class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<double[]>> adj = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new double[]{v, p});
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new double[]{u, p});
        }
        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;

        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        maxHeap.offer(new double[]{start_node, 1.0});

        while (!maxHeap.isEmpty()) {
            double[] cur = maxHeap.poll();
            int node = (int) cur[0];
            double prob = cur[1];

            if (node == end_node) {
                return prob;
            }

            if (prob < maxProb[node]) {
                continue;
            }

            for (double[] neighbor : adj.getOrDefault(node, new ArrayList<>())) {
                int nextNode = (int) neighbor[0];
                double edgeProb = neighbor[1];

                if (prob * edgeProb > maxProb[nextNode]) {
                    maxProb[nextNode] = prob * edgeProb;
                    maxHeap.offer(new double[]{nextNode, maxProb[nextNode]});
                }
            }
        }

        return 0.0;
    }
}