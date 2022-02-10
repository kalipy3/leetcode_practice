
//完全背包，死命咬文嚼字`选与不选`这句话
//先看这个题解!!!!!!!!! 或者直接看官方题解也行
https://leetcode-cn.com/problems/perfect-squares/solution/dai-ma-sui-xiang-lu-279-wan-quan-ping-fa-9ieo/


//f[i] 表示最少需要多少个数的平方来表示整数 i
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;

        for(int i = 0 ; i <= n ; ++i){
            for(int j = 1 ; j * j <= i ; ++j){//背包可以装下当前物品则进入此循环进行装放
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);//选当前物品，则dp[i]=dp[i-j*j]+1。不选当前物品，则dp[i]=dp[i]
            }
        }

        return dp[n];
    }
}


i=1,
j=1
dp[1]=Math.min(dp[1], dp[1-1*1]+1)=1

i=2
j=1
dp[2]=Math.min(dp[2], dp[2-1*1]+1)=2

i=3
j=1
dp[3]=Math.min(dp[3], dp[3-1*1]+1)=3

i=4
j=1
dp[4]=Math.min(dp[4], dp[4-1*1]+1)=4
j=2
dp[4]=Math.min(dp[4], dp[4-2*2]+1)=min(4, 1)=1
