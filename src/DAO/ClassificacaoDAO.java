/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Classificacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jailson Portela
 */
public class ClassificacaoDAO extends ExecuteSQL{
    /*
    public ClassificacaoDAO(Connection con) {
        super(con);
    }*/
    //<editor-fold desc="funções de inserção">
public void inserirClassificacao(Classificacao c){
        String sql="insert into classificacao values(0,?,?)";
        try {
            PreparedStatement ps=getCon().prepareStatement(sql);
            ps.setString(1,c.getNome());
            ps.setDouble(2,c.getPreco());
            ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
}
//</editor-fold>

    //<editor-fold desc="funções de consulta">
public List<Classificacao> listaClassificacoes(){
        String sql="select * from classificacao";
        List<Classificacao>lista=new ArrayList<>();
        try {
            PreparedStatement ps=getCon().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Classificacao classificacao= new Classificacao();
                classificacao.setCodigo(rs.getInt(1));
                classificacao.setNome(rs.getString(2));
                classificacao.setPreco(rs.getDouble(3));
                lista.add(classificacao);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
}
public int pegarPorCodigo(String nome){
        String sql="select idclassificacao from classificacao where nome='"+nome+"' ";
        try {
            PreparedStatement ps=getCon().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            Classificacao classificacao=new Classificacao();
            if(rs!=null){
                while(rs.next()){
                    classificacao.setCodigo(rs.getInt(1));
                }
            }
            return classificacao.getCodigo();
        } catch (Exception e) {
            e.getStackTrace();
            return 0;
        }
}
public String pegarONome(String codigo){
            String sql="select nome from classificacao where idclassificacao="+codigo;
        try {
            PreparedStatement ps=getCon().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            Classificacao classificacao=new Classificacao();
            if(rs!=null){
                while(rs.next()){
                    classificacao.setNome(rs.getString(1));
                }
            }
            return classificacao.getNome();
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
}
//</editor-fold>    
}
