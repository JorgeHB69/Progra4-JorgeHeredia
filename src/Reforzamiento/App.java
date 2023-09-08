package Reforzamiento;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.*;

public class App implements ProgressCallback {

    public int quantity;
    public int threads;
    public double percent = 0;

    public App(int quantity, int threads){
        this.threads = threads;
        this.quantity = quantity;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert array size: ");
        int quantity = scanner.nextInt();
        int cores = 3;
        ProgressCallback callback = new App(quantity, cores);

        int[] array = ArrayCreator.createEnumeratedArray(quantity);
        int[][] splitWork = WorkHandler.divideArray(array, cores);

        ExecutorService executorService = Executors.newFixedThreadPool(cores);

        ArrayList<FutureTask<int[]>> results = new ArrayList<>();


        for (int i = 0; i < splitWork.length; i++){
            Callable<int[]> callable = new MyCallable(splitWork[i], callback);
            results.add(new FutureTask<>(callable));
            executorService.execute(results.get(i));
        }
        executorService.shutdown();

        int index = 0;
        for (FutureTask<int[]> res : results) {
            try {
               int[] aux = res.get();
               for (int j = 0; j < aux.length; j++){
                   array[index] = aux[j];
                   index++;
               }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Arrays.toString(array));

    }

    @Override
    public synchronized void onProgressUpdate() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.percent += 100./ quantity;
        System.out.println("Progress: " + percent + "%");
    }
}
