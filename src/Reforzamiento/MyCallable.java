package Reforzamiento;


import java.util.concurrent.Callable;

public class MyCallable implements Callable<int[]> {

    int[] array;
    ProgressCallback callback;

    public MyCallable(int[] array, ProgressCallback callback){
        this.array = array;
        this.callback = callback;
    }

    @Override
    public int[] call() throws Exception {
        Thread.sleep(5000);
        for (int i = 0; i < array.length; i++){
            array[i] = (int) Calculator.getFibonacciProduct(array[i]);
            callback.onProgressUpdate();
        }
        return array;
    }
}
