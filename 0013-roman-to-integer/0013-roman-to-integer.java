class Solution {
    public int romanToInt(String s) {
        int result = 0;
        int len = s.length();
        for(int i = 0 ; i < len ; i++ ){
            
            if (i < len-1 && translate(s.charAt(i)) < translate(s.charAt(i+1))){
                result = result - translate(s.charAt(i));
            }
            else{
                result = result + translate(s.charAt(i));
            }
        }
        return result;
    }

    public int translate(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}