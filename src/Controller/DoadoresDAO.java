/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.conexaoMysql;
import Model.Doadores;
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
public class DoadoresDAO {
    
    private List<Doadores> doadoresList = new ArrayList();
    private String ListSQL = "SELECT * from doadores";
    
    public List<Doadores> getDoadoresList() {
        return doadoresList;
    }

    private void setListSQL(String ListSQL) {
        this.ListSQL = ListSQL;
    }
    
    public List<Doadores> listar(){
        setListSQL("SELECT * from doadores");
        gerarLista();
        
        return getDoadoresList();
    }
    
    public List<Doadores> pesquisar(String Campo,String Valor){
        setListSQL("SELECT * from doadores where "+Campo+" = '"+Valor+"'");
        gerarLista();
        
        return getDoadoresList();
    }
    
    private void gerarLista() {

        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        getDoadoresList().clear();
        try {
            stmt = conn.prepareStatement(ListSQL);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Doadores d = new Doadores();
                d.setId(rs.getInt("id_doador"));
                d.setCidadeId(rs.getInt("fk_cidades_id_cidade"));
                d.setTipoSanguineoId(rs.getInt("fk_tipos_sanguineos_id_tipo_sanguineo"));
                d.setNome(rs.getString("nome"));
                d.setEndereco(rs.getString("endereco"));
                d.setDataNascimento(rs.getInt("data_nascimento"));
                d.setTelefone(rs.getString("telefone"));
                d.setEmail(rs.getString("email"));
                d.setCpf(rs.getString("cpf"));

                getDoadoresList().add(d);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DoadoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Excluir(Doadores d) {

        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("DELETE from doadores WHERE id_doador = ?");
            stmt.setInt(1, d.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Doador Excluido com Sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(DoadoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void alterar(Doadores d) {

        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("UPDATE doadores set fk_cidades_id_cidade = ?, fk_tipos_sanguineos_id_tipo_sanguineo = ?, nome = ?, endereco = ?, data_nascimento = ?, telefone = ?, email = ?, cpf = ? WHERE id_doador = ? ");
            stmt.setInt(1, d.getCidadeId());
            stmt.setInt(2, d.getTipoSanguineoId());
            stmt.setString(3, d.getNome());
            stmt.setString(4, d.getEndereco());
            stmt.setInt(5, d.getDataNascimento());
            stmt.setString(6, d.getTelefone());
            stmt.setString(7, d.getEmail());
            stmt.setString(8, d.getCpf());
            stmt.setInt(9, d.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Doador Alterado com Sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(DoadoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public void salvar(Doadores d) {

        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO doadores (fk_cidades_id_cidade, fk_tipos_sanguineos_id_tipo_sanguineo, nome, endereco, data_nascimento, telefone, email, cpf) VALUES (?,?,?,?,?,?,?,?)");
            stmt.setInt(1, d.getCidadeId());
            stmt.setInt(2, d.getTipoSanguineoId());
            stmt.setString(3, d.getNome());
            stmt.setString(4, d.getEndereco());
            stmt.setInt(5, d.getDataNascimento());
            stmt.setString(6, d.getTelefone());
            stmt.setString(7, d.getEmail());
            stmt.setString(8, d.getCpf());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Doador Salvo com Sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(DoadoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
