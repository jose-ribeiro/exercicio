package org.example;

import java.util.Scanner;

public class Exercicio5  {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe uma string: ");
        String original = scanner.nextLine();

        String invertida = inverterString(original);
        System.out.println("String invertida: " + invertida);

        scanner.close();
    }

    public static String inverterString(String s) {
        String invertida = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            invertida += s.charAt(i);
        }
        return invertida;
    }
}
