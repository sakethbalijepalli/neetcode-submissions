class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare((b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1]))
        );

        // Loop over each point in the points array
        for (int[] point : points) {
            maxHeap.offer(point);

            // If our heap gets larger than k, we remove the element with the largest distance
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Build the final result array from the remaining k elements in the heap
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }
}
