//请先看153题

//kalipy一次过
class Solution {
    public int minArray(int[] nums) {
        int l = 0;
        int r = nums.length-1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                r--;//去重
            }
        }

        return nums[l];
    
    }
}
