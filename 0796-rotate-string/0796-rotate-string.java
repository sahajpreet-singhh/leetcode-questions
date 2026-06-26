class Solution {
    public boolean rotateString(String s, String goal) {
        String ans = s + s;
        if(ans.contains(goal))return true;
        else{
            return false;
        }
    }
}