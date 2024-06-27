class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int i = 0, j = 0, k = (len1 + len2) / 2, odd = 1, l = 0, i_incre, j_incre, sum = 0;
        int[] nums3 = new int[2];

        if ((len1 + len2) % 2 == 0)
            odd = 0;

        while (i < len1 || j < len2)
        {
            if(i<len1 && j<len2)
                if (nums1[i] < nums2[j]) {
                    i++;
                    l++;
                    i_incre = 1;
                    j_incre = 0;
                }

                else
                {
                    j++;
                    l++;
                    j_incre = 1;
                    i_incre = 0;
                }
            
            else if(i<len1)
            {
                i++;
                l++;
                i_incre = 1;
                j_incre = 0;
            }

            else
            {
                j++;
                l++;
                j_incre = 1;
                i_incre = 0;
            }

            if(k == l && odd == 0)
                if(i_incre == 1)
                    sum = nums1[i-1];
                else
                    sum = nums2[j-1];

            if(k == l-1)
                if(odd == 0)
                {
                    if(i_incre == 1)
                        sum += nums1[i-1];
                    else
                        sum += nums2[j-1];
                    
                    break;
                }

                else
                {   if(i_incre == 1)
                        sum = nums1[i-1];
                    else
                        sum = nums2[j-1];
                    
                    break;
                }
        }

        if(odd == 0)
            return sum/2.0f;
        else
            return sum;
    }
}
