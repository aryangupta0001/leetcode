class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int i = 0, n = nums.length, temp;
        
        List <Integer> ans = new ArrayList<>();

        while(i<n)
            if(nums[i] != nums[nums[i]- 1]){
                temp  = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
            else
                i++;
        
        for(i = 0; i<n; i++)
            if(nums[i] != i + 1)
                ans.add(nums[i]);
        
        return ans;
    }
}
