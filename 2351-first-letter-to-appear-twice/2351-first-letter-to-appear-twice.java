class Solution {
    public char repeatedCharacter(String s) {
        HashMap<Character,Integer> mp = new HashMap<>();
        mp.put(s.charAt(0),1);
        for(int i = 1; i < s.length();i++){
            if(mp.containsKey(s.charAt(i))){
                return s.charAt(i);
            }
            else{
                mp.put(s.charAt(i),mp.get(s.charAt(i)+1));
            }
        }
        return s.charAt(0);
        
    }
}