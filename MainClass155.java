//官方题解
class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
//kalipy
class MinStack {
    Stack<Integer> st = null;
    Stack<Integer> stMin = null;
    //int min = Integer.MIN_VALUE;

    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<Integer>();
        stMin = new Stack<Integer>();
    }

    public void push(int val) {
        st.push(val);
        if (stMin.isEmpty()) stMin.push(val);
        else {
            stMin.push(Math.min(val, stMin.peek()));
        }

    }

    public void pop() {
        st.pop();
        stMin.pop();

    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return stMin.peek();
    }
}
