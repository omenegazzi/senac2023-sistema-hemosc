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

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author murilo.comim
 */
public class AgendamentosDAO {

    private List<Agendamentos> agendamentosList = new ArrayList();
    private String ListSQL = "SELECT * from agendamentos";
    
    public List<Agendamentos> getAgendamentosList() {
        return agendamentosList;
    }

    public void setListSQL(String ListSQL) {
        this.ListSQL = ListSQL;
    }
    
    public List<Agendamentos> listar(){
        setListSQL("SELECT * from agendamentos");
        gerarLista();
        
        return getAgendamentosList();
    }
    
    public List<Agendamentos> pesquisar(String Campo,String Valor){
        setListSQL("SELECT * from agendamentos where "+Campo+" = "+Valor);
        gerarLista();
        
        return getAgendamentosList();
    }
    
    public void gerarLista() {

        getAgendamentosList().clear(); //Limpando a lista

        //Inicio da conexão com o banco
        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null; 

        try {
            //Executando SQL no banco
            stmt = conn.prepareStatement(ListSQL);
            rs = stmt.executeQuery();

            //Registrando os valores do banco no objeto
            while (rs.next()) {
                Agendamentos ag = new Agendamentos();
                ag.setId(rs.getInt("id_agendamento"));
                ag.setData(Integer.parseInt(rs.getDate("data").toString()));
                ag.setHora(Integer.parseInt(rs.getTime("hora").toString()));
                ag.setIdDoador(rs.getInt("fk_doadores_id_doador"));

                //Adicionando objeto na lista
                getAgendamentosList().add(ag);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AgendamentosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvar(Agendamentos ag) {

        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO agendamentos(data,hora,fk_doadores_id_doador) VALUES(?,?,?)");
            stmt.setInt(1, ag.getData());
            stmt.setInt(2, ag.getHora());
            stmt.setInt(3, ag.getIdDoador());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Agendamento Salvo com Sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(AgendamentosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
