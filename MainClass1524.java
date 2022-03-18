/*
 * MainClass1524.java
 * Copyright (C) 2022 2022-02-02 20:39 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

/* 方法一
链接：https://leetcode-cn.com/problems/number-of-sub-arrays-with-odd-sum/solution/python-qian-zhui-he-qi-ou-by-brillant_o-/
class Solution:
    def numOfSubarrays(self, arr: List[int]) -> int:
        sums = [0]
        odd = 0
        even = 0
        for i in range(len(arr)):
            sums.append(sums[-1] + arr[i])
            if sums[-1] % 2 == 0:
                even += 1
            else:
                odd += 1
        return int((odd + odd*even) % (1e9+7))

*/

//请看官方题解
class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MODULO = 1000000007;
        int odd = 0, even = 1;
        int subarrays = 0;
        int sum = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            sum += arr[i];
            subarrays = (subarrays + (sum % 2 == 0 ? odd : even)) % MODULO;
            if (sum % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return subarrays;
    }
}

//评论区
class Solution {
    public int numOfSubarrays(int[] arr) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        long sum = 0;
        int length = arr.length;
        hashMap.put(0,1);
        hashMap.put(1,0);
        long count = 0;
        for (int i = 0;i < length;i++) {
            sum += arr[i];
            if (sum % 2 == 1) {
                count += hashMap.get(0);
                hashMap.put(1,hashMap.get(1)+1);
                sum = 1;
            }else {
                count += hashMap.get(1);
                hashMap.put(0,hashMap.get(0)+1);
                sum = 0;
            }
        }

        return (int)(count % 1000000007);
}
}

//评论区 推荐
/*
class Solution {
public:
    int numOfSubarrays(vector<int>& arr) {
        long long even_pre_sum = 1; // [num] 可以理解为0 + num
        long long odd_pre_sum = 0;//奇数前缀和的数量
        long long sum = 0;
        int ans = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr[i];
            if (sum % 2 == 1) {
                ans += even_pre_sum;
                odd_pre_sum++;
            } else {
                ans += odd_pre_sum;
                even_pre_sum++;
            }
            ans %= 1000000007;
        }
        return ans;
    }
};
*/
