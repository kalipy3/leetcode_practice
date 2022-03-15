/*
 * MainClass434.java
 * Copyright (C) 2022 2022-03-15 21:53 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */


/*

    模拟大法好

    a.找到一个单词，更新一下res，bool find = true记录找到了（下一次连续找到单词时，find = true 就不更新）

    b.直到找到空格为止，将find = false，（可以再次进行a.）

    cpp

class Solution {
public:
    int countSegments(string s) {
        int res = 0;
        bool find = false;
        for(int i = 0;i < s.size();i ++){
            if(s[i] != ' ' && !find){
                res ++;
                find = true;
            }
            if(s[i] == ' '){
                find = false;
            }
        }
        return res;
    }
};

*/

//方法二
class Solution {
    public int countSegments(String s) {
          int cnt = 0;
          s = " " + s;
          for (int i = 1; i < s.length(); i++) {
              if (s.charAt(i) != ' ' && s.charAt(i - 1) == ' ') cnt++;
          }
          return cnt;
    }
}

//方法三
//计算字符串中单词的数量，就等同于计数单词的第一个下标的个数。因此，我们只需要遍历整个字符串，统计每个单词的第一个下标的数目即可。
//满足单词的第一个下标有以下两个条件：
//    该下标对应的字符不为空格；
//    该下标为初始下标或者该下标的前下标对应的字符为空格；
class Solution {
    public int countSegments(String s) {
        int segmentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }

        return segmentCount;
    }
}

//kalipy一次过
class Solution {
    public int countSegments(String s) {
        int cnt = 0;
        s += " ";

        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) != ' ') && s.charAt(i+1) == ' ') {
                cnt++;
            }
        }

        return cnt;
    }
}
