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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author guest01
 */
public class TiposSanguineosDAO {

    private List<TiposSanguineos> TiposSanguineosList = new ArrayList();
    private String ListSQL = "SELECT * from tipos_sanguineos";
    
    public List<TiposSanguineos> getTiposSanguineosList() {
        return TiposSanguineosList;
    }

    private void setListSQL(String ListSQL) {
        this.ListSQL = ListSQL;
    }
    
    public List<TiposSanguineos> listar(){
        setListSQL("SELECT * from tipos_sanguineos");
        gerarLista();
        
        return getTiposSanguineosList();
    }
    
    public List<TiposSanguineos> pesquisar(String Campo,String Valor){
        setListSQL("SELECT * from tipos_sanguineos where "+Campo+" = "+Valor);
        gerarLista();
        
        return getTiposSanguineosList();
    }
    
    private void gerarLista() {

        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        getTiposSanguineosList().clear();
        try {
            stmt = conn.prepareStatement(ListSQL);
            rs = stmt.executeQuery();

            while (rs.next()) {
                TiposSanguineos ts = new TiposSanguineos();
                ts.setId(rs.getInt("id_tipo_sanguineo"));
                ts.setDescricao(rs.getString("descricao"));
                ts.setFator_rh(rs.getString("fator_rh"));
                ts.setEstoque(rs.getInt("estoque"));

                getTiposSanguineosList().add(ts);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CidadesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void salvar(TiposSanguineos ts) {

        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO tipos_sanguineos(descricao, fator_rh, estoque) VALUES (?,?,?)");
            stmt.setString(1, ts.getDescricao());
            stmt.setString(2, ts.getFator_rh());
            stmt.setInt(3, ts.getEstoque());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Tipo Sanguineo Cadastrado com Sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(CidadesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void alterar(TiposSanguineos ts) {

        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("UPDATE tipos_sanguineos set descricao = ?, fator_rh = ?, estoque = ? WHERE id_tipo_sanguineo = ? ");
            stmt.setString(1, ts.getDescricao());
            stmt.setString(2, ts.getFator_rh());
            stmt.setInt(3, ts.getEstoque());
            stmt.setInt(4, ts.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Tipo Sanguineo Alterado com Sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(TiposSanguineosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Excluir(TiposSanguineos ts) {

        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("DELETE from tipos_sanguineos WHERE id_tipo_sanguineo = ?");
            stmt.setInt(1, ts.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Tipo Sanguineo Excluido com Sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(CidadesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
