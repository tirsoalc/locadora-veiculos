package view.utils;

import controller.input.MensagemSaidaErros;
import view.Menus;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ClienteUtil {
    public static int getTipoCliente(Scanner scanner) {
        int opcaoTipo = 0;
        do {
            Menus.showClienteTipoMenu();
            System.out.print("Selecione uma opção: ");

            try {
                opcaoTipo = scanner.nextInt();
                scanner.nextLine();

                if (opcaoTipo != 1 && opcaoTipo != 2) {
                    System.out.print(MensagemSaidaErros.OPCAO_INVALIDA.getMensagem());
                    scanner.nextLine();
                }

            } catch (InputMismatchException e) {
                System.out.println(MensagemSaidaErros.OPCAO_INVALIDA.getMensagem());
                scanner.nextLine();
            }

        } while (opcaoTipo != 1 && opcaoTipo != 2);
        return opcaoTipo;
    }
}
