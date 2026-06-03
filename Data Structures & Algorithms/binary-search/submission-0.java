class Solution {
    public int search(int[] arr, int target) {
        int L = 0, R = arr.length - 1;
// 0 1 2 3 4 5 6 7 8 9, target is 6
        while(L <= R){
            int mid = L + (R - L) / 2;

            if(target > arr[mid]){
                L = mid + 1;
            }else if(target < arr[mid]){
                R = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
