//官方题解
class MyQueue {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public MyQueue() {
        inStack = new LinkedList<Integer>();
        outStack = new LinkedList<Integer>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}

//方法二 不推荐 速度慢
class MyQueue {

    Stack<Integer> st = null;
    Stack<Integer> t = null;

    /** Initialize your data structure here. */
    public MyQueue() {
        st = new Stack<Integer>();
        t = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        st.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!st.isEmpty()) {
            t.push(st.pop());
        }
        int x = t.pop();
        while (!t.isEmpty()) {
            st.push(t.pop());
        }
        return x;
    }

    /** Get the front element. */
    public int peek() {
        while (!st.isEmpty()) {
            t.push(st.pop());
        }
        int x = t.peek();
        while (!t.isEmpty()) {
            st.push(t.pop());
        }
        return x;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st.isEmpty();
    }
}
