class Solution {
    public int[] productExceptSelf(int[] nums) {
        int results[] = new int[nums.length];
        int pre = 1;
        int post = 1;
        for(int i =  0 ; i < results.length ; i++){
            results[i] =1;
        }
        for(int i =  0 ; i < results.length ; i++){
            results[i] = results[i] * pre;
            pre = nums[i] *pre;
        }
        for(int i = results.length-1 ; i >= 0 ; i--){
            results[i] = results[i] * post;
            post = post * nums[i];
        }
        return results;
        
    }
}