作者：fuxuemingzhu
链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii/solution/fen-xiang-hua-dong-chuang-kou-mo-ban-mia-f76z/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution {
    public int longestOnes(int[] A, int K) {
        int N = A.length;
        int res = 0;
        int left = 0, right = 0;
        int zeros = 0;
        while (right < N) {
            if (A[right] == 0)
                zeros ++;
            while (zeros > K) {
                if (A[left++] == 0) 
                    zeros --;
            }
            res = Math.max(res, right - left + 1);
            right ++;
        }
        return res;
    }
}


