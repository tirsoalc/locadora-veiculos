package controller.input;

public enum MensagemErros {
    OPCAO_INVALIDA("\nOpção inválida selecionada. Pressione enter para continuar.");

    private String mensagem;

    MensagemErros(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
