import java.util.Scanner;

public class Subsetsum {

    /**
     * Método recursivo para verificar si existe un subconjunto que sume 'target'
     * Utiliza el enfoque de recursión similar a la clase Recursion
     */
    public static boolean existeSubconjunto(List<Integer> lista, int target) {
        return existeSubconjuntoRecursivo(lista.getFirstNode(), target);
    }

    /**
     * Método recursivo auxiliar similar al estilo de la clase Recursion
     */
    private static boolean existeSubconjuntoRecursivo(Node<Integer> nodo, int target) {
        // Caso base: si el objetivo es 0, existe el subconjunto vacío
        if (target == 0) {
            return true;
        }

        // Caso base: si no hay más elementos
        if (nodo == null) {
            return false;
        }

        // Obtener el valor actual
        int valorActual = nodo.data;

        // Si el valor actual es mayor que el objetivo, solo podemos excluirlo
        if (valorActual > target) {
            return existeSubconjuntoRecursivo(nodo.next, target);
        }

        // Caso recursivo: probar incluyendo o excluyendo el elemento actual
        boolean incluir = existeSubconjuntoRecursivo(nodo.next, target - valorActual);
        boolean excluir = existeSubconjuntoRecursivo(nodo.next, target);

        return incluir || excluir;
    }

    /**
     * Método para convertir una cadena a lista
     */
    public static List<Integer> stringToList(String numerosStr) {
        List<Integer> lista = new List<>();
        String[] partes = numerosStr.split(" ");

        for (int i = partes.length - 1; i >= 0; i--) {
            if (!partes[i].isEmpty()) {
                try {
                    lista.insertAtFirstPosition(Integer.parseInt(partes[i]));
                } catch (NumberFormatException e) {
                    System.out.println("Advertencia: '" + partes[i] + "' no es un número válido.");
                }
            }
        }

        return lista;
    }

    /**
     * Método para mostrar una lista como string
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
     * Método para calcular la suma de dígitos usando la clase Recursion
     * (Ejemplo de cómo integrar otras funciones recursivas)
     */
    public static int sumaDigitosLista(List<Integer> lista) {
        int sumaTotal = 0;
        Node<Integer> current = lista.getFirstNode();
        while (current != null) {
            sumaTotal += Recursion.sumaDigitos(current.data);
            current = current.next;
        }
        return sumaTotal;
    }

    /**
     * Método para invertir una lista (usando recursividad similar)
     */
    public static List<Integer> invertirLista(List<Integer> lista) {
        List<Integer> resultado = new List<>();
        invertirListaRecursivo(lista.getFirstNode(), resultado);
        return resultado;
    }

    private static void invertirListaRecursivo(Node<Integer> nodo, List<Integer> resultado) {
        if (nodo == null) {
            return;
        }
        // Llamada recursiva primero
        invertirListaRecursivo(nodo.next, resultado);
        // Insertar al final (que se convierte en el principio debido a la recursión)
        resultado.insertAtFirstPosition(nodo.data);
    }

    /**
     * Método menu principal
     */
    public static void menu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== SUMA DE SUBCONJUNTOS (SUBSET SUM) ===");
        System.out.println("Usando recursividad estilo clase Recursion");

        // Solicitar números
        System.out.print("Ingrese números separados por espacios: ");
        scanner.nextLine();
        String entrada = scanner.nextLine();

        List<Integer> lista = stringToList(entrada);

        System.out.print("Ingrese el valor objetivo: ");
        int objetivo = scanner.nextInt();

        // Calcular
        long startTime = System.nanoTime();
        boolean resultado = existeSubconjunto(lista, objetivo);
        long endTime = System.nanoTime();

        System.out.println("\nLista: " + listToString(lista));
        System.out.println("Objetivo: " + objetivo);
        System.out.println("¿Existe subconjunto? " + resultado);
        System.out.println("Tiempo: " + (endTime - startTime) + " ns");

        // Demostrar otras funciones recursivas
        System.out.println("\n--- Otras operaciones recursivas ---");
        System.out.println("Suma de dígitos de todos los números: " + sumaDigitosLista(lista));
        System.out.println("Lista invertida: " + listToString(invertirLista(lista)));

        // Ejemplo con factoriales
        System.out.println("\nFactoriales de los números:");
        Node<Integer> current = lista.getFirstNode();
        while (current != null && current.data >= 0 && current.data <= 15) { // Limitar para no sobrecargar
            System.out.println("Factorial(" + current.data + ") = " + Recursion.factorial(current.data));
            current = current.next;
        }
    }

    /**
     * Método main de ejemplo
     */
    public static void main(String[] args) {
        // Ejemplo de uso
        System.out.println("Ejemplo de SubsetSum con recursividad:");

        List<Integer> lista = new List<>();
        lista.insertAtFirstPosition(2);
        lista.insertAtFirstPosition(5);
        lista.insertAtFirstPosition(12);
        lista.insertAtFirstPosition(4);
        lista.insertAtFirstPosition(34);
        lista.insertAtFirstPosition(3);

        int objetivo = 9;
        boolean resultado = existeSubconjunto(lista, objetivo);

        System.out.println("Lista: " + listToString(lista));
        System.out.println("Objetivo: " + objetivo);
        System.out.println("Subconjunto: " + listToString(resultado.subconjunto));
    }
}