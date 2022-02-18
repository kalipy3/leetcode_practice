/*
 * MainClass1288.java
 * Copyright (C) 2022 2022-02-16 17:22 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//方法一 暴力 评论区 枚举每个元素，看每个元素是否被其它元素包含
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int ans=intervals.length;
        for(int interval[]:intervals){
            for(int inter[]:intervals){
                if(interval[0]==inter[0]&&interval[1]==inter[1]){continue;}
                if(interval[0]>=inter[0]&&interval[1]<=inter[1]){
                    ans--;
                    break;
                }
            }
        }
        return ans;
    }
}


//推荐 链接：https://leetcode-cn.com/problems/remove-covered-intervals/solution/sao-miao-xian-fa-by-liweiwei1419/
public class Solution {

    public int removeCoveredIntervals(int[][] intervals) {
        int len = intervals.length;
        // 特判
        if (len < 2) {
            return len;
        }

        // 特别注意：当区间左端点相同的时候，右端点降序排序
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o2[0];
            }
            return o1[0] - o2[0];
        });

        // 需要被删除的区间个数
        int remove = 0;
        int currentRight = intervals[0][1];
        for (int i = 1; i < len; i++) {
            if (intervals[i][1] <= currentRight) {
                remove++;
            } else {
                currentRight = intervals[i][1];
            }
        }
        return len - remove;
    }
}



//官方题解 推荐
class Solution {
  public int removeCoveredIntervals(int[][] intervals) {
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        // Sort by start point.
        // If two intervals share the same start point,
        // put the longer one to be the first.
        return o1[0] == o2[0] ? o2[1] - o1[1]: o1[0] - o2[0];
      }
    });

    int count = 0;
    int end, prev_end = 0;
    for (int[] curr : intervals) {
      end = curr[1];
      // if current interval is not covered
      // by the previous one
      if (prev_end < end) {
        ++count;
        prev_end = end;
      }
    }
    return count;
  }
}


