int removeDuplicates(int* nums, int numsSize) {
    int count = 0, i, j, k = 0;

    for(i=0; i<numsSize-1; i++)
        if(nums[i] != nums[i+1])
            nums[k++] = nums[i];

    nums[k++] = nums[i];

    return k;
}
