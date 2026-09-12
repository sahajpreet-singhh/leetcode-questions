class Solution {
    int[][] a;
    int n;
    long[][] dp;
    List<Integer>[][] path;
    public int[] maximumWeight(List<List<Integer>> intervals) {
        n = intervals.size();
        a = new int[n][4];
        for (int i = 0; i < n; i++) {
            a[i][0] = intervals.get(i).get(0);
            a[i][1] = intervals.get(i).get(1);
            a[i][2] = intervals.get(i).get(2);
            a[i][3] = i;
        }

        Arrays.sort(a, (x, y) -> {
            if (x[0] != y[0])
                return Integer.compare(x[0], y[0]);
            return Integer.compare(x[3], y[3]);
        });
        dp = new long[n + 1][5];
        path = new ArrayList[n + 1][5];
        for (int i = 0; i <= n; i++)
            for (int k = 0; k <= 4; k++)
                path[i][k] = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {

            for (int k = 1; k <= 4; k++) {

                int next = getNext(i);

                long take = a[i][2] + dp[next][k - 1];
                long skip = dp[i + 1][k];
                if (take > skip) {

                    dp[i][k] = take;

                    path[i][k] = new ArrayList<>(path[next][k - 1]);
                    path[i][k].add(a[i][3]);

                } else if (skip > take) {

                    dp[i][k] = skip;
                    path[i][k] = new ArrayList<>(path[i + 1][k]);

                } else {
                    // Same score → choose lexicographically smaller answer
                    List<Integer> p1 = new ArrayList<>(path[next][k - 1]);
                    p1.add(a[i][3]);

                    List<Integer> p2 = path[i + 1][k];

                    Collections.sort(p1);

                    if (compare(p1, p2) < 0) {
                        dp[i][k] = take;
                        path[i][k] = p1;
                    } else {
                        dp[i][k] = skip;
                        path[i][k] = new ArrayList<>(p2);
                    }
                }
            }
        }
        Collections.sort(path[0][4]);
        return path[0][4]
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
    int getNext(int i) {

        int l = i + 1;
        int r = n;

        while (l < r) {
            int mid = (l + r) / 2;
            if (a[mid][0] > a[i][1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    int compare(List<Integer> x, List<Integer> y) {
        int size = Math.min(x.size(), y.size());
        for (int i = 0; i < size; i++) {
            if (!x.get(i).equals(y.get(i)))
                return Integer.compare(x.get(i), y.get(i));
        }
        return Integer.compare(x.size(), y.size());
    }
}