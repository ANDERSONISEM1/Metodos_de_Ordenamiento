package metodosordenamiento;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Menú de opciones
        System.out.println("Digite la opción a comprobar:\n"
                + "1.Selection sort (selección)\n"
                + "2.Bubble sort (burbuja)\n"
                + "3.Insertion sort (inserción)\n"
                + "4.Merge sort (combinación)\n"
                + "5.Quick sort (rápida)\n"
                + "6.Heap sort (montón)\n"
                + "7.Counting sort (conteo)\n"
                + "8.Radix sort (raíz)\n"
                + "9.Bucket sort (cubo)\n");

        System.out.println("Ingrese su opción");

        int opciones = 0;
        opciones = entrada.nextInt();
        switch (opciones) {
            case 1:
                System.out.println("1.Selection sort (selección)");
                Seleccion.main(args);
                break;
            case 2:
                System.out.println("2.Bubble sort (burbuja)");
                Burbuja.main(args);
                break;
            case 3:
                System.out.println("3.Insertion sort (inserción)\n");
                Insercion.main(args);
                break;
            case 4:
                System.out.println("4.Merge sort (combinación)\n");
                Combinacion.main(args);
                break;
            case 5:
                System.out.println("5.Quick sort (rápida)\n");
                Rapida.main(args);
                break;
            case 6:
                System.out.println("6.Heap sort (montón)\n");
                Monton.main(args);
                break;
            case 7:
                System.out.println("7.Counting sort (conteo)\n");
                Conteo.main(args);
                break;
            case 8:
                System.out.println("8.Radix sort (raíz)\n");
                Raiz.main(args);
                break;
            case 9:
                System.out.println("9.Bucket sort (cubo)\n");
                Cubo.main(args);
                break;
            default:
                System.out.println("Salir");
                break;

        }

    }
}
