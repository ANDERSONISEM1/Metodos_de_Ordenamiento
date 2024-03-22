package metodosordenamiento;

import java.util.Arrays;
import java.util.Scanner;

public class Conteo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario la cantidad de números a ordenar
        System.out.print("Ingrese la cantidad de números a ordenar: ");
        int n = scanner.nextInt();

        // Crear un arreglo para almacenar los números a ordenar
        int[] arr = new int[n];
        System.out.println("Ingrese los números a ordenar:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Llamar al método countingSort para ordenar el arreglo
        countingSort(arr);

        // Mostrar el arreglo ordenado
        System.out.println("Arreglo ordenado: " + Arrays.toString(arr));
    }

    // Implementación del algoritmo de ordenamiento por conteo (counting sort)
    public static void countingSort(int[] arr) {
        // Encontrar el valor máximo y mínimo en el arreglo
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;

        // Crear arreglos auxiliares para contar y almacenar los elementos ordenados
        int[] count = new int[range];
        int[] output = new int[arr.length];

        // Contar la frecuencia de cada elemento en el arreglo original
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }

        // Calcular las posiciones finales de los elementos ordenados en el arreglo de salida
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Colocar los elementos en sus posiciones correctas en el arreglo de salida
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        // Copiar los elementos ordenados de vuelta al arreglo original
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }
}
