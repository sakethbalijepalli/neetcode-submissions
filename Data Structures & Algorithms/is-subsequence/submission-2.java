class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s == null || s.isEmpty()) return true;
        if(t == null || t.isEmpty()) return false;
        int j = 0;
        for(char c : t.toCharArray()){
            if(c == s.charAt(j)){
                j++;
            }
            if(j==s.length()){
                return true;
            }
        }
        return false;
    }
}