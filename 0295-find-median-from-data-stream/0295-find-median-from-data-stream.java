class MedianFinder {
    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    public MedianFinder() {
    }
    public void addNum(int num) {
        if(max.size() == 0)max.add(num);
        else{
            if(num < max.peek())max.add(num);
            else min.add(num);
        }
        
        if(min.size() == max.size()+2){
            max.add(min.remove());
        }
        if(max.size() == min.size()+2){
            min.add(max.remove());
        }
    }
    
    public double findMedian() {
        if(max.size() == min.size()+1) return max.peek();
        else if(min.size() == max.size()+1)return min.peek();
        else{
            return (max.peek()+min.peek())/2.0;
        }
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */