/*
 * MainClass424.java
 * Copyright (C) 2022 2022-03-14 10:38 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//请先看这个题解 很好懂
//链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement/solution/tong-guo-ci-ti-liao-jie-yi-xia-shi-yao-shi-hua-don/
class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null) {
            return 0;
        }
        int[] map = new int[26];
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int historyCharMax = 0;
        for (right = 0; right < chars.length; right++) {
            int index = chars[right] - 'A';
            map[index]++;
            //这个题的关键点就是我们如何判断一个字符串改变 K 个字符，能够变成一个连续串
            //如果当前字符串中的出现次数最多的字母个数 +K 大于串长度，那么这个串就是满足条件的
            historyCharMax = Math.max(historyCharMax, map[index]);
            if (right - left + 1 > historyCharMax + k) {
                map[chars[left] - 'A']--;
                left++;
            }
        }
        return chars.length - left;
    }
}

//写法二 推荐
class Solution {
    public int characterReplacement(String s, int k) {
        int[] num = new int[26];
        int n = s.length();
        int maxn = 0;
        int left = 0, right = 0;
        while (right < n) {
            num[s.charAt(right) - 'A']++;
            maxn = Math.max(maxn, num[s.charAt(right) - 'A']);
            if (right - left + 1 > maxn + k) {
                num[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }
}

//kalipy一次过
class Solution {
    public int characterReplacement(String s, int k) {
        
        int l = 0;
        int r = 0;
        int n = s.length();
        int ans = 0;
        int[] map = new int[26];
        int max = 0;
        while (r < n) {
            map[s.charAt(r) - 'A']++;
            max = Math.max(max, map[s.charAt(r) - 'A']);
            if (r - l + 1 > max + k) {
                map[s.charAt(l) - 'A']--;
                l++;
            }

            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return ans;
    }
}
