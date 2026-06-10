class Solution {
    public int[] twoSum(int[] numbers, int target) {
          HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i < numbers.length;i++){
            int compositeKey = target - numbers[i];
            if(map.containsKey(compositeKey)){
                return new int[]{map.get(compositeKey),i + 1};
            }
            if(!map.containsKey(numbers[i])){
                map.put(numbers[i],i + 1);
            }
        }

        return new int[]{};
    }
}
