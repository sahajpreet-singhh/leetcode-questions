class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int z = 0;
        int n  = nums.length;
        Stack <Integer> st = new Stack<>();
        int[] nge = new int[n];
        int[] ans = new int[n-k+1];
        st.push(n-1);
        nge[n-1] = n;
        for ( int i = n-2;  i >=0 ; i--){
            while ( st.size() != 0 && nums[st.peek()] < nums[i]){
                st.pop();
            }
            if (st.size() == 0) nge[i] = n;
            else nge[i] = st.peek();
            st.push(i);
        }
        int j = 0;
        for(int i = 0 ; i < n-k+1 ; i++){
            if(j >= k+i) j = i;
            int max = nums[j];
            while(j < i+k){
                max = nums[j];
                j = nge[j];
            }
            ans[z++] = max;
        }return ans;
    }
}