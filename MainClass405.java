/*
 * MainClass405.java
 * Copyright (C) 2022 2022-02-16 23:00 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
链接：https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/solution/gong-shui-san-xie-yi-ti-shuang-jie-jin-z-d93o/
//方法一 不推荐
class Solution {
    public String toHex(int _num) {
        if (_num == 0) return "0";
        long num = _num;
        StringBuilder sb = new StringBuilder();
        if(num < 0) num = (long)(Math.pow(2, 32) + num);
        while (num != 0) {
            long u = num % 16;
            char c = (char)(u + '0');
            if (u >= 10) c = (char)(u - 10 + 'a');
            sb.append(c);
            num /= 16;
        }
        return sb.reverse().toString();
    }
}



//方法二
//推荐
链接：https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/solution/gong-shui-san-xie-yi-ti-shuang-jie-jin-z-d93o/
class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int u = num & 15;
            char c = (char)(u + '0');
            if (u >= 10) c = (char)(u - 10 + 'a');
            sb.append(c);
            num >>>= 4;
        }
        return sb.reverse().toString();
    }
}


