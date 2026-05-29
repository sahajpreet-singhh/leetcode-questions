class Solution {
    public boolean isValid(String s) {
        Stack <Character> st = new Stack<>();
        int n = s.length();
        for(int i = 0 ; i < n; i++){
            char x = s.charAt(i);
            if (x == '(' || x == '{' || x == '['){
                st.push(x);
            }
            else{
                if (st.size() == 0) return false;
                char top = st.peek();
                if ((x == ')' && top != '(') ||
                    (x == '}' && top != '{') ||
                    (x == ']' && top != '['))
                    return false;
                else
                    st.pop();
            }
        }
        if (st.size() != 0) return false;
        else return true;
        
    }
}