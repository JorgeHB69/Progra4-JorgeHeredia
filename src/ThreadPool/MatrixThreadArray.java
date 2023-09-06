package ThreadPool;

import Fibonacci.MyThread;

import java.util.Arrays;

public class MatrixThreadArray implements Runnable {
    private static int n;
    public static int[][] matrix;
    public static int nThreads;
    public MatrixThreadArray() {    }

    public static void setN(int n) {
        MatrixThreadArray.n = n;
    }

    public static void setNThreads(int nThreads) {
        MatrixThreadArray.nThreads = nThreads;
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
        int rowsPerThread = n / nThreads;
        long nThread = Thread.currentThread().getId();
        int start;
        if (nThread == 0) {
            start = 0;
        } else {
            start = (int) ((nThread - 1) * rowsPerThread);
        }

        for (int i = start; i < nThread * rowsPerThread; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = matrix[i][j] * 5;
            }
        }
    }

    public static void main(String[] args) {
        int n = 20000;
        MatrixThreadArray.setN(n);
        MatrixThreadArray.fillMatrix();
        MatrixThreadArray.nThreads = 5;
        System.out.println(MatrixThreadArray.matrix[0][10]);

        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            Runnable runnable = new MatrixThreadArray();
            threads[i] = new Thread(runnable);
            threads[i].start();
        }

        long startTime = System.nanoTime();

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.nanoTime();
        System.out.println(MatrixThreadArray.matrix[0][10]);

        System.out.println("TIME: " + (endTime - startTime));
    }
}
