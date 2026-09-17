class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < operations.length; i++) {
            String x = operations[i];

            if(x.equals("+")) {
                int y = st.pop();
                int z = st.peek();
                st.push(y);
                st.push(y + z);
            }
            else if(x.equals("C")) {
                st.pop();
            }
            else if(x.equals("D")) {
                st.push(2 * st.peek());
            }
            else {
                st.push(Integer.parseInt(x));
            }
        }
        int res = 0;
        while(!st.isEmpty()) {
            res += st.pop();
        }
        return res;
    }
}