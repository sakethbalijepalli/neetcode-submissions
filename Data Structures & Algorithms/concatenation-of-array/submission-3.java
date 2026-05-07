class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] resultArr = new int[2 * nums.length];
        int n = nums.length;

        for(int i = 0;i < nums.length;i++){
            resultArr[i] = resultArr[i + n] = nums[i];
        }
       return resultArr;
    }
}