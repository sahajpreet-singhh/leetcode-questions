int reverse(int x){
    int n = x;
    long long s = 0;

    while(n != 0){
        int y = n % 10;
        s = s * 10 + y;
        if(s>2147483647 || s< -2147483648) return 0;
        n = n / 10;
    }
    return s;
}