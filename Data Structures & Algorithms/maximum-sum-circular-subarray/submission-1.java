class Solution {
    public int maxSubarraySumCircular(int[] nums) {
       int globalMax = nums[0], globalMin = nums[0];
        int currMax = 0, currMin = 0, total = 0;

        for (int num : nums) {
            total += num;
            currMax = Math.max(num, currMax + num);
            currMin = Math.min(num, currMin + num);
            globalMax = Math.max(globalMax, currMax);
            globalMin = Math.min(globalMin, currMin);

        }
        return globalMax > 0 ? Math.max(globalMax, total - globalMin) : globalMax;
    }
}