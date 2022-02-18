面试题 08.12. 八皇后与此题完全一样

//请看这个神仙题解,吹爆!!:
//链接：https://leetcode-cn.com/problems/n-queens/solution/nhuang-hou-jing-dian-hui-su-suan-fa-tu-wen-xiang-j/
//写法二 回溯
public List<List<String>> solveNQueens(int n) {
    char[][] chess = new char[n][n];
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            chess[i][j] = '.';
    List<List<String>> res = new ArrayList<>();
    solve(res, chess, 0);
    return res;
}

private void solve(List<List<String>> res, char[][] chess, int row) {
    if (row == chess.length) {
        res.add(construct(chess));
        return;
    }
    for (int col = 0; col < chess.length; col++) {
        if (valid(chess, row, col)) {
            chess[row][col] = 'Q';
            solve(res, chess, row + 1);
            chess[row][col] = '.';
        }
    }
}

//row表示第几行，col表示第几列
private boolean valid(char[][] chess, int row, int col) {
    //判断当前列有没有皇后,因为他是一行一行往下走的，
    //我们只需要检查走过的行数即可，通俗一点就是判断当前
    //坐标位置的上面有没有皇后
    for (int i = 0; i < row; i++) {
        if (chess[i][col] == 'Q') {
            return false;
        }
    }
    //判断当前坐标的右上角有没有皇后
    for (int i = row - 1, j = col + 1; i >= 0 && j < chess[i].length; i--, j++) {
        if (chess[i][j] == 'Q') {
            return false;
        }
    }
    //判断当前坐标的左上角有没有皇后
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
        if (chess[i][j] == 'Q') {
            return false;
        }
    }
    return true;
}

//把数组转为list
private List<String> construct(char[][] chess) {
    List<String> path = new ArrayList<>();
    for (int i = 0; i < chess.length; i++) {
        path.add(new String(chess[i]));
    }
    return path;
}




//空间优化 官方题解
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();
        int[] queens = new int[n];//下标表示行,值表示queen存储在哪一列
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }

    public void backtrack(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}


