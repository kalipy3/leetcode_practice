/*
 * 面试题01_01.java
 * Copyright (C) 2022 2022-02-02 17:29 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//请直接看这里的注释和代码即可 推荐位运算

//1、利用 Set 不可重复性
class Solution {
    public boolean isUnique(String astr) {
        HashSet<Character> set = new HashSet<>();
        for(char c : astr.toCharArray()){
            if(!set.add(c)) {
                return false;
            }
        }
        return true;
    }
}

//2、用数组标识位置
class Solution {
    public boolean isUnique(String astr) {
        int[] hash = new int[26];
        for(char ch : astr.toCharArray()) {
            hash[ch - 'a']++;
            if(hash[ch - 'a'] > 1) {
                return false;
            }
        }
        return true;
    }
}

//基于bool数组的方法：
//由于题目没有明确说明，根据示例我判断字符串中出现的字符应该在['a','z']之间，实践证明确实如此。基于这个前提，使用bool数组的做法是定义一个长度为26的初始值全为0 bool数组，逐个字符遍历astr，如果bool数组中对应的下标（'a'->0, ..., 'z'->25）的值为1则重复出现，返回false，否则设置对应下标值为1。
//
//基于位运算的方法：
//我们可以使用一个int类型的变量（下文用mark表示）来代替长度为26的bool数组。假设这个变量占26个bit（在多数语言中，这个值一般不止26），那么我们可以把它看成000...00(26个0)，这26个bit对应着26个字符，对于一个字符c，检查对应下标的bit值即可判断是否重复。那么难点在于如何检查？这里我们可以通过位运算来完成。首先计算出字符char离'a'这个字符的距离，即我们要位移的距离，用move_bit表示，那么使用左移运算符1 << move_bit则可以得到对应下标为1，其余下标为0的数，如字符char = 'c'，则得到的数为000...00100，将这个数跟mark做与运算，由于这个数只有一个位为1，其他位为0，那么与运算的结果中，其他位肯定是0，而对应的下标位是否0则取决于之前这个字符有没有出现过，若出现过则被标记为1，那么与运算的结果就不为0；若之前没有出现过，则对应位的与运算的结果也是0，那么整个结果也为0。对于没有出现过的字符，我们用或运算mark | (1 << move_bit)将对应下标位的值置为1。
//

//3、位运算，用一个 int 来标识位置
class Solution {
    public boolean isUnique(String astr) {
        int mark = 0;
        for(char ch : astr.toCharArray()) {
            int index = ch - 'a';
            if((mark & (1 << index)) != 0) {
                return false;
            } else {
                mark |= (1 << index);
            }
        }
        return true;
    }
}


