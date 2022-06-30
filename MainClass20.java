//推荐
public boolean isValid(String s) {
    if(s.isEmpty())
        return true;
    Stack<Character> stack=new Stack<Character>();
    for(char c:s.toCharArray()){
        if(c=='(')
            stack.push(')');
        else if(c=='{')
            stack.push('}');
        else if(c=='[')
            stack.push(']');
        else if(stack.empty()||c!=stack.pop())
            return false;
    }

    return stack.empty();
}

//作者：kalipy
//链接：https://leetcode-cn.com/problems/valid-parentheses/solution/lai-ge-zheng-chang-si-wei-tong-su-yi-don-vcaj/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//kalipy的
class Solution {
    public boolean isValid(String s) {
        if (s.length() == 1) return false;

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push('(');
                //continue;
            } 
            else if ( s.charAt(i) == '{'){
                st.push('{');
                //continue;
            }
            else if (s.charAt(i) == '[') {
                st.push('[');
                //continue;
            } 

            else if (!st.isEmpty()) {
                if (s.charAt(i) == ')' && st.peek() == '(') {
                    st.pop();
                } 
                else if (s.charAt(i) == '}' && st.peek() == '{') {
                    st.pop();
                } 
                else if (s.charAt(i) == ']' && st.peek() == '[') {
                    st.pop();
                } else return false; 
            } else {
                return false;
            }
        }

        return st.isEmpty();
    }
}


//推荐
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            //左括号入栈
            if(c == '(' || c == '[' || c == '{')
                stack.push(c);
            //碰到右括号的情况
            else{
                // 栈为空，false
                if(stack.isEmpty())
                    return false;
                // 栈不为空，但栈顶元素不匹配，false
                else if(c == ')' && stack.pop() != '(' || c == ']' && stack.pop() != '[' || c == '}' && stack.pop() != '{')
                    return false;
            }
        }
        // 左括号有剩余
        // 字符序列遍历完，但是栈不为空，则也不是合法的序列
        return stack.isEmpty();
    }
}
