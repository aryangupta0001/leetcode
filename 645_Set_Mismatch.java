class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        int i = 0, n = nums.length, a, temp;

        while(i<n)
            if (nums[i] != nums[nums[i] - 1]) {
                temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
            else
                i++;

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1){
                ans[0] = nums[i];
                ans[1] = i+1;
                return ans;
            }
        }
        return ans;
    }
}
