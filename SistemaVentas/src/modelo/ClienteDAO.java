/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.PreparedStatement;
import com.mysql.jdbc.Connection;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bmeji
 */
public class ClienteDAO implements CRUD{
    Connection con;
    Conexion cn =new Conexion ();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List listar() {
      List<Cliente>lista=new ArrayList<>();
      String sql =" select *from cliente";
      try{
          con =(Connection) cn.Conectar();
          ps=(PreparedStatement) con.prepareStatement(sql);
          rs= ps.executeQuery();
          while(rs.next()){
              Cliente c= new Cliente ();
              c.setId(rs.getInt(1));
              c.setDni(rs.getString(2));
              c.setNom(rs.getString(3));
              c.setDir(rs.getString(4));
              c.setEstado(rs.getString(5));
              lista.add(c);
              
          }
      }catch (Exception e){
          
      }
      return lista;
    }

   
    public int add(Object[] o) {
        int r=0;
        String sql= "insert into cliente (Dni, Nombres,Direccion,Estado)values(?,?,?,?)";
        try{
            con=(Connection) cn.Conectar();
            ps=(PreparedStatement) con.prepareStatement(sql);
            ps.setObject(1,o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            
            ps.executeUpdate();
            
        }catch (Exception e){
            
        }
        return r ;
    }

  
    public int actualizar(Object[] o) {
        int r=0;
        String sql= "update cliente set Dni =?,Nombres=?,Direccion=?,Estado=? where IdCliente=?";
        try{
            con =(Connection) cn.Conectar();
            ps =con.prepareStatement (sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
           r= ps.executeUpdate();
            
            
        }catch(Exception e){
            
        }
        return r;
    }

    @Override
    public void eliminar(int id) {
       String sql ="delete from cliente where IdCliente=?";
       try{
           con = (Connection) cn.Conectar();
           ps=con.prepareStatement(sql);
           ps.setInt(1, id);
           ps.executeUpdate();
       }catch(Exception e){
           
       }
    }
    
    
    
}
