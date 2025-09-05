//Alejandro Garcia Pelayo Banda 04/09/2025

// Recursion.java
public class Recursion {

    public Recursion() {
    }

    /**
     * Calcula el factorial de un número usando recursividad
     * Caso base: factorial(0) = 1
     * @param n Número para calcular factorial (debe ser no negativo)
     * @return El factorial de n
     */
    public static int factorial(int n) {
        return n == 0 ? 1 : n * factorial(n - 1); // RECURSIVIDAD
    }

    /**
     * Calcula el n-ésimo número de Fibonacci usando recursividad
     * Caso base: fibonacci(0)=0, fibonacci(1)=1
     * @param n Posición en la secuencia de Fibonacci
     * @return El n-ésimo número de Fibonacci
     */
    public static int fibonacci(int n) {
        return n <= 1 ? n : fibonacci(n - 1) + fibonacci(n - 2); // RECURSIVIDAD
    }

    /**
     * Suma los dígitos de un número usando recursividad
     * Caso base: sumaDigitos(0)=0
     * @param n Número cuyos dígitos se sumarán
     * @return La suma de los dígitos de n
     */
    public static int sumaDigitos(int n) {
        return n == 0 ? 0 : n % 10 + sumaDigitos(n / 10); // RECURSIVIDAD
    }

    /**
     * Invierte un string usando recursividad
     * Caso base: string vacío
     * @param str String a invertir
     * @return String invertido
     */
    public static String invertirString(String str) {
        if (str.isEmpty()) {
            return str;
        } else {
            String var10000 = invertirString(str.substring(1)); // RECURSIVIDAD
            return var10000 + str.charAt(0);
        }
    }

    /**
     * Cuenta las vocales en un string usando recursividad
     * Caso base: string vacío
     * @param str String en el que contar vocales
     * @return Cantidad de vocales en el string
     */
    public static int contarVocales(String str) {
        if (str.isEmpty()) {
            return 0;
        }

        char c = Character.toLowerCase(str.charAt(0));
        int suma = (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ? 1 : 0;

        return suma + contarVocales(str.substring(1)); // RECURSIVIDAD
    }
}
