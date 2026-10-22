class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        long currsum = 0 , maxSum = 0;
        int left = 0;
        for(int right = 0 ; right < nums.length ; right++){
            while(set.contains(nums[right]) || set.size()>=k){
                set.remove(nums[left]);
                currsum -= nums[left];
                left++;
            }
            currsum += nums[right];
            set.add(nums[right]);
            if(set.size() == k){
                maxSum = Math.max(currsum , maxSum);
            }
        }
        return maxSum;
    }
}