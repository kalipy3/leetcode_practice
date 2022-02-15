/*
 * 剑指offer59_II.java
 * Copyright (C) 2022 2022-02-15 18:04 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//请直接看代码
class MaxQueue {
    Queue<Integer> q;
    Deque<Integer> d;

    public MaxQueue() {
        q = new LinkedList<Integer>();
        d = new LinkedList<Integer>();
    }
    
    public int max_value() {
        if (d.isEmpty()) {
            return -1;
        }
        return d.peekFirst();
    }
    
    public void push_back(int value) {
        while (!d.isEmpty() && d.peekLast() < value) {
            d.pollLast();
        }
        d.offerLast(value);
        q.offer(value);
    }
    
    public int pop_front() {
        if (q.isEmpty()) {
            return -1;
        }
        int ans = q.poll();
        if (ans == d.peekFirst()) {
            d.pollFirst();
        }
        return ans;
    }
}


