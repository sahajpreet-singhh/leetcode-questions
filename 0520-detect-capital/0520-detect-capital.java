class Solution {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isUpperCase(c)) {
                count++;
            }
        }
        char x = word.charAt(0);
        if (word.length() == count ||
            count == 0 ||
            (count == 1 && Character.isUpperCase(x))) {
            return true;
        }
        return false;
    }
}