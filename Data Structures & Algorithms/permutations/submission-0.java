class Solution {
     public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        boolean[] arr = new boolean[nums.length];
        dfs(nums,0,resList,numList,arr);
        return resList;
    }

    private void dfs(int[] nums,int i,List<List<Integer>> resList,List<Integer> numList,boolean[] arr){
        if(i == nums.length){
            resList.add(new ArrayList<>(numList));
            return;
        }
        for(int j = 0;j < nums.length;j++){
            if(!arr[j]){
                numList.add(nums[j]);
                arr[j] = true;
                dfs(nums, i + 1, resList, numList,arr);
                numList.removeLast();
                arr[j] = false;
            }
        }
    }
}
