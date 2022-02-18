/*
 * MainClass1456.java
 * Copyright (C) 2022 2022-02-11 11:45 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 *
 *
 * /

//kalipy一次过 送分题
首先计算初始窗口[0,k]中元音字母的个数，然后这个窗口开始向右滑动一格，此时分为三种情况：

    右侧新进入窗口的字母为元音字母，左侧移出窗口的字母也是元音字母，这样一进一出抵消掉了
    右侧新进入窗口的字母为元音字母，左侧移出窗口的字母非元音字母，此时元音字母个数+1
    右侧新进入窗口的字母非元音字母，左侧移出窗口的字母为元音字母，此时元音字母个数-1

/*
//例子： s=leetcode k=3
var maxVowels = function (s, k) {
    const vowels = new Set(['a', 'e', 'i', 'o', 'u'])
    let count = 0,
        l = 0,
        r = 0
    while (r < k) {//初始化大小k的窗口
        vowels.has(s[r]) && count++
        r++
    }
    let max = count
    while (r < s.length) {//不断移动窗口
        vowels.has(s[r]) && count++
        vowels.has(s[l]) && count--
        l++
        r++
        max = Math.max(max, count)//更新最大元音数
    }
    return max
};

*/
