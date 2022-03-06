推荐方法超


//方法二
//作者：windliang
//链接：https://leetcode-cn.com/problems/gas-station/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--30/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length;
    for (int i = 0; i < n; i++) {
        int j = i;
        int remain = gas[i];
        while (remain - cost[j] >= 0) {
            //减去花费的加上新的点的补给
            remain = remain - cost[j] + gas[(j + 1) % n];
            j = (j + 1) % n;
            //j 回到了 i
            if (j == i) {
                return i;
            }
        }
        //最远距离绕到了之前，所以 i 后边的都不可能绕一圈了
        if (j < i) {
            return -1;
        }
        //i 直接跳到 j，外层 for 循环执行 i++，相当于从 j + 1 开始考虑
        i = j;

    }
    return -1;
}

}

//方法超 推荐！！！！
//重点就两句话： 1、两个数组之差的总和必须大于等于0，否则不能完成绕行 2、 一个站的收益如果小于0，肯定不能作为起点；而连续的多个站也可以等效地看做一个站，如果其累积收益小于0，就跳过，寻找下一个。
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int total_tank = 0;
        int curr_tank = 0;
        int starting_station = 0;
        for (int i = 0; i < n; ++i) {
            //总和必须大于等于0，否则不能完成绕行
            total_tank += gas[i] - cost[i];
            curr_tank += gas[i] - cost[i];
            if (curr_tank < 0) {
                // 一个站的收益如果小于0，肯定不能作为起点；而连续的多个站也可以等效地看做一个站，如果其累积收益小于0，就跳过，寻找下一个。
                starting_station = i + 1;
                // 还原到初始状态
                curr_tank = 0;
            }
        }
        return total_tank >= 0 ? starting_station : -1;
    }
}


class Solution {
    public:
        int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
            int curSum = 0, totalSum = 0, st = 0;   //当前汽油量，总汽油量，起点

            for (int i = 0; i < gas.size(); ++ i)
            {
                curSum += gas[i] - cost[i];         //累加当前站汽油量
                totalSum += gas[i] - cost[i];

                if (curSum < 0)                     //当前汽油量小于0，说明从第0站到第i站都不能作为起点站
                {                                   //因为中途会断油
                    curSum = 0;                     //贪心原理，当前汽油量清零
                    st = i + 1;                     //起点只能从下一点开始
                }
            }

            if (totalSum < 0) return -1;            //总汽油量小于消耗汽油量的情况
            return st;
        }
};


