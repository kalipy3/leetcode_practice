/*
 * MainClass836.java
 * Copyright (C) 2022 2022-02-08 23:26 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//请看这个题解 非常好 通俗易懂
链接：https://leetcode-cn.com/problems/rectangle-overlap/solution/tu-jie-jiang-ju-xing-zhong-die-wen-ti-zhuan-hua-we/
public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
    boolean x_overlap = !(rec1[2] <= rec2[0] || rec2[2] <= rec1[0]);
    boolean y_overlap = !(rec1[3] <= rec2[1] || rec2[3] <= rec1[1]);
    return x_overlap && y_overlap;
}


