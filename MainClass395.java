//先看题解的文字解说，然后直接看代码
作者：fuxuemingzhu
链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/solution/jie-ben-ti-bang-zhu-da-jia-li-jie-di-gui-obla/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//写法一 
class Solution {
    public int longestSubstring(String s, int k) {
        if (s.length() < k) return 0;
        HashMap<Character, Integer> counter = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (char c : counter.keySet()) {
            if (counter.get(c) < k) {
                int res = 0;
                for (String t : s.split(String.valueOf(c))) {
                    res = Math.max(res, longestSubstring(t, k));
                }
                return res;
            }
        }
        return s.length();
    }
}

//写法二 推荐
class Solution {
    public int longestSubstring(String s, int k) {
        if(s.length() < k)
        {  
            return 0;
        }
        int [] count = new int [26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)- 'a']++;
        }
        for(int i=0;i<s.length();i++){
            char ca = s.charAt(i);
            //判断条件 找到小于出现k次的字符串
            if(count[ca - 'a'] < k)
            {
                int res = 0;
                //将字符串切分成多个小段 分别在求解
                for (String t : s.split(String.valueOf(ca))) {
                    res = Math.max(res, longestSubstring(t, k));
                }
                return res;
            }
        }
        //原字符串里面没有小于k的字符串 直接返回字符串长度
        return s.length();
    }
}



//官方题解
class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        return dfs(s, 0, n - 1, k);
    }

    public int dfs(String s, int l, int r, int k) {
        int[] cnt = new int[26];
        for (int i = l; i <= r; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        char split = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }
        if (split == 0) {
            return r - l + 1;
        }

        int i = l;
        int ret = 0;
        while (i <= r) {
            while (i <= r && s.charAt(i) == split) {
                i++;
            }
            if (i > r) {
                break;
            }
            int start = i;
            while (i <= r && s.charAt(i) != split) {
                i++;
            }

            int length = dfs(s, start, i - 1, k);
            ret = Math.max(ret, length);
        }
        return ret;
    }
}


