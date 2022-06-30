/*
 * MainClass448.java
 * Copyright (C) 2022 2022-02-03 15:23 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//官方题解 多看几遍 推荐
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

//方法二 原地哈希 评论区 推荐
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

//方法三 评论区
/*
这题用鸽笼原理实现，由题意可得，1~n的位置表示1~n个笼子，如果出现过，相应的“鸽笼”就会被占掉，我们将数字置为负数表示被占掉了。 最后再遍历一遍，如果“鸽笼”为正数就是没出现的数字。

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        for n in nums:
            nums[abs(n)-1] = - abs(nums[abs(n)-1])
            #找到相应的鸽笼位置，取反

        res = []
        for i, v in enumerate(nums):
            if v >0:#如果大于0，说明没被占过，也就是没有出现过的数字
                res.append(i+1)

        return res

*/
