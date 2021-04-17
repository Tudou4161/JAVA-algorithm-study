package chap01;

import java.util.PriorityQueue;
import java.util.Queue;

public class KClosest {
    public static void main(String[] args) {
        KClosest a = new KClosest();
        int[][] points = {{1,3}, {-2,2}};
        System.out.println("=");
        a.print(points);
        int k = 1;
        System.out.println("==result==");
        int[][] result = a.solve(points, k);
        a.print(result);
    }

    public int[][] solve(int[][] points, int k) {
        //write your code.
        Queue<int[]> pq = new PriorityQueue<>((a, b) ->
                (a[0]*a[0]+a[1]*a[1])-(b[0]*b[0]+b[1]*b[1]));  //힙 정렬 기준. 정렬 기준에 명시한 연산 결과대로 데이터가 삽입된다.
                                                                // 그러나 결과 자체가 삽입되는 것은 아니니까 오해하지 말자.

        int[][] result = new int[k][2];

        for (int[] p : points) { // [[1,3], [-2,2]] -> [1,3] [-2,2] 순으로 데이터 삽입. 그래서 1차원 배열로 받는 것임 ㅇㅇ.
            System.out.print("들어갈 원소 " + p[0]);
            System.out.println(" 들어갈 원소 " + p[1]);
            pq.offer(p);
        }

        int index = 0;
        while (index < k) {
            System.out.print("pq.peek() = " + pq.peek()[0]);
            System.out.println(" pq.peek() = " + pq.peek()[1]);
            result[index] = pq.poll(); //poll 이후에는 result배열은 2차원이 될 수 밖에 없다.
            index++;
        }

        return result;
    }


    private void print(int[][] result) {
        int m = result.length;
        int n = result[0].length;
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.println(" result[i] = " + result[i][j]);
            }
        }
    }
}
