package Recuperatorio;

public class ArrayCreator {
    public static int[][] getArray(int n) {
        int[][] array = new int[n][2];

        int counter = 1;
        for (int[] row : array) {
            row[0] = counter;
            row[1] = counter + 1;
            counter += 2;
        }

        return array;
    }
}
