package chap01;

import java.util.*;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        KthLargestElementInAnArray a = new KthLargestElementInAnArray();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println("solve_arr(nums, k) = " + a.solve_arr(nums, k));
        System.out.println("solve_pq(nums, k) = " + a.solve_pq(nums, k));
    }

    private int solve_pq(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comp);

        for(int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    Comparator<Integer> Comp = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    };

    private int solve_arr(int[] nums, int k) {
        Arrays.sort(nums);
        int[] arr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        return arr[nums.length-k];
    }


    public void print(int[] nums) {
        for (int i:nums)
            System.out.println("i = " + i);
    }
}
