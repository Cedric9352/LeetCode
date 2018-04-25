package org.leetcode.easy;

public class MaxAreaOfIsland {
	private int max = -1, count = 0;
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] ismarked = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
        	for(int j = 0; j < grid[0].length; j++) {
        		if(!ismarked[i][j])
        			dfs(grid, i, j, grid.length, grid[0].length, ismarked);
        		if(count > max) 
        			max = count;
        		count = 0;
        	}
        }
        return max;
    }
    public void dfs(int[][] grid, int row, int col, int rows, int cols, boolean[][] ismarked) {
    	if(grid[row][col] == 0)
    		return;
    	ismarked[row][col] = true;
    	count++;
    	if(row + 1 < rows && !ismarked[row+1][col])
    		dfs(grid, row+1, col, rows, cols, ismarked);
    	if(row - 1 >= 0 && !ismarked[row-1][col])
    		dfs(grid, row-1, col, rows, cols, ismarked);
    	if(col + 1 < cols && !ismarked[row][col+1])
    		dfs(grid, row, col+1, rows, cols, ismarked);
    	if(col - 1 >= 0 && !ismarked[row][col-1])
    		dfs(grid, row, col-1, rows, cols, ismarked);
    }
    public static void main(String[] args) {
    	int[][] grid = { {1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1} };
    	System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(grid));
    }
}
