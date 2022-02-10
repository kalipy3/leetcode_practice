/*
 * MainClass785.java
 * Copyright (C) 2022 2022-02-08 13:00 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//先看这个题解 然后直接看代码：
//链接：https://leetcode-cn.com/problems/is-graph-bipartite/solution/shou-hua-tu-jie-bfs-si-lu-by-hyj8/

/* js 方法一
const isBipartite = (graph) => {
    const visited = new Array(graph.length); // undefined为未染色，1为蓝色，-1为黄色

    for (let i = 0; i < graph.length; i++) { // 遍历每个顶点
        if (visited[i]) continue;            // 已经染过色的，跳过
        const queue = [i];           // 队列初始推入顶点 i
        visited[i] = 1;              // 染为蓝色

        while (queue.length) {       // 遍历顶点 i 所有相邻的顶点
            const cur = queue.shift();           // 考察出列的顶点
            const curColor = visited[cur];       // 出列顶点的颜色
            const neighborColor = -curColor;     // 它的相邻顶点应该有的颜色

            for (let i = 0; i < graph[cur].length; i++) {      // 给他们都上色
                const neighbor = graph[cur][i];
                if (visited[neighbor] == undefined) {          // 还没上色
                    visited[neighbor] = neighborColor;         // 上色
                    queue.push(neighbor);                      // 并推入队列
                } else if (visited[neighbor] != neighborColor) { // 上了不对的颜色
                    return false;
                }
            }
        }
    }
    return true; // 遍历完所有顶点，没有发现哪里不对
};
*/

//java 方法一
class Solution {
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] color;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        Arrays.fill(color, UNCOLORED);
        for (int i = 0; i < n; ++i) {
            if (color[i] == UNCOLORED) {
                Queue<Integer> queue = new LinkedList<Integer>();
                queue.offer(i);
                color[i] = RED;
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    int cNei = color[node] == RED ? GREEN : RED;
                    for (int neighbor : graph[node]) {
                        if (color[neighbor] == UNCOLORED) {
                            queue.offer(neighbor);
                            color[neighbor] = cNei;
                        } else if (color[neighbor] != cNei) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}

//方法二 并查集
class Solution {
    public boolean isBipartite(int[][] graph) {
        // 初始化并查集
        UnionFind uf = new UnionFind(graph.length);
        // 遍历每个顶点，将当前顶点的所有邻接点进行合并
        for (int i = 0; i < graph.length; i++) {
            int[] adjs = graph[i];
            for (int w: adjs) {
                // 若某个邻接点与当前顶点已经在一个集合中了，说明不是二分图，返回 false。
                if (uf.isConnected(i, w)) {
                    return false;
                }
                uf.union(adjs[0], w);
            }
        }
        return true;
    }
}
// 并查集
class UnionFind {
    int[] roots;
    public UnionFind(int n) {
        roots = new int[n]; 
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
    }

    public int find(int i) {
        if (roots[i] == i) {
            return i;
        }
        return roots[i] = find(roots[i]);
    }

    // 判断 p 和 q 是否在同一个集合中
    public boolean isConnected(int p, int q) {
        return find(q) == find(p);
    }

    // 合并 p 和 q 到一个集合中
    public void union(int p, int q) {
        roots[find(p)] = find(q);
    }
}

