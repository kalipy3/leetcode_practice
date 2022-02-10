//参考评论区:我觉得这个题目没说清楚，应该说清连续就是两种情况，一种嵌套，一种两个两个成对出现

//方法二 官方题解
class Solution {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}


//方法三 官方题解
class Solution {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}

//方法一
//"()(()"
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<Integer>();
        int ans = 0;
        for(int i = 0 ,start = 0;i < s.length();i ++)
        {
            if( s.charAt(i) == '(') st.add(i);
            else
            {
                if(!st.isEmpty()) 
                {
                    st.pop();
                    if(st.isEmpty()) ans = Math.max(ans,i - start + 1);
                    else ans = Math.max(ans,i - st.peek());
                }
                else start = i + 1;
            }
        }
        return ans;
    }
}

作者：lin-shen-shi-jian-lu-k
链接：https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zhan-zui-jian-jie-yi-dong-de-dai-ma-cjav-xa7v/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


