class Solution {
    public void solveSudoku(char[][] board) {
        sudokuSolver(board, 0, 0);
    }

    static boolean sudokuSolver(char[][] board, int row, int col) {
        if (col == 9) {
            if (row == 8)
                return true;
            else {
                row++;
                col = 0;
            }
        }

        if (board[row][col] != '.')
            return sudokuSolver(board, row, col + 1);

        for (char k = '1'; k <= '9'; k++) {
                if (isSafe(board, k, row, col)) {
                    board[row][col] = k;

                    if (sudokuSolver(board, row, col + 1))
                        return true;

                    board[row][col] = '.';
                }
        }
        return false;
    }

    static boolean isSafe(char[][] board, char k, int row, int col) {
        for (int i = 0; i < 9; i++)
            if (board[row][i] == k || board[i][col] == k)
                return false;

        for (int i = row - row % 3; i <= row - row % 3 + 2; i++)
            for (int j = col - col % 3; j <= col - col % 3 + 2; j++)
                if (board[i][j] == k)
                    return false;

        return true;
    }
}
