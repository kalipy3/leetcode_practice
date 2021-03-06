import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//方法一:https://leetcode-cn.com/problems/restore-ip-addresses/solution/fu-yuan-ip-di-zhi-bao-li-by-wo-yao-chu-q-0j62/
//class Solution {
//    public List<String> restoreIpAddresses(String s) {
//        List<String> list = new ArrayList();
//        for(int a=1; a<4; a++){
//            for(int b=1; b<4; b++){
//                for(int c=1; c<4; c++){
//                    for(int d=1; d<4; d++){
//                        if(a+b+c+d==s.length()){
//                            String s1 = s.substring(0, a);
//                            String s2 = s.substring(a, a+b);
//                            String s3 = s.substring(a+b, a+b+c);
//                            String s4 = s.substring(a+b+c, a+b+c+d);
//
//                            if(check(s1)&&check(s2)&&check(s3)&&check(s4)){
//                                String ip = s1+"."+s2+"."+s3+"."+s4;
//                                list.add(ip);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return list;
//    }
//
//    public boolean check(String s){
//        if(Integer.valueOf(s)<=255){
//            if(s.charAt(0)!='0' || s.charAt(0)=='0'&&s.length()==1) 
//                return true;
//        }
//        return false;
//    }
//}

//方法二
//作者：carlsun-2
//链接：https://leetcode-cn.com/problems/restore-ip-addresses/solution/dai-ma-sui-xiang-lu-93-fu-yuan-ip-di-zhi-pzjo/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution {
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return result; // 算是剪枝了
        backTrack(s, 0, 0);
        return result;
    }

    // startIndex: 搜索的起始位置， pointNum:添加逗点的数量
    private void backTrack(String s, int startIndex, int pointNum) {
        if (pointNum == 3) {// 逗点数量为3时，分隔结束
            // 判断第四段⼦字符串是否合法，如果合法就放进result中
            if (isValid(s,startIndex,s.length()-1)) {
                result.add(s);
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                /* test.java
                String str = "abcde";
                System.out.println(str.substring(0,0));//
                System.out.println(str.substring(0,1));//a
                System.out.println(str.substring(0));//abcde
                System.out.println(str.substring(1));//bcde
                */
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);    //在str的后⾯插⼊⼀个逗点
                pointNum++;
                backTrack(s, i + 2, pointNum);// 插⼊逗点之后下⼀个⼦串的起始位置为i+2
                pointNum--;// 回溯
                s = s.substring(0, i + 1) + s.substring(i + 2);// 回溯删掉逗点
            } else {
                break;
            }
        }
    }

    // 判断字符串s在左闭⼜闭区间[start, end]所组成的数字是否合法
    private Boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) { // 0开头的数字不合法
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }
}


//方法二
List<String> res = new ArrayList<>();
List<String> path = new ArrayList<>();

public List<String> restoreIpAddresses(String s) {
    backtracking(s,0,path);
    return res;
}

private void backtracking(String s, int index, List<String> path) {
    if (path.size() == 4 && index == s.length()){
        // 收集
        String ans = "";
        for (String s1 : path) {
            ans += s1;
            ans += ".";
        }
        res.add(ans.substring(0,ans.length() - 1));
    }
    if (path.size() == 4 && index != s.length()) return;
    for (int i = index; i < s.length() && i < index + 3; i++) {
        if (isIp(s,index,i)){
            path.add(s.substring(index,i + 1));
            backtracking(s,i + 1,path);
            path.remove(path.size() - 1);
        }
    }
}

private boolean isIp(String s, int index, int end) {
    if (s.charAt(index) == '0' && end - index >= 1) return false;
    int sum = 0;
    for (int j = index; j <= end; j++) {
        int tmp = s.charAt(j) - '0';
        sum = sum*10 + tmp;
    }
    if (sum >= 0 && sum <= 255) return true;
    return false;
}


//kalipy一次过 送分题
class Solution {
    List<String> ans = new LinkedList<>();
    List<String> list = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0);

        return ans;
    }

    private void dfs(String s, int idx) {
        if (list.size() == 4 && idx == s.length()) {
            ans.add(list.get(0) + "." + list.get(1) + "." + list.get(2) + "." + list.get(3));
            return;
        }

        if (list.size() == 4 && idx != s.length()) return;//没有也ok

        for (int i = idx; i < s.length(); i++) {
            if (isIp(s, idx, i)) {
                list.add(s.substring(idx, i + 1));
                dfs(s, i + 1);
                list.remove(list.size() - 1);
            } else {
                break;
            }
        }
    }

    private boolean isIp(String s, int start, int end) {
        if (start > end) return false;
        if (s.charAt(start) == '0' && end - start >= 1) return false;

        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum = sum * 10 + (s.charAt(i) - '0');
        }

        return sum <= 255;
    }
}
