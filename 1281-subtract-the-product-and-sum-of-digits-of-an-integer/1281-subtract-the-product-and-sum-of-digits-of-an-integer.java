class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int x = n;
        int prod = 1;
        while(x != 0){
            int num = x%10;
            sum += num;
            prod *= num;
            x = x/10;
        }
        int dif = prod - sum;
        return dif;
    }
}