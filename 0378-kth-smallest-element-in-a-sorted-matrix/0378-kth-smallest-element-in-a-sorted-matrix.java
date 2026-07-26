class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int r = matrix.length;
        int c = matrix[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0 ; i < r ; i++){
            for(int j = 0 ; j < c ; j++){
                pq.add(matrix[i][j]);
                if(pq.size() > k){
                    pq.remove();
                }
            }
        }
        return pq.peek();
    }
}