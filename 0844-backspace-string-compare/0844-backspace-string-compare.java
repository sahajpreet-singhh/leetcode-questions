class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            if (s.charAt(i) != '#') {
                st1.push(s.charAt(i));
            } else if (!st1.isEmpty()) {
                st1.pop();
            }
            i++;
        }
        while (j < t.length()) {
            if (t.charAt(j) != '#') {
                st2.push(t.charAt(j));
            } else if (!st2.isEmpty()) {
                st2.pop();
            }
            j++;
        }
        return st1.equals(st2);
    }
}