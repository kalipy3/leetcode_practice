//方法一 请直接看代码,直到看懂为止
class Solution {
    public int longestSubarray(int[] nums, int limit) {

        PriorityQueue<Integer> minQueue = new PriorityQueue<>(Comparator.naturalOrder());
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());

        int left = 0;
        int right = 0;
        int ans = 0;
        while (right < nums.length && left < nums.length) {
            minQueue.add(nums[right]);
            maxQueue.add(nums[right]);

            if (maxQueue.peek() - minQueue.peek() <= limit) {
                ans = Math.max(ans, right - left + 1);
                right++;
                continue;
            }

            maxQueue.remove((Integer) nums[left]);
            minQueue.remove((Integer) nums[left]);
            left++;
            right++;
        }
        return ans;
    }
}

//方法二
//显然，使用滑动窗口，维护当前窗口的的最大值和最小值是解决这个问题的关键。
//
//既然是维护，那就要考虑，当窗口扩大时，那来一个新的值是很容易知道是否是最大值或者是最小值，即维护起来是简单直观的。 但是，当窗口减小时，假如从窗口出去的是最大值，或者是最小值，那么窗口缩小以后的最小值或者最大值是啥呢。所以相对窗口增大再次判断最值不容易想出来。
//
//实际上，这个维护窗口的最值问题，是一个非常经典的问题，归纳出来一种普遍认为比较好用的方法，就是使用单调队列。 因为单调队列保持了队列中元素之间的固有的顺序，同时也维护了单调性。这样，当窗口减小时，我们非常容易知道下一个最值是多少。
//
//但是，单调队列只能维护一种单调性，而题目又要求我们同时考虑最大值和最小值的差，所以就用两个呗，后边的解决方法也就顺其自然了。
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> queMax = new LinkedList<Integer>();
        Deque<Integer> queMin = new LinkedList<Integer>();
        int n = nums.length;
        int left = 0, right = 0;
        int ret = 0;
        
        while (right < n) {
            while (!queMax.isEmpty() && queMax.peekLast() < nums[right]) {
                queMax.pollLast();
            }
            while (!queMin.isEmpty() && queMin.peekLast() > nums[right]) {
                queMin.pollLast();
            }
            queMax.offerLast(nums[right]);
            queMin.offerLast(nums[right]);
            while (!queMax.isEmpty() && !queMin.isEmpty() && queMax.peekFirst() - queMin.peekFirst() > limit) {
                if (nums[left] == queMin.peekFirst()) {
                    queMin.pollFirst();
                }
                if (nums[left] == queMax.peekFirst()) {
                    queMax.pollFirst();
                }
                left++;
            }
            ret = Math.max(ret, right - left + 1);
            right++;
        }
        return ret;
    }
}


