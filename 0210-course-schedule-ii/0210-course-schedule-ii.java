class Solution {
    public int[] findOrder(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++)adj.add(new ArrayList<>());
        int[] indegree = new int[n];
        for(int i = 0 ; i < pre.length ; i++){
            int a = pre[i][0] , b = pre[i][1];
            adj.get(b).add(a);
            indegree[a]++;
        }
        //kahn's algo 
        Queue<Integer> q = new LinkedList<>();
        List<Integer> arr = new ArrayList<>();
        for(int i = 0 ; i < indegree.length ; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while(q.size() != 0){
            int front = q.remove();
            arr.add(front);
            for(int ele : adj.get(front)){
                indegree[ele]--;
                if(indegree[ele] == 0){
                    q.add(ele);
                }
            }
        }
        if(arr.size() != n)return new int[0];
        else{
            int[] x = new int[n];
            int idx = 0;
            for(int ele: arr){
                x[idx] = ele;
                idx++;
            }
            return x;
        }
    }
}