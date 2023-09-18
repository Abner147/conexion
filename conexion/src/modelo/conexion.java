/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Abner
 */
public class conexion {
     public Connection conexionBD;
    private final String db = "db_empresa";
    private final String urlconexion = String.format("jdbc:mysql://localhost:3306/%s",db);
    private final String usuario = "usr_empresa";
    private final String contra = "Empresa123";
    private final String jdbc ="com.mysql.cj.jdbc.Driver";
   
    public void abrir_conexion(){
            try{
                Class.forName(jdbc);
                conexionBD = DriverManager.getConnection(urlconexion,usuario,contra);
                //JOptionPane.showMessageDialog(null,"Conexion Exitosa","Exito",JOptionPane.INFORMATION_MESSAGE);
                
            }catch(HeadlessException | ClassNotFoundException | SQLException ex){
                    System.out.println("Error: " + ex.getMessage());
            }
        
                    }
    public void cerrar_conexion(){
        try{
            conexionBD.close();
        } catch(SQLException ex){
             System.out.println("Error: " + ex.getMessage());
        }
    }
    
    }
