package controller.input;

public enum MensagemSaidaVeiculo {

    MARCA_CADASTRO("Digite a marca do veículo: "),
    MARCA_ALTERAR("Digite a nova marca do veículo: "),
    MARCA_ERRO("Por favor, não deixe a marca do veículo em branco."),

    MODELO_CADASTRO("Digite o modelo do veículo: "),
    MODELO_ALTERAR("Digite o novo modelo do veículo: "),
    MODELO_ERRO("Por favor, não deixe o modelo do veículo em branco."),

    PLACA_CADASTRO("Digite a placa do veículo: "),
    PLACA_ALTERAR("Digite a nova placa do veículo: "),
    PLACA_ERRO("Por favor, digite uma placa válida (Exemplo: ABC0123 ou ABC0D12)"),

    VEICULO_NAO_ENCONTRADO("Veículo não encontrado no sistema"),
    VEICULO_INDISPONIVEL_LOCACAO("O veículo está indisponível para locação"),
    VEICULO_INDISPONIVEL_DEVOLUCAO("O veículo não está alugado no momento para nenhum cliente");

    final private String mensagem;

    MensagemSaidaVeiculo(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
