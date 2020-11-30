
package DAO;

import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO extends ExecuteSQL{
//<editor-fold desc="Funções de inserção">  
    public String inserir_Cliente(Cliente cliente){
        String sql="insert into cliente values (0,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps=getCon().prepareStatement(sql);
            ps.setString(1, cliente.getNome() );
             ps.setString(2, cliente.getNascimento());
              ps.setString(3, cliente.getRG());
               ps.setString(4, cliente.getCPF());
                ps.setString(5, cliente.getEmail());
                 ps.setString(6, cliente.getTelefone());
                  ps.setString(7, cliente.getBairro());
                   ps.setString(8, cliente.getRua() );
                    ps.setInt(9, cliente.getNumero());
                     ps.setString(10, cliente.getCEP());
                    if(ps.executeUpdate()>0){
                         return "Cliente cadastrado com sucesso";
                    }else{
                        return "Erro ao cadastrar o cliente";
                    }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    //</editor-fold>
    
//<editor-fold desc="Funções de consulta">  
   public List<Cliente> lista(String sql){
               List<Cliente>clientes=new ArrayList<>();
        try {
            PreparedStatement ps=getCon().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs != null){
                    while(rs.next()){
                              Cliente cliente=new Cliente();
                              cliente.setCodigo(rs.getInt(1));
                              cliente.setNome(rs.getString(2));
                              cliente.setNascimento(rs.getString(3));
                              cliente.setRG(rs.getString(4));
                              cliente.setCPF(rs.getString(5));
                              cliente.setEmail(rs.getString(6));
                              cliente.setTelefone(rs.getString(7));
                              cliente.setBairro(rs.getString(8));
                              cliente.setRua(rs.getString(9));
                              cliente.setNumero(rs.getInt(10));
                              cliente.setCEP(rs.getString(11));
                              clientes.add(cliente);
                    }
                    return clientes;
            }else{
                   return null;
            }
        } catch (Exception e) {
            return null;
        }
   }
    public List<Cliente> listar_clientes(){
        return lista("select * from cliente");
    }
    public List<Cliente>pegarPorCodigo(int codigo){
                return lista("select * from cliente where idcliente="+codigo);
    }
        public List<Cliente>pegarPorNome(String nome){
                return lista("select * from cliente where nome Like '%"+nome+"%'");
    }
        public boolean testarCliente(int cod){
            String sql="select * from cliente where idcliente="+cod;
            try {
                PreparedStatement ps=getCon().prepareStatement(sql);
                ResultSet rs=ps.executeQuery();
                if(rs!=null){
                    return true;
                }else return false;
            } catch (Exception e) {
                return false;
            }
        }
       //</editor-fold>
        
//<editor-fold  desc="Funções de alteração(possui relação com as de consulta)">
        public String alterarCliente(Cliente cliente){
            String sql="update cliente set nome=?,data_nasc=?,rg=?,cpf=?,email=?,telefone=?,bairro=?,rua=?,"
                           + "numero=?,cep=? where idcliente=?";
            try {
                PreparedStatement ps=getCon().prepareStatement(sql);
                ps.setString(1, cliente.getNome());
                ps.setString(2, cliente.getNascimento());
                ps.setString(3, cliente.getRG());
                ps.setString(4, cliente.getCPF());
                ps.setString(5, cliente.getEmail());
                ps.setString(6, cliente.getTelefone());
                ps.setString(7, cliente.getBairro());
                ps.setString(8, cliente.getRua());
                ps.setInt(9, cliente.getNumero());
                ps.setString(10, cliente.getCEP());
                ps.setInt(11, cliente.getCodigo());
                if(ps.executeUpdate()>0){
                    return "Atualizado com sucesso";
                }else return "Não foi possível atualizar";
            } catch (Exception e) {
                return e.getMessage();
            }
        }
        //</editor-fold>
//<editor-fold desc="Funções de Exclusão">
        public void excluirClientePeloNome(String nome){
            String sql="delete from cliente where nome='"+nome+"'";
            try {
                PreparedStatement ps=getCon().prepareStatement(sql);
                ps.executeUpdate();
                } catch (SQLException ex) {
                
                }
           }
//</editor-fold>
}
