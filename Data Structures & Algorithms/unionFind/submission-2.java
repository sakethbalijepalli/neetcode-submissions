
class UnionFind {
    private final int[] parent;
    private final int[] rank;
    private int numOfComponents;

    public UnionFind(int n) {
        this.numOfComponents = n;
        this.parent = new int[n];
        this.rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }
    public int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public boolean isSameComponent(int x, int y) {
        return find(x) == find(y);
    }

    public boolean union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);

        if (root1 == root2) {
            return false;
        }

        if (rank[root1] > rank[root2]) {
            parent[root2] = root1;
        } else if (rank[root1] < rank[root2]) {
            parent[root1] = root2;
        } else {
            parent[root2] = root1;
            rank[root1]++;
        }

        numOfComponents--;
        return true;
    }

    public int getNumComponents() {
        return numOfComponents;
    }
}