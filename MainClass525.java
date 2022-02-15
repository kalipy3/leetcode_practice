/*
 * MainClass525.java
 * Copyright (C) 2022 2022-02-15 12:34 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//由于「0 和 1 的数量相同」等价于「1 的数量减去 0 的数量等于 0」，我们可以将数组中的 0 视作 −1，则原问题转换成「求最长的连续子数组，其元素和为 0」。
//官方题解
class Solution {
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int counter = 0;
        map.put(counter, -1);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 1) {
                counter++;
            } else {
                counter--;
            }
            if (map.containsKey(counter)) {
                int prevIndex = map.get(counter);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                map.put(counter, i);
            }
        }
        return maxLength;
    }
}



