//官方题解 方法一 送分题
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // start our "pointer" in the bottom-left
        int row = matrix.length-1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else { // found it
                return true;
            }
        }

        return false;
    }
}

//方法一的递归写法
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n= matrix[0].length;
        return searchMatrix(matrix, m-1, 0, target);
    }
    public boolean searchMatrix(int[][] matrix, int m, int n, int target){
        //搜索到达边界未搜索成功，返回false
        if(m<0 || n>=matrix[0].length){return false;}
        //搜索成功，返回true
        if(matrix[m][n] == target){return true;}
        if(matrix[m][n] < target){
            return searchMatrix(matrix, m, n+1, target);
        }else{
            return searchMatrix(matrix, m-1, n, target);
        }
    }
}

//方法二
作者：windliang
链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-5-4/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0 || matrix[0].length == 0) {
        return false;
    }
    for (int i = 0; i < matrix.length; i++) {
        if (matrix[i][0] > target) {
            break;
        }
        if(matrix[i][matrix[i].length - 1] < target){
            continue;
        } 
        int col = binarySearch(matrix[i], target);
        if (col != -1) {
            return true;
        }
    }
    return false;
}
private int binarySearch(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    while (start <= end) {
        int mid = (start + end) >>> 1;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }
    return -1;
}


