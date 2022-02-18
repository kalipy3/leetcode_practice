/*
 * MainClass861.java
 * Copyright (C) 2022 2022-02-17 18:40 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

/*
先横竖变换保证第一列全部是1
竖变换保证其他列1比0多

第一步：将首列全部置位1，保证最高位全部取到，首列不为1的行全部翻转

第二步：从第二列开始，将所有列中1的数量小于0的数量的行翻转，保证取1的数量尽可能多

第三步：计算结果返回
*/
/*
class Solution {
public:
    int matrixScore(vector<vector<int>>& a) {
        //step1:翻转所有行，保证第一列全为1
        int m=a.size(),n=a[0].size();
        for (int i=0;i<m;i++)
        {
            if (a[i][0]!=1)
            {
                //翻转该行
                for (int j=0;j<n;j++)
                {
                    a[i][j]=!a[i][j];
                }
            }
        }
        //step2:从第二列开始，检查该列的1的数量是否大于等于0，如果不是，则翻转该列
        for (int j=1;j<n;j++)
        {
            int count=0;
            for (int i=0;i<m;i++)
            {
                if (a[i][j]) count++;
            }
            if (count<(m+1)/2)
            {
                for (int i=0;i<m;i++)
                {
                    a[i][j]=!a[i][j];
                }
            }
        }
        //step3:计算结果并返回
        int num=0;
        for(int j=0;j<n;j++)
        {
            int temp=pow(2,n-j-1);
            for (int i=0;i<m;i++)
            {
                num+=a[i][j]*temp;
            }
        }
        return num;
    }
};
*/
