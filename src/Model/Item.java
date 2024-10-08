package Model;

public class Item {
    private int id_Item;
    private String nome;
    private String descricao;
    private boolean podeSerColetado;
    private int idCena;

    // Getters e Setters
    public int getId() { return id_Item; }
    public void setId(int id) { this.id_Item = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public boolean isPodeSerColetado() { return podeSerColetado; }
    public void setPodeSerColetado(boolean podeSerColetado) { this.podeSerColetado = podeSerColetado; }

    public int getIdCena() { return idCena; }
    public void setIdCena(int idCena) { this.idCena = idCena; }
}

