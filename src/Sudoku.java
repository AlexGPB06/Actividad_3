import java.util.Random;
import java.util.Scanner;

public class Sudoku {
    private int[][] board;
    private static final int SIZE = 9;
    private static final int EMPTY = 0;
    private Random rand = new Random();

    public Sudoku() {
        board = new int[SIZE][SIZE];
    }

    // Genera un tablero válido y lo "vacia" parcialmente
    public void generateBoard(int holes) {
        solveSudoku(); // genera un tablero completo
        for (int i = 0; i < holes; i++) {
            int row = rand.nextInt(SIZE);
            int col = rand.nextInt(SIZE);
            board[row][col] = EMPTY;
        }
    }

    // Verifica si es seguro poner un número
    private boolean isSafe(int row, int col, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num) return false;
        }
        int startRow = row - row % 3, startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == num) return false;
            }
        }
        return true;
    }

    // Algoritmo de backtracking
    public boolean solveSudoku() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == EMPTY) {
                    for (int num = 1; num <= SIZE; num++) {
                        if (isSafe(row, col, num)) {
                            board[row][col] = num;
                            if (solveSudoku()) return true;
                            board[row][col] = EMPTY;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    // Mostrar tablero bonito
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

    // Jugar manualmente
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

    // Verifica si está resuelto
    private boolean isSolved() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) return false;
            }
        }
        return true;
    }

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

