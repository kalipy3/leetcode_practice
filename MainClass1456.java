/*
 * MainClass1456.java
 * Copyright (C) 2022 2022-02-11 11:45 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 *
 *
 * /

//kalipy一次过 送分题
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
