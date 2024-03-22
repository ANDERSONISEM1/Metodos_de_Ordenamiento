
package metodosordenamiento;

import java.util.Scanner;

public class Burbuja {
    // Método para ordenar un arreglo de enteros utilizando el algoritmo de burbuja
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // Iterar a través del arreglo, comparando elementos adyacentes
            for (int j = 0; j < n - i - 1; j++) {
                // Si el elemento actual es mayor que el siguiente, intercambiarlos
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
// metodo main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los números separados por espacios:");
        String input = scanner.nextLine();
        String[] strArr = input.split(" ");
        int[] arr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        System.out.println("Array original:");
        printArray(arr);

        bubbleSort(arr);

        System.out.println("\nArray ordenado:");
        printArray(arr);

        scanner.close();
    }

    // Método auxiliar para imprimir un arreglo de enteros
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
