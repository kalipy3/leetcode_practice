/*
 * MainClass1156.java
 * Copyright (C) 2022 2022-02-11 12:19 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//评论区 这道题不会就算了 题解匮乏
//三种考虑情况：
//
//    一段连续的 ...aaaa...a...（其他地方还有 'a' ）, 则可以放在之前或之后，则可以连起来 -> ...aaaaa...
//    间隔一个字符的 ...aaaabaaaa...a... （其他地方还有 'a' ），则可以把那个 'a' 与中间的 'b' 交换 -> ...aaaaaaaaa...b...
//    间隔一个字符的 ...aaaabaaaa... （其他地方没有 'a' ），则可以将第一个 'a' 与中间的 'b' 交换，-> ...baaaaaaaa...
//
//时间 O(n) 空间 O(1)
/*
class Solution {
public:
    int maxRepOpt1(string text) {
        int cnts[26] = {0}, ends[26], lens[26], res = 0;
        memset(ends, 0x3f, sizeof(ends));
        for(int i = 0; i < text.size(); ++i)
            cnts[text[i] - 'a']++;
        text.push_back('.');
        for(int i = 0, lastidx = 0; i + 1 < text.size(); ++i) {
            if(text[i] != text[i+1]) {
                res = max(res, min(cnts[text[i] - 'a'], i - lastidx + 2));
                if(lastidx - ends[text[i] - 'a'] == 2)
                    res = max(res, min(lens[text[i]-'a'] + i - lastidx + 2, cnts[text[i]-'a']));
                ends[text[i] - 'a'] = i;
                lens[text[i] - 'a'] = i - lastidx + 1;
                lastidx = i+1;
            }
        }
        return res;
    }
};
*/
