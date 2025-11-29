class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = nums[0], ans = Integer.MAX_VALUE, i = 0, j = 0;

        while (j < nums.length && i <= j) {
            if (sum >= target) {
                sum -= nums[i];
                ans = ans > j - i + 1 ? j - i + 1 : ans;
                i++;
            }
            else {
                if (j < nums.length - 1) {
                    sum += nums[++j];
                } else
                    i++;
            }

        }

        return ans < Integer.MAX_VALUE ? ans : 0;
    }
}
