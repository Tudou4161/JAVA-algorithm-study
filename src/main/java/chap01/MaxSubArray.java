package chap01;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("결과값 = " + solve(nums));
    }

    public static int solve(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int newSum = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            newSum = Math.max(nums[i], newSum + nums[i]);
            System.out.println("newSum = " + newSum);
            max = Math.max(newSum, max);
            System.out.println("max = " + max);
        }
        return max;
    }
}


















    //1. ds
//    int newSum = nums[0];
//    int max = nums[0];
//
////2. iter
//        for (int i = 1; i < nums.length; i++) {
//        //현재 위치의 값과 현재 위치의 값과 newSum값 중에 어떤게 큰지
//        System.out.print("nums = " + nums[i]);
//        newSum = Math.max(nums[i], newSum+nums[i]);
//
//        System.out.print(" : newSum = " + newSum);
//        //newSum과 기존의 max값과 비교.
//
//        max = Math.max(newSum, max);
//        System.out.println(" : max = " + max);
//        }
//        return max;
