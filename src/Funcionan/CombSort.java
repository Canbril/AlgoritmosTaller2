package Funcionan;

import java.util.Random;

public class CombSort {
    public static void main(String[] args) {
        // Registra el tiempo de inicio
        long startTime = System.currentTimeMillis();

        int[][] matrix = generateRandomMatrix(10000, 10000, 1, 999);

        System.out.println("Matriz desordenada:");
        printMatrix(matrix);

        combSortMatrix(matrix);

        System.out.println("Matriz ordenada:");
        printMatrix(matrix);

        // Registra el tiempo de finalización
        long endTime = System.currentTimeMillis();

        // Calcula el tiempo total de ejecución en milisegundos
        long executionTime = endTime - startTime;
        System.out.println("Tiempo de ejecución: " + executionTime + " milisegundos");
    }

    public static void combSortMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            combSort(matrix[i]);
        }
    }

    public static void combSort(int[] array) {
        int n = array.length;
        int gap = n;
        boolean swapped = true;

        while (gap > 1 || swapped) {
            gap = getNextGap(gap);
            swapped = false;

            for (int i = 0; i < n - gap; i++) {
                int j = i + gap;

                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    swapped = true;
                }
            }
        }
    }

    public static int getNextGap(int gap) {
        gap = (gap * 10) / 13;
        if (gap < 1) {
            return 1;
        }
        return gap;
    }

    public static int[][] generateRandomMatrix(int rows, int cols, int min, int max) {
        int[][] matrix = new int[rows][cols];
        Random rand = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(max - min + 1) + min;
            }
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}