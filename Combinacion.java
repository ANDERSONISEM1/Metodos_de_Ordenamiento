package metodosordenamiento;

import java.util.Scanner;

public class Combinacion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario la cantidad de elementos a ordenar
        System.out.print("Ingrese la cantidad de elementos a ordenar: ");
        int n = scanner.nextInt();

        // Crear un arreglo para almacenar los elementos
        int[] arr = new int[n];
        System.out.println("Ingrese los elementos:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Llamar al método mergeSort para ordenar el arreglo
        mergeSort(arr, 0, n - 1);

        // Mostrar el arreglo ordenado
        System.out.println("\nArreglo ordenado:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    // Método para realizar el ordenamiento por mezcla (merge sort)
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            // Ordenar la primera mitad del arreglo
            mergeSort(arr, l, m);
            // Ordenar la segunda mitad del arreglo
            mergeSort(arr, m + 1, r);

            // Combinar las dos mitades ordenadas
            merge(arr, l, m, r);
        }
    }

    // Método para combinar dos subarreglos ordenados en un arreglo ordenado
    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        // Crear arreglos temporales para almacenar las dos mitades
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copiar los elementos a los arreglos temporales
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Combinar los arreglos temporales en el arreglo original
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copiar los elementos restantes de L[] si los hay
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copiar los elementos restantes de R[] si los hay
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
