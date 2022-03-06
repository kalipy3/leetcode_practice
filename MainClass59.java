//请对比54题 请先直接看方法二和方法三的代码和注释 可以看懂 推荐方法二和方法三

//方法二
class Solution {
public:
    //四边界法
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> ans(n, vector<int>(n));//定义一个n*n的二维矩阵
        int top = 0, right = n-1, bottom = n-1, left = 0;//初始化四个边界
        int num = 1;//表示填入的元素大小，从1开始
        //while(num <= n*n)//也ok
        while(left <= right && top <= bottom)//循环条件
        {
            for(int i = left; i <= right; i++)
            {
                ans[top][i] = num;//从左到右填充上边界
                num++;
            }
            for(int i = top + 1; i <= bottom; i++)
            {
                ans[i][right] = num;//从上到下填充右边界
                num++;
            }
            for(int i = right - 1; i >= left; i--)
            {
                ans[bottom][i] = num;//从右到左填充下边界
                num++;
            }
            for(int i = bottom - 1; i > top; i--)
            {
                ans[i][left] = num;//从下到上填充左边界
                num++;
            }
            top++;
            left++;
            right--;
            bottom--;//更新4个边界的值
        }
        return ans;
    }
};

//方法三
class Solution {
    public int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while(num <= tar){
            for(int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
            t++;
            for(int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
            r--;
            for(int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
            b--;
            for(int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
            l++;
        }
        return mat;
    }
}


作者：jyd
链接：https://leetcode-cn.com/problems/spiral-matrix-ii/solution/spiral-matrix-ii-mo-ni-fa-she-ding-bian-jie-qing-x/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

//方法一 思路简单清晰
//模拟过程：
//
//    将矩阵的每一个位置看做一个格子
//    将整个求解过程看做从左上角的格子（0，0）开始不断沿着右、下、左、上的顺序前进，直至走遍所有格子
//
//整体思路：
//
//    生成n x n的矩阵res，所有元素初始值均为0
//    使用i，j指示当前所在格子,初始化：i = 0, j = 0, res[i][j] = 1
//    前进顺序优先级为：右、下、左、上（如果在当前格子可以向右前进，则一直向右前进，如果无法向右前进，那就看是否可以向下前进，如果可以向下前进，则一直向下前进。此规则依此类推）
//    如何判断是否可以向指定方向前进？
//        如果下一个格子已超出矩阵范围，则不可沿此方向前进
//        如果下一个格子已走过，则不可沿此方向前进（可以发现走过的格子都会被填充一个大于0的数值，而未走过的格子依然为初始值0）
//    终止条件：当走完最后一个格子时，此时的res[i][j] = n x n
class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> res(n, vector<int>(n, 0));// 结果矩阵
        int i = 0;
        int j = 0;// （i，j）指示当前所在格子
        res[i][j] = 1;// 进入第一个格子，即左上角格子
        while(res[i][j] != n * n)// 终止条件
        {
            while(j + 1 < n && 0 == res[i][j + 1])// 判断是否可以向右前进
            {
                res[i][j + 1] = res[i][j] + 1;
                ++j;// 向右前进一格并填充数据
            }
            while(i + 1 < n && 0 == res[i + 1][j])// 判断是否可以向下前进
            {
                res[i + 1][j] = res[i][j] + 1;
                ++i;// 向下前进一格并填充数据
            }
            while(j - 1 >= 0 && 0 == res[i][j - 1])// 判断是否可以向左前进
            {
                res[i][j - 1] = res[i][j] + 1;
                --j;// 向左前进一格并填充数据
            }
            while(i - 1 >= 0 && 0 == res[i - 1][j])// 判断是否可以向上前进
            {
                res[i - 1][j] = res[i][j] + 1;
                --i;// 向上前进一格并填充数据
            }
        }
        return res;// 所有格子均走完，返回结果矩阵
    }
};
