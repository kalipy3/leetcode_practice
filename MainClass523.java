
//推荐写法三


//方法一 暴力破解
class Solution {
    public:
        bool checkSubarraySum(vector<int>& nums, int k) {
            int n = nums.size();
            vector<int> preSum(n+1);
            for(int i = 0; i < n; ++i)
                preSum[i+1] = preSum[i] + nums[i];

            for(int i = 0; i < n-1; ++i)
                for(int j = i+2; j <= n; ++j)
                    if((preSum[j] - preSum[i])%k == 0)
                        return true;
            return false;
        }
};

//官方题解
//使用哈希表存储每个余数第一次出现的下标。
//规定空的前缀的结束下标为 −1，由于空的前缀的元素和为 0，因此在哈希表中存入键值对 (0,−1)。
//同余定理：如果两个整数m、n满足n-m能被k整除，那么n和m对k同余
//
//即 ( pre(j) - pre (i) ) % k == 0 则 pre(j) % k == pre(i) % k
//
//推导 => pre (i) % k = (a0 + a1 + ... + ai) % k = (a0 % k + a1 % k + ... ai % k ) % k （该推导在简化前缀和的时候有用，说明当前前缀和 % k 不会影响后面的前缀和 % k ）
//
//哈希表 存储 Key ：pre(i) % k
//Value： i
//
//遍历过程：
//
//    计算前缀和 pre( j ) % k
//
//    当pre(j) % k 在哈希表中已存在，则说明此时存在 i 满足 pre(j) % k == pre(i) % k ( i < j )
//
//HashMap里，已知Key，可以取到Value 即i的值， 最后 判断 j - i >= 2 是否成立 即可
//
//    当 pre(j) % k 不存在于哈希表，则将 (pre(j) % k, j ) 存入哈希表
//
//因在计算 pre(i) = (pre(i-1) + nums[i]) % k 时，pre(i) 只与上一个状态有关
//
//故可以直接用变量pre 替代数组。 那么 求前缀和 % k 的公式就简化为 题解代码中的 remainder = (remainder + nums[i]) % k;
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int m = nums.length;
        if (m < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < m; i++) {
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }
}

//写法三
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            set.add(sum[i - 2] % k);
            if (set.contains(sum[i] % k)) return true;
        }
        return false;
    }
}

//写法四kalipy(也ok) 请注意:sum[i] = sum[i] + nums[i]是错误的写法，当时脑子短路不知道多久!!!!!!!!!!!!!!!!!!!!!!!!!!
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n];
        //for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) sum[i] = sum[i-1] + nums[i];
        for (int i =0;i<n;i++) {
            System.out.println(sum[i]);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < n; i++) {
            if (i == 1) {
                set.add(0);
            } else {
                set.add(sum[i - 2] % k);
            }

            if (set.contains(sum[i] % k)) return true;
        }
        return false;
    }
}



//写法二
//sum 是前 i+1 项和，每次加入集合的是前 i 项和的模。 当两个前缀和*关于模 k 同余*时，它们的差值就是满足条件的子数组和
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (set.contains(sum % k)) return true;
            set.add((sum - nums[i]) % k);
        }
        return false;
    }
}
