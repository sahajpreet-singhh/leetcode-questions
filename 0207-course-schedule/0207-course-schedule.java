class Solution {
    static boolean ans;
    public void dfs(int i , List<List<Integer>> adj ,boolean[] vis , boolean[] path){
        vis[i]=true;
        path[i]=true;
        for(int ele : adj.get(i)){
            if(path[ele] == true){
                ans = false;
                return;
            }
            if(vis[ele] == false) dfs(ele,adj,vis,path);
        }
        path[i] = false;

    }
    public boolean canFinish(int n, int[][] pre) {
        ans = true;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++)adj.add(new ArrayList<>());
        // int[] indegree = new int[n];
        for(int i = 0 ; i < pre.length ; i++){
            int a = pre[i][0] , b = pre[i][1];
            adj.get(b).add(a);
            // indegree[a]++;
        }
        boolean[] vis = new boolean[n];
        boolean[] path = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            if(vis[i] == false) dfs(i,adj,vis,path);
        }
        return ans;
        //kahn's algo 
        // Queue<Integer> q = new LinkedList<>();
        // List<Integer> arr = new ArrayList<>();
        // for(int i = 0 ; i < indegree.length ; i++){
        //     if(indegree[i] == 0){
        //         q.add(i);
        //     }
        // }
        // while(q.size() != 0){
        //     int front = q.remove();
        //     arr.add(front);
        //     for(int ele : adj.get(front)){
        //         indegree[ele]--;
        //         if(indegree[ele] == 0){
        //             q.add(ele);
        //         }
        //     }
        // }
        // if(arr.size() == n)return true;
        // else return false;



        //dfs
    }
}