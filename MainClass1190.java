/*
 * MainClass1190.java
 * Copyright (C) 2022 2022-02-17 18:16 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//送分题 方法一 推荐
//请看这个图解 https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/solution/zhan-dong-tu-yan-shi-by-xiaohu9527-hua8/
class Solution {
    public String reverseParentheses(String s) {
        Deque<String> stack = new LinkedList<String>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (ch == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}

//kalipy一次过 送分题 请直接凭自己的思路开写即可
class Solution {
    public String reverseParentheses(String s) {
        Deque<Character> st = new LinkedList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ')') {
                StringBuilder sb = new StringBuilder();
                while (!st.isEmpty() && st.peekLast() != '(') {
                    sb.append(st.pollLast());
                }
                st.pollLast();
                for (char c : sb.toString().toCharArray()) {
                    st.offerLast(c);
                }

            } else {
                st.offerLast(s.charAt(i));
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pollFirst());
        }

        return ans.toString();
    }
}
