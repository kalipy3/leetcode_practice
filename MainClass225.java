//kalipy 写法一 推荐写法二(快了一倍)
class MyStack {
    private Queue<Integer> a;
    private Queue<Integer> b;
    
    public MyStack() {
        a = new LinkedList<>();
        b = new LinkedList<>();
    }
    
    public void push(int x) {
        while(!a.isEmpty())
            b.offer(a.poll());

        a.offer(x);
        while (!b.isEmpty()) {
            a.offer(b.poll());
        }
    }
    
    public int pop() {
        return a.poll();
    }
   
    public int top() {
        return a.peek();
    }
    
    public boolean empty() {
        return a.isEmpty();
    }
}

//作者：demigodliu
//链接：https://leetcode-cn.com/problems/implement-stack-using-queues/solution/wu-tu-guan-fang-tui-jian-ti-jie-yong-dui-63d4/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//一个队列为主队列，一个为辅助队列，当入栈操作时，我们先将主队列内容导入辅助队列，然后将入栈元素放入主队列队头位置，再将辅助队列内容，依次添加进主队列即可。
//写法二
class MyStack {
    private Queue<Integer> a;//输入队列
    private Queue<Integer> b;//输出队列
    
    public MyStack() {
        a = new LinkedList<>();
        b = new LinkedList<>();
    }
    
    //入栈时始终入栈空的那个队列
    public void push(int x) {
        a.offer(x);
        // 将b队列中元素全部转给a队列
        while(!b.isEmpty())
            a.offer(b.poll());
        Queue temp = a;
        a = b;
        b = temp;
    }
    
    //出栈时始终出栈非空的那个队列
    public int pop() {
        return b.poll();
    }
   
    public int top() {
        return b.peek();
    }
    
    public boolean empty() {
        return b.isEmpty();
    }
}



