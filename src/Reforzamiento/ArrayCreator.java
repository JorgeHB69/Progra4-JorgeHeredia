package Reforzamiento;

public class ArrayCreator {
    public static int[] createEnumeratedArray(int n) {
        int[] array = new int[n];
        for (int i = 1; i <= n; i++) {
            array[i - 1] = i;
        }
        return array;
    }
}
