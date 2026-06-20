class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        // For lowercase only problems, prefer: int[] freq = new int[26];

        int left = 0;
        int result = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // 1. EXPAND: add right character into window
            //we are putting char x into map with frequency
            window.put(c, window.getOrDefault(c, 0) + 1);

            // 2. SHRINK: contract window while constraint is violated
            while (left < right && window.get(c) > 1) {
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (window.get(leftChar) == 0) window.remove(leftChar);
                left++;
            }

            // 3. UPDATE result at every valid window state
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
