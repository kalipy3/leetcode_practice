/*
 * MainClass49.java
 * Copyright (C) 2022 2022-02-10 22:37 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//推荐方法 官方题解 方法三
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}


//官方题解 方法四
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}






// 方法一 评论区 骚里骚气
//在美版leetcode上看到大神的思路，用质数表示26个字母，把字符串的各个字母相乘，这样可保证字母异位词的乘积必定是相等的。其余步骤就是用map存储，和别人的一致了。（这个用质数表示真的很骚啊！！!）
/*
var groupAnagrams = function(strs) {
    let map = {
        'a':2,'b':3,'c':5,'d':7,'e':11,'f':13,'g':17,'h':19,'i':23,'j':29,'k':31,'l':37,'m':41,
        'n':43,'o':47,'p':53,'q':59,'r':61,'s':67,'t':71,'u':73,'v':79,'w':83,'x':89,'y':97,'z':101
    }
    let resMap = {};
    let resList = [];
    for(let str of strs) {
        let m = 1;
        for(let i=0;i<str.length;i++) {
            m*=map[str[i]];
        }
        if(!resMap[m]) {resMap[m]=[];}
        resMap[m].push(str);
    }
    for(let key in resMap) {
        resList.push(resMap[key]);
    }
    return resList;
};
*/


// 方法二 评论区 骚里骚气
/*
我发现直接hash每一个字符，然后加起来也能AC
d = {}
        for each in strs:
            # key = "".join(sorted(each))
            key = sum([hash(i) for i in each])
            d[key] = d.setdefault(key, []) + [each]
        return list(d.values())
*/
