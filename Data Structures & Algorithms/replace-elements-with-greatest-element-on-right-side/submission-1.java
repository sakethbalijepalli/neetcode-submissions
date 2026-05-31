class Solution {
    public int[] replaceElements(int[] arr) {
        int maxNumber = -1;
        for(int i = arr.length - 1;i >= 0;i--){
            int temp = arr[i];// ith index is at 2 now and we are storing the value in temp to lose the element. 
            arr[i] = maxNumber;
            maxNumber = Math.max(temp, arr[i]);// max  = 2
        }
        return arr;
    }
}
