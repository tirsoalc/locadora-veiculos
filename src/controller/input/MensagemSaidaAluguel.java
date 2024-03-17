package controller.input;

public enum MensagemSaidaAluguel {
    DATA_ALUGUEL("Digite a data do aluguel: "),
    DATA_DEVOLUCAO("Digite a data de devolução: "),
    DATA_ERRO("Por favor, digite uma data válida (Exemplo de formato válido: dd/mm/yyyy hh:mm)"),
    DATA_DEVOLUCAO_ERRO("Por favor, digite uma data de devolução que seja após a data de locação"),

    LOCAL_CADASTRO("Digite o local do aluguel: "),
    LOCAL_ERRO("Pro favor, não deixe o local em branco"),

    CADASTRO_SUCESSO("Aluguel cadastrado com sucesso."),
    DEVOLUCAO_SUCESSO("A devolução foi realizada com sucesso."),

    DESCONTO_ERRO("Nenhum desconto foi encontrado.");

    private final String mensagem;

    MensagemSaidaAluguel(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}