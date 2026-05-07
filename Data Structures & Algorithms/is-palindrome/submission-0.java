class Solution {
    public boolean isPalindrome(String s) {
        String modifiedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i = 0;
        int j = modifiedString.length() - 1;
        while (i < j){
            if(modifiedString.charAt(i) != modifiedString.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
