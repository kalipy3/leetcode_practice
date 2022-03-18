/*
 * MainClass201.java
 * Copyright (C) 2022 2022-02-16 13:46 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//记住结论即可：求前缀

/*
【笔记】当一个数+1时，总会有这么一个规律“某一位后的数字，全部被置为相反数”。举个例子：

    010111 + 1 = 011000，则010111 & 011000 = 010000。那么，x & (x+1) 后几位相反数的“与操作”，结果总为0。

所以，当(m,m+1,...n-1,n)进行连续“与操作”时，会按照上述规律被抵消很大一部分，而只剩下n的前缀部分，最后只需将n归位。举个例子：

    m = 5(0101), n = 7 (0111)。不停右移，得到n前缀部分为01，最后归位前缀得res=0100=4
*/
int rangeBitwiseAnd(int m, int n) {
    int offset = 0;
    for (; m != n; ++offset) {
        m >>= 1;
        n >>= 1;
    }
    return n << offset;
}


//然后看 官方题解
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        // 找到公共前缀
        //while (m < n) {//也ok
        while (m != n) {
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        return m << shift;
    }
}

//官方题解 方法二 推荐
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        //while (m != n) {//error 不ok
        while (m < n) {
            // 抹去最右边的 1
            n = n & (n - 1);
        }
        return n;
    }
}
