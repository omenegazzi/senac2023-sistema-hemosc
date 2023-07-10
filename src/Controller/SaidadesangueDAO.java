
package Controller;

import Connection.conexaoMysql;
import Model.saidassangue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaidadesangueDAO {
    
    private List<saidassangue> saidadesangueList = new ArrayList();

    public List<saidassangue> getSaidasangueList() {
        return saidadesangueList;
    }
    
    public List<saidassangue> listar() {
        
        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        getSaidasangueList().clear();
        try {
            stmt = conn.prepareStatement("SELECT * from saida_sangue");
            rs = stmt.executeQuery();

            while (rs.next()) {
                saidassangue c = new saidassangue();
                c.setId(rs.getInt("id_saida_sangue"));
                c.setData(rs.getInt("data"));
                c.setQuantidade(rs.getString("quantidade"));
                c.setTipodesangue(rs.getString("id_tipo_sanguineo"));
                c.setEntidade(rs.getString("id_entidade"));
                
                getSaidasangueList().add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CidadesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return getSaidasangueList();
    }
}