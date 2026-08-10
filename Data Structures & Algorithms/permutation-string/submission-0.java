class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        
        if (n1 > n2) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        
        for (int i = 0; i < n1; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < n2 - n1; i++) {
            if (Arrays.equals(s1Count, s2Count)) {
                return true;
            }
            
            s2Count[s2.charAt(i + n1) - 'a']++; 
            s2Count[s2.charAt(i) - 'a']--; 
        }
        
        return Arrays.equals(s1Count, s2Count);
    }
}
