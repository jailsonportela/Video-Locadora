
package DAO;

import Modelo.Funcionario;
import Principal.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FuncionarioDAO extends ExecuteSQL{
    
        public boolean cadastrarFuncionario(Funcionario f){
            try {
                    String sql="insert into funcionario values(0,?,?,?)";
                    PreparedStatement ps=getCon().prepareStatement(sql);
                    ps.setString(1,f.getNome());
                    ps.setString(2,f.getLogin());
                    ps.setString(3,f.getSenha());
                    ps.executeUpdate();
                    return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    public boolean Logar(String login,String senha){
        boolean finalResult=false;
        try {
         String consulta="select login,senha from funcionario where login = '"+login+" ' and senha= '"+senha+"' ";
         PreparedStatement ps=getCon().prepareStatement(consulta);
         ResultSet rs= ps.executeQuery();
         if(rs!=null){
                    while(rs.next()){
                              finalResult=true;
                    }
         }
        }catch (Exception e){
            e.printStackTrace();
        }
        return finalResult;
    }
    public String funcionarioAtual(){
        String login=Login.txtLogin.getText();
        String senha=Login.txtSenha.getText();
        String nome=null;
                try {
         String consulta="select nome from funcionario where login = '"+login+" ' and senha= '"+senha+"' ";
         PreparedStatement ps=getCon().prepareStatement(consulta);
         ResultSet rs= ps.executeQuery();
         if(rs!=null){
                    while(rs.next()){
                              nome=rs.getString(1);
                    }
         }
        }catch (Exception e){
            e.printStackTrace();
        }finally{return nome;}
    }

}
