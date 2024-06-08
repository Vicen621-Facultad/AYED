package ayed.tp1;

import java.util.Scanner;

public class ejercicio2 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ingrese un numero: ");
            int[] multiplos = obtenerMultiplos(scanner.nextInt());
            printArray(multiplos);
        }
    }

    private static void printArray(int[] array) {
        System.out.print("array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static int[] obtenerMultiplos(int n) {
        int[] multiplos = new int[n];

        for (int i = 1; i <= n; i++) {
            multiplos[i - 1] = n * i;
        }

        return multiplos;
    }
}
