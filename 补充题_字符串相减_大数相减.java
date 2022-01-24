https://mp.weixin.qq.com/s?__biz=MzkxNDI1MTA1MA==&mid=2247484424&idx=1&sn=be2a24dcce2996c34e12ab36f21e80f4&source=41#wechat_redirect

//题目描述
//
//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的差。
//
//    注意：
//
//        num1 和num2 都只会包含数字 0-9
//        num1 和num2 都不包含任何前导零
//        你不能使用任何內建 BigInteger 库
//


题目分析

两个非负整数相减的结果可能为负。

因此，首先比较两个数的大小。

如代码所示，当小减大时，需将两个参数调换一下位置执行减法，在结果前填上负号即可

注意：结果为0时不加负号。

string subStrings(string num1, string num2) {
    string res;
    if (isLess(num1, num2)) {
        res = sub(num2, num1);
        if (res != "0") res.insert(0, "-");
    }
    else res = sub(num1, num2);
    return res;
}


如何比较两个大数的大小呢？

由于是大数，肯定不能直接转成int比较。

我们可以比较两个字符串的长度。

长度更长的字符串，数一定更大；当长度一样的就去比较字典序。

bool isLess(string a, string b) {
    if (a.size() == b.size()) return a < b;
    return a.size() < b.size();
}

大体框架写完了，接下来实现关键的sub函数。

我推荐下边这种实现。


string sub(string a, string b) {
    string res = "";
    int borrow = 0;
    int i = a.size() - 1, j = b.size() - 1;
    while (i >= 0 || j >= 0) {
        int x = i >= 0 ? (a[i] - '0') : 0; //字符转整数
        int y = j >= 0 ? (b[j] - '0') : 0; //字符转整数
        int z = (x - borrow - y + 10) % 10;
        res += ('0' + z); //整数转成字符
        borrow = x - borrow - y < 0 ? 1 : 0;
        i--, j--;
    }
    reverse(res.begin(), res.end());
    //删除前导0，注意边界是res.size()-1！！防止当res为"0000"时，删为""的清空
    int pos;
    for (pos = 0; pos < res.size() - 1; pos++) {
        if (res[pos] != '0') break;
    }
    return res.substr(pos);
}


需要说明的点有2个：

    1. z = (x - borrow - y + 10) % 10
    这种写法更简洁，其实等价于以下代码

if(x - borrow - y < 0) {
    z = (x - borrow - y + 10) % 10;
}
else z = x - borrow - y;


    2. 删除前导0
    例如，当121-120=001，需要将前面的0删除，得到最终结果1。注意121-121=000这种情况，不要把所有0都删了！

大功告成~下面附上C++版的完整代码


参考代码

#include <iostream>
#include <algorithm>
using namespace std;

string sub(string a, string b) {
    string res = "";
    int borrow = 0;
    int i = a.size() - 1, j = b.size() - 1;
    while (i >= 0 || j >= 0) {
        int x = i >= 0 ? a[i] - '0' : 0;
        int y = j >= 0 ? b[j] - '0' : 0;
        int z = (x - borrow - y + 10) % 10;
        res += '0' + z;
        borrow = x - borrow - y < 0 ? 1 : 0;
        i--, j--;
    }
    reverse(res.begin(), res.end());
    //删除前导0。循环条件是res.size()-1是为防止"0000"的情况
    int pos;
    for (pos = 0; pos < res.size() - 1; pos++) {
        if (res[pos] != '0') break;
    }
    return res.substr(pos);
}

bool cmp(string a, string b) {
    if (a.size() == b.size()) return a < b;
    return a.size() < b.size();
}

string subStrings(string num1, string num2) {
    string res;
    if (cmp(num1, num2)) {
        res = sub(num2, num1);
        if (res != "0") res.insert(0, "-");
    }
    else res = sub(num1, num2);
    return res;
}


int main() {
    string a, b, c;
    cin >> a >> b;
    cout << subStrings(a, b) << endl;
    return 0;
}
