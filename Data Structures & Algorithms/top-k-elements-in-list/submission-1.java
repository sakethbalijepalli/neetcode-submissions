class Solution {
   public int[] topKFrequent(int[] arr, int k) {
       HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map.entrySet()
                .stream()
                .sorted((x, y) -> y.getValue().compareTo(x.getValue())) // Sort by value descending
                .limit(k)
                .map(Map.Entry::getKey)                                 // Extract just the keys
                .mapToInt(Integer::intValue)
                .toArray();    
    }
}
