class Solution {
    public boolean checkValidGrid(int[][] grid) {
        return (grid[0][0] == 0) && isValid(grid, 0, 0, 0);
    }

    static boolean isValid(int[][] grid, int count, int i, int j) {
        int n = grid.length;

        if (count == n * n - 1)
            return true;

        int[] nextIndices = getNextMove(i, j, grid, count + 1);

        if (nextIndices[0] == -1)
            return false;

        return isValid(grid, count + 1, nextIndices[0], nextIndices[1]);
    }

    static int[] getNextMove(int i, int j, int[][] grid, int count) {
        int[] ans = { -1, -1 };

        if (i > 1 && j > 0) {
            if (grid[i - 2][j - 1] == count)
                return new int[] { i - 2, j - 1 };
        }

        if (i > 1 && j < grid.length - 1) {
            if (grid[i - 2][j + 1] == count)
                return new int[] { i - 2, j + 1 };
        }

        if (j < grid.length - 2 && i > 0) {
            if (grid[i - 1][j + 2] == count)
                return new int[] { i - 1, j + 2 };
        }

        if (j < grid.length - 2 && i < grid.length - 1) {
            if (grid[i + 1][j + 2] == count)
                return new int[] { i + 1, j + 2 };
        }

        if (i < grid.length - 2 && j > 0) {
            if (grid[i + 2][j - 1] == count)
                return new int[] { i + 2, j - 1 };
        }

        if (i < grid.length - 2 && j < grid.length - 1) {
            if (grid[i + 2][j + 1] == count)
                return new int[] { i + 2, j + 1 };
        }

        if (j > 1 && i > 0) {
            if (grid[i - 1][j - 2] == count)
                return new int[] { i - 1, j - 2 };
        }

        if (j > 1 && i < grid.length - 1) {
            if (grid[i + 1][j - 2] == count)
                return new int[] { i + 1, j - 2 };
        }

        return ans;
    }
}
