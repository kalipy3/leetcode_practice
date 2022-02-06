//方法一暴力破解 kalipy一次过
class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    ans++;
                }
            }
        }

        return ans;
    }
}

//官方题解 方法二 请直接看本注释，看完后对照注释看代码
//两数之和，为a+b=k，遍历数组，若a已加入哈希表，对于b，看k-b是不是在哈希表中；本题，问题转化为两数之差，为a-b=k，无需我再解释了吧

//我们定义pre[i]为[0..i]里所有数的和
public class Solution {

    public int subarraySum(int[] nums, int k) {
        // key：前缀和，value：key 对应的前缀和的个数
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        // 对于下标为 0 的元素，前缀和为 0，个数为 1
        preSumFreq.put(0, 1);

        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;

            // 先获得前缀和为 preSum - k 的个数，加到计数变量里
            if (preSumFreq.containsKey(preSum - k)) {
                count += preSumFreq.get(preSum - k);
            }

            // 然后维护 preSumFreq 的定义
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);//获取指定 key 对应对 value,如果找不到 key ,则返回设置的默认值。
        }
        return count;
    }
}
