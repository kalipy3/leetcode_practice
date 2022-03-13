//请先看153题,153题是互不重复的数组，此题是允许重复
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

//kalipy一次过 方法二
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == nums[r]) {
            //if (nums[l] == nums[r]) {
                r--;
            }
            else if (nums[mid] <= nums[r]) {
                r = mid;
            } else if (nums[mid] > nums[r]) {
                l = mid + 1;
            }
        }

        return nums[l];
    }
}

