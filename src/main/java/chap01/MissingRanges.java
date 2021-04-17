package chap01;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public static void main(String[] args) {
        int[] nums = {0,2,3,5,50,75};
        int lower = 0, upper = 99;
        System.out.println("solve(nums, lower, upper) = " + solve(nums, lower, upper));

    }

    private static List<String> solve(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        //1. lower < nums
        // condition 만드는게 제일 짜증나네 ^^..^^ ..
        if (lower < nums[0]) {
            result.add(makeRange(lower, nums[0]-1));
        }

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] != nums[i+1] && nums[i]+1 < nums[i+1]) {
                result.add(makeRange(nums[i]+1, nums[i+1]-1));
            }
        }

        if (nums[nums.length-1] < upper) {
            result.add(makeRange(nums[nums.length-1]+1, upper));
        }

        return result;
    }

    private static String makeRange(int start, int end) {
        return start == end ? String.valueOf(start) : start + "->" + end;
    }

}








//    private static List<String> solve(int[] nums, int lower, int upper) {
//        //1. ds
//        List<String> results = new ArrayList<>();
//        if (nums == null || nums.length == 0) return results;
//
//        //2. 첫번째 원소와 lower값 비교.
//        if (lower < nums[0]) {
//            results.add(makeRange(lower, nums[0]-1));
//        }
//
//        //2-2. 추후 원소부턴 값 간의 차이에 따라서 range를 출력해준다.
//        for (int i = 0; i <nums.length-1; i++) { //마지막 원소 직전까지만 순회.
//            if (nums[i] != nums[i+1] && nums[i]+1 < nums[i+1]) {
//                results.add(makeRange(nums[i]+1, nums[i+1]-1));
//            }
//        }
//
//        //2-3. 마지막 원소부터 upper까지의 range를 출력.
//        if(nums[nums.length-1] < upper) {
//            results.add(makeRange(nums[nums.length-1]+1, upper));
//        }
//
//        return results;
//    }
//
//
//    private static String makeRange(int low, int high) {
//        return low==high ? String.valueOf(low) : (low + "->" + high);
//    }
