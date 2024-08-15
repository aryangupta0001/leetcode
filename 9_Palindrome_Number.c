bool isPalindrome(int x) {
    long rev = 0, a = x;
    int len = 0, l = 0;

    if(x<0)
        return false;

    while(a)
    {   len++;
        a/=10;
    }

    l = len;
    len/=2;
    a = x;

    while(len)
    {   rev = rev*10 + a%10;
        a/=10;
        len--;
    }

    if(l%2)
        a/=10;
    

    if(rev == a)
        return true;

    else
        return false;
}
