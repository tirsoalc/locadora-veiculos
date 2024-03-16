package controller.input;

public enum MensagemCadastroAluguel {
    DATA_ALUGUEL("Digite a data do aluguel: "),
    DATA_DEVOLUCAO("Digite a data de devolução: "),
    DATA_ERRO("Por favor, digite uma data válida (Exemplo de formato válido: dd/mm/yyyy hh:mm)"),

    LOCAL_CADASTRO("Digite o local do aluguel: "),
    LOCAL_ERRO("Pro favor, não deixe o local em branco");

    private final String mensagem;

    MensagemCadastroAluguel(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}