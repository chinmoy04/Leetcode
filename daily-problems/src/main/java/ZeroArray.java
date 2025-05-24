import java.util.Arrays;

public class ZeroArray {
    public boolean isZeroArray(int[] nums, int[][] queries) {//[1,0,1]  [0,2]
        int len = nums.length;
        int[] diff = new int[len];

        diff[0] = nums[0];
        for (int i=1; i<len; i++) {
            diff[i] = nums[i] - nums[i-1];//1,-1,1
        }

        for (int i=0; i < queries.length; i++) {
            int[] arr = queries[i];//0,2
            diff[arr[0]] -= 1;//0,-1,1
            if (arr[1] + 1 < len) {//
                diff[arr[1] + 1] += 1;
            }
        }

        for (int j=1; j<len; j++) {
            diff[j] = diff[j-1] + diff[j];//0,0,1
        }

        for (int i=0; i<len; i++) {
            if (diff[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ZeroArray za = new ZeroArray();

        Object[][] testCases = {
                { new int[] {1, 0, 1}, new int[][] { {0, 2} } },
                { new int[] {2, 2, 2}, new int[][] { {0, 2}, {0, 2} } },
                { new int[] {1, 2, 3}, new int[][] { {0, 0}, {1, 1}, {2, 2} } },
                { new int[] {0, 0, 0}, new int[][] {} },
                { new int[] {5, 5, 5, 5}, new int[][] { {0, 3}, {0, 3}, {0, 3}, {0, 3}, {0, 3} } },
                { new int[] {3, 1, 2}, new int[][] { {0, 0}, {1, 1}, {2, 2} } },
                { new int[] {4, 0, 0, 4}, new int[][] { {0, 0}, {3, 3}, {1, 2}, {1, 2} } },
                { new int[] {1}, new int[][] { {0, 0} } },
                { new int[] {1, -1, 1}, new int[][] { {0, 2} } },
                { new int[] {2, 0, 2}, new int[][] { {0, 2}, {0, 2} } },
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] nums = (int[]) testCases[i][0];
            int[][] queries = (int[][]) testCases[i][1];
            boolean result = za.isZeroArray(nums, queries);
            System.out.printf("Test %d: nums=%s, queries=%s -> %b%n",
                i + 1, Arrays.toString(nums),
                Arrays.deepToString(queries), result);
        }
    }
}
