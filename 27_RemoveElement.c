int removeElement(int* nums, int numsSize, int val) {
    int i, j;

    while (i < numsSize)
        if (nums[i] == val)
        {
            for (j = i; j < numsSize-1; j++)
                nums[j] = nums[j + 1];
            numsSize--;
        }
        else
            i++;

    return i;
}
