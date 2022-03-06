/*
 * MainClass149.java
 * Copyright (C) 2022 2022-02-17 15:44 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//先看这个题解 链接：https://leetcode-cn.com/problems/max-points-on-a-line/solution/gong-shui-san-xie-liang-chong-mei-ju-zhi-u44s/
//方法一 暴力破解 送分题
class Solution {
    public int maxPoints(int[][] ps) {
        int n = ps.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            int[] x = ps[i];
            for (int j = i + 1; j < n; j++) {
                int[] y = ps[j];
                int cnt = 2;
                for (int k = j + 1; k < n; k++) {
                    int[] p = ps[k];
                    int s1 = (y[1] - x[1]) * (p[0] - y[0]);//直线的两点式方程(y-y1)/(x-x1)=(y-y2)/(x-x2)，再对角相乘就可以了
                    int s2 = (p[1] - y[1]) * (y[0] - x[0]);
                    if (s1 == s2) cnt++;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}
//(y2-y1)/(x2-x1) = (y3-y1)/(x3-x1)
//(y[1]-x[1])/(y[0]-x[0]) = (k[1]-x[1])/(k[0]-x[0])


//方法二
class Solution {
    public int maxPoints(int[][] ps) {
        int n = ps.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            // 由当前点 i 发出的直线所经过的最多点数量
            int max = 0;
            for (int j = i + 1; j < n; j++) {
                int x1 = ps[i][0], y1 = ps[i][1], x2 = ps[j][0], y2 = ps[j][1];
                int a = x1 - x2, b = y1 - y2;
                int k = gcd(a, b);
                String key = (a / k) + "_" + (b / k);
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            ans = Math.max(ans, max + 1);
        }
        return ans;
    }
    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

