/*
 * 剑指offer_17.java
 * Copyright (C) 2022 2022-02-09 20:24 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//方法一 kalipy一次过
class Solution {
    public int[] printNumbers(int n) {
        int len = (int)Math.pow(10, n);
        int ans[] = new int[len-1];

        for (int i = 1; i < len; i++) {
            ans[i-1] = i;
        }

        return ans;
    }
}

//两个写法都很好 值得多看几遍
//方法二 写法一 官方题解
class Solution {
    int[] res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public int[] printNumbers(int n) {
        this.n = n;
        res = new int[(int)Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1;
        dfs(0);
        return res;
    }
    void dfs(int x) {
        if(x == n) {
            String s = String.valueOf(num).substring(start);
            if(!s.equals("0")) res[count++] = Integer.parseInt(s);
            if(n - start == nine) start--;
            return;
        }
        for(char i : loop) {
            if(i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }
}

//写法二
class Solution {
private:
    vector<string> res;
    string s;
    char num[10] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    // 生成长度为len的数，固定第x位
    void dfs(int x, int len){
        if(x == len){
            res.push_back(s);
            return;
        }
        // 如果固定的是第0位（从左向右数），表明是第一位，则不能取0
        int start = x == 0 ? 1 : 0;
        for(int i = start; i < 10; i++){
            s.push_back(num[i]);
            dfs(x + 1, len);
            s.pop_back();
        }
    }

public:
    vector<int> printNumbers(int n) {
        // 数字长度：1 ~ n
        for(int i = 1; i <= n; i++){
            dfs(0, i);
        }
        vector<int> ans;
        for(int i = 0; i < res.size(); i++){
            ans.push_back(stoi(res[i]));
        }
        return ans;
    }
};


