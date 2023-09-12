package Recuperatorio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.*;

public class SuccessionManagerThread {

    public void solveWithoutConcurrency(int[][] array) {
        for (int[] row : array) {
            ThreeLetters threeLetters = new ThreeLetters(row[0], row[1]);
            System.out.println(threeLetters.getSuccesion());
        }
    }

    public void solveWithConcurrency(int[][] array, ExecutorService executor, ArrayList<FutureTask<String>> results) {
        for (int i = 0; i < array.length; i++) {
            Callable<String> succession = new ThreeLetters(array[i][0], array[i][1]);
            results.add(new FutureTask<>(succession));
            executor.execute(results.get(i));
        }
        executor.shutdown();

        for (FutureTask<String> res : results) {
            try {
                System.out.println(res.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        SuccessionManagerThread successionManagerThread = new SuccessionManagerThread();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please insert the size of array [n][2]: ");
        int n = scanner.nextInt();
        int[][] array = ArrayCreator.getArray(n);

        System.out.println("WITHOUT CONCURRENCY");
        long startTime = System.nanoTime();
        successionManagerThread.solveWithoutConcurrency(array);
        long endTime = System.nanoTime();
        long timeSequential = endTime - startTime;

        System.out.println("\nWITH CONCURRENCY");
        ExecutorService executor = Executors.newSingleThreadExecutor();
        ArrayList<FutureTask<String>> results = new ArrayList<>();

        startTime = System.nanoTime();
        successionManagerThread.solveWithConcurrency(array, executor, results);
        endTime = System.nanoTime();
        long timeConcurrency = endTime - startTime;

        System.out.println("\n\nTIME SEQUENTIAL: " + timeSequential);
        System.out.println("TIME CONCURRENCY: " + timeConcurrency);
        String mayor = (timeConcurrency < timeSequential) ? "Concurrencia es mas rapido" : "Secuencial es mas rapido";
        System.out.println(mayor);
        //USUALMENTE LA FORMA SECUENCIAL ES MAS RAPIDA CON ARRAYS PEQUEÑOS, A PARTIR DE 50 LA CONCURRENCIA SIEMPRE ES MAS RAPIDA.
    }
}
