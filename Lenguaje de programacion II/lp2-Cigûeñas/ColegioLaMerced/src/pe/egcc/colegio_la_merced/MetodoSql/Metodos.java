
package pe.egcc.colegio_la_merced.MetodoSql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import pe.egcc.colegio_la_merced.ControlDB.ConexionBDColegioLaMerced;

public class Metodos 
        
{
    Connection cn;

    public Metodos() 
    
    {
        cn = ConexionBDColegioLaMerced.AccesoBD();
    }
    
    public  void LlenarTablaDocente(DefaultTableModel model)
    {
        try 
        
        {
            String sql = "select idTrabajador,Nombre,Apellidos,dni,Telefono,Nombre_del_puesto  from TBCategoria C inner join TBTrabajador T\n" +
" on C.idCategoria=T.idcategoria\n" +
"";
            CallableStatement cmd = cn.prepareCall(sql);
            ResultSet rs = cmd.executeQuery();
            
            
            while(rs.next())
                
            {
                Object[] dato = new Object[6];
                for (int i = 0; i < 6; i++) 
                
                {
                    dato[i] = rs.getString(i+1);
                }
                
                model.addRow(dato);
            }
            
            cmd.close();
            cn.close();
        }
        
        
        catch (Exception e) 
        
        {
            System.err.println(e.getMessage());
            
        }
    }
    
    
    public  void agregar(String Nombre, String Apellido,String Dni, String Telefono, String idcategoria  )
    {
        
        try 
        
        {
            String sql = "execute add_trabajador ?,?,?,?,? ";
            PreparedStatement cmd = cn.prepareCall(sql);
            cmd.setString(1, Nombre);
            cmd.setString(2, Apellido);
            cmd.setString(3, Dni);
            cmd.setString(4, Telefono);
            cmd.setString(5, idcategoria);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        
        catch (Exception e) 
        
        {
           String error = "Error en funcion agregar";
            System.err.println();
        }
        
    }


    
    
    
    
}
