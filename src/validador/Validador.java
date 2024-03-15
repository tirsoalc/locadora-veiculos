package validador;

public class Validador {
    public static boolean nomeValido(String nome) {
        return nome != null && !nome.isEmpty();
    }

    public static boolean cpfValido(String cpf) {
        return cpf != null && cpf.matches("^\\d{4}$");
    }

    public static boolean cnpjValido(String cnpj) {
        return cnpj != null && cnpj.matches("^\\d{4}/\\d$");
    }

    public static boolean placaValida(String placa) {
        return placa != null && placa.matches("^[A-Z]{3}[0-9][0-9A-Z][0-9]{2}$");
    }

    public static boolean alcanceOpcaoPermitida(int limiteBaixoIncluso, int limiteAltoIncluso, int numero) {
        return numero >= limiteBaixoIncluso && numero <= limiteAltoIncluso;
    }
}
