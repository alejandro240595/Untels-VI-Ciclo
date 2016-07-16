
package pe.egcc.colegio_la_merced.ControlDB;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConexionBDColegioLaMerced 

{

    public ConexionBDColegioLaMerced() 
    
    {
        
    }
    
    
    
    private  static final String User = "sa";
    private  static final String Password = "sistemas";
    private  static final String Driver  = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private  static final String puerto = "1433";
    private  static final String BD = "ColegioLaMerced";
    private  static final String Server = "ALEJANDRO\\SQLEXPRESS";
    
    public static Connection AccesoBD ()
            
    {
        Connection cn = null;
        
        try 
        
        {
            Class.forName(Driver);
            
            String url ="jdbc:sqlserver://" + Server + ":" + puerto + ";databaseName=" + BD + 
                  ";user=" + User + ";password=" + Password  ;
            
            cn = DriverManager.getConnection(url);
            
            
        }   
            
        
        
        catch (Exception e) 
        
        {
            
            System.err.println("Error en la conexion ");
        }
      
        
        return  cn; 
    }
    
    
    
    
    
    
    
    

}
