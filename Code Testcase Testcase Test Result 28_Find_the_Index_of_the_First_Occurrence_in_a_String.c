int strStr(char* haystack, char* needle) {
    int str1 = strlen(haystack), str2 = strlen(needle), i = 0, j, found = 0;

    while(i<(str1-(str2-1)))
    {   if(haystack[i] == needle[0])
        {   found  = 1;

            if(str2 > 1)  
                for(j = 1; j<str2; j++)
                    if(haystack[i+j] != needle[j])
                    {   found = 0;
                        break;
                    }

            if(found)
                return i;
        }
        i++;
    }

    return -1;
}
