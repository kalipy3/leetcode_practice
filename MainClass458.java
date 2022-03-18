/*
 * MainClass458.java
 * Copyright (C) 2022 2022-03-18 19:47 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

/* 请先看这个文字：
满脑子都是二进制老鼠那题，区别在于本题可能可以继续实验。从信息论的角度来说，原来的问题，对于N个bucket需要确认ceiling[log2(N)] bit的信息（十进制编号转二进制），而每个动物因为test的结果是死/生，二种可能。也就是说每个动物可以提供1 bit的信息。所以答案就是需要ceiling[log2(N)]个动物。

而本题存在多次实验的可能，也就是每个动物提供的信息不再是1 bit，而是大于1 bit，这是因为如果一个动物没死还能继续test。根据复杂的证明，存在n次测试，则每个动物提供的是(n+1)进制的一个基本单位（就像bit对于二进制），那么也就是说，求X * log2(n) = ceiling[log2(N)]（log2(n)将n进制基本单位转为二进制信息；一个码元可取m种离散值，则该码元能携带log2(m)位二进制信息)。

最终得到公式X = ceiling[log2(N) / log2(n)]

*/

//思路： 一个猪代表一个维度
//       例如：两头猪代表两个维度,一头猪代表行row,一头猪代表列column
//             通过minutesToTest/minutesToDie获取可以测试的轮数.
//             如：我们有25个桶,5行5列. 
//                 第1次,测试第1行,第1列
//                 第2次,测试第2行,第2列 ......
//                 行猪死在第3次,列猪死在第2次,说明第3行第2列的桶是***
//                 实际上,并不用测试满5次,第4次时就可以确定答案了
//                 如果测试完第4次后,行猪和列猪都没有死,说明第5行第5列的桶是***,而无需额外的测试
//             所以每一个维度的最大值为minutesToTest/minutesToDie+1
//             那么我们只需要确定需要有多少个维度(猪)能够满足条件即可
class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0;
        int maxRound = minutesToTest/minutesToDie+1;
        while(Math.pow(maxRound,pigs) < buckets){
            pigs++;
        }
        return pigs;
    }
}

//请先看这个好题解 通俗易懂 链接：https://leetcode-cn.com/problems/poor-pigs/solution/hua-jie-suan-fa-458-ke-lian-de-xiao-zhu-by-guanpen/
class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int times = minutesToTest / minutesToDie;
        int base = times + 1;
        // base ^ ans >= buckets
        // ans >= log(buckets) / log(base)
        double temp = Math.log(buckets) / Math.log(base);
        int ans = (int)Math.ceil(temp)
        return ans;
    }
}



/*
用猪猪的生死状态：

    一只猪在一次观察中，他的状态只有两种，活着或者死了。此时可以判断两桶水中哪一桶有毒。
    n只猪在一次观察中，他们的状态有2^n种。此时可以判断2^n桶中哪一桶有毒。具体方式为：将各个桶用2进制编码，第i只猪喝去喝所有[二进制编码中第i位为1的]桶，如果第1、3、4猪死了，说明二进制为0000001101的水桶有毒。
    一只猪在k次观察中，他的状态有k+1种：第一次就死了、第二次就死了...第k次才死、最后还活着。此时可以判断k+1桶水中哪个有毒。具体地，用k+1进制将水桶编码，第一次喝第0桶，第k次喝第k-1桶，如果最后没死就是第k桶有毒。
    n只猪在k次观察中，他们的状态共有(k+1)^n种，则最多可以判断这么多桶水中哪个有毒。

class Solution {
public:
    int poorPigs(int buckets, int minutesToDie, int minutesToTest) {

        if (buckets == 1) return 0;

        int runs = minutesToTest / minutesToDie;   // 多少次观察
        int status = runs + 1;                   // 一只猪有多少种状态
        int pigs = 1;
        int covered = status;                  // 可以判断多少桶水

        while (covered < buckets) {
            // 如果猪不够用，则增加一只猪，同时能够判断的水桶变成加猪之前的status倍
            covered *= status;
            pigs++;
        }

        return pigs;
    }
};

谷歌经典题目是test时间==die时间, 使用二进制表示, 这个题目多了个时间不等的情况, 可以使用N+1进制表示(一只猪可以表示N+1个状态,其中N=minutesToTest/minutesToDie),比如1000只猪, 测试4次, 1000在5进制表示下为13000, 一共5位, 所以只需要5只小猪就行了

*/
