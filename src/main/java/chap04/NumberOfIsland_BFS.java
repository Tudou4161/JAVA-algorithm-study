package chap04;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland_BFS {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','1'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},
                {'1','0','0','1','1'}
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
                    bfs(grid, i, j);
                }
            }
        }
        return cnt;
    }

    private static void bfs(char[][] grid, int i, int j) {
        //이동방향 정의
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        //탐색을 위한 큐 생성
        Queue<int[]> q = new LinkedList<>();
        //배열 사이즈 변수에 담아주기
        int m = grid.length;
        int n = grid[0].length;
        //첫번째 원소 q에 담아주기
        q.offer(new int[]{i, j});

        //loop & condition
        //큐가 비어있으면 알아서 멈춘다.
        while (!q.isEmpty()) {
            //q의 크기는 매번 시시각각 변한다. 따라서 while문 안에서 선언한다.
            int size = q.size();
            //밖에서 꺼낸 후에 순회한다...메모...
            int[] point = q.poll();

            for (int[] dir : dirs) {
                int x = point[0] + dir[0];
                int y = point[1] + dir[1];

                if(x>=0 && y>=0 && x<m && y<n && grid[x][y]=='1') {
                    grid[x][y] = '0';
                    q.offer(new int[]{x,y});
                }
            }
        }
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
