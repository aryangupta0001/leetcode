class Solution {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];

        for (char[] a : board)
            Arrays.fill(a, '.');

        return getArrangements(0, board);

    }

    static int getArrangements(int row, char[][] board) {
        int ans = 0;

        if (row == board.length)
            return 1;

        for (int i = 0; i < board.length; i++) {
            if (isSafe(row, i, board)) {
                board[row][i] = 'Q';

                ans += getArrangements(row + 1, board);
                board[row][i] = '.';
            }
        }
        return ans;
    }

    static boolean isSafe(int row, int col, char[][] board) {
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q')
                return false;

        for (int i = row, j = col; i > 0 && j > 0;)
            if (board[--i][--j] == 'Q')
                return false;

        for (int i = row, j = col; i > 0 && j < board.length - 1;)
            if (board[--i][++j] == 'Q')
                return false;

        return true;
    }
}
