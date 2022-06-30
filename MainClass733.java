/*
 * MainClass733.java
 * Copyright (C) 2022 2022-06-27 20:37 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//评论区
//刚开始还真没看懂题意（捂脸），其实就是给你一个矩阵：
//[[1,1,1],
//
//[1,1,0],
//
//[1,0,1]]
//
//然后给你一个坐标（1,1）和新数值（2），要求你把坐标及其周围的旧数值变为新数值，即新矩阵为：
//
//[[2,2,2],
//
//[2,2,0],
//
//[2,0,1]]
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        DFS(image,sr,sc,newColor,oldColor);
        return image;
    }

     public void DFS(int[][] image,int x,int y,int newColor,int oldColor){
        if(x < 0 || x >= image.length || y < 0 || y >= image[0].length) {
            return;
        }
        if(image[x][y] != oldColor || image[x][y] == newColor){
            return;
        }
        image[x][y] = newColor;
        DFS(image, x - 1, y,newColor,oldColor);   
        DFS(image, x + 1, y,newColor,oldColor);   
        DFS(image, x, y - 1,newColor,oldColor);   
        DFS(image, x, y + 1,newColor,oldColor);   
    }
}

//kalipy一次过
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        dfs(image, sr, sc, oldColor, color);

        return image;
    }

    private void dfs(int[][] image, int i, int j, int oldColor, int newColor) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != oldColor || image[i][j] == newColor) {
            return;
        }

        if (image[i][j] == oldColor) {
            image[i][j] = newColor;
        }

        dfs(image, i + 1, j, oldColor, newColor);
        dfs(image, i - 1, j, oldColor, newColor);
        dfs(image, i, j + 1, oldColor, newColor);
        dfs(image, i, j - 1, oldColor, newColor);
    }
}
