class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Pair> stack = new Stack<>();

        for(int i = 0;i < heights.length;i++){
            int start = i;
            while (!stack.isEmpty() && stack.peek().height > heights[i]){
                Pair prevPair = stack.pop();
                maxArea = Math.max(maxArea, prevPair.height * (i - prevPair.index));
                start = prevPair.index;
            }
            stack.push(new Pair(start,heights[i]));
        }

        for(int i = 0;i < stack.size();i++){
            maxArea = Math.max(maxArea,stack.get(i).height * (heights.length - stack.get(i).index));
        }
        return maxArea;
    }
    class Pair{
        int index;
        int height;

        public Pair(int index, int height){
            this.index = index;
            this.height = height;
        }
    }
}
