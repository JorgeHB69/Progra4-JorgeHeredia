package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Main {
    public static void main(String[] args) {
        int n = 20000;
        Matrix.setN(n);
        Matrix.fillMatrix();
        System.out.println(Matrix.matrix[0][10]);
        //Matrix.print();

        //SINGLE TIME: 160 ms
        //FIXED TIME(5 threads): 148
        //CACHE TIME: 260 ms
        ExecutorService executor = Executors.newFixedThreadPool(5);

        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            Runnable matrix = new Matrix(i);
            executor.execute(matrix);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        long endTime = System.nanoTime();
        System.out.println(Matrix.matrix[0][10]);

        System.out.println("TIME: " + (endTime - startTime));
    }
}
