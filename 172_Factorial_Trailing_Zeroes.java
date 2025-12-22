class Solution {
    public int trailingZeroes(int n) {

        int count = 0;
        int factor = 5;

        while (factor <= n) {
            count += n / factor;
            factor *= 5;
        }

        return count;
    }

}
