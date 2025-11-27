class Solution {
    public int mySqrt(int x) {
        int a = 0, b = x / 2;

        if (x == 0 || x == 1)
            return x;

        while (a <= b) {
            int mid = a + (b - a) / 2;
            long sq = 1L * mid * mid;

            if (sq > Integer.MAX_VALUE || (int) sq > x)
                b = mid - 1;

            else if (sq == x)
                return mid;

            else if (sq < x)
                a = mid + 1;
        }

        return b;
    }
}
