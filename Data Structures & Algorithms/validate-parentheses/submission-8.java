class Solution {
     public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.length() <= 1){
            return false;
        }
        if(s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}'){
            return false;
        }
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }
            if(s.charAt(i) == ')'){
                char c;
                if(!stack.isEmpty()){
                    c = stack.peek();
                }else{
                    return false;
                }
                stack.pop();
                if(c != '('){
                    return false;
                }
            } else if (s.charAt(i) == ']') {
                char c;
                if(!stack.isEmpty()){
                    c = stack.peek();
                }else{
                    return false;
                }
                stack.pop();
                if(c != '['){
                    return false;
                }
            }else if (s.charAt(i) == '}'){
                char c;
                if(!stack.isEmpty()){
                    c = stack.peek();
                }else{
                    return false;
                }
                if(c != '{'){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}
