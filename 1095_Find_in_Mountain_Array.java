/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int beg = 0, end = mountainArr.length() - 1;

        while(beg != end){
            int mid = beg + (end - beg) / 2;
            int a, b, c;

            a = mountainArr.get(mid);
            b = mountainArr.get(mid + 1);
            c = mountainArr.get(mid-1);
            
            if(a < b)
                beg = mid + 1;

            else
                if(c < a){
                    beg = mid;
                    end = mid;
                    break;
                }

                else
                    end = mid;
        }

        int i = beg;
        beg = 0;

        while(beg <= end){
            int mid = beg + (end - beg) / 2, a;

            a = mountainArr.get(mid);
            
            if(a < target)
                beg = mid + 1;
            
            else if(a == target)
                return mid;

            else
                end = mid - 1;
        }

        beg = i + 1;
        end = mountainArr.length() - 1;

        while(beg <= end){
            int mid = beg + (end - beg) / 2, a;
            a = mountainArr.get(mid);

            if(a > target)
                beg = mid + 1;
            
            else if(a == target)
                return mid;
            
            else
                end = mid - 1;
        }
        
        return -1;
    }
}
