package Controller;

import Connection.conexaoMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.ResultSet;

public class DoacoesDAO {

    public void Excluir(Doacoes a) {

        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("DELETE from Doacoes WHERE DoacoesList = ?");
            stmt.setInt(1, a.getId());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DoacoesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
