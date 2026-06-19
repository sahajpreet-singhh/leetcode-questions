class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int curr = 0;
        for(int i = 0 ; i < nums.length ; i++){
            curr = curr + nums[i];
            max = Math.max(curr,max);
            if(curr < 0) curr = 0;
        }
        return max;
    }
}