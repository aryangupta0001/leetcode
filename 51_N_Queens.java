class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for (char[] a : board)
            Arrays.fill(a, '.');

        return getArrangements(0, board);
    }

    static List<List<String>> getArrangements(int row, char[][] board){
        
        List<List<String>> ans = new ArrayList<>();
        
        if(row == board.length){
            List<String> innerList = new ArrayList<>();

            for(char[] a : board){
                String b  = "";

                for(char c : a)
                    b += c;
                
                innerList.add(b);
            }

            ans.add(innerList);

            return ans;
        }

        for(int i = 0; i<board.length; i++){
            if(isSafe(row, i, board)){
                board[row][i] = 'Q';

                List<List<String>> a = new ArrayList<>();

                a = getArrangements(row+1, board);

                if(a.size() > 0)
                    ans.addAll(a);
                
                board[row][i] = '.';
            }
        }

        return ans;
    }

    static boolean isSafe(int row, int col, char [][] board){
        for(int i = 0; i<board.length; i++)
            if(board[row][i] == 'Q' || board[i][col] == 'Q')
                return false;
        
        int i = row, j = col;

        while(i > 0 && j > 0)
            if(board[--i][--j] == 'Q')
                return false;

        i = row;
        j = col;

        while(i > 0 && j<board.length - 1)
            if(board[--i][++j] == 'Q')
                return false;

        return true;
    }
}
