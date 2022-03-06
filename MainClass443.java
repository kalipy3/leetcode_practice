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

//写法三 推荐 不易错
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
