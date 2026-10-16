class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int min = 0;
        int max = 0;
        for(int weight : weights){
            min = Math.max(min,weight);
            max = max + weight;
        }
        while(min < max){
            int mid = (min + max)/2;
            int days = 1;
            int sum = 0;
            for(int weight : weights){
                if(sum + weight > mid){
                    days++;
                    sum = 0;
                }
                sum +=weight;
            }
            if(days > D) min = mid+1;
            else max = mid;
        }
        return  min;
    }
}