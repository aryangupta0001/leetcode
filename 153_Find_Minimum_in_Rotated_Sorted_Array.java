class Solution {
    public int findMin(int[] nums) {
        int beg = 0, end = nums.length - 1, pivot = end;

        if(end == 0)
            return nums[0];
        
        else if(end == 1)
            return nums[0] < nums[1] ? nums[0] : nums[1];

        while(beg != end){
            int mid = beg + (end - beg) / 2;

            if(nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            
            else if(nums[mid] < nums[mid - 1])
                return nums[mid];
            
            else if(nums[beg] > nums[mid])
                end = mid - 1;
            
            else
                beg = mid + 1;
        }

        return nums[(beg + 1) % nums.length];
    }
}
