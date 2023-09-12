package Practice10;

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
        System.out.println("//FIRST PART//");
        int n = askPositiveNumber("Insert n: ");
        HighestPowerCallable a = new HighestPowerCallable(n);
        System.out.println(a.findHighestPowerOf2());
        System.out.println("////");
        System.out.println("//SECOND PART//");
        ArrayCreator arrayCreator = new ArrayCreator();
        int[] array = arrayCreator.createEnumeratedArray(n);

        ExecutorService executor = Executors.newSingleThreadExecutor();

        ArrayList<Future<Integer>> results = new ArrayList<>();
        for (int j : array) {
            Callable<Integer> highestPowerCallable = new HighestPowerCallable(j);
            Future<Integer> future = executor.submit(highestPowerCallable);
            results.add(future);
        }
        executor.shutdown();

        for (int i = 0; i < array.length; i++) {
            Future<Integer> res = results.get(i);
            try {
                System.out.print(res.get() + " - ");
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}