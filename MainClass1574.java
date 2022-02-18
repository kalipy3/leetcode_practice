/*
 * MainClass1574.java
 * Copyright (C) 2022 2022-02-03 14:37 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//通俗易懂 好题 链接：https://leetcode-cn.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/solution/shan-chu-lian-xu-zi-shu-zu-by-taicailea-tp0t/
class Solution {
public:
    int findLengthOfShortestSubarray(vector<int>& arr) {
        // 找到最左边开始递减的位置 i 有 arr[i-1] > arr[i]
        // 找到最右边的非递减的开始位置 j 有 arr[k] <= arr[k+1], any k >= j
        int left = 1, right = arr.size()-1, n = arr.size();
        while (left < n && arr[left-1] <= arr[left]) ++left;
        while (right-1 >= 0 && arr[right-1] <= arr[right]) --right;
        if (left > right) return 0; // 已经有序
        // 中间的子数组 arr[left:right] 肯定是要删除的，因为只能删除一个连续的子数组
        int ans = right;
        for (int i = 0; i < left; ++i) {
            int e = arr[i];
            int j = lower_bound(arr.begin()+right, arr.end(), e) - arr.begin();
            ans = min(ans, j-i-1);
        }
        return ans;
    }
};

//方法二
链接：https://leetcode-cn.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/solution/shuang-zhi-zhen-shan-chu-zui-xiao-lian-x-aeim/
class Solution:
    def findLengthOfShortestSubarray(self, arr: List[int]) -> int:
        left, right = 0, len(arr)-1
        while left < len(arr)-1 and arr[left] <= arr[left+1]: left += 1
        while right > 0 and arr[right-1] <= arr[right]: right -= 1
        if left >= right: return 0

        j = right
        ans = min(left+1, len(arr)-right) + right-left-1
        for i in range(left+1):
            while j <len(arr) and arr[i] > arr[j]:
                j += 1
            ans = min(ans, j-i-1)

        return ans


