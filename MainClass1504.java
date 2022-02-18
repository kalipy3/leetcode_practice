/*
 * MainClass1504.java
 * Copyright (C) 2022 2022-02-16 16:51 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//超难题！！！

//先掌握这个方法 对dp很大启发作用 链接：https://leetcode-cn.com/problems/count-submatrices-with-all-ones/solution/shi-yong-yu-yun-suan-fu-javashuang-bai-by-mp1256/
class Solution {
    public int numSubmat(int[][] mat) {
        int result = 0;
        for (int i = 0; i < mat.length; i++) {
            int[] nums = new int[mat[i].length];
            System.arraycopy(mat[i], 0, nums, 0, mat[i].length);

            result += getRes(nums);

            for (int j = i + 1; j < mat.length; j++) {
                for (int k = 0; k < mat[j].length; ++k) {
                    nums[k] = nums[k] & mat[j][k];
                }
                result += getRes(nums);
            }
        }
        return result;
    }

    //计算1行
    public int getRes(int[] nums) {
        int result = 0;     //结果
        int continuous = 0;  //连续出现的1的个数
        for (int num : nums) {
            if (num == 0) {
                result += continuous * (continuous + 1) / 2;
                continuous = 0;
            } else {
                continuous++;
            }
        }
        result += continuous * (continuous + 1) / 2;
        return result;
    }
}


//评论区
/*
c++ 88ms 13.2M 只统计当前位置右下方能组成的矩形
class Solution {
public:
    int numSubmat(vector<vector<int>>& mat) {
        int M = mat.size(), N = mat[0].size(), res = 0;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(mat[i][j] == 0) {
                    continue;
                }
                int n_max = N;
                for(int m = i; m < M; m++) {
                    for(int n = j; n < n_max; n++) {         
                        if(mat[m][n] == 0) {
                            n_max = n;
                            break;
                        }
                        res++;
                    }
                }
            }
        }
        return res;
    }
};

*/
