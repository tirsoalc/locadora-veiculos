package controller.input;

public enum MensagemSaidaErros {
    OPCAO_INVALIDA("\nOpção inválida selecionada. Pressione enter para continuar.");

    private String mensagem;

    MensagemSaidaErros(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
