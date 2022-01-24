//官方题解 先看官方题解
class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<Character>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }
}


作者：xiao_ben_zhu
链接：https://leetcode-cn.com/problems/remove-k-digits/solution/wei-tu-jie-dan-diao-zhan-dai-ma-jing-jian-402-yi-d/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new LinkedList<>();
        for(char c : num.toCharArray()){
            while(k > 0 && !stack.isEmpty() && c < /*stack.peekLast()*/stack.peekLast()){
                //stack.pop();
                stack.pollLast();
                k--;
            }
            if( c != '0' || !stack.isEmpty()){
                //stack.push(c);
                stack.offerLast(c);
            }
        }

        while( k > 0 && !stack.isEmpty()){
            //stack.pop();
            stack.pollLast();
            k--;
        }

        StringBuffer buffer = new StringBuffer();
        while(!stack.isEmpty()){
            //System.out.println(stack.peekLast());
            buffer.append(stack.pollFirst());
        }

        return buffer.length() == 0 ? "0" : buffer.toString();
    }
}
