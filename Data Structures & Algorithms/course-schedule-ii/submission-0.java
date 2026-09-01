class Solution {
     private int topIndex;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            adj.get(prereq).add(course);
        }

        int[] state = new int[numCourses];
        int[] result = new int[numCourses];
        topIndex = numCourses - 1;

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, state, adj, result)) {
                return new int[0];
            }
        }

        return result;
    }

    private boolean hasCycle(int course, int[] state, List<List<Integer>> adj, int[] result) {
        if (state[course] == 1) return true;
        if (state[course] == 2) return false;

        state[course] = 1;

        for (int nextCourse : adj.get(course)) {
            if (hasCycle(nextCourse, state, adj, result)) {
                return true;
            }
        }

        state[course] = 2;
        result[topIndex--] = course;
        return false;
    }
}
