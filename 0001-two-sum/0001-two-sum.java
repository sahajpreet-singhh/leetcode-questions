class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        int len = nums.length;
        for(int i = 0 ; i < len ; i++){
            int x = nums[i];
            for(int j = i+1; j< len; j++){
                if (x + nums[j] == target){
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        } return arr;
        
    }
}