//先看官方题解思路，然后直接看kalipy的代码 简单
//kalipy的 写法一
class Solution {
    public int maxProduct(int[] nums) {
        int N = nums.length;

        if (N == 0) return 0;

        int[] max = new int[N];
        int[] min = new int[N];
        int ans = max[0] = min[0] = nums[0];

        for (int i = 1; i < N; i++) {
            max[i] = Math.max(nums[i], Math.max(max[i-1]*nums[i], min[i-1]*nums[i]));
            min[i] = Math.min(nums[i], Math.min(min[i-1]*nums[i], max[i-1]*nums[i]));
            ans = Math.max(ans, max[i]);
        }
        return ans;
    }
}

//kalipy的 写法二
class Solution {
    public int maxProduct(int[] nums) {
        int N = nums.length;

        if (N == 0) return 0;

        int preMax = nums[0];
        int preMin = nums[0];
        int ans = nums[0];
        int max, min = 0;
        
        for (int i = 1; i < N; i++) {
            max = Math.max(nums[i], Math.max(preMax*nums[i], preMin*nums[i]));
            min = Math.min(nums[i], Math.min(preMin*nums[i], preMax*nums[i]));
            ans = Math.max(ans, max);
            preMax = max;
            preMin = min;
        }
        return ans;
    }
}

//kalipy暴力破解 超时
class Solution {
    int ans = Integer.MIN_VALUE;

    public int maxProduct(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int sum = 1;
            for (int j = i; j < nums.length; j++) {
                sum *= nums[j];
                ans = Math.max(ans, sum);
            }
        }

        return ans;
    }
}
