package Reforzamiento;

public class WorkHandler {
    public static int[][] divideArray(int[] arr, int numRows) {
        int elementsPerRow = arr.length / numRows;
        int[][] result = new int[numRows][elementsPerRow];
        int index = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < elementsPerRow; j++) {
                result[i][j] = arr[index];
                index++;
            }
        }

        return result;
    }
}
