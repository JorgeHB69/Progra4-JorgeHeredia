package Practice11;

import Practice11.ArrayCreator;
import Practice11.HighestPowerCallable;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    private static int askPositiveNumber(String message) {
        int number;
        do {
            System.out.println(message);
            number = scanner.nextInt();
        } while (number < 1 || number > 1000000000);
        return number;
    }

    public static void main(String[] args) {
        int result = 0;
        float progress = 0;
        System.out.println("//FUTURE TASK//");
        int n = askPositiveNumber("Insert n: ");
        ArrayCreator arrayCreator = new ArrayCreator();
        int[] array = arrayCreator.createEnumeratedArray(n);
        int cores = Runtime.getRuntime().availableProcessors();

        ExecutorService executor = Executors.newFixedThreadPool(cores);

        ArrayList<FutureTask<Integer>> results = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            Callable<Integer> highestPowerCallable1 = new HighestPowerCallable(j);
            results.add(new FutureTask<>(highestPowerCallable1));
            executor.execute(results.get(j));
        }
        executor.shutdown();

        for (int i = 0; i < cores; i++) {
            FutureTask<Integer> res = results.get(i);
            try {
                result += res.get();
                progress += (100.0/cores);
                System.out.println("Progress: " + progress + "%");
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}