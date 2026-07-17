class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for(String s: sentences){
            int words = 1;
            int len = s.length();
            for(int i = 0 ; i < len-1 ; i ++){
                if(s.toCharArray()[i] == ' '){
                    words++;
                }
            }
            max = Math.max(max,words);
        }
        return max;
    }
}