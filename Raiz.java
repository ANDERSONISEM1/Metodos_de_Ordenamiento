package metodosordenamiento;

import java.util.*;

public class Raiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de números a ordenar:");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Ingrese los números a ordenar:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        radixSort(arr);

        System.out.println("Números ordenados:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        scanner.close();
    }

    // Función para ordenar el arreglo usando Radix Sort
    public static void radixSort(int[] arr) {
        int max = getMax(arr); // Obtiene el máximo número en el arreglo

        // Realiza counting sort para cada dígito. exp se multiplica por 10 en cada iteración
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }

    // Función para obtener el máximo número en un arreglo
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // Función para ordenar el arreglo usando Counting Sort basado en el dígito representado por exp
    public static void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // Arreglo de salida
        int[] count = new int[10]; // Arreglo para almacenar el conteo de dígitos

        // Almacena el conteo de apariciones de cada dígito en el arreglo count[]
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Cambia count[i] para que count[i] ahora contenga la actual
        // posición de este dígito en el arreglo de salida
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Construye el arreglo de salida
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copia el arreglo de salida al arreglo original arr[] para reflejar los cambios
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
}
