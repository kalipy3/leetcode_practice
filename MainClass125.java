//请直接看代码 送分题
class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
}

//写法二
/*
class Solution {
public:
    bool isPalindrome(string s) {
        string str = "";
        // 把原有字符串全部变为小写
        for (int i =0; i < s.length(); i++)
        {
            if (s[i] >= 'A' && s[i] <= 'Z')
            {
                s[i] += 32;
            }
        }
        // 再把原有字符串的所有字符数字放到新的字符串中
        for (int i = 0; i < s.length(); i++)
        {
            if ((s[i] >= 'a' && s[i] <= 'z') || (s[i] >= '0' && s[i] <= '9'))
            {
                str += s[i];
            }
        }

        // 最后判断是不是回文串
        int front = 0;
        int end = str.length()-1;
        while (front != str.length())
        {
            if (str[front] != str[end])
            {
                return false;
            }
            front++;
            end--;
        }
        return true;

    }
};

*/
