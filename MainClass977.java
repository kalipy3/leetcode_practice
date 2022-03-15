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

//kalipy一次过 写法二 送分题
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int tail = n - 1;
        int l = 0;
        int r = n - 1;
        int ans[] = new int[n];
        while (l <= r) {
            if (nums[l] * nums[l] < nums[r] * nums[r]) {
                ans[tail--] = nums[r] * nums[r];
                r--;
            } else {
                ans[tail--] = nums[l] * nums[l];
                l++;
            }
        }

        return ans;
    }
}

//kalipy一次过 送分题
class Solution {
    public int[] sortedSquares(int[] nums) {
        int ans[] = new int[nums.length];

        int tail = nums.length - 1;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            ans[tail--] = Math.max(nums[l]*nums[l], nums[r]*nums[r]);
            if (nums[l]*nums[l] < nums[r]*nums[r]) {
                r--;
            } else {
                l++;
            }
        }

        return ans;
    }
}
