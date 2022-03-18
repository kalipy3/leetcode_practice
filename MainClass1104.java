/*
 * MainClass1104.java
 * Copyright (C) 2022 2022-01-27 10:33 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

// 先看这个题解的思路，然后再看写法一的注释，  然后直接看kalipy修改后的注释和代码 最后可以看看官方题解 https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree/solution/1104-er-cha-shu-xun-lu-c-100-jie-fa-wei-p3ik1/

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

//官方题解
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        int row = 1, rowStart = 1;
        while (rowStart * 2 <= label) {
            row++;
            rowStart *= 2;
        }
        if (row % 2 == 0) {
            label = getReverse(label, row);
        }
        List<Integer> path = new ArrayList<Integer>();
        while (row > 0) {
            if (row % 2 == 0) {
                path.add(getReverse(label, row));
            } else {
                path.add(label);
            }
            row--;
            label >>= 1;
        }
        Collections.reverse(path);
        return path;
    }

    public int getReverse(int label, int row) {
        return (1 << row - 1) + (1 << row) - 1 - label;
    }
}

//评论区
/*
位运算即可。具体解释见题解。

举例14=1110b，

先将14右移，变为111b，然后对除第一位外所有位取反变为100b，即它的根节点4，

同理100b，右移变为10b，对除第一位外所有位取反变为11b，即它的根节点3

一直到1结束。

    def pathInZigZagTree(self, label: int) -> List[int]:
        res = []
        while label != 1:
            res.append(label)
            label >>= 1
            # 这里我采用异或实现
            label = label ^(1 << (label.bit_length() - 1)) - 1
        return [1]+res[::-1]

*/

位运算的确很巧妙，其实原理就是求原始父节点（非之字形分布的二叉树）在该行的对称位置，贴下代码助大家理解
public class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> res = new LinkedList<>();
        res.add(label);
        int c = (int) (Math.log(label) / Math.log(2));
        while (c != 0) {
            label = (int) (Math.pow(2, c) - 1) + (int) (Math.pow(2, c - 1)) - label / 2;
            res.addFirst(label);
            c--;
        }
        return res;
    }
}

