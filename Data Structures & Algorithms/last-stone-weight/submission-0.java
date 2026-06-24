class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b , a));
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int head = maxHeap.poll();

            if (Objects.equals(head, maxHeap.peek())) {
                maxHeap.poll();
            } else if (head < maxHeap.peek()) {
                int diff = maxHeap.poll() - head;
                maxHeap.offer(diff);
            } else {
                int diff = head - maxHeap.poll();
                maxHeap.offer(diff);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
