class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if (n <= 1) return 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        boolean[] visited = new boolean[n];
        int totalCost = 0;
        int edgesConnected = 0;
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty() && edgesConnected < n) {
            int[] current = pq.poll();
            int currNode = current[0];
            int currCost = current[1];
            
            if (visited[currNode]) {
                continue;
            }
            
            visited[currNode] = true;
            totalCost += currCost;
            edgesConnected++;
            
            for (int nextNode = 0; nextNode < n; nextNode++) {
                if (!visited[nextNode]) {
                    int distance = Math.abs(points[currNode][0] - points[nextNode][0]) +
                            Math.abs(points[currNode][1] - points[nextNode][1]);

                    pq.offer(new int[]{nextNode, distance});
                }
            }
        }

        return totalCost;
    }
}
