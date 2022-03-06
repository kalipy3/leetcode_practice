/*
 * MainClass1353.java
 * Copyright (C) 2022 2022-03-02 20:13 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

/* 评论区
这道题目需要用贪心的思想去考虑，其中贪心的策略是：

    在所有开始时间相同的会议中，我们尽量的去选择结束时间最小的会议，因为结束时间更大的会议的选择天数更多

比如在会议：[[1,1],[1,2],[1,3]] 这三个会议中，如果是在第 1 天的话，我们会尽量的选择 [1,1] 这个会议，因为后面的两个会议，分别可以在第 2 天和第 3 天选择，选择的范围更广

只有这样选择，才可以得到能参加更多的会议

所以，这里我们需要能快速的选择结束时间最小的会议，而且这个最小的结束时间是动态变化的，因为参加了一个会议，就应该排除这个会议

高效的维护动态数据的最小值，我们想到了小顶堆了。

所以，这道题的算法步骤是这样：

    1. 首先，对会议按照开始时间升序排列，排序的目的是为了可以方便的一起选择开始时间相同的会议
    2. 然后从第 1 天开始，依次判断每一天是否可以参加会议，记当天为 currDay ，从第 1 天开始
    3. 顺序遍历会议，将开始时间等于 currDay 的会议的结束时间放入小顶堆
    4. 将堆顶结束时间小于 currDay 的会议从堆中删除，这些会议都是过时的，参加不到的会议
    5. 如果堆不为空，则选择会议结束时间最小的会议参加，表示 currDay 这一天可以参加会议
    6. currDay 往后走一天，判断下一天是否可以参加会议

*/

// 评论区
public int maxEvents(int[][] events) {
    int n = events.length;
    // 按照开始时间升序排列，这样，对于相同开始时间的会议，可以一起处理
    Arrays.sort(events, new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    });

    // 小顶堆：用于高效的维护最小的 endDay
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int res = 0;
    int currDay = 1;
    int i = 0;
    while (i < n || !pq.isEmpty()) {
        // 将所有开始时间等于 currDay 的会议的结束时间放到小顶堆
        while (i < n && events[i][0] == currDay) {
            pq.add(events[i][1]);
            i++;
        }

        // 将已经结束的会议弹出堆中，即堆顶的结束时间小于 currDay 的
        while (!pq.isEmpty() && pq.peek() < currDay) {//eg:[[1,2],[1,2],[1,2]]
            pq.remove();
        }

        // 贪心的选择结束时间最小的会议参加
        if (!pq.isEmpty()) {
            // 参加的会议，就从堆中删除
            pq.remove();
            res++;
        }

        // 当前的天往前走一天，开始看下下一天能不能参加会议
        currDay++;
    }

    return res;
}
