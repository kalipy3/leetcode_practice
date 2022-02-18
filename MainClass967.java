/*
 * MainClass967.java
 * Copyright (C) 2022 2022-02-17 21:36 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

// 链接：https://leetcode-cn.com/problems/numbers-with-same-consecutive-differences/solution/967-lian-xu-chai-xiang-tong-de-shu-zi-by-yvp7/
/*
class Solution {
public:
    vector<int> ans;
    //now 当前选出的数，left剩余的数字
    void func(int now, int left, int k){
        if(left == 0){
            ans.push_back(now);
            return ;
        }
        if(now % 10 - k >= 0) {
            func(now * 10 + now %10 - k, left - 1, k);
        }
        //k=0时，now % 10 - k 和now % 10 + k是一样的，答案会重复
        if(k != 0 && now % 10 + k < 10){
            func(now * 10 + now %10 + k, left - 1, k);
        }
    }
    vector<int> numsSameConsecDiff(int n, int k) {
        for(int i = 1; i<= 9; i++){
            func(i, n - 1, k);
        }
        return ans;
    }
};

*/

//写法二
List<Integer> res;
public int[] numsSameConsecDiff(int n, int k) {
    res = new ArrayList<>();
    dfs(n,k,new StringBuilder());
    return res.stream().mapToInt(Integer::intValue).toArray();
}
private void dfs(int n,int k,StringBuilder str){
    if(str.length()==n){
        res.add(Integer.parseInt(str.toString()));
        return ;
    }
    for(int i=0;i<=9;i++){
        if(str.length()==0&&i==0)   continue;
        if(str.length()==0||Math.abs(str.charAt(str.length()-1)-'0'-i)==k){
            str.append(i);
            dfs(n,k,str);
            str.deleteCharAt(str.length()-1);
        }
    }
}
