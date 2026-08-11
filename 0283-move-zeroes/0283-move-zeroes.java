class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length < 2) return;
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] == 0 && nums[j] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            } 
            else if (nums[i] != 0) {
                i++;
            }
            j++;
        }
    }
}