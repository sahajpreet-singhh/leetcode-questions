class Solution {
    class Pair implements Comparable<Pair> {
        int node;
        double prob;
        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
        public int compareTo(Pair p) {
            if (this.prob == p.prob)
                return this.node - p.node;
            return Double.compare(this.prob, p.prob);
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];

            adj.get(u).add(new Pair(v, p));
            adj.get(v).add(new Pair(u, p));
        }
        double[] ans = new double[n];
        ans[start] = 1.0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(new Pair(start, 1.0));
        while (!pq.isEmpty()) {
            Pair front = pq.poll();
            int node = front.node;
            double prob = front.prob;
            if (prob < ans[node])
                continue;
            for (Pair nbr : adj.get(node)) {
                double newProb = prob * nbr.prob;
                if (newProb > ans[nbr.node]) {
                    ans[nbr.node] = newProb;
                    pq.add(new Pair(nbr.node, newProb));
                }
            }
        }
        return ans[end];
    }
}