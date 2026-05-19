class Solution {
   public boolean hasDuplicate(int[] nums) {
      HashSet<Integer> map = new HashSet<>();
//        key as the number and the value as the count

        for (int num : nums) {
            if (map.contains(num)) {
                return true;
            }
            map.add(num);
        }
        return false;
    }
}