/*
 * MainClass575.java
 * Copyright (C) 2022 2022-03-15 22:07 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//智障测试题 kalipy一次过
class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> set = new HashSet<>();

        for (int x : candyType) {
            set.add(x);
        }

        return Math.min(candyType.length/2, set.size());
    }
}
