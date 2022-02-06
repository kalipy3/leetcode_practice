/*
 * MainClass374.java
 * Copyright (C) 2022 2022-01-31 16:29 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//kalipy一次过
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int ret = guess(mid);
            if (ret == 0) return mid;
            else if (ret == -1) {
                r = mid - 1;
            } else if (ret == 1) {
                l = mid + 1;
            }
        }

        return l;
    }
}

