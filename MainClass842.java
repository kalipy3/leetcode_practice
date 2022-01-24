//先看这个题解 然后看写法二和写法三
链接：https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/solution/javahui-su-suan-fa-tu-wen-xiang-jie-ji-b-vg5z/
//写法一
public List<Integer> splitIntoFibonacci(String S) {
    List<Integer> res = new ArrayList<>();
    backtrack(S.toCharArray(), res, 0);
    return res;
}

public boolean backtrack(char[] digit, List<Integer> res, int index) {
    //边界条件判断，如果截取完了，并且res长度大于等于3，表示找到了一个组合。
    if (index == digit.length && res.size() >= 3) {
        return true;
    }
    for (int i = index; i < digit.length; i++) {
        //两位以上的数字不能以0开头
        if (digit[index] == '0' && i > index) {
            break;
        }
        //截取字符串转化为数字
        long num = subDigit(digit, index, i + 1);
        //如果截取的数字大于int的最大值，则终止截取
        if (num > Integer.MAX_VALUE) {
            break;
        }
        int size = res.size();
        //如果截取的数字大于res中前两个数字的和，说明这次截取的太大，直接终止，因为后面越截取越大
        if (size >= 2 && num > res.get(size - 1) + res.get(size - 2)) {
            break;
        }
        if (size <= 1 || num == res.get(size - 1) + res.get(size - 2)) {
            //把数字num添加到集合res中
            res.add((int) num);
            //如果找到了就直接返回
            if (backtrack(digit, res, i + 1))
                return true;
            //如果没找到，就会走回溯这一步，然后把上一步添加到集合res中的数字给移除掉
            res.remove(res.size() - 1);
        }
    }
    return false;
}

//相当于截取字符串S中的子串然后转换为十进制数字
private long subDigit(char[] digit, int start, int end) {
    long res = 0;
    for (int i = start; i < end; i++) {
        res = res * 10 + digit[i] - '0';
    }
    return res;
}




//写法二
class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ans = new ArrayList<>();
        return backTrack(S, ans, 0) ? ans : new ArrayList<>();
    }

    private boolean backTrack(String S, List<Integer> ans, int start) {
        if (ans.size() >= 3) {
            int num = ans.size();
            //不满足斐波那契
            if (ans.get(num - 1) != ans.get(num - 2) + ans.get(num - 3)) {
                return false;
            }
        }
        if (start == S.length() && ans.size() >= 3) {
            return true;
        }
        //kalipy: 对比着n叉树的图来看for循环,图在下面链接里:
        //链接：https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/solution/javahui-su-suan-fa-tu-wen-xiang-jie-ji-b-vg5z/ 前序遍历 root, 左子树，又子树
        for (int i = start + 1; i <= S.length(); i++) {
            String tmp = S.substring(start, i);
            //当前数字以0开头但不是0，返回false
            if (tmp.charAt(0) == '0' && !"0".equals(tmp)) {
                break;
            }
            long num = Long.parseLong(tmp);
            //当前数字超过int的范围，返回false
            if (num > Integer.MAX_VALUE) {
                break;
            }
            ans.add((int) num);
            if (backTrack(S, ans, i)) {
                return true;
            }
            ans.remove(ans.size() - 1);
        }
        return false;
    }
}


//写法三 kalipy
class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> ans = new LinkedList<>();

        return backTrack(num, ans, 0) ? ans : new LinkedList<>();
    }

    public boolean backTrack(String num, List<Integer> ans, int start) {
        if (ans.size() >= 3) {
            if (ans.get(ans.size()-1) != ans.get(ans.size()-2)+ans.get(ans.size()-3)) {
                return false;
            }
        }

        if (start == num.length() && ans.size()>=3) {
            return true;
        }

        for (int i = start; i < num.length(); i++) {
            String str = num.substring(start, i+1);
            //String str = num.substring(start, i);
            
            //if (str.charAt(0) == '0' && !"0".equals(str)) {
            if (str.charAt(0)=='0' && str.length()>1) {
                break;
            }

            long digit = Long.parseLong(str);

            if (digit > Integer.MAX_VALUE) {
                break;
            }

            ans.add((int)digit);
           // backTrack(num, ans, start+1);
            if (backTrack(num, ans, i+1)) {
                return true;
            }
            ans.remove(ans.size()-1);
        }

        return false;
    }
}
