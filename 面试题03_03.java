/*
 * 面试题03_03.java
 * Copyright (C) 2022 2022-02-13 10:54 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

/*
题目意思解释：

输入：
["StackOfPlates", "push", "push", "push", "popAt", "popAt", "popAt"]
[[2], [1], [2], [3], [0], [0], [0]]

“StackOfPlates” [2] 表示每堆盘子最高2个，再次push就要另添加一个栈来放盘子

"push" [1] 堆盘子1（第一堆有一个盘子1）

"push" [2] 堆盘子2（第一堆有两个盘子1，2）

"push" [3] 堆盘子3（第一堆已经有两个盘子了，达到_capcity，另起一堆，第二堆有一个盘子3）

“popAt” [0] 弹出指定堆（第一堆）的顶层盘子2

“popAt” [0] 弹出指定堆（第一堆）的顶层盘子1（此时第一堆没有盘子了，记得删除这一堆，原来的第二堆变成现在的第一堆）

“popAt” [0] 弹出指定堆（第一堆）的顶层盘子3
*/

//请直接看注释和代码 简单题
//思路
//
//    1.新建一个List<Stack<Integer>>用来存放各个栈，而且栈的个数是动态变化的。
//    2.push的时候，可能需要新建一个栈，或者直接插入到最后一个栈中。
//    3.pop直接调用popAt方法。其中popAt方法需要处理的是弹出指定位置栈的栈顶元素。我们可以通过list拿到指定index的栈，拿到之后执行stack的pop操作即可。同时如果弹出栈顶元素之后，当前stack变成空了，需要将当前stack从list中移除。
class StackOfPlates {

        private List<Stack<Integer>> stackList;
        private int cap;

        public StackOfPlates(int cap) {
            stackList = new ArrayList<>();
            this.cap = cap;
        }

        public void push(int val) {
            if (cap <= 0) {
                return;
            }

            if (stackList.isEmpty() || stackList.get(stackList.size() - 1).size() == cap) {
                Stack<Integer> stack = new Stack<>();
                stack.push(val);
                stackList.add(stack);
                return;
            }

            stackList.get(stackList.size() - 1).push(val);
        }

        public int pop() {
            return popAt(stackList.size() - 1);
        }

        public int popAt(int index) {
            if (index < 0 || index >= stackList.size()) {
                return -1;
            }

            Stack<Integer> stack = stackList.get(index);
            if (stack.isEmpty()) {
                return -1;
            }

            int res = stack.pop();

            if (stack.isEmpty()) {
                stackList.remove(index);
            }

            return res;
        }
    }


