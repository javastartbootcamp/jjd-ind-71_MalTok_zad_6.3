package pl.javastart.task;

import java.util.Scanner;

public class ArrayUtils {
    private Scanner scanner = new Scanner(System.in);
    private final int minSize = 1;
    private final int maxSize = 100;

    public void run() {
        int arrayRows = getArrayRows();
        int arrayColumns = getArrayColumns();

        int[][] ints = createArray(arrayRows, arrayColumns);

        fillArray(ints);

        showFormattedArray(ints);

        closeScanner();
    }

    private int getArrayRows() {
        int rows;
        do {
            System.out.println("Podaj liczbę wierszy tablicy:");
            rows = scanner.nextInt();
            if (!isRowSizeOk(rows)) {
                System.out.println("Nieprawidłowa liczba wierszy");
            }
        } while (!isRowSizeOk(rows));
        return rows;
    }

    private int getArrayColumns() {
        int columns;
        do {
            System.out.println("Podaj liczbę kolumn tablicy:");
            columns = scanner.nextInt();
            if (!isColumnSizeOk(columns)) {
                System.out.println("Nieprawidłowa liczba kolumn");
            }
        } while (!isColumnSizeOk(columns));
        return columns;
    }

    private boolean isRowSizeOk(int rowsNumber) {
        return rowsNumber >= minSize && rowsNumber <= maxSize;
    }

    private boolean isColumnSizeOk(int columnsNumber) {
        return columnsNumber >= minSize && columnsNumber <= maxSize;
    }

    private int[][] createArray(int rowsNumber, int columnsNumber) {
        return new int[rowsNumber][columnsNumber];
    }

    private void fillArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = i * j;
            }
        }
    }

    private void showFormattedArray(int[][] array) {
        for (int[] row : array) {
            for (int cell : row) {
                System.out.printf(" %6d |", cell);
            }
            System.out.println();
            for (int cell : row) {
                System.out.print("---------");
            }
            System.out.println();
        }
    }

    private void closeScanner() {
        scanner.close();
    }
}
