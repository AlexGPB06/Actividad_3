//Alejandro Garcia Pelayo Banda 04/09/2025
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENÚ PRINCIPAL DE FUNCIONES RECURSIVAS ===");
            System.out.println("1. Calcular número de Fibonacci");
            System.out.println("2. Suma de subconjuntos (Subset Sum)");
            System.out.println("3. Problema Sudoku");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción  ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Fibonacci.mostrarMenu();
                    break;
                case 2:
                    Subsetsum.menu();
                    break;
                case 3:
                    Sudoku juego = new Sudoku();
                    juego.menu();
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