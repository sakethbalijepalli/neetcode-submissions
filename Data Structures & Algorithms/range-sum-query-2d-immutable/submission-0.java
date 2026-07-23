class NumMatrix {

    HashMap<HashMap<Integer,Integer>,Integer> map = new HashMap<>();
    public NumMatrix(int[][] matrix) {
        int total = 0;
        for(int row = 0;row < matrix.length;row++){
            for(int col = 0;col < matrix[0].length;col++){
                total += matrix[row][col];
                map.put(new HashMap<>(Map.of(row, col)), total);
            }
            total = 0;
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int prefixRight = map.get(new HashMap<>(Map.of(row1,col2))) - (col1 - 1 >= 0 ? map.get(new HashMap<>(Map.of(row1,col1 - 1))) : 0);
        int prefixLeft = 0;
        while (row1 + 1 <= row2){
            prefixLeft += map.get(new HashMap<>(Map.of(row1 + 1,col2))) - (col1 - 1 >= 0 ? map.get(new HashMap<>(Map.of(row1 + 1,col1 - 1))) : 0);
            row1++;
        }
        return prefixRight + prefixLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */