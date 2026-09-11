class Solution {
    public int totalNumbers(int[] digits) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < digits.length; i++) {

            // Hint: hundreds digit cannot be 0
            if(digits[i] == 0) continue;

            for (int j = 0; j < digits.length; j++) {
                if(i == j) continue;
                // Hint: don't reuse i

                for (int k = 0; k < digits.length; k++) {
                    if( k == i || k ==j) continue;
                    // Hint: don't reuse i or j
                    // Hint: last digit must be even
                    if(digits[k] % 2==0){
                        int num = digits[i] * 100+ digits[j] *10 + digits[k];
                        set.add(num);
                    }
                    // construct number
                    
                    // add to set
                }
            }
        }
        return set.size();
    }
}