/*
 * MainClass72.java
 * Copyright (C) 2022 2022-02-10 14:32 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//看完这题 请马上看1143题

链接：https://leetcode-cn.com/problems/edit-distance/solution/dai-ma-sui-xiang-lu-72-bian-ji-ju-chi-do-y87e/

public int minDistance(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    int[][] dp = new int[m + 1][n + 1];
    // 初始化
    for (int i = 1; i <= m; i++) {
        dp[i][0] =  i;
    }
    for (int j = 1; j <= n; j++) {
        dp[0][j] = j;
    }
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            // 因为dp数组有效位从1开始
            // 所以当前遍历到的字符串的位置为i-1 | j-1
            if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                dp[i][j] = dp[i - 1][j - 1];
            } else {
                dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
            }
        }
    }
    return dp[m][n];
}


链接：https://leetcode-cn.com/problems/edit-distance/solution/zi-di-xiang-shang-he-zi-ding-xiang-xia-by-powcai-3/
class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        // 第一行
        for (int j = 1; j <= n2; j++) dp[0][j] = dp[0][j - 1] + 1;
        // 第一列
        for (int i = 1; i <= n1; i++) dp[i][0] = dp[i - 1][0] + 1;

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
            }
        }
        return dp[n1][n2];
    }
}
/*
 *
对“dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。”的补充理解：

以 word1 为 "horse"，word2 为 "ros"，且 dp[5][3] 为例，即要将 word1的前 5 个字符转换为 word2的前 3 个字符，也就是将 horse 转换为 ros，因此有：

(1) dp[i-1][j-1]，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 2 个字符 ro，然后将第五个字符 word1[4]（因为下标基数以 0 开始） 由 e 替换为 s（即替换为 word2 的第三个字符，word2[2]）

(2) dp[i][j-1]，即先将 word1 的前 5 个字符 horse 转换为 word2 的前 2 个字符 ro，然后在末尾补充一个 s，即插入操作

(3) dp[i-1][j]，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 3 个字符 ros，然后删除 word1 的第 5 个字符
*/

/*
讲一下我自己对状态转移方程的理解,麻烦大家看看我说得对不对有没有道理:
(一)、当word1[i]==word2[j]时,由于遍历到了i和j,说明word1的0~i-1和word2的0~j-1的匹配结果已经生成,
由于当前两个字符相同,因此无需做任何操作,dp[i][j]=dp[i-1][j-1]
(二)、当word1[i]!=word2[j]时,可以进行的操作有3个:
      ① 替换操作:可能word1的0~i-1位置与word2的0~j-1位置的字符都相同,
           只是当前位置的字符不匹配,进行替换操作后两者变得相同,
           所以此时dp[i][j]=dp[i-1][j-1]+1(这个加1代表执行替换操作)
      ②删除操作:若此时word1的0~i-1位置与word2的0~j位置已经匹配了,
         此时多出了word1的i位置字符,应把它删除掉,才能使此时word1的0~i(这个i是执行了删除操作后新的i)
         和word2的0~j位置匹配,因此此时dp[i][j]=dp[i-1][j]+1(这个加1代表执行删除操作)
      ③插入操作:若此时word1的0~i位置只是和word2的0~j-1位置匹配,
          此时只需要在原来的i位置后面插入一个和word2的j位置相同的字符使得
          此时的word1的0~i(这个i是执行了插入操作后新的i)和word2的0~j匹配得上,
          所以此时dp[i][j]=dp[i][j-1]+1(这个加1代表执行插入操作)
      ④由于题目所要求的是要最少的操作数:所以当word1[i] != word2[j] 时,
          需要在这三个操作中选取一个最小的值赋格当前的dp[i][j]
(三)总结:状态方程为:
if(word1[i] == word2[j]):
      dp[i][j] = dp[i-1][j-1]
else:
       min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1


PS:大佬的代码中word1.charAt(i-1)==word2.charAt(j-1)的原因是:
     初始化DP Table时dp[i][0]和dp[0][j]已经填写完成,所以接下来填表需要从1开始,
     但是字符的比较需要从0开始,因此才这样子写
*/

/* 根据图可知:
 对“dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。”的说明 更容易理解些： dp[i-1][j-1]到dp[i][j]需要进行替换操作，dp[i-1][j]到d[i][j]需要进行删除操作，dp[i][j-1] 到d[i][j]需要进行添加操作。
 */
