
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
    Connection conectar = null;
    public ConexionBD (){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost/db_civil","root","");
        
        }catch (Exception e){
            System.out.println(e.getMessage());
            
}
}
    public Connection getConnection(){
        return conectar;
    }
    public void desconectar(){
        conectar=null;
    }
}
