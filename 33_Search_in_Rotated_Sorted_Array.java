class Solution {
    public int search(int[] nums, int target) {

        int beg = 0, end = nums.length - 1, pivot = end;

        while (beg <= end) {
            int mid = beg + (end - beg) / 2;

            if (mid < end && nums[mid] > nums[mid + 1]) {
                pivot = mid;
                break;
            }

            if(mid > beg && nums[mid] < nums[mid - 1]){
                pivot = mid - 1;
                break;
            }

            if(nums[mid] < nums[beg])
                end = mid - 1;
            
            else
                beg = mid + 1;
        }

        if(target == nums[pivot])
            return pivot;
            
        else{
            if(target >= nums[0]){
                beg = 0;
                end = pivot;
            }

            else{
                beg = pivot + 1;
                end = nums.length - 1;
            }

            while(beg <= end){
                int mid = beg + (end - beg) / 2;

                if(target == nums[mid])
                    return mid;
                
                else if(target < nums[mid])
                    end = mid - 1;
                
                else
                    beg = mid + 1;
            }
        }
        return -1;
    }
}
