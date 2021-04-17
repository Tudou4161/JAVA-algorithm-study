package chap01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) {
        int[] t = {73,74,75,71,69,72,76,73};
        int[] res = solve(t);  //결과 배열 출력

        for (int i : res) {
            System.out.println("i = " + i);
        }
    }

    public static int[] solve(int[] t) {
        //1. stack 생성, 반환 값 배열 생성
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[t.length];

        //2. for(push전용) -> while(pop전용)
        for (int i = 0; i < t.length; i++) {
            while (!stack.isEmpty() && t[stack.peek()] < t[i]) {
                int index = stack.pop(); //pop처리될 원소의 index값을 미리 저장해둔다.
                System.out.println("index = " + index);
                result[index] = i - index; //위에서 받은 index값에 해당하는 위치에 결과값을 담는다.
                System.out.println("result = " + result[index]);
            }
            //while에 해당하지 않는 경우, push를 진행.
            stack.push(i);
        }

        return result;
    }
}