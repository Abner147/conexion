/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Abner
 */
public class Cliente extends Persona {
    private String nit;
    private int id;
conexion cn;
public Cliente(){
}

    public Cliente(int id, String nit,String nombres, String apellidos, String direccion, String telefono, String fecha_nacimiento) {
        super(nombres, apellidos, direccion, telefono, fecha_nacimiento);
        this.id = id;
        this.nit = nit;
        
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
}
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    
    }
    //nuevo codigo clase 
    @Override
    public DefaultTableModel leer(){
        DefaultTableModel tabla = new DefaultTableModel();
        try{
            cn= new conexion();
            cn.abrir_conexion();
            String query;
            query = "SELECT id_cliente AS id, nit, nombres, apellidos, direccion, telefono, fecha_nacimiento   FROM clientes";
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            String encabezado[] = 
            {"id", "nit","nombre", "apellidos","direccion","telefono","Fecha_nacimiento"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[]= new String[7];
            while(consulta.next()){
                datos[0]=consulta.getString("id");
                datos[1]=consulta.getString("nit");
                datos[2]=consulta.getString("nombres");
                datos[3]=consulta.getString("apellidos");
                datos[4]=consulta.getString("direccion");
                datos[5]=consulta.getString("telefono");
                datos[6]=consulta.getString("Fecha_nacimiento");
                tabla.addRow(datos);
            }
                  cn.cerrar_conexion();
        }
           catch (SQLException ex){
               System.out.println("error:" + ex.getMessage());
            }
    
        return tabla;   
           }
     public void agregar() {
    try{
        PreparedStatement parametro;
        String query = "INSERT INTO clientes(nit,nombres,apellidos,direccion,telefono,fecha_nacimiento) VALUES(?,?,?,?,?,?);";
        cn = new conexion();
        cn.abrir_conexion();
        parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
        parametro.setString(1, this.getNit());
        parametro.setString(2, this.getNombres());
        parametro.setString(3, this.getApellidos());
        parametro.setString(4, this.getDireccion());
        parametro.setString(5, this.getTelefono());
        parametro.setString(6, this.getFecha_nacimiento());
        
        int executar= parametro.executeUpdate();
        cn.cerrar_conexion();
        //JOptionPane.showMessageDialog(null,Integer.toString (executar) + "Registro ingresado", "Agregar",JOptionPane.INFORMATION_MESSAGE);
        
        
    } catch(SQLException ex){
        System.out.println("Error..." + ex.getMessage());
    }

    }
    @Override
     public void actualizar() {
    try{
        PreparedStatement parametro;
        String query = "update clientes set nit= ?,nombres= ?,apellidos= ?,direccion= ?,telefono= ?,fecha_nacimiento= ?"+ "where id_cliente=?";
        cn = new conexion();
        cn.abrir_conexion();
        parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
        parametro.setString(1, this.getNit());
        parametro.setString(2, this.getNombres());
        parametro.setString(3, this.getApellidos());
        parametro.setString(4, this.getDireccion());
        parametro.setString(5, this.getTelefono());
        parametro.setString(6, this.getFecha_nacimiento());
        parametro.setInt(7, getId());
         
        
        int executar= parametro.executeUpdate();
        cn.cerrar_conexion();
        //JOptionPane.showMessageDialog(null,Integer.toString (executar) + "Registro ingresado", "Agregar",JOptionPane.INFORMATION_MESSAGE);
        
        
    } catch(SQLException ex){
        System.out.println("Error..." + ex.getMessage());
     }
    }
      public void eliminar() {
    try{
        PreparedStatement parametro; 
        cn = new conexion();
        cn.abrir_conexion();
        String query = "delete from clientes where id_cliente=?";
        parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
        parametro.setInt(1, getId());
        
        int executar= parametro.executeUpdate();
        cn.cerrar_conexion();
        //JOptionPane.showMessageDialog(null,Integer.toString (executar) + "Registro ingresado", "Agregar",JOptionPane.INFORMATION_MESSAGE);
        
        
    } catch(SQLException ex){
        System.out.println("Error..." + ex.getMessage());
     }
    }
     }
     
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
    
   

   
    
    