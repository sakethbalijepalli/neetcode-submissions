class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        Map<String, Integer> emailToAccount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);

            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if(emailToAccount.containsKey(email)){
                    uf.union(i,emailToAccount.get(email));
                }
                emailToAccount.put(email,i);
            }
        }
        Map<Integer, TreeSet<String>> rootToEmails = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            int root = uf.find(i);
            for(int j = 1;j < account.size();j++){
                rootToEmails.computeIfAbsent(root, k -> new TreeSet<>()).add(account.get(j));
            }
        }

        List<List<String>> mergedAccounts = new ArrayList<>();

        for(Map.Entry<Integer,TreeSet<String>> mp : rootToEmails.entrySet()){
            List<String> mergedIds = new ArrayList<>();
            mergedIds.add(accounts.get(mp.getKey()).getFirst());
            mergedIds.addAll(mp.getValue());
            mergedAccounts.add(mergedIds);
        }
        return mergedAccounts;
    }
}
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