/*
 * MainClass57.java
 * Copyright (C) 2022 2022-01-31 17:41 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//方法一 评论区
class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        vector<vector<int>> res;
        int pos=0,n=intervals.size();
        //找到准备合并的区间，当前区间最右边端点都不和待插入区间最左端点有交集时，直接Push进res
        while(pos<n&&intervals[pos][1]<newInterval[0])
        {
            res.push_back(intervals[pos++]);        
        }
        //合并区间,当前区间最左侧都和待插入区间最右侧有交集时(注意不断更新待插入区间的边界)
        while(pos<n&&intervals[pos][0]<=newInterval[1])
        {
            newInterval[0]=min(intervals[pos][0],newInterval[0]);
            newInterval[1]=max(intervals[pos][1],newInterval[1]);
            pos++;
        }
        res.push_back(newInterval);
        //处理剩余区间
        while(pos<n)
        {
            res.push_back(intervals[pos++]);
        }
        return res;
    }
};

//方法二 评论区 直接复用56题的代码
//先把newInterval 加到interval里，然后排序一下。然后用56题的代码就行了
