//直接看代码
//kalipy一次过 写法一
class Solution {
    public int[] sortedSquares(int[] nums) {
        int N = nums.length;
        int[] ans = new int[N];
        int l = 0;
        int r = N-1;
        int j = N-1;
        while (l <= r) {
            if (nums[l]*nums[l] < nums[r]*nums[r]) {
                ans[j] = nums[r]*nums[r];
                j--;
                r--;
            } else if (nums[l]*nums[l] >= nums[r]*nums[r]) {
                ans[j] = nums[l]*nums[l];
                j--;
                l++;
            }

        }
        return ans;

    }
}

//kalipy一次过 写法二
class Solution {
    public int[] sortedSquares(int[] nums) {
        int N = nums.length;
        int[] ans = new int[N];
        int l = 0;
        int r = N-1;
        int j = N-1;
        while (l <= r) {
            if (nums[l]*nums[l] <= nums[r]*nums[r]) {
                ans[j] = nums[r]*nums[r];
                j--;
                r--;
            } else if (nums[l]*nums[l] > nums[r]*nums[r]) {
                ans[j] = nums[l]*nums[l];
                j--;
                l++;
            }

        }
        return ans;

    }
}
