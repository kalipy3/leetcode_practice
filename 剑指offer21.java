//kalipy一次过
class Solution {
    public int[] exchange(int[] nums) {
        int[] ans = new int[nums.length];

        int l = 0;
        int r = ans.length-1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                ans[l] = nums[i];
                l++;
            } else {
                ans[r] = nums[i];
                r--;
            }
        }
        return ans;
    }
}

//写法二 kalipy一次过
class Solution {
    public int[] exchange(int[] nums) {
        int[] ans = new int[nums.length];

        int l = 0;
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                swap(nums, l, r);
                l++;
                r++;
            } else {
                r++;
            }
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}


//方法二 官方题解 推荐
public int[] exchange1(int[] nums) {
    if(nums.length < 2) return nums;
    int l = 0;
    int r = nums.length - 1;
    while(l < r){
        //左边找到偶数
        while((nums[l] & 1) == 1 && l < r) l++;
        //右边找到奇数
        while((nums[r] & 1) == 0 && l < r) r--;
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
        l++;
        r--;
    }
    return nums;
}
