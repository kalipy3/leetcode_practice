/*
 * MainClass1109.java
 * Copyright (C) 2022 2022-03-17 13:59 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//kalipy一次过 暴力破解 不推荐
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            for (int j = bookings[i][0] - 1; j <= bookings[i][1] - 1; j++) {
                ans[j] += bookings[i][2];
            }
        }

        return ans;
    }
}



//先看这个题解 链接：https://leetcode-cn.com/problems/corporate-flight-bookings/solution/tong-ge-lai-shua-ti-la-yi-ti-liang-jie-t-0qse/
//评论区 画一画帮助理解吧，我是随便举了个例子[1, 2, 3] [2, 3, 4] [3, 5, 6]，然后第一行标了1 2 3 4 5这几个航班，第二三四行就是 3 3 0 0 0，0 4 4 0 0，0 0 6 6 6，然后想着这个公交车的思路盯了一会就会发现，最终要的结果数组的每个元素值，真的就是当做公交车时每一站车上的人数，然后代码什么也都水到渠成能懂了，大佬是真的牛皮能有这样的思路转换
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // 先计算差分数组，再计算前缀和，注意下标的处理
        int[] arr = new int[n];
        for (int[] booking : bookings) {
            arr[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                arr[booking[1]] -= booking[2];
            }
        }
        
        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
        }
        
        return arr;
    }
}


