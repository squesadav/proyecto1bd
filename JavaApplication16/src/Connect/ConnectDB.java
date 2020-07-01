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
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "ADM";
        String uPass = "ADM";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call adminUser.createUser(?,?,?,?) } ");
        
        stmnt.setString(1, user.getUsername());
        stmnt.setString(2, user.getPassword());
        stmnt.setInt(3, user.getId_userType());
        stmnt.setInt(4, user.person.getId());
        stmnt.execute();
    }
    
    public static void insertBanned(Banned banned) throws SQLException 
    {        
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
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
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "ADM";
        String uPass = "ADM";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call adminUser.createbannedreason(?) } ");
        
        stmnt.setString(1, bannedreason.getDescription());
        stmnt.execute();
    }
    
    public static void insertUserType(UserType usertype) throws SQLException 
    {        
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "ADM";
        String uPass = "ADM";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call adminUser.createUsertype(?) } ");
        
        stmnt.setString(1, usertype.getDescription());
        stmnt.execute();
    }
    
    public static void editUserPassword(String username, String oldPassword, String newPassword) throws SQLException 
    {        
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
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
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
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
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
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
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
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
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
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
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
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
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
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
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call admin_city.update_city(?,?, ?) } ");
        
        stmnt.setInt(1, city.getId());
        stmnt.setString(2, city.getName());
        stmnt.setInt(2, city.getId_state());
        stmnt.execute();
    }
    
    public static void insert_country(Country country) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call admin_country.insert_country(?) } ");
        
        stmnt.setString(1, country.getName());
        stmnt.execute();
    }
    
    public static void update_country(Country country) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
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
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
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
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call admin_district.update_district(?,?,?) } ");
        
        stmnt.setInt(1, district.getId());
        stmnt.setString(2, district.getName());
        stmnt.setInt(3, district.getId_city());
        stmnt.execute();
    }

    public static void insert_gender(Gender gender) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call admin_gender.insert_gender(?) } ");
        
        stmnt.setString(1, gender.getName());
        stmnt.execute();
    }

    public static void update_gender(Gender gender) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call admin_gender.update_gender(?,?) } ");
        
        stmnt.setInt(1, gender.getId());
        stmnt.setString(2, gender.getName());
        stmnt.execute();
    }

    public static void insert_institution(Institution institution) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call admin_intitution.insert_institution(?) } ");
        
        stmnt.setString(1, institution.getName());
        stmnt.execute();
    }

    public static void update_institution(Institution institution) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call admin_institution.update_institution(?,?) } ");
        
        stmnt.setInt(1, institution.getId());
        stmnt.setString(2, institution.getName());
        stmnt.execute();
    }
    
    public static void insert_person(Person person) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call admin_person.insert_person(?,?,?,?,?,?,?,?) } ");
        
        stmnt.setInt(1, person.getId());
        stmnt.setString(2, person.getName());
        stmnt.setString(3, person.getMiddle_name());
        stmnt.setString(4, person.getLast_name());
        stmnt.setDate(5, (Date) person.getBirthday());
        stmnt.setInt(6, person.getId_gender());
        stmnt.setInt(7, person.getId_institution());
        stmnt.setInt(8, person.getId_district());
        stmnt.execute();
    }

    public static void update_person(Person person) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call admin_person.update_person(?,?,?,?,?,?,?,?) } ");
        
        stmnt.setInt(1, person.getId());
        stmnt.setString(2, person.getName());
        stmnt.setString(3, person.getMiddle_name());
        stmnt.setString(4, person.getLast_name());
        stmnt.setDate(5, (Date) person.getBirthday());
        stmnt.setInt(6, person.getId_gender());
        stmnt.setInt(7, person.getId_institution());
        stmnt.setInt(8, person.getId_district());
        stmnt.execute();
    }

    public static void insert_picture(Pictures picture) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call admin_picture.insert_picture(?,?) } ");
        
        stmnt.setString(1, picture.getPic());
        stmnt.setString(2, picture.getNumberr());
        stmnt.execute();
    }

    public static void update_picture(Pictures picture) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call admin_picture.update_picture(?,?,?) } ");
        
        stmnt.setInt(1, picture.getId());
        stmnt.setString(2, picture.getPic());
        stmnt.setString(3, picture.getNumberr());
        stmnt.execute();
    }
    
    public static void insert_place(Place place) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call admin_place.insert_place(?) } ");
        
        stmnt.setString(1, place.getName());
        stmnt.execute();
    }

    public static void update_place(Place place) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call admin_place.update_place(?,?) } ");
        
        stmnt.setInt(1, place.getId());
        stmnt.setString(2, place.getName());
        stmnt.execute();
    }
    
    public static void approve_record(String number) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call admin_record.approve_record(?) } ");
        
        stmnt.setString(1, number);
        stmnt.execute();
    }

    public static void insert_record(BL.Record record) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call admin_record.insert_record(?,?,?,?,?,?,?,?,?,?)}");
        
        stmnt.setString(1, record.getNumber());
        stmnt.setString(2, record.getDescription_crime());
        stmnt.setDate(3, (Date) record.getDate_crime());
        stmnt.setString(4, record.getResolution());
        stmnt.setDate(5, (Date) record.getCrime_expiration_date());
        stmnt.setString(6, record.isApproved());
        stmnt.setInt(7, record.getId_type());
        stmnt.setInt(8, record.getId_veredict());
        stmnt.setInt(9, record.getId_person());
        stmnt.setInt(10, record.getId_district());
        stmnt.execute();
    }

    public static void update_record(BL.Record record) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call admin_record.update_record(?,?,?,?,?,?,?,?,?,?)}");
        
        stmnt.setString(1, record.getNumber());
        stmnt.setString(2, record.getDescription_crime());
        stmnt.setDate(3, (Date) record.getDate_crime());
        stmnt.setString(4, record.getResolution());
        stmnt.setDate(5, (Date) record.getCrime_expiration_date());
        stmnt.setString(6, record.isApproved());
        stmnt.setInt(7, record.getId_type());
        stmnt.setInt(8, record.getId_veredict());
        stmnt.setInt(9, record.getId_person());
        stmnt.setInt(10, record.getId_district());
        stmnt.execute();
    }

    public static void insert_state(State state) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call admin_state.insert_state(?,?) } ");
        
        stmnt.setString(1, state.getName());
        stmnt.setInt(2, state.getId_country());
        stmnt.execute();
    }

    public static void update_state(State state) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call admin_state.update_state(?,?) } ");
        
        stmnt.setInt(1, state.getId());
        stmnt.setString(2, state.getName());
        stmnt.setInt(3, state.getId_country());
        stmnt.execute();
    }

    public static void insert_type(Types type) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call admin_type.insert_type(?) } ");
        
        stmnt.setString(1, type.getName());
        stmnt.execute();
    }

    public static void update_type(Types type) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call admin_type.update_type(?,?) } ");
        
        stmnt.setInt(1, type.getId());
        stmnt.setString(1, type.getName());
        stmnt.execute();
    }

    public static void insert_veredict(Veredict veredict) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call admin_veredict.insert_veredict(?,?,?,?) } ");
        
        stmnt.setInt(1, veredict.getYears());
        stmnt.setInt(2, veredict.getId_place());
        stmnt.setDate(3, (Date) veredict.getDate_start());
        stmnt.setDate(4, (Date) veredict.getDate_end());
        stmnt.execute();
    }

    public static void update_veredict(Veredict veredict) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call admin_veredict.update_veredict(?,?,?,?,?) } ");
        
        stmnt.setInt(1, veredict.getId());
        stmnt.setInt(2, veredict.getYears());
        stmnt.setInt(3, veredict.getId_place());
        stmnt.setDate(4, (Date) veredict.getDate_start());
        stmnt.setDate(5, (Date) veredict.getDate_end());
        stmnt.execute();
    }
    
    public static String getString(String schema, String function, int atributo) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = schema;
        String uPass = schema;
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ ? = call " + function + "(?) } ");
        
        stmnt.registerOutParameter(1, OracleTypes.VARCHAR);
        stmnt.setInt(2, atributo);
        stmnt.executeQuery(); 
        String result = (String) stmnt.getString(1);
        return result;
    }
    
    public static int getInt(String schema, String function, int atributo) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = schema;
        String uPass = schema;
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ ? = call " + function + "(?) } ");
        
        stmnt.registerOutParameter(1, OracleTypes.NUMBER);
        stmnt.setInt(2, atributo);
        stmnt.executeQuery(); 
        int result = (int) stmnt.getInt(1);
        return result;
    }
    
    public static Date getDate(String schema, String function, int atributo) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = schema;
        String uPass = schema;
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ ? = call " + function + "(?) } ");
        
        stmnt.registerOutParameter(1, OracleTypes.DATE);
        stmnt.setInt(2, atributo);
        stmnt.executeQuery(); 
        Date result = (Date) stmnt.getDate(1);
        return result;
    } 
     
    public static String getString(String schema, String function, String atributo) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = schema;
        String uPass = schema;
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ ? = call " + function + "(?) } ");
        
        stmnt.registerOutParameter(1, OracleTypes.VARCHAR);
        stmnt.setString(2, atributo);
        stmnt.executeQuery(); 
        String result = (String) stmnt.getString(1);
        return result;
    }
    
    public static int getInt(String schema, String function, String atributo) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = schema;
        String uPass = schema;
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ ? = call " + function + "(?) } ");
        
        stmnt.registerOutParameter(1, OracleTypes.NUMBER);
        stmnt.setString(2, atributo);
        stmnt.executeQuery(); 
        int result = (int) stmnt.getInt(1);
        return result;
    }
    
    public static Date getDate(String schema, String function, String atributo) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = schema;
        String uPass = schema;
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ ? = call " + function + "(?) } ");
        
        stmnt.registerOutParameter(1, OracleTypes.DATE);
        stmnt.setString(2, atributo);
        stmnt.executeQuery(); 
        Date result = (Date) stmnt.getDate(1);
        return result;
    }
    
    public static ResultSet query(String schema,String function,String atributo) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = schema;
        String uPass = schema;
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ ? = call " + function + "(?) } ");
        
        stmnt.registerOutParameter(1, OracleTypes.CURSOR);
        stmnt.setString(2, atributo);
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
        CallableStatement stmnt = con.prepareCall("{ ? = call " + function + "(?) } ");
        
        stmnt.registerOutParameter(1, OracleTypes.CURSOR);
        stmnt.setInt(2, atributo);
        stmnt.executeQuery(); 
        ResultSet result = (ResultSet) stmnt.getObject(1);
        return result;
    }
    
    public static ResultSet query(String schema,String function) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = schema;
        String uPass = schema;
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ ? = call " + function + " } ");
        
        stmnt.registerOutParameter(1, OracleTypes.CURSOR);
        stmnt.executeQuery(); 
        ResultSet result = (ResultSet) stmnt.getObject(1);
        return result;
    }
   
    public void delete(String schema,String function,String atributo) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = schema;
        String uPass = schema;
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call " + function + "(?) } ");
        
        stmnt.setString(1, atributo);
        stmnt.executeQuery(); 
    }
    
    public static void delete(String schema,String function,int atributo) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = schema;
        String uPass = schema;
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ call " + function + "(?) } ");
        
        stmnt.setInt(1, atributo);
        stmnt.executeQuery(); 
    }

    public static String isBanned(String username) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "ADM";
        String uPass = "ADM";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ ? = call adminUser.isBanned(?) } ");
        
        stmnt.registerOutParameter(1, OracleTypes.VARCHAR);
        stmnt.setString(2, username);
        String result = (String) stmnt.getString(1);
        stmnt.executeQuery(); 
        return result;
    }

    public static int checkLogin(String username, String password) throws SQLException 
    {
        int result = 0;
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "ADM";
        String uPass = "ADM";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ ? = call adminUser.checkLogin(?,?) } ");
        
        stmnt.registerOutParameter(1, OracleTypes.NUMBER);
        stmnt.setString(2, username);
        stmnt.setString(3, password);
        stmnt.executeQuery(); 
        result = stmnt.getInt(1);
        return result;
    }
    
    public static ResultSet records_by_district(int idCity, int idState, int idCountry) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "ADM";
        String uPass = "ADM";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ ? = call statistics.records_by_district(?,?,?)} ");
        
        stmnt.registerOutParameter(1, OracleTypes.CURSOR);
        stmnt.setInt(2, idCity);
        stmnt.setInt(3, idState);
        stmnt.setInt(4, idCountry);
        stmnt.executeQuery(); 
        ResultSet result = (ResultSet) stmnt.getObject(1);
        return result;
    }

    public static ResultSet records_by_city(int idState, int idCountry) throws SQLException 
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "ADM";
        String uPass = "ADM";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ ? = call statistics.records_by_city(?,?)} ");
        
        stmnt.registerOutParameter(1, OracleTypes.CURSOR);
        stmnt.setInt(2, idState);
        stmnt.setInt(3, idCountry);
        stmnt.executeQuery(); 
        ResultSet result = (ResultSet) stmnt.getObject(1);
        return result;
    }

    public static ResultSet criminals_by_district(int idCity, int idState, int idCountry) throws SQLException
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "ADM";
        String uPass = "ADM";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ ? = call statistics.criminals_by_district(?,?,?)} ");
        
        stmnt.registerOutParameter(1, OracleTypes.CURSOR);
        stmnt.setInt(2, idCity);
        stmnt.setInt(3, idState);
        stmnt.setInt(4, idCountry);
        stmnt.executeQuery(); 
        ResultSet result = (ResultSet) stmnt.getObject(1);
        return result;
    }

    public static ResultSet criminals_by_city(int idState, int idCountry) throws SQLException
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "ADM";
        String uPass = "ADM";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ ? = call statistics.criminals_by_city(?,?)} ");
        
        stmnt.registerOutParameter(1, OracleTypes.CURSOR);
        stmnt.setInt(2, idState);
        stmnt.setInt(3, idCountry);
        stmnt.executeQuery(); 
        ResultSet result = (ResultSet) stmnt.getObject(1);
        return result;
    }

    public static ResultSet passwords_not_changed(int numberDays, String first_name, String last_name, int id_person, String username) throws SQLException
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ ? = call admin_queries.passwords_not_changed(?,?,?,?,?)} ");
        
        stmnt.registerOutParameter(1, OracleTypes.CURSOR);
        stmnt.setInt(2, numberDays);
        stmnt.setString(3, first_name);
        stmnt.setString(4, last_name);
        stmnt.setInt(5, id_person);
        stmnt.setString(6, username);
        stmnt.executeQuery(); 
        ResultSet result = (ResultSet) stmnt.getObject(1);
        return result;
    }

    public static ResultSet recordsByClassification(int id_type, Date date_start, Date date_end, int idDistrict, int idCity, int idState, int idCountry) throws SQLException
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ ? = call user_queries.recordsByClassification(?,?,?,?,?)} ");
        
        stmnt.registerOutParameter(1, OracleTypes.CURSOR);
        stmnt.setInt(2, id_type);
        stmnt.setDate(3, date_start);
        stmnt.setDate(4, date_end);
        stmnt.setInt(5, idDistrict);
        stmnt.setInt(6, idCity);
        stmnt.setInt(7, idState);
        stmnt.setInt(8, idCountry);
        stmnt.executeQuery(); 
        ResultSet result = (ResultSet) stmnt.getObject(1);
        return result;
    }

    public static ResultSet getSubtotal(int id_type, Date date_start, Date date_end, int idDistrict, int idCity, int idState, int idCountry) throws SQLException
    {
        String host = "jdbc:oracle:thin:@localhost:1521:PROYECTO1";
        String uName = "APP";
        String uPass = "APP";
        
        Connection con = DriverManager.getConnection(host, uName, uPass);
        CallableStatement stmnt = con.prepareCall("{ ? = call user_queries.getSubtotal(?,?,?,?,?)} ");
        
        stmnt.registerOutParameter(1, OracleTypes.CURSOR);
        stmnt.setInt(2, id_type);
        stmnt.setDate(3, date_start);
        stmnt.setDate(4, date_end);
        stmnt.setInt(5, idDistrict);
        stmnt.setInt(6, idCity);
        stmnt.setInt(7, idState);
        stmnt.setInt(8, idCountry);
        stmnt.executeQuery(); 
        ResultSet result = (ResultSet) stmnt.getObject(1);
        return result;
    }

}