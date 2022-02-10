/*
 * MainClass223.java
 * Copyright (C) 2022 2022-02-09 17:51 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
https://leetcode-cn.com/problems/rectangle-area/solution/acmjin-pai-ti-jie-mo-ni-bian-cheng-xiong-o9ep/
int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
    int area = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);

    int overlapLong = max(0, min(ax2, bx2) - max(ax1, bx1));
    int overlapWidth = max(0, min(ay2, by2) - max(ay1, by1));

    return area - overlapLong * overlapWidth;
}
