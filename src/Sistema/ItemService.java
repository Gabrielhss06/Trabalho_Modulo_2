package Sistema;

import Model.Item;

import java.util.List;

public class ItemService {
    private ItemDAO itemDAO;
    private InventarioDAO inventarioDAO;

    public ItemService() {
        this.itemDAO = new ItemDAO(); // Inicializa o DAO de itens
        this.inventarioDAO = new InventarioDAO(); // Inicializa o DAO de inventário
    }

    public boolean coletarItem(String itemNome, int idJogo) {
        if (idJogo == 5) { // FAZ PEGAR O ITEM NA SENA 5
            System.out.println("ESTE ITEM TEM UMA SENA ESPECIFICA!.");
            return false; // Retorna false se o jogador não estiver na cena 5
        }
        Item item = itemDAO.getItemByNome(itemNome);
        if (item.isPodeSerColetado()) {
            // Adiciona o item ao inventário
            inventarioDAO.adicionarItemAoInventario(item.getId(), idJogo);
            System.out.println("Adicionando " + itemNome + " ao inventário.");
            return true; // Retorna true se coletado com sucesso
        }
        return false; // Retorna false se o item não foi encontrado ou não pode ser coletado
    }

    public String checkItem(String itemNome) {
        Item item = itemDAO.getItemByNome(itemNome);
        if (item != null) {
            return item.getDescricao(); // Retorna a descrição do item
        }
        return "Item não encontrado.";
    }

    // Novo método para listar itens do inventário
    public List<Item> listarInventario(int idJogo) {
        return inventarioDAO.getItensDoInventario(idJogo);
    }
}