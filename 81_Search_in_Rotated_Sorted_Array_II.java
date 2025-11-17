class Solution {
    public boolean search(int[] nums, int target) {
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

            if(beg != mid && mid != end && nums[beg] == nums[mid] && nums[mid] == nums[end]){
                if(nums[beg] > nums[beg + 1]){
                    pivot = beg;
                    break;
                }

                if (nums[end] < nums[end - 1]){
                    pivot = end - 1;
                    break;
                }

                beg++;
                end--;
            }

            // else if(nums[beg] < nums[mid] || (nums[beg] == nums[mid] && nums[mid] > nums[end])){
            //     beg = mid + 1;
            // }
            
            else if(nums[beg] <= nums[mid] && nums[mid] >= nums[end]){
                beg = mid + 1;
            }

            else
                end = mid - 1;
        }


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
                return true;
            
            else if(target < nums[mid])
                end = mid - 1;
            
            else
                beg = mid + 1;
        }
        return false;

    }
}
