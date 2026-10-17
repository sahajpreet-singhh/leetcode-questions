class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] ress  = new int[intervals.length+1][2];
        for(int i = 0 ; i < intervals.length ; i++){
            ress[i] = intervals[i];
        }
        ress[intervals.length] = newInterval;
        Arrays.sort(ress , (a,b) -> Integer.compare(a[0],b[0]));
        int n = ress.length;
        int[][] res = new int[n][2];
        res[0] = ress[0];
        int e = 0;
        for(int i = 1 ; i < n ; i++){
            if(ress[i][0] <= res[e][1]){
                res[e][1] = Math.max(ress[i][1] , res[e][1]);
            }
            else{
                e++;
                res[e] = ress[i];
            }
        }
        return Arrays.copyOfRange(res,0,e+1);
    }
}