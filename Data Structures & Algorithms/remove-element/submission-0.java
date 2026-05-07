class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int j = 0;
        int i = 0;
        int n =nums.length - 1;

        while(i <= n){
            if(nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }else{
                count++;
            }
            i++;
        }
        return nums.length - count;
    }
}