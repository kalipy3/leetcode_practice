//请直接看这里的解释和代码即可 通俗易懂
//
//判断子数组的和能否被 k 整除就等价于判断 (P[j]−P[i−1]) mod k==0，根据 同余定理，只要 P[j] mod k==P[i−1] ，就可以保证上面的等式成立。

//kalipy 推荐写法
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> record = new HashMap<Integer, Integer>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem : nums) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % k + k) % k;

            if (!record.containsKey(modulus)) {
                record.put(modulus, 1);
            } else {
                ans += record.get(modulus);
                record.put(modulus, record.get(modulus)+1);
            }

        }
        return ans;
    }
}

//kalipy一次过 推荐
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> record = new HashMap<Integer, Integer>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem : nums) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % k + k) % k;

            if (record.containsKey(modulus)) {
                ans += record.get(modulus);
            }

            record.put(modulus, record.getOrDefault(modulus, 0)+1);

        }
        return ans;
    }
}

