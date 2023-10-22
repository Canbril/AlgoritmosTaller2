package Funcionan;

import java.util.Random;

public class PigeonholeSort {

    public static void pigeonholeSortMatrix(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int min = matrix[0][0];
        int max = matrix[0][0];

        // Encontrar el valor mínimo y máximo en la matriz
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }

        // Crear un arreglo de "agujeros" (pigeonholes)
        int[] pigeonholes = new int[max - min + 1];

        // Contar la frecuencia de cada elemento en la matriz
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                pigeonholes[matrix[i][j] - min]++;
            }
        }

        int index = 0;

        // Reescribir la matriz con los elementos ordenados
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                while (pigeonholes[index] == 0) {
                    index++;
                }
                matrix[i][j] = index + min;
                pigeonholes[index]--;
            }
        }
    }

    public static void main(String[] args) {
        int numRows = 100;
        int numCols = 100;
        int[][] matrix = new int[numRows][numCols];
        Random random = new Random();

        // Llenar la matriz con números aleatorios del 1 al 999
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                matrix[i][j] = random.nextInt(999) + 1;
            }
        }

        System.out.println("Matriz original:");
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        // Medir el tiempo de ejecución
        long startTime = System.currentTimeMillis();
        pigeonholeSortMatrix(matrix);
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);

        System.out.println("\nMatriz ordenada:");
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("Tiempo de ejecución: " + duration + " milisegundos");
    }
}