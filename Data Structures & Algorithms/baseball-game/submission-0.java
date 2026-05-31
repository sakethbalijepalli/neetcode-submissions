class Solution {
    public int calPoints(String[] operations) {
        Deque<String> stack = new ArrayDeque<>();
        for (String operation : operations) {
            switch (operation) {
                case "+" -> {
                    int lastElement = Integer.parseInt(stack.pollLast());
                    int lastButOneElement = Integer.parseInt(stack.peekLast());
                    int sum = lastElement + lastButOneElement;
                    stack.offer(String.valueOf(lastElement));
                    stack.offer(String.valueOf(sum));
                    continue;
                }
                case "C" -> {
                    stack.removeLast();
                    continue;
                }
                case "D" -> {
                    int lastElement = Integer.parseInt(stack.peekLast());
                    int multiply = lastElement * 2;
                    stack.offer(String.valueOf(multiply));
                    continue;
                }
            }
            stack.offer(operation);
        }
        int sum = 0;
        for(String num : stack){
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}