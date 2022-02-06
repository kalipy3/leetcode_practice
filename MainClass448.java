/*
 * MainClass448.java
 * Copyright (C) 2022 2022-02-03 15:23 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//官方题解 多看几遍
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }
}

//方法二 原地哈希 评论区
//原地hash：因为数组大小为n，且范围在[1,n]，所以可以用nums[i]来存储i + 1,如果当前位置存放的数不对，就把这个数放到该放的地方
class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int>ans;
        for(int i = 0; i < nums.size(); ++i){
            //如果存放的不对，就把当前的数放到该放的位置上
            //后面的别漏掉，不然会陷入无限循环
            while((nums[i] != i + 1) && (nums[i] != nums[nums[i] - 1])){
                swap(nums[i], nums[nums[i] - 1]);
            }
        }
        //遍历数组，位置上数不对的，这个位置应该存放的数就空缺了
        for(int i = 0; i < nums.size(); ++i){
            if(nums[i] != i + 1)
                ans.push_back(i + 1);
        }
        return ans;
    }
};
