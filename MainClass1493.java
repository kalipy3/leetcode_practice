/*
 * MainClass1493.java
 * Copyright (C) 2022 2022-02-02 17:12 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//核心思路:以0为中心,统计0左右两边最长的1序列之和
//请直接看注释和代码 简单
class Solution {
    public int longestSubarray(int[] nums) {
        /*      
        例如:[1,1,0,1,1,1]最长的就是left+right=2+3=5
        特殊案例:整个数组没0的情况,这是就要删掉1个1,那么就是len-1
        可以用两个变量left和right分别维护当前0左边和右边的的1数量
        数组最左边默认补上一个0->[0,1,1,0,1,1,1],此时左边的1数目为0,右边的数目待统计
        遍历数组:遇到1时right++,left不变;遇到0时left=right,right=0(左边变右边,右边从0统计)
        遍历过程一直维护max=left+right的最大值,最后再判断一下特例,在全1特例和max中选一个返回即可
        */
        // left和right分别记录0左右两边1的数目,max维护遍历过程;left+right最大值
        int left = 0, right = 0, max = 0;
        for(int num : nums) {
            if(num == 1) {
                right++;
            }else {
                left = right;
                right = 0;
            }
            max = Math.max(max, left + right);
        }
        // 若max=len说明全为1,此时至少要删掉一个1返回max-1,否则直接返回max就是删掉一个0后的最长1序列长度
        return max == nums.length ? max - 1 : max;
    }
}


//kalipy一次过
class Solution {
    public int longestSubarray(int[] nums) {
        int l = 0;
        int r = 0;
        int ans = 0;
        int idx = 0;
        while (idx < nums.length) {
            if (nums[idx] == 0) {
                l = r;
                r = 0;
                idx++;
            } else {
                r++;
                ans = Math.max(ans, r + l);
                idx++;
            }


        }

        return ans == nums.length ? ans - 1 : ans;
    }
}
