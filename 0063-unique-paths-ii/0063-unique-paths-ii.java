class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return paths(0, 0, m - 1, n - 1, dp, arr);
    }

    public int paths(int row, int col, int er, int ec, int[][] dp, int[][] arr) {
        if (row > er || col > ec) return 0;
        if (arr[row][col] == 1) return 0;
        if (row == er && col == ec) return 1;
        if (dp[row][col] != -1) return dp[row][col];
        int downways = paths(row + 1, col, er, ec, dp, arr);
        int rightways = paths(row, col + 1, er, ec, dp, arr);
        return dp[row][col] = downways + rightways;
    }
}