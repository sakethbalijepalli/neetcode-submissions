class NumArray {
    
    List<Integer> prefix = new ArrayList<>();

    public NumArray(int[] nums) {
        int total = 0;

        for(int i : nums){
            total += i;
            prefix.add(total);
        }
    }

    public int sumRange(int left, int right) {
        int prefixRight = prefix.get(right);
        int prefixLeft = left > 0 ? prefix.get(left - 1) : 0;

        return prefixRight - prefixLeft;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */