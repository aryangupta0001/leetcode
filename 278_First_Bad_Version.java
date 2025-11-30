/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {

    public int firstBadVersion(int n) {
        int a = 1, b = n;

        while (a < b) {
            int mid = a + (b - a) / 2;

            // bad = ;

            if (isBadVersion(mid))
                b = mid;
            else
                a = mid + 1;

        }

        return a;
    }
}
