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

//写法一 kalipy一次过 送分题
class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> dq = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {

            if (!dq.isEmpty() && dq.peekLast() == s.charAt(i)) {
                dq.pollLast();
            } else {
                dq.offerLast(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append(dq.pollFirst());
        }

        return sb.toString();
    }
}
