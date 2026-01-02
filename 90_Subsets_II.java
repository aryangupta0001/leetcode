class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        return createSubsets(mergeSort(nums));
    }

    static int[] mergeSort(int[] nums) {
        if (nums.length == 1)
            return nums;

        int mid = nums.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(nums, mid, nums.length));

        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        int[] arr = new int[left.length + right.length];

        while (i < left.length && j < right.length)
            if (left[i] <= right[j])
                arr[k++] = left[i++];

            else
                arr[k++] = right[j++];

        while (i < left.length)
            arr[k++] = left[i++];

        while (j < right.length)
            arr[k++] = right[j++];

        return arr;
    }

    static List<List<Integer>> createSubsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>(Arrays.asList(nums[0])));

        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            int n = ans.size(), beg = 0, end = n;

            if (nums[i] == nums[i - 1])
                beg = n - count;
            
            count = 0;

            for (int j = beg; j < end; j++) {
                List<Integer> lst = new ArrayList<>(ans.get(j));
                lst.add(nums[i]);
                ans.add(lst);
                count++;
            }
        }
        return ans;
    }
}
