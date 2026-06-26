class Solution {
     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//        To perform a flood fill:
//
//Begin with the starting pixel and change its color to color.
//Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel, either horizontally or vertically) and shares the same color as the starting pixel.
//Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches the original color of the starting pixel.
//The process stops when there are no more adjacent pixels of the original color to update.
        int startingColor = image[sr][sc];
        if (startingColor == color) return image;
        return dfs(image,sr,sc,color,startingColor);
    }

    private int[][] dfs(int[][] image, int row, int col, int color,int startingColor){
        int ROW = image.length, COL = image[0].length;
        if(Math.min(row,col) < 0 || row == ROW || col == COL || image[row][col] != startingColor){
            return image;
        }
        
        image[row][col] = color;

        dfs(image,row + 1,col,color,startingColor);
        dfs(image,row - 1,col,color,startingColor);
        dfs(image,row ,col + 1,color,startingColor);
        dfs(image,row,col - 1,color,startingColor);

        return image;
    }
}