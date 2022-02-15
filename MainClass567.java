//请直接看代码，直到看懂为止

class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        
        // 排除异常的边界情况，也限定了模式串的长度
        if(s1.size() > s2.size()) return false;
        
        // 匹配采用的窗口大小为模式串大小
        int windowSize = s1.size();//2
        
        // 模式串的字典：可以看做一种频率分布
        vector<int> hashmap1(26, 0);
        // 动态更新的匹配窗口字典
        vector<int> hashmap2(26, 0);
        
        // 构建字典
        for(int i = 0; i < windowSize; i++) {
            hashmap1[s1[i] - 'a']++;//{a=1,b=1}
            hashmap2[s2[i] - 'a']++;//{e=1,i=1}
        }
        
        //i=2,
        // 对于每一轮滑窗查询，如果两个字典相等(频率分布一致)，则命中
        for(int i = windowSize; i < s2.size(); i++) {
            // 两个字典相等(频率分布一致)，则命中
            if(hashmap1 == hashmap2) return true;
            
            // 否则，向右滑窗：滑窗对于 hash 表的操作变为对应频率的增减
            hashmap2[s2[i - windowSize] - 'a']--;
            hashmap2[s2[i] - 'a']++;
        }
        
        // 整个算法采用左闭右开区间，因此最后还有一个窗口没有判断
        return hashmap1 == hashmap2;
    }
};


//Java版
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {//这句不能少
            return true;
        }
        for (int i = n; i < m; ++i) {
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }
}


