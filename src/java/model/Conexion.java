/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author bgonz
 */
public class Conexion {
    
     private static Connection con; //se maneja la conexion de la basae de datos.
    private static final String driver="com.mysql.jdbc.Driver"; //Manejador de base de datos.
    private static final String user="root"; 
    private static final String pass="123456";
    private static final String url="jdbc:mysql://localhost:3306/dbiMC";// se pone el de la base de datos
    private static String mensaje;
    
    public static Connection getConexion()//Verifica si existe una conexion
    {

        if(con!=null)// conexion abierta
        {
            return con;// conexion establecida.
        }
		
        try//Aqui es donde se controlan los errores, se establece la conexion. Si hay error se muestra mensaje 
	{
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, pass);
            mensaje = "Conectado a la base de datos";
            return con;
	}
	catch(ClassNotFoundException | SQLException ex)// mensaje de error. 
	{
            mensaje = ex.getMessage();
            return null;
	}
    }
    
    public static String getMensaje(){
        return mensaje;
    }
    
    public static void cerrar(){
        try{
            con.close();
        }catch(SQLException ex){
            mensaje="Error al cerrar la conexion";
        }
    }
    
}


