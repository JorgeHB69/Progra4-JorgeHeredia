package Fibonacci;

public class MyThread implements Runnable {
    static ArrayRandom arrayRandom;
    static int counter = 0;
    private int numberOfThread;
    private int totalThreads;
    private int rowsPerThread;

    public MyThread(int numberOfThread, int totalThreads) {
        this.numberOfThread = numberOfThread;
        this.totalThreads = totalThreads;
        this.rowsPerThread = (int) Math.ceil((double) arrayRandom.getSize()/ (double) totalThreads);
    }

    @Override
    public void run() {
        for (int i = numberOfThread * rowsPerThread; i <= (((numberOfThread + 1) * rowsPerThread) - 1); i++) {
            if (i >= arrayRandom.getSize()) {
                break;
            }
            arrayRandom.calculateFibonacciArray(i);
        }
    }
}
