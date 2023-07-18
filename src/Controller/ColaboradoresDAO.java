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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ColaboradoresDAO {

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

    public List<Colaboradores> listar() {

        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Colaboradores> Colaboradores = new ArrayList();

        try {
            stmt = conn.prepareStatement("SELECT * from colaboradores");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Colaboradores col = new Colaboradores();
                col.setId(rs.getInt("id_colaboradores"));
                col.setIdCidade(rs.getInt("cidades"));
                col.setEndereco(rs.getString("endereco"));
                col.setFuncao(rs.getString("funcao"));

                Colaboradores.add(col);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ColaboradoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Colaboradores;
    }

    public void excluir(Colaboradores a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
