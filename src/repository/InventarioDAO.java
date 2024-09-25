package repository;

import model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventarioDAO {

    public static List<Item> getInventarioBySaveId(Integer idSave) throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "SELECT * FROM inventario WHERE id_save = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idSave);
        ResultSet rs = stmt.executeQuery();
        List<Item> inventario = new ArrayList<>();

        while (rs.next()) {
            String nomeItem = rs.getString("nome_item");
            String descricaoItem = rs.getString("descricao_item");
            Item item = new Item(nomeItem, descricaoItem);
            inventario.add(item);
        }

        conn.close();
        return inventario;
    }

    public static void adicionarItemAoInventario(Item item, Integer idSave) throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "INSERT INTO inventario (nome_item, descricao_item, id_save) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, item.getNome());
        stmt.setString(2, item.getDescricao());
        stmt.setInt(3, idSave);
        stmt.executeUpdate();
        conn.close();

    }


    public static void removerItemDoInventario(String nomeItem, Integer idSave) throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "DELETE FROM inventario WHERE nome_item = ? AND id_save = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nomeItem);
        stmt.setInt(2, idSave);
        stmt.executeUpdate();
        conn.close();
    }
}


