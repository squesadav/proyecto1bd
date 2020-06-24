/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author sebas
 */
public class ConnectDB {
    
    public static void insertUserType(String name) throws SQLException {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "ADM";
        String uPass = "ADM";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call adminUser.createUserType(?) } ");
        
        stmnt.setString(1, name);
        stmnt.execute();
    }
    
        public static void getUserType(String user_name) throws SQLException {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "ADM";
        String uPass = "ADM";
        //Lo dejo así porque no se si hay una funcion que devuelva cursor con todos los datos de user
        //Voy a suponer que esa funcion si existe
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ ? = call adminUser.getUserType(?) } ");
        //CallableStatement stmnt = con.prepareCall("{ ? = call adminUser.getUserAll(?)}");
     
        stmnt.registerOutParameter(1, OracleTypes.Number);
        //stmnt.registerOutParameter(1, OracleTypes.Cursor);
        //stmnt.executeQuery(); creo que es igual a stmnt.execute();
        //ResultSet user = (ResultSet) stmnt.getObject(1);
        //string password = user.getString("password");
        //int idType = (int) user.getString("id_type");
        stmnt.setString(2, user_name);
        stmnt.execute();
        int typeUser = (int) stmnt.getObject(1);
        
    }
    
             
    public static void insertRecord(String schema,String function,HashMap<String,String> attributes) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = schema;
        String uPass = schema;
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        if (attibutes.size() == 9)
        {
            CallableStatement stmnt = con.prepareCall("{? = call ?(?,?,?,?,?,?,?,?,?)}");
            stmnt.setString(3, attributes.get("description_crime"));
            String date_crimeS = attributes.get("date_crime");
            Date date_crime = new SimpleDateFormat("yyyy/MM/dd").parseDate(attributes.get("date_crime"));
            
        }
        stmnt.registerOutParameter(1, OracleTypes.Cursor);
        
        stmnt.setString(2, function);
        
        stmnt.executeQuery(); 
        ResultSet user = (ResultSet) stmnt.getObject(1);
    }
        
    public static void query(String schema,String function,String atributo) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = schema;
        String uPass = schema;
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ ? = call ?(?) } ");
        
        stmnt.registerOutParameter(1, OracleTypes.Cursor);
        stmnt.setString(2, function);
        stmnt.setString(3, atributo);
        stmnt.executeQuery(); 
        ResultSet user = (ResultSet) stmnt.getObject(1);
    }
    
    public static void query(String schema,String function,int atributo) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = schema;
        String uPass = schema;
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ ? = call ?(?) } ");
        
        stmnt.registerOutParameter(1, OracleTypes.Cursor);
        stmnt.setString(2, function);
        stmnt.setInt(3, atributo);
        stmnt.executeQuery(); 
        ResultSet user = (ResultSet) stmnt.getObject(1);
    }
}











