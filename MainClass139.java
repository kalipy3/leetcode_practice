//kalipy错误做法!!!!
//原因是:
//输入：
//"cars"
//["car","ca","rs"]
//输出：
//false
//预期结果：
//true
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        for (String str : wordDict) {
            if (s.contains(str)) {
                s = s.replace(str, "");
            }
        }

        if (s.equals("")) return true;
        else return false;
    }
}


//正确解法
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 可以类比于背包问题
        int n = s.length();
        // memo[i] 表示 s 中以 i - 1 结尾的字符串是否可被 wordDict 拆分
        boolean[] memo = new boolean[n + 1];
        memo[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (memo[j] && wordDict.contains(s.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[n];
    }
}
