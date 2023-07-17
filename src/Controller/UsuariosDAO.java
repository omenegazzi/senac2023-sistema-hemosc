package Controller;

import Connection.conexaoMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuariosDAO {
        
    public void cadastro(String usuario, String senha, String confirmaSenha) {

        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("SELECT COUNT(*) FROM login WHERE usuario = ? AND senha = ?");
            stmt.setString(1, usuario);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if(count > 0){
                    JOptionPane.showMessageDialog(null, "Usuário já cadastrado");
                }else if (senha.equals(confirmaSenha)){
                    stmt = conn.prepareStatement("INSERT INTO login (usuario, senha) VALUES (?,?)");
                    stmt.setString(1, usuario);
                    stmt.setString(2, senha);

                    stmt.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
                }else{
                    JOptionPane.showMessageDialog(null, "As senhas não coincidem!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return; //Em caso de erro ou se não houver registros correspondentes.
    }
        
    public boolean validacaoLogin(String usuario, String senha) {

        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("SELECT COUNT(*) FROM login WHERE usuario = ? AND senha = ?");
            stmt.setString(1, usuario);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0){
                    JOptionPane.showMessageDialog(null, "Seja bem-vindo, " + usuario + "!");
                    return true;
                }else{
                    JOptionPane.showMessageDialog(null, "Login incorreto!");
                }
            } 
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Em caso de erro ou se não houver registros correspondentes.
    }
}        

