package Fibonacci;

import java.util.Random;

public class ArrayRandom {
    private long[][] array2D;

    public ArrayRandom(int n, int m, int maxRand, int minRand) {
        array2D = new long[n][m];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array2D[i][j] = random.nextInt(maxRand-minRand) + minRand;
            }
        }
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array2D.length; i++) {
            sb.append("[");
            for (int j = 0; j < array2D[0].length; j++) {
                if (j + 1 == array2D[0].length) {
                    sb.append(array2D[i][j] + "]\n");
                } else {
                    sb.append(array2D[i][j] + ",\t ");
                }
            }
        }
        System.out.println(sb);
    }

    public void calculateFibonacciArray() {
        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D[0].length; j++) {
                array2D[i][j] = FibonacciCalculator.getFibonacciProduct(array2D[i][j]);
            }
        }
    }

    public void calculateFibonacciArray(int row) {
        for (int i = 0; i < array2D[0].length; i++) {
            array2D[row][i] = FibonacciCalculator.getFibonacciProduct(array2D[row][i]);
        }
    }

    public int getSize() {
        return array2D.length;
    }

    public void solveWithoutThreads() {
        System.out.println("SOLUTION WITHOUT THREADS");
        System.out.println("ORIGINAL: ");
        print();

        long startTime = System.currentTimeMillis();
        calculateFibonacciArray();
        long endTime = System.currentTimeMillis();

        System.out.println("RESULT: ");
        print();

        System.out.println("Total execution time without threads: " + (endTime - startTime) +
                "\nStart time: " + startTime +
                "\nEndTime: " + endTime + "\n");
    }

    public void solveWithThreads(int numberOfThreads) {
        MyThread.arrayRandom = this;
        System.out.println("SOLUTION WITH THREADS");
        System.out.println("ORIGINAL: ");
        MyThread.arrayRandom.print();

        Thread[] threads = new Thread[numberOfThreads];

        for (int i = 0; i < threads.length; i++) {
            Runnable runnable = new MyThread(i, threads.length);
            threads[i] = new Thread(runnable);
            threads[i].start();
        }

        long startTime = System.currentTimeMillis();

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();

        System.out.println("RESULT: ");
        MyThread.arrayRandom.print();

        System.out.println("Total execution time with threads: " + (endTime - startTime) +
                "\nStart time: " + startTime +
                "\nEndTime: " + endTime + "\n");

    }
}
