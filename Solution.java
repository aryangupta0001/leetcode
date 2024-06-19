class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 1, j = 0, max = 0, k, l, match = 0;

        StringBuilder sb = new StringBuilder();

        if(s.length() > 0)
        {   sb.append(s.charAt(0));
            j++;
            max = j;
        }

        while(i<s.length())
        {   match = 0;
            for(k = 0; k<j; k++)
                if(s.charAt(i) == sb.charAt(k))
                {   match = 1;
                    break;
                }
            
            if(match == 1)
            {   sb.delete(0, k+1);
                j = j-k-1;

            }

            sb.append(s.charAt(i));
            j++;
            if(max < j)
                max = j;

            i++;
        }

        return max;

    }
}
