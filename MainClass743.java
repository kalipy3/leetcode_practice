/*
 * MainClass743.java
 * Copyright (C) 2022 2022-02-08 13:28 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//官方题解 和正月点灯笼的dfs优先队列版差不多
//代码很好懂
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE / 2;
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; ++i) {
            g[i] = new ArrayList<int[]>();
        }
        for (int[] t : times) {
            int x = t[0] - 1, y = t[1] - 1;
            g[x].add(new int[]{y, t[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[k - 1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        pq.offer(new int[]{0, k - 1});//eg:到达k-1节点说需要的时间为0
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int time = p[0], x = p[1];
            if (time > dist[x]) {//优化，因为这里没有设置访问数组，所以有重复节点入队列，如果后续对已经在队列中的节点的time进行了更新，那么之前队列中该节点存储的time值就失效了
                continue;
            }
            for (int[] e : g[x]) {
                int y = e[0], d = dist[x] + e[1];
                if (d < dist[y]) {
                    dist[y] = d;
                    pq.offer(new int[]{d, y});
                }
            }
        }

        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? -1 : ans;
    }
}

