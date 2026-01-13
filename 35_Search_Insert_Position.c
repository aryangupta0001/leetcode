int searchInsert(int* nums, int numsSize, int target) {
    int beg = 0, end = numsSize-1, mid;


    while(beg<=end)
    {
        mid = (beg+end)/2;

        if(nums[mid] == target)
            return mid;
        
        else if(nums[mid]<target)
            beg = mid+1;
        
        else
            end = mid-1;
    }

    if(nums[mid] > target)
        return mid;

    else
        return beg;

}
