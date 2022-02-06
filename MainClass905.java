/*
 * MainClass905.java
 * Copyright (C) 2022 2022-02-03 14:23 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//kalipy一次过
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        int i = 0, j = n - 1;
        for(int k = 0; k < n; k++) {
            if(A[k] % 2 == 0) {
              ans[i++] = A[k];
            }else {
              ans[j--] = A[k];
            }
        }
        return ans;
    }
}
