class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            if(!vis[i]){
                bfs(i,vis,isConnected);
                count++;
            }
        }
        return count;
    }
    public void bfs(int i , boolean[] vis ,int[][] isConnected){
        Queue<Integer> q = new LinkedList<>();
        int n = isConnected.length;
        vis[i] = true;
        q.add(i);
        while(q.size()>0){
            int front = q.remove();
            for(int j = 0 ; j < n ; j++){
                if(isConnected[front][j] == 1 && vis[j] == false){
                    q.add(j);
                    vis[j] = true;
                }
            }
        }
    }
}