/*
 * MainClass435.java
 * Copyright (C) 2022 2022-03-14 16:17 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//评论区 请直接看这个文字和代码 送分题
//记录一下大佬的思想： 贪心算法，按照起点排序：选择结尾最短的，后面才可能连接更多的区间（如果两个区间有重叠，应该保留结尾小的） 把问题转化为最多能保留多少个区间，使他们互不重复，则按照终点排序，每个区间的结尾很重要，结尾越小，则后面越有可能容纳更多的区间。

/*
class Solution {
public:
    int eraseOverlapIntervals(vector<Interval>& intervals) {
        if(intervals.size() == 0) return 0;
        int ans = 0;
        
        //按照 start 进行排序。
        sort(intervals.begin(), intervals.end(), [](const Interval &lhs, const Interval &rhs){
            return lhs.start < rhs.start;
        });
        int end = intervals[0].end;            //表示已经添加进去的区间的结束位置。
        for(int i = 1; i != intervals.size(); ++i)
        {
            //发生重叠了, 保留最小的那个end, 保证给后面的留下更多的空间。
            if(intervals[i].start < end)
            {
                ++ans;
                end = min(intervals[i].end, end);
            }
            //没有发生重叠则 更新 end 的取值
            else
            {
                end = intervals[i].end;        
            }
        }
        return ans;
    }
};
*/

//kalipy一次过
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int ans = 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (end > intervals[i][0]) {
                ans++;
                end = Math.min(end, intervals[i][1]);
            } else {
                end = intervals[i][1];
            }
        }

        return ans;
    }
}

//记录一下大佬的思想： 贪心算法，按照起点排序：选择结尾最短的，后面才可能连接更多的区间（如果两个区间有重叠，应该保留结尾小的） 把问题转化为最多能保留多少个区间，使他们互不重复，则按照终点排序，每个区间的结尾很重要，结尾越小，则后面越有可能容纳更多的区间。

//[1,2] [1,3] 1
