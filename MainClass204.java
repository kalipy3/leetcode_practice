/*
 * MainClass204.java
 * Copyright (C) 2022 2022-02-09 22:43 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//官方题解 方法一 暴力 超时
class Solution {
    public int countPrimes(int n) {
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            ans += isPrime(i) ? 1 : 0;
        }
        return ans;
    }

    public boolean isPrime(int x) {
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}

//官方题解 方法二
class Solution {
    public int countPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                ans += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
}

//方法二 写法二
//先看这个图解 https://leetcode-cn.com/problems/count-primes/solution/ji-shu-zhi-shu-bao-li-fa-ji-you-hua-shai-fa-ji-you/
class Solution {
    
    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        // 从 2 开始枚举到 sqrt(n)。
        for (int i = 2; i * i < n; i++) {
            // 如果当前是素数
            if (isPrim[i]) {
                // 就把从 i*i 开始，i 的所有倍数都设置为 false。
                for (int j = i * i; j < n; j+=i) {
                    isPrim[j] = false;
                }
            }
        }

        // 计数
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                cnt++;
            }
        }
        return cnt;
    }
}


//写法三 推荐
class Solution {
    public int countPrimes(int n) {
        int arr[] = new int[n];
        Arrays.fill(arr, 1);

        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (arr[i] == 1) {
                ans++;
                for (int j = i+i; j < n; j+=i) {
                    arr[j] = 0;
                }
            }
        }
        return ans;

    }
}
