package chap01;

import java.util.HashMap;
import java.util.Map;

public class LongestSubMostTwoDist {
    public static void main(String[] args) {
        String s = "ccaabbb";
        System.out.println("solve(s) = " + solve(s));
    }

    private static int solve(String s) {
        //1. ds

        /*
         * length -> twoDistinct 조건을 만족하는 문자열 최대 길이. max 메소드로 이전의 length값과 비교해야한다.
         * start -> 맵 내부의 value값이 줄어들면, start값이 증가한다.
         * end -> 현재 위치이자, 다음 위치를 가르킬 변수.
         * counter -> map에 들어간 unique알파벳 개수.
         */

        int length = 0, start = 0, end = 0, counter = 0;
        Map<Character, Integer> map = new HashMap<>();

        //2. loop
        /*
         * 문자열을 char타입으로 하나씩 받아서 처리해야함.
         * 해쉬맵은 중복을 제거한다. 따라서 알파벳을 키로 받고, 갯수를 value에 두어서 처리하면 간편하다.
         * value가 1이 되면 counter를 증가시킨다.
         * counter가 3이 되는 순간, two distinct 조건을 충족시키지 못하므로 앞에 있는 문자도 하나씩 제거해야한다. 이때 value를 1씩 감소시키고, start값을 증가시키면 삭제로직을 수행할 수 있다.
         * length는 이전의 값과 현재의 end-start값을 비교해야한다.
         * ccaa -> 4 , c를 둘다 삭제시키고, 내부 while문을 벗어나면 length가 3이 된다.
         */

        while (end < s.length()) {
            char endChar = s.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);

            if (map.get(endChar) == 1) counter++;
            end++;

            while (counter > 2) {
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                if (map.get(startChar) == 0) counter--;
                start++;
            }

            length = Math.max(length, end - start);
        }
        //write your code.
        return length;
    }

}


















//    private static int solve(String s) {
//        //1. ds
//        int start = 0, end = 0, length = 0, counter = 0;
//        Map<Character, Integer> map = new HashMap<>();
//
//        //2. loop
//        while (end < s.length()) {
//            char endChar = s.charAt(end);
//            // c = 2, a = 2, b = 3 를 맵에 저장해야함.
//            map.put(endChar, map.getOrDefault(endChar, 0)+1); //중요!
//            if (map.get(endChar)==1) counter++; //카운터 증가 시키기.
//            end++; //end인덱스 증가 시키기.
//            // delete first value.
//            while (counter > 2) {
//                char startChar = s.charAt(start);
//                map.put(startChar, map.get(startChar)-1);
//                if (map.get(startChar)==0) counter--;
//                start++;
//            }
//
//            length = Math.max(length, end-start);
//        }
//
//        return length;
//    }
