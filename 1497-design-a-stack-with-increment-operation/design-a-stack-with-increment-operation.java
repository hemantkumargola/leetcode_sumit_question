
class CustomStack {

    int[] arr;
    int top;
    int maxSize;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        top = -1;
    }

    public void push(int x) {
        if (top == maxSize - 1) {
            return;
        }

        arr[++top] = x;
    }

    public int pop() {
        if (top == -1) {
            return -1;
        }

        return arr[top--];
    }

    public void increment(int k, int val) {
        int limit = Math.min(k, top + 1);

        for (int i = 0; i < limit; i++) {
            arr[i] += val;
        }
    }
}
