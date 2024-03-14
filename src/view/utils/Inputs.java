package view.utils;

import java.util.Scanner;

public class Inputs {
    public static String inputHelper(String textoOutput, Scanner scanner) {
        String dado;
        System.out.print("\n" + textoOutput);
        dado = scanner.nextLine();
        return dado;
    }
}
