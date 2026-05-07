class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int i = 1;
        int j = 0;
        int n = nums.length;

        while (i < n){
            if(nums[i] == nums[j]){
                i++;
            }else{
                j++; k++;
                nums[j] = nums[i];
            }
        }
        return k;
    }
}