
package prueba;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;


public class clasetipos 
{
    Connection cn;
    public clasetipos()
    {
        Conexion con= new Conexion();
        cn=con.conectar();      
    }
    
    public void llenardatos(DefaultTableModel modelo)
    {
        try
        {
            String sql="select * from tbtipos";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs=cmd.executeQuery();
            while(rs.next())
            {
                Object[] datos=new Object[3];
                for(int i=0;i<3;i++)
                { 
                    datos[i]=rs.getString(i+1);
                }
                modelo.addRow(datos);
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
   public void agregar(String desc, String abrev)
   {
       try
       {
           String sql="execute add_tipo ?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           
           cmd.setString(1, desc);
           cmd.setString(2, abrev);
           cmd.execute();
           cmd.close();
           cn.close();
            }
       catch(Exception ex)
       {
           System.out.println(ex.getMessage());
       }
   }
    
    
}
