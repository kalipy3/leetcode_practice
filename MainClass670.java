/*
 * MainClass670.java
 * Copyright (C) 2022 2022-01-30 10:02 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//推荐方法二和方法三
//方法一暴力破解 草 暴力都能超33%
public class Solution {

    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        char[] charArray = s.toCharArray();
        int max = num;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                swap(charArray, i, j);
                max = Math.max(max, Integer.parseInt(new String(charArray)));
                swap(charArray, i, j);
            }
        }
        return max;
    }

    private void swap(char[] charArray, int index1, int index2) {
        char temp = charArray[index1];
        charArray[index1] = charArray[index2];
        charArray[index2] = temp;
    }
}

//方法二 排序 
/**
 * 将数字从大到小排列，与原数字比较，找出第一位置不一样的数
 * 如8217排序后变为8721，两两对比，第二个数不同，表示7和2交换，得到结果8712
 * 注意如果有重复数字，要取该重复数字的最后一个，比如：
 * old: 2776
 * order: 7762
 * 7276x   vs   7726v
 */
public int maximumSwap(int num) {
    //1.排序数组元素
    char[] orderNum = Integer.toString(num).toCharArray();
    char[] oldNum = Integer.toString(num).toCharArray();
    Arrays.sort(orderNum);//这里是从小到大排列

    int diff = -1;
    //2.比较第一个不同的元素
    for (int i = 0; i < orderNum.length; i++) {
        if (oldNum[i] != orderNum[orderNum.length - 1 - i]) {
            diff = i;
            break;
        }
    }

    //两数相同，不需要交换
    if (diff == -1) return num;

    for (int i = oldNum.length - 1; i >= diff; i--) {
        if (oldNum[i] == orderNum[orderNum.length - 1 - diff]) {
            //交换后直接跳出
            swap(oldNum, diff, i);
            break;
        }
    }

    return Integer.parseInt(new String(oldNum));
}

private void swap(char[] chars, int lo, int hi) {
    char tmp = chars[lo];
    chars[lo] = chars[hi];
    chars[hi] = tmp;
}


//方法三 贪心 请直接下面文字解释和代码 通俗易懂
//解释1：
//我们将计算 last[d] = i，最后一次出现的数字 d（如果存在）的索引 i。
//然后，从左到右扫描数字时，如果将来有较大的数字，我们将用最大的数字交换；如果有多个这样的数字，我们将用最开始遇到的数字交换。


//解释2：
//核心就一句话：就是把一个小数和它后面最大的大数进行交换
//要让一个数变大，要尽可能的让其高位变大
//比如说 2736 ， 让最高位2变大成3，也比让3那位变成9来的大， 3736 >>>> 2796
//所以，本题的核心要义就是 让最高位的小数和后面的大数交换
//
//小数我们找到了，那那个大数怎么找呢？大数需要满足以下特点
//
//    比小数靠后(废话)
//    值比小数大(废话)
//    尽可能的后(因为，该大数位交换后，来的是个小数，所以要把这个小数尽可能放到后面去)
//    比如 12344 ，是42341 大还是 42314 大呢？显而易见嘛
//
//有的朋友会问：欸欸欸，怎么感觉还是有点不对，说不清哪里不对。
//
//没错，还有一个关键修饰词：尽可能
//
//什么叫尽可能？就是在限制条件下求极致，那限制条件是什么呢？
//
//尽可能的后是我们要追求的，但我们不能忘记初心：最大值！！！小数后面的最大值，无论你多靠后，只要你不是最大值，不好意思，pass
//推荐
public class Solution {

    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        char[] charArray = s.toCharArray();

        // 记录每个数字最后一次出现的下标
        int[] last = new int[10];
        for (int i = 0; i < len; i++) {
            last[charArray[i] - '0'] = i;
        }

        // 从左向右扫描，找到当前位置右边的最大的数字并交换
        for (int i = 0; i < len - 1; i++) {
            // 找最大，所以倒着找
            for (int d = 9; d > charArray[i] - '0'; d--) {
                if (last[d] > i) {
                    swap(charArray, i, last[d]);
                    // 只允许交换一次，因此直接返回
                    return Integer.parseInt(new String(charArray));
                }
            }
        }
        return num;
    }

    private void swap(char[] charArray, int index1, int index2) {
        char temp = charArray[index1];
        charArray[index1] = charArray[index2];
        charArray[index2] = temp;
    }
}

