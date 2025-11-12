class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int beg = 0, end = letters.length - 1, mid;

        if(target >= letters[letters.length  - 1])
            return letters[0];

        while(beg <= end){
            mid = beg + (end - beg)/2;

            if(letters[mid] <= target)
                beg = mid + 1;
            
            else
                end = mid - 1;
        }

        return letters[beg %  letters.length];
    }
}
