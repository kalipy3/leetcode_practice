//kalipy暴力破解一次过
//方法一
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        boolean ans = false;
        for (int i = 0; i < s.length()/2; i++) {
            int step = i+1;
            String str = s.substring(0, step);
            ans = true;
            for (int j = step; j < s.length(); j+=step) {
                if(j+step<=s.length() && s.substring(j, j+step).equals(str)) {
                    continue;
                } else {
                    ans = false;
                }
            }
            if (ans) return true;
        }
        return ans;
    }
}

//方法二
//作者：13217319563
//链接：https://leetcode-cn.com/problems/repeated-substring-pattern/solution/jian-dan-ming-liao-guan-yu-javaliang-xing-dai-ma-s/
//
//为什么要去头尾？
//整个过程其实就是模仿旋转的过程。头部是没开始旋转，到了尾部是旋转了一圈回到了初始状态。这两种情况都是原字符串，肯定不能考虑的呀
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }
}

//方法三
用kmp自己实现字符串匹配
