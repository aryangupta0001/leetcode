class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int i = 0;

        List<Integer> ans = new ArrayList<>();

        while(i<nums.length){
            if(nums[i] != nums[nums[i] - 1]){
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
            else
                i++;
        }

        for(i = 0; i<nums.length; i++)
            if(nums[i] != i + 1)
                ans.add(i+1);
        
        return ans;
    }
}
