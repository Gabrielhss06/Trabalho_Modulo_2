package repository;

import model.Cena;
import model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CenaDAO {

    public static Cena findCenaById(Integer id) throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "SELECT * FROM cenas WHERE id_cena = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Cena cena = null;

        if (rs.next()) {
            int idCena = rs.getInt("id_cena");
            String descricao = rs.getString("descricao");
            int idCenaSeguinte = rs.getInt("id_cena_seguinte");

            // Buscar os itens da cena
            List<Item> itensCena = findItensByCenaId(idCena);

            // Criar a cena com a cena seguinte ainda não carregada
            cena = new Cena(idCena, descricao, itensCena, null);

            // Carregar a próxima cena, se houver
            if (idCenaSeguinte != 0) {
                Cena cenaSeguinte = findCenaById(idCenaSeguinte);
                cena.setCenaSeguinte(cenaSeguinte);
            }
        }

        // Fechar a conexão fora do bloco if
        conn.close();
        return cena;
    }

    public static List<Item> findItensByCenaId(Integer idCena) throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "SELECT * FROM objetos WHERE id_cena = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idCena);  // Certifique-se de que o idCena está correto
        ResultSet rs = stmt.executeQuery();

        List<Item> itens = new ArrayList<>();

        while (rs.next()) {
            String nome = rs.getString("nome");
            String descricao = rs.getString("descricao");
            Item item = new Item(nome, descricao);
            itens.add(item);
        }

        conn.close();  // Fechar a conexão corretamente
        return itens;
    }
}
