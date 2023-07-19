/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.conexaoMysql;
import Model.Colaboradores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ColaboradoresDAO {


    public List<Colaboradores> listar() {

        Connection conn = conexaoMysql.conexao();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        List<Colaboradores> Colaboradores = new ArrayList();

        try {

            stmt = conn.prepareStatement("SELECT * from Colaborador");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Colaboradores a = new Colaboradores();

                a.setId(rs.getInt("id_Colaborador"));

                a.setNome(rs.getString("Nome"));

                a.setEndereco(rs.getString("Endereco"));

                a.setFuncao(rs.getString("funcao"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ColaboradoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Colaboradores;
    }

    public void salvar(Colaboradores col) {
        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO colaboradores (nome, enderece, cidade, funcao) (?,?,?,?)");
            stmt.setString(1, col.getNome());
            stmt.setString(2, col.getEndereco());
            stmt.setInt(3, col.getIdCidade());
            stmt.setString(4, col.getFuncao());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Entidade Salva com Sucesso!");
        
        } catch (SQLException ex) {
            Logger.getLogger(ColaboradoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
