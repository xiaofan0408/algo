package com.xiaofan0408.leetcode2;

public class Solution200 {

    public int numIslands(char[][] grid) {

        int lands = 0;
        int len = grid[0].length;
        for (int i= 0; i < grid.length;i++) {
            for (int j = 0; j < len; j++ ) {
                if (grid[i][j] == '1') {
                    dfs(grid,i,j);
                    lands++;
                }
            }
        }
        return lands;
    }

    void dfs(char[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) {
            return;
        }
        if (grid[r][c] != '1') {
            return;
        }
        grid[r][c] = '2';

        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    boolean inArea(char[][] grid, int r, int c) {
        return 0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length;
    }


    public static void main(String[] args) {
        Solution200 solution200 = new Solution200();
        System.out.println(solution200.numIslands(new char[][]{{'1','1','1','1','0'},
                {'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}));
    }

}
