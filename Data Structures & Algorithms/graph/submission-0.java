class Graph {
    HashMap<Integer,HashSet<Integer>> adjList;
    public Graph() {
        adjList = new HashMap<>();
    }

    public void addEdge(int src, int dst) {
        adjList.putIfAbsent(src,new HashSet<>());
        adjList.putIfAbsent(dst,new HashSet<>());
        adjList.get(src).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        if(!adjList.containsKey(src) || !adjList.get(src).contains(dst)){
            return false;
        }
        adjList.get(src).remove(dst);
        return true;
    }

    public boolean hasPath(int src, int dst) {
        HashSet<Integer> visited = new HashSet<>();

        return dfs(src,dst,visited);
    }

    private boolean dfs(int src,int dst,HashSet<Integer> visited){
        if(src == dst) return true;

        visited.add(src);
        for(int neighbour : adjList.getOrDefault(src,new HashSet<>())){
            if(!visited.contains(neighbour)){
                if(dfs(neighbour,dst,visited)){
                    return true;
                }
            }
        }
        return false;
    }
}
