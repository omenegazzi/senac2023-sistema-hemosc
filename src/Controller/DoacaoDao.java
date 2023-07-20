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

public class DoacaoDao {

    public void salvar(Doadores d) {

        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null ;

        try {
            stmt = conn.prepareStatement("INSERT INTO doadores (id_doador,nome,telefone,email,endereco,cpf,data_nascimento,fk_cidades_id_cidade,fk_tipos_sanguineos_id_tipo_sanguineo) values (?,?,?,?,?,?,?,?,?)");
            stmt.setString(2, d.getNome());
            stmt.setString(3, d.getTelefone());
            stmt.setString(4, d.getEmail());
            stmt.setString(5, d.getEndereco());
            stmt.setString(6, d.getCpf());
            stmt.setInt(7, d.getDataNascimento());
            stmt.setInt(8, d.getTipoSanguineoId());
            stmt.setInt(9, d.getCidadeId());
            stmt.setInt(1, d.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastro Salvo com Sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(DoacaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private List<Doadores> DoadoresList = new ArrayList();
    private String ListSQL = "SELECT * from doadores";

    public List<Doadores> getDoadoresList() {
        return DoadoresList;
    }

    private void setListSQL(String ListSQL) {
        this.ListSQL = ListSQL;
    }

    public List<Doadores> listar() {
        setListSQL("SELECT * from doadores");
        gerarLista();

        return getDoadoresList();
    }

    public List<Doadores> pesquisar(String Campo, String Valor) {
        setListSQL("SELECT * from doadores where " + Campo + " = " + Valor);
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
                d.setId(0);
                d.setTipoSanguineoId(0);
                d.setCidadeId(0);
                d.setNome(rs.getString("nome"));
                d.setEmail(rs.getString("email"));
                d.setTelefone(rs.getString("telefone"));
                d.setCpf(rs.getString("cpf"));
                d.setEndereco(rs.getString("endereco"));
                d.setDataNascimento(rs.getInt("Data Nascimento"));
                Doadores.add(d);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DoacaoDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    public void alterar(Doadores d) {

        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("insert into doadores (id_doador,nome,telefone,email,endereco,cpf,data_nascimento,fk_cidades_id_cidade,fk_tipos_sanguineos_id_tipo_sanguineo) values (?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, d.getNome());
            stmt.setString(2, d.getTelefone());
            stmt.setString(3, d.getEmail());
            stmt.setString(4, d.getEndereco());
            stmt.setInt(5, d.getId());
            stmt.setString(6, d.getCpf());
            stmt.setInt(7, d.getDataNascimento());
            stmt.setInt(8, d.getCidadeId());
            stmt.setInt(9, d.getTipoSanguineoId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastro de Doador Alterado com Sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(SaidadesangueDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
