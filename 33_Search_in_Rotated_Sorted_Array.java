class Solution {
    public int search(int[] nums, int target) {
        int beg = 0, end = nums.length - 1;

        int pivot = findPivot(nums, beg, end);

        if (target == nums[pivot])
            return pivot;

        else if (target < nums[beg])
            return getIndex(nums, pivot + 1, end, target);

        return getIndex(nums, beg, pivot, target);
    }

    static int findPivot(int[] nums, int beg, int end) {
        int mid = beg + (end - beg) / 2;

        if (mid < end && nums[mid] > nums[mid + 1])
            return mid;

        else if (mid > 0 && nums[mid] < nums[mid - 1])
            return mid - 1;

        else if (nums[mid] < nums[beg])
            return findPivot(nums, beg, mid - 1);

        else if (mid < end && nums[mid] < nums[mid + 1])
            return findPivot(nums, mid + 1, end);

        return nums.length - 1;
    }

    static int getIndex(int[] nums, int beg, int end, int target) {
        if (beg <= end) {
            int mid = beg + (end - beg) / 2;

            if (nums[mid] == target)
                return mid;

            else if (nums[mid] < target)
                return getIndex(nums, mid + 1, end, target);

            else
                return getIndex(nums, beg, mid - 1, target);
        }
        return -1;
    }
}
