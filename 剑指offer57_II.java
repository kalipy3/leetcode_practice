/*
 * 剑指offer57_II.java
 * Copyright (C) 2022 2022-02-16 23:40 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//kalipy一次过 推荐写法二
//链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/shi-yao-shi-hua-dong-chuang-kou-yi-ji-ru-he-yong-h/
public int[][] findContinuousSequence(int target) {
    int i = 1; // 滑动窗口的左边界
    int j = 1; // 滑动窗口的右边界
    int sum = 0; // 滑动窗口中数字的和
    List<int[]> res = new ArrayList<>();

    while (i <= target / 2) {
        if (sum < target) {
            // 右边界向右移动
            sum += j;
            j++;
        } else if (sum > target) {
            // 左边界向右移动
            sum -= i;
            i++;
        } else {
            // 记录结果
            int[] arr = new int[j-i];
            for (int k = i; k < j; k++) {
                arr[k-i] = k;
            }
            res.add(arr);
            // 左边界向右移动
            sum -= i;
            i++;
        }
    }

    return res.toArray(new int[res.size()][]);
}


//写法二
public int[][] findContinuousSequence(int target) {
    List<int[]> res = new ArrayList<>();
    // 滑动窗口,左右指针指向的数
    // 初始窗口的宽度为1，所有左右都指向1
    int left = 1;
    int right = 1;
    // 窗口内的数字和,左闭右闭
    int sum = 1;
    // 只需要遍历到目标值的一般即可，后面加起来肯定大于target
    while (left <= target / 2){
        // 如果小了，右指针增大
        if (sum < target) {
            right++;
            sum += right;
        }else if (sum > target){
            // 如果大了，左指针增大
            sum -= left;
            left++;
        }else {
            // 说明匹配上了需要把窗口中的元素放进结果集
            int[] level = new int[right - left + 1];
            for (int i = left; i <= right; i++) {
                level[i - left] = i;
            }
            res.add(level);
            // 加入结果集之后窗口要移动
            right++;
            sum += right;
            sum -= left;
            left++;
        }
    }
    return res.toArray(new int[res.size()][]);
}

