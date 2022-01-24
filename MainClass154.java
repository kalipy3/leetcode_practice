//请先看153题,153题是互补重复的数组，此题是运行重复
//在153题基础上加一句`r--`
class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                r--;
            }
        }

        return nums[l];
    }
}

