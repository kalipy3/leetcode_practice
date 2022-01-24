//方法一 推荐
https://leetcode-cn.com/problems/check-if-it-is-a-straight-line/solution/1232-zhui-dian-cheng-xian-shu-xue-cha-ch-gcl9/
/*
 * 叉乘 a * b
 * = | x1, y1 | = x1 * y2 - y1 * x2
 *   | x2, y2 |
 * 若结果小于 0，表示向量 b 在向量 a 的顺时针方向；
 * 若结果大于 0，表示向量 b 在向量 a 的逆时针方向；
 * 若结果为 0，表示向量 b 与向量 a 平行；
 */
bool checkStraightLine(int** coordinates, int coordinatesSize, int* coordinatesColSize)
{
    int x1 = coordinates[1][0] - coordinates[0][0];
    int y1 = coordinates[1][1] - coordinates[0][1];

    for (int i = 2; i < coordinatesSize; ++i) {
        int x2 = coordinates[i][0] - coordinates[0][0];
        int y2 = coordinates[i][1] - coordinates[0][1];
        if (x1 * y2 != x2 * y1) {
            return false;
        }
    }

    return true;
}


作者：addzero
链接：https://leetcode-cn.com/problems/check-if-it-is-a-straight-line/solution/cha-cheng-gu-ji-cai-shi-bi-jiao-zheng-qu-gc7i/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



作者：Provencih
链接：https://leetcode-cn.com/problems/check-if-it-is-a-straight-line/solution/jin-liang-bu-yao-yong-pan-duan-xie-lu-sh-9r4r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution {
    public:
        bool checkStraightLine(vector<vector<int>>& coordinates) {
            int n = coordinates.size();
            int x0 = coordinates[0][0], y0 = coordinates[0][1];
            int x = coordinates[1][0] - x0;
            int y = coordinates[1][1] - y0;
            for (int i = 2; i < n; ++i) {
                int xi = coordinates[i][0] - x0;
                int yi = coordinates[i][1] - y0;
                if (x * yi - y * xi) { //计算二阶行列式
                    return false;
                }
            }
            return true;
        }
};

