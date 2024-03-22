package metodosordenamiento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Cubo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de números a ordenar: ");
        int n = scanner.nextInt();

        // Crear un ArrayList para almacenar los números ingresados por el usuario
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el número " + (i + 1) + ": ");
            array.add(scanner.nextInt());
        }

        // Llamar al método bucketSort para ordenar los números
        bucketSort(array);

        // Imprimir los números ordenados
        System.out.println("Números ordenados:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Implementación del algoritmo de ordenamiento Bucket Sort
    public static void bucketSort(ArrayList<Integer> array) {
        if (array == null || array.size() <= 1) {
            return; // No es necesario ordenar un array vacío o con un solo elemento
        }

        // Encontrar el valor máximo y mínimo en el array
        int maxVal = Collections.max(array);
        int minVal = Collections.min(array);

        // Calcular el número de baldes (buckets) necesarios
        int bucketCount = (maxVal - minVal) / array.size() + 1;

        // Crear una lista de buckets (ArrayList de ArrayLists)
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        // Distribuir los números en los buckets correspondientes
        for (int num : array) {
            int bucketIndex = (num - minVal) / array.size();
            buckets.get(bucketIndex).add(num);
        }

        // Ordenar cada bucket y reconstruir el array original
        array.clear();
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
            array.addAll(bucket);
        }
    }
}
