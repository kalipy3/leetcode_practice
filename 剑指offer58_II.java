/*
 * 剑指offer58_II.java
 * Copyright (C) 2022 2022-02-11 12:33 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//送分题

//链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/solution/mian-shi-ti-58-ii-zuo-xuan-zhuan-zi-fu-chuan-qie-p/
class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}



//方法二
/*
思路:

三次反转是个经典解法。技巧性很强。

例如：输入: s = "abcdefg", k = 2
"abcdefg" 反转前2个字符 "bacdefg"
"bacdefg" 反转后5个字符 "bagfedc"
"bagfedc" 反转整个字符串 "cdefgab"

class Solution {
public:
    string reverseLeftWords(string s, int n) {
        reverse(s.begin(),s.begin()+n);
        reverse(s.begin()+n,s.begin()+s.size());
        reverse(s.begin(),s.end());
        return s;
    }
};
*/


//方法二 写法二
class Solution {
    public String reverseLeftWords(String s, int n) {
        int len=s.length();
        StringBuilder sb=new StringBuilder(s);
        reverseString(sb,0,n-1);
        reverseString(sb,n,len-1);
        return sb.reverse().toString();
    }
     public void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
            }
        }
}
