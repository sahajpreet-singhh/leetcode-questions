
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int curr = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            curr += nums[i];
            curr %= k;
            
            if (mp.containsKey(curr)) {
                if (i - mp.get(curr) >= 2) return true;
            } 
            else mp.put(curr, i);
        }
        return false;
    }
}
