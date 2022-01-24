//推荐思路三或思路二

/** 思路一
    上楼梯的复杂版？
    如果连续的两位数符合条件，就相当于一个上楼梯的题目，可以有两种选法：
        1.一位数决定一个字母
        2.两位数决定一个字母
        就相当于dp(i) = dp[i-1] + dp[i-2];
    如果不符合条件，又有两种情况
        1.当前数字是0：
            不好意思，这阶楼梯不能单独走，
            dp[i] = dp[i-2]
        2.当前数字不是0
            不好意思，这阶楼梯太宽，走两步容易扯着步子，只能一个一个走
            dp[i] = dp[i-1];
    
*/

作者：sdwwld
链接：https://leetcode-cn.com/problems/decode-ways/solution/shu-ju-jie-gou-he-suan-fa-di-gui-he-dong-pnyf/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//思路二
public int numDecodings(String s) {
    int length = s.length();
    int[] dp = new int[length + 1];
    dp[0] = 1;
    for (int i = 1; i <= length; i++) {
        //判断截取一个是否符合（只要不是0，都符合）
        if (s.charAt(i - 1) != '0')
            dp[i] = dp[i - 1];
        //判断截取两个是否符合
        if (i >= 2 && (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6'))
            dp[i] += dp[i - 2];
    }
    return dp[length];
}

//思路三
//作者：pris_bupt
//链接：https://leetcode-cn.com/problems/decode-ways/solution/c-wo-ren-wei-hen-jian-dan-zhi-guan-de-jie-fa-by-pr/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
int numDecodings(string s) {
    if (s[0] == '0') return 0;
    int pre = 1, curr = 1;//dp[-1] = dp[0] = 1
    for (int i = 1; i < s.size(); i++) {
        int tmp = curr;
        if (s[i] == '0')
            if (s[i - 1] == '1' || s[i - 1] == '2') curr = pre;
            else return 0;
        else if (s[i - 1] == '1' || (s[i - 1] == '2' && s[i] >= '1' && s[i] <= '6'))
            curr = curr + pre;
        pre = tmp;
    }
    return curr;
}


