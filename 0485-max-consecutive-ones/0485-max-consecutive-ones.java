class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int mxcount = 0 ;
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if (nums[i] == 1){
                count++;
            }
            else{
                mxcount = Math.max(mxcount , count);
                count = 0;
            }
        }
        mxcount = Math.max(mxcount , count);
        return mxcount;
    }
}