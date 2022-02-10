//先看十进制的
string addStrings(string num1, string num2)
{
    int carry = 0;
    int i = num1.size() - 1, j = num2.size() - 1;
    string res;
    while (i >= 0 || j >= 0 || carry)
    {
        int x = i >= 0 ? num1[i] - '0' : 0;
        int y = j >= 0 ? num2[j] - '0' : 0;
        int temp = x + y + carry;
        res += '0' + temp % 10;
        carry = temp / 10;
        i--, j--;
    }
    reverse(res.begin(), res.end());
    return res;
}

36进制由0-9，a-z，共36个字符表示。
要求按照加法规则计算出任意两个36进制正整数的和，如1b + 2x = 48  （解释：47+105=152）

掌握十进制的大数相加后，那本题只需要注意将10变成36，以及36进制字符与数值的转换。这里，我使用了getChar(int n)和getInt(char ch)两个辅助函数来完成36进制字符与数值的转换。


参考代码:
#include <iostream>
#include <algorithm>
using namespace std;

char getChar(int n)
{
    if (n <= 9)
        return n + '0';
    else
        return n - 10 + 'a';
}
int getInt(char ch)
{
    if ('0' <= ch && ch <= '9')
        return ch - '0';
    else
        return ch - 'a' + 10;
}
string add36Strings(string num1, string num2)
{
    int carry = 0;
    int i = num1.size() - 1, j = num2.size() - 1;
    int x, y;
    string res;
    while (i >= 0 || j >= 0 || carry)
    {
        x = i >= 0 ? getInt(num1[i]) : 0;
        y = j >= 0 ? getInt(num2[j]) : 0;
        int temp = x + y + carry;
        res += getChar(temp % 36);
        carry = temp / 36;
        i--, j--;
    }
    reverse(res.begin(), res.end());
    return res;
}

int main()
{
    string a = "1b", b = "2x", c;
    c = add36Strings(a, b);
    cout << c << endl;
}
