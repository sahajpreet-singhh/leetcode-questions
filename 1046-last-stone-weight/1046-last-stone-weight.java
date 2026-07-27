class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele : stones) pq.add(ele);
        while(pq.size()>=2){
            int y = pq.remove();
            int x = pq.remove();
            pq.add(y-x);
        }
        return pq.peek();

    }
}