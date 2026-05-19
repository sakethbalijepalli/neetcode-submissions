class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] arrs = new int[26];
        int[] arrt = new int[26];

        for(char c : s.toCharArray()){
            arrs[c - 97]++;
        }
        for(int i = 0;i < t.length();i++){
            arrt[t.charAt(i) - 97]++;
        }
        return Arrays.toString(arrs).equals(Arrays.toString(arrt));
    }
}
