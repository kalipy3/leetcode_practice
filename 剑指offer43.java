/*
 * 剑指offer43.java
 * Copyright (C) 2022 2022-02-17 19:54 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
本题和233题一样
// 方法一 推荐 可以看懂 链接：https://leetcode-cn.com/problems/number-of-digit-one/solution/gong-shui-san-xie-jiang-shu-wei-dp-wen-t-c9oi/
class Solution {
    public int countDigitOne(int n) {
        String s = String.valueOf(n);
        int m = s.length();
        if (m == 1) return n > 0 ? 1 : 0;
        // 计算第 i 位前缀代表的数值，和后缀代表的数值
        // 例如 abcde 则有 ps[2] = ab; ss[2] = de
        int[] ps = new int[m], ss = new int[m];
        ss[0] = Integer.parseInt(s.substring(1));
        for (int i = 1; i < m - 1; i++) {
            ps[i] = Integer.parseInt(s.substring(0, i));
            ss[i] = Integer.parseInt(s.substring(i + 1));
        }
        ps[m - 1] = Integer.parseInt(s.substring(0, m - 1));
        // 分情况讨论
        int ans = 0;
        for (int i = 0; i < m; i++) {
            // x 为当前位数值，len 为当前位后面长度为多少
            int x = s.charAt(i) - '0', len = m - i - 1;
            int prefix = ps[i], suffix = ss[i];
            int tot = 0;
            tot += prefix * Math.pow(10, len);
            if (x == 0) {
            } else if (x == 1) {
                tot += suffix + 1;
            } else {
                tot += Math.pow(10, len);
            }
            ans += tot;
        }
        return ans;
    }
}

//方法二
 //分别计算个、十、百......千位上1出现的次数，再求和。
 /*
 class Solution {
public:
    int countDigitOne(int n) {
        long cnt = 0, i = 1, num = n; 
        while(num) {
            if(num%10 == 0) cnt += (num/10)*i; //个
            if(num%10 == 1) cnt += (num/10)*i+(n%i)+1; //十
            if(num%10 > 1) cnt += ceil(num/10.0)*i;
            num /= 10;
            i *= 10;
        }
        return cnt;
    }
};
*/

