class MyQueue {
    int [] arr1, arr2;
    int i, j;

    public MyQueue() {
        arr1 = new int[100];
        arr2 = new int[100];
        i = -1;
        j = -1;
    }
    
    public void push(int x) {
        while(i>=0)
            arr2[++j] = arr1[i--];

        arr1[++i] = x;

        while(j>=0)
            arr1[++i] = arr2[j--];
    }
    
    public int pop() {
        return arr1[i--];
    }
    
    public int peek() {
        return arr1[i];
    }
    
    public boolean empty() {
        return i == -1;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
