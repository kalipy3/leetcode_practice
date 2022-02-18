/*
 * MainClass461.java
 * Copyright (C) 2022 2022-02-16 13:52 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//送分题
//kalipy一次过
class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}


//方法二
class Solution {
    public int hammingDistance(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            ret += s & 1;
            s >>= 1;
        }
        return ret;
    }
}

//官方题解 方法三
//我们可以使用 Brian Kernighan 算法进行优化，具体地，该算法可以被描述为这样一个结论：记 f(x) 表示 x 和 x−1 进行与运算所得的结果（即 f(x)=x & (x−1)，那么 f(x) 恰为 x 删去其二进制表示中最右侧的 1 的结果
class Solution {
    public int hammingDistance(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            s &= s - 1;
            ret++;
        }
        return ret;
    }
}

