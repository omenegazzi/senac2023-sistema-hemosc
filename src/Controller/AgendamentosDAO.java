/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.conexaoMysql;
import Model.Agendamentos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgendamentosDAO {


    public void Excluir(Agendamentos a) {

        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("DELETE from Agendamento WHERE id_agendamento = ?");
            stmt.setInt(1, a.getId());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AgendamentosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
