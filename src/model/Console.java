package model;

public class Console {
    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void exibirMensagem() {
        System.out.println(mensagem);
    }
}

