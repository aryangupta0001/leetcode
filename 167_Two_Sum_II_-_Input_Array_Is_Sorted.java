class Solution {

    public int binarySearch(int[] numbers, int i, int target){
        int a = i+1, b = numbers.length - 1;

        while(a<=b){
            int mid = a + (b - a) / 2;

            if(numbers[mid] == target)
                return mid;
            
            else if (numbers[mid] < target)
                a =  mid + 1;
            
            else
                b = mid - 1;
        }

        return -1;
    }

    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

        if(n == 2)
            return new int[] {1, 2};

        for (int i = 0; i < n; i++) {
            int diff = target - numbers[i];
            
            int index = binarySearch(numbers, i, diff);

            if (index > -1)
                return new int[] { i + 1, index + 1 };
        }

        return new int[] { -1, -1 };
    }
}
