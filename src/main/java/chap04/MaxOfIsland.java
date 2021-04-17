package chap04;

import java.util.Map;

public class MaxOfIsland {
    public static void main(String[] args) {
        int[][] grid = {{1,1,0,1,1},
                        {0,1,1,0,0},
                        {0,0,0,0,0},
                        {1,1,0,1,1},
                        {1,0,1,1,1},
                        {1,0,1,1,1}};

        System.out.println("maxOfIsland(grid) = " + maxOfIsland(grid));
    }

    private static int maxOfIsland(int[][] grid) {
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, 0);
                    System.out.println("max = " + max);
                    max = Math.max(max, area);
                }
            }
        }

        return max;
    }

    private static int dfs(int[][] grid, int x, int y, int area) {
        if(x<0||y<0||x>=grid.length||y>=grid[0].length||grid[x][y]==0) return area;

        System.out.println("grid[x][y] = " + grid[x][y]);
        System.out.println("x + = " + x + " y = " + y);
        grid[x][y] = 0;
        area++;
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        for (int[] dir: dirs) {
            area = dfs(grid, x+dir[0], y+dir[1], area);
        }

        return area;
    }
}
