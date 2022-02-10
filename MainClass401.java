/*
 * MainClass401.java
 * Copyright (C) 2022 2022-02-10 13:08 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//官方题解 枚举
class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<String>();
        for (int h = 0; h < 12; ++h) {
            for (int m = 0; m < 60; ++m) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    ans.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return ans;
    }
}

