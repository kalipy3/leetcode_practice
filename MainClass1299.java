/*
 * MainClass1299.java
 * Copyright (C) 2022 2022-02-03 15:59 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//kalipy丢人一次过
class Solution {
    public int[] replaceElements(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int max = 0;
            for (int j = i + 1; j < arr.length; j++) {
                max = Math.max(max, arr[j]);
            }
            arr[i] = max;
        }

        arr[arr.length-1] = -1;

        return arr;
    }
}

//方法二 评论区 请直接看代码 简单
//原地修改数组即可，从后往前扫数组记录最大值。
public int[] replaceElements(int[] arr) {

    int curMax = -1;
    for (int i = arr.length - 1; i >= 0; i--) {

        int curVal = arr[i];
        arr[i] = curMax;
        curMax = Math.max(curMax, curVal);
    }

    return arr;        
}

