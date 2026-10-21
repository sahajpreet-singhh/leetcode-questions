
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int curr = 0;
        int mini = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            curr += nums[right];
            while (curr >= target) {
                mini = Math.min(mini, right - left + 1);
                curr -= nums[left];
                left++;
            }
        }
        if (mini == Integer.MAX_VALUE) return 0;
        return mini;
    }
}
