package Fibonacci;

import java.util.Random;

public class ArrayRandom {
    private long[][] array2D;

    public ArrayRandom(int n) {
        array2D = new long[n][n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array2D[i][j] = random.nextInt(200-2) + 2;
            }
        }
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array2D.length; i++) {
            sb.append("[");
            for (int j = 0; j < array2D.length; j++) {
                if (j + 1 == array2D.length) {
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
            for (int j = 0; j < array2D.length; j++) {
                array2D[i][j] = FibonacciCalculator.getFibonacciProduct(array2D[i][j]);
            }
        }
    }

    public void calculateFibonacciArray(int row) {
        row -= 1;
        for (int i = 0; i < array2D.length; i++) {
            array2D[row][i] = FibonacciCalculator.getFibonacciProduct(array2D[row][i]);
        }
    }

    public int getSize() {
        return array2D.length;
    }

    public static void main(String[] args) {
        //Without use threads
        ArrayRandom arrayRandom = new ArrayRandom(10);
        arrayRandom.print();

        long startTime = System.currentTimeMillis();
        arrayRandom.calculateFibonacciArray();
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) +
                "\nStart time: " + startTime +
                "\nEndTime: " + endTime + "\n");

        arrayRandom.print();

        MyThread myThread1 = new MyThread(1);
        MyThread myThread2 = new MyThread(2);
        MyThread myThread3 = new MyThread(3);
        MyThread myThread4 = new MyThread(4);

        MyThread.arrayRandom.print();

        startTime = System.currentTimeMillis();
        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();

        try {
            myThread1.join();
            myThread2.join();
            myThread3.join();
            myThread4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));

        MyThread.arrayRandom.print();
    }
}
