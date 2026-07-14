class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Arrays.sort(candidates);
        recurse(candidates,target,resList,0,res);
        return resList;
    }

    private void recurse(int[] candidate,int target,List<List<Integer>> resList,int i,List<Integer> res){
        if(target == 0){
            resList.add(new ArrayList<>(res));
            return;
        }

        if(target < 0 || i == candidate.length ){
            return;
        }

        res.add(candidate[i]);
        recurse(candidate,target -= candidate[i],resList,i + 1,res);
        res.removeLast();

        while (i < candidate.length - 1 && candidate[i + 1] == candidate[i]){
            i++;
        }
        recurse(candidate,target += candidate[i],resList,i + 1,res);

    }
}
