//kalipy
//请直接看代码 简单题
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};

        return search(nums, target);
    }

    public int[] search(int[] nums, int target) {
        // 搜索右边界 right
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= target) i = m + 1;
            else j = m - 1;
        }
        int right = i;
        // 若数组中无 target ，则提前返回
        if (j < 0) return new int[]{-1, -1};
        if(j >= 0 && nums[j] != target) return new int[]{-1,-1};

        // 搜索左边界 right
        i = 0; j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] < target) i = m + 1;
            else j = m - 1;
        }
        int left = j;
        //return right - left - 1;
        return new int[]{left+1, right-1};
    }

}

