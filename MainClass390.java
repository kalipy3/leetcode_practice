/*
 * MainClass390.java
 * Copyright (C) 2022 2022-03-15 18:57 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

/*
 * 评论区
## 思路：
无论从左到右， 还是从右到左，每次都要消除 一半的数
但是，从左到右，每次都要消除第一个
而从右到左，只要数组为奇数个，才会消除第一个。
## 代码:
class Solution:
    def lastRemaining(self, n: int) -> int:
        remain = n
        flag = True
        res = 1
        step = 1
        while remain > 1:
            # 当左到右 或者剩余个数为奇数
            if flag or remain % 2 == 1:
                res += step
            flag = not flag
            step *= 2
            remain //= 2
        return res

*/

//推荐
//链接：https://leetcode-cn.com/problems/elimination-game/solution/gong-shui-san-xie-yue-se-fu-huan-yun-yon-x60m/
//刚开始被评论搞糊涂了，各种曲解f[i]的意思。。。。。我重新整理下，f[i]定义，起始是从左开始，轮流换向间隔删除(从左向右，从右向左，从左向右....... ，直到只剩下一个数)。 f[i]为从左开始，最后剩下的那个数。f'[i]为从右开始，最后剩下的那个数。（不用去管最终左边剩余还是最终右边剩余，只要最后剩下的那个数，题解加了这个感觉有些误导） 比如[1,2,3,4,5,6,7,8,9] 那么f[9]=6、f'[9]=4 公式一由于对称关系很好明白。 公式二，可以看作是一个递推关系式，是一个n问题与n-1子问题的关系。
class Solution {
    public int lastRemaining(int n) {
        return n == 1 ? 1 : 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }
}

//推荐
//链接：https://leetcode-cn.com/problems/elimination-game/solution/wo-hua-yi-bian-jiu-kan-dong-de-ti-jie-ni-k2uj/
class Solution {
    public int lastRemaining(int n) {
        int head = 1;
        int step = 1;
        boolean left = true;

        while (n > 1) {
            //从左边开始移除 or（从右边开始移除，数列总数为奇数）
            if (left || n % 2 != 0) {
                head += step;
            }
            step *= 2; //步长 * 2
            left = !left; //取反移除方向
            n /= 2; //总数 / 2
        }

        return head;
    }
}


