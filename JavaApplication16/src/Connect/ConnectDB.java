package Connect;
import BL.Banned;
import BL.BannedReason;
import BL.User;
import BL.UserType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.Date;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author sebas
 */
public class ConnectDB {
    
    public static void insertUser(User user) throws SQLException 
    {        
        String host = "jdbc:oracle:thin:@localhost:1521:DB";
        String uName = "ADM";
        String uPass = "ADM";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call adminUser.createUser(?,?,?) } ");
        
        stmnt.setString(1, user.getUsername());
        stmnt.setString(2, user.getPassword());
        stmnt.setInt(3, user.getId_userType());
        stmnt.execute();
    }
    
    public static void insertBanned(Banned banned) throws SQLException 
    {        
        String host = "jdbc:oracle:thin:@localhost:1521:DB";
        String uName = "ADM";
        String uPass = "ADM";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call adminUser.createbanned(?,?,?,?,?) } ");
        
        stmnt.setString(1, banned.getIsPermanent());
        stmnt.setDate(2, (Date) banned.getDate_start());
        stmnt.setDate(3, (Date) banned.getDate_finish());
        stmnt.setString(4, banned.getUsername());
        stmnt.setInt(5, banned.getId_bannedreason());
        stmnt.execute();
    }
    
    public static void insertBannedReason(BannedReason bannedreason) throws SQLException 
    {        
        String host = "jdbc:oracle:thin:@localhost:1521:DB";
        String uName = "ADM";
        String uPass = "ADM";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call adminUser.createbannedreason(?) } ");
        
        stmnt.setString(1, bannedreason.getDescription());
        stmnt.execute();
    }
    
    public static void insertUserType(UserType usertype) throws SQLException 
    {        
        String host = "jdbc:oracle:thin:@localhost:1521:DB";
        String uName = "ADM";
        String uPass = "ADM";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call adminUser.createUsertype(?) } ");
        
        stmnt.setString(1, usertype.getDescription());
        stmnt.execute();
    }
    
    public static void editUserPassword(String username, String oldPassword, String newPassword) throws SQLException 
    {        
        String host = "jdbc:oracle:thin:@localhost:1521:DB";
        String uName = "ADM";
        String uPass = "ADM";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call adminUser.editUserPassword(?,?,?) } ");
        
        stmnt.setString(1, username);
        stmnt.setString(2, oldPassword);
        stmnt.setString(3, newPassword);
        stmnt.execute();
    }
    
    public static void editUserType(String username, int userType) throws SQLException 
    {        
        String host = "jdbc:oracle:thin:@localhost:1521:DB";
        String uName = "ADM";
        String uPass = "ADM";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call adminUser.editUserType(?,?) } ");
        
        stmnt.setString(1, username);
        stmnt.setInt(2, userType);
        stmnt.execute();
    }
    
    public static void editUsername(String oldUsername, String newUsername) throws SQLException 
    {        
        String host = "jdbc:oracle:thin:@localhost:1521:DB";
        String uName = "ADM";
        String uPass = "ADM";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call adminUser.editUsername(?,?) } ");
        
        stmnt.setString(1, oldUsername);
        stmnt.setString(2, newUsername);
        stmnt.execute();
    }
    
    public static void editBannedReason(int idBanned, int idBannedReason) throws SQLException 
    {        
        String host = "jdbc:oracle:thin:@localhost:1521:DB";
        String uName = "ADM";
        String uPass = "ADM";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call adminUser.editBannesReason(?,?) } ");
        
        stmnt.setInt(1, idBanned);
        stmnt.setInt(2, idBannedReason);
        stmnt.execute();
    }
    
    public static void editBannedReasonDescription(int idBanned, String newDescription) throws SQLException 
    {        
        String host = "jdbc:oracle:thin:@localhost:1521:DB";
        String uName = "ADM";
        String uPass = "ADM";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call adminUser.editBannedReasonDescription(?,?) } ");
        
        stmnt.setInt(1, idBanned);
        stmnt.setString(2, newDescription);
        stmnt.execute();
    }
    
    public static void editUserTypeDescription(int idUserType, String newDescription) throws SQLException 
    {        
        String host = "jdbc:oracle:thin:@localhost:1521:DB";
        String uName = "ADM";
        String uPass = "ADM";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call adminUser.editUserTypeDescription(?,?) } ");
        
        stmnt.setInt(1, idUserType);
        stmnt.setString(2, newDescription);
        stmnt.execute();
    }
    
    public static String getPassword(String username) throws SQLException 
    {        
        String host = "jdbc:oracle:thin:@localhost:1521:DB";
        String uName = "ADM";
        String uPass = "ADM";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ ? = call adminUser.getPassword(?) } ");
        
        stmnt.registerOutParameter(1, OracleTypes.VARCHAR);
        stmnt.setString(2, username);
        stmnt.execute();
        String result = (String) stmnt.getObject(1);
        return result;
    }
    public static int getUserType(String username) throws SQLException 
    {        
        String host = "jdbc:oracle:thin:@localhost:1521:DB";
        String uName = "ADM";
        String uPass = "ADM";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ ? = call adminUser.getUserType(?) } ");
        
        stmnt.registerOutParameter(1, OracleTypes.NUMBER);
        stmnt.setString(2, username);
        stmnt.execute();
        int result = (int) stmnt.getObject(1);
        return result;
    }
    
    public static String getString(String schema, String function, int atributo) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:DB";
        String uName = schema;
        String uPass = schema;
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ ? = call ?(?) } ");
        
        stmnt.registerOutParameter(1, OracleTypes.VARCHAR);
        stmnt.setString(2, function);
        stmnt.setInt(3, atributo);
        stmnt.executeQuery(); 
        String result = (String) stmnt.getObject(1);
        return result;
    }
    
    public static int getInt(String schema, String function, int atributo) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:DB";
        String uName = schema;
        String uPass = schema;
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ ? = call ?(?) } ");
        
        stmnt.registerOutParameter(1, OracleTypes.NUMBER);
        stmnt.setString(2, function);
        stmnt.setInt(3, atributo);
        stmnt.executeQuery(); 
        int result = (int) stmnt.getObject(1);
        return result;
    }
    
    public static Date getDate(String schema, String function, int atributo) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:DB";
        String uName = schema;
        String uPass = schema;
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ ? = call ?(?) } ");
        
        stmnt.registerOutParameter(1, OracleTypes.DATE);
        stmnt.setString(2, function);
        stmnt.setInt(3, atributo);
        stmnt.executeQuery(); 
        Date result = (Date) stmnt.getObject(1);
        return result;
    }
    
    
    
    
    
    
    
    
    
    
    /*public void getUserType(String user_name) throws SQLException 
    {
        String uName = "ADM";
        String uPass = "ADM";
        //Lo dejo así porque no se si hay una funcion que devuelva cursor con todos los datos de user
        //Voy a suponer que esa funcion si existe
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ ? = call adminUser.getUserType(?) } ");
        //CallableStatement stmnt = con.prepareCall("{ ? = call adminUser.getUserAll(?)}");
     
        stmnt.registerOutParameter(1, OracleTypes.NUMBER);
        //stmnt.registerOutParameter(1, OracleTypes.Cursor);
        //stmnt.executeQuery(); creo que es igual a stmnt.execute();
        //ResultSet user = (ResultSet) stmnt.getObject(1);
        //string password = user.getString("password");
        //int idType = (int) user.getString("id_type");
        stmnt.setString(2, user_name);
        stmnt.execute();
        int typeUser = (int) stmnt.getObject(1);
        
    }*/
    
     
    public static ResultSet query(String schema,String function,String atributo) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:DB";
        String uName = schema;
        String uPass = schema;
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ ? = call ?(?) } ");
        
        stmnt.registerOutParameter(1, OracleTypes.CURSOR);
        stmnt.setString(2, function);
        stmnt.setString(3, atributo);
        stmnt.executeQuery(); 
        ResultSet result = (ResultSet) stmnt.getObject(1);
        return result;
    }
    
    public static ResultSet query(String schema,String function,int atributo) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = schema;
        String uPass = schema;
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ ? = call ?(?) } ");
        
        stmnt.registerOutParameter(1, OracleTypes.CURSOR);
        stmnt.setString(2, function);
        stmnt.setInt(3, atributo);
        stmnt.executeQuery(); 
        ResultSet result = (ResultSet) stmnt.getObject(1);
        return result;
    }
    
    public void delete(String schema,String function,String atributo) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:DB";
        String uName = schema;
        String uPass = schema;
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call ?(?) } ");
        
        stmnt.setString(1, function);
        stmnt.setString(2, atributo);
        stmnt.executeQuery(); 
    }
    
    public static void delete(String schema,String function,int atributo) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = schema;
        String uPass = schema;
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call ?(?) } ");
        
        stmnt.setString(1, function);
        stmnt.setInt(2, atributo);
        stmnt.executeQuery(); 
    }
}