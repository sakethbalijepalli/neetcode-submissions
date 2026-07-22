class Solution {
    public int removeDuplicates(int[] nums) {
        int L = 2;

        for(int R = 2;R < nums.length;R++){
            while (R < nums.length && nums[L - 2] == nums[R]){
                R++;
            }
            if(R < nums.length && nums[L - 2] != nums[R]){
                nums[L] = nums[R];
                L++;
            }
        }
        return L;
    }
}