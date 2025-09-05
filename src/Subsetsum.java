//Alejandro Garcia Pelayo Banda 04/09/2025
import java.util.Scanner;

// Subsetsum.java
import java.util.Scanner;

public class Subsetsum {

    /**
     * Clase para almacenar el resultado de la búsqueda de subconjuntos
     */
    public static class ResultadoSubconjunto {
        public boolean existe;              // Indica si existe un subconjunto que suma el objetivo
        public List<Integer> numerosSumados; // Lista de números que forman el subconjunto

        public ResultadoSubconjunto(boolean existe, List<Integer> numerosSumados) {
            this.existe = existe;
            this.numerosSumados = numerosSumados;
        }
    }

    /**
     * Método principal para encontrar subconjunto que suma target
     * @param lista Lista de números enteros
     * @param target Valor objetivo a alcanzar
     * @return ResultadoSubconjunto con existencia y números del subconjunto
     */
    public static ResultadoSubconjunto encontrarSubconjunto(List<Integer> lista, int target) {
        return encontrarSubconjuntoRecursivo(lista.getFirstNode(), target, new List<>());
    }

    /**
     * Método recursivo con BACKTRACKING para encontrar subconjunto
     * @param nodo Nodo actual de la lista
     * @param target Valor objetivo restante
     * @param numerosActuales Lista temporal de números considerados
     * @return ResultadoSubconjunto con la solución
     */
    private static ResultadoSubconjunto encontrarSubconjuntoRecursivo(Node<Integer> nodo, int target, List<Integer> numerosActuales) {
        if (target == 0) {
            return new ResultadoSubconjunto(true, copiarLista(numerosActuales)); // SOLUCIÓN ENCONTRADA
        }
        if (nodo == null) {
            return new ResultadoSubconjunto(false, new List<>()); // NO HAY SOLUCIÓN
        }

        int valorActual = nodo.data;

        if (valorActual > target) {
            return encontrarSubconjuntoRecursivo(nodo.next, target, numerosActuales); // RECURSIVIDAD - saltar elemento
        }

        // BACKTRACKING: Probar excluyendo el elemento actual
        ResultadoSubconjunto excluir = encontrarSubconjuntoRecursivo(nodo.next, target, numerosActuales);
        if (excluir.existe) {
            return excluir;
        }

        // BACKTRACKING: Probar incluyendo el elemento actual
        List<Integer> nuevosNumeros = copiarLista(numerosActuales);
        nuevosNumeros.insertAtFirstPosition(valorActual);
        ResultadoSubconjunto incluir = encontrarSubconjuntoRecursivo(nodo.next, target - valorActual, nuevosNumeros);

        if (incluir.existe) {
            return incluir;
        }

        return new ResultadoSubconjunto(false, new List<>()); // BACKTRACKING - retroceder
    }

    /**
     * Crea una copia profunda de una lista
     * @param original Lista original a copiar
     * @return Nueva lista con los mismos elementos
     */
    public static List<Integer> copiarLista(List<Integer> original) {
        List<Integer> copia = new List<>();
        if (original.getFirstNode() == null) return copia;

        List<Integer> temp = new List<>();
        Node<Integer> current = original.getFirstNode();
        while (current != null) {
            temp.insertAtFirstPosition(current.data);
            current = current.next;
        }

        current = temp.getFirstNode();
        while (current != null) {
            copia.insertAtFirstPosition(current.data);
            current = current.next;
        }

        return copia;
    }

    /**
     * Convierte una lista a string con formato [element1, element2, ...]
     * @param lista Lista a convertir
     * @return String representando la lista
     */
    public static String listToString(List<Integer> lista) {
        StringBuilder sb = new StringBuilder("[");
        Node<Integer> current = lista.getFirstNode();
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Muestra la operación de suma del subconjunto
     * @param numeros Lista de números a sumar
     * @return String con la operación matemática
     */
    public static String mostrarOperacion(List<Integer> numeros) {
        if (numeros.getFirstNode() == null) {
            return "0 (subconjunto vacío)";
        }

        StringBuilder sb = new StringBuilder();
        Node<Integer> current = numeros.getFirstNode();
        int suma = 0;

        while (current != null) {
            sb.append(current.data);
            suma += current.data;
            if (current.next != null) {
                sb.append(" + ");
            }
            current = current.next;
        }

        sb.append(" = ").append(suma);
        return sb.toString();
    }

    /**
     * Permite ingresar números manualmente por consola
     * @return Lista con los números ingresados
     */
    public static List<Integer> ingresarNumerosManual() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> lista = new List<>();

        System.out.println("\n--- INGRESO MANUAL DE NÚMEROS ---");
        System.out.println("Ingrese los números uno por uno (ingrese 'fin' para terminar):");

        int contador = 1;
        while (true) {
            System.out.print("Número " + contador + ": ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("fin")) {
                break;
            }

            try {
                int numero = Integer.parseInt(input);
                lista.insertAtFirstPosition(numero);
                contador++;

                System.out.println("Lista actual: " + listToString(lista));

            } catch (NumberFormatException e) {
                System.out.println("Error: '" + input + "' no es un número válido. Intente nuevamente.");
            }
        }

        return lista;
    }

    /**
     * Permite modificar una lista existente
     * @param listaExistente Lista a modificar
     * @return Lista modificada
     */
    public static List<Integer> modificarLista(List<Integer> listaExistente) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nuevaLista = copiarLista(listaExistente);

        System.out.println("\nLista actual: " + listToString(nuevaLista));

        while (true) {
            System.out.println("\nOpciones:");
            System.out.println("1. Agregar número");
            System.out.println("2. Eliminar último número");
            System.out.println("3. Vaciar lista");
            System.out.println("4. Terminar edición");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese número a agregar: ");
                    try {
                        int numero = scanner.nextInt();
                        nuevaLista.insertAtFirstPosition(numero);
                        System.out.println("Nueva lista: " + listToString(nuevaLista));
                    } catch (Exception e) {
                        System.out.println("Número inválido.");
                    }
                    break;

                case 2:
                    if (nuevaLista.getFirstNode() != null) {
                        List<Integer> temp = new List<>();
                        Node<Integer> current = nuevaLista.getFirstNode();

                        if (current.next != null) {
                            current = current.next;
                            while (current != null) {
                                temp.insertAtFirstPosition(current.data);
                                current = current.next;
                            }
                        }
                        nuevaLista = temp;
                        System.out.println("Último número eliminado. Nueva lista: " + listToString(nuevaLista));
                    } else {
                        System.out.println("La lista ya está vacía.");
                    }
                    break;

                case 3:
                    nuevaLista = new List<>();
                    System.out.println("Lista vaciada.");
                    break;

                case 4:
                    return nuevaLista;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    /**
     * Menú principal del programa Subset Sum
     */
    public static void menu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== SUMA DE SUBCONJUNTOS (SUBSET SUM) ===");
        System.out.println("Encuentra los números exactos que suman el objetivo");

        List<Integer> lista;
        int objetivo;

        System.out.println("1. Ingresar números manualmente");
        System.out.println("2. Crear lista vacía y luego editarla");
        System.out.print("Seleccione una opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        if (opcion == 1) {
            lista = ingresarNumerosManual();
            System.out.print("Ingrese el valor objetivo: ");
            objetivo = scanner.nextInt();

        } else {
            lista = new List<>();
            lista = modificarLista(lista);
            System.out.print("Ingrese el valor objetivo: ");
            objetivo = scanner.nextInt();
        }

        System.out.println("\nLista final: " + listToString(lista));
        System.out.println("Objetivo: " + objetivo);
        System.out.print("¿Es correcto? (s/n): ");
        String confirmacion = scanner.next();

        if (!confirmacion.equalsIgnoreCase("s")) {
            System.out.println("Operación cancelada. Volviendo al menú...");
            return;
        }

        long startTime = System.nanoTime();
        ResultadoSubconjunto resultado = encontrarSubconjunto(lista, objetivo); // BACKTRACKING + RECURSIVIDAD
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("\n=== RESULTADO ===");
        System.out.println("Lista: " + listToString(lista));
        System.out.println("Objetivo: " + objetivo);

        if (resultado.existe) {
            System.out.println("✓ SI existe un subconjunto que suma " + objetivo);
            System.out.println("Números sumados: " + listToString(resultado.numerosSumados));
            System.out.println("Operación: " + mostrarOperacion(resultado.numerosSumados));
        } else {
            System.out.println("✗ NO existe un subconjunto que suma " + objetivo);
        }

        System.out.println("Tiempo de ejecución: " + duration + " ns");
        System.out.println("Tiempo de ejecución: " + (duration / 1_000_000.0) + " ms");
    }
}