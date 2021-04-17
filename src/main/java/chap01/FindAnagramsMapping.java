package chap01;

import java.util.HashMap;
import java.util.Map;

public class FindAnagramsMapping {
    public static void main(String[] args) {
        int[] a = {11, 27, 45, 31, 50};
        int[] b = {50, 11, 31, 45, 27};
        int[] result = solve(a, b);
        print(result);
    }


    public static int[] solve(int[] a, int[] b) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[a.length];

        for (int i = 0; i < b.length; i++) {
            map.put(b[i], i);
        }

        for (int i = 0; i < a.length; i++) {
            result[i] = map.get(a[i]);
            System.out.println("result[i] = " + result[i]);
        }

        return result;
    }


    private static void print(int[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.println("result = " + result[i]);
        }
    }
}

//
//    //1. ds
//    int[] result = new int[a.length];
//    Map<Integer, Integer> map = new HashMap<>();
////2. iter
//        for (int i = 0; i < a.length; i++) {
//        map.put(b[i], i);
//        }
//
//        for (int i = 0; i < a.length; i++) {
//        result[i] = map.get(a[i]);
//        }
//
//        return result;