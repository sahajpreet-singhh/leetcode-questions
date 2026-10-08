class Solution {
    public boolean isHappy(int n) {
        int slow = square(n);
        int fast = square(square(n));
        while(slow != fast){
            if(slow==1 || fast ==1) return true;
            slow = square(slow);
            fast = square(square(fast));
        }
        return slow==1;
    }
    public int square(int n){
        int sum=0;
        int x = n;
        while(x != 0){
            int a = x%10;
            sum = sum + a*a;
            x = x/10;
        }
        return sum;
    }
}