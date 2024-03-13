package factory;

import model.veiculo.TipoVeiculo;
import model.veiculo.Veiculo;

import java.util.regex.Pattern;

public class VeiculoFactory {
    public static Veiculo criarVeiculo(String marca, String modelo, String placa, TipoVeiculo tipo) {
        if (veiculoValidado(marca, modelo, placa)) {
            return new Veiculo(marca, modelo, placa, tipo);
        }
        return null;

    }

    public static boolean veiculoValidado(String marca, String modelo, String placa) {

        String regexPlaca = "[A-Z]{3}[0-9][0-9A-Z][0-9]{2}";

        if (marca.isEmpty() || modelo.isEmpty() || !Pattern.matches(regexPlaca, placa)) {
            return false;
        }
        return true;
    }
}
