
package pe.egcc.pruebaSQL.ControlDB;

import java.sql.Connection;
import java.sql.DriverManager;


public final class AccesoControlBD 

{

    public AccesoControlBD() 
    
    {
        
    }
    
    
    private static final String Usuario = "sa";
    private static final String Contraseña = "sistemas";
    private static final String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String BD = "Control";
    private static final String Servidor = "ALEJANDRO\\SQLEXPRESS";
    private static final String Puerto = "1433";
    
    
    
    
    public static Connection ConexionControl()
            {
                
                Connection cn = null;
                
                try 
                
                {
                    Class.forName(Driver);  //Carga el driver
                    
                    String url = "jdbc:sqlserver://"+ Servidor +":" + Puerto + ";"+"databaseName=" + BD 
                            + ";" + "user=" + Usuario + ";" + "password=" + Contraseña;
                    cn = DriverManager.getConnection(url); // Se obtiene el objeto conexion
                    
                    System.out.println("Conexion Correcta ");
                    
                    
                    
                } 
                
                catch (Exception e) 
                
                {
                   
                   System.out.println("Fallo en la conexion");
                    
                }
                
                return cn;
                
            }
    
    
}
