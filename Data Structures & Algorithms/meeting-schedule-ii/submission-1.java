/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
         if(intervals == null || intervals.isEmpty()){
            return 0;
        }

        Collections.sort(intervals,Comparator.comparingInt(i -> i.start));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(intervals.getFirst().end);

        for(int i = 1;i < intervals.size();i++){
            if(intervals.get(i).start >= minHeap.peek()){
                minHeap.poll();
            }
            minHeap.add(intervals.get(i).end);
        }
        return minHeap.size();
    }
}