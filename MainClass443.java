//请直接看这个代码 kalipy用一下午选出来的最好的写法
//写法二 推荐
class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int insertIndex = 0;
        int curr = 0;
        while (curr < n) {
            chars[insertIndex++] = chars[curr];
            int next = curr + 1;
            while (next < n && chars[next] == chars[curr]) {
                next++;
            }
            int count = next - curr;
            if (count > 1) {
                String str = Integer.toString(count);
                for (int i = 0; i < str.length(); i++) {
                    chars[insertIndex++] = str.charAt(i);
                }
            }
            curr = next;
        }
        return insertIndex;
    }
}

//写法三 推荐 不易错 强烈推荐
public int compress(char[] chars) {
    StringBuilder sb = new StringBuilder();
    int l = 0;
    int r = 0;
    int len = chars.length;
    while (r < len){
        r++;
        while (r < len && chars[l] == chars[r]){
            r++;
        }
        sb.append(chars[l]);
        if(r - l > 1){
            sb.append(r - l);
        }
        l = r;
    }
    String s = sb.toString();
    for (int i = 0; i < s.length(); i++) {
        chars[i] = s.charAt(i);
    }
    return s.length();
}

//kalipy 错误写法 请看测试用例
/*
输入：
["a","a","a","b","b","a","a"]
输出：
["a","5","b","2"]
预期结果：
["a","3","b","2","a","2"]
*/
class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int idx = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            sb.append(key);
            if (val > 1) {
                StringBuilder sub = new StringBuilder();
                int tIdx = 0;
                while (val != 0) {
                    sub.append(val % 10);
                    val /= 10;
                }
                sb.append(sub.reverse());
            }
        }

        String s = sb.toString();
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        return s.length();
    }
}
