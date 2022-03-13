//借群友一句话： 温馨提示, 今天这个打卡题出自136场周赛第四题, 当时国服只有6个人做出来 所以不会做很正常哦，直接来看题解吧
//先看这个题解 非常好懂 看完这个再看官方题解
//https://leetcode-cn.com/problems/longest-duplicate-substring/solution/wei-rao-li-lun-rabin-karp-er-fen-sou-suo-3c22/
/*
class Solution {
public:
    int n;
    unsigned long long prime = 31;
    string longestDupSubstring(string s) {
        n = s.size();
        int l = 1;
        int r = n - 1;
        int pos = -1;
        int len = 0;

        auto find = [&](int len){
            unsigned long long hash = 0;
            unsigned long long power = 1;
            for (int i = 0; i < len; i++) {
                hash = hash * prime + (s[i] - 'a');
                power *= prime;
            }
            unordered_set<unsigned long long> exist{hash};
            for(int i = len; i < n; i++) {
                hash = hash * prime - power * (s[i-len] - 'a') + (s[i] - 'a');
                if (exist.count(hash)) return (i - len + 1);
                exist.insert(hash);
            }
            return -1;
        };

        while(l <= r) {
            int mid = (l + r) / 2;
            int start = find(mid);
            if (start != -1) {
                len = mid;
                pos = start;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        if (pos == -1) return "";
        else return s.substr(pos, len);
    }
};

*/
//暴力破解 超时
class Solution {
    public String longestDupSubstring(String s) {
      
      String result = "";

      int length = s.length();
      if (length <= 1) {
          return result;
      }
      for(int i = length - 1; i >= 1; i--) {
          List<String> subStrs = new ArrayList<String>();
          int subLength = i;
          for (int j = 0; j <= length - subLength; j++) {
              String subStr = s.substring(j, j + subLength);
              if (subStrs.contains(subStr)) {
                  result = subStr;
                  break;
              } else {
                  subStrs.add(subStr);
              }
          }
          if (!"".equals(result)) {
              break;
          }
      }
      return result;
    }
}

/*
   二分+字符串哈希 (by:宫水三叶)
   为什么可以用到二分呢？ 开始想了很久也没想清楚，看了三叶姐的题解之后才知道，这个二分的用法
   首先 已知题目要求返回最长的重复子串，假设最长重复子串存在，当我们枚举每一种长度的时候
   都存在两种情况： 1. 当前枚举的子串长小于或等于最长重复子串，即该区间长度下，
   字符串中存在重复子串(考虑答案的子区间)
   2. 当前枚举的长度大于最长重复子串，即该区间下，不存在重复子串
   如果按照从1到n的情况枚举长度的话，选取区间的时间复杂度就达到了O(n)
   如果引入二分的思想，利用上述的两种情况做筛查，时间复杂度就下降到了O(logn)
   举例：0-10这个区间，第一次二分选中mid 5，此时检查字符串中所有长度为5的区间
   如果存在重复子串，则区间长的选取范围就被扩大到了 5-10
   如果不存在重复子串，则区间长的选取范围就缩小到了 0-4
   假设存在重复子串，再取mid 8 ( l + (r-l+1)/2 ),
   此时就要检查字符串中所有长度为8的子串是否存在重复子串

   依次类推，当l=r时，检查结束
   即当前区间存在重复子串时，往更高的区间找，当前区间不存在重复子串，缩小区间范围继续找

   搜索区间的办法想出来了，那如何检查一个规定区间长度下，字符串中所有取该长度的子串是否重复呢？
   一种高效的方式是字符串哈希，提前对字符串处理，
   保证在对比两个子串的时候利用两者的hash值能够做到O(1)的时间复杂度
   至于hash操作如何进行，可看宫水三叶的题解
   或者学习这篇文章 https://blog.csdn.net/qq_45778406/article/details/113920372


   执行用时：162 ms, 在所有 Java 提交中击败了86.01%的用户
   内存消耗：47.2 MB, 在所有 Java 提交中击败了53.89%的用户
   */

final static int P = 1313131;
long[] hash, base;
public String longestDupSubstring(String s) {
    String ans = "";
    if(s == null || s.length() == 0) return ans;
    int len = s.length();
    hash = new long[len+1];
    base = new long[len+1];
    base[0] = 1;
    for(int i = 0; i < len; i++){
        hash[i+1] = hash[i] * P + s.charAt(i);
        base[i+1] = base[i] * P;
    }
    int l = 0, r = len - 1;
    while(l < r){
        int mid = (l + r + 1) >> 1; // l + (r-l+1)/2 区间长
        String temp = check(s, mid);
        if(temp.length() > 0) l = mid; // 存在重复子串 扩大区间范围
        else r = mid-1; // 不存在则缩小区间范围
        ans = temp.length() > ans.length() ? temp : ans;
    }
    return ans;
}

/*
   计算所有长度为len的子串是否有重复
   */
String check(String s, int len){
    Set<Long> set = new HashSet<>();
    int end = s.length() - len + 1; // 最后一个区间的位置
    for(int i = 1; i <= end; i++){
        int j = i + len - 1;
        long h = hash[j] - hash[i-1] * base[j-i+1]; // 区间hash值公式
        if(!set.add(h)) return s.substring(i-1,j); // 如果重复 返回该子串
    }
    return "";
}
