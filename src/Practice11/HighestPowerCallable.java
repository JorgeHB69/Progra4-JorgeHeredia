package Practice11;

import java.util.Random;
import java.util.concurrent.Callable;

public class HighestPowerCallable implements Callable<Integer> {
    private int n;

    public HighestPowerCallable(int n) {
        this.n = n;
    }

    public int findHighestPowerOf2() {
        int power = 0;
        if (n == 0) return power;
        while (n % 2 == 0) {
            n /= 2;
            power++;
        }
        return power;
    }

    @Override
    public Integer call() throws Exception {
        Random random = new Random();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return findHighestPowerOf2();
    }
}
