package chap01;

import java.util.*;

public class JewelsAndStones {
    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAAbbbb";
        System.out.println(" result = " + solve(jewels, stones));
    }

    public static int solve(String jew, String stones) {
        if (jew.length() == 0 && stones.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        char[] jewChar = jew.toCharArray();
        for (char c : jewChar) {
            set.add(c);
        }

        char[] stoneList = stones.toCharArray();

        int cnt = 0;
        for (char c : stoneList) {
            if (set.contains(c)){
                cnt += 1;
            }
        }

        return cnt;
    }
}
