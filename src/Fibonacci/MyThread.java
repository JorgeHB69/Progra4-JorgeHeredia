package Fibonacci;

public class MyThread extends Thread {
    static ArrayRandom arrayRandom = new ArrayRandom(10);
    private int row;

    public MyThread(int numberOfThread) {
        this.row = numberOfThread;
    }

    @Override
    public void run() {
        arrayRandom.calculateFibonacciArray(row);
    }
}
