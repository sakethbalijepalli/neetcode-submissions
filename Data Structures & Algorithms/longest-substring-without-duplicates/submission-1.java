class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int result = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            
            window.put(c, window.getOrDefault(c, 0) + 1);
            
            while (left < right && window.get(c) > 1) {
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (window.get(leftChar) == 0) window.remove(leftChar);
                left++;
            }
            
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
