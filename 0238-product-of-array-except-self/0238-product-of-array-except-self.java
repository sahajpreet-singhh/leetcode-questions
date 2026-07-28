class Solution {
    public int[] productExceptSelf(int[] nums) {
       int  n = nums.length; 
       int[] arr = new int[n];
       int pre = 1, post = 1;
       for(int i = 0 ; i < n ; i++){
        arr[i] = 1;
       }
       for(int i = 0 ; i< n ; i++){
        arr[i] = arr[i]*pre;
        pre = pre*nums[i];
       }
       for(int i = n-1 ; i>= 0 ; i--){
        arr[i] = arr[i]*post;
        post = post*nums[i];
       }
       return arr;
    }
}