

package metodosordenamiento;

import java.util.Scanner;

public class Monton {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //pidiendo datos al usuario
        System.out.print("Ingrese la cantidad de números a ordenar: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        //leyendo numeros ingresados
        System.out.println("Ingrese los números a ordenar:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        heapSort(arr);

        System.out.println("Números ordenados:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Construir el heap (montón) máximo
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extraer elementos del heap uno por uno
        for (int i = n - 1; i > 0; i--) {
            // Mover la raíz actual al final del arreglo
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Llamar a heapify en el montón reducido
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i; // Inicializar el nodo más grande como la raíz
        int left = 2 * i + 1; // índice del hijo izquierdo
        int right = 2 * i + 2; // índice del hijo derecho

        // Si el hijo izquierdo es más grande que la raíz
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Si el hijo derecho es más grande que el más grande hasta ahora
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // Si el más grande no es la raíz
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursivamente heapify el subárbol afectado
            heapify(arr, n, largest);
        }
    }
}

