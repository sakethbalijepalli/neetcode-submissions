class Solution {
    public int missingNumber(int[] nums) {
        //001
        //010
        //011
        //100
        //101
        int res = nums.length;
        for(int i = 0;i < nums.length;i++){
            res = res ^ nums[i] ^ i;
        }
        return res;
    }
}
