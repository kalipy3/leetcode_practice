/*
 * MainClass168.java
 * Copyright (C) 2022 2022-02-08 22:37 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//本质是26进制计算
//链接：https://leetcode-cn.com/problems/excel-sheet-column-title/solution/gong-shui-san-xie-cong-1-kai-shi-de-26-j-g2ur/
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while (columnNumber != 0) {
            columnNumber--;
            sb.append((char)(columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}


