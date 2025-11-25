class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        int i = 0, n = nums.length, a;

        for (i = 0; i < n; i++) {
            a = Math.abs(nums[i]) - 1;

            if (nums[a] > 0) 
                nums[a] *= -1;
            
            else
                ans[0] = Math.abs(nums[i]);
        }

        for(i = 0; i<n; i++)    
            if(nums[i] > 0){
                ans[1] = i+1;
                break;
            }

        return ans;

    }
}
