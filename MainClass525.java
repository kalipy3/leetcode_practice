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



//写法二
public int findMaxLength(int[] nums) {
    int res = 0, sum = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 0) {
            nums[i] = -1;
        }
    }
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        if (sum == 0 && i > res) {
            res = i + 1;
        }
        if (map.containsKey(sum)) {
            res = Math.max(i - map.get(sum), res);
        } else {
            map.put(sum, i);
        }
    }
    return res;
}

//写法三
//sum == 0的特殊情况 直接 if(sum == 0) {res = i + 1; continue;}更好，i+1一定是最大的。
//还有一个解决方案就是 map初始化一个 (0 ，-1) 就可以不用处理特殊情况了
public int findMaxLength(int[] nums) {
    for (int i = 0; i < nums.length; i++) if (nums[i] == 0) nums[i] = -1;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);//拿[-1,1]带进去过一遍你就知道为什么了
    int sum = 0, res = 0;
    for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        if (map.containsKey(sum)) res = Math.max(res, i - map.get(sum));
        else map.put(sum, i);
    }
    return res;
}

