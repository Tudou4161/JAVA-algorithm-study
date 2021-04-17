package chap01;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {1,2,3};
        //int[] digits = {8,9,9};
        int[] result = plusOne(digits);
        for (int i : result) {
            System.out.println("val = " + i);
        }
    }

    private static int[] plusOne(int[] digits) {
        //write your code.
        int index = digits.length - 1;
        int carry = 1;

        while (index >= 0 && carry > 0) {
            digits[index] = (digits[index] + 1) % 10;
            if (digits[index] == 0) {
                carry = 1;
            } else {
                carry = 0; //0으로 바꾸면 알아서 멈춤.
            }
            --index;
        }

        if (carry == 1) {
            digits = new int[digits.length+1];
            digits[0] = 1;
        }

        return digits;
    }
}