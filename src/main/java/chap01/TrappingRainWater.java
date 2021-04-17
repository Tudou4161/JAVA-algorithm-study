package chap01;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("solve(nums) = " + solve(nums));
    }

    private static int solve(int[] nums) {
        //1. ds -> 데이터 구조 구하기. (벽 높이)
        int result = 0;
        if (nums.length == 0 || nums == null) return result;
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        //2. left -> 왼쪽 방향으로 물이 채워졌을 때의 높이를 구함.
        int max = nums[0];
        left[0] = nums[0];
        for (int i = 1; i < left.length; i++) {
            if (max < nums[i]) {
                left[i] = nums[i];
                max = nums[i];
            } else {
                left[i] = max;
            }
        }

        //3. right -> 오른쪽 방향으로 물이 채워졌을 때의 높이를 구함.
        int max2 = nums[nums.length-1];
        right[nums.length-1] = nums[nums.length-1];
        for (int i = nums.length-2; i >= 0; i--) {
            if (max2 < nums[i]) {
                right[i] = nums[i];
                max2 = nums[i];
            } else {
                right[i] = max2;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println("left = " + left[i] + " right = " + right[i]);
        }

        //4. math.min -> 물과 벽을 포함한 실제 높이.
        // nums[i] -> 벽의 높이.
        // 둘을 빼주면 물의 높이만 계산된다.
        for (int i = 0; i < nums.length; i++) {
            //System.out.println("result = " + Math.min(left[i], right[i])-nums[i]);
            result += Math.min(left[i], right[i])-nums[i];
        }

        return result;
    }
}
