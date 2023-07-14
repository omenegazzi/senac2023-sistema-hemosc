/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.conexaoMysql;
import Model.cidades;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author murilo.comim
 */
public class CidadesDAO {

    private List<cidades> cidadesList = new ArrayList();
    private String ListSQL = "SELECT * from cidades";
    
    private List<cidades> getCidadesList() {
        return cidadesList;
    }

    private void setListSQL(String ListSQL) {
        this.ListSQL = ListSQL;
    }
    
    public List<cidades> listar(){
        setListSQL("SELECT * from cidades");
        gerarLista();
        
        return getCidadesList();
    }
    
    public List<cidades> pesquisar(String Campo,String Valor){
        setListSQL("SELECT * from cidades where "+Campo+" = "+Valor);
        gerarLista();
        
        return getCidadesList();
    }
    
    private void gerarLista() {

        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        getCidadesList().clear();
        try {
            stmt = conn.prepareStatement(ListSQL);
            rs = stmt.executeQuery();

            while (rs.next()) {
                cidades c = new cidades();
                c.setId(rs.getInt("id_cidade"));
                c.setCodigoIbge(rs.getInt("codigo_ibge"));
                c.setDescricao(rs.getString("descricao"));
                c.setUf(rs.getString("uf"));

                getCidadesList().add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CidadesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Excluir(cidades a) {

        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("DELETE from cidades WHERE cidadesList = ?");
            stmt.setInt(1, a.getId());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CidadesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void alterar(cidades a) {

        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("UPDATE autores set descricao = ?, uf = ?, codigo_ibge = ? WHERE id_cidade = ? ");
            stmt.setString(1, a.getDescricao());
            stmt.setString(2, a.getUf());
            stmt.setInt(3, a.getCodigoIbge());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cidade Alterado com Sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(CidadesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvar(cidades a) {

        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO cidades (codigo_ibge, descricao, uf) VALUES (?,?,?)");
            stmt.setInt(1, a.getCodigoIbge());
            stmt.setString(2, a.getDescricao());
            stmt.setString(3, a.getUf());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cidade Salva com Sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(CidadesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
