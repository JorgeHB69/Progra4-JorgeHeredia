package Practice11;

public class ArrayCreator {
    public int[] createEnumeratedArray(int n) {
        int[] array = new int[n];
        for (int i = 1; i <= n; i++) {
            array[i - 1] = i;
        }
        return array;
    }
}
