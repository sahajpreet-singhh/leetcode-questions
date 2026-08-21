class Solution {
    public int uniquePaths(int m, int n){
        int [][] dp = new int[m][n];
        for(int i = 0 ; i < m ;i++){
            for(int j = 0 ; j < n ; j++){
                dp[i][j] = -1;
            }
        }
        return paths(0,0,m-1,n-1,dp);
    }
    public int paths(int row , int col , int er , int ec, int[][] dp){
        if(row>er || col > ec) return 0;
        if(row==er && col==ec)return 1;
        if(dp[row][col] != -1) return dp[row][col];
        return dp[row][col] =  paths(row+1,col,er,ec,dp) + paths(row,col+1,er,ec,dp);
    }
}