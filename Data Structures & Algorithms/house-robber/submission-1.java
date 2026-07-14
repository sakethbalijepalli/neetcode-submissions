class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int robPrevious2 = 0; 
        int robPrevious1 = 0; 
        for (int currentHouseMoney : nums) {
            int currentMax = Math.max(currentHouseMoney + robPrevious2, robPrevious1);
            robPrevious2 = robPrevious1;
            robPrevious1 = currentMax;
        }
        return robPrevious1;
    }
}
