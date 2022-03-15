/*
 * MainClass1218.java
 * Copyright (C) 2022 2022-03-15 18:32 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//kalipy一次不过 超时
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int[] dp = new int[arr.length];
        int ans = 1;
        Arrays.fill(dp, 1);

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[j]+difference == arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                } 
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}

//请先看这个题解
//链接：https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference/solution/tong-ge-lai-shua-ti-la-dong-tai-gui-hua-ue2q9/
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        int[] dp = new int[40001];
        for (int num : arr) {
            dp[num + 20000] = dp[num + 20000 - difference] + 1; 
            ans = Math.max(ans, dp[num + 20000]);
        }
        return ans;
    }
}



//官方题解 推荐
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
        for (int v : arr) {
            dp.put(v, dp.getOrDefault(v - difference, 0) + 1);
            ans = Math.max(ans, dp.get(v));
        }
        return ans;
    }
}

//写法二
//我是之前从dp数组来的，这题感觉固定思维了，开始写了个连续递增序列的思路超时了，就是没想到这里等差，还能运用和两数之和的思想。两数之和，两数之差，等差，都能map降维
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dpm = new HashMap<>();
        //引入dp数组，只为更贴近之前做的dp，方便理解一些
        int dp[] = new int[arr.length];
        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            int v = arr[i];
            if (dpm.containsKey(v)) {
                dp[i] = dpm.get(v);
            } else {
                dp[i] = 1;
            }
            dpm.put(v + difference, dp[i] + 1);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}

