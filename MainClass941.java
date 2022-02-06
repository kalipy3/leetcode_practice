/*
 * MainClass941.java
 * Copyright (C) 2022 2022-02-03 14:16 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//kalipy一次过
class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;

        int n = arr.length;
        int i = 0;

        for (i = 1; i < n; i++) {
            if (arr[i] > arr[i-1]) {
                continue;
            } else if (arr[i] == arr[i-1]) return false;
            if (arr[i] < arr[i-1]) {
                break;
            }
        }

        if (i == 1) return false;
        for (int j = i; j < n-1; j++) {
            if (arr[j] <= arr[j+1]) return false;
        }

        return i == n ? false : true;
    }
}
