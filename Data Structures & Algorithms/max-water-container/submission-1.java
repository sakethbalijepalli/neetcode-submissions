class Solution {
    public int maxArea(int[] heights) {
//        L * B
        int i = 0;
        int j = heights.length - 1;
        int max = Integer.MIN_VALUE;
        while (i < j){
            int area = (j - i) * Math.min(heights[i],heights[j]);
            max = Math.max(area,max);
            if(heights[i] < heights[j]){

                i++;
            }else{
                j--;
            }
        }
        return max;
    }
}
