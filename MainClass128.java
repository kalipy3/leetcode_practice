/*
 * MainClass128.java
 * Copyright (C) 2022 2022-01-29 20:17 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//kalipy暴力破解一次过 不推荐

class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) return 0;

        int ans = 1;
        Arrays.sort(nums);

        int cnt = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) continue;// 0 1 1 2
            if (nums[i] + 1 == nums[i+1]) {
                cnt++;

            } else {
                ans = Math.max(ans, cnt);
                cnt = 1;
            }
        }

        return Math.max(ans, cnt);
    }
}

//方法二 评论区 通俗易懂 推荐
//1. 将数组元素存入 set 中
//2. 遍历nums，如果 当前项 - 1 存在于 set ，说明当前项不是连续序列的起点，忽略，继续遍历
//3. 如果当前项没有“左邻居”，它就是连续序列的起点，循环查看当前项连续的右邻居有多少个
//4. 返回最长的连续次数
/*
var longestConsecutive = function (nums) {
    // 把题目中数组的数字全部放入set中，一来去重，二来方便快速查找
    const set = new Set(nums);
    let max = 0;
    for (let a of nums) {
        // 没有左邻居，是序列的起点
        if (!set.has(a - 1)) {
            let count = 1;
            let cur = a;
            // 有右邻居，看连续的右邻居有多少个
            while (set.has(cur + 1)) {
                cur++;
                count++;
            }
            // 存放最大的连续邻居的值
            max = Math.max(max, count);
        }
    }
    return max;
};
*/

