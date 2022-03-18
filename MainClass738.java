/*
 * MainClass738.java
 * Copyright (C) 2022 2022-03-17 17:32 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//方法一 评论区 请直接看代码 可以看懂
int monotoneIncreasingDigits(int N) {
    int i = 1;
    int res = N;
    while(i <= res/10) {
        int n = res / i % 100; // 每次取两个位
        i *= 10;
        if(n/10 > n%10) // 比较的高一位大于底一位
            res = res / i * i - 1; //例如1332 循环第一次变为1330-1=1329 第二次变为1300-1=1299
    }
    return res;
}

//方法二 推荐

/*
这题感觉不难，没觉着哪里贪心了

做完后，感觉思路很自然啊，就应该是这样子啊，怎么贪心的，哪里贪的？

【思路】

从左往右遍历各位数字，找到第一个开始下降的数字[i]，将[i]减1，然后将[i+1 ...]各位数字全部置为9即可

例如：1232123，从左往右遍历，找到第一个开始下降的数字3，将3改为2，然后将后面所有数字全部置为9，最后为：1229999 即为答案

【需要注意一点】：如果第一个开始下降的数字[i]，前面还有与其相等的数字，需要找到最前面的一个数字作为上面所说的[i]

例如：13332，从左往右遍历，找到第一个开始下降的数字3，往前再看下，是否还有等于3的数字，找到最前面那个3，将3改为2，然后将后面的各个数字置为9，最后为：12999
*/
public static int monotoneIncreasingDigits(int N) {
    if (N < 10) return N;

    char[] chars = String.valueOf(N).toCharArray();

    // 从左往右遍历各位数字，找到第一个开始下降的数字[i]
    int i = 0;
    while (i+1 < chars.length && chars[i] <= chars[i+1]) {
        i++;
    }
    if (i == chars.length-1) return N; // 整个数字符合要求，直接返回
    // 需要再往前再看下，是否还有等于当前[i]的数字，找到最前面那个
    while (i-1 >= 0 && chars[i-1] == chars[i]) {
        i--;
    }
    // 将此时的[i]--，并将[i+1 ...]各位数字全部置为9
    chars[i] = (char) (chars[i]- 1);
    i++;
    while (i < chars.length) {
        chars[i] = '9';
        i++;
    }

    return Integer.parseInt(String.valueOf(chars));
}
