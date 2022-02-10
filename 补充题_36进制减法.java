https://mp.weixin.qq.com/s/ub9GpTBjDF55hZld3V2rEA

题目描述

36进制由0-9，a-z，共36个字符表示。

要求按照减法规则计算出任意两个36进制正整数的差，如48-2x =1b  （解释：152-105=47）

要求：不允许使用先将36进制数字整体转为10进制，相减后再转回为36进制的做法
题目分析

在掌握这道题之前，一定要去熟悉下我上次写的十进制的大数相减呀~

本题在原来的基础上只需修改几行代码即可！

以下是36进制减法核心sub函数的代码。

string sub(string a, string b) {
    string res = "";
    int borrow = 0;
    int i = a.size() - 1, j = b.size() - 1;
    while (i >= 0 || j >= 0) {
        int x = i >= 0 ? getInt(a[i]) : 0; //第1处
        int y = j >= 0 ? getInt(b[j]) : 0; //第2处
        int z = (x - borrow - y + 36) % 36; //第3处
        res += getChar(z); //第4处
        borrow = x - borrow - y < 0 ? 1 : 0;
        i--, j--;
    }
    reverse(res.begin(), res.end());
    //删除前导0。注意：循环条件是res.size()-1是为防止"0000"的情况
    int pos;
    for (pos = 0; pos < res.size() - 1; pos++) {
        if (res[pos] != '0') break;
    }
    return res.substr(pos);
}

细心的同学可以看到，与大数相减的sub函数相比，只改动了4处代码

    1. int x = i >= 0 ? getInt(a[i]) : 0：十进制大数相减时字符转整数是a[i] - '0'，36进制时需要实现单独的字符转换整数的getInt函数。

    2. int y = j >= 0 ? getInt(b[j]) : 0;，与1同理。

    3. int z = (x - borrow - y + 36) % 36：十进制减法时是(x - borrow - y + 10) % 10，36进制需要改成36，这应该不难理解。

    4. res += getChar(z);：每一位减完的数需要转成对应的字符，36进制不能再使用('0' + z)了，需要额外实现整数转字符的getChar函数函数。

接下来，再实现上边所说的getInt函数和getChar函数就可以了。

char getChar(int n) {
    if (n <= 9) return n + '0';
    else return n - 10 + 'a';
}
int getInt(char ch) {
    if ('0' <= ch && ch <= '9') return ch - '0';
    else return ch - 'a' + 10;
}

打完收工~

下面附上C++版的完整代码。

参考代码

#include <iostream>
#include <algorithm>
using namespace std;

char getChar(int n) {
    if (n <= 9) return n + '0';
    else return n - 10 + 'a';
}

int getInt(char ch) {
    if ('0' <= ch && ch <= '9') return ch - '0';
    else return ch - 'a' + 10;
}

string sub(string a, string b) {
    string res = "";
    int borrow = 0;
    int i = a.size() - 1, j = b.size() - 1;
    while (i >= 0 || j >= 0) {
        int x = i >= 0 ? getInt(a[i]) : 0;
        int y = j >= 0 ? getInt(b[j]) : 0;
        int z = (x - borrow - y + 36) % 36;
        res += getChar(z);
        borrow = x - borrow - y < 0 ? 1 : 0;
        i--, j--;
    }
    reverse(res.begin(), res.end());
    //删除前导0。注意：循环条件是res.size()-1是为防止"0000"的情况
    int pos;
    for (pos = 0; pos < res.size() - 1; pos++) {
        if (res[pos] != '0') break;
    }
    return res.substr(pos);
}

bool isLess(string a, string b) {
    if (a.size() == b.size()) return a < b;
    return a.size() < b.size();
}

string subStrings(string num1, string num2) {
    string res;
    if (isLess(num1, num2)) {
        res = sub(num2, num1);
        res.insert(0, "-");
    }
    else res = sub(num1, num2);
    return res;
}

int main() {
    string a, b;
    cin >> a >> b;
    cout << subStrings(a, b) << endl;
    return 0;
}

