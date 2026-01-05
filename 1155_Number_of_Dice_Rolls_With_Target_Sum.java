class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        if (n > target)
            return 0;

        int[][] dp = new int[n + 1][target + 1];

        for (int[] arr : dp)
            Arrays.fill(arr, -1);

        return possibleWays(target, n, k, dp);
    }

    static int possibleWays(int target, int n, int k, int[][] dp) {
        if (dp[n][target] > -1) {
            return dp[n][target];
        }

        if (n == 0 && target == 0)
            return 1;

        if (n == 0 || target == 0)
            return 0;

        int ans = 0;

        for (int i = 1; i <= k; i++) {
            if (i > target)
                break;

            ans = (ans + possibleWays(target - i, n - 1, k, dp)) % 1000000007;
        }
        
        return (dp[n][target] = ans);

    }
}
