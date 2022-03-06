作者：guanpengchn
链接：https://leetcode-cn.com/problems/longest-common-prefix/solution/hua-jie-suan-fa-14-zui-chang-gong-gong-qian-zhui-b/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) 
            return "";
        String ans = strs[0];
        for(int i =1;i<strs.length;i++) {
            int j=0;
            for(;j<ans.length() && j < strs[i].length();j++) {
                if(ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }
}


//kalipy一次过
class Solution {
    public String longestCommonPrefix(String[] strs) {

        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String cur = strs[i];
            int p1 = 0;
            int p2 = 0;
            while (p1 < ans.length() && p2 < cur.length()) {
                if (cur.charAt(p2) != ans.charAt(p1)) {
                    break;
                }
                p2++;
                p1++;
            }
            ans = ans.substring(0, p1);
            //ans = ans.substring(0, p2);//也ok
        }

        return ans;
    } 
}
