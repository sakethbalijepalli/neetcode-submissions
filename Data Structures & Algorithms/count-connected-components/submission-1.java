class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int[] i : edges){
            int edgeU = uf.find(i[0]);
            int edgeV = uf.find(i[1]);

            uf.union(edgeU,edgeV);
        }
        return uf.noOfComponents;
    }
}

class UnionFind{
    int[] parent;
    int[] rank;
    int noOfComponents;

    public UnionFind(int n){
        parent = new int[n];
        rank = new int[n];
        noOfComponents = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x){
        if(x != parent[x]){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public boolean union(int x,int y){
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
        noOfComponents--;
        return true;
    }

    public int getNoOfComponents(){
        return noOfComponents;
    }
}
