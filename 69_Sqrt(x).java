class Solution {
    public int mySqrt(int x) {
        int a = 0, b = x / 2 + 1;

        if (x == 0 || x == 1)
            return x;

        while (a < b) {
            int mid = a + (b - a) / 2;
            long sq = 1L * mid * mid;

            if (sq > Integer.MAX_VALUE || (int) sq > x)
                b = mid;

            else if (sq == x)
                return mid;

            else if (sq < x) {
                if(a == mid)
                    return a;
                a = mid;
            }
        }

        return a;
    }
}
