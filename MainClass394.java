//官方题解 方法一
class Solution {
    int ptr;

    public String decodeString(String s) {
        LinkedList<String> stk = new LinkedList<String>();
        ptr = 0;

        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                // 获取一个数字并进栈
                String digits = getDigits(s);
                stk.addLast(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                // 获取一个字母并进栈
                stk.addLast(String.valueOf(s.charAt(ptr++))); 
            } else {
                ++ptr;
                LinkedList<String> sub = new LinkedList<String>();
                while (!"[".equals(stk.peekLast())) {
                    sub.addLast(stk.removeLast());
                }
                Collections.reverse(sub);
                // 左括号出栈
                stk.removeLast();
                // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);
                // 构造字符串
                while (repTime-- > 0) {
                    t.append(o);
                }
                // 将构造好的字符串入栈
                stk.addLast(t.toString());
            }
        }

        return getString(stk);
    }

    public String getDigits(String s) {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }

    public String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }
}

//kalipy写法 我是不知道为什么错了
class Solution {
    int cur = 0;
    public String decodeString(String s) {
        Deque<String> st = new LinkedList<>();

        while (cur < s.length()) {
            if (s.charAt(cur) >= '0' && s.charAt(cur) <= '9') {
                String digit = getDigit(s);
                st.offerLast(digit);
            } else if (s.charAt(cur) == '[' || Character.isLetter(s.charAt(cur))) {
                st.offerLast(s.charAt(cur) + "");
                cur++;
            } else {
                cur++;
                StringBuilder sub = new StringBuilder();
                while (!"[".equals(st.peekLast())) {
                    sub.append(st.pollLast());
                }
                sub = sub.reverse();

                st.pollLast();
                int digit = Integer.valueOf(st.pollLast());
                StringBuilder sb = new StringBuilder();
                while (digit > 0) {
                    sb.append(sub);
                    digit--;
                }
                st.offerLast(sb.toString());
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pollFirst());
        }

        return ans.toString();
    }

    private String getDigit(String str) {
        int digit = 0;
        while (Character.isDigit(str.charAt(cur))) {
            digit = digit * 10 + (str.charAt(cur) - '0');
            cur++;
        }
        return digit + "";
    }
}
