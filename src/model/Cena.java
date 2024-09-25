package model;

import java.util.List;

public class Cena {
    private int idCena;
    private String descricao;
    private List<Item> itens;
    private Cena cenaSeguinte;

    public Cena(int idCena, String descricao, List<Item> itens, Cena cenaSeguinte) {
        this.idCena = idCena;
        this.descricao = descricao;
        this.itens = itens;
        this.cenaSeguinte = cenaSeguinte;
    }

    public int getIdCena() {
        return idCena;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Item> getItens() {
        return itens;
    }

    public Cena getCenaSeguinte() {
        return cenaSeguinte;
    }

    public void setCenaSeguinte(Cena cenaSeguinte) {
        this.cenaSeguinte = cenaSeguinte;
    }

    public void removerItem(Item item) {
        this.itens.remove(item);  // Remove o item da lista de itens da cena
    }
}
