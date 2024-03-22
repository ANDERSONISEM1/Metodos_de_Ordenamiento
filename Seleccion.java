


package metodosordenamiento;

import java.util.Scanner;

public class Seleccion{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario la cantidad de números a ordenar
        System.out.print("Ingrese la cantidad de números a ordenar: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        // Solicitar al usuario los números a ordenar
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el número " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        // Mostrar el array antes del ordenamiento
        System.out.println("\nArray antes del ordenamiento:");
        printArray(arr);

        // Llamar al método de ordenamiento selectionSort
        selectionSort(arr);

        // Mostrar el array después del ordenamiento
        System.out.println("\nArray después del ordenamiento:");
        printArray(arr);

        scanner.close();
    }

    // Implementación del algoritmo de ordenamiento por selección
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Intercambiar el elemento mínimo con el primer elemento no ordenado
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Método para imprimir un array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
