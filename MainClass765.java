/*
 * MainClass765.java
 * Copyright (C) 2022 2022-02-08 16:24 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//先看这个题解 
//链接：https://leetcode-cn.com/problems/couples-holding-hands/solution/qing-lu-qian-shou-by-leetcode-gl1c/
public class Solution {

    public int minSwapsCouples(int[] row) {
        int len = row.length;
        int N = len / 2;
        UnionFind unionFind = new UnionFind(N);
        for (int i = 0; i < len; i += 2) {
            unionFind.union(row[i] / 2, row[i + 1] / 2);
        }
        return N - unionFind.getCount();
    }

    private class UnionFind {

        private int[] parent;

        private int count;

        public int getCount() {
            return count;
        }

        public UnionFind(int n) {
            this.count = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            parent[rootX] = rootY;
            count--;
        }
    }
}

//写法二
 class Solution {
    int[] p = new int[70];
    void union(int a, int b) {
        p[find(a)] = p[find(b)];
    }
    int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
    public int minSwapsCouples(int[] row) {
        int n = row.length, m = n / 2;
        for (int i = 0; i < m; i++) p[i] = i;
        for (int i = 0; i < n; i += 2) union(row[i] / 2, row[i + 1] / 2);
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            if (i == find(i)) cnt++;
        }
        return m - cnt;
    }
}

//方法二 贪心 也通俗易懂
//链接：https://leetcode-cn.com/problems/couples-holding-hands/solution/tan-xin-suan-fa-shi-qing-lu-qian-shou-bi-eeel/
//写法一
/*
class Solution(object):
    def minSwapsCouples(self, row):
        """
        :type row: List[int]
        :rtype: int
        """
        N = len(row)
        res = 0
        for i in range(0, N - 1, 2):
            if row[i] == row[i + 1] ^ 1:
                continue
            for j in range(i + 1, N):
                if row[i] == row[j] ^ 1:
                    row[i + 1], row[j] = row[j], row[i + 1]
            res += 1
        return res
*/

//写法二 优化查找速度
class Solution {
    public int minSwapsCouples(int[] row) {
        int ans = 0;
        int[] pos = new int[row.length];

        for (int i = 0; i < pos.length; i++) {
            pos[row[i]] = i;  //每个人对应的位置
        }

        for (int i = 0; i < pos.length; i += 2) {
            int pairPerson = row[i] ^ 0x1;  //i号位置的情侣应该是谁
            if (row[i + 1] == pairPerson) {
                continue;  //右边是情侣，直接继续处理下一个。
            }
            
            int nextPerson = row[i + 1]; //右边不是情侣，得到右边的人是谁
            int changePos = pos[pairPerson]; //得到情侣的位置在哪
            
            row[changePos] = nextPerson; //交换后，情侣位置坐上了右边的人nextPerson
            pos[nextPerson] = changePos; //交换后，右边人nextPerson的位置发生了改变，记录下来。
            ans++;
        }

        return ans;
    }
}

