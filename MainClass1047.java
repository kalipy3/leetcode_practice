//思路：栈 直接看代码
class Solution {
    public String removeDuplicates(String s) {
        StringBuffer stack = new StringBuffer();
        int top = -1;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }
}

//写法二 kalipy
class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (sb.length() != 0 && c == sb.charAt(sb.length()-1)) {
                sb.deleteCharAt(sb.length()-1);
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}

