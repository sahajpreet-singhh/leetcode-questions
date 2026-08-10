class Solution {

    class Pair implements Comparable<Pair> {
        int node;
        int cost;
        int stops;

        Pair(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }

        public int compareTo(Pair p) {
            return this.cost - p.cost;
        }
    }

    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        // Adjacency list
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            adj.get(from).add(new Pair(to, price, 0));
        }
        int[][] dist = new int[n][k + 2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0, 0));
        dist[src][0] = 0;

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int node = curr.node;
            int cost = curr.cost;
            int stops = curr.stops;
            if (node == dst) {
                return cost;
            }
            if (stops == k + 1) {
                continue;
            }
            for (Pair next : adj.get(node)) {

                int newNode = next.node;
                int newCost = cost + next.cost;
                int newStops = stops + 1;

                if (newCost < dist[newNode][newStops]) {

                    dist[newNode][newStops] = newCost;

                    pq.add(
                        new Pair(newNode, newCost, newStops)
                    );
                }
            }
        }

        return -1;
    }
}