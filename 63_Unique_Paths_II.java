class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length;
        int c = obstacleGrid[r-1].length;

        if(obstacleGrid[0][0] == 1 || obstacleGrid[r-1][c-1] == 1)
            return 0;

        int [][] dp = new int[r+1][c+1];

        for(int [] arr : dp)
            Arrays.fill(arr, -1);
        
        return totalPaths(obstacleGrid, 0, 0, dp);
    }

    static int totalPaths(int[][] grid, int r, int c, int[][]dp) {

        if(dp[r][c] > -1)
            return dp[r][c];

        int path = 0;

        if (r == grid.length - 1 && c == grid[r].length - 1)
            return 1;

        if (r == grid.length - 1) {
            if (grid[r][c + 1] == 0)
                path += totalPaths(grid, r, c + 1, dp);

            else
                return 0;
        }

        else if (c == grid[r].length - 1) {
            if (grid[r + 1][c] == 0)
                path += totalPaths(grid, r + 1, c, dp);

            else
                return 0;
        }

        else {
            if (grid[r][c + 1] == 0)
                path += totalPaths(grid, r, c + 1, dp);

            if (grid[r + 1][c] == 0)
                path += totalPaths(grid, r + 1, c, dp);
        }

        
        return dp[r][c] = path;
    }
}
