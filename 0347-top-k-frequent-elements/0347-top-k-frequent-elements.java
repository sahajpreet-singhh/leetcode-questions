class Pair implements Comparable<Pair>{
    int ele;
    int freq;
    Pair(int ele  ,int freq){
        this.ele = ele;
        this.freq = freq;
    }
    public int compareTo(Pair p){
        if(this.freq == p.freq)return this.ele - p.ele;
        return this.freq-p.freq;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int i = 0;
        while(i != nums.length){
            mp.put(nums[i], mp.getOrDefault(nums[i],0)+1);
            i++;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int ele : mp.keySet()){
            pq.add(new Pair(ele,mp.get(ele)));
            if(pq.size()>k)pq.remove();
        }
        int[] arr = new int[k];
        int idx = 0;
        while(pq.size() != 0){
            Pair x = pq.remove();
            int y = x.ele;
            arr[idx] = y;
            idx++;
        }
        return arr;
        
    }
}