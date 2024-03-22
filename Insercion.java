package metodosordenamiento;

import java.util.Scanner;

public class Insercion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de elementos: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Ingrese los elementos:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("\nArray original:");
        printArray(arr);

        insertionSort(arr);

        System.out.println("\nArray ordenado:");
        printArray(arr);

        scanner.close();
    }

    // Método para ordenar un arreglo utilizando el algoritmo de inserción
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            // Mover los elementos del arreglo que son mayores que key
            // a una posición adelante de su posición actual
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // Método para imprimir un arreglo
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
