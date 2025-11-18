class Solution {
    public int findMin(int[] nums) {
        int beg = 0, end = nums.length - 1, pivot = end;

        if(end == 0)
            return nums[0];

        else if(end == 1)
            return nums[0] < nums[1] ? nums[0] : nums[1];

        while(beg <= end){
            int mid = beg + (end - beg) / 2;

            if(mid < end && nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            
            else if(mid > beg && nums[mid] < nums[mid - 1])
                return nums[mid];
            
            else if(beg != mid && mid != end && nums[beg] == nums[mid] && nums[mid] == nums[end]){
                if(nums[beg] > nums[beg + 1])
                    return nums[beg + 1];
                
                if(nums[end] < nums[end - 1])
                    return nums[end];
                
                beg++;
                end--;
            }

            else if(nums[mid] >= nums[beg] && nums[mid] >= nums[end]){
                beg = mid + 1;
            }

            else
                end = mid - 1;
        }

        return nums[(pivot + 1) % nums.length];
    }
}
