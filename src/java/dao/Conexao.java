/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author gilson
 */
public class Conexao {
   private static final String USERNAME = "root";
   private static final String PASSWORD = "";
   private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/arduino";

   
   public static Connection criarConexao() throws Exception{
      Class.forName("com.mysql.jdbc.Driver");
      Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
      return connection;
   }
}
