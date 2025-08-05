import java.util.Arrays;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int ans = nums[0];
        int count = 1;
        for (int i=1; i<nums.length; i++) {
            if (count == 0) {
                ans = nums[i];
            }

            if (nums[i] == ans) {
                count++;
            } else {
                count--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();

        int[][] testCases = {
            {3, 2, 3},       // 3
            {2, 2, 1, 1, 1, 2, 2}, // 2
            {1, 1, 2, 2, 3, 3, 3}, // 3
            {5, 5, 5, 1, 1}, // 5
            {1},             // 1
            {7, 7, 7, 8, 8} // 7
        };

        for (int[] nums : testCases) {
            System.out.printf("Array: %s -> Majority Element: %d%n",
                Arrays.toString(nums), me.majorityElement(nums));
        }
    }
}
