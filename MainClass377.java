/*
 * MainClass377.java
 * Copyright (C) 2022 2022-02-15 22:57 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//评论区 方法一 推荐
class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public int combinationSum4(int[] nums, int target) {
        return backtrack(nums,target);
    }
    private int backtrack(int[]nums,int remains){
        if(remains ==0){
            return 1;
        }
        if(map.containsKey(remains)){
            return map.get(remains);
        }
        int res = 0;
        for(int i=0;i<nums.length;i++){
            if(remains>=nums[i]){
                res+=backtrack(nums,remains-nums[i]);
            }
        }
        map.put(remains,res);
        return res;
    }
}


//方法二
链接：https://leetcode-cn.com/problems/combination-sum-iv/solution/gong-shui-san-xie-yu-wan-quan-bei-bao-we-x0kn/
class Solution {
    public int combinationSum4(int[] nums, int t) {
        // 因为 nums[i] 最小值为 1，因此构成答案的最大长度为 target
        int len = t;
        int[][] f = new int[len + 1][t + 1];
        f[0][0] = 1;
        int ans = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= t; j++) {
                for (int u : nums) {
                    if (j >= u) f[i][j] += f[i - 1][j - u];
                }
            }
            ans += f[i][t];
        }
        return ans;
    }
}

class Solution {
    public int combinationSum4(int[] nums, int t) {
        int[] f = new int[t + 1];
        f[0] = 1;
        for (int j = 1; j <= t; j++) {
            for (int u : nums) {
                if (j >= u) f[j] += f[j - u];
            }
        }
        return f[t];
    }
}


//评论区
class Solution {
    /**
     * 简单递归
     */
    public int combinationSum4_1(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                res += combinationSum4_1(nums, target - num);
            }
        }
        return res;
    }

    /**
     * 记忆化搜索
     */
    private int[] memo;

    public int combinationSum4_2(int[] nums, int target) {
        memo = new int[target + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        return search(nums, target);
    }

    private int search(int[] nums, int target) {
        if (memo[target] != -1) {
            return memo[target];
        }
        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                res += search(nums, target - num);
            }
        }
        memo[target] = res;
        return res;
    }

    /**
     * 动态规划
     */
    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target + 1];
        memo[0] = 1;
        for (int i = 0; i < target; i++) {
            for (int num : nums) {
                if (i + num <= target) {
                    memo[i + num] += memo[i];
                }
            }
        }
        return memo[target];
    }
}

//kalipy 超时
class Solution {
    int ans = 0;
    List<Integer> list = new LinkedList<>();
    //List<List<Integer>> ans1 = new LinkedList<>();
    public int combinationSum4(int[] nums, int target) {
        dfs(nums, target, 0, list);

        /*for (List<Integer> x : ans1) {
          System.out.println(x);
          }*/

        return ans;
    }

    private void dfs(int[] nums, int target, int dept, List<Integer> list) {
        if (target < 0) return;

        if (target == 0) {
            //ans1.add(new LinkedList<>(list));
            ans += 1;
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //list.add(nums[i]);
            dfs(nums, target - nums[i], i, list);
            //list.remove(list.size() - 1);
        } 
    }
}

//kalipy一次过 推荐 送分题
//本题要求的是排列，那么这个for循环嵌套的顺序可以有说法了。
//
//在动态规划：518.零钱兑换II 中就已经讲过了。
//
//**如果求组合数就是外层for循环遍历物品，内层for遍历背包**。
//
//**如果求排列数就是外层for遍历背包，内层for循环遍历物品**。
//
//如果把遍历nums（物品）放在外循环，遍历target的作为内循环的话，举一个例子：计算dp[4]的时候，结果集只有 {1,3} 这样的集合，不会有{3,1}这样的集合，因为nums遍历放在外层，3只能出现在1后面！
//
//所以本题遍历顺序最终遍历顺序：**target（背包）放在外循环，将nums（物品）放在内循环，内循环从前到后遍历**。

class Solution {
    public int combinationSum4(int[] nums, int target) {
        //dfs会超时
        //使用dp数组，dp[i]代表组合数为i时使用nums中的数能组成的组合数的个数
        //别怪我写的这么完整
        //dp[i]=dp[i-nums[0]]+dp[i-nums[1]]+dp[i=nums[2]]+...
        //举个例子比如nums=[1,3,4],target=7;
        //dp[7]=dp[6]+dp[4]+dp[3]
        //其实就是说7的组合数可以由三部分组成，1和dp[6]，3和dp[4],4和dp[3];
        int[]dp=new int[target+1];
        //是为了算上自己的情况，比如dp[1]可以由dp【0】和1这个数的这种情况组成。
        dp[0]=1;
        for(int i=1;i<=target;i++)
        {
            for(int num:nums)
            {
                if(i>=num)
                {
                    dp[i]+=dp[i-num];
                }
            }
        }
        return dp[target];
    }
}
