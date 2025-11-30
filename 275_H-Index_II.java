class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length, a = 0, b = n-1;

        while(a<b){
            int mid = a + (b - a) / 2;

            if(n - mid <= citations[mid])
                b = mid;
            
            else
                a = mid + 1;
        }

        return citations[a] > 0 ? n - a : 0;
    }
}
