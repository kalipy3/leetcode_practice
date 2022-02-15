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


//正确解法 官方题解 先看官方题解 然后直接用代码过一遍例子 很好懂
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

//方法二 dfs 推荐一定要看，题解写得很好
//链接：https://leetcode-cn.com/problems/word-break/solution/shou-hui-tu-jie-san-chong-fang-fa-dfs-bfs-dong-tai/
/*
const wordBreak = (s, wordDict) => {
	const len = s.length;
  	const wordSet = new Set(wordDict);

	const canBreak = (start) => { // 判断从start到末尾的子串能否break
		if (start == len) {//指针越界，s一步步成功划分为单词，才走到越界这步，现在没有剩余子串
			return true;   //返回真，结束递归
		}
		for (let i = start + 1; i <= len; i++) { //指针i去划分两部分，for枚举出当前所有的选项i
			const prefix = s.slice(start, i);    // 切出的前缀部分
			if (wordSet.has(prefix) && canBreak(i)) {// 前缀部分是单词，且剩余子串能break，返回真
				return true;                            
			} // 如果前缀部分不是单词，就不会执行canBreak(i)。进入下一轮迭代，再切出一个前缀串，再试
		}
		return false; // 指针i怎么划分，都没有返回true，则返回false
	}

	return canBreak(0); // 递归的入口，从0到末尾的子串能否break
}


*/
