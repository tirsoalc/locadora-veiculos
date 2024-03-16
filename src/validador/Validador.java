package validador;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Validador {
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

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

    public static boolean dataValida(String data) {
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(data.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }
}