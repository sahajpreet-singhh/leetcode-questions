class Pair implements Comparable<Pair>{
    int row;
    int count;

    Pair(int row, int count){
        this.row = row;
        this.count = count;
    }

    public int compareTo(Pair p){
        if(this.count == p.count)
            return this.row - p.row;
        return this.count - p.count;
    }
}

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] arr = new int[k];
        for(int i = 0; i < mat.length; i++){
            int soldiers = 0;
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 1)
                    soldiers++;
            }
            pq.add(new Pair(i, soldiers));
        }

        for(int i = 0; i < k; i++){
            arr[i] = pq.remove().row;
        }
        return arr;
    }
}