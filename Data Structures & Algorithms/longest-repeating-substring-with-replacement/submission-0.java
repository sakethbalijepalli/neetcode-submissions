class Solution {
    public int characterReplacement(String s, int k) {
        int L = 0;
        int maxFreq = 0;
        int maxLen = 0;
        int[] arr = new int[26];
        for(int R = 0;R < s.length();R++){
            arr[s.charAt(R) - 'A']++;
            maxFreq = Math.max(maxFreq, arr[s.charAt(R) - 'A']);
            if(R - L + 1 - maxFreq > k){
                arr[s.charAt(L) - 'A']--;
                L++;
            }
            maxLen = Math.max(maxLen, R - L + 1);
        }
        return maxLen;
    }
}
