/*
 * MainClass90.java
 * Copyright (C) 2022 2022-02-17 15:24 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
https://leetcode-cn.com/problems/subsets-ii/solution/90-zi-ji-iiche-di-li-jie-zi-ji-wen-ti-ru-djmf/

//方法一
class Solution {
    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0){
            result.add(path);
            return result;
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
        subsetsWithDupHelper(nums, 0);
        return result;
    }

    private void subsetsWithDupHelper(int[] nums, int startIndex){
        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length){
            return;
        }
        for (int i = startIndex; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            subsetsWithDupHelper(nums, i + 1);
            path.removeLast();
            used[i] = false;
        }
    }
}

//方法二
class Solution {
public List<List<Integer>> subsetsWithDup(int[] nums) {
    //先对数组进行排序，这样相同的元素就会在一起，便于过滤
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    backtrack(nums, res, new ArrayList<>(), 0);
    return res;
}

/**
 * @param nums     原始数组
 * @param res      需要返回的结果
 * @param tempList 当前路径上的元素
 * @param level    遍历到第几层
 */
private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> tempList, int level) {
    //每条路径上所选择的元素组成的数组都是子集，所以都要添加到集合res中
    res.add(new LinkedList<>(tempList));
    //这里遍历的时候每次都有从之前选择元素的下一个开始，所以这里i的初始值是level
    for (int i = level; i < nums.length; i++) {
        //剪枝，过滤掉重复的
        if (i != level && nums[i] == nums[i - 1])
            continue;
        //选择当前元素
        tempList.add(nums[i]);
        //递归到下一层
        backtrack(nums, res, tempList, i + 1);
        //撤销选择
        tempList.remove(tempList.size() - 1);
    }
}

}
