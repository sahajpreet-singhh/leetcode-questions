class Solution {
    public int c(int n  , int[] dp){
        if(n<=3) return n;
        if(dp[n] != -1) return dp[n];
        return dp[n] = c(n-1,dp) + c(n-2,dp);

    }
    public int climbStairs(int n) {
        int[] dp = new int[n*n];
        Arrays.fill(dp,-1);
        return c(n , dp);
        
    }
}