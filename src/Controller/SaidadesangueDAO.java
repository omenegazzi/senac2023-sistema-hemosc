
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
import javax.swing.JOptionPane;

public class SaidadesangueDAO {
    
    private List<saidassangue> saidadesangueList = new ArrayList();
    private String ListSQL = "SELECT * from saida_sangue";

    public List<saidassangue> getSaidasangueList() {
        return saidadesangueList;
    }
    
    private void setListSQL(String ListSQL) {
        this.ListSQL = ListSQL;
    }
    
    public List<saidassangue> listar(){
        setListSQL("SELECT * from saida_sangue");
        gerarLista();
        
        return getSaidasangueList();
    }
    
    public List<saidassangue> pesquisar(String Campo,String Valor){
        setListSQL("SELECT * from saida_sangue where "+Campo+" = "+Valor);
        gerarLista();
        
        return getSaidasangueList();
    }
    
    private void gerarLista() {
        
        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        getSaidasangueList().clear();
        try {
            stmt = conn.prepareStatement(ListSQL);
            rs = stmt.executeQuery();

            while (rs.next()) {
                saidassangue c = new saidassangue();
                c.setId(rs.getInt("id_saida_sangue"));
                c.setData(rs.getInt("data"));
                c.setQuantidade(rs.getString("quantidade"));
                c.setIdTipoSanguineo(rs.getInt("fk_tipos_sanguineos_id_tipo_sanguineo"));
                c.setIdEntidade(rs.getInt("fk_entidades_id_entidade"));
                
                getSaidasangueList().add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CidadesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void salvar(saidassangue ss) {

        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO saida_sangue(fk_entidades_id_entidade,fk_tipos_sanguineos_id_tipo_sanguineo,data,quantidade) VALUES(?,?,?,?)");
            stmt.setInt(1, ss.getIdEntidade());
            stmt.setInt(2, ss.getIdTipoSanguineo());
            stmt.setInt(3, ss.getData());
            stmt.setString(4, ss.getQuantidade());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Saida de Sangue Salvo com Sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(AgendamentosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Excluir(saidassangue ss) {

        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("DELETE from saida_sangue WHERE id_saida_sangue = ?");
            stmt.setInt(1, ss.getId());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AgendamentosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void alterar(saidassangue ss) {

        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("UPDATE saida_sangue set fk_entidades_id_entidade = ?, fk_tipos_sanguineos_id_tipo_sanguineo = ?, data = ?, quantidade = ? WHERE id_saida_sangue = ?");
            stmt.setInt(1, ss.getIdEntidade());
            stmt.setInt(2, ss.getIdTipoSanguineo());
            stmt.setInt(3, ss.getData());
            stmt.setString(4, ss.getQuantidade());
            stmt.setInt(5, ss.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Saida de Sangue Alterado com Sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(SaidadesangueDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}