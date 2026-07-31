class Solution {
     public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] pair : prerequisites) {
            int course = pair[0];//0
            int prereq = pair[1];//1
            adj.get(prereq).add(course);
        }

        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, state, adj)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int course, int[] state, List<List<Integer>> adj){
        if(state[course] == 1){
            return true;
        }
        if(state[course] == 2){
            return false;
        }
        state[course] = 1;

        for (int nextCourse : adj.get(course)) {
            if (hasCycle(nextCourse, state, adj)) {
                return true;
            }
        }
        state[course] = 2;
        return false;
    }
}
