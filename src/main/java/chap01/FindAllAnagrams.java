package chap01;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {
    public static void main(String[] args) {
        String txt = "BACDGABCDA";
        String pat = "ABCD";

        System.out.println("solve(txt, pat) = " + solve(txt, pat));
    }


    private static List<Integer> solve(String txt, String pat) {

        List<Integer> result = new ArrayList<>();

        if(txt.length() == 0 || txt == null || pat.length() == 0 || pat == null || txt.length() < pat.length())
            return result;

        int[] patArr = new int[256];
        for (int i = 0; i < pat.length(); i++) {
            patArr[pat.charAt(i)]++; //뒤에 왜 ++을 붙히지...? -> 해당 위치의 값을 1로 상승시킴.
        }


        for (int i = 0; i < txt.length()-pat.length()+1; i++) {
            int[] txtArr = new int[256];

            for (int j = 0; j < pat.length(); j++) {
                txtArr[txt.charAt(i+j)]++;
            }

            if (check(patArr, txtArr)) {
                result.add(i);
            }
        }

        return result;
    }

    private static boolean check(int[] patArr, int[] txtArr) {
        for (int i = 0; i < patArr.length; i++) {
            if (patArr[i] != txtArr[i]) return false;
        }
        return true;
    }
}








//    private static List<Integer> solve(String txt, String pat) {
//        //1. ds
//        List<Integer> result = new ArrayList<>();
//        if (txt==null || txt.length()==0 || pat==null || pat.length()==0 || txt.length()<pat.length())
//            return result;
//
//        //2. iter
//        int[] patArr = new int[256];
//        for (int i = 0; i < pat.length(); i++) {
//            System.out.println("pat.charAt(i) = " + pat.charAt(i));
//            patArr[pat.charAt(i)]++;
//        }
//
//        for(int i = 0; i < txt.length()-pat.length()+1; i++) {
//            int[] txArr = new int[256];
//            for (int j = 0; j < pat.length(); j++) {
//                System.out.println("txt.charAt(i+j) = " + txt.charAt(i+j));
//                txArr[txt.charAt(i+j)]++;
//            }
//            if (check(patArr, txArr)) {
//                result.add(i);
//                System.out.println("input!");
//            }
//        }
//        return result;
//    }
//
//    private static boolean check(int[] patArr, int[] txArr) {
//        for (int i=0; i<patArr.length; i++) {
//            //System.out.println(patArr[i] + "  ::  " + txArr[i]);
//            if (patArr[i] != txArr[i]) {
//                return false;
//            }
//        }
//        return true;
//    }
