class Solution {
    public int maxProductDifference(int[] nums) {
        for(int i = 0  ; i < nums.length ; i++){
            for(int  j = 0 ; j < nums.length - i - 1 ; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        int ans = (nums[nums.length-1]*nums[nums.length-2])-(nums[0]*nums[1]);
        return ans;
    }
}