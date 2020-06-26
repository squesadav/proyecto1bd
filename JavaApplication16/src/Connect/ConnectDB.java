package Connect;
import BL.*;
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
    
    public static void insert_city(City city) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:DB";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call admin_city.insert_city(?, ? ) } ");
        
        stmnt.setString(1, city.getName());
        stmnt.setInt(2, city.getId_state());
        stmnt.execute();
    }
    
    public static void update_city(City city) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:DB";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call admin_city.update_city(?,?, ?) } ");
        
        stmnt.setInt(1, city.getId());
        stmnt.setString(2, city.getName());
        stmnt.setInt(2, city.getId_state());
        stmnt.execute();
    }
    
    public static void insert_community(Community community) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:DB";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call admin_community.insert_community(?, ? ) } ");
        
        stmnt.setString(1, community.getName());
        stmnt.setInt(2, community.getId_district());
        stmnt.execute();
    }
    
    public static void update_community(Community community) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:DB";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call admin_city.update_community(?, ? ) } ");
        
        stmnt.setString(1, community.getName());
        stmnt.setInt(2, community.getId_district());
        stmnt.execute();
    }
    
    public static void insert_country(Country country) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:DB";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call admin_country.insert_country(?) } ");
        
        stmnt.setString(1, country.getName());
        stmnt.execute();
    }
    
    public static void update_country(Country country) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:DB";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call admin_country.update_country(?,?) } ");
        
        stmnt.setInt(1,country.getId());
        stmnt.setString(2, country.getName());
        stmnt.execute();
    }
    
    public static void insert_district(District district) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:DB";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call admin_district.insert_district(?,?) } ");
        
        stmnt.setString(1, district.getName());
        stmnt.setInt(2, district.getId_city());
        stmnt.execute();
    }
    
    public static void update_district(District district) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:DB";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call admin_district.update_district(?,?,?) } ");
        
        stmnt.setInt(1, district.getId());
        stmnt.setString(2, district.getName());
        stmnt.setInt(3, district.getId_city());
        stmnt.execute();
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
     
    public static String getString(String schema, String function, String atributo) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:DB";
        String uName = schema;
        String uPass = schema;
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ ? = call ?(?) } ");
        
        stmnt.registerOutParameter(1, OracleTypes.VARCHAR);
        stmnt.setString(2, function);
        stmnt.setString(3, atributo);
        stmnt.executeQuery(); 
        String result = (String) stmnt.getObject(1);
        return result;
    }
    
    public static int getInt(String schema, String function, String atributo) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:DB";
        String uName = schema;
        String uPass = schema;
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ ? = call ?(?) } ");
        
        stmnt.registerOutParameter(1, OracleTypes.NUMBER);
        stmnt.setString(2, function);
        stmnt.setString(3, atributo);
        stmnt.executeQuery(); 
        int result = (int) stmnt.getObject(1);
        return result;
    }
    
    public static Date getDate(String schema, String function, String atributo) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:DB";
        String uName = schema;
        String uPass = schema;
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ ? = call ?(?) } ");
        
        stmnt.registerOutParameter(1, OracleTypes.DATE);
        stmnt.setString(2, function);
        stmnt.setString(3, atributo);
        stmnt.executeQuery(); 
        Date result = (Date) stmnt.getObject(1);
        return result;
    }
    
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