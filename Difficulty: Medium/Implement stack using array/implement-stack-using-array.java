class myStack {

    int[] stack;
    int top;
    int size;

    public myStack(int n) {
        size = n;
        stack = new int[n];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(int x) {
        if (isFull()) {
        
            return;
        }

        top++;
        stack[top] = x;
    }

    public void pop() {
        if (isEmpty()) {
        
            return;
        }

        top--;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }

        return stack[top];
    }
}