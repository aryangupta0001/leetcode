class Solution {
    public int fib(int n) {
        int[] cache = new int[n + 1];

        return fibonacci(n, cache);
    }

    int fibonacci(int n, int[] cache) {

        if (n <= 1)
            return n;
     
        else if (cache[n] != 0)
            return cache[n];

        else {
            cache[n] = fibonacci(n - 1, cache) + fibonacci(n - 2, cache);
        }

        return cache[n];
    }
}
