/*
 * MainClass930.java
 * Copyright (C) 2022 2022-02-16 15:00 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//官方题解
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        int ret = 0;
        for (int num : nums) {
            cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            sum += num;
            ret += cnt.getOrDefault(sum - goal, 0);
        }
        return ret;
    }
}

//评论区 推荐
public int numSubarraysWithSum(int[] nums, int S) {
    Map<Integer,Integer> map = new HashMap<>();
    map.put(0,1);
    int sum = 0;
    int res = 0;
    for(int i=0;i<nums.length;i++){
        sum += nums[i];
        if(map.containsKey(sum-S)){
            res += map.get(sum-S);
        }
        map.put(sum,map.getOrDefault(sum,0)+1);
    }
    return res;
}

