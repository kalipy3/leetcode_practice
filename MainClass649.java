/*
 * MainClass649.java
 * Copyright (C) 2022 2022-02-02 11:32 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//该贪心算法很简单，kalipy就是这么想的

//+n的原因是可以保证当前轮次之后的轮次中议员投票的相对顺序保持不变，我们需要的只是议员的相对投票次序，而不需要绝对准确的投票时间； 因此，取+n和取+10n、+100n的结果都是正确的。 如果增加的时间小于n，可能会出现一个议员执行在一轮中执行多次权利或者本该后执行却先执行的情况。
class Solution {

    /**
     * 思路：
     *  贪心算法：每个R阵营的参议员禁止下一个离他最近的D阵营的参议员，反之亦然。
     * 算法流程：
     *  使用两个队列分别保存R阵营和D阵营的参议员索引，
     *  在每一轮循环中，比较相邻两个R和D阵营的参议员的索引，
     *      保留索引小（min）的，并将该(min + senate.length)添加到该阵营队列尾部
     *      去除索引大的，即不添加到末尾。
     */
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n = senate.length();
        char c;
        for (int i = 0; i < n; i++) {
            c = senate.charAt(i);
            if (c == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int r = radiant.remove();
            int d = dire.remove();
            if (r < d) {
                radiant.offer(r + n);
            } else {
                dire.offer(d + n);
            } 
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
    
}
