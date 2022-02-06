/*
 * MainClass389.java
 * Copyright (C) 2022 2022-01-30 15:50 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//kalipy一次过
class Solution {
    public char findTheDifference(String s, String t) {
        char[] cs = (s+t).toCharArray();

        char c = cs[0];
        for (int i = 1; i < cs.length; i++) {
            c ^= cs[i];
        }

        return c;
    }
}

//方法二 官方
class Solution {
    public char findTheDifference(String s, String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            cnt[ch - 'a']++;
        }
        for (int i = 0; i < t.length(); ++i) {
            char ch = t.charAt(i);
            cnt[ch - 'a']--;
            if (cnt[ch - 'a'] < 0) {
                return ch;
            }
        }
        return ' ';
    }
}

//方法三 不推荐 如果long都存不下数据溢出呢
//将字符串 s 中每个字符的 ASCII 码的值求和，得到 As；对字符串 t 同样的方法得到 At。两者的差值 At−As即代表了被添加的字符。

class Solution {
    public char findTheDifference(String s, String t) {
        int as = 0, at = 0;
        for (int i = 0; i < s.length(); ++i) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }
}


