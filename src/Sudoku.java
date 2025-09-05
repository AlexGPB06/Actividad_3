//Alejandro Garcia Pelayo Banda 04/09/2025
import java.util.Random;
import java.util.Scanner;

import java.util.Random;
import java.util.Scanner;

public class Sudoku {
    private int[][] board; // Matriz que representa el tablero de Sudoku
    private static final int SIZE = 9; // Tamaño del tablero (9x9)
    private static final int EMPTY = 0; // Valor que representa una celda vacía
    private Random rand = new Random(); // Generador de números aleatorios

    /**
     * Constructor de la clase Sudoku.
     * Inicializa el tablero como una matriz 9x9 vacía.
     */
    public Sudoku() {
        board = new int[SIZE][SIZE];
    }

    /**
     * Genera un tablero válido de Sudoku y luego vacía parcialmente algunas celdas.
     * @param holes - Número de celdas a vaciar (hacer agujeros) en el tablero
     */
    public void generateBoard(int holes) {
        solveSudoku(); // genera un tablero completo resolviéndolo
        for (int i = 0; i < holes; i++) {
            int row = rand.nextInt(SIZE);
            int col = rand.nextInt(SIZE);
            board[row][col] = EMPTY;
        }
    }

    /**
     * Verifica si es seguro colocar un número en una posición específica.
     * @param row - Fila donde se quiere colocar el número (0-8)
     * @param col - Columna donde se quiere colocar el número (0-8)
     * @param num - Número que se quiere colocar (1-9)
     * @return true si es seguro colocar el número, false si no lo es
     */
    private boolean isSafe(int row, int col, int num) {
        // Verifica la fila y columna
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num) return false;
        }
        // Verifica el cuadrante 3x3
        int startRow = row - row % 3, startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == num) return false;
            }
        }
        return true;
    }

    /**
     * Resuelve el Sudoku utilizando backtracking con recursividad.
     * Se utiliza recursividad para probar diferentes combinaciones de números.
     * Se aplica backtracking cuando una elección lleva a un callejón sin salida.
     * @return true si se encontró una solución, false si no hay solución
     */
    public boolean solveSudoku() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == EMPTY) {
                    int[] nums = generateRandomNumbers(); // <- orden aleatorio
                    for (int num : nums) {
                        if (isSafe(row, col, num)) {
                            board[row][col] = num; // Asigna el número
                            if (solveSudoku()) return true; // RECURSIVIDAD: llama a sí mismo
                            board[row][col] = EMPTY; // BACKTRACKING: deshace la elección si no lleva a solución
                        }
                    }
                    return false; // BACKTRACKING: ninguna opción funcionó
                }
            }
        }
        return true; // Tablero completado exitosamente
    }

    /**
     * Genera un array con los números del 1 al 9 en orden aleatorio.
     * @return Array de enteros con números del 1-9 en orden aleatorio
     */
    private int[] generateRandomNumbers() {
        int[] nums = new int[SIZE];
        for (int i = 0; i < SIZE; i++) nums[i] = i + 1;

        // Mezclamos con Fisher-Yates
        for (int i = SIZE - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

    /**
     * Muestra el tablero de Sudoku con formato visual atractivo.
     * Incluye bordes y separadores para los cuadrantes 3x3.
     */
    public void printBoard() {
        System.out.println("╔═════════════════════════════════╗");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("║ ");
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    System.out.print(". ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
                if ((j + 1) % 3 == 0) System.out.print("║ ");
            }
            System.out.println();
            if ((i + 1) % 3 == 0 && i < SIZE - 1) {
                System.out.println("╠═════════════════════════════════╣");
            }
        }
        System.out.println("╚═════════════════════════════════╝");
    }

    /**
     * Permite al usuario jugar Sudoku manualmente.
     * Solicita movimientos por consola hasta que el tablero esté completo.
     */
    public void play() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            printBoard();
            System.out.print("Introduce fila (1-9, 0 para salir): ");
            int row = sc.nextInt();
            if (row == 0) break;
            System.out.print("Introduce columna (1-9): ");
            int col = sc.nextInt();
            System.out.print("Introduce número (1-9): ");
            int num = sc.nextInt();

            if (board[row - 1][col - 1] == EMPTY && isSafe(row - 1, col - 1, num)) {
                board[row - 1][col - 1] = num;
                if (isSolved()) {
                    printBoard();
                    System.out.println("¡Felicidades! Has completado el Sudoku.");
                    break;
                }
            } else {
                System.out.println("Movimiento inválido, intenta de nuevo.");
            }
        }
    }

    /**
     * Verifica si el tablero está completamente resuelto.
     * @return true si no hay celdas vacías, false si hay al menos una celda vacía
     */
    private boolean isSolved() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) return false;
            }
        }
        return true;
    }

    /**
     * Muestra el menú principal del juego con opciones para el usuario.
     * Permite elegir entre resolver automáticamente o jugar manualmente.
     */
    public void menu() {
        Scanner sc = new Scanner(System.in);
        Sudoku sudoku;

        System.out.println("╔════════════════════════════╗");
        System.out.println("║        ✦ SUDOKU ✦          ║");
        System.out.println("╚════════════════════════════╝");

        while (true) {
            System.out.println("\n1. Resolver Sudoku automáticamente");
            System.out.println("2. Jugar Sudoku manualmente");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            int opcion = sc.nextInt();

            if (opcion == 0) break;

            switch (opcion) {
                case 1:
                    sudoku = new Sudoku();
                    sudoku.generateBoard(40);
                    System.out.println("\n--- TABLERO INICIAL ---");
                    sudoku.printBoard();
                    sudoku.solveSudoku();
                    System.out.println("\n--- TABLERO RESUELTO ---");
                    sudoku.printBoard();
                    break;

                case 2:
                    sudoku = new Sudoku();
                    sudoku.generateBoard(50);
                    sudoku.play();
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}

