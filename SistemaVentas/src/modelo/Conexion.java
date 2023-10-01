/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

//import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.Connection;
/**
 *
 * @author bmeji
 */
public class Conexion {
    Connection con;
    String url= "jdbc:mysql://localhost:3306/db_drake";
    String user="root";
    String pass="12345678";
    public Connection Conectar() {
        try{
        Class.forName ("com.mysql.jdbc.Driver");
        //con=(Connection) DriverManager.getConnection(url,user,pass);
        con=DriverManager.getConnection (url,user,pass);
        }catch(Exception e){
            
        }
            return con;
        }
    }
    
    
