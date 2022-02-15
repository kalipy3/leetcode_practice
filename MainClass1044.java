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
