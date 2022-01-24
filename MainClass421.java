//官方题解 方法一
class Solution {
    // 最高位的二进制位编号为 30
    static final int HIGH_BIT = 30;

    public int findMaximumXOR(int[] nums) {
        int x = 0;
        for (int k = HIGH_BIT; k >= 0; --k) {
            Set<Integer> seen = new HashSet<Integer>();
            // 将所有的 pre^k(a_j) 放入哈希表中
            for (int num : nums) {
                // 如果只想保留从最高位开始到第 k 个二进制位为止的部分
                // 只需将其右移 k 位
                seen.add(num >> k);
            }

            // 目前 x 包含从最高位开始到第 k+1 个二进制位为止的部分
            // 我们将 x 的第 k 个二进制位置为 1，即为 x = x*2+1
            int xNext = x * 2 + 1;//每次*2相当于左移1位，等价于int xNext = (x<<1)+1;注意:<<优先级很低，要加括号
            boolean found = false;

            // 枚举 i
            for (int num : nums) {
                if (seen.contains(xNext ^ (num >> k))) {
                    found = true;
                    break;
                }
            }

            if (found) {
                x = xNext;
            } else {
                // 如果没有找到满足等式的 a_i 和 a_j，那么 x 的第 k 个二进制位只能为 0
                // 即为 x = x*2
                x = xNext - 1;
            }
        }
        return x;
    }
}


//写法二
//作者：liweiwei1419
//链接：https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/solution/li-yong-yi-huo-yun-suan-de-xing-zhi-tan-xin-suan-f/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
public class Solution {

    // 先确定高位，再确定低位（有点贪心算法的意思），才能保证这道题的最大性质
    // 一位接着一位去确定这个数位的大小
    // 利用性质： a ^ b = c ，则 a ^ c = b，且 b ^ c = a

    public int findMaximumXOR(int[] nums) {
        int res = 0;
        int mask = 0;
        for (int i = 30; i >= 0; i--) {
            // 注意点1：注意保留前缀的方法，mask 是这样得来的
            // 用异或也是可以的 mask = mask ^ (1 << i);
            mask = mask | (1 << i);

            // System.out.println(Integer.toBinaryString(mask));
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                // 注意点2：这里使用 & ，保留前缀的意思（从高位到低位）
                set.add(num & mask);
            }

            // 这里先假定第 n 位为 1 ，前 n-1 位 res 为之前迭代求得
            int temp = res | (1 << i);
            for (Integer prefix : set) {
                if (set.contains(prefix ^ temp)) {
                    res = temp;
                    break;
                }
            }
        }
        return res;
    }
}


