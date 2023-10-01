/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
/**
 *
 * @author bmeji
 */
public class VendedorDAO {
    PreparedStatement ps;
    ResultSet rs;
    
    EntiVendedor ev =new EntiVendedor();
    
    Conexion con = new Conexion();
    Connection acceso;
    
    public EntiVendedor ValidarVendedor(String dni,String user){
        String sql="select *from vendedor where Dni=? and User=?";
        try{
            acceso =con.Conectar();
            ps=acceso.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, user);
            rs= ps.executeQuery();
            while (rs.next()){
                ev.setId(rs.getInt(1));
                ev.setDni(rs.getString(2));
                ev.setNom(rs.getString(3));
                ev.setTel(rs.getString(4));
                ev.setEstado(rs.getString(5));
                ev.setUser(rs.getString(6));
                
            }
        }catch(Exception e){
            return ev;
            
        }
        return ev;
        
    }
    
    
    
}
