
//直接看代码 可以看懂
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);//请注意这种情况[(0,3),(0,1)]，所以才要Math.max
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}

//写法二 推荐
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals , new Comparator<int[]>() {
            public int compare(int[] intervals1, int[] intervals2) {
                return intervals1[0] - intervals2[0];
            }
        });

        List<int[]> ans = new ArrayList<>();
        ans.add(new int[]{intervals[0][0], intervals[0][1]});
        for (int i = 1; i < intervals.length; i++) {
            if (ans.get(ans.size()-1)[1] < intervals[i][0]) {
                ans.add(new int[]{intervals[i][0], intervals[i][1]});
            } else {
                ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1], intervals[i][1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}

