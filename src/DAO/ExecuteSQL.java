
package DAO;

import java.sql.Connection;

public class ExecuteSQL {
    private Connection con=Conexao.abrirConexao();
    /*
    public ExecuteSQL(Connection con){
        this.con=con;
    }*/

    public Connection getCon() {
        return con;
    }
}
