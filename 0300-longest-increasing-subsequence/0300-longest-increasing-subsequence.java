class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j <= i-1 ; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]);
                }
            }
            dp[i] += 1;
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0 ; i < dp.length ; i++){
            if(ans < dp[i]) ans = dp[i];
        }
        return ans;
    }
}