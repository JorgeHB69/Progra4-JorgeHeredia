package Recuperatorio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class ThreeLetters implements Callable<String> {
    private int a, b;

    public ThreeLetters(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public String getSuccesion() {
        StringBuilder result = new StringBuilder();

        while (a > 0 || b > 0) {
            if (b > a) {
                result.append('b');
                b--;
            } else {
                result.append('a');
                a--;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        ThreeLetters threeLetters = new ThreeLetters(3, 5);
        String succession = threeLetters.getSuccesion();
        System.out.println(succession);

        System.out.println(Arrays.deepToString(ArrayCreator.getArray(5)));
    }

    @Override
    public String call() throws Exception {
        return getSuccesion();
    }
}
