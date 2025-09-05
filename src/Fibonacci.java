//Alejandro Garcia Pelayo Banda 04/09/2025
import java.util.Scanner;

public class Fibonacci {

    /**
     * Muestra un menú para calcular el número de Fibonacci en la posición "n".
     * - Solicita al usuario un valor entero.
     * - Llama al método recursivo {@link Recursion#fibonacci(int)} para calcular el resultado.
     * - Mide y muestra el tiempo de ejecución.
     * - Si n <= 20, también muestra la serie completa hasta "n".
     *
     * Uso de recursividad:
     *   - Se utiliza dentro del método fibonacci de la clase Recursion.
     *
     * No recibe parámetros.
     * No retorna valor (void).
     */
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
                int resultado = Recursion.fibonacci(n); // Aquí se usa recursividad
                long endTime = System.nanoTime();
                long duration = (endTime - startTime);

                System.out.println("Fibonacci(" + n + ") = " + resultado);
                System.out.println("Tiempo de ejecución: " + duration + " nanosegundos");

                // Mostrar la serie completa solo para valores pequeños de n (ej: n <= 20)
                if (n <= 20) {
                    System.out.print("Serie completa: ");
                    for (int i = 0; i <= n; i++) {
                        System.out.print(Recursion.fibonacci(i) + " "); // Recursividad en cada llamada
                    }
                    System.out.println();
                } else {
                    System.out.println("(La serie completa no se muestra para n > 20)");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: Entrada no válida. Por favor ingrese un número entero.");
            scanner.nextLine(); // Limpiar buffer
        }
    }
}
