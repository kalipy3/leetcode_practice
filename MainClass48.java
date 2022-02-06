作者：powcai
链接：https://leetcode-cn.com/problems/rotate-image/solution/yi-ci-xing-jiao-huan-by-powcai/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//方法一 推荐这个解法，不易出错
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 上下翻转，两种写法
        // 第一种
        //  for (int i =0; i < n /2 ; i++ ){
        //      for (int j =0; j < n; j ++){
        //          int tmp = matrix[i][j];
        //          matrix[i][j] = matrix[n-i-1][j];
        //          matrix[n-i-1][j] = tmp;
        //      }
        //  }
        // 第二种 即两个一维数组整体之间的交互 
        for (int i = 0; i < n / 2; i ++){
            int[] tmp = matrix[i];
            matrix[i] = matrix[n - i - 1];
            matrix[n - i - 1] = tmp;
        }
        //System.out.println(Arrays.deepToString(matrix));
        // 对角翻转
        for (int i = 0; i < n; i ++){
            for (int j= i + 1; j < n; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}




作者：zuo-ni-ai-chi-de-tang-seng-rou
链接：https://leetcode-cn.com/problems/rotate-image/solution/li-kou-48xiao-bai-du-neng-kan-dong-de-fang-fa-zhu-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//方法二
public void rotate(int[][] matrix) {
    int add = 0;
    int temp = 0;
    int pos1 = 0;
    int pos2 = matrix[0].length - 1;
    while (pos1 < pos2){
        add = 0;
        while (add < pos2 - pos1){
            temp = matrix[pos1][pos1 + add];
            matrix[pos1][pos1 + add] = matrix[pos2 - add][pos1];
            matrix[pos2 - add][pos1] = matrix[pos2][pos2 -add];
            matrix[pos2][pos2 -add] = matrix[pos1 + add][pos2];
            matrix[pos1 + add][pos2] = temp;
            add++;
        }
        pos1++;
        pos2--;


    }
}


