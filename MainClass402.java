//官方题解 先看官方图解

作者：xiao_ben_zhu
链接：https://leetcode-cn.com/problems/remove-k-digits/solution/wei-tu-jie-dan-diao-zhan-dai-ma-jing-jian-402-yi-d/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//推荐
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
