//推荐方法二也必须掌握


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


//方法二 推荐掌握
//链接：https://leetcode-cn.com/problems/min-stack/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-38/
class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        //当前值更小
        if(x <= min){   
            //将之前的最小值保存
            stack.push(min);
            //更新最小值
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        //如果弹出的值是最小值，那么将下一个元素更新为最小值
        if(stack.pop() == min) {
            min=stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}


