/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ida Bagus Mahendra
 */
public class KoneksiDB {
    static Connection koneksi;
    public static Connection getkoneksi()
            {
                try
                {
                  String url = "jdbc:mysql://localhost/pbo";
                  String user = "root";
                  String password = "";
                  DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                  koneksi = DriverManager.getConnection(url, user, password);
                }
                catch (SQLException t)
                {
                  System.out.println("Error membuat koneksi");
                }
                return koneksi;
            }
   
    public static void main(String[] args) 
    {
        getkoneksi();
    }
}
