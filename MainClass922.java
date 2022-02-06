//方法一
//遍历一遍数组把所有的偶数放进 ans[0]，ans[2]，ans[4]，依次类推。
//再遍历一遍数组把所有的奇数依次放进 ans[1]，ans[3]，ans[5]，依次类推。
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int n = A.length;
        int[] ans = new int[n];

        int i = 0;
        for (int x : A) {
            if (x % 2 == 0) {
                ans[i] = x;
                i += 2;
            }
        }
        i = 1;
        for (int x : A) {
            if (x % 2 == 1) {
                ans[i] = x;
                i += 2;
            }
        }
        return ans;
    }
}

//写法二
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int[] result = new int[A.length];
        int ji = 1;
        int ou = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                result[ou] = A[i];
                ou += 2; //偶数下标移动
            } else {
                result[ji] = A[i];
                ji += 2; //奇数下标移动
            }
        }
        return result;
    }
}

//方法二
//如果原数组可以修改，则可以使用就地算法求解。
//为数组的偶数下标部分和奇数下标部分分别维护指针 i,j。随后，在每一步中，如果 A[i] 为奇数，则不断地向前移动 j（每次移动两个单位），直到遇见下一个偶数。此时，可以直接将 A[i] 与 A[j] 交换。我们不断进行这样的过程，最终能够将所有的整数放在正确的位置上
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int n = A.length;
        int j = 1;
        for (int i = 0; i < n; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {//line36
                    j += 2;
                }
                swap(A, i, j);//因为A[j]为偶数时才交换掉，所以为了让while跳出后为偶数，所以line36要为奇数
            }
        }   
        return A;
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}

//写法三
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int n = A.length;
        int i = 0;
        int j = 1;
        while (i<n && j<n) {
            while (i<n && (A[i]&1)==0) i += 2;
            while (j<n && (A[j]&1)==1) j+= 2;
            if (i>=n || j>=n) break;
            int t = A[i];
            A[i] = A[j];
            A[j] = t; 
        }
        return A;
    }
}

