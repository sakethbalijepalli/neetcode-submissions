class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE, sum = 0, L = 0;

        for(int R = 0;R < nums.length;R++){
            sum += nums[R];
            if(sum >= target){
                while (sum >= target){
                    minLen = Math.min(minLen,R - L + 1);
                    sum -= nums[L];
                    L++;
                }
            }
        }
        if (minLen ==  Integer.MAX_VALUE) {
            return 0;
        }
        return minLen;
    }
}