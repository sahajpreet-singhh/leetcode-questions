int mySqrt(int x) {
    long sol = 0;
    if(x == 0 || x == 1){
        return x;
    }
    else{
        for(long i = 1; i <=x ; i++){
            if((i*i) == x){
                return i;
            }
            else if((i*i) < x){
                sol = i;
            }
            else{
                break;
            }

        }
    }
    return sol;
}