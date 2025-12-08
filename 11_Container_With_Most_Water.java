class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, max = 0;

        while(i<j){
            int boundary = Math.min(height[i], height[j]);
            int vol = boundary * (j - i);

            if(max < vol)
                max = vol;
            
            while(i<j && height[i] <= boundary)
                i++;
            
            while(i<j && height[j] <= boundary)
                j--;
        }

        return max;
    }
}
