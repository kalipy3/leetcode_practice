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


