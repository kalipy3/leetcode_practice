/*
 * MainClass452.java
 * Copyright (C) 2022 2022-02-16 12:19 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//写法一 line17行会有问题
//最近新增了Test Case， [[-2147483646,-2147483645],[2147483646,2147483647]] 就过不了了，这是因为差值过大而产生溢出。sort的时候不要用a-b来比较，要用Integer.compare(a, b)!!!
class Solution {
    public int findMinArrowShots(int[][] points) {
        /**
        我特么射爆!!!!!!! \(^o^)/
        
        贪心法, 每个气球只少需要一支箭, 先按照右端点排序, 然后每次
        从最小的右端点射出一支箭, 去掉被射爆的气球, 重复该过程. 
        **/
        if(points.length < 1) return 0;
        Arrays.sort(points, (a, b) -> (a[1] - b[1]));//line17
        int count = 1;
        int axis = points[0][1];
        
        for(int i = 1; i < points.length; ++i) {
            if(axis < points[i][0]) {
                count++;
                axis = points[i][1];
            }
        }
        
        return count;
    }
}

//写法二 ok

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon: points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }
}

