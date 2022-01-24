//请直接先看方法一的代码 然后直接看方法终的代码
//
//方法一
public int compareVersion(String version1, String version2) {
    String[] a1 = version1.split("\\.");
    String[] a2 = version2.split("\\.");

    for(int n = 0; n < Math.max(a1.length, a2.length); n++){
        int i = (n < a1.length ? Integer.valueOf(a1[n]) : 0);
        int j = (n < a2.length ? Integer.valueOf(a2[n]) : 0);
        if(i < j) return -1;
        else if(i > j) return 1;
    }
    return 0;  
}

//变量简洁正确完整思路
//cur1cur2同时遍历，两人版本号值为num1num2=0，只要没到.就num1=num1*10+
//s[cur1]-'0'，cur++，如果cur1或cur2到n1或n2则num1或num2就是0，while中
//一旦num1num2不同立刻返回
//
//精确定义
//cur1cur2
//num1num2
class Solution {
    public:
        int compareVersion(string version1, string version2) {
            int n1=version1.size(),n2=version2.size();
            int cur1=0,cur2=0;
            while(cur1<n1||cur2<n2){
                int num1=0,num2=0;
                while(cur1<n1&&version1[cur1]!='.'){
                    num1=num1*10+version1[cur1]-'0';
                    cur1++;
                }
                while(cur2<n2&&version2[cur2]!='.'){
                    num2=num2*10+version2[cur2]-'0';
                    cur2++;
                }
                if(num1<num2)return -1;
                if(num1>num2)return 1;
                cur1++,cur2++;
            }
            return 0;
        }
};


class Solution {
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        while (i < version1.length() || j < version2.length()) {
            int x = i, y = j;
            while (x<version1.length()&&version1.charAt(x)!='.') x++;
            while (y<version2.length()&&version2.charAt(y)!='.') y++;
            int a = x == i ? 0 : Integer.parseInt(version1.substring(i, x));
            int b = y == j ? 0 : Integer.parseInt(version2.substring(j, y));
            if(a<b) return -1;
            if(a>b) return 1;
            i = x + 1;
            j = y + 1;
        }
        return 0;
    }

}

//写法终
public int compareVersion(String version1, String version2) {
    int index1 = 0;
    int index2 = 0;
    while (index1 < version1.length() || index2 < version2.length()) {
        int res1 = 0;
        //遍历第一个字符串，同时记录 . 分割的这个数字大小
        while (index1 < version1.length() && version1.charAt(index1) != '.') {
            res1 = res1 * 10 + (version1.charAt(index1) - '0');
            index1++;
        }
        int res2 = 0;
        //遍历第二个字符串，同时记录 . 分割的这个数字大小
        while (index2 < version2.length() && version2.charAt(index2) != '.') {
            res2 = res2 * 10 + (version2.charAt(index2) - '0');
            index2++;
        }
        //比较这两个数字大小，相等则进入下一个循环
        if (res1 > res2) {
            return 1;
        } else if (res1 < res2) {
            return -1;
        }
        index1++;
        index2++;
    }
    return 0;
}
