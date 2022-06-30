//请看官方题解的文字部分 然后直接看kalipy的代码
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //找到较小数
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            //找到较大数
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}

//kalipy一次过
class Solution {
    public void nextPermutation(int[] nums) {
        int i = 0;
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                break;
            }
        }
        if (i >= 0) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                    break;
                }
            }
        }
        revesere(nums, i + 1, nums.length - 1);

    }

    private void revesere(int[] nums, int l, int r) {
        while (l < r) {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }
    }
}
