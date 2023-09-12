package Practice10;

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
        return findHighestPowerOf2();
    }
}
