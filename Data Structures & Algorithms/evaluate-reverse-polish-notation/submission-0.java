class Solution {
    public int evalRPN(String[] tokens) {
         Stack<Integer> stack = new Stack<>();

        for(int i = 0;i < tokens.length;i++){
            switch (tokens[i]) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-": {
                    int right = Integer.parseInt(String.valueOf(stack.pop()));
                    int left = Integer.parseInt(String.valueOf(stack.pop()));
                    stack.push(Integer.valueOf(String.valueOf(left - right)));
                    break;
                }
                case "*":
                    stack.push(Integer.valueOf(String.valueOf(Integer.parseInt(String.valueOf(stack.pop())) * Integer.parseInt(String.valueOf(stack.pop())))));
                    break;

                case "/": {
                    int right = Integer.parseInt(String.valueOf(stack.pop()));
                    int left = Integer.parseInt(String.valueOf(stack.pop()));
                    stack.push(Integer.valueOf(String.valueOf(left / right)));
                    break;
                }
                default:
                    stack.push(Integer.valueOf(String.valueOf(Integer.parseInt(tokens[i]))));
                    break;
            }
        }
        return stack.peek();
    }
}
