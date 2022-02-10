/*
 * MainClass207.java
 * Copyright (C) 2022 2022-02-08 11:41 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//先看这个题解的ppt 链接：https://leetcode-cn.com/problems/course-schedule/solution/tuo-bu-pai-xu-by-liweiwei1419/

// 写法一
public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }

        // 特判
        int pLen = prerequisites.length;
        if (pLen == 0) {
            return true;
        }

        int[] inDegree = new int[numCourses];
        HashSet<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }

        // 想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
        // [0,1] 表示 1 在先，0 在后
        for (int[] p : prerequisites) {
            inDegree[p[0]]++;
            adj[p[1]].add(p[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        // 首先加入入度为 0 的结点
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // 记录已经出队的课程数量
        int cnt = 0;
        while (!queue.isEmpty()) {
            Integer top = queue.poll();
            cnt += 1;
            // 遍历当前出队结点的所有后继结点
            for (int successor : adj[top]) {
                inDegree[successor]--;
                if (inDegree[successor] == 0) {
                    queue.add(successor);
                }
            }
        }
        return cnt == numCourses;
    }
}


// 写法二
class Solution {
    List<List<Integer>> edges;
    int[] indeg;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        indeg = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            ++visited;
            int u = queue.poll();
            for (int v: edges.get(u)) {
                --indeg[v];
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return visited == numCourses;
    }
}
