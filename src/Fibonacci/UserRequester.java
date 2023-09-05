package Fibonacci;

import java.util.Scanner;

public class UserRequester {

    Scanner scanner = new Scanner(System.in);
    private int sizeOfRows;
    private int sizeOfColumns;
    private int numOfThreads;
    private int minNumRandom;
    private int maxNumRandom;

    public void sayHi() {
        System.out.println("---\tWelcome to fibonacci Array calculator\t---\n");
    }

    public void requestArraySize() {
        System.out.print("\nPlease insert the rows size: ");
        sizeOfRows = scanner.nextInt();
        System.out.print("\nPlease insert the column size: ");
        sizeOfColumns = scanner.nextInt();
    }

    public void requestNumberOfThreads() {
        System.out.print("\nHow many threads want to use?: ");
        numOfThreads = scanner.nextInt();
    }

    public void requestRandomLimits() {
        System.out.print("\nInsert the min number random: ");
        minNumRandom = scanner.nextInt();
        System.out.print("\nInsert the max number random: ");
        maxNumRandom = scanner.nextInt();
    }

    public void requestAll() {
        sayHi();
        requestArraySize();
        requestNumberOfThreads();
        requestRandomLimits();
    }

    public static void main(String[] args) {
        UserRequester userRequester = new UserRequester();
        userRequester.requestAll();
        ArrayRandom arrayRandom = new ArrayRandom(userRequester.sizeOfRows,
                userRequester.sizeOfColumns, userRequester.maxNumRandom, userRequester.minNumRandom);

        arrayRandom.solveWithoutThreads();

        ArrayRandom arrayRandom2 = new ArrayRandom(userRequester.sizeOfRows,
                userRequester.sizeOfColumns, userRequester.maxNumRandom, userRequester.minNumRandom);
        arrayRandom2.solveWithThreads(userRequester.numOfThreads);
    }
}
