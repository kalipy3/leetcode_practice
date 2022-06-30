/*
 * MainClass605.java
 * Copyright (C) 2022 2022-02-02 10:13 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//请直接看代码和注释

//防御式编程思想：在 flowerbed 数组两端各增加一个 0， 这样处理的好处在于不用考虑边界条件，任意位置处只要连续出现三个 0 就可以栽上一棵花。
//推荐
class Solution {
    public boolean canPlaceFlowers(int[] nums, int n) {

        int flowerbed[] = new int[nums.length+2];
        for (int i = 0; i < flowerbed.length-2; i++) {
            flowerbed[i+1] = nums[i];
        }
   
        for (int i = 1; i < flowerbed.length-1; i++) {
            if (flowerbed[i-1] == 0 && flowerbed[i] == 0 && flowerbed[i+1] == 0) {
                n--;
                flowerbed[i] = 1;
            }
        }

        return n <= 0;
    }
}

//方法二
//推荐
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int ans = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            //判断当前位置能否种花
            //能种 ❀ 的情况
            if (flowerbed[i] == 0 
                    && (i + 1 == flowerbed.length || flowerbed[i + 1] == 0) 
                    && (i == 0 || flowerbed[i - 1] == 0)) {
                flowerbed[i] = 1;
                ans++;
                    }
        }
        return ans >= n;
    }
}
