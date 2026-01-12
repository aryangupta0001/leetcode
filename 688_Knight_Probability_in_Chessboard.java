class Solution {
    public double knightProbability(int n, int k, int row, int column) {

        double[][][] dp = new double[n][n][k + 1];

        for (double[][] a : dp)
            for (double[] b : a)
                Arrays.fill(b, -1);

        return getProbability(n, k, row, column, dp);
    }

    static double getProbability(int n, int k, int row, int col, double[][][] dp) {
        if (k == 0)
            return 1;

        if (dp[row][col][k] > -1)
            return dp[row][col][k];

        double prob = 0d;

        int[][] idcs = { { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { -1, -2 }, { 1, -2 } };

        for (int[] idx : idcs) {
            int i = row + idx[0];
            int j = col + idx[1];

            if (i >= 0 && i < n && j >= 0 && j < n)
                prob = prob + 0.125d * getProbability(n, k - 1, i, j, dp);
        }

        dp[row][col][k] = prob;
        return prob;
    }
}
