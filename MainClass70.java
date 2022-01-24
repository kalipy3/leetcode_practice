//请看指剑offer第10题，有个大坑!!
//
//https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
class Solution {
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int pre = 1, cur = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = (pre + cur) % 1000_000_007;
            pre = cur;
            cur = tmp;
        }
        return cur;
    }
}

public class MainClass70
{
    public static void main(String args[]) {
        int res = new Solution().numWays(7);
        System.out.println(res);
    }
}

