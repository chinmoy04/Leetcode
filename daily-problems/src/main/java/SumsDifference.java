public class SumsDifference {
    public int differenceOfSums(int n, int m) {
        final int sum = n*(n+1)/2;
        int divSum = 0;
        for (int i=1; i<=n/m; i++) {
            divSum += m * i;
        }

        final int NonDivSum = sum - divSum;
        return NonDivSum - divSum;
    }

    public static void main(String[] args) {
        SumsDifference sd = new SumsDifference();

        int[][] testCases = {
            {10, 2},   // 30
            {10, 3},   // 25
            {20, 5},   // 70
            {15, 4},   // 45
            {100, 10}  // 450
        };

        for (int[] testCase : testCases) {
            int n = testCase[0];
            int m = testCase[1];
            int result = sd.differenceOfSums(n, m);
            System.out.printf("n=%d, m=%d -> Difference of sums: %d%n", n, m, result);
        }
    }
}
