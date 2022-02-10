/*
 * MainClass397.java
 * Copyright (C) 2022 2022-02-09 21:24 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//方法一 推荐 dfs 官方题解
class Solution {
    Map<Long, Integer> memo = new HashMap<Long, Integer>();

    public int integerReplacement(int n) {
        return dfs(n*1L);
    }

    private int dfs(long n) {
        if (n == 1) {
            return 0;
        }
        if (!memo.containsKey(n)) {
            if (n % 2 == 0) {
                memo.put(n, 1 + dfs(n / 2));
            } else {
                memo.put(n, 1 + Math.min(dfs(n + 1), dfs(n - 1)));
            }
        }
        return memo.get(n);
    }
}

//写法二
class Solution {
    Map<Long, Integer> map = new HashMap<>();
    public int integerReplacement(int n) {
        return dfs(n * 1L);
    }
    int dfs(long n) {
        if (n == 1) return 0;
        if (map.containsKey(n)) return map.get(n);
        int ans = n % 2 == 0 ? dfs(n / 2) : Math.min(dfs(n + 1), dfs(n - 1));
        map.put(n, ++ans);
        return ans;
    }
}


https://leetcode-cn.com/problems/integer-replacement/solution/bao-li-dong-tai-gui-hua-dfssi-kao-si-lu-qy5oa/

//评论区 方法一 位运算
//看被操作数n二进制编码的最低位：
//（1）如果是0，只需要向右移动一位，就可以将0移掉，只需要一次操作；
//
//（2）如果是1，则需要先加1或减1操作变成0，之后进行移位操作，
//    才能将1移掉，需要两次操作；
//
//故，若n二进制编码比特位中的1越少，0越多，则将n变为1需要执行的
//操作次数就越少。
//即，若我们进行一次操作将越多的1变成0，总操作次数就越少。
//
//
//若低位有连续m个1：
//（1）减一操作：将m个1都变成m个0需要m次减一操作，
//    1...00[11...11] ---> 1...00[00...00]，
//    共m次操作；
//
//（2）加一操作：对最低位加1，由于进位，m个1都会变成0，
//    最高位进位，最终形成高位一个1，低位m个0的形式，
//    高位1再通过一次减1操作（或加1操作）变成0，
//    1...00[11...11] ---> 1...01[00...00]
//                    ---> 1...00[00...00]，
//    一次加1操作，一次减1操作（或加1操作），共2次操作。
//
//因此，当低位有连续m个1时，减一操作需要m次，
//加一操作+减一操作（或加1操作）只需要2次；
//
//故当 m >= 2时，优先用加一操作（外加一次减一操作或加一操作），
//              只需2次；
//  当 m < 2时，优先用减一操作，只需1次。
//
//
//注意： 当n为3时，二进制为11，由于最终结果要变成1，
//      故统计连续1时，不能将高位的1统计在内，也就是
//      n为3时低位连续1的个数只能算1个。
//
//代码：

int integerReplacement(int n) {
    int ans = 0;
    unsigned int val = n;
    while (val > 1) {
        if ((val & 1) == 0) {
            ans++;
            val >>= 1;
        } else if (val != 3 && ((val >> 1) & 1) == 1) {
            ans++;
            val++;
        } else {
            ans += 2;
            val >>= 1;
        }
    }
    return ans;
}

