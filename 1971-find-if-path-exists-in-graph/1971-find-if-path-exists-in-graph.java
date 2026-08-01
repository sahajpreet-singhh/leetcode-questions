class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(start == end)return true;
        List<List<Integer>> l = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            List<Integer> list = new ArrayList<>();
            l.add(list);
        }
        for(int i = 0 ; i < edges.length ; i++){
            int a = edges[i][0] , b = edges[i][1];
            l.get(a).add(b);
            l.get(b).add(a);
        }
        boolean[] visited = new boolean[n];
        visited[start] = true;
        bfs(start,l,visited);
        return visited[end];
    }
    public void bfs(int start, List<List<Integer>> l , boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(q.size()  > 0){
            int front = q.remove();
            for(int ele : l.get(front)){
                if(!visited[ele]){
                    visited[ele] = true;
                    q.add(ele);
                }
            }
        }
    }
}