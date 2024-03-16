package controller.input;

public enum MensagemSaidaErros {
    OPCAO_INVALIDA("\nOpção inválida selecionada. Pressione enter para continuar."),
    ERRO_INESPERADO("Um erro inesperado foi encontrado");

    private String mensagem;

    MensagemSaidaErros(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}