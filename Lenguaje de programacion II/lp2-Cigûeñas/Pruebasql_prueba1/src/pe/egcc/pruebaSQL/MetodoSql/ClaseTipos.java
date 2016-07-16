
package pe.egcc.pruebaSQL.MetodoSql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import pe.egcc.pruebaSQL.ControlDB.AccesoControlBD;

public class ClaseTipos 
        
        
{
    Connection cn;

    public ClaseTipos() 
    {
        
        cn = AccesoControlBD.ConexionControl();
    }
    
    public  void LlenarDto(DefaultTableModel modelo)
    {
        try 
        
        {
            String sql = "select * from tbtipos";
            CallableStatement cmd = cn.prepareCall(sql);
            ResultSet rs = cmd.executeQuery();
            
            while(rs.next())
                
            {
                Object[] datos = new Object[3];
                for (int i = 0; i < 3; i++) 
                {
                    datos[i] = rs.getString(i+1);
                    
                }
                
                modelo.addRow(datos);
            }
            cmd.close();
            cn.close();
            
        } 
        
        catch (Exception ex) 
        
        {
            
            System.out.println(ex.getMessage());
            
            
        }
    }
    
    
    
    
    
    
}
