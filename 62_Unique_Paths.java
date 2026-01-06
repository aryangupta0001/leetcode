class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int[] arr : dp)
            Arrays.fill(arr, -1);

        return countPaths(m, n, dp);
    }

    static int countPaths(int r, int c, int[][] dp) {
        if (dp[r][c] > -1)
            return dp[r][c];

        if (r == 1 || c == 1)
            return 1;
        
        return dp[r][c] = countPaths(r - 1, c, dp) + countPaths(r, c - 1, dp);
    }
}
