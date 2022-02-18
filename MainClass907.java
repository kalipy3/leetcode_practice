/*
 * MainClass907.java
 * Copyright (C) 2022 2022-02-03 12:21 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
链接：https://leetcode-cn.com/problems/sum-of-subarray-minimums/solution/xiao-bai-lang-dong-hua-xiang-jie-bao-zhe-489q/
class Solution {
    private static final int MOD = 1000000007;
    public int sumSubarrayMins(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        long ans = 0;
        // 起点
        for (int i = 0; i < n; i++) {
            int min = arr[i];
            // 终点
            for (int j = i; j < n; j++) {
                min = Math.min(min, arr[j]);
                ans = (ans + min) % MOD;
            }
        }
        return (int)ans;
    }
}



链接：https://leetcode-cn.com/problems/sum-of-subarray-minimums/solution/dan-diao-zhan-zuo-you-liang-bian-di-yi-g-ww3n/
/*
class Solution {
private:
    const int BASE = 1e9 + 7;
public:
    int sumSubarrayMins(vector<int>& arr) {
        stack<int> stk;
        arr.push_back(0);               // 保证栈中所有元素都会被弹出计算
        int len = arr.size();
        long res = 0;
        for ( int i = 0; i < len; ++i ) {
            while ( !stk.empty() && arr[i] <= arr[stk.top()] ) {
                int index = stk.top(); stk.pop();
                int prev_index = -1;
                if ( !stk.empty() ) prev_index = stk.top();
                int prev_count = index - prev_index - 1; // 数量m
                int next_count = i - index - 1;          // 数量n
                res += long(arr[index]) * (prev_count + 1) * (next_count + 1) % BASE;
                res %= BASE;
            }
            stk.push(i);
        }
        return res;
    }
};

*/
