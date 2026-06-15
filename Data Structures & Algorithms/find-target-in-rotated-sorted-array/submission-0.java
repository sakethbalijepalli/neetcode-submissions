class Solution {
    public int search(int[] nums, int target) {
        int L = 0, R = nums.length - 1;
        while(L <= R) {
            int mid = L + (R - L) / 2;

//            3 4 5 6 1 2 -> i am searching for 1 we check with L pointer first, we check with mid and we check with R
//            if less than L and less than mid then we move L to mid + 1
            if(nums[L] <= nums[mid]){
                if(target >= nums[L] && target < nums[mid]){
                    R = mid - 1;
                }else {
                    L = mid + 1;
                    if(target == nums[mid]){
                        return mid;
                    }
                }
            }else{
                if(target > nums[mid] && target <= nums[R]){
                    L = mid + 1;
                }else{
                    R = mid - 1;
                    if(target == nums[mid]){
                        return mid;
                    }
                }
            }
        }
        return -1;
    }
}
