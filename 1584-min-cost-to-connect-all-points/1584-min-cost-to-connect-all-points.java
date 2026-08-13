class Solution {
    public class Triplet implements Comparable<Triplet> {
        int node;
        int parent;
        int distance;

        Triplet(int node, int parent, int distance) {
            this.node = node;
            this.parent = parent;
            this.distance = distance;
        }

        public int compareTo(Triplet t) {
            if (this.distance == t.distance)
                return this.node - t.node;

            return this.distance - t.distance;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.add(new Triplet(0, -1, 0));

        boolean[] vis = new boolean[n];
        int sum = 0;

        while (pq.size() != 0) {

            Triplet front = pq.remove();

            int node = front.node;
            int parent = front.parent;
            int distance = front.distance;

            // Already included in MST
            if (vis[node] == true)
                continue;

            // Include this node in MST
            vis[node] = true;
            sum += distance;

            // Add all unvisited neighbours
            for (int i = 0; i < n; i++) {

                if (vis[i] == true)
                    continue;

                if (i == node || i == parent)
                    continue;

                int x1 = points[node][0];
                int y1 = points[node][1];

                int x2 = points[i][0];
                int y2 = points[i][1];

                int mDis = Math.abs(x1 - x2) + Math.abs(y1 - y2);

                pq.add(new Triplet(i, node, mDis));
            }
        }
        return sum;
    }
}