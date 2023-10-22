package Funcionan;

import java.util.Random;

public class SelectionSort {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); // Registra el tiempo de inicio

        int[][] matrix = generateRandomMatrix(100, 100, 1, 999);

        System.out.println("Matriz original:");
        printMatrix(matrix);

        selectionSortMatrix(matrix);

        System.out.println("Matriz ordenada:");
        printMatrix(matrix);

        long endTime = System.currentTimeMillis(); // Registra el tiempo de finalización
        long executionTime = endTime - startTime;
        System.out.println("Tiempo de ejecución: " + executionTime + " milisegundos");
    }

    public static int[][] generateRandomMatrix(int rows, int cols, int min, int max) {
        int[][] matrix = new int[rows][cols];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(max - min + 1) + min;
            }
        }

        return matrix;
    }

    public static void selectionSortMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int minRow = row;
                int minCol = col;

                for (int i = row; i < rows; i++) {
                    for (int j = (i == row ? col + 1 : 0); j < cols; j++) {
                        if (matrix[i][j] < matrix[minRow][minCol]) {
                            minRow = i;
                            minCol = j;
                        }
                    }
                }

                if (minRow != row || minCol != col) {
                    // Intercambiar elementos
                    int temp = matrix[row][col];
                    matrix[row][col] = matrix[minRow][minCol];
                    matrix[minRow][minCol] = temp;
                }
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}