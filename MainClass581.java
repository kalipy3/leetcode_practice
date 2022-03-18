/*
 * MainClass581.java
 * Copyright (C) 2022 2022-02-02 20:17 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//从左到右循环，记录最大值为 max，若 nums[i] < max, 则表明位置 i 需要调整, 循环结束，记录需要调整的最大位置 i 为 high; 同理，从右到左循环，记录最小值为 min, 若 nums[i] > min, 则表明位置 i 需要调整，循环结束，记录需要调整的最小位置 i 为 low.
//

//先看这个题解的图
//链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/si-lu-qing-xi-ming-liao-kan-bu-dong-bu-cun-zai-de-/
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        //初始化
        int len = nums.length;
        int min = nums[len-1];
        int max = nums[0];
        int begin = 0, end = -1;
        //遍历
        for(int i = 0; i < len; i++){
            if(nums[i] < max){      //从左到右维持最大值，寻找右边界end(左中右三段，相对于左段来说)
                end = i;
            }else{
                max = nums[i];
            }
            
            if(nums[len-i-1] > min){    //从右到左维持最小值，寻找右段的左边界begin
                begin = len-i-1;
            }else{
                min = nums[len-i-1];
            }            
        }
        return end-begin+1;
    }
}

//kalipy一次过 不推荐
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        //初始化
        int len = nums.length;
        
        int[] b = new int[len];
        System.arraycopy(nums, 0, b, 0, len);
        Arrays.sort(b);

        int l = 0;
        int r = len - 1;
        while (l <= r && nums[l] == b[l]) l++;
        while (r >= l && nums[r] == b[r]) r--; 

        return r - l + 1;

    }
}
