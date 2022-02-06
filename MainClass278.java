/*
 * MainClass278.java
 * Copyright (C) 2022 2022-01-31 15:38 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//kalipy一次过
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // 1 2 3 4 5
        int l = 1;
        int r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            boolean ret = isBadVersion(mid);
            if (ret) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
