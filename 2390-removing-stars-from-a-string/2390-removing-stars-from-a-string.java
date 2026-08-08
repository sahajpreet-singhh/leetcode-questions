class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch == '*'){
                if(st.size()>0) st.pop();
            }
            else{
                st.push(ch);
            }
        }
        for(char ch : st){
            ans.append(ch);
        }
        return ans.toString();
    }
}