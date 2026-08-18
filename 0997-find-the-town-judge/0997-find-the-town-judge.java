class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indeg = new int[n + 1];
        int[] outdeg = new int[n + 1];
        for(int[] ele : trust) {
            int from = ele[0];
            int to = ele[1];
            indeg[to]++;
            outdeg[from]++;
        }
        for(int i = 1; i <= n; i++) {
            if(indeg[i] == n - 1 && outdeg[i] == 0) return i;
        }
        return -1;
    }
}