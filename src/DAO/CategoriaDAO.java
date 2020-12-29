/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategoriaDAO extends ExecuteSQL{
    
   /* public CategoriaDAO(Connection con) {
        super(con);
    }*/
//<editor-fold desc="funções de inserção">
public void inserirCategoria(Categoria c){
           String sql="insert into categoria values(0,?)";
        try {
            PreparedStatement ps=getCon().prepareStatement(sql);
            ps.setString(1,c.getNome());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
}
//</editor-fold>    
    //<editor-fold desc="funções de consulta">
public List<Categoria> listaCategoria(){
        String sql="select * from categoria";
        List<Categoria>lista=new ArrayList<>();
        try {
            PreparedStatement ps=getCon().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Categoria categoria= new Categoria();
                categoria.setCodigo(rs.getInt(1));
                categoria.setNome(rs.getString(2));
                lista.add(categoria);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
}
public int pegarPorCodigo(String nome){
            String sql="select idcategoria from categoria where nome='"+nome+"' ";
        try {
            PreparedStatement ps=getCon().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            Categoria categoria=new Categoria();
            if(rs!=null){
                while(rs.next()){
                    categoria.setCodigo(rs.getInt(1));
                }
            }
            return categoria.getCodigo();
        } catch (Exception e) {
            e.getStackTrace();
            return 0;
        }
}
public String pegarONome(String codigo){
            String sql="select nome from categoria where idcategoria="+codigo;
        try {
            PreparedStatement ps=getCon().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            Categoria categoria=new Categoria();
            if(rs!=null){
                while(rs.next()){
                    categoria.setNome(rs.getString(1));
                }
            }
            return categoria.getNome();
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
}
public List<Categoria>pegarPorCodigo(int id){
    return listaCategoria().stream()
            .filter(c->c.getCodigo()==id)
            .collect(Collectors.toList());
}
public List<Categoria>pegarPorNome(String nome){
    return listaCategoria().stream()
            .filter(c->c.getNome().contains(nome))
            .collect(Collectors.toList());
}
//</editor-fold>
}
