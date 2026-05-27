class Solution {
    public boolean isValidSudoku(char[][] board) {
            char[] numsArr = new char[]{'1','2','3','4','5','6','7','8','9'};
        HashSet<Character> set = new HashSet<>();

        Set<Character> restrictedChars = new HashSet<>();
        for (char c : numsArr) {
            restrictedChars.add(c);
        }

        // Loop over the rows.
        for (char[] chars : board) { // loops through the rows 0 - 9
            for (char current : chars) { // loops through the columns 0 - 9
                if (current == '.') {
                    continue;
                }
                if (!restrictedChars.contains(current) || !set.add(current)) {
                    return false;
                }
            }
            set.clear();
        }

        //Loop over columns.
        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 9; row++) {
                char current = board[row][col];
                if (current == '.') {
                    continue;
                }
                if (!restrictedChars.contains(current) || !set.add(current)) {
                    return false;
                }
            }
            set.clear();
        }
        // we also need to check 3 * 3 constraints - 1st approach by jumping through grids
//        for(int row = 0;row < 9;row += 3){ // jumps row by 3
//            for(int col = 0;col < 9;col +=3){ // jumps col by 3
//                for(int innerRow = 0;innerRow <= 2;innerRow++){ //Checks the boxes of those by looping through them
//                    for(int innerCol = 0;innerCol <=2;innerCol++){
//                        char current = board[row + innerRow][col + innerCol];
//                        if (current == '.') {
//                            continue;
//                        }
//                        if (!restrictedChars.contains(current) || !set.add(current)) {
//                            return false;
//                        }
//                    }
//                }
//                set.clear();
//            }
//        }

        // 2nd approach is through IDing the boxes using division example - 4 / 3 gives us 1 we ID the boxes 0 1 2 where
        // 0 -> 0 1 2 and 1 -> 3 4 5 and 2 -> 6 7 8 likewise for col.
        HashSet<Character>[] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            boxes[i] = new HashSet<>(); // Initialize each set
        }

        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                char current = board[row][col];
                if (current == '.') continue;

                // Calculate the single Box ID (0 through 8)
                int boxId = (row / 3) * 3 + (col / 3);

                // Try to add it to that specific box's set
                if (!boxes[boxId].add(current)) {
                    return false; // It's a duplicate in this box!
                }
            }
        }
        return true;
    }
}
