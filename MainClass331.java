https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/solution/pai-an-jiao-jue-de-liang-chong-jie-fa-zh-66nt/

public static boolean isValidSerialization(String s) {
    if (s == null || s.length() == 0) return true;
    String[] str = s.split(",");
    int n = str.length;
    if ("#".equals(str[0]) && n > 1) return false;
    if ("#".equals(str[0])) return true;

    Deque<String> stack = new LinkedList<>();
    int i = 0;
    while ( i < n ) {
        String c = str[i];
        if (!"#".equals(c)) { // 遇到的不是'#'，直接入栈
            stack.push(c);
            i++;
        } else {
            if ("#".equals(stack.peek())){ // 遇到'#'，当前栈顶也是'#'，弹出2个字符，压入1个'#'
                stack.pop();
                if (stack.isEmpty()) return false;
                stack.pop(); 
                // i 位置不动，继续处理当前字符'#'，循环判断是否依旧满足2）
            } else {
                stack.push(c); // 栈顶不是'#'，直接入栈
                i++;
            }
        }
    }
    return stack.size() == 1 && "#".equals(stack.peek());
}

//写法二 推荐
class Solution {
    public boolean isValidSerialization(String preorder) {
        String str[] = preorder.split(",");
        
        Stack<String> st = new Stack<>();
        for(String s : str){
            if (s.equals("#")) {
                while (!st.isEmpty() && "#".equals(st.peek())) {
                    st.pop();
                    if (st.isEmpty()) return false;
                    st.pop();
                } 
            }
            st.push(s);
        }

        return st.size() == 1 && "#".equals(st.peek());
    }
}

// 第一种解法 推荐
class Solution {
    public boolean isValidSerialization(String preorder) {
        LinkedList<String> stack = new LinkedList<>();
        for (String s : preorder.split(",")) {
            stack.push(s);
            while (stack.size() >= 3
                    && stack.get(0).equals("#")
                    && stack.get(1).equals("#")
                    && !stack.get(2).equals("#")) {
                stack.pop();
                stack.pop();
                stack.pop();
                stack.push("#");
                    }
        }
        return stack.size() == 1 && stack.pop().equals("#");
    }
}

// 第二种解法
class Solution {
    public boolean isValidSerialization(String preorder) {
        int diff = 1;
        for(String s : preorder.split(",")){
            diff--;
            // 每加入一个节点 都要先减去一个入度   若该节点是非空节点 还要再加上两个出度
            // 遍历完之前，出度是大于等于入度的    1个出度认为提供一个挂载点  1个入度认为消耗一个挂载点
            // 若小于等于 消耗的挂载点 大于等于 提供的挂载点  不可能再继续遍历挂载剩下的节点了
            if (diff < 0){
                return false;
            }
            if(!s.equals("#")){
                diff += 2;
            }
        }
        return diff == 0;
    }
}

//kalipy 写法二 注意:diff<=0的判断一定要放for循环最上面!!!(因为90line还要判断diff,所以for里的判断要放最上面)
class Solution {
    public boolean isValidSerialization(String preorder) {
        int diff = 1;
        String str[] = preorder.split(",");
        
        for(String s : str){
            if (diff <= 0){
                return false;
            }
            if(!s.equals("#")){
                diff += 1;
            }
            else if(s.equals("#")){
                diff -= 1;
            }
 
        }
        return diff == 0;//90line
    }
}
