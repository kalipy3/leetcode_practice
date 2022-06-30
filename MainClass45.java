//作者：windliang
//链接：https://leetcode-cn.com/problems/jump-game-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-10/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution {
    public int jump(int[] nums) {
        int end = 0;//必须起跳的点
        int maxPosition = 0; 
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i++){
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i); 
            if( i == end){ //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}

//写法二
class Solution {
    public int jump(int[] nums) {
        int maxPosition = 0;
        int end = 0;
        int step = 0;
        if (nums.length == 1) return 0;

        for (int i = 0; i < nums.length; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                end = maxPosition;
                step++;
                if (maxPosition == nums.length-1) return step;
            }
        }
        return step;
    }
}

//kalipy一次过 推荐
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int must = 0;//必须起跳的点
        int maxPos = 0;
        int step = 0;
        for (int i = 0;  i < n - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == must) {
                must = maxPos;
                step++;
            }
        }

        return step;
    }
}

//方法二 推荐
class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i)
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
            }
        }

        return dp[nums.length - 1];
    }
}


