/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.conexaoMysql;
import Model.entidades;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author murilo.comim
 */
public class EntidadesDAO {
    
    private List<entidades> entidadesList = new ArrayList();
    private String ListSQL;
    
    //Metodos para pegar Lista e setar SQL de geracao de Lista
    private List<entidades> getEntidadesList() {
        return entidadesList;
    }

    private void setListSQL(String ListSQL) {
        this.ListSQL = ListSQL;
    }
    
    //Metodo listar: gera lista com sql sem filtro e retorna a Lista de entidades
    public List<entidades> listar(){
        setListSQL("SELECT * from entidades");
        gerarLista();
        
        return getEntidadesList();
    }
    
    
    //Metodo gerarLista: gera a lista de entidades com base no listSQL podendo ser colocado filtros
    public void gerarLista() {

        getEntidadesList().clear(); //Limpando a lista

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
                entidades ee = new entidades();
                ee.setId(rs.getInt("id_entidade"));
                ee.setIdCidade(rs.getInt("fk_cidades_id_cidade"));
                ee.setNome(rs.getString("nome"));
                ee.setEndereco(rs.getString("endereco"));

                //Adicionando objeto na lista
                getEntidadesList().add(ee);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EntidadesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
