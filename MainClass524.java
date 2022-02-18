/*
 * MainClass524.java
 * Copyright (C) 2022 2022-02-16 20:04 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//kalipy差点一次过
//请直接看这个题解 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/solution/gong-shui-san-xie-xiang-jie-pai-xu-shuan-qi20/
class Solution {
    public String findLongestWord(String s, List<String> list) {
        Collections.sort(list, (a,b)->{
            if (a.length() != b.length()) return b.length() - a.length();
            return a.compareTo(b);
        });
        int n = s.length();
        for (String ss : list) {
            int m = ss.length();
            int i = 0, j = 0;
            while (i < n && j < m) {
                if (s.charAt(i) == ss.charAt(j)) j++;
                i++;
            }
            if (j == m) return ss;
        }
        return "";
    }
}


