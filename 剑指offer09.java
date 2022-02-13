/*
 * 剑指offer09.java
 * Copyright (C) 2022 2022-02-12 11:15 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//请直接看代码 送分题
class CQueue {
    Deque<Integer> st1 = new LinkedList<>();
    Deque<Integer> st2 = new LinkedList<>();

    public CQueue() {

    }
    
    public void appendTail(int value) {
        st1.push(value);
    }
    
    public int deleteHead() {
        int head = -1;

        if (st2.size() == 0) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
        if (!st2.isEmpty()) {
            head = st2.pop();
        }


        return head;
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
