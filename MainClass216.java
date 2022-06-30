/*
 * MainClass216.java
 * Copyright (C) 2022 2022-02-15 22:55 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
链接：https://leetcode-cn.com/problems/combination-sum-iii/solution/dai-ma-sui-xiang-lu-dai-ni-xue-tou-hui-s-petp/
class Solution {
	List<List<Integer>> result = new ArrayList<>();
	LinkedList<Integer> path = new LinkedList<>();

	public List<List<Integer>> combinationSum3(int k, int n) {
		backTracking(n, k, 1, 0);
		return result;
	}

	private void backTracking(int targetSum, int k, int startIndex, int sum) {
		// 减枝
		if (sum > targetSum) {
			return;
		}

		if (path.size() == k) {
			if (sum == targetSum) result.add(new ArrayList<>(path));
			return;
		}
		
		// 减枝 9 - (k - path.size()) + 1
		for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
		//for (int i = startIndex; i <= 9; i++) {//也ok
			path.add(i);
			sum += i;
			backTracking(targetSum, k, i + 1, sum);
			//回溯
			path.removeLast();
			//回溯
			sum -= i;
		}
	}
}

//kalipy一次过 推荐 送分题
class Solution {
    List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int target) {
        dfs(k, target, new LinkedList<>(), 1);

        return ans;
    }

    private void dfs(int k, int target, List<Integer> list, int dept) {
        if (target < 0) return;
        if (target == 0 && list.size() == k) {
            ans.add(new LinkedList<>(list));
            return;
        }

        for (int i = dept; i <= 9; i++) {
            list.add(i);
            dfs(k, target - i, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
