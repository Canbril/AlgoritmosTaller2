package Funcionan;

import java.util.Arrays;
import java.util.Random;

public class RadixSort {

    public static void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    public static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
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

        int[] flatArray = Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .toArray();

        radixSort(flatArray);

        // Ahora flatArray contiene los elementos ordenados
        System.out.println("Matriz ordenada:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(flatArray[i * matrix[i].length + j] + " ");
            }
            System.out.println();
        }
    }
}

