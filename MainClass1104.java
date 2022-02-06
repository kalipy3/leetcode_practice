/*
 * MainClass1104.java
 * Copyright (C) 2022 2022-01-27 10:33 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

// 先看这个题解的思路，然后再看写法一的注释，  然后直接看kalipy修改后的注释和代码https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree/solution/1104-er-cha-shu-xun-lu-c-100-jie-fa-wei-p3ik1/

//写法一
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new ArrayList<>();
        while(label>0){
            ans.add(label);
            label>>=1;//返回上一层
        }
        Collections.reverse(ans);
        int l, r, deep = ans.size();
        for(int i = 0; i < deep; i++) {
            if((deep & 1) != (i & 1)) continue;     // 判断第 i 层是否需要修改
            l = (1 << i);//获取左节点值
            r = l + l - 1;//获取右节点值
            ans.set(i,r - ans.get(i) + l);//修改成对应的镜像值（即与正常树对称的值）
        }
        return ans;

    }

}

//kalipy
//翻转前：8 9 10 11 12 13 14 15
//翻转前节点到最左边节点的距离 = 翻转前最右边节点到要求的x节点的距离
//ans.get(i) - l = r -x;
//9          - 8 = 15-x; --->x = 14
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new ArrayList<>();
        while(label>0){
            ans.add(label);
            label>>=1;
        }
        Collections.reverse(ans);
        int l, r, deep = ans.size();
        for(int i = 0; i < deep; i++) {
            if((deep & 1) != (i & 1)) continue;     // 判断第 i 层是否需要修改
            l = (1 << i);
            //r = l + l - 1;
            r = 2*l - 1;
            ans.set(i,r - ans.get(i) + l);//ans.get(i) - l = r -x;
        }
        return ans;

    }

}

