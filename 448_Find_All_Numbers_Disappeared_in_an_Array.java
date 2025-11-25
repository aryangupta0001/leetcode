class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int i = 0, j;

        List<Integer> ans = new ArrayList<>();

        while (i < nums.length) {
            j = Math.abs(nums[i])  - 1;

            if(nums[j] > 0)
                nums[j] = nums[j] * -1;
            
            i++;
        }

        for (i = 0; i < nums.length; i++)
            if (nums[i] > 0)
                ans.add(i + 1);

        return ans;
    }
}
