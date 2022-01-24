//官方题解 方法一
public class Solution {
    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }
}

//方法一 写法二
作者：fuxuemingzhu
链接：https://leetcode-cn.com/problems/number-of-1-bits/solution/fu-xue-ming-zhu-xiang-jie-wei-yun-suan-f-ci7i/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; ++i) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
}

//写法三 错误写法
//在 Java 中，以下代码会 超时。这就不得不讲一讲 Java 中的 算术右移 和 逻辑右移 。
//
//    算术右移 >> ：舍弃最低位，高位用符号位填补；
//    逻辑右移 >>> ：舍弃最低位，高位用 0 填补。
//
//那么对于负数而言，其二进制最高位是 1，如果使用算术右移，那么高位填补的仍然是 1。也就是 n 永远不会为 0。所以下面的代码会超时 TLE。
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
}

//写法三 正确写法
//在 Java 中需要使用逻辑右移，即 >>> ，while 的判断条件才能是 n != 0
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }
}

//方法二
//有个更为神奇的做法，那就是 n & (n - 1) ，这个代码可以把 n 的二进制中，最后一个出现的 1 改写成 0
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += 1;
            n &= n - 1;
        }
        return res;
    }
}
