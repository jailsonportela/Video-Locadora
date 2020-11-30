
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexao {
    public static Connection abrirConexao(){
        Connection con=null;
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             String url="jdbc:mysql://localhost:3306/video_locadora?serverTimezone=UTC";
             con=DriverManager.getConnection(url,"user", "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao se conectar com o Banco de Dados","Video Locadora"
            ,JOptionPane.ERROR_MESSAGE);
        }
        return con;
    }
    public static void fecharConexao(Connection c){
        try {
            c.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
