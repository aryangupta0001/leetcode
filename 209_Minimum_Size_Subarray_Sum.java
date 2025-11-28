class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int a = 1, b = nums.length;
        int sum = 0, lastAns = 0;
        boolean found = false;

        while(a<=b){
            int mid = a + (b - a) / 2, i = 0,  j = 0;
            found = false;

            sum = 0;

            while(j<nums.length){
                sum += nums[j];

                if(j - i + 1 == mid){
                    if(sum >= target){
                        found = true;
                        break;
                    }
                    
                    sum -= nums[i];
                    i++;
                }
                j++;
            }

            if(found){
                b = mid-1;
                lastAns = mid;
            }
            
            else{
                a = mid+1;
            }

        }

        return lastAns;
    }
}
