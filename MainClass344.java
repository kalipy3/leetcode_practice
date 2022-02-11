/*
 * MainClass344.java
 * Copyright (C) 2022 2022-02-11 12:47 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//索然无味 无语提
class Solution {
    char temp = 0;
    public void reverseString(char[] s) {
        reverse(s, 0, s.length-1);

    }

    public void reverse(char[]s, int left, int right) {
        // 返回条件
        if (left>=right) {
            return;
        }

        // 递之前
        temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        // 递下去
        reverse(s, left+1, right-1);

        // 归回来
        // Do nothing.

    }
}


