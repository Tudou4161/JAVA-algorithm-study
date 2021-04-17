package chap04;

public class NumberOfIsland_DFS {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','1'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},
                {'0','0','0','1','1'}
        };

        int result = solve(grid);
        System.out.println("result = " + result);
    }

    private static int solve(char[][] grid) {
        if (grid.length == 0 || grid == null || grid[0].length == 0)
            return 0;

        int cnt = 0;

        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }

    private static void dfs(char[][] grid, int i, int j) {

        int m = grid.length;
        int n = grid[0].length;

        //조건식 순서 바뀌는게 왜 문제인거지..? 어차피 or조건인데..ㅋㅋㅋ
        if (i<0||j<0||i>=m||j>=n||grid[i][j]!='1') return;

        grid[i][j] = 'x';

        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);

    }

    private static void print(char[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}
