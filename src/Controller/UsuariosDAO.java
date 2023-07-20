package Controller;

import Connection.conexaoMysql;
import Model.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuariosDAO {

    public void cadastro(String email, String usuario, char[] senha, char[] confirmaSenha) {

        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("SELECT COUNT(*) FROM login WHERE email = ? AND usuario = ? AND senha = ?");
            stmt.setString(1, email);
            stmt.setString(2, usuario);
            stmt.setString(3, String.valueOf(senha));

            rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário já cadastrado");
                } else if (Arrays.equals(senha, confirmaSenha)) {
                    stmt = conn.prepareStatement("INSERT INTO login(email,usuario,senha)values(?,?,?)");
                    stmt.setString(1, email);
                    stmt.setString(2, usuario);
                    stmt.setString(3, String.valueOf(senha));

                    stmt.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
                } else {
                    JOptionPane.showMessageDialog(null, "As senhas não coincidem!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return; //Em caso de erro ou se não houver registros correspondentes.
    }

    public boolean validacaoLogin(String usuario,String email, char[] senha) {

        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("SELECT COUNT(*) FROM login WHERE email = ? AND usuario = ? AND senha = ?");
            stmt.setString(1, usuario);
            stmt.setString(2,email);
            stmt.setString(3, String.valueOf(senha));

            rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "Seja bem-vindo, " + usuario + "!");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Login incorreto!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Em caso de erro ou se não houver registros correspondentes.
    }

    public List<Usuarios> Listar() {
        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuarios> Usuarios = new ArrayList();

        try {
            stmt = conn.prepareStatement("select*from login");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Usuarios u = new Usuarios();
                u.setId(rs.getInt("id_usuario"));
                u.setUsuario(rs.getString("usuario"));
                u.setEmail(rs.getNString("email"));
                Usuarios.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Usuarios;
    }

    public void Excluir(Usuarios u) {
        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("DELETE from login WHERE id_usuario = ?");
            stmt.setInt(1, u.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuario excluido com Sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Alterar(Usuarios u) {
        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("UPDATE login set usuario = ?, email = ? where id_usuario = ?");
            stmt.setString(1, u.getEmail());
            stmt.setString(2, u.getUsuario());
            stmt.setInt(3, u.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuario alterado com Sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Usuarios> pesquisar(String texto) {
        Connection conn = conexaoMysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuarios> Usuarios = new ArrayList();

        try {
            stmt = conn.prepareStatement("select*from login where usuario like ? '%'");
            stmt.setString(1, '%'+texto+'%');
            rs = stmt.executeQuery();
            
             while(rs.next()){
            Usuarios u = new Usuarios();
            u.setId(rs.getInt("id_usuario"));
            u.setUsuario(rs.getString("usuario"));
            u.setEmail(rs.getString("email"));
 
            
            Usuarios.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Usuarios;
        
    }

}
