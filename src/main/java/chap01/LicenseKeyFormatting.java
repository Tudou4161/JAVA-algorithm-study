package chap01;

import java.util.Locale;

public class LicenseKeyFormatting {
    public static void main(String[] args) {
        //String str = "8F3Z-2e-9-w";
        String str = "8-5g-3-J"; //문제 요구사항을 정확하게 파악하자!
        int k = 4;
        System.out.println("solve(str, k) = " + solve(str, k));
    }
    
    public static StringBuilder solve(String str, int k) {
        String newStr = str.replace("-", "");
        System.out.println("기호 제거 : newStr = " + newStr);

        newStr = newStr.toUpperCase(Locale.ROOT);
        System.out.println("대문자 변환 : newStr = " + newStr);

        StringBuilder sb = new StringBuilder();
        int length = newStr.length();
        for (int i = 0; i < length; i++) {
            sb.append(newStr.charAt(i));
        }
        System.out.println("length = " + length);

        for (int i = k; i < length; i+=k) {
            sb.insert(length-i, '-');
        }

        return sb;
    }
}
