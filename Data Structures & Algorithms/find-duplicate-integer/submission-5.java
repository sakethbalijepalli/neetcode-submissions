class Solution {
    public int findDuplicate(int[] nums) {

        for(int i = 0;i < nums.length;i++){
            nums[Math.abs(nums[i]) - 1] *= -1;
            if(nums[Math.abs(nums[i]) - 1] > 0){
                return Math.abs(nums[i]);
            }
        }
        return 0;
    }
}
