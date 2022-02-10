两种方法都好理解


//作者：jiang-hui-4
//链接：https://leetcode-cn.com/problems/sliding-window-maximum/solution/you-xian-dui-lie-zui-da-dui-dan-diao-dui-dbn9/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//方法一
public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    //这里我们传入了一个比较器，当两者的值相同时，比较下标的位置，下标大的在前面。
    PriorityQueue<int[]> queue = new PriorityQueue<>((p1, p2) -> p1[0] != p2[0] ? p2[0] - p1[0] : p2[1] - p1[1]);
    //初始化前K的元素到堆中
    for (int i = 0; i < k; i++) {
        queue.offer(new int[]{nums[i], i});
    }
    //有n-k+1个
    int[] ans = new int[n - k + 1];
    //将第一次答案加入数据
    ans[0] = queue.peek()[0];
    for (int i = k; i < n; i++) {
        //将新元素加入优先队列
        queue.offer(new int[]{nums[i], i});
        //循环判断当前队首是否在窗口中，窗口的左边界为i-k
        while (queue.peek()[1] <= i - k) {
            queue.poll();
        }
        //在窗口中直接赋值即可
        ans[i - k + 1] = queue.peek()[0];
    }
    return ans;
}

//方法二
public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    //创建双端队列
    Deque<Integer> deque = new ArrayDeque<>();
    //先初始化前K个元素
    for (int i = 0; i < k; i++) {
        //判断队列是否为空 或者当前入队元素是否大于队尾元素 大于则出队
        while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
            deque.pollLast();
        }
        //当前元素入队
        //由于需要判断当前元素是否在窗口中，所以实际上队列中存储的为当前元素的下标
        //根据下标找元素比根据元素找下标方便
        deque.offerLast(i);
    }
    int[] ans = new int[n - k + 1];
    //添加当前最大元素
    ans[0] = nums[deque.peekFirst()];
    for (int i = k; i < n; i++) {
        //判断队列是否为空 或者当前入队元素是否大于队尾元素 大于则出队
        while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
            deque.pollLast();
        }
        //当前元素入队
        deque.offerLast(i);
        //判断队首元素是否在窗口中
        while (deque.peekFirst() <= i - k) {
            deque.pollFirst();
        }
        //添加答案
        ans[i - k + 1] = nums[deque.peekFirst()];
    }
    return ans;
}



