class MedianFinder {
     PriorityQueue<Integer> small;   // maxHeap
    PriorityQueue<Integer> large; // minHeap

    public MedianFinder() {
        small = new PriorityQueue<>(Comparator.reverseOrder());
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        small.offer(num);
        if(!small.isEmpty() && !large.isEmpty() && small.peek() > large.peek()){
            large.offer(small.poll());
        }

        if(small.size() > large.size() + 1){
            large.offer(small.poll());
        }else if (large.size() > small.size() + 1){
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if(small.size() > large.size()){
            return (double) small.peek();
        } else if (small.size() < large.size()) {
            return (double) large.peek();
        }
        return (double) (small.peek() + large.peek()) / 2;
    }
}
