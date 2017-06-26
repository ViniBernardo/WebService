/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rodrigo
 */
public class ConnectionFactory {
   private Connection conexao;
   private static final String URL = "jdbc:mysql://localhost";
   private static final String PORT = "3306";
   private static final String DATA_BASE = "casa";
   private static final String USER = "root";
   private static final String PASSWORD = "";
   private static ConnectionFactory connectionFactory;
   
   private ConnectionFactory() throws SQLException, ClassNotFoundException {
       // muito importante não esquecer
        Class.forName("com.mysql.jdbc.Driver");
        conexao = DriverManager.getConnection(URL+":"+PORT+"/"+DATA_BASE, USER, PASSWORD);
   }
   
   public static ConnectionFactory getInstance() throws SQLException, ClassNotFoundException{
        if(connectionFactory == null){
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }
    
    public java.sql.Connection getConn(){
        return conexao;
    } 
}
