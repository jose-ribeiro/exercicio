package org.example;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.print("Informe um número: ");
            int numero = scanner.nextInt();

            if (fibonacci(numero)) {
                System.out.println("O número " + numero + " pertence à sequência de Fibonacci.");
            } else {
                System.out.println("O número " + numero + " não pertence à sequência de Fibonacci.");
            }

            System.out.print("Deseja testar outro número? (s/n): ");
            String resposta = scanner.next();

            if (!resposta.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }

        System.out.println("Programa encerrado.");
        scanner.close();
    }

    public static boolean fibonacci(int numero) {
        if (numero == 0 || numero == 1) {
            return true;
        }

        int a = 0, b = 1;
        while (b < numero) {
            int temp = b;
            b = a + b;
            a = temp;
        }

        return b == numero;
    }
}