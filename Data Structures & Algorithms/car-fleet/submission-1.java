class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
       if(target == 0 || position.length == 0 || speed.length == 0) return 0;

        Stack<Double> stack = new Stack<>();
//        Sort the position array and get absolute leader of the pack/fleet
        int n = position.length;
        int[][] cars = new int[n][2];

        for(int i = 0;i < position.length;i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars,(a,b) -> Integer.compare(b[0],a[0]));

//        If currentCarTime > stack.peek then we push to the stack, then we find a new leader and that car will lead the fleet.
        for(int i = 0;i < position.length;i++){
            int positionOfCar = cars[i][0];
            int speedOfCar = cars[i][1];
            double currentCarTime = (target - (double) positionOfCar) / speedOfCar;
            if(stack.isEmpty()){
                stack.push( currentCarTime);
            }else{
                if(currentCarTime > stack.peek()){
                    stack.push(currentCarTime);
                }
            }
        }
        return stack.size();
    }
}
