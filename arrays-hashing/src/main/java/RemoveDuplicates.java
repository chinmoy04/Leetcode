import java.util.Arrays;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int l = 0;
        for (int i=0; i < nums.length-1; i++) {
            if (nums[i] != nums[i+1]) {
                nums[l++] = nums[i];
            }
        }
        nums[l] = nums[nums.length-1];
        return l+1;
    }

    public static void main(String[] args) {
        RemoveDuplicates rd = new RemoveDuplicates();

        int[][] testCases = {
            {1, 1, 2},       // 2
            {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, // 5
            {1, 2, 3, 4},   // 4
            {1, 1, 1},      // 1
            {5},            // 1
            //{},             // 0
        };

        for (int[] nums : testCases) {
            int length = rd.removeDuplicates(nums);
            System.out.printf("Array: %s -> Length after removing duplicates: %d%n",
                Arrays.toString(nums), length);
        }
    }
}
