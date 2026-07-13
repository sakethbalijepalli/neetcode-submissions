class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        recurse(n,0,0,res,stringBuilder);
        return res;
    }

    private void recurse(int n,int open,int close,List<String> res,StringBuilder stringBuilder){
        if(close > open) return;

        if(stringBuilder.length() == 2 * n){
            res.add(stringBuilder.toString());
            return;
        }

        if(open < n){
            stringBuilder.append("(");
            recurse(n,open + 1,close,res,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if(close < open){
            stringBuilder.append(")");
            recurse(n,open,close + 1,res,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
