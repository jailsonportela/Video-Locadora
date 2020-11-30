
package DAO;

import Modelo.Filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO extends ExecuteSQL{
    
//<editor-fold desc="funções de inserção">
    public void inserirFilme(Filme filme){
        String sql="insert into filme values(0,?,?,?,?,?,?)";
        try {
            PreparedStatement ps=getCon().prepareStatement(sql);
            ps.setString(1,filme.getTitulo());
            ps.setInt(2,filme.getAno());
            ps.setString(3,filme.getDuracao());
            ps.setInt(4,filme.getCodigo_categoria());
            ps.setInt(5,filme.getCodigo_classificacao());
            ps.setString(6,filme.getCapa());
            ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
    }
//</editor-fold>
//<editor-fold desc="funções de inserção">
     public List<Filme> listaTituloFilmes(){
         String sql="select titulo from filme";
         try {
             PreparedStatement ps=getCon().prepareStatement(sql);
             ResultSet rs=ps.executeQuery();
             List<Filme>lista=new ArrayList<>();
             if(rs!=null){
                 while(rs.next()){
                     Filme filme=new Filme();
                     filme.setTitulo(rs.getString(1));
                     lista.add(filme);
                 }
             }
              return lista;
         } catch (Exception e) {
             e.printStackTrace();
             return null;
         }
     }
          public List<Filme> listaTituloFilmesLikeString(String nome){
         String sql="select titulo from filme where tituloe like '%"+nome+"%'";
         try {
             PreparedStatement ps=getCon().prepareStatement(sql);
             ResultSet rs=ps.executeQuery();
             List<Filme>lista=new ArrayList<>();
             if(rs!=null){
                 while(rs.next()){
                     Filme filme=new Filme();
                     filme.setTitulo(rs.getString(1));
                     lista.add(filme);
                 }
             }
              return lista;
         } catch (Exception e) {
             e.printStackTrace();
             return null;
         }
     }
          public int codigoFilme(String titulo){
         String sql="select idfilme from filme where titulo='"+titulo+"'";
         try {
             PreparedStatement ps=getCon().prepareStatement(sql);
             ResultSet rs=ps.executeQuery();
             Filme filme=new Filme();
             if(rs!=null){
                 while(rs.next()){
                     
                     filme.setCodigo(rs.getInt(1));
                 }
             }
              return filme.getCodigo();
         } catch (Exception e) {
             e.printStackTrace();
             return 0;
         }
     }
          public String pegarCapaFilme(int codigoFilme){
              String capa=null;
              String sql="select capa from filme where idfilme="+codigoFilme;
              try {
                  PreparedStatement ps=getCon().prepareStatement(sql);
                  ResultSet rs=ps.executeQuery();
                  if(rs!=null){
                      while(rs.next()){
                              capa=rs.getString(1);
                      }
                  }
              } catch (Exception e) {
                  return null;
              }
              return capa;
          }
//</editor-fold>
//<editor-fold desc="funções de exclusão">
          public boolean excluirFilme(String titulo){
              try {
                  String sql="delete from filme where titulo='"+titulo+"'";
                  PreparedStatement ps=getCon().prepareStatement(sql);
                  ps.executeUpdate();
                  return true;
              } catch (Exception e) {
                  return false;
              }
          }
//</editor-fold>
}
