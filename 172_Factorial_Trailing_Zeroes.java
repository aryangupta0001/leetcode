class Solution {
    public int trailingZeroes(int n) {
        return countZero(n, 5);
    }

    static int countZero(int n, int factor){
        if(factor > n)
            return 0;

        return n / factor + countZero(n, factor * 5);
    }
}
