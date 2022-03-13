//方法一
//作者：c-liueasymoney
//链接：https://leetcode-cn.com/problems/diagonal-traverse/solution/quan-ju-ding-wei-dui-jiao-xian-liang-dia-y67h/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
public int[] findDiagonalOrder(int[][] mat) {
    if (mat == null || mat.length == 0){
        return null;
    }
    int N = mat.length;
    int M = mat[0].length;

    // 定义两个对角点
    int[] pointA = {0, 0};
    int[] pointB = {0, 0};
    int[] res = new int[N * M];
    int index = 0;
    // 设定标志位表示应该从A点到B点遍历还是相反的顺序, true代表B->A
    boolean flag = true;

    // A点是先右移再下移，所以当A点下移到最低的时候就结束了；另外不用担心B点越界，因为两个点走过的路程长度是相等的
    while (pointA[0] < N){
        int i = 0;
        int j = 0;
        if (flag){
            i = pointB[0];
            j = pointB[1];
            while (i >= 0 && j < M){
                res[index++] = mat[i][j];
                i--;
                j++;
            }
        }else {
            i = pointA[0];
            j = pointA[1];
            while (i < N && j >= 0){
                res[index++] = mat[i][j];
                i++;
                j--;
            }
        }

        if (pointA[1] < M - 1){   // A点先左移到边缘再下移
            pointA[1]++;
        }else {
            pointA[0]++;
        }

        if (pointB[0] < N - 1){   // B点先下移再右移
            pointB[0]++;
        }else {
            pointB[1]++;
        }
        // 每次遍历一遍之后对flag取反
        flag = !flag;
    }
    return res;
}

//方法二
//[Java] 观察规律可知，遍历方向由层数决定，而层数即为横纵坐标之和。故而可以得出解答。
public int[] findDiagonalOrder(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
        return new int[]{};
    }
    int r = 0, c = 0;
    int row = matrix.length, col = matrix[0].length;
    int[] res = new int[row * col];
    for (int i = 0; i < res.length; i++) {
        res[i] = matrix[r][c];
        // r + c 即为遍历的层数，偶数向上遍历，奇数向下遍历
        if ((r + c) % 2 == 0) {
            if (c == col - 1) {
                // 往下移动一格准备向下遍历
                r++;
            } else if (r == 0) {
                // 往右移动一格准备向下遍历
                c++;
            } else {
                // 往上移动
                r--;
                c++;
            }
        } else {
            if (r == row - 1) {
                // 往右移动一格准备向上遍历
                c++;
            } else if (c == 0) {
                // 往下移动一格准备向上遍历
                r++;
            } else {
                // 往下移动
                r++;
                c--;
            }
        }
    }
    return res;
}

//方法三
public int[] findDiagonalOrder(int[][] mat) {
    int m = mat.length,n = mat[0].length,k = 0;
    int[] result = new int[m * n];
    Map<Integer,List<Integer>> map = new HashMap<>();
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            List<Integer> integers;
            if(map.containsKey(i + j)){
                integers = map.get(i + j);
            }else{
                integers = new ArrayList<>();
            }
            integers.add(mat[i][j]);
            map.put(i + j,integers);
        }
    }
    for (Map.Entry<Integer, List<Integer>> integerListEntry : map.entrySet()) {
        int key = integerListEntry.getKey();
        List<Integer> value = integerListEntry.getValue();
        if(key % 2 == 0){ // 偶数倒序
            Collections.reverse(value);
        }
        for (Integer integer : value) {
            result[k++] = integer;
        }
    }
    return result;
}
