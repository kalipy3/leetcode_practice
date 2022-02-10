/*
 * 面试题01_05.java
 * Copyright (C) 2022 2022-02-10 21:57 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//方法一 直接看代码注释都能看懂 简单
//链接：https://leetcode-cn.com/problems/one-away-lcci/solution/mian-shi-ti-0105-yi-ci-bian-ji-qing-xi-t-xoy7/
class Solution {
    public boolean oneEditAway(String first, String second) {
        int lf = first.length(), ls = second.length();
        // 为方便后续处理，先保证输入 first 长度 < second 长度
        if (lf > ls)
            return oneEditAway(second, first);
        // 「CASE1」若两字符串长度之差 > 1 ，则无法通过一次编辑互相转换
        if (ls - lf > 1)
            return false;
        // 「CASE2」当两字符串长度相等
        if (lf == ls) {
            int count = 0;
            // 遍历两字符串，统计“对应索引处字符不同”数量
            for (int i = 0; i < lf; i++) {
                if (first.charAt(i) != second.charAt(i))
                    count += 1;
            }
            // 若“对应索引处字符不同”数量 <= 1 ，则能够通过一次编辑互相转换
            return count <= 1;
        }
        // 「CASE3」当两字符串长度之差为 1
        int i = 0, ofs = 0;
        // 遍历两字符串，统计“对应索引处字符不同”数量
        while (i < lf) {
            // 当遍历到不同字符时，执行偏移量 ofs += 1
            if (first.charAt(i) != second.charAt(i + ofs)) {
                // 若偏移量 > 1 ,说明无法通过一次编辑互相转换
                if (++ofs > 1) // 注意 ++ofs > 1 是先执行 ofs 自增，再执行逻辑判断； ofs++ 的顺序反之
                    return false;
            } else {
                i += 1;
            }
        }
        // 遍历完成，代表能够通过一次编辑互相转换
        return true;
    }
}



//方法二
/*
其实也不用指针移来移去计数啥的，直接看比较字符串即可。 核心代码其实很短代码也很简单，前面都是一些判断和预处理，为了解题方便的预处理。 插入和删除其实是一个意思，对长的删除就是对短的插入。 附上golang代码。

func oneEditAway(first string, second string) bool {
    if first == second { return true }
    M, N := len(first), len(second)
    // 长在前  即令first始终是长的，M也表示first的长度，方便解题
    if M < N {
        first, second = second, first
        M, N = N, M
    }
    // 如果长度差值大于1 则直接false
    if M - N > 1 { return false }
    // 核心代码
    i := 0
    // 遍历较短的   遇到不同的字符，比较 （first删除该位置 || 两者替换该位置）  的情况下后面是否相等
    for i < N {
        if first[i] != second[i] {
            return first[i+1:] == second[i:] || first[i+1:] == second[i+1:]
        }
        i++
    }
    return true
}

*/
