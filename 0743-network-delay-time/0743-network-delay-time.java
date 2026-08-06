class Solution {
    class Pair implements Comparable<Pair> {
        int node;
        int time;
        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
        public int compareTo(Pair p) {
            if (this.time == p.time)
                return this.node - p.node;
            return this.time - p.time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int src) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for (int[] t : times) {
            adj.get(t[0]).add(new Pair(t[1], t[2]));
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair front = pq.remove();
            int node = front.node;
            int time = front.time;

            if (time > dist[node]) continue;
            for (Pair nbr : adj.get(node)) {
                int newTime = time + nbr.time;
                if (newTime < dist[nbr.node]) {
                    dist[nbr.node] = newTime;
                    pq.add(new Pair(nbr.node, newTime));
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}