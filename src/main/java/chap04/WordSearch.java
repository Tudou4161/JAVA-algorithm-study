package chap04;

public class WordSearch {
    public static void main(String[] args) {
        char[][] grid = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};

        String word = "ABCCED";
        System.out.println(solve(grid, word));
    }

    private static boolean solve(char[][] grid, String word) {
        if (grid == null || grid.length==0 || grid[0].length==0) return false;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                //한큐에 끝내버린다...!
                if (dfs(grid, visited, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] grid, boolean[][] visited,
                               int x, int y, int start, String word) {

        if (start==word.length()) return true;
        if (x<0||x>=grid.length||y<0||y>=grid[0].length) return false;
        if (visited[x][y]) return false;
        if (grid[x][y] != word.charAt(start)) return false;

        visited[x][y] = true;
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        for (int[] dir: dirs) {
            int dx = x+dir[0];
            int dy = y+dir[1];
            if (dfs(grid, visited, dx, dy, start+1, word)) {
                return true;
            }
        }
        //원복
        visited[x][y] = false;
        return false;
    }
}
