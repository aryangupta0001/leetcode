class Solution {
    public int palindrome(int a, int b, String s) {
        while (a < b) {
            if (s.charAt(a) != s.charAt(b))
                return 0;
            a++;
            b--;
        }
        return 1;
    }

    public String longestPalindrome(String s) {
        int i, j, len = s.length(), max = 0, palin;
        int[] arr = new int[2];

        if (len == 1)
            return s;

        for (i = 0; i < len; i++)
            if (max < len-1-i)
                for (j = len - 1; j > i; j--)
                {   if (max < j - i) {
                        palin = palindrome(i, j, s);
                        if (palin == 1) {
                            max = j - i;
                            arr[0] = i;
                            arr[1] = j;
                            break;
                        }
                    }
                    else
                        break;
                }
            else
                break;
        String res = s.substring(arr[0], arr[1] + 1);

        return res;
    }
}
