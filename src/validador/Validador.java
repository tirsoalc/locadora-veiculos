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
}
