import java.util.HashSet;
import java.util.Set;

public class SetZeroes {
        public void setZeroes(int[][] matrix) {

            boolean firstCol = false;
            boolean firstRow = false;

            for(int i=0; i<matrix.length; i++){
                if(matrix[i][0] == 0){
                    firstCol = true;
                    break;
                }
            }

            for(int i=0; i<matrix[0].length; i++){
                if(matrix[0][i] == 0){
                    firstRow = true;
                    break;
                }
            }

            for(int i=1; i<matrix.length; i++){
                for(int j=1; j<matrix[i].length; j++){
                    if(matrix[i][j] == 0){
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }

            for(int i=1; i<matrix.length; i++){
                for(int j=1; j<matrix[i].length; j++){
                    if(matrix[i][0] == 0 || matrix[0][j] == 0){
                        matrix[i][j] = 0;
                    }
                }
            }

            if(firstCol){
                for(int i=0; i<matrix.length; i++){
                    matrix[i][0] = 0;
                }
            }

            if(firstRow){
                for(int j=0; j<matrix[0].length; j++){
                    matrix[0][j] = 0;
                }
            }

        }

    public void setZeroes1(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(java.util.Arrays.toString(row));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SetZeroes sz = new SetZeroes();

        int[][] matrix1 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        int[][] matrix2 = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };

        // Test setZeroes
        System.out.println("Before setZeroes:");
        printMatrix(matrix1);
        sz.setZeroes(matrix1);
        System.out.println("After setZeroes:");
        printMatrix(matrix1);

        // Test setZeroes1
        System.out.println("Before setZeroes1:");
        printMatrix(matrix2);
        sz.setZeroes1(matrix2);
        System.out.println("After setZeroes1:");
        printMatrix(matrix2);
    }

}


