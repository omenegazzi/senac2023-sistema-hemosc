package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaoMysql {
    
    public static Connection conexao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/db_hemosc?user=root&password=root");
                        
        } catch (ClassNotFoundException | SQLException ex) {            
           throw new RuntimeException("Erro ao conectar no banco", ex);
        }
    }     
}

