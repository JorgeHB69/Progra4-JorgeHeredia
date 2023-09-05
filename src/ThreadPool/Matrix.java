package ThreadPool;

import java.util.Arrays;

public class Matrix implements Runnable {
    private static int n;
    public static int[][] matrix;
    private int rowAssigned;
    public Matrix(int row) {
        this.rowAssigned = row;
    }

    public static void setN(int n) {
        Matrix.n = n;
    }

    public static void fillMatrix() {
        matrix = new int[n][n];
        if (matrix[0][0] == 0) {
            int counter = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = counter;
                    counter++;
                }
            }
        }
    }

    public static void print() {
        StringBuilder sb = new StringBuilder("MATRIZ:\n");
        for (int i = 0; i < n; i++) {
            sb.append(Arrays.toString(matrix[i]) + "\n");
        }
        System.out.println(sb);
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            matrix[rowAssigned][i] = matrix[rowAssigned][i] * 5;
        }
    }
}
