package prueba;
import java.sql.*;
import static prueba.Conexion.servidor;


public class Conexion 
{
    static String servidor="ALEJANDRO\\SQLEXPRESS";
    static String puerto="1433";
    static String usuario="sa";
    static String clave="sistemas";
    static String bd="Control";
    static String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
   
    
    public Connection conectar()
    {
        
        Connection cn=null;
        try {
            
            Class.forName(Driver).newInstance();
            String url="jdbc:sqlserver://"+servidor+":"+puerto+";"+
                    "databaseName="+bd+";user="+usuario+";password="+clave+";";
            
            cn=DriverManager.getConnection(url);
            System.out.println(" Conexion ok ");
            
            
        } catch (Exception e) {
            System.out.println("SQL Exception: "+e.toString());
        }
      return cn;
    }
    
    
}




