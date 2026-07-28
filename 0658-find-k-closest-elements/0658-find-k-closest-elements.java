class Pair implements Comparable<Pair>{
    int ele;
    int diff;
    Pair(int ele , int diff){
        this.ele = ele;
        this.diff = diff;
    }
    public int compareTo(Pair p){
        if(p.diff == this.diff)return this.ele - p.ele;
        return this.diff - p.diff;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele : arr){
            pq.add(new Pair (ele,Math.abs(ele-x)));
            if(pq.size()>k)pq.remove();
        }
        ArrayList<Integer> ar = new ArrayList<>();
        while(pq.size()!= 0){
            Pair q = pq.remove();
            int y  = q.ele;
            ar.add(y);
        }
        Collections.sort(ar);
        return ar;

        
    }
}