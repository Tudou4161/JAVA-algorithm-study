package chap01;

public class MoveZeros {
    public static void main(String[] args) {
        //1. 배열 미리 선언하기.
        int[] nums = {0,3,2,0,8,5,0,4,11};
        int index = 0;

        //2. iter = num to frontpoint;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        //3. iter = zero to endpoint;
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }

        //4. 출력
        for (int i = 0; i<nums.length; i++) {
            System.out.println("nums[i] = " + nums[i]);
        }
    }
}
