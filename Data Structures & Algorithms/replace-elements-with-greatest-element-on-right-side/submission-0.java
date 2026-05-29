class Solution {
    public int[] replaceElements(int[] arr) {
        int[] res = new int[arr.length];
        res[arr.length - 1] = -1;
        int maxNumber = Integer.MIN_VALUE;
        for(int i = 0;i < arr.length - 1;i++){
            int j = i + 1;
            while (j < arr.length){
                //we check j with every index starting with i
                if(arr[j] >= maxNumber){
                    maxNumber = Math.max(maxNumber,arr[j]);
                }
                j++;
            }
            res[i] = maxNumber;
            maxNumber = Integer.MIN_VALUE;
        }
        return res;
    }
}