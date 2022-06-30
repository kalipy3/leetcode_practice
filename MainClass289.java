/*
 * MainClass289.java
 * Copyright (C) 2022 2022-06-30 12:46 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//写法一 kalipy
class Solution {

    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int [][] temp = new int[row][col];

        for (int i = 0;i < row;i++){
            for (int j = 0;j < col;j++){
                /**
                 * 遍历8个方向！
                 */
                int count = 0;
                for (int startRow = i - 1;startRow <= i + 1;startRow++){
                    for (int startCol = j - 1;startCol <= j + 1;startCol++){
                        if(startRow >= 0 && startRow < row && startCol >= 0 && startCol < col && !(startRow == i && startCol == j) && board[startRow][startCol] == 1){
                            count++;
                        }
                    }
                }
                if(board[i][j] == 1){
                    if(count == 2 || count == 3){
                        temp[i][j] = 1;
                    }
                }else {
                    if(count == 3){
                        temp[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0;i < row;i++){
            for (int j = 0;j < col;j++){
                board[i][j] = temp[i][j];
            }
        }
    }
}


//评论区 写法二
//class Solution {
//public:
//    void gameOfLife(vector<vector<int>>& board) {
//        vector<vector<int>> ans(board);
//        int dx[8] = {1, 1, 1, 0, 0, -1, -1, -1};
//        int dy[8] = {1, -1, 0, 1, -1, 1, -1, 0};
//        for(int i = 0; i < board.size(); i ++){
//            for(int j = 0; j < board[0].size(); j ++){
//                int cnt = 0;
//                for(int z = 0; z < 8; z ++){
//                    int x = i + dx[z];
//                    int y = j + dy[z];
//                    if(x >= 0 && x < board.size() && y >= 0 && y < board[0].size() && board[x][y] == 1)
//                        cnt ++;
//                }
//                if(cnt < 2) ans[i][j] = 0;
//                else if(cnt > 3)    ans[i][j] = 0;
//                else if(cnt == 3)   ans[i][j] = 1;
//            }
//        }
//        board = ans;
//        return;
//    }
//};


//评论区 方法二二
//一. 普遍意义上，如果规则极其繁复，如何简化这些规则呢？
//
//关于逻辑表达式的简化可能会用上“卡诺图”，有兴趣的朋友请自行查一查。
//
//二. 这道题的规则如何简化？
//
//1. 原来是活的，周围有2-3个活的，成为活的
//2. 原来是死的，周围有3个活的，成为活的
//3. 其他都是死了
//class Solution {
//public:
//    void gameOfLife(vector<vector<int>>& board) {
//        int dx[] = {-1,  0,  1, -1, 1, -1, 0, 1};
//        int dy[] = {-1, -1, -1,  0, 0,  1, 1, 1};
//
//        for(int i = 0; i < board.size(); i++) {
//            for(int j = 0 ; j < board[0].size(); j++) {
//                int sum = 0;
//                for(int k = 0; k < 8; k++) {
//                    int nx = i + dx[k];
//                    int ny = j + dy[k];
//                    if(nx >= 0 && nx < board.size() && ny >= 0 && ny < board[0].size()) {
//                        sum += (board[nx][ny]&1); // 只累加最低位
//                    }
//                }
//                if(board[i][j] == 1) {
//                    if(sum == 2 || sum == 3) {
//                        board[i][j] |= 2;  // 使用第二个bit标记是否存活
//                    }
//                } else {
//                    if(sum == 3) {
//                        board[i][j] |= 2; // 使用第二个bit标记是否存活
//                    }
//                }
//            }
//        }
//        for(int i = 0; i < board.size(); i++) {
//            for(int j = 0; j < board[i].size(); j++) {
//                board[i][j] >>= 1; //右移一位，用第二bit覆盖第一个bit。
//            }
//        }
//    }
//};
//
//
//作者：Time-Limit
//链接：https://leetcode.cn/problems/game-of-life/solution/c-wei-yun-suan-yuan-di-cao-zuo-ji-bai-shuang-bai-b/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
