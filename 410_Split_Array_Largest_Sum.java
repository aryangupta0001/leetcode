class Solution {
    public int splitArray(int[] nums, int k) {
        
        int sum = 0, i = 0, max = nums[0], count = 0, minSum = 0;
        int[] ans = new int[1000];

        while (i < nums.length) {
            sum += nums[i];

            max = max < nums[i] ? nums[i] : max;
            i++;
        }

        int a = max;
        int b = sum;

        while (a < b) {
            int mid = a + (b - a) / 2;

            count = 1;
            minSum = 0;

            for (i = 0; i < nums.length; i++) {
                if (minSum + nums[i] <= mid)
                    minSum += nums[i];

                else {
                    count++;
                    minSum = nums[i];
                }
            }

            if (count > k){
                // a = a == mid ? a + 1 : mid;
                if(a == mid)
                    return b;
                
                else
                    a = mid;
            }

            else
                b = mid;
        }
        return a;
    }
}
