class Solution {
    public int[] plusOne(int[] digits) {
        int[] ans = new int[digits.length + 1];

        int i = 0;

        while(i<digits.length)
            ans[i+1] = digits[i++];

        ans[i] += 1;

        while(ans[i] == 10){
            ans[i-1] += 1;
            ans[i--] = 0;
        }

        if(ans[0] == 0)
            return Arrays.copyOfRange(ans, 1, ans.length);
        
        return ans;
    }
}
