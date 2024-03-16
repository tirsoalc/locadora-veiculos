package controller.input;

import validador.Validador;
import view.utils.Inputs;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class InputController {
    public static String obterNomeValidado(String mensagem, Scanner scanner) {
        String nome = Inputs.inputHelper(mensagem, scanner);
        if (!Validador.nomeValido(nome)) {
            throw new IllegalArgumentException(MensagemCadastroCliente.NOME_ERRO.getMensagem());
        }
        return nome;
    }

    public static String obterRazaoSocialValidada(String mensagem, Scanner scanner) {
        String razaoSocial = Inputs.inputHelper(mensagem, scanner);
        if (!Validador.nomeValido(razaoSocial)) {
            throw new IllegalArgumentException(MensagemCadastroCliente.RAZAOSOCIAL_ERRO.getMensagem());
        }
        return razaoSocial;
    }

    public static String obterCpfValidado(String mensagem, Scanner scanner) {
        String cpf = Inputs.inputHelper(mensagem, scanner);
        if (!Validador.cpfValido(cpf)) {
            throw new IllegalArgumentException(MensagemCadastroCliente.CPF_ERRO.getMensagem());
        }
        return cpf;
    }

    public static String obterCnpjValidado(String mensagem, Scanner scanner) {
        String cnpj = Inputs.inputHelper(mensagem, scanner);
        if (!Validador.cnpjValido(cnpj)) {
            throw new IllegalArgumentException(MensagemCadastroCliente.CNPJ_ERRO.getMensagem());
        }
        return cnpj;
    }

    public static String obterMarcaValida(String mensagem, Scanner scanner) {
        String marca = Inputs.inputHelper(mensagem, scanner);
        if (!Validador.nomeValido(marca)) {
            throw new IllegalArgumentException(MensagemCadastroVeiculo.MARCA_ERRO.getMensagem());
        }
        return marca;
    }

    public static String obterModeloValido(String mensagem, Scanner scanner) {
        String modelo = Inputs.inputHelper(mensagem, scanner);
        if (!Validador.nomeValido(modelo)) {
            throw new IllegalArgumentException(MensagemCadastroVeiculo.MODELO_ERRO.getMensagem());
        }
        return modelo;
    }

    public static String obterPlacaValida(String mensagem, Scanner scanner) {
        String placa = Inputs.inputHelper(mensagem, scanner);
        if (!Validador.placaValida(placa)) {
            throw new IllegalArgumentException(MensagemCadastroVeiculo.PLACA_ERRO.getMensagem());
        }
        return placa;
    }

    public static String obterLocalValidado(String mensagem, Scanner scanner) {
        String local = Inputs.inputHelper(mensagem, scanner);
        if (!Validador.nomeValido(local)) {
            throw new IllegalArgumentException(MensagemCadastroAluguel.LOCAL_ERRO.getMensagem());
        }
        return local;
    }

    public static Date obterDataValidada(String mensagem, Scanner scanner) throws ParseException {
        String dataStr = Inputs.inputHelper(mensagem, scanner);
        if (!Validador.dataValida(dataStr)) {
            throw new IllegalArgumentException(MensagemCadastroAluguel.DATA_ERRO.getMensagem());
        }
        Validador.dateFormat.setLenient(false);
        return Validador.dateFormat.parse(dataStr.trim());
    }
}