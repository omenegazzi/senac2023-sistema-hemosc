package Controller;

import Connection.conexaoMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Model.Doadores;


public class DoacaoDao {



    public void salvar(Doadores d) {

        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("insert into doadores (id_doador,nome,telefone,email,endereco,cpf,data_nascimento,fk_cidades_id_cidade,fk_tipos_sanguineos_id_tipo_sanguineo) values (?,?,?,?,?,?,?,?,?)");
            stmt.setString(2, d.getNome());
            stmt.setString(3, d.getTelefone());
            stmt.setString(4, d.getEmail());
            stmt.setString(5, d.getEndereco());
            stmt.setString(6, d.getCpf());
            stmt.setInt(7, d.getDataNascimento());
            stmt.setInt(8, d.getTipoSanguineoId());
            stmt.setInt(9,d.getCidadeId());
            stmt.setInt(1,d.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastro Salvo com Sucesso!");

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DoacaoDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
    }

    public List<Doadores> list() {
        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Doadores> Doadores;
        Doadores = new ArrayList();
        try {
            stmt = conn.prepareStatement("SELECT*from doadores");
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
        return Doadores;

    }
}
