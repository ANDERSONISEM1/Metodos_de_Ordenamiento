

package metodosordenamiento;

import java.util.Scanner;

public class Rapida {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar al usuario la cantidad de elementos a ordenar
        System.out.print("Ingrese la cantidad de elementos a ordenar: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        // Solicitar al usuario los elementos a ordenar
        System.out.println("Ingrese los elementos a ordenar:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // Ordenar el arreglo utilizando el algoritmo Quick Sort
        quickSort(arr, 0, n - 1);
        
        // Mostrar los elementos ordenados
        System.out.println("\nElementos ordenados:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    // Método para ordenar un arreglo utilizando el algoritmo Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Método auxiliar para realizar la partición en el algoritmo Quick Sort
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
