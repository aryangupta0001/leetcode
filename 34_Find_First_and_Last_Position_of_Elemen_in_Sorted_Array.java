class Solution {
    public int[] searchRange(int[] nums, int target) {
        int beg = 0, end = nums.length - 1, mid;
        int [] ans = {-1, -1};

        if(nums.length == 0)
            return ans;

        while(beg <= end){

            mid = beg + (end - beg) / 2;

            if(nums[mid] >= target){
                end = mid - 1;
            }

            else {
                beg = mid + 1;
            }
        }

        if(beg < nums.length && nums[beg] == target){
            ans[0] = beg;
        }
        else{
            System.out.println("25");
            return new int[] {-1, -1};
        }
        end = nums.length  - 1;
        while(beg <= end){
            mid = beg + (end - beg) / 2;

            if(nums[mid] <= target)
                beg = mid + 1;
            
            else{
               end = mid - 1;
            }
        }

        ans[1] = end;
        return ans;
    }
}
