class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if(letters[letters.length - 1] <= target)
            return letters[0];

        int beg = 0, end = letters.length - 1, mid;
        mid = beg + (end - beg)/2;

        while(beg <= end){
            mid = beg + (end - beg)/2;

            if(letters[mid] < target)
                beg = mid + 1;
            
            else if(letters[mid] > target)
                end = mid - 1;
            
            else{
                while(letters[mid] == letters[mid + 1])
                    mid++;
                return letters[mid + 1];
            }
        }
        
        if(letters[mid] > target)
            return letters[mid];
        
        else
            return letters[mid + 1];
    }
}
