/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {

    boolean isBad(Map<Integer, Boolean> versions, int n){
        boolean bad  = true;
        
        if(versions.containsValue(n))
            bad = versions.get(n);
        
        else
            bad = isBadVersion(n);
        
        return bad;

    }

    public int firstBadVersion(int n) {
        int a = 1, b = n;

        Map<Integer, Boolean> versions = new HashMap<>();
        boolean bad = true;


        while(a<=b){
            int mid = a + (b-a) / 2;

            bad = isBad(versions, mid);
            versions.put(mid, bad);

            if(bad){
                if(mid > 0){   
                    bad = isBad(versions, mid-1);

                    if(!bad)
                        return mid;
                    
                    else{
                        versions.put(mid - 1, bad);
                        b = mid - 2;
                    }
                }
                else
                    return mid;
            }

            else{
                    bad = isBad(versions, mid + 1);

                    if(bad)
                        return mid + 1;
                    
                    else
                        a = mid  + 2;
            }

        }

        return a;
    }
}
