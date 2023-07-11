/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.conexaoMysql;
import Model.TiposSanguineos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author guest01
 */
public class TiposSanguineosDAO {
            public void alterar(TiposSanguineos ts) {

        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("UPDATE autores set descricao = ?, fator_rh = ?, estoque = ? WHERE id_tipo_sanguineo = ? ");
            stmt.setString(1, ts.getDescricao());
            stmt.setString(2, ts.getFator_rh());
            stmt.setInt(3, ts.getEstoque());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Tipo Sanguineo Alterado com Sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(TiposSanguineosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

