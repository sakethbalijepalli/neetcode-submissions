class Solution {
    public int[] countBits(int n) {
        int count = 0;
        int[] arr = new int[n + 1];
        for(int i = 0;i <= n;i++){
            count = 0;
            int temp = i;
            for (int j = 0; j < 32; j++) {
                if ((temp & 1) == 1) {
                    count++;
                }
                temp = temp >> 1;
            }
            arr[i] = count;
        }
        return arr;
    }
}
