class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>>  resList = new ArrayList<>();
        helper(1,n,k,res,resList);
        return resList;
    }

    private void helper(int i,int n,int k,List<Integer> res,List<List<Integer>> resList){
        if(res.size() == k){
            resList.add(new ArrayList<>(res));
            return;
        }

        if(i > n){
            return;
        }

        res.add(i);
        helper(i + 1,n,k,res,resList);
        res.removeLast();

        helper(i + 1,n,k,res,resList);
    }
}