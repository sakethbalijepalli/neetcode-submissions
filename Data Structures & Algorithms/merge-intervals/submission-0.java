class Solution {
    public int[][] merge(int[][] intervals) {
         //1 3  // 1 2 -> 1,3
        //1 5  // 2 3
        //6 7
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> output = new ArrayList<>();
        output.add(intervals[0]);

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            int lastEnd = output.get(output.size() - 1)[1];

            if (start <= lastEnd) {
                output.get(output.size() - 1)[1] = Math.max(lastEnd, end);
            } else {
                output.add(new int[]{start, end});
            }
        }
        return output.toArray(new int[output.size()][]);
    }
}
