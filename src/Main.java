//Alejandro Garcia Pelayo Banda 04/09/2025
import java.util.Scanner;

import java.util.Scanner;

public class Main {

    /**
     * Método principal del programa.
     * Muestra un menú con las opciones:
     *  1. Calcular Fibonacci (usa recursividad en Recursion.fibonacci).
     *  2. Resolver Subset Sum (usa recursividad y backtracking).
     *  3. Resolver Sudoku (usa backtracking).
     *  0. Salir.
     *
     * No recibe parámetros.
     * No retorna valor (void).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENÚ PRINCIPAL DE FUNCIONES RECURSIVAS ===");
            System.out.println("1. Calcular número de Fibonacci");
            System.out.println("2. Suma de subconjuntos (Subset Sum)");
            System.out.println("3. Problema Sudoku");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Fibonacci.mostrarMenu(); // Usa recursividad
                    break;
                case 2:
                    Subsetsum.menu(); // Usa recursividad + backtracking
                    break;
                case 3:
                    Sudoku juego = new Sudoku();
                    juego.menu(); // Usa backtracking
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}
