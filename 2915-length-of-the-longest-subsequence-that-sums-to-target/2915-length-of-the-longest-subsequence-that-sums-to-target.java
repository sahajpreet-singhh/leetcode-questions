class Solution {
    public int longestsub(int i ,List<Integer> nums, int target, int[][] dp){
        if(target == 0) return 0;
        if( i == nums.size()){
            return Integer.MIN_VALUE;
        }
        if(dp[i][target] != -1) return dp[i][target];
        int skip = longestsub(i+1,nums,target,dp);
        if(target - nums.get(i) < 0) return dp[i][target] = skip;
        int take = longestsub(i+1,nums,target-nums.get(i),dp);
        if(take != Integer.MIN_VALUE) take = take+1;
        return dp[i][target] = Math.max(skip,take);
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target){
        int[][] dp = new int[nums.size()][target+1];
        for(int i = 0 ; i < dp.length ; i++){
            for(int j = 0 ; j < dp[0].length ;j++) dp[i][j] = -1;
        }
        int ans = longestsub(0,nums,target,dp);
        if(ans == Integer.MIN_VALUE) return -1;
        return ans;
    }
}