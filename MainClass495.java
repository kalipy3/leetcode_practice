/*
 * MainClass495.java
 * Copyright (C) 2022 2022-01-31 21:49 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//请直接看题解和代码即可

//题目已确保 timeSeriestimeSeriestimeSeries 为非递减排序，按照顺序进行遍历处理即可。
//我们使用 ans 统计答案，使用 last 记录上一次攻击的结束点，对于任意的 timeSeries[i] 而言，假设其发起点为 s=timeSeries[i]，结束点为 e=s+duration−1，针对 last 和 s 进行分情况讨论即可：
//
//    last<s ：两次攻击不重合，则有 ans+=duration;last=e;
//    last>=s ：两次攻击重合，则有 ans+=e−last;last=e;

//方法一 推荐
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0, last = -1;
        for (int s : timeSeries) {
            int e = s + duration - 1;
            ans += last < s ? duration : e - last;
            last = e;
        }
        return ans;
    }
}

//方法二
//var findPoisonedDuration = function(timeSeries, duration) {
//    let res = 0;
//    for (let i = 1; i < timeSeries.length; i++) {
//        // 攻击间隙，中毒时长最大为duration，或为间隙时长
//        res += Math.min(duration, timeSeries[i] - timeSeries[i - 1]);
//    }
//    // 最后一次攻击
//    res += duration;
//    return res;
//};
