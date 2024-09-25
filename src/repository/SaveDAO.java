package repository;

import model.Save;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaveDAO {

    public static Save findSaveById(Integer idSave) throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "SELECT * FROM save WHERE id_save = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idSave);
        ResultSet rs = stmt.executeQuery();

        Save save = null;
        if (rs.next()) {
            int idCenaAtual = rs.getInt("id_cena_atual");
            save = new Save(idSave, idCenaAtual);
        }

        conn.close();
        return save;
    }

    public static void novoSave(Integer idSave, Integer idCenaAtual) throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "INSERT INTO save (id_save, id_cena_atual) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idSave);
        stmt.setInt(2, idCenaAtual);
        stmt.executeUpdate();
        conn.close();
    }
}
