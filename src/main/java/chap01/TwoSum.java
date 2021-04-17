package chap01;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum a = new TwoSum();

        //int[] nums = {2,8,11,14};
        int[] nums = {3, 7, 8, 10};
        int target = 15;
        int[] result = a.solve(nums, target);
        for(int i : result) {
            System.out.print(i+" ");
        }
    }

    //fill out your code!
    public int[] solve(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for(int i = 0; i < nums.length; i++) {
            //순회 중, 만약 원소 값과 키 값이 일치하는 경우 -> 일치하는 원소의 value 값과 순회 원소의 index를 반환한다.
            if (map.containsKey(nums[i])) {
                int value = map.get(nums[i]);
                result[0] = value+1;
                result[1] = i+1;
            } else { //일치하지 않는 경우 -> map에 값을 계속 put 시킨다.
                map.put(target - nums[i], i);
            }
        }
        return result;
    };
}


