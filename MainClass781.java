/*
 * MainClass781.java
 * Copyright (C) 2022 2022-02-09 13:50 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//请先看官方题解 kalipy差点一次想出这个方法
class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int y : answers) {
            count.put(y, count.getOrDefault(y, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int y = entry.getKey(), x = entry.getValue();
            ans += (x + y) / (y + 1) * (y + 1);//(x + (y - 1)) / y 是x/y向上取整，把y换y+1变为：(x + y) / (y + 1)，就是x/(y+1)的向上取整
        }
        return ans;
    }
}

