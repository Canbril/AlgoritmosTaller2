package Funcionan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BucketSort {

    public static void bucketSort(int[][] matrix) {
        int maxVal = findMaxValue(matrix);
        int minVal = findMinValue(matrix);
        int range = maxVal - minVal + 1;

        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();

        // Inicializar los buckets
        for (int i = 0; i < range; i++) {
            buckets.add(new ArrayList<>());
        }

        // Colocar los elementos en los buckets
        for (int[] row : matrix) {
            for (int num : row) {
                int index = num - minVal;
                buckets.get(index).add(num);
            }
        }

        // Ordenar los elementos dentro de los buckets
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // Combinar los elementos ordenados de los buckets en la matriz original
        int row = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int num : bucket) {
                matrix[row / matrix[0].length][row % matrix[0].length] = num;
                row++;
            }
        }
    }

    private static int findMaxValue(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] row : matrix) {
            for (int num : row) {
                if (num > max) {
                    max = num;
                }
            }
        }
        return max;
    }

    private static int findMinValue(int[][] matrix) {
        int min = matrix[0][0];
        for (int[] row : matrix) {
            for (int num : row) {
                if (num < min) {
                    min = num;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[10][10];
        Random rand = new Random();

        // Llenar la matriz con números aleatorios entre 1 y 999
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matrix[i][j] = rand.nextInt(999) + 1;
            }
        }

        System.out.println("Matriz original:");
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }

        // Medir el tiempo de ejecución
        long startTime = System.currentTimeMillis();
        bucketSort(matrix);
        long endTime = System.currentTimeMillis();

        System.out.println("Matriz ordenada:");
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }

        System.out.println("Tiempo de ejecución: " + (endTime - startTime) + " milisegundos");
    }
}