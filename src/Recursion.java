//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Recursion {
    public Recursion() {
    }

    public static int factorial(int n) {
        return n == 0 ? 1 : n * factorial(n - 1);
    }

    public static int fibonacci(int n) {
        return n <= 1 ? n : fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int sumaDigitos(int n) {
        return n == 0 ? 0 : n % 10 + sumaDigitos(n / 10);
    }

    public static String invertirString(String str) {
        if (str.isEmpty()) {
            return str;
        } else {
            String var10000 = invertirString(str.substring(1));
            return var10000 + str.charAt(0);
        }

    }

    // Caso 5: Contar vocales en un String
    public static int contarVocales(String str) {
        if (str.isEmpty()) {
            return 0;
        }

        char c = Character.toLowerCase(str.charAt(0));
        int suma = (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ? 1 : 0;

        return suma + contarVocales(str.substring(1));
    }

}
