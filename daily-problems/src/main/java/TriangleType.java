public class TriangleType {
    public String triangleType(int[] nums) {
        final int firstNo = nums[0];
        final int secondNo = nums[1];
        final int thirdNo = nums[2];

        final int sum = firstNo + secondNo + thirdNo;
        int largest = firstNo >= secondNo && firstNo >= thirdNo
            ? 0 : secondNo >= firstNo && secondNo >= thirdNo
            ? 1 : 2;

        if (nums[largest] >= sum - nums[largest]) {
            return "none";
        }

        if (firstNo == secondNo && firstNo == thirdNo) {
            return "equilateral";
        } else if (firstNo == secondNo || firstNo == thirdNo || secondNo == thirdNo) {
            return "isosceles";
        }
        return "scalene";
    }

    public static void main(String[] args) {
        TriangleType tt = new TriangleType();

        int[][] testCases = {
            {3, 3, 3},    // equilateral
            {3, 4, 4},    // isosceles
            {3, 4, 5},    // scalene
            {1, 2, 3},    // none
            {5, 5, 10},   // none
            {7, 7, 14},   // none
            {2, 2, 3}     // isosceles
        };

        for (int[] sides : testCases) {
            System.out.printf("Sides: %d, %d, %d -> Type: %s%n",
                sides[0], sides[1], sides[2], tt.triangleType(sides));
        }
    }
}
