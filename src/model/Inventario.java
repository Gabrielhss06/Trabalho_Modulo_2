package model;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Item> itens;

    public Inventario() {
        this.itens = new ArrayList<>();
    }

    // Método para adicionar um item ao inventário
    public void adicionarItem(Item item) {
        itens.add(item);
    }

    // Método para remover um item do inventário
    public void removerItem(Item item) {
        itens.remove(item);
    }

    // Método para verificar se o inventário contém um item específico
    public boolean contemItem(String nomeItem) {
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                return true;
            }
        }
        return false;
    }

    // Método para listar os itens no inventário
    public void mostrarInventario() {
        if (itens.isEmpty()) {
            System.out.println("O inventário está vazio.");
        } else {
            System.out.println("Itens no inventário:");
            for (Item item : itens) {
                System.out.println(item.getNome() + ": " + item.getDescricao());
            }
        }
    }

    // Método para obter a lista de itens
    public List<Item> getItens() {
        return itens;
    }

    // Método para definir a lista de itens (útil ao carregar um inventário salvo)
    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
