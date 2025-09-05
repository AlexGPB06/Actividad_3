//Alejandro Garcia Pelayo Banda 04/09/2025
import java.util.Scanner;

public class Fibonacci {


     // Método para mostrar el menú de Fibonacci y procesar la entrada del usuario
     // Utiliza el método fibonacci de la clase Recursion
    public static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== MENÚ FIBONACCI ===");
        System.out.print("Ingrese el valor de n para Fibonacci: ");

        try {
            int n = scanner.nextInt();

            if (n < 0) {
                System.out.println("Por favor, ingrese un número no negativo.");
            } else {
                long startTime = System.nanoTime();
                int resultado = Recursion.fibonacci(n);
                long endTime = System.nanoTime();
                long duration = (endTime - startTime);

                System.out.println("Fibonacci(" + n + ") = " + resultado);
                System.out.println("Tiempo de ejecución: " + duration + " nanosegundos");

                // Mostrar la serie completa hasta n
                    System.out.print("Serie completa: ");
                    for (int i = 0; i <= n; i++) {
                        System.out.print(Recursion.fibonacci(i) + " ");
                    }
                    System.out.println();

            }
        } catch (Exception e) {
            System.out.println("Error: Entrada no válida. Por favor ingrese un número entero.");
            scanner.nextLine(); // Limpiar buffer
        }
    }
}