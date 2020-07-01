
package javaapplication16.Frame;
import BL.*;
import Connect.ConnectDB;
import java.awt.Color;
import java.awt.Cursor;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.jfree.chart.JFreeChart;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Login extends javax.swing.JFrame {

    void fillInComboBox_signIn() throws SQLException
    {
        ResultSet genders = null;
        ResultSet district = null;
        ResultSet institutions = null;
        ResultSet type = null;
        try
        {
            genders = ConnectDB.query("APP","admin_gender.getAll");
            district = ConnectDB.query("APP","admin_district.getAll");
            institutions = ConnectDB.query("APP","admin_institution.getAll");
            type = ConnectDB.query("ADM","adminUser.getAllUserType");
        }
        catch(Exception e)
        {
        }
        while(genders.next())
        {
            BoxGenderNewUser.addItem(genders.getString("name"));
        }
        while(district.next())
        {
            BoxNewUserDistrict.addItem(district.getString("name"));
        }
        while(institutions.next())
        {
            BoxInstitutionNewUser.addItem(institutions.getString("name"));
        }
        while(type.next())
        {
            BoxUserTypeNewUser.addItem(type.getString("name"));
        }
    }
    
    void fillInComboBox_Offender() throws SQLException
    {
        ResultSet genders = null;
        ResultSet districts = null;
        ResultSet institutions = null;
        try
        {
            genders = ConnectDB.query("APP", "admin_gender.getAll");
            districts = ConnectDB.query("APP","admin_district.getAll");
            institutions = ConnectDB.query("APP","admin_institution.getAll");
        }
        catch(Exception e)
        {
            
        }
        while(genders.next())
        {
            BoxGenderOffender.addItem(genders.getString("name"));
        }
        while(districts.next())
        {
            BoxDistrictOffender.addItem(districts.getString("name"));
        }
        while(institutions.next())
        {
            BoxInstitutionOffender.addItem(institutions.getString("name"));
        }
    }
    
    void fillInComboBox_UserCatalogues() throws SQLException
    {
        ResultSet userType = null;
        ResultSet BannedReason = null;
        try
        {
            userType = ConnectDB.query("ADM", "adminUser.getAllUserType");
            BannedReason = ConnectDB.query("ADM","admin_district.getAllBannedReason");
        }
        catch(Exception e)
        {
            
        }
        while(userType.next())
        {
            BoxGenderOffender.addItem(userType.getString("name"));
        }
        while(BannedReason.next())
        {
            BoxDistrictOffender.addItem(BannedReason.getString("name"));
        }
    }
    
    void fillInPersonCatalogues() throws SQLException
    {
        ResultSet genders = null;
        ResultSet institutions = null;
        ResultSet countries = null;
        ResultSet states = null;
        ResultSet cities = null;
        try
        {
            genders = ConnectDB.query("APP", "admin_gender.getAll");
            institutions = ConnectDB.query("APP","admin_institution.getAll");
            countries = ConnectDB.query("APP","admin_country.getAll");
            states = ConnectDB.query("APP","admin_states.getAll");
            cities = ConnectDB.query("APP","admin_cities.getAll");
        }
        catch(Exception e){}
        while(genders.next())
        {
            BoxModifyGender.addItem(genders.getString("name"));
        }
        while(institutions.next())
        {
            BoxModifyInstitution.addItem(institutions.getString("name"));
        }
        while(countries.next())
        {
            BoxModifyCountry.addItem(countries.getString("name"));
        }
        while(states.next())
        {
            BoxModifyState.addItem(states.getString("name"));
        }
        while(cities.next())
        {
            BoxModifyCity.addItem(cities.getString("name"));
        }
    }
    
     void fillInZones() throws SQLException
    {
        ResultSet districts = null;
        ResultSet countries = null;
        ResultSet states = null;
        ResultSet cities = null;
        try
        {
            districts = ConnectDB.query("APP","admin_institution.getAll");
            countries = ConnectDB.query("APP","admin_country.getAll");
            states = ConnectDB.query("APP","admin_states.getAll");
            cities = ConnectDB.query("APP","admin_cities.getAll");
        }
        catch(Exception e){}
        while(districts.next())
        {
            BoxDistrict.addItem(districts.getString("name"));
        }
        while(countries.next())
        {
            BoxCountry.addItem(countries.getString("name"));
        }
        while(states.next())
        {
            BoxState.addItem(states.getString("name"));
        }
        while(cities.next())
        {
            BoxCity.addItem(cities.getString("name"));
        }
    }
    
    void fillIn_Records() throws SQLException
    {
        ResultSet types = null;
        ResultSet districts = null;
        try
        {
            types = ConnectDB.query("APP", "admin_type.getAll");
            districts = ConnectDB.query("APP","admin_institution.getAll");
        }
        catch(Exception e){}
        while(types.next())
        {
            BoxFilter.addItem(types.getString("name"));
        }
        while(districts.next())
        {
            BoxFilterSpecify.addItem(districts.getString("name"));
        }
    }
    
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPWelcome = new javax.swing.JPanel();
        LabelWelcome = new javax.swing.JLabel();
        JPLogin = new javax.swing.JPanel();
        LabelPassword = new javax.swing.JLabel();
        LabelUsername = new javax.swing.JLabel();
        IconUser = new javax.swing.JLabel();
        UsernameField = new javax.swing.JTextField();
        PasswordField = new javax.swing.JPasswordField();
        LineUsername = new javax.swing.JSeparator();
        LinePassword = new javax.swing.JSeparator();
        ButtonEnter = new javax.swing.JButton();
        IconPassword = new javax.swing.JLabel();
        IconUsername = new javax.swing.JLabel();
        ButtonSignUp = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        JPSignUp = new javax.swing.JPanel();
        LabelSignUp = new javax.swing.JLabel();
        LabelNewUserPassword = new javax.swing.JLabel();
        LabelNewUsername = new javax.swing.JLabel();
        LabelIdNewUser = new javax.swing.JLabel();
        LabelNameNewUser = new javax.swing.JLabel();
        LabelMiddleNameNewUser = new javax.swing.JLabel();
        LabelLastNameNewUser = new javax.swing.JLabel();
        LabelNewUserGender = new javax.swing.JLabel();
        LabelNewUserBirthday = new javax.swing.JLabel();
        LabelCommunityNewUser = new javax.swing.JLabel();
        LabelInstitutionNewUser = new javax.swing.JLabel();
        LineNewUsername = new javax.swing.JSeparator();
        NewUsernameField = new javax.swing.JTextField();
        LineNewUserPassword = new javax.swing.JSeparator();
        NewUserPasswordField = new javax.swing.JTextField();
        LineNewUserId = new javax.swing.JSeparator();
        IdNewUserField = new javax.swing.JTextField();
        LineNewUserName = new javax.swing.JSeparator();
        NameNewUserField = new javax.swing.JTextField();
        LineNewUserMiddleName = new javax.swing.JSeparator();
        MiddleNameNewUserField = new javax.swing.JTextField();
        LineNewUserLastName = new javax.swing.JSeparator();
        LastNameNewUserField = new javax.swing.JTextField();
        BoxGenderNewUser = new javax.swing.JComboBox<>();
        BoxNewUserDistrict = new javax.swing.JComboBox<>();
        BoxInstitutionNewUser = new javax.swing.JComboBox<>();
        ButtonCancel = new javax.swing.JButton();
        ButtonJoin = new javax.swing.JButton();
        LabelNewUserUserType = new javax.swing.JLabel();
        BoxUserTypeNewUser = new javax.swing.JComboBox<>();
        LineOffenderBirthday2 = new javax.swing.JSeparator();
        NewUserBirthday = new javax.swing.JFormattedTextField();
        JPWindow = new javax.swing.JPanel();
        ButtonMinimize = new javax.swing.JButton();
        ButtonClose = new javax.swing.JButton();
        JPLogged = new javax.swing.JPanel();
        IconLogged = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        JPAdminMenu = new javax.swing.JPanel();
        ButtonStatistics = new javax.swing.JButton();
        ButtonLogOutAdminUser = new javax.swing.JButton();
        ButtonAdminQuery = new javax.swing.JButton();
        ButtonAdminConfiguration = new javax.swing.JButton();
        AdminQuery = new javax.swing.JTabbedPane();
        UserListNotChangingPassword = new javax.swing.JPanel();
        LabelChooseFilterUserListNotChangePassword = new javax.swing.JLabel();
        BoxFilterIdPerson = new javax.swing.JComboBox<>();
        BoxFilterNamePerson = new javax.swing.JComboBox<>();
        ButtonShowFilteredUserList = new javax.swing.JButton();
        BoxFilterLastNamePerson = new javax.swing.JComboBox<>();
        LabelFilterIdPerson = new javax.swing.JLabel();
        LabelFilterNamePerson = new javax.swing.JLabel();
        LabelFilterLastNamePerson = new javax.swing.JLabel();
        LabelFilterUsername = new javax.swing.JLabel();
        BoxFilterUsernamePerson = new javax.swing.JComboBox<>();
        ButtonRollbackUserListNotChangePassword = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TableUsersPassword = new javax.swing.JTable();
        ReportList = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        NewReportList = new javax.swing.JList<>();
        jScrollPane11 = new javax.swing.JScrollPane();
        ReportInformation = new javax.swing.JTextArea();
        PictureNewReportList = new javax.swing.JButton();
        RightPicNewReportList = new javax.swing.JButton();
        LeftPicNewReportList = new javax.swing.JButton();
        ButtonRollbackReportList = new javax.swing.JButton();
        LabelChooseFilterUserListNotChangePassword2 = new javax.swing.JLabel();
        LabelChooseFilterUserListNotChangePassword3 = new javax.swing.JLabel();
        ButtonShowListOfReports = new javax.swing.JButton();
        Log = new javax.swing.JPanel();
        BoxLogStartDate = new javax.swing.JComboBox<>();
        BoxLogFinishDate = new javax.swing.JComboBox<>();
        LabelChooseFilterUserListNotChangePassword1 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        LogUserList = new javax.swing.JList<>();
        ButtonLogUserList = new javax.swing.JButton();
        ButtonRollbackLog = new javax.swing.JButton();
        AdminConfiguration = new javax.swing.JTabbedPane();
        UpdateAdminLoginInfo = new javax.swing.JPanel();
        LabelAdminPasswordUpdateLogin = new javax.swing.JLabel();
        LabelAdminUsernameUpdateLogin = new javax.swing.JLabel();
        LineUpdateAdminUsername = new javax.swing.JSeparator();
        AdminUpdateUsernameField = new javax.swing.JTextField();
        LineUpdateAdminPassword = new javax.swing.JSeparator();
        AdminUpdatePasswordField = new javax.swing.JTextField();
        ButtonCancelUpdatesUserLoginAdmin = new javax.swing.JButton();
        ButtonConfirmChangesAdmin = new javax.swing.JButton();
        IconUpdateUsernameAdmin = new javax.swing.JLabel();
        IconUpdatePasswordAdmin = new javax.swing.JLabel();
        LabelAdminUpdateLoginFields = new javax.swing.JLabel();
        LabelUpdateAdminUserType = new javax.swing.JLabel();
        BoxAdminUserTypeUpdate = new javax.swing.JComboBox<>();
        ActualUsername = new javax.swing.JTextField();
        LineUpdateAdminUsername1 = new javax.swing.JSeparator();
        LabelAdminUsernameUpdateLogin1 = new javax.swing.JLabel();
        UpdateAdminPersonalInfo = new javax.swing.JPanel();
        LabelUpdateAdminId = new javax.swing.JLabel();
        LabelUpdateAdminNameUpdate = new javax.swing.JLabel();
        LabelUpdateAdminMiddleName = new javax.swing.JLabel();
        LabelUpdateAdminLastName = new javax.swing.JLabel();
        LabelUpdateAdminCommunity = new javax.swing.JLabel();
        LabelUpdateAdminInstitution = new javax.swing.JLabel();
        LabelUpdateAdminGender = new javax.swing.JLabel();
        LabelUpdateAdminBirthday = new javax.swing.JLabel();
        LineUpdateAdminId = new javax.swing.JSeparator();
        UpdateAdminIdField = new javax.swing.JTextField();
        LineUpdateAdminName = new javax.swing.JSeparator();
        UpdateAdminNameField = new javax.swing.JTextField();
        LineUpdateAdminMiddleName = new javax.swing.JSeparator();
        UpdateAdminMiddleNameField = new javax.swing.JTextField();
        LineUpdateAdminLastName = new javax.swing.JSeparator();
        UpdateAdminLastNameField = new javax.swing.JTextField();
        LineAdminBirthday = new javax.swing.JSeparator();
        UpdateAdminBirthdayField = new javax.swing.JFormattedTextField();
        BoxDistrictAdminUpdate = new javax.swing.JComboBox<>();
        BoxInstitutionAdminUpdate = new javax.swing.JComboBox<>();
        BoxGenderAdminUpdate = new javax.swing.JComboBox<>();
        ButtonCancelUpdatesAdminInfo = new javax.swing.JButton();
        ButtonConfirmChangesUpdateAdminPersonalInfo = new javax.swing.JButton();
        IconUpdateUsername6 = new javax.swing.JLabel();
        IconUpdateUsername7 = new javax.swing.JLabel();
        IconUpdateUsername8 = new javax.swing.JLabel();
        IconUpdateUsername9 = new javax.swing.JLabel();
        IconUpdateUsername10 = new javax.swing.JLabel();
        LabelUserUpdateLogin3 = new javax.swing.JLabel();
        AdminCatalogues = new javax.swing.JPanel();
        ButtonUserCatalogues = new javax.swing.JButton();
        ButtonPersonCatalogues = new javax.swing.JButton();
        ButtonRecordCatalogues = new javax.swing.JButton();
        ButtonRollbackCatalogues = new javax.swing.JButton();
        ApproveRecords = new javax.swing.JPanel();
        LabelApproveRecords = new javax.swing.JLabel();
        LabelResolutionUnapproved = new javax.swing.JLabel();
        LabelVeredictUnapproved = new javax.swing.JLabel();
        LabelOffenderUnapproved = new javax.swing.JLabel();
        LabelCrimeTypeUnapproved = new javax.swing.JLabel();
        LabelDateCrimeUnapproved = new javax.swing.JLabel();
        LineResolution2 = new javax.swing.JSeparator();
        LineDateCrime2 = new javax.swing.JSeparator();
        UnapprovedDateCrimeField = new javax.swing.JFormattedTextField();
        ButtonCancelUnapproved = new javax.swing.JButton();
        ButtonBanUser = new javax.swing.JButton();
        jScrollPane16 = new javax.swing.JScrollPane();
        UnapprovedCrimeDescriptionField = new javax.swing.JTextArea();
        CheckBoxApprovedOrNot = new javax.swing.JCheckBox();
        UnapprovedExpireDateField = new javax.swing.JFormattedTextField();
        LineExpireDate2 = new javax.swing.JSeparator();
        LabelExpireDateUnapproved = new javax.swing.JLabel();
        PictureUnapproved = new javax.swing.JButton();
        UnapprovedResolutionField = new javax.swing.JTextField();
        RightUnapprovedPic = new javax.swing.JButton();
        LeftUnapprovedPic = new javax.swing.JButton();
        AddUnapprovedPic = new javax.swing.JButton();
        RemoveUnapprovedPic = new javax.swing.JButton();
        jScrollPane17 = new javax.swing.JScrollPane();
        ListUnapprovedRecords = new javax.swing.JList<>();
        LabelCrimeDescriptionUnapproved = new javax.swing.JLabel();
        ButtonConfirmUnapproved = new javax.swing.JButton();
        ButtonRefresh = new javax.swing.JButton();
        UnapprovedVeredictField = new javax.swing.JTextField();
        LineResolution3 = new javax.swing.JSeparator();
        LineResolution4 = new javax.swing.JSeparator();
        UnapprovedIdOffender = new javax.swing.JTextField();
        UnapprovedTypeField = new javax.swing.JTextField();
        LineResolution5 = new javax.swing.JSeparator();
        UserCatalogues = new javax.swing.JPanel();
        BoxModifyUserType = new javax.swing.JComboBox<>();
        LabelUserType = new javax.swing.JLabel();
        BoxModifyBannedReason = new javax.swing.JComboBox<>();
        LabelBannedReason = new javax.swing.JLabel();
        AddUserTypeCatalogue = new javax.swing.JButton();
        RemoveUserType = new javax.swing.JButton();
        AddBannedReason = new javax.swing.JButton();
        RemoveBannedReason = new javax.swing.JButton();
        ButtonConfirmUserCatalogue = new javax.swing.JButton();
        LabelUserType1 = new javax.swing.JLabel();
        PersonCatalogues = new javax.swing.JPanel();
        BoxModifyGender = new javax.swing.JComboBox<>();
        LabelGender = new javax.swing.JLabel();
        BoxModifyInstitution = new javax.swing.JComboBox<>();
        LabelInstitution = new javax.swing.JLabel();
        AddGender = new javax.swing.JButton();
        RemoveGender = new javax.swing.JButton();
        AddInstitution = new javax.swing.JButton();
        RemoveInstitution = new javax.swing.JButton();
        ButtonConfirmPersonCatalogue = new javax.swing.JButton();
        BoxModifyCountry = new javax.swing.JComboBox<>();
        LabelCountry = new javax.swing.JLabel();
        BoxModifyState = new javax.swing.JComboBox<>();
        LabelState = new javax.swing.JLabel();
        AddCountry = new javax.swing.JButton();
        RemoveCountry = new javax.swing.JButton();
        AddState = new javax.swing.JButton();
        RemoveState = new javax.swing.JButton();
        BoxModifyCity = new javax.swing.JComboBox<>();
        LabelCity = new javax.swing.JLabel();
        AddCity = new javax.swing.JButton();
        RemoveCity = new javax.swing.JButton();
        LabelUserType2 = new javax.swing.JLabel();
        BoxModifyDistrict = new javax.swing.JComboBox<>();
        LabelDistrict = new javax.swing.JLabel();
        AddDistrict = new javax.swing.JButton();
        RemoveDistrict = new javax.swing.JButton();
        RecordCatalogues = new javax.swing.JPanel();
        BoxModifyTypeCrime = new javax.swing.JComboBox<>();
        LabelGender1 = new javax.swing.JLabel();
        AddTypeCrime = new javax.swing.JButton();
        RemoveTypeCrime = new javax.swing.JButton();
        BoxModifyTypeSentence = new javax.swing.JComboBox<>();
        LabelState1 = new javax.swing.JLabel();
        AddTypeSentence = new javax.swing.JButton();
        RemoveTypeSentence = new javax.swing.JButton();
        ButtonCancelRecordCatalogue = new javax.swing.JButton();
        LabelUserType3 = new javax.swing.JLabel();
        AdminStatistics = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        ButtonEnterReportsZone1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        BoxCountry = new javax.swing.JComboBox<>();
        ButtonEnterReportsZone = new javax.swing.JButton();
        BoxState = new javax.swing.JComboBox<>();
        BoxCity = new javax.swing.JComboBox<>();
        BoxDistrict = new javax.swing.JComboBox<>();
        LabelNewUsername1 = new javax.swing.JLabel();
        LabelNewUsername2 = new javax.swing.JLabel();
        LabelNewUsername3 = new javax.swing.JLabel();
        LabelNewUsername4 = new javax.swing.JLabel();
        ButtonRefreshTotalRecordsByZone = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        BoxCountryPersonRecords = new javax.swing.JComboBox<>();
        ButtonEnterPersonRecords = new javax.swing.JButton();
        BoxStatePersonRecords = new javax.swing.JComboBox<>();
        BoxCityPersonRecords = new javax.swing.JComboBox<>();
        BoxDistrictPersonRecords = new javax.swing.JComboBox<>();
        LabelNewUsername5 = new javax.swing.JLabel();
        LabelNewUsername6 = new javax.swing.JLabel();
        LabelNewUsername7 = new javax.swing.JLabel();
        LabelNewUsername8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        JPUserMenu = new javax.swing.JPanel();
        ButtonQuery = new javax.swing.JButton();
        ButtonConfiguration = new javax.swing.JButton();
        ButtonLogOut = new javax.swing.JButton();
        ButtonCreateRecord = new javax.swing.JButton();
        JPCreateOffender = new javax.swing.JPanel();
        LabelIdOffender = new javax.swing.JLabel();
        LabelNameOffender = new javax.swing.JLabel();
        LabelMiddleNameOffender = new javax.swing.JLabel();
        LabelLastNameOffender = new javax.swing.JLabel();
        LabelCommunityOffender = new javax.swing.JLabel();
        LabelInstitutionOffender = new javax.swing.JLabel();
        LabelOffenderGender = new javax.swing.JLabel();
        LabelOffenderBirthday = new javax.swing.JLabel();
        LineOffenderId = new javax.swing.JSeparator();
        IdOffenderField = new javax.swing.JTextField();
        LineOffenderName = new javax.swing.JSeparator();
        NameOffenderField = new javax.swing.JTextField();
        LineOffenderMiddleName = new javax.swing.JSeparator();
        MiddleNameOffenderField = new javax.swing.JTextField();
        LineOffenderLastName = new javax.swing.JSeparator();
        LastNameOffenderField = new javax.swing.JTextField();
        LineOffenderBirthday = new javax.swing.JSeparator();
        BirthdayOffenderField = new javax.swing.JFormattedTextField();
        BoxDistrictOffender = new javax.swing.JComboBox<>();
        BoxInstitutionOffender = new javax.swing.JComboBox<>();
        BoxGenderOffender = new javax.swing.JComboBox<>();
        ButtonCancelOffender = new javax.swing.JButton();
        ButtonConfirmOffender = new javax.swing.JButton();
        IconOffender = new javax.swing.JLabel();
        JPCreateRecord = new javax.swing.JPanel();
        ButtonRollbackCreateRecord = new javax.swing.JButton();
        LabelRecordNumber = new javax.swing.JLabel();
        LabelCrimeDescription = new javax.swing.JLabel();
        LabelResolution = new javax.swing.JLabel();
        LabelVeredict = new javax.swing.JLabel();
        LabelOffender = new javax.swing.JLabel();
        LabelCrimeType = new javax.swing.JLabel();
        LabelDateCrime = new javax.swing.JLabel();
        LineNumberRecord = new javax.swing.JSeparator();
        RecordNumberField = new javax.swing.JTextField();
        LineResolution = new javax.swing.JSeparator();
        LineDateCrime = new javax.swing.JSeparator();
        DateCrimeField = new javax.swing.JFormattedTextField();
        BoxVeredict = new javax.swing.JComboBox<>();
        BoxOffender = new javax.swing.JComboBox<>();
        BoxCrimeType = new javax.swing.JComboBox<>();
        ButtonCancelNewRecord = new javax.swing.JButton();
        ButtonConfirmNewRecord = new javax.swing.JButton();
        IconCreateReacord = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        CrimeDescriptionField = new javax.swing.JTextArea();
        CheckBoxApproved = new javax.swing.JCheckBox();
        ExpireDateField = new javax.swing.JFormattedTextField();
        LineExpireDate = new javax.swing.JSeparator();
        LabelExpireDate = new javax.swing.JLabel();
        PictureNewRecord = new javax.swing.JButton();
        ResolutionField = new javax.swing.JTextField();
        RightNewRecord = new javax.swing.JButton();
        LeftNewRecord = new javax.swing.JButton();
        AddNewRecord = new javax.swing.JButton();
        RemoveNewRecord = new javax.swing.JButton();
        LabelCrimeType1 = new javax.swing.JLabel();
        BoxDistrictRecord = new javax.swing.JComboBox<>();
        UserQuery = new javax.swing.JTabbedPane();
        PlacesMoreRecords = new javax.swing.JPanel();
        LabelTop = new javax.swing.JLabel();
        NumberTopField = new javax.swing.JTextField();
        NumberTopLine = new javax.swing.JSeparator();
        ButtonShowPlaces = new javax.swing.JButton();
        ButtonRollbackQueryPlaces = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        Records = new javax.swing.JPanel();
        LabelChooseFilterRecords = new javax.swing.JLabel();
        BoxFilter = new javax.swing.JComboBox<>();
        BoxFilterSpecify = new javax.swing.JComboBox<>();
        ButtonShowRecords = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        RecordsList = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        RecordDescriptionText = new javax.swing.JTextArea();
        ButtonRollbackQueryRecords = new javax.swing.JButton();
        PictureShowRecords = new javax.swing.JButton();
        RightPicShowRecords = new javax.swing.JButton();
        LeftPicShowRecords = new javax.swing.JButton();
        ButtonShowCatalogues = new javax.swing.JButton();
        DateStartField = new javax.swing.JFormattedTextField();
        LineDateCrime1 = new javax.swing.JSeparator();
        DateEndField = new javax.swing.JFormattedTextField();
        LineDateCrime3 = new javax.swing.JSeparator();
        LabelChooseFilterRecords1 = new javax.swing.JLabel();
        LabelChooseFilterRecords2 = new javax.swing.JLabel();
        UsersList = new javax.swing.JPanel();
        ButtonRollbackQueryUsers = new javax.swing.JButton();
        ButtonShowUsers = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableUsers = new javax.swing.JTable();
        BannedUsers = new javax.swing.JPanel();
        ButtonRollbackQueryBanned = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableBanned = new javax.swing.JTable();
        ButtonShowBanned = new javax.swing.JButton();
        RecordsConvictionsToExpireOrExpired = new javax.swing.JPanel();
        BoxStartDate1 = new javax.swing.JComboBox<>();
        BoxFinishDate1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        RecordDescriptionTextExpire = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        RecordsExpireList = new javax.swing.JList<>();
        ButtonShowRecordsDate = new javax.swing.JButton();
        ButtonRollbackQueryExpire = new javax.swing.JButton();
        PictureRecordToExpire = new javax.swing.JButton();
        RightPicRecordToExpire = new javax.swing.JButton();
        LeftPicRecordToExpire = new javax.swing.JButton();
        UserConfiguration = new javax.swing.JTabbedPane();
        UpdateLoginInfo = new javax.swing.JPanel();
        LabelUserPasswordUpdateLogin = new javax.swing.JLabel();
        LabelUserUpdateLogin = new javax.swing.JLabel();
        LineUpdateUsername = new javax.swing.JSeparator();
        UpdateUsernameField = new javax.swing.JTextField();
        LineUpdatePassword = new javax.swing.JSeparator();
        UpdatePasswordField = new javax.swing.JTextField();
        ButtonCancelUpdatesUserLogin = new javax.swing.JButton();
        ButtonConfirmChanges = new javax.swing.JButton();
        IconUpdateUsername = new javax.swing.JLabel();
        IconUpdatePassword = new javax.swing.JLabel();
        LabelUserUpdateLoginFields = new javax.swing.JLabel();
        LabelUpdateUserType = new javax.swing.JLabel();
        BoxUserTypeUpdateUser = new javax.swing.JComboBox<>();
        UpdatePersonalInfo = new javax.swing.JPanel();
        LabelUpdateId = new javax.swing.JLabel();
        LabelUpdateNameUpdate = new javax.swing.JLabel();
        LabelMiddleNameUpdate = new javax.swing.JLabel();
        LabelLastNameUpdate = new javax.swing.JLabel();
        LabelCommunityUpdate = new javax.swing.JLabel();
        LabelInstitutionUpdate = new javax.swing.JLabel();
        LabelUpdateGender = new javax.swing.JLabel();
        LabelUpdateBirthday = new javax.swing.JLabel();
        LineUpdateId = new javax.swing.JSeparator();
        IdUpdateField = new javax.swing.JTextField();
        LineOffenderName1 = new javax.swing.JSeparator();
        NameUpdateField = new javax.swing.JTextField();
        LineUpdateMiddleName = new javax.swing.JSeparator();
        MiddleNameUpdateField = new javax.swing.JTextField();
        LineUpdateLastName = new javax.swing.JSeparator();
        LastNameUpdateField = new javax.swing.JTextField();
        LineOffenderBirthday1 = new javax.swing.JSeparator();
        BirthdayUpdateField = new javax.swing.JFormattedTextField();
        BoxCommunityUpdate = new javax.swing.JComboBox<>();
        BoxInstitutionUpdate = new javax.swing.JComboBox<>();
        BoxGenderUpdate = new javax.swing.JComboBox<>();
        ButtonCancelUpdatesUserInfo = new javax.swing.JButton();
        ButtonConfirmChangesUpdatePersonalInfo = new javax.swing.JButton();
        IconUpdateUsername1 = new javax.swing.JLabel();
        IconUpdateUsername2 = new javax.swing.JLabel();
        IconUpdateUsername3 = new javax.swing.JLabel();
        IconUpdateUsername4 = new javax.swing.JLabel();
        IconUpdateUsername5 = new javax.swing.JLabel();
        LabelUserUpdateLogin2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JPWelcome.setBackground(new java.awt.Color(255, 255, 255));
        JPWelcome.setForeground(new java.awt.Color(255, 255, 255));
        JPWelcome.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JPWelcome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPWelcomeMouseEntered(evt);
            }
        });
        JPWelcome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelWelcome.setBackground(new java.awt.Color(255, 255, 255));
        LabelWelcome.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 48)); // NOI18N
        LabelWelcome.setForeground(new java.awt.Color(29, 41, 81));
        LabelWelcome.setText("Welcome");
        JPWelcome.add(LabelWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 220, 70));

        getContentPane().add(JPWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 760, 530));

        JPLogin.setBackground(new java.awt.Color(29, 41, 81));
        JPLogin.setForeground(new java.awt.Color(255, 255, 255));
        JPLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPLoginMouseEntered(evt);
            }
        });
        JPLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelPassword.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        LabelPassword.setForeground(new java.awt.Color(255, 255, 255));
        LabelPassword.setText("Password:");
        JPLogin.add(LabelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 90, 20));

        LabelUsername.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        LabelUsername.setForeground(new java.awt.Color(255, 255, 255));
        LabelUsername.setText("Username:");
        JPLogin.add(LabelUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 90, 20));

        IconUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Archive.png"))); // NOI18N
        JPLogin.add(IconUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 130, 150));

        UsernameField.setBackground(new java.awt.Color(29, 41, 81));
        UsernameField.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        UsernameField.setForeground(new java.awt.Color(240, 240, 240));
        UsernameField.setBorder(null);
        JPLogin.add(UsernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 170, 20));

        PasswordField.setBackground(new java.awt.Color(29, 41, 81));
        PasswordField.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        PasswordField.setForeground(new java.awt.Color(255, 255, 255));
        PasswordField.setBorder(null);
        JPLogin.add(PasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 399, 170, 20));
        JPLogin.add(LineUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 210, 10));
        JPLogin.add(LinePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 210, 10));

        ButtonEnter.setBackground(new java.awt.Color(29, 41, 81));
        ButtonEnter.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        ButtonEnter.setForeground(new java.awt.Color(255, 255, 255));
        ButtonEnter.setText("ENTER");
        ButtonEnter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        ButtonEnter.setContentAreaFilled(false);
        ButtonEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEnterActionPerformed(evt);
            }
        });
        JPLogin.add(ButtonEnter, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, 100, 40));

        IconPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Password.png"))); // NOI18N
        JPLogin.add(IconPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 50, 30));

        IconUsername.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/User.png"))); // NOI18N
        JPLogin.add(IconUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 30, 40));

        ButtonSignUp.setBackground(new java.awt.Color(29, 41, 81));
        ButtonSignUp.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        ButtonSignUp.setForeground(new java.awt.Color(255, 255, 255));
        ButtonSignUp.setText("Sign Up");
        ButtonSignUp.setBorder(null);
        ButtonSignUp.setContentAreaFilled(false);
        ButtonSignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonSignUpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonSignUpMouseExited(evt);
            }
        });
        ButtonSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSignUpActionPerformed(evt);
            }
        });
        JPLogin.add(ButtonSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 500, 80, -1));
        JPLogin.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 513, 50, 20));

        getContentPane().add(JPLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 580));

        JPSignUp.setBackground(new java.awt.Color(255, 255, 255));
        JPSignUp.setForeground(new java.awt.Color(255, 255, 255));
        JPSignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPSignUpMouseEntered(evt);
            }
        });
        JPSignUp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelSignUp.setBackground(new java.awt.Color(255, 255, 255));
        LabelSignUp.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        LabelSignUp.setForeground(new java.awt.Color(29, 41, 81));
        LabelSignUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/AddUser.png"))); // NOI18N
        LabelSignUp.setText("Welcome");
        LabelSignUp.setMaximumSize(new java.awt.Dimension(240, 128));
        LabelSignUp.setMinimumSize(new java.awt.Dimension(240, 128));
        JPSignUp.add(LabelSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 260, 130));

        LabelNewUserPassword.setBackground(new java.awt.Color(255, 255, 255));
        LabelNewUserPassword.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelNewUserPassword.setForeground(new java.awt.Color(29, 41, 81));
        LabelNewUserPassword.setText("Password:");
        JPSignUp.add(LabelNewUserPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 100, 30));

        LabelNewUsername.setBackground(new java.awt.Color(255, 255, 255));
        LabelNewUsername.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelNewUsername.setForeground(new java.awt.Color(29, 41, 81));
        LabelNewUsername.setText("Username:");
        JPSignUp.add(LabelNewUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 100, 30));

        LabelIdNewUser.setBackground(new java.awt.Color(255, 255, 255));
        LabelIdNewUser.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelIdNewUser.setForeground(new java.awt.Color(29, 41, 81));
        LabelIdNewUser.setText("Id:");
        JPSignUp.add(LabelIdNewUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 100, 30));

        LabelNameNewUser.setBackground(new java.awt.Color(255, 255, 255));
        LabelNameNewUser.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelNameNewUser.setForeground(new java.awt.Color(29, 41, 81));
        LabelNameNewUser.setText("Name:");
        JPSignUp.add(LabelNameNewUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 100, 30));

        LabelMiddleNameNewUser.setBackground(new java.awt.Color(255, 255, 255));
        LabelMiddleNameNewUser.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelMiddleNameNewUser.setForeground(new java.awt.Color(29, 41, 81));
        LabelMiddleNameNewUser.setText("Middle name:");
        JPSignUp.add(LabelMiddleNameNewUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 120, 30));

        LabelLastNameNewUser.setBackground(new java.awt.Color(255, 255, 255));
        LabelLastNameNewUser.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelLastNameNewUser.setForeground(new java.awt.Color(29, 41, 81));
        LabelLastNameNewUser.setText("Last name:");
        JPSignUp.add(LabelLastNameNewUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 90, 30));

        LabelNewUserGender.setBackground(new java.awt.Color(255, 255, 255));
        LabelNewUserGender.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelNewUserGender.setForeground(new java.awt.Color(29, 41, 81));
        LabelNewUserGender.setText("Gender:");
        JPSignUp.add(LabelNewUserGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 100, 30));

        LabelNewUserBirthday.setBackground(new java.awt.Color(255, 255, 255));
        LabelNewUserBirthday.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelNewUserBirthday.setForeground(new java.awt.Color(29, 41, 81));
        LabelNewUserBirthday.setText("Birthday:");
        JPSignUp.add(LabelNewUserBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 100, 30));

        LabelCommunityNewUser.setBackground(new java.awt.Color(255, 255, 255));
        LabelCommunityNewUser.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelCommunityNewUser.setForeground(new java.awt.Color(29, 41, 81));
        LabelCommunityNewUser.setText("District:");
        JPSignUp.add(LabelCommunityNewUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 100, 30));

        LabelInstitutionNewUser.setBackground(new java.awt.Color(255, 255, 255));
        LabelInstitutionNewUser.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelInstitutionNewUser.setForeground(new java.awt.Color(29, 41, 81));
        LabelInstitutionNewUser.setText("Institution:");
        JPSignUp.add(LabelInstitutionNewUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, 90, 30));

        LineNewUsername.setForeground(new java.awt.Color(29, 41, 81));
        JPSignUp.add(LineNewUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 220, 20));

        NewUsernameField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NewUsernameField.setForeground(new java.awt.Color(29, 41, 81));
        NewUsernameField.setBorder(null);
        JPSignUp.add(NewUsernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 220, 30));

        LineNewUserPassword.setForeground(new java.awt.Color(29, 41, 81));
        JPSignUp.add(LineNewUserPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 220, 20));

        NewUserPasswordField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NewUserPasswordField.setForeground(new java.awt.Color(29, 41, 81));
        NewUserPasswordField.setBorder(null);
        JPSignUp.add(NewUserPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 220, 30));

        LineNewUserId.setForeground(new java.awt.Color(29, 41, 81));
        JPSignUp.add(LineNewUserId, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 220, 20));

        IdNewUserField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        IdNewUserField.setForeground(new java.awt.Color(29, 41, 81));
        IdNewUserField.setBorder(null);
        JPSignUp.add(IdNewUserField, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 220, 30));

        LineNewUserName.setForeground(new java.awt.Color(29, 41, 81));
        JPSignUp.add(LineNewUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 220, 20));

        NameNewUserField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NameNewUserField.setForeground(new java.awt.Color(29, 41, 81));
        NameNewUserField.setBorder(null);
        JPSignUp.add(NameNewUserField, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 220, 30));

        LineNewUserMiddleName.setForeground(new java.awt.Color(29, 41, 81));
        JPSignUp.add(LineNewUserMiddleName, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 220, 20));

        MiddleNameNewUserField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        MiddleNameNewUserField.setForeground(new java.awt.Color(29, 41, 81));
        MiddleNameNewUserField.setBorder(null);
        JPSignUp.add(MiddleNameNewUserField, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, 220, 30));

        LineNewUserLastName.setForeground(new java.awt.Color(29, 41, 81));
        JPSignUp.add(LineNewUserLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 220, 20));

        LastNameNewUserField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LastNameNewUserField.setForeground(new java.awt.Color(29, 41, 81));
        LastNameNewUserField.setBorder(null);
        JPSignUp.add(LastNameNewUserField, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, 220, 30));

        BoxGenderNewUser.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        BoxGenderNewUser.setForeground(new java.awt.Color(29, 41, 81));
        BoxGenderNewUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        JPSignUp.add(BoxGenderNewUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 120, 30));

        BoxNewUserDistrict.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        BoxNewUserDistrict.setForeground(new java.awt.Color(29, 41, 81));
        BoxNewUserDistrict.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        JPSignUp.add(BoxNewUserDistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 170, 30));

        BoxInstitutionNewUser.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        BoxInstitutionNewUser.setForeground(new java.awt.Color(29, 41, 81));
        BoxInstitutionNewUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        JPSignUp.add(BoxInstitutionNewUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 400, 170, 30));

        ButtonCancel.setBackground(new java.awt.Color(255, 255, 255));
        ButtonCancel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonCancel.setForeground(new java.awt.Color(29, 41, 81));
        ButtonCancel.setText("Cancel");
        ButtonCancel.setBorder(null);
        ButtonCancel.setContentAreaFilled(false);
        ButtonCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonCancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonCancelMouseExited(evt);
            }
        });
        ButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelActionPerformed(evt);
            }
        });
        JPSignUp.add(ButtonCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 470, 100, 40));

        ButtonJoin.setBackground(new java.awt.Color(255, 255, 255));
        ButtonJoin.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonJoin.setForeground(new java.awt.Color(29, 41, 81));
        ButtonJoin.setText("Join");
        ButtonJoin.setBorder(null);
        ButtonJoin.setContentAreaFilled(false);
        ButtonJoin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonJoinMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonJoinMouseExited(evt);
            }
        });
        ButtonJoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonJoinActionPerformed(evt);
            }
        });
        JPSignUp.add(ButtonJoin, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, 100, 40));

        LabelNewUserUserType.setBackground(new java.awt.Color(255, 255, 255));
        LabelNewUserUserType.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelNewUserUserType.setForeground(new java.awt.Color(29, 41, 81));
        LabelNewUserUserType.setText("User Type:");
        JPSignUp.add(LabelNewUserUserType, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 90, 30));

        BoxUserTypeNewUser.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        BoxUserTypeNewUser.setForeground(new java.awt.Color(29, 41, 81));
        BoxUserTypeNewUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        JPSignUp.add(BoxUserTypeNewUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 120, 30));

        LineOffenderBirthday2.setForeground(new java.awt.Color(29, 41, 81));
        JPSignUp.add(LineOffenderBirthday2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 130, 20));

        NewUserBirthday.setBorder(null);
        NewUserBirthday.setForeground(new java.awt.Color(29, 41, 81));
        NewUserBirthday.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        JPSignUp.add(NewUserBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 130, 30));

        getContentPane().add(JPSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 760, 530));

        JPWindow.setBackground(new java.awt.Color(255, 255, 255));
        JPWindow.setForeground(new java.awt.Color(255, 255, 255));
        JPWindow.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonMinimize.setBackground(new java.awt.Color(255, 255, 255));
        ButtonMinimize.setForeground(new java.awt.Color(255, 255, 255));
        ButtonMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Minimize.png"))); // NOI18N
        ButtonMinimize.setContentAreaFilled(false);
        ButtonMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonMinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonMinimizeMouseExited(evt);
            }
        });
        ButtonMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonMinimizeActionPerformed(evt);
            }
        });
        JPWindow.add(ButtonMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 40, 30));

        ButtonClose.setBackground(new java.awt.Color(255, 255, 255));
        ButtonClose.setForeground(new java.awt.Color(255, 255, 255));
        ButtonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Close.png"))); // NOI18N
        ButtonClose.setContentAreaFilled(false);
        ButtonClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonCloseMouseExited(evt);
            }
        });
        ButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCloseActionPerformed(evt);
            }
        });
        JPWindow.add(ButtonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 40, 30));

        getContentPane().add(JPWindow, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 760, 50));

        JPLogged.setBackground(new java.awt.Color(29, 41, 81));
        JPLogged.setForeground(new java.awt.Color(255, 255, 255));
        JPLogged.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPLoggedMouseEntered(evt);
            }
        });
        JPLogged.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        IconLogged.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/User.png"))); // NOI18N
        JPLogged.add(IconLogged, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        Username.setBackground(new java.awt.Color(29, 41, 81));
        Username.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        Username.setForeground(new java.awt.Color(255, 255, 255));
        JPLogged.add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 100, 40));

        getContentPane().add(JPLogged, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 580));

        JPAdminMenu.setBackground(new java.awt.Color(255, 255, 255));
        JPAdminMenu.setForeground(new java.awt.Color(255, 255, 255));
        JPAdminMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPAdminMenuMouseEntered(evt);
            }
        });
        JPAdminMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonStatistics.setBackground(new java.awt.Color(255, 255, 255));
        ButtonStatistics.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ButtonStatistics.setForeground(new java.awt.Color(29, 41, 81));
        ButtonStatistics.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Statistics.png"))); // NOI18N
        ButtonStatistics.setText("Statistics");
        ButtonStatistics.setBorder(null);
        ButtonStatistics.setContentAreaFilled(false);
        ButtonStatistics.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ButtonStatistics.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ButtonStatistics.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonStatisticsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonStatisticsMouseExited(evt);
            }
        });
        ButtonStatistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonStatisticsActionPerformed(evt);
            }
        });
        JPAdminMenu.add(ButtonStatistics, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 230, 170));

        ButtonLogOutAdminUser.setBackground(new java.awt.Color(255, 255, 255));
        ButtonLogOutAdminUser.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        ButtonLogOutAdminUser.setForeground(new java.awt.Color(29, 41, 81));
        ButtonLogOutAdminUser.setText("Log Out");
        ButtonLogOutAdminUser.setBorder(null);
        ButtonLogOutAdminUser.setContentAreaFilled(false);
        ButtonLogOutAdminUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonLogOutAdminUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonLogOutAdminUserMouseExited(evt);
            }
        });
        ButtonLogOutAdminUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLogOutAdminUserActionPerformed(evt);
            }
        });
        JPAdminMenu.add(ButtonLogOutAdminUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 460, 110, 40));

        ButtonAdminQuery.setBackground(new java.awt.Color(255, 255, 255));
        ButtonAdminQuery.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ButtonAdminQuery.setForeground(new java.awt.Color(29, 41, 81));
        ButtonAdminQuery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Query.png"))); // NOI18N
        ButtonAdminQuery.setText("Query");
        ButtonAdminQuery.setBorder(null);
        ButtonAdminQuery.setContentAreaFilled(false);
        ButtonAdminQuery.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ButtonAdminQuery.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ButtonAdminQuery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonAdminQueryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonAdminQueryMouseExited(evt);
            }
        });
        ButtonAdminQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAdminQueryActionPerformed(evt);
            }
        });
        JPAdminMenu.add(ButtonAdminQuery, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 230, 170));

        ButtonAdminConfiguration.setBackground(new java.awt.Color(255, 255, 255));
        ButtonAdminConfiguration.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ButtonAdminConfiguration.setForeground(new java.awt.Color(29, 41, 81));
        ButtonAdminConfiguration.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Configuration.png"))); // NOI18N
        ButtonAdminConfiguration.setText("Configuration");
        ButtonAdminConfiguration.setBorder(null);
        ButtonAdminConfiguration.setContentAreaFilled(false);
        ButtonAdminConfiguration.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ButtonAdminConfiguration.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonAdminConfigurationMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonAdminConfigurationMouseExited(evt);
            }
        });
        ButtonAdminConfiguration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAdminConfigurationActionPerformed(evt);
            }
        });
        JPAdminMenu.add(ButtonAdminConfiguration, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 230, 150));

        getContentPane().add(JPAdminMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 760, 530));

        AdminQuery.setBackground(new java.awt.Color(255, 255, 255));
        AdminQuery.setForeground(new java.awt.Color(29, 41, 81));
        AdminQuery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AdminQueryMouseEntered(evt);
            }
        });

        UserListNotChangingPassword.setBackground(new java.awt.Color(255, 255, 255));
        UserListNotChangingPassword.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelChooseFilterUserListNotChangePassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LabelChooseFilterUserListNotChangePassword.setForeground(new java.awt.Color(29, 41, 81));
        LabelChooseFilterUserListNotChangePassword.setText("Choose the filter:");
        UserListNotChangingPassword.add(LabelChooseFilterUserListNotChangePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, 30));

        BoxFilterIdPerson.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BoxFilterIdPerson.setForeground(new java.awt.Color(29, 41, 81));
        BoxFilterIdPerson.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default", "Type", "Date", "Place" }));
        UserListNotChangingPassword.add(BoxFilterIdPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 140, 30));

        BoxFilterNamePerson.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BoxFilterNamePerson.setForeground(new java.awt.Color(29, 41, 81));
        BoxFilterNamePerson.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        UserListNotChangingPassword.add(BoxFilterNamePerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 140, 30));

        ButtonShowFilteredUserList.setBackground(new java.awt.Color(255, 255, 255));
        ButtonShowFilteredUserList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ButtonShowFilteredUserList.setForeground(new java.awt.Color(29, 41, 81));
        ButtonShowFilteredUserList.setText("Enter");
        ButtonShowFilteredUserList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        ButtonShowFilteredUserList.setContentAreaFilled(false);
        ButtonShowFilteredUserList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonShowFilteredUserListActionPerformed(evt);
            }
        });
        UserListNotChangingPassword.add(ButtonShowFilteredUserList, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 100, 30));

        BoxFilterLastNamePerson.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BoxFilterLastNamePerson.setForeground(new java.awt.Color(29, 41, 81));
        BoxFilterLastNamePerson.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        UserListNotChangingPassword.add(BoxFilterLastNamePerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 140, 30));

        LabelFilterIdPerson.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LabelFilterIdPerson.setForeground(new java.awt.Color(29, 41, 81));
        LabelFilterIdPerson.setText("Id of the person");
        UserListNotChangingPassword.add(LabelFilterIdPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, 30));

        LabelFilterNamePerson.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LabelFilterNamePerson.setForeground(new java.awt.Color(29, 41, 81));
        LabelFilterNamePerson.setText("Name of the person");
        UserListNotChangingPassword.add(LabelFilterNamePerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, 30));

        LabelFilterLastNamePerson.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LabelFilterLastNamePerson.setForeground(new java.awt.Color(29, 41, 81));
        LabelFilterLastNamePerson.setText("Last name of the person");
        UserListNotChangingPassword.add(LabelFilterLastNamePerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 160, 30));

        LabelFilterUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LabelFilterUsername.setForeground(new java.awt.Color(29, 41, 81));
        LabelFilterUsername.setText("Username");
        UserListNotChangingPassword.add(LabelFilterUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, -1, 30));

        BoxFilterUsernamePerson.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BoxFilterUsernamePerson.setForeground(new java.awt.Color(29, 41, 81));
        BoxFilterUsernamePerson.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        UserListNotChangingPassword.add(BoxFilterUsernamePerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 140, 30));

        ButtonRollbackUserListNotChangePassword.setBackground(new java.awt.Color(255, 255, 255));
        ButtonRollbackUserListNotChangePassword.setForeground(new java.awt.Color(255, 255, 255));
        ButtonRollbackUserListNotChangePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Rollback.png"))); // NOI18N
        ButtonRollbackUserListNotChangePassword.setBorder(null);
        ButtonRollbackUserListNotChangePassword.setContentAreaFilled(false);
        ButtonRollbackUserListNotChangePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonRollbackUserListNotChangePasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonRollbackUserListNotChangePasswordMouseExited(evt);
            }
        });
        ButtonRollbackUserListNotChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRollbackUserListNotChangePasswordActionPerformed(evt);
            }
        });
        UserListNotChangingPassword.add(ButtonRollbackUserListNotChangePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 50));

        TableUsersPassword.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(TableUsersPassword);

        UserListNotChangingPassword.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 460, 360));

        AdminQuery.addTab("User list without changing the password", UserListNotChangingPassword);

        ReportList.setBackground(new java.awt.Color(255, 255, 255));
        ReportList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane10.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        jScrollPane10.setForeground(new java.awt.Color(29, 41, 81));

        NewReportList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        NewReportList.setForeground(new java.awt.Color(29, 41, 81));
        NewReportList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        NewReportList.setToolTipText("");
        NewReportList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NewReportListMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(NewReportList);

        ReportList.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 210, 390));

        ReportInformation.setColumns(20);
        ReportInformation.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        ReportInformation.setForeground(new java.awt.Color(29, 41, 81));
        ReportInformation.setRows(5);
        ReportInformation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        jScrollPane11.setViewportView(ReportInformation);

        ReportList.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 350, 180));

        PictureNewReportList.setBackground(new java.awt.Color(255, 255, 255));
        PictureNewReportList.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        PictureNewReportList.setForeground(new java.awt.Color(29, 41, 81));
        PictureNewReportList.setText("Picture");
        PictureNewReportList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        PictureNewReportList.setContentAreaFilled(false);
        PictureNewReportList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PictureNewReportListActionPerformed(evt);
            }
        });
        ReportList.add(PictureNewReportList, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, 130, 150));

        RightPicNewReportList.setBackground(new java.awt.Color(255, 255, 255));
        RightPicNewReportList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/RightPic.png"))); // NOI18N
        RightPicNewReportList.setBorder(null);
        RightPicNewReportList.setContentAreaFilled(false);
        RightPicNewReportList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RightPicNewReportListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RightPicNewReportListMouseExited(evt);
            }
        });
        RightPicNewReportList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RightPicNewReportListActionPerformed(evt);
            }
        });
        ReportList.add(RightPicNewReportList, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 350, 40, 40));

        LeftPicNewReportList.setBackground(new java.awt.Color(255, 255, 255));
        LeftPicNewReportList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/LeftPic.png"))); // NOI18N
        LeftPicNewReportList.setBorder(null);
        LeftPicNewReportList.setContentAreaFilled(false);
        LeftPicNewReportList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LeftPicNewReportListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LeftPicNewReportListMouseExited(evt);
            }
        });
        LeftPicNewReportList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeftPicNewReportListActionPerformed(evt);
            }
        });
        ReportList.add(LeftPicNewReportList, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 40, 40));

        ButtonRollbackReportList.setBackground(new java.awt.Color(255, 255, 255));
        ButtonRollbackReportList.setForeground(new java.awt.Color(255, 255, 255));
        ButtonRollbackReportList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Rollback.png"))); // NOI18N
        ButtonRollbackReportList.setBorder(null);
        ButtonRollbackReportList.setContentAreaFilled(false);
        ButtonRollbackReportList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonRollbackReportListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonRollbackReportListMouseExited(evt);
            }
        });
        ButtonRollbackReportList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRollbackReportListActionPerformed(evt);
            }
        });
        ReportList.add(ButtonRollbackReportList, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 50));

        LabelChooseFilterUserListNotChangePassword2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LabelChooseFilterUserListNotChangePassword2.setForeground(new java.awt.Color(29, 41, 81));
        LabelChooseFilterUserListNotChangePassword2.setText("List of new reports");
        ReportList.add(LabelChooseFilterUserListNotChangePassword2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, 30));

        LabelChooseFilterUserListNotChangePassword3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LabelChooseFilterUserListNotChangePassword3.setForeground(new java.awt.Color(29, 41, 81));
        LabelChooseFilterUserListNotChangePassword3.setText("Description of the selected report");
        ReportList.add(LabelChooseFilterUserListNotChangePassword3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, 30));

        ButtonShowListOfReports.setBackground(new java.awt.Color(255, 255, 255));
        ButtonShowListOfReports.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ButtonShowListOfReports.setForeground(new java.awt.Color(29, 41, 81));
        ButtonShowListOfReports.setText("Refresh");
        ButtonShowListOfReports.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        ButtonShowListOfReports.setContentAreaFilled(false);
        ButtonShowListOfReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonShowListOfReportsActionPerformed(evt);
            }
        });
        ReportList.add(ButtonShowListOfReports, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 420, 100, 30));

        AdminQuery.addTab("List of new reports", ReportList);

        Log.setBackground(new java.awt.Color(255, 255, 255));
        Log.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BoxLogStartDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BoxLogStartDate.setForeground(new java.awt.Color(29, 41, 81));
        BoxLogStartDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Start Date" }));
        Log.add(BoxLogStartDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 100, 30));

        BoxLogFinishDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BoxLogFinishDate.setForeground(new java.awt.Color(29, 41, 81));
        BoxLogFinishDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Finish Date" }));
        Log.add(BoxLogFinishDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 100, 30));

        LabelChooseFilterUserListNotChangePassword1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LabelChooseFilterUserListNotChangePassword1.setForeground(new java.awt.Color(29, 41, 81));
        LabelChooseFilterUserListNotChangePassword1.setText("Range dates:");
        Log.add(LabelChooseFilterUserListNotChangePassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, 30));

        jScrollPane12.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        jScrollPane12.setForeground(new java.awt.Color(29, 41, 81));

        LogUserList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        LogUserList.setForeground(new java.awt.Color(29, 41, 81));
        LogUserList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        LogUserList.setToolTipText("");
        jScrollPane12.setViewportView(LogUserList);

        Log.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 210, 260));

        ButtonLogUserList.setBackground(new java.awt.Color(255, 255, 255));
        ButtonLogUserList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ButtonLogUserList.setForeground(new java.awt.Color(29, 41, 81));
        ButtonLogUserList.setText("Enter");
        ButtonLogUserList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        ButtonLogUserList.setContentAreaFilled(false);
        ButtonLogUserList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLogUserListActionPerformed(evt);
            }
        });
        Log.add(ButtonLogUserList, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 100, 30));

        ButtonRollbackLog.setBackground(new java.awt.Color(255, 255, 255));
        ButtonRollbackLog.setForeground(new java.awt.Color(255, 255, 255));
        ButtonRollbackLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Rollback.png"))); // NOI18N
        ButtonRollbackLog.setBorder(null);
        ButtonRollbackLog.setContentAreaFilled(false);
        ButtonRollbackLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonRollbackLogMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonRollbackLogMouseExited(evt);
            }
        });
        ButtonRollbackLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRollbackLogActionPerformed(evt);
            }
        });
        Log.add(ButtonRollbackLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 50));

        AdminQuery.addTab("Log", Log);

        getContentPane().add(AdminQuery, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 530));

        AdminConfiguration.setBackground(new java.awt.Color(255, 255, 255));
        AdminConfiguration.setForeground(new java.awt.Color(29, 41, 81));

        UpdateAdminLoginInfo.setBackground(new java.awt.Color(255, 255, 255));
        UpdateAdminLoginInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelAdminPasswordUpdateLogin.setBackground(new java.awt.Color(255, 255, 255));
        LabelAdminPasswordUpdateLogin.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelAdminPasswordUpdateLogin.setForeground(new java.awt.Color(29, 41, 81));
        LabelAdminPasswordUpdateLogin.setText("Password:");
        UpdateAdminLoginInfo.add(LabelAdminPasswordUpdateLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 90, 30));

        LabelAdminUsernameUpdateLogin.setBackground(new java.awt.Color(255, 255, 255));
        LabelAdminUsernameUpdateLogin.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelAdminUsernameUpdateLogin.setForeground(new java.awt.Color(29, 41, 81));
        LabelAdminUsernameUpdateLogin.setText("Username:");
        UpdateAdminLoginInfo.add(LabelAdminUsernameUpdateLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 100, 30));

        LineUpdateAdminUsername.setForeground(new java.awt.Color(29, 41, 81));
        UpdateAdminLoginInfo.add(LineUpdateAdminUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 220, 20));

        AdminUpdateUsernameField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AdminUpdateUsernameField.setForeground(new java.awt.Color(29, 41, 81));
        AdminUpdateUsernameField.setBorder(null);
        UpdateAdminLoginInfo.add(AdminUpdateUsernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 180, 30));

        LineUpdateAdminPassword.setForeground(new java.awt.Color(29, 41, 81));
        UpdateAdminLoginInfo.add(LineUpdateAdminPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 220, 20));

        AdminUpdatePasswordField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AdminUpdatePasswordField.setForeground(new java.awt.Color(29, 41, 81));
        AdminUpdatePasswordField.setBorder(null);
        UpdateAdminLoginInfo.add(AdminUpdatePasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 180, 30));

        ButtonCancelUpdatesUserLoginAdmin.setBackground(new java.awt.Color(255, 255, 255));
        ButtonCancelUpdatesUserLoginAdmin.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonCancelUpdatesUserLoginAdmin.setForeground(new java.awt.Color(29, 41, 81));
        ButtonCancelUpdatesUserLoginAdmin.setText("Cancel");
        ButtonCancelUpdatesUserLoginAdmin.setBorder(null);
        ButtonCancelUpdatesUserLoginAdmin.setContentAreaFilled(false);
        ButtonCancelUpdatesUserLoginAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonCancelUpdatesUserLoginAdminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonCancelUpdatesUserLoginAdminMouseExited(evt);
            }
        });
        ButtonCancelUpdatesUserLoginAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelUpdatesUserLoginAdminActionPerformed(evt);
            }
        });
        UpdateAdminLoginInfo.add(ButtonCancelUpdatesUserLoginAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 500, 100, 40));

        ButtonConfirmChangesAdmin.setBackground(new java.awt.Color(255, 255, 255));
        ButtonConfirmChangesAdmin.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonConfirmChangesAdmin.setForeground(new java.awt.Color(29, 41, 81));
        ButtonConfirmChangesAdmin.setText("Confirm Changes");
        ButtonConfirmChangesAdmin.setBorder(null);
        ButtonConfirmChangesAdmin.setContentAreaFilled(false);
        ButtonConfirmChangesAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonConfirmChangesAdminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonConfirmChangesAdminMouseExited(evt);
            }
        });
        ButtonConfirmChangesAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonConfirmChangesAdminActionPerformed(evt);
            }
        });
        UpdateAdminLoginInfo.add(ButtonConfirmChangesAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 500, 150, 40));

        IconUpdateUsernameAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/EditField.png"))); // NOI18N
        UpdateAdminLoginInfo.add(IconUpdateUsernameAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 40, 40));

        IconUpdatePasswordAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/EditField.png"))); // NOI18N
        UpdateAdminLoginInfo.add(IconUpdatePasswordAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 40, 40));

        LabelAdminUpdateLoginFields.setBackground(new java.awt.Color(255, 255, 255));
        LabelAdminUpdateLoginFields.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        LabelAdminUpdateLoginFields.setForeground(new java.awt.Color(29, 41, 81));
        LabelAdminUpdateLoginFields.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/UpdateInfo.png"))); // NOI18N
        LabelAdminUpdateLoginFields.setText("Update the desired field");
        UpdateAdminLoginInfo.add(LabelAdminUpdateLoginFields, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 330, -1));

        LabelUpdateAdminUserType.setBackground(new java.awt.Color(255, 255, 255));
        LabelUpdateAdminUserType.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelUpdateAdminUserType.setForeground(new java.awt.Color(29, 41, 81));
        LabelUpdateAdminUserType.setText("User Type:");
        UpdateAdminLoginInfo.add(LabelUpdateAdminUserType, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, 90, 30));

        BoxAdminUserTypeUpdate.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        BoxAdminUserTypeUpdate.setForeground(new java.awt.Color(29, 41, 81));
        BoxAdminUserTypeUpdate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        UpdateAdminLoginInfo.add(BoxAdminUserTypeUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 420, 120, 30));

        ActualUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ActualUsername.setForeground(new java.awt.Color(29, 41, 81));
        ActualUsername.setBorder(null);
        UpdateAdminLoginInfo.add(ActualUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 180, 30));

        LineUpdateAdminUsername1.setForeground(new java.awt.Color(29, 41, 81));
        UpdateAdminLoginInfo.add(LineUpdateAdminUsername1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 220, 20));

        LabelAdminUsernameUpdateLogin1.setBackground(new java.awt.Color(255, 255, 255));
        LabelAdminUsernameUpdateLogin1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelAdminUsernameUpdateLogin1.setForeground(new java.awt.Color(29, 41, 81));
        LabelAdminUsernameUpdateLogin1.setText("Actual username:");
        UpdateAdminLoginInfo.add(LabelAdminUsernameUpdateLogin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 150, 30));

        AdminConfiguration.addTab("Update login information", UpdateAdminLoginInfo);

        UpdateAdminPersonalInfo.setBackground(new java.awt.Color(255, 255, 255));
        UpdateAdminPersonalInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelUpdateAdminId.setBackground(new java.awt.Color(255, 255, 255));
        LabelUpdateAdminId.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelUpdateAdminId.setForeground(new java.awt.Color(29, 41, 81));
        LabelUpdateAdminId.setText("Id:");
        UpdateAdminPersonalInfo.add(LabelUpdateAdminId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 100, 30));

        LabelUpdateAdminNameUpdate.setBackground(new java.awt.Color(255, 255, 255));
        LabelUpdateAdminNameUpdate.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelUpdateAdminNameUpdate.setForeground(new java.awt.Color(29, 41, 81));
        LabelUpdateAdminNameUpdate.setText("Name:");
        UpdateAdminPersonalInfo.add(LabelUpdateAdminNameUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 100, 30));

        LabelUpdateAdminMiddleName.setBackground(new java.awt.Color(255, 255, 255));
        LabelUpdateAdminMiddleName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelUpdateAdminMiddleName.setForeground(new java.awt.Color(29, 41, 81));
        LabelUpdateAdminMiddleName.setText("Middle name:");
        UpdateAdminPersonalInfo.add(LabelUpdateAdminMiddleName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 120, 30));

        LabelUpdateAdminLastName.setBackground(new java.awt.Color(255, 255, 255));
        LabelUpdateAdminLastName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelUpdateAdminLastName.setForeground(new java.awt.Color(29, 41, 81));
        LabelUpdateAdminLastName.setText("Last name:");
        UpdateAdminPersonalInfo.add(LabelUpdateAdminLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 90, 30));

        LabelUpdateAdminCommunity.setBackground(new java.awt.Color(255, 255, 255));
        LabelUpdateAdminCommunity.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelUpdateAdminCommunity.setForeground(new java.awt.Color(29, 41, 81));
        LabelUpdateAdminCommunity.setText("District:");
        UpdateAdminPersonalInfo.add(LabelUpdateAdminCommunity, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 100, 30));

        LabelUpdateAdminInstitution.setBackground(new java.awt.Color(255, 255, 255));
        LabelUpdateAdminInstitution.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelUpdateAdminInstitution.setForeground(new java.awt.Color(29, 41, 81));
        LabelUpdateAdminInstitution.setText("Institution:");
        UpdateAdminPersonalInfo.add(LabelUpdateAdminInstitution, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 90, 30));

        LabelUpdateAdminGender.setBackground(new java.awt.Color(255, 255, 255));
        LabelUpdateAdminGender.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelUpdateAdminGender.setForeground(new java.awt.Color(29, 41, 81));
        LabelUpdateAdminGender.setText("Gender:");
        UpdateAdminPersonalInfo.add(LabelUpdateAdminGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 100, 30));

        LabelUpdateAdminBirthday.setBackground(new java.awt.Color(255, 255, 255));
        LabelUpdateAdminBirthday.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelUpdateAdminBirthday.setForeground(new java.awt.Color(29, 41, 81));
        LabelUpdateAdminBirthday.setText("Birthday:");
        UpdateAdminPersonalInfo.add(LabelUpdateAdminBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 100, 30));

        LineUpdateAdminId.setForeground(new java.awt.Color(29, 41, 81));
        UpdateAdminPersonalInfo.add(LineUpdateAdminId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 220, 20));

        UpdateAdminIdField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        UpdateAdminIdField.setForeground(new java.awt.Color(29, 41, 81));
        UpdateAdminIdField.setBorder(null);
        UpdateAdminPersonalInfo.add(UpdateAdminIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 220, 30));

        LineUpdateAdminName.setForeground(new java.awt.Color(29, 41, 81));
        UpdateAdminPersonalInfo.add(LineUpdateAdminName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 220, 20));

        UpdateAdminNameField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        UpdateAdminNameField.setForeground(new java.awt.Color(29, 41, 81));
        UpdateAdminNameField.setBorder(null);
        UpdateAdminPersonalInfo.add(UpdateAdminNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 220, 30));

        LineUpdateAdminMiddleName.setForeground(new java.awt.Color(29, 41, 81));
        UpdateAdminPersonalInfo.add(LineUpdateAdminMiddleName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 220, 20));

        UpdateAdminMiddleNameField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        UpdateAdminMiddleNameField.setForeground(new java.awt.Color(29, 41, 81));
        UpdateAdminMiddleNameField.setBorder(null);
        UpdateAdminPersonalInfo.add(UpdateAdminMiddleNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 220, 30));

        LineUpdateAdminLastName.setForeground(new java.awt.Color(29, 41, 81));
        UpdateAdminPersonalInfo.add(LineUpdateAdminLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 220, 20));

        UpdateAdminLastNameField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        UpdateAdminLastNameField.setForeground(new java.awt.Color(29, 41, 81));
        UpdateAdminLastNameField.setBorder(null);
        UpdateAdminPersonalInfo.add(UpdateAdminLastNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 220, 30));

        LineAdminBirthday.setForeground(new java.awt.Color(29, 41, 81));
        UpdateAdminPersonalInfo.add(LineAdminBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 130, 20));

        UpdateAdminBirthdayField.setBorder(null);
        UpdateAdminBirthdayField.setForeground(new java.awt.Color(29, 41, 81));
        UpdateAdminBirthdayField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        UpdateAdminPersonalInfo.add(UpdateAdminBirthdayField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 130, 30));

        BoxDistrictAdminUpdate.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        BoxDistrictAdminUpdate.setForeground(new java.awt.Color(29, 41, 81));
        BoxDistrictAdminUpdate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        UpdateAdminPersonalInfo.add(BoxDistrictAdminUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 170, 30));

        BoxInstitutionAdminUpdate.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        BoxInstitutionAdminUpdate.setForeground(new java.awt.Color(29, 41, 81));
        BoxInstitutionAdminUpdate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        UpdateAdminPersonalInfo.add(BoxInstitutionAdminUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 170, 30));

        BoxGenderAdminUpdate.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        BoxGenderAdminUpdate.setForeground(new java.awt.Color(29, 41, 81));
        BoxGenderAdminUpdate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        UpdateAdminPersonalInfo.add(BoxGenderAdminUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 120, 30));

        ButtonCancelUpdatesAdminInfo.setBackground(new java.awt.Color(255, 255, 255));
        ButtonCancelUpdatesAdminInfo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonCancelUpdatesAdminInfo.setForeground(new java.awt.Color(29, 41, 81));
        ButtonCancelUpdatesAdminInfo.setText("Cancel");
        ButtonCancelUpdatesAdminInfo.setBorder(null);
        ButtonCancelUpdatesAdminInfo.setContentAreaFilled(false);
        ButtonCancelUpdatesAdminInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonCancelUpdatesAdminInfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonCancelUpdatesAdminInfoMouseExited(evt);
            }
        });
        ButtonCancelUpdatesAdminInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelUpdatesAdminInfoActionPerformed(evt);
            }
        });
        UpdateAdminPersonalInfo.add(ButtonCancelUpdatesAdminInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, 100, 40));

        ButtonConfirmChangesUpdateAdminPersonalInfo.setBackground(new java.awt.Color(255, 255, 255));
        ButtonConfirmChangesUpdateAdminPersonalInfo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonConfirmChangesUpdateAdminPersonalInfo.setForeground(new java.awt.Color(29, 41, 81));
        ButtonConfirmChangesUpdateAdminPersonalInfo.setText("Confirm Changes");
        ButtonConfirmChangesUpdateAdminPersonalInfo.setBorder(null);
        ButtonConfirmChangesUpdateAdminPersonalInfo.setContentAreaFilled(false);
        ButtonConfirmChangesUpdateAdminPersonalInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonConfirmChangesUpdateAdminPersonalInfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonConfirmChangesUpdateAdminPersonalInfoMouseExited(evt);
            }
        });
        ButtonConfirmChangesUpdateAdminPersonalInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonConfirmChangesUpdateAdminPersonalInfoActionPerformed(evt);
            }
        });
        UpdateAdminPersonalInfo.add(ButtonConfirmChangesUpdateAdminPersonalInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, 150, 40));

        IconUpdateUsername6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/EditField.png"))); // NOI18N
        UpdateAdminPersonalInfo.add(IconUpdateUsername6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 40, 40));

        IconUpdateUsername7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/EditField.png"))); // NOI18N
        UpdateAdminPersonalInfo.add(IconUpdateUsername7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 40, 40));

        IconUpdateUsername8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/EditField.png"))); // NOI18N
        UpdateAdminPersonalInfo.add(IconUpdateUsername8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 40, 40));

        IconUpdateUsername9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/EditField.png"))); // NOI18N
        UpdateAdminPersonalInfo.add(IconUpdateUsername9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 40, 40));

        IconUpdateUsername10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/EditField.png"))); // NOI18N
        UpdateAdminPersonalInfo.add(IconUpdateUsername10, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 210, 40, 40));

        LabelUserUpdateLogin3.setBackground(new java.awt.Color(255, 255, 255));
        LabelUserUpdateLogin3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        LabelUserUpdateLogin3.setForeground(new java.awt.Color(29, 41, 81));
        LabelUserUpdateLogin3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/UpdateInfo.png"))); // NOI18N
        LabelUserUpdateLogin3.setText("Update the desired field");
        UpdateAdminPersonalInfo.add(LabelUserUpdateLogin3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 330, 90));

        AdminConfiguration.addTab("Update personal information", UpdateAdminPersonalInfo);

        AdminCatalogues.setBackground(new java.awt.Color(255, 255, 255));
        AdminCatalogues.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonUserCatalogues.setBackground(new java.awt.Color(255, 255, 255));
        ButtonUserCatalogues.setForeground(new java.awt.Color(29, 41, 81));
        ButtonUserCatalogues.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/UserCatalogue.png"))); // NOI18N
        ButtonUserCatalogues.setText("User Catalogues");
        ButtonUserCatalogues.setBorder(null);
        ButtonUserCatalogues.setContentAreaFilled(false);
        ButtonUserCatalogues.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ButtonUserCatalogues.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonUserCataloguesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonUserCataloguesMouseExited(evt);
            }
        });
        ButtonUserCatalogues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonUserCataloguesActionPerformed(evt);
            }
        });
        AdminCatalogues.add(ButtonUserCatalogues, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 230, 180));

        ButtonPersonCatalogues.setBackground(new java.awt.Color(255, 255, 255));
        ButtonPersonCatalogues.setForeground(new java.awt.Color(29, 41, 81));
        ButtonPersonCatalogues.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Person.png"))); // NOI18N
        ButtonPersonCatalogues.setText("Person Catalogues");
        ButtonPersonCatalogues.setBorder(null);
        ButtonPersonCatalogues.setContentAreaFilled(false);
        ButtonPersonCatalogues.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ButtonPersonCatalogues.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonPersonCataloguesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonPersonCataloguesMouseExited(evt);
            }
        });
        ButtonPersonCatalogues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPersonCataloguesActionPerformed(evt);
            }
        });
        AdminCatalogues.add(ButtonPersonCatalogues, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 240, 180));

        ButtonRecordCatalogues.setBackground(new java.awt.Color(255, 255, 255));
        ButtonRecordCatalogues.setForeground(new java.awt.Color(29, 41, 81));
        ButtonRecordCatalogues.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Record.png"))); // NOI18N
        ButtonRecordCatalogues.setText("Record Catalogues");
        ButtonRecordCatalogues.setBorder(null);
        ButtonRecordCatalogues.setContentAreaFilled(false);
        ButtonRecordCatalogues.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ButtonRecordCatalogues.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonRecordCataloguesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonRecordCataloguesMouseExited(evt);
            }
        });
        ButtonRecordCatalogues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRecordCataloguesActionPerformed(evt);
            }
        });
        AdminCatalogues.add(ButtonRecordCatalogues, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 240, 180));

        ButtonRollbackCatalogues.setBackground(new java.awt.Color(255, 255, 255));
        ButtonRollbackCatalogues.setForeground(new java.awt.Color(255, 255, 255));
        ButtonRollbackCatalogues.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Rollback.png"))); // NOI18N
        ButtonRollbackCatalogues.setBorder(null);
        ButtonRollbackCatalogues.setContentAreaFilled(false);
        ButtonRollbackCatalogues.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonRollbackCataloguesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonRollbackCataloguesMouseExited(evt);
            }
        });
        ButtonRollbackCatalogues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRollbackCataloguesActionPerformed(evt);
            }
        });
        AdminCatalogues.add(ButtonRollbackCatalogues, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 50));

        AdminConfiguration.addTab("Administrate system", AdminCatalogues);

        ApproveRecords.setBackground(new java.awt.Color(255, 255, 255));
        ApproveRecords.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelApproveRecords.setBackground(new java.awt.Color(255, 255, 255));
        LabelApproveRecords.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelApproveRecords.setForeground(new java.awt.Color(29, 41, 81));
        LabelApproveRecords.setText("List of unapproved records");
        ApproveRecords.add(LabelApproveRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 240, 30));

        LabelResolutionUnapproved.setBackground(new java.awt.Color(255, 255, 255));
        LabelResolutionUnapproved.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelResolutionUnapproved.setForeground(new java.awt.Color(29, 41, 81));
        LabelResolutionUnapproved.setText("Resolution:");
        ApproveRecords.add(LabelResolutionUnapproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 90, 30));

        LabelVeredictUnapproved.setBackground(new java.awt.Color(255, 255, 255));
        LabelVeredictUnapproved.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelVeredictUnapproved.setForeground(new java.awt.Color(29, 41, 81));
        LabelVeredictUnapproved.setText("Veredict:");
        ApproveRecords.add(LabelVeredictUnapproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 100, 30));

        LabelOffenderUnapproved.setBackground(new java.awt.Color(255, 255, 255));
        LabelOffenderUnapproved.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelOffenderUnapproved.setForeground(new java.awt.Color(29, 41, 81));
        LabelOffenderUnapproved.setText("Offender:");
        ApproveRecords.add(LabelOffenderUnapproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 90, 30));

        LabelCrimeTypeUnapproved.setBackground(new java.awt.Color(255, 255, 255));
        LabelCrimeTypeUnapproved.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelCrimeTypeUnapproved.setForeground(new java.awt.Color(29, 41, 81));
        LabelCrimeTypeUnapproved.setText("Type:");
        ApproveRecords.add(LabelCrimeTypeUnapproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 100, 30));

        LabelDateCrimeUnapproved.setBackground(new java.awt.Color(255, 255, 255));
        LabelDateCrimeUnapproved.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelDateCrimeUnapproved.setForeground(new java.awt.Color(29, 41, 81));
        LabelDateCrimeUnapproved.setText("Date crime:");
        ApproveRecords.add(LabelDateCrimeUnapproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 100, 30));

        LineResolution2.setForeground(new java.awt.Color(29, 41, 81));
        ApproveRecords.add(LineResolution2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, 220, 20));

        LineDateCrime2.setForeground(new java.awt.Color(29, 41, 81));
        ApproveRecords.add(LineDateCrime2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 110, 20));

        UnapprovedDateCrimeField.setBorder(null);
        UnapprovedDateCrimeField.setForeground(new java.awt.Color(29, 41, 81));
        UnapprovedDateCrimeField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        ApproveRecords.add(UnapprovedDateCrimeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 110, 30));

        ButtonCancelUnapproved.setBackground(new java.awt.Color(255, 255, 255));
        ButtonCancelUnapproved.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonCancelUnapproved.setForeground(new java.awt.Color(29, 41, 81));
        ButtonCancelUnapproved.setText("Cancel");
        ButtonCancelUnapproved.setBorder(null);
        ButtonCancelUnapproved.setContentAreaFilled(false);
        ButtonCancelUnapproved.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonCancelUnapprovedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonCancelUnapprovedMouseExited(evt);
            }
        });
        ButtonCancelUnapproved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelUnapprovedActionPerformed(evt);
            }
        });
        ApproveRecords.add(ButtonCancelUnapproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 460, 100, 40));

        ButtonBanUser.setBackground(new java.awt.Color(255, 255, 255));
        ButtonBanUser.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonBanUser.setForeground(new java.awt.Color(29, 41, 81));
        ButtonBanUser.setText("Ban user");
        ButtonBanUser.setBorder(null);
        ButtonBanUser.setContentAreaFilled(false);
        ButtonBanUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonBanUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonBanUserMouseExited(evt);
            }
        });
        ButtonBanUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBanUserActionPerformed(evt);
            }
        });
        ApproveRecords.add(ButtonBanUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 370, 100, 30));

        UnapprovedCrimeDescriptionField.setColumns(20);
        UnapprovedCrimeDescriptionField.setRows(5);
        jScrollPane16.setViewportView(UnapprovedCrimeDescriptionField);

        ApproveRecords.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 220, 40));

        CheckBoxApprovedOrNot.setBackground(new java.awt.Color(255, 255, 255));
        CheckBoxApprovedOrNot.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        CheckBoxApprovedOrNot.setForeground(new java.awt.Color(29, 41, 81));
        CheckBoxApprovedOrNot.setText("Approved");
        ApproveRecords.add(CheckBoxApprovedOrNot, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, 110, -1));

        UnapprovedExpireDateField.setBorder(null);
        UnapprovedExpireDateField.setForeground(new java.awt.Color(29, 41, 81));
        UnapprovedExpireDateField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        ApproveRecords.add(UnapprovedExpireDateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 410, 110, 30));

        LineExpireDate2.setForeground(new java.awt.Color(29, 41, 81));
        ApproveRecords.add(LineExpireDate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 440, 110, 20));

        LabelExpireDateUnapproved.setBackground(new java.awt.Color(255, 255, 255));
        LabelExpireDateUnapproved.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelExpireDateUnapproved.setForeground(new java.awt.Color(29, 41, 81));
        LabelExpireDateUnapproved.setText("Expire date:");
        ApproveRecords.add(LabelExpireDateUnapproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 410, 100, 30));

        PictureUnapproved.setBackground(new java.awt.Color(255, 255, 255));
        PictureUnapproved.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        PictureUnapproved.setForeground(new java.awt.Color(29, 41, 81));
        PictureUnapproved.setText("Picture");
        PictureUnapproved.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        PictureUnapproved.setContentAreaFilled(false);
        PictureUnapproved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PictureUnapprovedActionPerformed(evt);
            }
        });
        ApproveRecords.add(PictureUnapproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 130, 150));

        UnapprovedResolutionField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        UnapprovedResolutionField.setForeground(new java.awt.Color(29, 41, 81));
        UnapprovedResolutionField.setBorder(null);
        ApproveRecords.add(UnapprovedResolutionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, 220, 30));

        RightUnapprovedPic.setBackground(new java.awt.Color(255, 255, 255));
        RightUnapprovedPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/RightPic.png"))); // NOI18N
        RightUnapprovedPic.setBorder(null);
        RightUnapprovedPic.setContentAreaFilled(false);
        RightUnapprovedPic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RightUnapprovedPicMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RightUnapprovedPicMouseExited(evt);
            }
        });
        RightUnapprovedPic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RightUnapprovedPicActionPerformed(evt);
            }
        });
        ApproveRecords.add(RightUnapprovedPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, 40, 40));

        LeftUnapprovedPic.setBackground(new java.awt.Color(255, 255, 255));
        LeftUnapprovedPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/LeftPic.png"))); // NOI18N
        LeftUnapprovedPic.setBorder(null);
        LeftUnapprovedPic.setContentAreaFilled(false);
        LeftUnapprovedPic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LeftUnapprovedPicMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LeftUnapprovedPicMouseExited(evt);
            }
        });
        LeftUnapprovedPic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeftUnapprovedPicActionPerformed(evt);
            }
        });
        ApproveRecords.add(LeftUnapprovedPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 40, 40));

        AddUnapprovedPic.setBackground(new java.awt.Color(255, 255, 255));
        AddUnapprovedPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/AddPic.png"))); // NOI18N
        AddUnapprovedPic.setBorder(null);
        AddUnapprovedPic.setContentAreaFilled(false);
        AddUnapprovedPic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddUnapprovedPicMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddUnapprovedPicMouseExited(evt);
            }
        });
        AddUnapprovedPic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddUnapprovedPicActionPerformed(evt);
            }
        });
        ApproveRecords.add(AddUnapprovedPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, 40, 40));

        RemoveUnapprovedPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/RemovePic.png"))); // NOI18N
        RemoveUnapprovedPic.setContentAreaFilled(false);
        RemoveUnapprovedPic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RemoveUnapprovedPicMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RemoveUnapprovedPicMouseExited(evt);
            }
        });
        RemoveUnapprovedPic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveUnapprovedPicActionPerformed(evt);
            }
        });
        ApproveRecords.add(RemoveUnapprovedPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 40, 40));

        jScrollPane17.setForeground(new java.awt.Color(29, 41, 81));

        ListUnapprovedRecords.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ListUnapprovedRecords.setForeground(new java.awt.Color(29, 41, 81));
        ListUnapprovedRecords.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ListUnapprovedRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListUnapprovedRecordsMouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(ListUnapprovedRecords);

        ApproveRecords.add(jScrollPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 270, 120));

        LabelCrimeDescriptionUnapproved.setBackground(new java.awt.Color(255, 255, 255));
        LabelCrimeDescriptionUnapproved.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelCrimeDescriptionUnapproved.setForeground(new java.awt.Color(29, 41, 81));
        LabelCrimeDescriptionUnapproved.setText("Crime Description:");
        ApproveRecords.add(LabelCrimeDescriptionUnapproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 160, 30));

        ButtonConfirmUnapproved.setBackground(new java.awt.Color(255, 255, 255));
        ButtonConfirmUnapproved.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonConfirmUnapproved.setForeground(new java.awt.Color(29, 41, 81));
        ButtonConfirmUnapproved.setText("Confirm");
        ButtonConfirmUnapproved.setBorder(null);
        ButtonConfirmUnapproved.setContentAreaFilled(false);
        ButtonConfirmUnapproved.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonConfirmUnapprovedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonConfirmUnapprovedMouseExited(evt);
            }
        });
        ButtonConfirmUnapproved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonConfirmUnapprovedActionPerformed(evt);
            }
        });
        ApproveRecords.add(ButtonConfirmUnapproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 460, 100, 40));

        ButtonRefresh.setBackground(new java.awt.Color(255, 255, 255));
        ButtonRefresh.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonRefresh.setForeground(new java.awt.Color(29, 41, 81));
        ButtonRefresh.setText("Refresh");
        ButtonRefresh.setBorder(null);
        ButtonRefresh.setContentAreaFilled(false);
        ButtonRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonRefreshMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonRefreshMouseExited(evt);
            }
        });
        ButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRefreshActionPerformed(evt);
            }
        });
        ApproveRecords.add(ButtonRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 100, 40));

        UnapprovedVeredictField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        UnapprovedVeredictField.setForeground(new java.awt.Color(29, 41, 81));
        UnapprovedVeredictField.setBorder(null);
        ApproveRecords.add(UnapprovedVeredictField, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, 220, 30));

        LineResolution3.setForeground(new java.awt.Color(29, 41, 81));
        ApproveRecords.add(LineResolution3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 220, 20));

        LineResolution4.setForeground(new java.awt.Color(29, 41, 81));
        ApproveRecords.add(LineResolution4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 220, 20));

        UnapprovedIdOffender.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        UnapprovedIdOffender.setForeground(new java.awt.Color(29, 41, 81));
        UnapprovedIdOffender.setBorder(null);
        ApproveRecords.add(UnapprovedIdOffender, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 220, 30));

        UnapprovedTypeField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        UnapprovedTypeField.setForeground(new java.awt.Color(29, 41, 81));
        UnapprovedTypeField.setBorder(null);
        ApproveRecords.add(UnapprovedTypeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 220, 30));

        LineResolution5.setForeground(new java.awt.Color(29, 41, 81));
        ApproveRecords.add(LineResolution5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, 220, 20));

        AdminConfiguration.addTab("Approve records", ApproveRecords);

        getContentPane().add(AdminConfiguration, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 760, 530));

        UserCatalogues.setBackground(new java.awt.Color(255, 255, 255));
        UserCatalogues.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BoxModifyUserType.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BoxModifyUserType.setForeground(new java.awt.Color(29, 41, 81));
        UserCatalogues.add(BoxModifyUserType, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 130, 30));

        LabelUserType.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        LabelUserType.setForeground(new java.awt.Color(29, 41, 81));
        LabelUserType.setText("User type:");
        UserCatalogues.add(LabelUserType, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        BoxModifyBannedReason.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BoxModifyBannedReason.setForeground(new java.awt.Color(29, 41, 81));
        UserCatalogues.add(BoxModifyBannedReason, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, 150, 30));

        LabelBannedReason.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        LabelBannedReason.setForeground(new java.awt.Color(29, 41, 81));
        LabelBannedReason.setText("Banned Reason:");
        UserCatalogues.add(LabelBannedReason, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, -1, -1));

        AddUserTypeCatalogue.setBackground(new java.awt.Color(255, 255, 255));
        AddUserTypeCatalogue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/AddPic.png"))); // NOI18N
        AddUserTypeCatalogue.setBorder(null);
        AddUserTypeCatalogue.setContentAreaFilled(false);
        AddUserTypeCatalogue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddUserTypeCatalogueMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddUserTypeCatalogueMouseExited(evt);
            }
        });
        AddUserTypeCatalogue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddUserTypeCatalogueActionPerformed(evt);
            }
        });
        UserCatalogues.add(AddUserTypeCatalogue, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 40, -1));

        RemoveUserType.setBackground(new java.awt.Color(255, 255, 255));
        RemoveUserType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/RemovePic.png"))); // NOI18N
        RemoveUserType.setBorder(null);
        RemoveUserType.setContentAreaFilled(false);
        RemoveUserType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveUserTypeActionPerformed(evt);
            }
        });
        UserCatalogues.add(RemoveUserType, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 40, -1));

        AddBannedReason.setBackground(new java.awt.Color(255, 255, 255));
        AddBannedReason.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/AddPic.png"))); // NOI18N
        AddBannedReason.setBorder(null);
        AddBannedReason.setContentAreaFilled(false);
        AddBannedReason.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddBannedReasonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddBannedReasonMouseExited(evt);
            }
        });
        AddBannedReason.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBannedReasonActionPerformed(evt);
            }
        });
        UserCatalogues.add(AddBannedReason, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 40, -1));

        RemoveBannedReason.setBackground(new java.awt.Color(255, 255, 255));
        RemoveBannedReason.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/RemovePic.png"))); // NOI18N
        RemoveBannedReason.setBorder(null);
        RemoveBannedReason.setContentAreaFilled(false);
        RemoveBannedReason.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RemoveBannedReasonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RemoveBannedReasonMouseExited(evt);
            }
        });
        RemoveBannedReason.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveBannedReasonActionPerformed(evt);
            }
        });
        UserCatalogues.add(RemoveBannedReason, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, 40, -1));

        ButtonConfirmUserCatalogue.setBackground(new java.awt.Color(255, 255, 255));
        ButtonConfirmUserCatalogue.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        ButtonConfirmUserCatalogue.setForeground(new java.awt.Color(29, 41, 81));
        ButtonConfirmUserCatalogue.setText("Confirm");
        ButtonConfirmUserCatalogue.setBorder(null);
        ButtonConfirmUserCatalogue.setContentAreaFilled(false);
        ButtonConfirmUserCatalogue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonConfirmUserCatalogueMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonConfirmUserCatalogueMouseExited(evt);
            }
        });
        ButtonConfirmUserCatalogue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonConfirmUserCatalogueActionPerformed(evt);
            }
        });
        UserCatalogues.add(ButtonConfirmUserCatalogue, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, 100, 40));

        LabelUserType1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        LabelUserType1.setForeground(new java.awt.Color(29, 41, 81));
        LabelUserType1.setText("User Catalogues");
        UserCatalogues.add(LabelUserType1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, -1));

        getContentPane().add(UserCatalogues, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 760, 530));

        PersonCatalogues.setBackground(new java.awt.Color(255, 255, 255));
        PersonCatalogues.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BoxModifyGender.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BoxModifyGender.setForeground(new java.awt.Color(29, 41, 81));
        PersonCatalogues.add(BoxModifyGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 130, 30));

        LabelGender.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        LabelGender.setForeground(new java.awt.Color(29, 41, 81));
        LabelGender.setText("Gender:");
        PersonCatalogues.add(LabelGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        BoxModifyInstitution.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BoxModifyInstitution.setForeground(new java.awt.Color(29, 41, 81));
        PersonCatalogues.add(BoxModifyInstitution, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 150, 30));

        LabelInstitution.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        LabelInstitution.setForeground(new java.awt.Color(29, 41, 81));
        LabelInstitution.setText("Institution:");
        PersonCatalogues.add(LabelInstitution, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, -1, -1));

        AddGender.setBackground(new java.awt.Color(255, 255, 255));
        AddGender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/AddPic.png"))); // NOI18N
        AddGender.setBorder(null);
        AddGender.setContentAreaFilled(false);
        AddGender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddGenderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddGenderMouseExited(evt);
            }
        });
        AddGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddGenderActionPerformed(evt);
            }
        });
        PersonCatalogues.add(AddGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 40, -1));

        RemoveGender.setBackground(new java.awt.Color(255, 255, 255));
        RemoveGender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/RemovePic.png"))); // NOI18N
        RemoveGender.setBorder(null);
        RemoveGender.setContentAreaFilled(false);
        RemoveGender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RemoveGenderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RemoveGenderMouseExited(evt);
            }
        });
        RemoveGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveGenderActionPerformed(evt);
            }
        });
        PersonCatalogues.add(RemoveGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 40, -1));

        AddInstitution.setBackground(new java.awt.Color(255, 255, 255));
        AddInstitution.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/AddPic.png"))); // NOI18N
        AddInstitution.setBorder(null);
        AddInstitution.setContentAreaFilled(false);
        AddInstitution.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddInstitutionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddInstitutionMouseExited(evt);
            }
        });
        AddInstitution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddInstitutionActionPerformed(evt);
            }
        });
        PersonCatalogues.add(AddInstitution, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 40, -1));

        RemoveInstitution.setBackground(new java.awt.Color(255, 255, 255));
        RemoveInstitution.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/RemovePic.png"))); // NOI18N
        RemoveInstitution.setBorder(null);
        RemoveInstitution.setContentAreaFilled(false);
        RemoveInstitution.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RemoveInstitutionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RemoveInstitutionMouseExited(evt);
            }
        });
        RemoveInstitution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveInstitutionActionPerformed(evt);
            }
        });
        PersonCatalogues.add(RemoveInstitution, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, 40, -1));

        ButtonConfirmPersonCatalogue.setBackground(new java.awt.Color(255, 255, 255));
        ButtonConfirmPersonCatalogue.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        ButtonConfirmPersonCatalogue.setForeground(new java.awt.Color(29, 41, 81));
        ButtonConfirmPersonCatalogue.setText("Confirm");
        ButtonConfirmPersonCatalogue.setBorder(null);
        ButtonConfirmPersonCatalogue.setContentAreaFilled(false);
        ButtonConfirmPersonCatalogue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonConfirmPersonCatalogueMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonConfirmPersonCatalogueMouseExited(evt);
            }
        });
        ButtonConfirmPersonCatalogue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonConfirmPersonCatalogueActionPerformed(evt);
            }
        });
        PersonCatalogues.add(ButtonConfirmPersonCatalogue, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 460, 100, 40));

        BoxModifyCountry.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BoxModifyCountry.setForeground(new java.awt.Color(29, 41, 81));
        PersonCatalogues.add(BoxModifyCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 130, 30));

        LabelCountry.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        LabelCountry.setForeground(new java.awt.Color(29, 41, 81));
        LabelCountry.setText("Country:");
        PersonCatalogues.add(LabelCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, -1, -1));

        BoxModifyState.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BoxModifyState.setForeground(new java.awt.Color(29, 41, 81));
        PersonCatalogues.add(BoxModifyState, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 150, 30));

        LabelState.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        LabelState.setForeground(new java.awt.Color(29, 41, 81));
        LabelState.setText("State:");
        PersonCatalogues.add(LabelState, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, -1, -1));

        AddCountry.setBackground(new java.awt.Color(255, 255, 255));
        AddCountry.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/AddPic.png"))); // NOI18N
        AddCountry.setBorder(null);
        AddCountry.setContentAreaFilled(false);
        AddCountry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddCountryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddCountryMouseExited(evt);
            }
        });
        AddCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCountryActionPerformed(evt);
            }
        });
        PersonCatalogues.add(AddCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 40, -1));

        RemoveCountry.setBackground(new java.awt.Color(255, 255, 255));
        RemoveCountry.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/RemovePic.png"))); // NOI18N
        RemoveCountry.setBorder(null);
        RemoveCountry.setContentAreaFilled(false);
        RemoveCountry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RemoveCountryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RemoveCountryMouseExited(evt);
            }
        });
        RemoveCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveCountryActionPerformed(evt);
            }
        });
        PersonCatalogues.add(RemoveCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 40, -1));

        AddState.setBackground(new java.awt.Color(255, 255, 255));
        AddState.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/AddPic.png"))); // NOI18N
        AddState.setBorder(null);
        AddState.setContentAreaFilled(false);
        AddState.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddStateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddStateMouseExited(evt);
            }
        });
        AddState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddStateActionPerformed(evt);
            }
        });
        PersonCatalogues.add(AddState, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 40, -1));

        RemoveState.setBackground(new java.awt.Color(255, 255, 255));
        RemoveState.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/RemovePic.png"))); // NOI18N
        RemoveState.setBorder(null);
        RemoveState.setContentAreaFilled(false);
        RemoveState.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RemoveStateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RemoveStateMouseExited(evt);
            }
        });
        RemoveState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveStateActionPerformed(evt);
            }
        });
        PersonCatalogues.add(RemoveState, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 300, 40, -1));

        BoxModifyCity.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BoxModifyCity.setForeground(new java.awt.Color(29, 41, 81));
        PersonCatalogues.add(BoxModifyCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 130, 30));

        LabelCity.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        LabelCity.setForeground(new java.awt.Color(29, 41, 81));
        LabelCity.setText("City:");
        PersonCatalogues.add(LabelCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, -1, -1));

        AddCity.setBackground(new java.awt.Color(255, 255, 255));
        AddCity.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/AddPic.png"))); // NOI18N
        AddCity.setBorder(null);
        AddCity.setContentAreaFilled(false);
        AddCity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddCityMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddCityMouseExited(evt);
            }
        });
        AddCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCityActionPerformed(evt);
            }
        });
        PersonCatalogues.add(AddCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 40, -1));

        RemoveCity.setBackground(new java.awt.Color(255, 255, 255));
        RemoveCity.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/RemovePic.png"))); // NOI18N
        RemoveCity.setBorder(null);
        RemoveCity.setContentAreaFilled(false);
        RemoveCity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RemoveCityMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RemoveCityMouseExited(evt);
            }
        });
        RemoveCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveCityActionPerformed(evt);
            }
        });
        PersonCatalogues.add(RemoveCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 40, -1));

        LabelUserType2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        LabelUserType2.setForeground(new java.awt.Color(29, 41, 81));
        LabelUserType2.setText("Person Catalogues");
        PersonCatalogues.add(LabelUserType2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, -1));

        BoxModifyDistrict.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BoxModifyDistrict.setForeground(new java.awt.Color(29, 41, 81));
        PersonCatalogues.add(BoxModifyDistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 370, 140, 30));

        LabelDistrict.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        LabelDistrict.setForeground(new java.awt.Color(29, 41, 81));
        LabelDistrict.setText("District:");
        PersonCatalogues.add(LabelDistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, -1, -1));

        AddDistrict.setBackground(new java.awt.Color(255, 255, 255));
        AddDistrict.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/AddPic.png"))); // NOI18N
        AddDistrict.setBorder(null);
        AddDistrict.setContentAreaFilled(false);
        AddDistrict.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddDistrictMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddDistrictMouseExited(evt);
            }
        });
        AddDistrict.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddDistrictActionPerformed(evt);
            }
        });
        PersonCatalogues.add(AddDistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 410, 40, -1));

        RemoveDistrict.setBackground(new java.awt.Color(255, 255, 255));
        RemoveDistrict.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/RemovePic.png"))); // NOI18N
        RemoveDistrict.setBorder(null);
        RemoveDistrict.setContentAreaFilled(false);
        RemoveDistrict.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RemoveDistrictMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RemoveDistrictMouseExited(evt);
            }
        });
        RemoveDistrict.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveDistrictActionPerformed(evt);
            }
        });
        PersonCatalogues.add(RemoveDistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 410, 40, -1));

        getContentPane().add(PersonCatalogues, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 760, 530));

        RecordCatalogues.setBackground(new java.awt.Color(255, 255, 255));
        RecordCatalogues.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BoxModifyTypeCrime.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BoxModifyTypeCrime.setForeground(new java.awt.Color(29, 41, 81));
        RecordCatalogues.add(BoxModifyTypeCrime, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 130, 30));

        LabelGender1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        LabelGender1.setForeground(new java.awt.Color(29, 41, 81));
        LabelGender1.setText("Type of crime:");
        RecordCatalogues.add(LabelGender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        AddTypeCrime.setBackground(new java.awt.Color(255, 255, 255));
        AddTypeCrime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/AddPic.png"))); // NOI18N
        AddTypeCrime.setBorder(null);
        AddTypeCrime.setContentAreaFilled(false);
        AddTypeCrime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddTypeCrimeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddTypeCrimeMouseExited(evt);
            }
        });
        AddTypeCrime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTypeCrimeActionPerformed(evt);
            }
        });
        RecordCatalogues.add(AddTypeCrime, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 40, -1));

        RemoveTypeCrime.setBackground(new java.awt.Color(255, 255, 255));
        RemoveTypeCrime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/RemovePic.png"))); // NOI18N
        RemoveTypeCrime.setBorder(null);
        RemoveTypeCrime.setContentAreaFilled(false);
        RemoveTypeCrime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RemoveTypeCrimeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RemoveTypeCrimeMouseExited(evt);
            }
        });
        RemoveTypeCrime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveTypeCrimeActionPerformed(evt);
            }
        });
        RecordCatalogues.add(RemoveTypeCrime, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 40, -1));

        BoxModifyTypeSentence.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BoxModifyTypeSentence.setForeground(new java.awt.Color(29, 41, 81));
        RecordCatalogues.add(BoxModifyTypeSentence, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 150, 30));

        LabelState1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        LabelState1.setForeground(new java.awt.Color(29, 41, 81));
        LabelState1.setText("Type of sentence:");
        RecordCatalogues.add(LabelState1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, -1, -1));

        AddTypeSentence.setBackground(new java.awt.Color(255, 255, 255));
        AddTypeSentence.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/AddPic.png"))); // NOI18N
        AddTypeSentence.setBorder(null);
        AddTypeSentence.setContentAreaFilled(false);
        AddTypeSentence.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddTypeSentenceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddTypeSentenceMouseExited(evt);
            }
        });
        AddTypeSentence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTypeSentenceActionPerformed(evt);
            }
        });
        RecordCatalogues.add(AddTypeSentence, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 40, -1));

        RemoveTypeSentence.setBackground(new java.awt.Color(255, 255, 255));
        RemoveTypeSentence.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/RemovePic.png"))); // NOI18N
        RemoveTypeSentence.setBorder(null);
        RemoveTypeSentence.setContentAreaFilled(false);
        RemoveTypeSentence.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RemoveTypeSentenceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RemoveTypeSentenceMouseExited(evt);
            }
        });
        RemoveTypeSentence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveTypeSentenceActionPerformed(evt);
            }
        });
        RecordCatalogues.add(RemoveTypeSentence, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, 40, -1));

        ButtonCancelRecordCatalogue.setBackground(new java.awt.Color(255, 255, 255));
        ButtonCancelRecordCatalogue.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        ButtonCancelRecordCatalogue.setForeground(new java.awt.Color(29, 41, 81));
        ButtonCancelRecordCatalogue.setText("Confirm");
        ButtonCancelRecordCatalogue.setBorder(null);
        ButtonCancelRecordCatalogue.setContentAreaFilled(false);
        ButtonCancelRecordCatalogue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonCancelRecordCatalogueMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonCancelRecordCatalogueMouseExited(evt);
            }
        });
        ButtonCancelRecordCatalogue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelRecordCatalogueActionPerformed(evt);
            }
        });
        RecordCatalogues.add(ButtonCancelRecordCatalogue, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 460, 100, 40));

        LabelUserType3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        LabelUserType3.setForeground(new java.awt.Color(29, 41, 81));
        LabelUserType3.setText("Record Catalogues");
        RecordCatalogues.add(LabelUserType3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, -1));

        getContentPane().add(RecordCatalogues, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 760, 530));

        AdminStatistics.setBackground(new java.awt.Color(255, 255, 255));
        AdminStatistics.setForeground(new java.awt.Color(29, 41, 81));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonEnterReportsZone1.setBackground(new java.awt.Color(255, 255, 255));
        ButtonEnterReportsZone1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ButtonEnterReportsZone1.setForeground(new java.awt.Color(29, 41, 81));
        ButtonEnterReportsZone1.setText("Enter");
        ButtonEnterReportsZone1.setBorder(null);
        ButtonEnterReportsZone1.setContentAreaFilled(false);
        ButtonEnterReportsZone1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonEnterReportsZone1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonEnterReportsZone1MouseExited(evt);
            }
        });
        ButtonEnterReportsZone1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEnterReportsZone1ActionPerformed(evt);
            }
        });
        jPanel1.add(ButtonEnterReportsZone1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 120, 30));

        AdminStatistics.addTab("Total records by classification", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BoxCountry.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BoxCountry.setForeground(new java.awt.Color(29, 41, 81));
        BoxCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        jPanel2.add(BoxCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 160, 30));

        ButtonEnterReportsZone.setBackground(new java.awt.Color(255, 255, 255));
        ButtonEnterReportsZone.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ButtonEnterReportsZone.setForeground(new java.awt.Color(29, 41, 81));
        ButtonEnterReportsZone.setText("Enter");
        ButtonEnterReportsZone.setBorder(null);
        ButtonEnterReportsZone.setContentAreaFilled(false);
        ButtonEnterReportsZone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonEnterReportsZoneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonEnterReportsZoneMouseExited(evt);
            }
        });
        ButtonEnterReportsZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEnterReportsZoneActionPerformed(evt);
            }
        });
        jPanel2.add(ButtonEnterReportsZone, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 120, 30));

        BoxState.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BoxState.setForeground(new java.awt.Color(29, 41, 81));
        BoxState.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        jPanel2.add(BoxState, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 160, 30));

        BoxCity.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BoxCity.setForeground(new java.awt.Color(29, 41, 81));
        BoxCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        jPanel2.add(BoxCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 160, 30));

        BoxDistrict.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BoxDistrict.setForeground(new java.awt.Color(29, 41, 81));
        BoxDistrict.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        jPanel2.add(BoxDistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 160, 30));

        LabelNewUsername1.setBackground(new java.awt.Color(255, 255, 255));
        LabelNewUsername1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        LabelNewUsername1.setForeground(new java.awt.Color(29, 41, 81));
        LabelNewUsername1.setText("Country:");
        jPanel2.add(LabelNewUsername1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 100, 30));

        LabelNewUsername2.setBackground(new java.awt.Color(255, 255, 255));
        LabelNewUsername2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        LabelNewUsername2.setForeground(new java.awt.Color(29, 41, 81));
        LabelNewUsername2.setText("State:");
        jPanel2.add(LabelNewUsername2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 100, 30));

        LabelNewUsername3.setBackground(new java.awt.Color(255, 255, 255));
        LabelNewUsername3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        LabelNewUsername3.setForeground(new java.awt.Color(29, 41, 81));
        LabelNewUsername3.setText("City:");
        jPanel2.add(LabelNewUsername3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 100, 30));

        LabelNewUsername4.setBackground(new java.awt.Color(255, 255, 255));
        LabelNewUsername4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        LabelNewUsername4.setForeground(new java.awt.Color(29, 41, 81));
        LabelNewUsername4.setText("District:");
        jPanel2.add(LabelNewUsername4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 100, 30));

        ButtonRefreshTotalRecordsByZone.setBackground(new java.awt.Color(255, 255, 255));
        ButtonRefreshTotalRecordsByZone.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ButtonRefreshTotalRecordsByZone.setForeground(new java.awt.Color(29, 41, 81));
        ButtonRefreshTotalRecordsByZone.setText("Refresh");
        ButtonRefreshTotalRecordsByZone.setBorder(null);
        ButtonRefreshTotalRecordsByZone.setContentAreaFilled(false);
        ButtonRefreshTotalRecordsByZone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonRefreshTotalRecordsByZoneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonRefreshTotalRecordsByZoneMouseExited(evt);
            }
        });
        ButtonRefreshTotalRecordsByZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRefreshTotalRecordsByZoneActionPerformed(evt);
            }
        });
        jPanel2.add(ButtonRefreshTotalRecordsByZone, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 120, 30));

        AdminStatistics.addTab("Total records by zone", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        AdminStatistics.addTab("Age range of users", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        AdminStatistics.addTab("Age range of persons with records", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BoxCountryPersonRecords.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BoxCountryPersonRecords.setForeground(new java.awt.Color(29, 41, 81));
        BoxCountryPersonRecords.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        jPanel5.add(BoxCountryPersonRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 160, 30));

        ButtonEnterPersonRecords.setBackground(new java.awt.Color(255, 255, 255));
        ButtonEnterPersonRecords.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ButtonEnterPersonRecords.setForeground(new java.awt.Color(29, 41, 81));
        ButtonEnterPersonRecords.setText("Enter");
        ButtonEnterPersonRecords.setBorder(null);
        ButtonEnterPersonRecords.setContentAreaFilled(false);
        ButtonEnterPersonRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonEnterPersonRecordsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonEnterPersonRecordsMouseExited(evt);
            }
        });
        ButtonEnterPersonRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEnterPersonRecordsActionPerformed(evt);
            }
        });
        jPanel5.add(ButtonEnterPersonRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 120, 30));

        BoxStatePersonRecords.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BoxStatePersonRecords.setForeground(new java.awt.Color(29, 41, 81));
        BoxStatePersonRecords.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        jPanel5.add(BoxStatePersonRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 160, 30));

        BoxCityPersonRecords.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BoxCityPersonRecords.setForeground(new java.awt.Color(29, 41, 81));
        BoxCityPersonRecords.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        jPanel5.add(BoxCityPersonRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 160, 30));

        BoxDistrictPersonRecords.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BoxDistrictPersonRecords.setForeground(new java.awt.Color(29, 41, 81));
        BoxDistrictPersonRecords.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        jPanel5.add(BoxDistrictPersonRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 160, 30));

        LabelNewUsername5.setBackground(new java.awt.Color(255, 255, 255));
        LabelNewUsername5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        LabelNewUsername5.setForeground(new java.awt.Color(29, 41, 81));
        LabelNewUsername5.setText("Country:");
        jPanel5.add(LabelNewUsername5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 100, 30));

        LabelNewUsername6.setBackground(new java.awt.Color(255, 255, 255));
        LabelNewUsername6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        LabelNewUsername6.setForeground(new java.awt.Color(29, 41, 81));
        LabelNewUsername6.setText("State:");
        jPanel5.add(LabelNewUsername6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 100, 30));

        LabelNewUsername7.setBackground(new java.awt.Color(255, 255, 255));
        LabelNewUsername7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        LabelNewUsername7.setForeground(new java.awt.Color(29, 41, 81));
        LabelNewUsername7.setText("City:");
        jPanel5.add(LabelNewUsername7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 100, 30));

        LabelNewUsername8.setBackground(new java.awt.Color(255, 255, 255));
        LabelNewUsername8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        LabelNewUsername8.setForeground(new java.awt.Color(29, 41, 81));
        LabelNewUsername8.setText("District:");
        jPanel5.add(LabelNewUsername8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 100, 30));

        AdminStatistics.addTab("Total people with records by place of residence", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        AdminStatistics.addTab("Sentencing time for crime", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        AdminStatistics.addTab("Records with convictions expired or about to expire", jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        AdminStatistics.addTab("Number of years in jail by type of record", jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        AdminStatistics.addTab("Records with house by jail by type of record", jPanel9);

        getContentPane().add(AdminStatistics, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 760, 530));

        JPUserMenu.setBackground(new java.awt.Color(255, 255, 255));
        JPUserMenu.setForeground(new java.awt.Color(255, 255, 255));
        JPUserMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPUserMenuMouseEntered(evt);
            }
        });
        JPUserMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonQuery.setBackground(new java.awt.Color(255, 255, 255));
        ButtonQuery.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ButtonQuery.setForeground(new java.awt.Color(29, 41, 81));
        ButtonQuery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Query.png"))); // NOI18N
        ButtonQuery.setText("Query");
        ButtonQuery.setBorder(null);
        ButtonQuery.setContentAreaFilled(false);
        ButtonQuery.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ButtonQuery.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ButtonQuery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonQueryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonQueryMouseExited(evt);
            }
        });
        ButtonQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonQueryActionPerformed(evt);
            }
        });
        JPUserMenu.add(ButtonQuery, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 240, 170));

        ButtonConfiguration.setBackground(new java.awt.Color(255, 255, 255));
        ButtonConfiguration.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ButtonConfiguration.setForeground(new java.awt.Color(29, 41, 81));
        ButtonConfiguration.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Configuration.png"))); // NOI18N
        ButtonConfiguration.setText("Configuration");
        ButtonConfiguration.setBorder(null);
        ButtonConfiguration.setContentAreaFilled(false);
        ButtonConfiguration.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ButtonConfiguration.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonConfigurationMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonConfigurationMouseExited(evt);
            }
        });
        ButtonConfiguration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonConfigurationActionPerformed(evt);
            }
        });
        JPUserMenu.add(ButtonConfiguration, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 240, 170));

        ButtonLogOut.setBackground(new java.awt.Color(255, 255, 255));
        ButtonLogOut.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        ButtonLogOut.setForeground(new java.awt.Color(29, 41, 81));
        ButtonLogOut.setText("Log Out");
        ButtonLogOut.setBorder(null);
        ButtonLogOut.setContentAreaFilled(false);
        ButtonLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonLogOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonLogOutMouseExited(evt);
            }
        });
        ButtonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLogOutActionPerformed(evt);
            }
        });
        JPUserMenu.add(ButtonLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 460, 110, 40));

        ButtonCreateRecord.setBackground(new java.awt.Color(255, 255, 255));
        ButtonCreateRecord.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ButtonCreateRecord.setForeground(new java.awt.Color(29, 41, 81));
        ButtonCreateRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/CreateFile.png"))); // NOI18N
        ButtonCreateRecord.setText("Create record");
        ButtonCreateRecord.setBorder(null);
        ButtonCreateRecord.setContentAreaFilled(false);
        ButtonCreateRecord.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ButtonCreateRecord.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ButtonCreateRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonCreateRecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonCreateRecordMouseExited(evt);
            }
        });
        ButtonCreateRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCreateRecordActionPerformed(evt);
            }
        });
        JPUserMenu.add(ButtonCreateRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 240, 170));

        getContentPane().add(JPUserMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 760, 530));

        JPCreateOffender.setBackground(new java.awt.Color(255, 255, 255));
        JPCreateOffender.setForeground(new java.awt.Color(255, 255, 255));
        JPCreateOffender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPCreateOffenderMouseEntered(evt);
            }
        });
        JPCreateOffender.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelIdOffender.setBackground(new java.awt.Color(255, 255, 255));
        LabelIdOffender.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelIdOffender.setForeground(new java.awt.Color(29, 41, 81));
        LabelIdOffender.setText("Id:");
        JPCreateOffender.add(LabelIdOffender, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 100, 30));

        LabelNameOffender.setBackground(new java.awt.Color(255, 255, 255));
        LabelNameOffender.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelNameOffender.setForeground(new java.awt.Color(29, 41, 81));
        LabelNameOffender.setText("Name:");
        JPCreateOffender.add(LabelNameOffender, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 100, 30));

        LabelMiddleNameOffender.setBackground(new java.awt.Color(255, 255, 255));
        LabelMiddleNameOffender.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelMiddleNameOffender.setForeground(new java.awt.Color(29, 41, 81));
        LabelMiddleNameOffender.setText("Middle name:");
        JPCreateOffender.add(LabelMiddleNameOffender, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 120, 30));

        LabelLastNameOffender.setBackground(new java.awt.Color(255, 255, 255));
        LabelLastNameOffender.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelLastNameOffender.setForeground(new java.awt.Color(29, 41, 81));
        LabelLastNameOffender.setText("Last name:");
        JPCreateOffender.add(LabelLastNameOffender, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 90, 30));

        LabelCommunityOffender.setBackground(new java.awt.Color(255, 255, 255));
        LabelCommunityOffender.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelCommunityOffender.setForeground(new java.awt.Color(29, 41, 81));
        LabelCommunityOffender.setText("District:");
        JPCreateOffender.add(LabelCommunityOffender, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, 100, 30));

        LabelInstitutionOffender.setBackground(new java.awt.Color(255, 255, 255));
        LabelInstitutionOffender.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelInstitutionOffender.setForeground(new java.awt.Color(29, 41, 81));
        LabelInstitutionOffender.setText("Institution:");
        JPCreateOffender.add(LabelInstitutionOffender, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 90, 30));

        LabelOffenderGender.setBackground(new java.awt.Color(255, 255, 255));
        LabelOffenderGender.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelOffenderGender.setForeground(new java.awt.Color(29, 41, 81));
        LabelOffenderGender.setText("Gender:");
        JPCreateOffender.add(LabelOffenderGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 100, 30));

        LabelOffenderBirthday.setBackground(new java.awt.Color(255, 255, 255));
        LabelOffenderBirthday.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelOffenderBirthday.setForeground(new java.awt.Color(29, 41, 81));
        LabelOffenderBirthday.setText("Birthday:");
        JPCreateOffender.add(LabelOffenderBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, 100, 30));

        LineOffenderId.setForeground(new java.awt.Color(29, 41, 81));
        JPCreateOffender.add(LineOffenderId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 220, 20));

        IdOffenderField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        IdOffenderField.setForeground(new java.awt.Color(29, 41, 81));
        IdOffenderField.setBorder(null);
        JPCreateOffender.add(IdOffenderField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 220, 30));

        LineOffenderName.setForeground(new java.awt.Color(29, 41, 81));
        JPCreateOffender.add(LineOffenderName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 220, 20));

        NameOffenderField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NameOffenderField.setForeground(new java.awt.Color(29, 41, 81));
        NameOffenderField.setBorder(null);
        JPCreateOffender.add(NameOffenderField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 220, 30));

        LineOffenderMiddleName.setForeground(new java.awt.Color(29, 41, 81));
        JPCreateOffender.add(LineOffenderMiddleName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 220, 20));

        MiddleNameOffenderField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        MiddleNameOffenderField.setForeground(new java.awt.Color(29, 41, 81));
        MiddleNameOffenderField.setBorder(null);
        JPCreateOffender.add(MiddleNameOffenderField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 220, 30));

        LineOffenderLastName.setForeground(new java.awt.Color(29, 41, 81));
        JPCreateOffender.add(LineOffenderLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 220, 20));

        LastNameOffenderField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LastNameOffenderField.setForeground(new java.awt.Color(29, 41, 81));
        LastNameOffenderField.setBorder(null);
        JPCreateOffender.add(LastNameOffenderField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 220, 30));

        LineOffenderBirthday.setForeground(new java.awt.Color(29, 41, 81));
        JPCreateOffender.add(LineOffenderBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 130, 20));

        BirthdayOffenderField.setBorder(null);
        BirthdayOffenderField.setForeground(new java.awt.Color(29, 41, 81));
        BirthdayOffenderField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        JPCreateOffender.add(BirthdayOffenderField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 130, 30));

        BoxDistrictOffender.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        BoxDistrictOffender.setForeground(new java.awt.Color(29, 41, 81));
        BoxDistrictOffender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        JPCreateOffender.add(BoxDistrictOffender, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, 170, 30));

        BoxInstitutionOffender.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        BoxInstitutionOffender.setForeground(new java.awt.Color(29, 41, 81));
        BoxInstitutionOffender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        JPCreateOffender.add(BoxInstitutionOffender, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, 170, 30));

        BoxGenderOffender.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        BoxGenderOffender.setForeground(new java.awt.Color(29, 41, 81));
        BoxGenderOffender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        JPCreateOffender.add(BoxGenderOffender, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 120, 30));

        ButtonCancelOffender.setBackground(new java.awt.Color(255, 255, 255));
        ButtonCancelOffender.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonCancelOffender.setForeground(new java.awt.Color(29, 41, 81));
        ButtonCancelOffender.setText("Cancel");
        ButtonCancelOffender.setBorder(null);
        ButtonCancelOffender.setContentAreaFilled(false);
        ButtonCancelOffender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonCancelOffenderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonCancelOffenderMouseExited(evt);
            }
        });
        ButtonCancelOffender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelOffenderActionPerformed(evt);
            }
        });
        JPCreateOffender.add(ButtonCancelOffender, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 460, 100, 40));

        ButtonConfirmOffender.setBackground(new java.awt.Color(255, 255, 255));
        ButtonConfirmOffender.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonConfirmOffender.setForeground(new java.awt.Color(29, 41, 81));
        ButtonConfirmOffender.setText("Confirm");
        ButtonConfirmOffender.setBorder(null);
        ButtonConfirmOffender.setContentAreaFilled(false);
        ButtonConfirmOffender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonConfirmOffenderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonConfirmOffenderMouseExited(evt);
            }
        });
        ButtonConfirmOffender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonConfirmOffenderActionPerformed(evt);
            }
        });
        JPCreateOffender.add(ButtonConfirmOffender, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, 100, 40));

        IconOffender.setBackground(new java.awt.Color(255, 255, 255));
        IconOffender.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        IconOffender.setForeground(new java.awt.Color(29, 41, 81));
        IconOffender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/AddUser.png"))); // NOI18N
        IconOffender.setText("Offender Information");
        IconOffender.setMaximumSize(new java.awt.Dimension(240, 128));
        IconOffender.setMinimumSize(new java.awt.Dimension(240, 128));
        JPCreateOffender.add(IconOffender, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 380, 130));

        getContentPane().add(JPCreateOffender, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 760, 530));

        JPCreateRecord.setBackground(new java.awt.Color(255, 255, 255));
        JPCreateRecord.setForeground(new java.awt.Color(255, 255, 255));
        JPCreateRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPCreateRecordMouseEntered(evt);
            }
        });
        JPCreateRecord.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonRollbackCreateRecord.setBackground(new java.awt.Color(255, 255, 255));
        ButtonRollbackCreateRecord.setForeground(new java.awt.Color(255, 255, 255));
        ButtonRollbackCreateRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Rollback.png"))); // NOI18N
        ButtonRollbackCreateRecord.setBorder(null);
        ButtonRollbackCreateRecord.setContentAreaFilled(false);
        ButtonRollbackCreateRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonRollbackCreateRecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonRollbackCreateRecordMouseExited(evt);
            }
        });
        ButtonRollbackCreateRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRollbackCreateRecordActionPerformed(evt);
            }
        });
        JPCreateRecord.add(ButtonRollbackCreateRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        LabelRecordNumber.setBackground(new java.awt.Color(255, 255, 255));
        LabelRecordNumber.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelRecordNumber.setForeground(new java.awt.Color(29, 41, 81));
        LabelRecordNumber.setText("Record number:");
        JPCreateRecord.add(LabelRecordNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 140, 30));

        LabelCrimeDescription.setBackground(new java.awt.Color(255, 255, 255));
        LabelCrimeDescription.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelCrimeDescription.setForeground(new java.awt.Color(29, 41, 81));
        LabelCrimeDescription.setText("Crime Description:");
        JPCreateRecord.add(LabelCrimeDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 160, 30));

        LabelResolution.setBackground(new java.awt.Color(255, 255, 255));
        LabelResolution.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelResolution.setForeground(new java.awt.Color(29, 41, 81));
        LabelResolution.setText("Resolution:");
        JPCreateRecord.add(LabelResolution, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 90, 30));

        LabelVeredict.setBackground(new java.awt.Color(255, 255, 255));
        LabelVeredict.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelVeredict.setForeground(new java.awt.Color(29, 41, 81));
        LabelVeredict.setText("Veredict:");
        JPCreateRecord.add(LabelVeredict, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 100, 30));

        LabelOffender.setBackground(new java.awt.Color(255, 255, 255));
        LabelOffender.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelOffender.setForeground(new java.awt.Color(29, 41, 81));
        LabelOffender.setText("Offender:");
        JPCreateRecord.add(LabelOffender, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 90, 30));

        LabelCrimeType.setBackground(new java.awt.Color(255, 255, 255));
        LabelCrimeType.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelCrimeType.setForeground(new java.awt.Color(29, 41, 81));
        LabelCrimeType.setText("Type:");
        JPCreateRecord.add(LabelCrimeType, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 100, 30));

        LabelDateCrime.setBackground(new java.awt.Color(255, 255, 255));
        LabelDateCrime.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelDateCrime.setForeground(new java.awt.Color(29, 41, 81));
        LabelDateCrime.setText("Date crime:");
        JPCreateRecord.add(LabelDateCrime, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 100, 30));

        LineNumberRecord.setForeground(new java.awt.Color(29, 41, 81));
        JPCreateRecord.add(LineNumberRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 220, 20));

        RecordNumberField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        RecordNumberField.setForeground(new java.awt.Color(29, 41, 81));
        RecordNumberField.setBorder(null);
        JPCreateRecord.add(RecordNumberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 220, 30));

        LineResolution.setForeground(new java.awt.Color(29, 41, 81));
        JPCreateRecord.add(LineResolution, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, 220, 20));

        LineDateCrime.setForeground(new java.awt.Color(29, 41, 81));
        JPCreateRecord.add(LineDateCrime, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 110, 20));

        DateCrimeField.setBorder(null);
        DateCrimeField.setForeground(new java.awt.Color(29, 41, 81));
        DateCrimeField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        JPCreateRecord.add(DateCrimeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 110, 30));

        BoxVeredict.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        BoxVeredict.setForeground(new java.awt.Color(29, 41, 81));
        BoxVeredict.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        JPCreateRecord.add(BoxVeredict, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, 170, 30));

        BoxOffender.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        BoxOffender.setForeground(new java.awt.Color(29, 41, 81));
        BoxOffender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        JPCreateRecord.add(BoxOffender, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 170, 30));

        BoxCrimeType.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        BoxCrimeType.setForeground(new java.awt.Color(29, 41, 81));
        BoxCrimeType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        JPCreateRecord.add(BoxCrimeType, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 120, 30));

        ButtonCancelNewRecord.setBackground(new java.awt.Color(255, 255, 255));
        ButtonCancelNewRecord.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonCancelNewRecord.setForeground(new java.awt.Color(29, 41, 81));
        ButtonCancelNewRecord.setText("Cancel");
        ButtonCancelNewRecord.setBorder(null);
        ButtonCancelNewRecord.setContentAreaFilled(false);
        ButtonCancelNewRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonCancelNewRecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonCancelNewRecordMouseExited(evt);
            }
        });
        ButtonCancelNewRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelNewRecordActionPerformed(evt);
            }
        });
        JPCreateRecord.add(ButtonCancelNewRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 520, 100, 40));

        ButtonConfirmNewRecord.setBackground(new java.awt.Color(255, 255, 255));
        ButtonConfirmNewRecord.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonConfirmNewRecord.setForeground(new java.awt.Color(29, 41, 81));
        ButtonConfirmNewRecord.setText("Confirm");
        ButtonConfirmNewRecord.setBorder(null);
        ButtonConfirmNewRecord.setContentAreaFilled(false);
        ButtonConfirmNewRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonConfirmNewRecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonConfirmNewRecordMouseExited(evt);
            }
        });
        ButtonConfirmNewRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonConfirmNewRecordActionPerformed(evt);
            }
        });
        JPCreateRecord.add(ButtonConfirmNewRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 520, 100, 40));

        IconCreateReacord.setBackground(new java.awt.Color(255, 255, 255));
        IconCreateReacord.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        IconCreateReacord.setForeground(new java.awt.Color(29, 41, 81));
        IconCreateReacord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/AddFile.png"))); // NOI18N
        IconCreateReacord.setText("Create Record");
        IconCreateReacord.setMaximumSize(new java.awt.Dimension(240, 128));
        IconCreateReacord.setMinimumSize(new java.awt.Dimension(240, 128));
        JPCreateRecord.add(IconCreateReacord, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 300, 90));

        CrimeDescriptionField.setColumns(20);
        CrimeDescriptionField.setRows(5);
        jScrollPane6.setViewportView(CrimeDescriptionField);

        JPCreateRecord.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 220, 40));

        CheckBoxApproved.setBackground(new java.awt.Color(255, 255, 255));
        CheckBoxApproved.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        CheckBoxApproved.setForeground(new java.awt.Color(29, 41, 81));
        CheckBoxApproved.setText("Approved");
        JPCreateRecord.add(CheckBoxApproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, 220, -1));

        ExpireDateField.setBorder(null);
        ExpireDateField.setForeground(new java.awt.Color(29, 41, 81));
        ExpireDateField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        JPCreateRecord.add(ExpireDateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 410, 110, 30));

        LineExpireDate.setForeground(new java.awt.Color(29, 41, 81));
        JPCreateRecord.add(LineExpireDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 440, 110, 20));

        LabelExpireDate.setBackground(new java.awt.Color(255, 255, 255));
        LabelExpireDate.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelExpireDate.setForeground(new java.awt.Color(29, 41, 81));
        LabelExpireDate.setText("Expire date:");
        JPCreateRecord.add(LabelExpireDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 410, 100, 30));

        PictureNewRecord.setBackground(new java.awt.Color(255, 255, 255));
        PictureNewRecord.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        PictureNewRecord.setForeground(new java.awt.Color(29, 41, 81));
        PictureNewRecord.setText("Picture");
        PictureNewRecord.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        PictureNewRecord.setContentAreaFilled(false);
        PictureNewRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PictureNewRecordActionPerformed(evt);
            }
        });
        JPCreateRecord.add(PictureNewRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 130, 150));

        ResolutionField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ResolutionField.setForeground(new java.awt.Color(29, 41, 81));
        ResolutionField.setBorder(null);
        JPCreateRecord.add(ResolutionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, 220, 30));

        RightNewRecord.setBackground(new java.awt.Color(255, 255, 255));
        RightNewRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/RightPic.png"))); // NOI18N
        RightNewRecord.setBorder(null);
        RightNewRecord.setContentAreaFilled(false);
        RightNewRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RightNewRecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RightNewRecordMouseExited(evt);
            }
        });
        RightNewRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RightNewRecordActionPerformed(evt);
            }
        });
        JPCreateRecord.add(RightNewRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, 40, 40));

        LeftNewRecord.setBackground(new java.awt.Color(255, 255, 255));
        LeftNewRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/LeftPic.png"))); // NOI18N
        LeftNewRecord.setBorder(null);
        LeftNewRecord.setContentAreaFilled(false);
        LeftNewRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LeftNewRecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LeftNewRecordMouseExited(evt);
            }
        });
        LeftNewRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeftNewRecordActionPerformed(evt);
            }
        });
        JPCreateRecord.add(LeftNewRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 40, 40));

        AddNewRecord.setBackground(new java.awt.Color(255, 255, 255));
        AddNewRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/AddPic.png"))); // NOI18N
        AddNewRecord.setBorder(null);
        AddNewRecord.setContentAreaFilled(false);
        AddNewRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddNewRecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddNewRecordMouseExited(evt);
            }
        });
        AddNewRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNewRecordActionPerformed(evt);
            }
        });
        JPCreateRecord.add(AddNewRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 40, 40));

        RemoveNewRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/RemovePic.png"))); // NOI18N
        RemoveNewRecord.setContentAreaFilled(false);
        RemoveNewRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RemoveNewRecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RemoveNewRecordMouseExited(evt);
            }
        });
        RemoveNewRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveNewRecordActionPerformed(evt);
            }
        });
        JPCreateRecord.add(RemoveNewRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 40, 40));

        LabelCrimeType1.setBackground(new java.awt.Color(255, 255, 255));
        LabelCrimeType1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelCrimeType1.setForeground(new java.awt.Color(29, 41, 81));
        LabelCrimeType1.setText("District:");
        JPCreateRecord.add(LabelCrimeType1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 100, 30));

        BoxDistrictRecord.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        BoxDistrictRecord.setForeground(new java.awt.Color(29, 41, 81));
        BoxDistrictRecord.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        JPCreateRecord.add(BoxDistrictRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 120, 30));

        getContentPane().add(JPCreateRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 760, 530));

        UserQuery.setBackground(new java.awt.Color(255, 255, 255));
        UserQuery.setForeground(new java.awt.Color(29, 41, 81));
        UserQuery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UserQueryMouseEntered(evt);
            }
        });

        PlacesMoreRecords.setBackground(new java.awt.Color(255, 255, 255));
        PlacesMoreRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PlacesMoreRecordsMouseEntered(evt);
            }
        });
        PlacesMoreRecords.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelTop.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LabelTop.setForeground(new java.awt.Color(29, 41, 81));
        LabelTop.setText("Write the number of the top: ");
        PlacesMoreRecords.add(LabelTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        NumberTopField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NumberTopField.setForeground(new java.awt.Color(29, 41, 81));
        NumberTopField.setBorder(null);
        PlacesMoreRecords.add(NumberTopField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 80, 20));

        NumberTopLine.setForeground(new java.awt.Color(29, 41, 81));
        PlacesMoreRecords.add(NumberTopLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 80, 20));

        ButtonShowPlaces.setBackground(new java.awt.Color(255, 255, 255));
        ButtonShowPlaces.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ButtonShowPlaces.setForeground(new java.awt.Color(29, 41, 81));
        ButtonShowPlaces.setText("Enter");
        ButtonShowPlaces.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        ButtonShowPlaces.setContentAreaFilled(false);
        ButtonShowPlaces.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonShowPlacesActionPerformed(evt);
            }
        });
        PlacesMoreRecords.add(ButtonShowPlaces, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 100, 30));

        ButtonRollbackQueryPlaces.setBackground(new java.awt.Color(255, 255, 255));
        ButtonRollbackQueryPlaces.setForeground(new java.awt.Color(255, 255, 255));
        ButtonRollbackQueryPlaces.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Rollback.png"))); // NOI18N
        ButtonRollbackQueryPlaces.setBorder(null);
        ButtonRollbackQueryPlaces.setContentAreaFilled(false);
        ButtonRollbackQueryPlaces.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonRollbackQueryPlacesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonRollbackQueryPlacesMouseExited(evt);
            }
        });
        ButtonRollbackQueryPlaces.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRollbackQueryPlacesActionPerformed(evt);
            }
        });
        PlacesMoreRecords.add(ButtonRollbackQueryPlaces, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 50));

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table.setAutoscrolls(false);
        jScrollPane13.setViewportView(Table);

        PlacesMoreRecords.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 520, 310));

        UserQuery.addTab("Places with more records", PlacesMoreRecords);

        Records.setBackground(new java.awt.Color(255, 255, 255));
        Records.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RecordsMouseEntered(evt);
            }
        });
        Records.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelChooseFilterRecords.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LabelChooseFilterRecords.setForeground(new java.awt.Color(29, 41, 81));
        LabelChooseFilterRecords.setText("End Date:");
        Records.add(LabelChooseFilterRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, -1, 30));

        BoxFilter.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BoxFilter.setForeground(new java.awt.Color(29, 41, 81));
        BoxFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default", "Type", "Date", "Place" }));
        Records.add(BoxFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 140, 30));

        BoxFilterSpecify.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BoxFilterSpecify.setForeground(new java.awt.Color(29, 41, 81));
        BoxFilterSpecify.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        Records.add(BoxFilterSpecify, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 140, 30));

        ButtonShowRecords.setBackground(new java.awt.Color(255, 255, 255));
        ButtonShowRecords.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ButtonShowRecords.setForeground(new java.awt.Color(29, 41, 81));
        ButtonShowRecords.setText("Enter");
        ButtonShowRecords.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        ButtonShowRecords.setContentAreaFilled(false);
        ButtonShowRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonShowRecordsActionPerformed(evt);
            }
        });
        Records.add(ButtonShowRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 100, 30));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        jScrollPane2.setForeground(new java.awt.Color(29, 41, 81));
        jScrollPane2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        RecordsList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        RecordsList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RecordsList.setForeground(new java.awt.Color(29, 41, 81));
        RecordsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        RecordsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RecordsListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(RecordsList);

        Records.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 350, 150));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        jScrollPane3.setForeground(new java.awt.Color(29, 41, 81));

        RecordDescriptionText.setColumns(20);
        RecordDescriptionText.setRows(5);
        jScrollPane3.setViewportView(RecordDescriptionText);

        Records.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 350, 190));

        ButtonRollbackQueryRecords.setBackground(new java.awt.Color(255, 255, 255));
        ButtonRollbackQueryRecords.setForeground(new java.awt.Color(255, 255, 255));
        ButtonRollbackQueryRecords.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Rollback.png"))); // NOI18N
        ButtonRollbackQueryRecords.setBorder(null);
        ButtonRollbackQueryRecords.setContentAreaFilled(false);
        ButtonRollbackQueryRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonRollbackQueryRecordsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonRollbackQueryRecordsMouseExited(evt);
            }
        });
        ButtonRollbackQueryRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRollbackQueryRecordsActionPerformed(evt);
            }
        });
        Records.add(ButtonRollbackQueryRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 50));

        PictureShowRecords.setBackground(new java.awt.Color(255, 255, 255));
        PictureShowRecords.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        PictureShowRecords.setForeground(new java.awt.Color(29, 41, 81));
        PictureShowRecords.setText("Picture");
        PictureShowRecords.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        PictureShowRecords.setContentAreaFilled(false);
        PictureShowRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PictureShowRecordsActionPerformed(evt);
            }
        });
        Records.add(PictureShowRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 130, 150));

        RightPicShowRecords.setBackground(new java.awt.Color(255, 255, 255));
        RightPicShowRecords.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/RightPic.png"))); // NOI18N
        RightPicShowRecords.setBorder(null);
        RightPicShowRecords.setContentAreaFilled(false);
        RightPicShowRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RightPicShowRecordsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RightPicShowRecordsMouseExited(evt);
            }
        });
        RightPicShowRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RightPicShowRecordsActionPerformed(evt);
            }
        });
        Records.add(RightPicShowRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 40, 40));

        LeftPicShowRecords.setBackground(new java.awt.Color(255, 255, 255));
        LeftPicShowRecords.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/LeftPic.png"))); // NOI18N
        LeftPicShowRecords.setBorder(null);
        LeftPicShowRecords.setContentAreaFilled(false);
        LeftPicShowRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LeftPicShowRecordsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LeftPicShowRecordsMouseExited(evt);
            }
        });
        LeftPicShowRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeftPicShowRecordsActionPerformed(evt);
            }
        });
        Records.add(LeftPicShowRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 40, 40));

        ButtonShowCatalogues.setBackground(new java.awt.Color(255, 255, 255));
        ButtonShowCatalogues.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ButtonShowCatalogues.setForeground(new java.awt.Color(29, 41, 81));
        ButtonShowCatalogues.setText("Refresh");
        ButtonShowCatalogues.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        ButtonShowCatalogues.setContentAreaFilled(false);
        ButtonShowCatalogues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonShowCataloguesActionPerformed(evt);
            }
        });
        Records.add(ButtonShowCatalogues, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 100, 30));

        DateStartField.setBorder(null);
        DateStartField.setForeground(new java.awt.Color(29, 41, 81));
        DateStartField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        Records.add(DateStartField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 110, 30));

        LineDateCrime1.setForeground(new java.awt.Color(29, 41, 81));
        Records.add(LineDateCrime1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 110, 20));

        DateEndField.setBorder(null);
        DateEndField.setForeground(new java.awt.Color(29, 41, 81));
        DateEndField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        Records.add(DateEndField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 110, 30));

        LineDateCrime3.setForeground(new java.awt.Color(29, 41, 81));
        Records.add(LineDateCrime3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 110, 20));

        LabelChooseFilterRecords1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LabelChooseFilterRecords1.setForeground(new java.awt.Color(29, 41, 81));
        LabelChooseFilterRecords1.setText("Choose the filter:");
        Records.add(LabelChooseFilterRecords1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, 30));

        LabelChooseFilterRecords2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LabelChooseFilterRecords2.setForeground(new java.awt.Color(29, 41, 81));
        LabelChooseFilterRecords2.setText("Start Date:");
        Records.add(LabelChooseFilterRecords2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, 30));

        UserQuery.addTab("Records", Records);

        UsersList.setBackground(new java.awt.Color(255, 255, 255));
        UsersList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UsersListMouseEntered(evt);
            }
        });
        UsersList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonRollbackQueryUsers.setBackground(new java.awt.Color(255, 255, 255));
        ButtonRollbackQueryUsers.setForeground(new java.awt.Color(255, 255, 255));
        ButtonRollbackQueryUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Rollback.png"))); // NOI18N
        ButtonRollbackQueryUsers.setBorder(null);
        ButtonRollbackQueryUsers.setContentAreaFilled(false);
        ButtonRollbackQueryUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonRollbackQueryUsersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonRollbackQueryUsersMouseExited(evt);
            }
        });
        ButtonRollbackQueryUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRollbackQueryUsersActionPerformed(evt);
            }
        });
        UsersList.add(ButtonRollbackQueryUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 50));

        ButtonShowUsers.setBackground(new java.awt.Color(255, 255, 255));
        ButtonShowUsers.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ButtonShowUsers.setForeground(new java.awt.Color(29, 41, 81));
        ButtonShowUsers.setText("Refresh");
        ButtonShowUsers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        ButtonShowUsers.setContentAreaFilled(false);
        ButtonShowUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonShowUsersActionPerformed(evt);
            }
        });
        UsersList.add(ButtonShowUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, 100, 30));

        TableUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TableUsers);

        UsersList.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        UserQuery.addTab("Users list", UsersList);

        BannedUsers.setBackground(new java.awt.Color(255, 255, 255));
        BannedUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BannedUsersMouseEntered(evt);
            }
        });
        BannedUsers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonRollbackQueryBanned.setBackground(new java.awt.Color(255, 255, 255));
        ButtonRollbackQueryBanned.setForeground(new java.awt.Color(255, 255, 255));
        ButtonRollbackQueryBanned.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Rollback.png"))); // NOI18N
        ButtonRollbackQueryBanned.setBorder(null);
        ButtonRollbackQueryBanned.setContentAreaFilled(false);
        ButtonRollbackQueryBanned.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonRollbackQueryBannedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonRollbackQueryBannedMouseExited(evt);
            }
        });
        ButtonRollbackQueryBanned.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRollbackQueryBannedActionPerformed(evt);
            }
        });
        BannedUsers.add(ButtonRollbackQueryBanned, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 50));

        TableBanned.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(TableBanned);

        BannedUsers.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        ButtonShowBanned.setBackground(new java.awt.Color(255, 255, 255));
        ButtonShowBanned.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ButtonShowBanned.setForeground(new java.awt.Color(29, 41, 81));
        ButtonShowBanned.setText("Refresh");
        ButtonShowBanned.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        ButtonShowBanned.setContentAreaFilled(false);
        ButtonShowBanned.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonShowBannedActionPerformed(evt);
            }
        });
        BannedUsers.add(ButtonShowBanned, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, 100, 30));

        UserQuery.addTab("Banned Users", BannedUsers);

        RecordsConvictionsToExpireOrExpired.setBackground(new java.awt.Color(255, 255, 255));
        RecordsConvictionsToExpireOrExpired.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RecordsConvictionsToExpireOrExpiredMouseEntered(evt);
            }
        });
        RecordsConvictionsToExpireOrExpired.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BoxStartDate1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BoxStartDate1.setForeground(new java.awt.Color(29, 41, 81));
        BoxStartDate1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Start Date" }));
        RecordsConvictionsToExpireOrExpired.add(BoxStartDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, 30));

        BoxFinishDate1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BoxFinishDate1.setForeground(new java.awt.Color(29, 41, 81));
        BoxFinishDate1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "End Date" }));
        RecordsConvictionsToExpireOrExpired.add(BoxFinishDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(29, 41, 81));
        jLabel1.setText("Date Range:");
        RecordsConvictionsToExpireOrExpired.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 80, 30));

        jScrollPane7.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        jScrollPane7.setForeground(new java.awt.Color(29, 41, 81));

        RecordDescriptionTextExpire.setColumns(20);
        RecordDescriptionTextExpire.setRows(5);
        jScrollPane7.setViewportView(RecordDescriptionTextExpire);

        RecordsConvictionsToExpireOrExpired.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 370, 270));

        jScrollPane8.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        jScrollPane8.setForeground(new java.awt.Color(29, 41, 81));
        jScrollPane8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        RecordsExpireList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        RecordsExpireList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RecordsExpireList.setForeground(new java.awt.Color(29, 41, 81));
        jScrollPane8.setViewportView(RecordsExpireList);

        RecordsConvictionsToExpireOrExpired.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 280, 270));

        ButtonShowRecordsDate.setBackground(new java.awt.Color(255, 255, 255));
        ButtonShowRecordsDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ButtonShowRecordsDate.setForeground(new java.awt.Color(29, 41, 81));
        ButtonShowRecordsDate.setText("Enter");
        ButtonShowRecordsDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        ButtonShowRecordsDate.setContentAreaFilled(false);
        ButtonShowRecordsDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonShowRecordsDateActionPerformed(evt);
            }
        });
        RecordsConvictionsToExpireOrExpired.add(ButtonShowRecordsDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 100, 30));

        ButtonRollbackQueryExpire.setBackground(new java.awt.Color(255, 255, 255));
        ButtonRollbackQueryExpire.setForeground(new java.awt.Color(255, 255, 255));
        ButtonRollbackQueryExpire.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Rollback.png"))); // NOI18N
        ButtonRollbackQueryExpire.setBorder(null);
        ButtonRollbackQueryExpire.setContentAreaFilled(false);
        ButtonRollbackQueryExpire.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonRollbackQueryExpireMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonRollbackQueryExpireMouseExited(evt);
            }
        });
        ButtonRollbackQueryExpire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRollbackQueryExpireActionPerformed(evt);
            }
        });
        RecordsConvictionsToExpireOrExpired.add(ButtonRollbackQueryExpire, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 50));

        PictureRecordToExpire.setBackground(new java.awt.Color(255, 255, 255));
        PictureRecordToExpire.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        PictureRecordToExpire.setForeground(new java.awt.Color(29, 41, 81));
        PictureRecordToExpire.setText("Picture");
        PictureRecordToExpire.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        PictureRecordToExpire.setContentAreaFilled(false);
        PictureRecordToExpire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PictureRecordToExpireActionPerformed(evt);
            }
        });
        RecordsConvictionsToExpireOrExpired.add(PictureRecordToExpire, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 130, 150));

        RightPicRecordToExpire.setBackground(new java.awt.Color(255, 255, 255));
        RightPicRecordToExpire.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/RightPic.png"))); // NOI18N
        RightPicRecordToExpire.setBorder(null);
        RightPicRecordToExpire.setContentAreaFilled(false);
        RightPicRecordToExpire.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RightPicRecordToExpireMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RightPicRecordToExpireMouseExited(evt);
            }
        });
        RightPicRecordToExpire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RightPicRecordToExpireActionPerformed(evt);
            }
        });
        RecordsConvictionsToExpireOrExpired.add(RightPicRecordToExpire, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, 40, 40));

        LeftPicRecordToExpire.setBackground(new java.awt.Color(255, 255, 255));
        LeftPicRecordToExpire.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/LeftPic.png"))); // NOI18N
        LeftPicRecordToExpire.setBorder(null);
        LeftPicRecordToExpire.setContentAreaFilled(false);
        LeftPicRecordToExpire.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LeftPicRecordToExpireMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LeftPicRecordToExpireMouseExited(evt);
            }
        });
        LeftPicRecordToExpire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeftPicRecordToExpireActionPerformed(evt);
            }
        });
        RecordsConvictionsToExpireOrExpired.add(LeftPicRecordToExpire, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 40, 40));

        UserQuery.addTab("Records with convictions about to expire or expired", RecordsConvictionsToExpireOrExpired);

        getContentPane().add(UserQuery, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 760, 530));

        UserConfiguration.setForeground(new java.awt.Color(29, 41, 81));

        UpdateLoginInfo.setBackground(new java.awt.Color(255, 255, 255));
        UpdateLoginInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UpdateLoginInfoMouseEntered(evt);
            }
        });
        UpdateLoginInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelUserPasswordUpdateLogin.setBackground(new java.awt.Color(255, 255, 255));
        LabelUserPasswordUpdateLogin.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelUserPasswordUpdateLogin.setForeground(new java.awt.Color(29, 41, 81));
        LabelUserPasswordUpdateLogin.setText("Password:");
        UpdateLoginInfo.add(LabelUserPasswordUpdateLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 230, 90, 30));

        LabelUserUpdateLogin.setBackground(new java.awt.Color(255, 255, 255));
        LabelUserUpdateLogin.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelUserUpdateLogin.setForeground(new java.awt.Color(29, 41, 81));
        LabelUserUpdateLogin.setText("Username:");
        UpdateLoginInfo.add(LabelUserUpdateLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 100, 30));

        LineUpdateUsername.setForeground(new java.awt.Color(29, 41, 81));
        UpdateLoginInfo.add(LineUpdateUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 220, 20));

        UpdateUsernameField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        UpdateUsernameField.setForeground(new java.awt.Color(29, 41, 81));
        UpdateUsernameField.setBorder(null);
        UpdateLoginInfo.add(UpdateUsernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 180, 30));

        LineUpdatePassword.setForeground(new java.awt.Color(29, 41, 81));
        UpdateLoginInfo.add(LineUpdatePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 220, 20));

        UpdatePasswordField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        UpdatePasswordField.setForeground(new java.awt.Color(29, 41, 81));
        UpdatePasswordField.setBorder(null);
        UpdateLoginInfo.add(UpdatePasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 180, 30));

        ButtonCancelUpdatesUserLogin.setBackground(new java.awt.Color(255, 255, 255));
        ButtonCancelUpdatesUserLogin.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonCancelUpdatesUserLogin.setForeground(new java.awt.Color(29, 41, 81));
        ButtonCancelUpdatesUserLogin.setText("Cancel");
        ButtonCancelUpdatesUserLogin.setBorder(null);
        ButtonCancelUpdatesUserLogin.setContentAreaFilled(false);
        ButtonCancelUpdatesUserLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonCancelUpdatesUserLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonCancelUpdatesUserLoginMouseExited(evt);
            }
        });
        ButtonCancelUpdatesUserLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelUpdatesUserLoginActionPerformed(evt);
            }
        });
        UpdateLoginInfo.add(ButtonCancelUpdatesUserLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, 100, 40));

        ButtonConfirmChanges.setBackground(new java.awt.Color(255, 255, 255));
        ButtonConfirmChanges.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonConfirmChanges.setForeground(new java.awt.Color(29, 41, 81));
        ButtonConfirmChanges.setText("Confirm Changes");
        ButtonConfirmChanges.setBorder(null);
        ButtonConfirmChanges.setContentAreaFilled(false);
        ButtonConfirmChanges.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonConfirmChangesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonConfirmChangesMouseExited(evt);
            }
        });
        ButtonConfirmChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonConfirmChangesActionPerformed(evt);
            }
        });
        UpdateLoginInfo.add(ButtonConfirmChanges, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, 150, 40));

        IconUpdateUsername.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/EditField.png"))); // NOI18N
        UpdateLoginInfo.add(IconUpdateUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 40, 40));

        IconUpdatePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/EditField.png"))); // NOI18N
        UpdateLoginInfo.add(IconUpdatePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 40, 40));

        LabelUserUpdateLoginFields.setBackground(new java.awt.Color(255, 255, 255));
        LabelUserUpdateLoginFields.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        LabelUserUpdateLoginFields.setForeground(new java.awt.Color(29, 41, 81));
        LabelUserUpdateLoginFields.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/UpdateInfo.png"))); // NOI18N
        LabelUserUpdateLoginFields.setText("Update the desired field");
        UpdateLoginInfo.add(LabelUserUpdateLoginFields, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 330, -1));

        LabelUpdateUserType.setBackground(new java.awt.Color(255, 255, 255));
        LabelUpdateUserType.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelUpdateUserType.setForeground(new java.awt.Color(29, 41, 81));
        LabelUpdateUserType.setText("User Type:");
        UpdateLoginInfo.add(LabelUpdateUserType, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 90, 30));

        BoxUserTypeUpdateUser.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        BoxUserTypeUpdateUser.setForeground(new java.awt.Color(29, 41, 81));
        BoxUserTypeUpdateUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        UpdateLoginInfo.add(BoxUserTypeUpdateUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, 120, 30));

        UserConfiguration.addTab("Update login information", UpdateLoginInfo);

        UpdatePersonalInfo.setBackground(new java.awt.Color(255, 255, 255));
        UpdatePersonalInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelUpdateId.setBackground(new java.awt.Color(255, 255, 255));
        LabelUpdateId.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelUpdateId.setForeground(new java.awt.Color(29, 41, 81));
        LabelUpdateId.setText("Id:");
        UpdatePersonalInfo.add(LabelUpdateId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 100, 30));

        LabelUpdateNameUpdate.setBackground(new java.awt.Color(255, 255, 255));
        LabelUpdateNameUpdate.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelUpdateNameUpdate.setForeground(new java.awt.Color(29, 41, 81));
        LabelUpdateNameUpdate.setText("Name:");
        UpdatePersonalInfo.add(LabelUpdateNameUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 100, 30));

        LabelMiddleNameUpdate.setBackground(new java.awt.Color(255, 255, 255));
        LabelMiddleNameUpdate.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelMiddleNameUpdate.setForeground(new java.awt.Color(29, 41, 81));
        LabelMiddleNameUpdate.setText("Middle name:");
        UpdatePersonalInfo.add(LabelMiddleNameUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 120, 30));

        LabelLastNameUpdate.setBackground(new java.awt.Color(255, 255, 255));
        LabelLastNameUpdate.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelLastNameUpdate.setForeground(new java.awt.Color(29, 41, 81));
        LabelLastNameUpdate.setText("Last name:");
        UpdatePersonalInfo.add(LabelLastNameUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 90, 30));

        LabelCommunityUpdate.setBackground(new java.awt.Color(255, 255, 255));
        LabelCommunityUpdate.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelCommunityUpdate.setForeground(new java.awt.Color(29, 41, 81));
        LabelCommunityUpdate.setText("District:");
        UpdatePersonalInfo.add(LabelCommunityUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 100, 30));

        LabelInstitutionUpdate.setBackground(new java.awt.Color(255, 255, 255));
        LabelInstitutionUpdate.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelInstitutionUpdate.setForeground(new java.awt.Color(29, 41, 81));
        LabelInstitutionUpdate.setText("Institution:");
        UpdatePersonalInfo.add(LabelInstitutionUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 90, 30));

        LabelUpdateGender.setBackground(new java.awt.Color(255, 255, 255));
        LabelUpdateGender.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelUpdateGender.setForeground(new java.awt.Color(29, 41, 81));
        LabelUpdateGender.setText("Gender:");
        UpdatePersonalInfo.add(LabelUpdateGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 100, 30));

        LabelUpdateBirthday.setBackground(new java.awt.Color(255, 255, 255));
        LabelUpdateBirthday.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelUpdateBirthday.setForeground(new java.awt.Color(29, 41, 81));
        LabelUpdateBirthday.setText("Birthday:");
        UpdatePersonalInfo.add(LabelUpdateBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 100, 30));

        LineUpdateId.setForeground(new java.awt.Color(29, 41, 81));
        UpdatePersonalInfo.add(LineUpdateId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 220, 20));

        IdUpdateField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        IdUpdateField.setForeground(new java.awt.Color(29, 41, 81));
        IdUpdateField.setBorder(null);
        UpdatePersonalInfo.add(IdUpdateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 220, 30));

        LineOffenderName1.setForeground(new java.awt.Color(29, 41, 81));
        UpdatePersonalInfo.add(LineOffenderName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 220, 20));

        NameUpdateField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NameUpdateField.setForeground(new java.awt.Color(29, 41, 81));
        NameUpdateField.setBorder(null);
        UpdatePersonalInfo.add(NameUpdateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 220, 30));

        LineUpdateMiddleName.setForeground(new java.awt.Color(29, 41, 81));
        UpdatePersonalInfo.add(LineUpdateMiddleName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 220, 20));

        MiddleNameUpdateField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        MiddleNameUpdateField.setForeground(new java.awt.Color(29, 41, 81));
        MiddleNameUpdateField.setBorder(null);
        UpdatePersonalInfo.add(MiddleNameUpdateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 220, 30));

        LineUpdateLastName.setForeground(new java.awt.Color(29, 41, 81));
        UpdatePersonalInfo.add(LineUpdateLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 220, 20));

        LastNameUpdateField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LastNameUpdateField.setForeground(new java.awt.Color(29, 41, 81));
        LastNameUpdateField.setBorder(null);
        UpdatePersonalInfo.add(LastNameUpdateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 220, 30));

        LineOffenderBirthday1.setForeground(new java.awt.Color(29, 41, 81));
        UpdatePersonalInfo.add(LineOffenderBirthday1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 130, 20));

        BirthdayUpdateField.setBorder(null);
        BirthdayUpdateField.setForeground(new java.awt.Color(29, 41, 81));
        BirthdayUpdateField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        UpdatePersonalInfo.add(BirthdayUpdateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 130, 30));

        BoxCommunityUpdate.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        BoxCommunityUpdate.setForeground(new java.awt.Color(29, 41, 81));
        BoxCommunityUpdate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        UpdatePersonalInfo.add(BoxCommunityUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 170, 30));

        BoxInstitutionUpdate.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        BoxInstitutionUpdate.setForeground(new java.awt.Color(29, 41, 81));
        BoxInstitutionUpdate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        UpdatePersonalInfo.add(BoxInstitutionUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 170, 30));

        BoxGenderUpdate.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        BoxGenderUpdate.setForeground(new java.awt.Color(29, 41, 81));
        BoxGenderUpdate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        UpdatePersonalInfo.add(BoxGenderUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 120, 30));

        ButtonCancelUpdatesUserInfo.setBackground(new java.awt.Color(255, 255, 255));
        ButtonCancelUpdatesUserInfo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonCancelUpdatesUserInfo.setForeground(new java.awt.Color(29, 41, 81));
        ButtonCancelUpdatesUserInfo.setText("Cancel");
        ButtonCancelUpdatesUserInfo.setBorder(null);
        ButtonCancelUpdatesUserInfo.setContentAreaFilled(false);
        ButtonCancelUpdatesUserInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonCancelUpdatesUserInfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonCancelUpdatesUserInfoMouseExited(evt);
            }
        });
        ButtonCancelUpdatesUserInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelUpdatesUserInfoActionPerformed(evt);
            }
        });
        UpdatePersonalInfo.add(ButtonCancelUpdatesUserInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, 100, 40));

        ButtonConfirmChangesUpdatePersonalInfo.setBackground(new java.awt.Color(255, 255, 255));
        ButtonConfirmChangesUpdatePersonalInfo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonConfirmChangesUpdatePersonalInfo.setForeground(new java.awt.Color(29, 41, 81));
        ButtonConfirmChangesUpdatePersonalInfo.setText("Confirm Changes");
        ButtonConfirmChangesUpdatePersonalInfo.setBorder(null);
        ButtonConfirmChangesUpdatePersonalInfo.setContentAreaFilled(false);
        ButtonConfirmChangesUpdatePersonalInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonConfirmChangesUpdatePersonalInfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonConfirmChangesUpdatePersonalInfoMouseExited(evt);
            }
        });
        ButtonConfirmChangesUpdatePersonalInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonConfirmChangesUpdatePersonalInfoActionPerformed(evt);
            }
        });
        UpdatePersonalInfo.add(ButtonConfirmChangesUpdatePersonalInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, 150, 40));

        IconUpdateUsername1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/EditField.png"))); // NOI18N
        UpdatePersonalInfo.add(IconUpdateUsername1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 40, 40));

        IconUpdateUsername2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/EditField.png"))); // NOI18N
        UpdatePersonalInfo.add(IconUpdateUsername2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 40, 40));

        IconUpdateUsername3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/EditField.png"))); // NOI18N
        UpdatePersonalInfo.add(IconUpdateUsername3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 40, 40));

        IconUpdateUsername4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/EditField.png"))); // NOI18N
        UpdatePersonalInfo.add(IconUpdateUsername4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 40, 40));

        IconUpdateUsername5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/EditField.png"))); // NOI18N
        UpdatePersonalInfo.add(IconUpdateUsername5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 210, 40, 40));

        LabelUserUpdateLogin2.setBackground(new java.awt.Color(255, 255, 255));
        LabelUserUpdateLogin2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        LabelUserUpdateLogin2.setForeground(new java.awt.Color(29, 41, 81));
        LabelUserUpdateLogin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/UpdateInfo.png"))); // NOI18N
        LabelUserUpdateLogin2.setText("Update the desired field");
        UpdatePersonalInfo.add(LabelUserUpdateLogin2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 330, 90));

        UserConfiguration.addTab("Update personal information", UpdatePersonalInfo);

        getContentPane().add(UserConfiguration, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 760, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonQueryActionPerformed
        Animacion.Animacion.mover_derecha(290, 1100, 1, 1, JPUserMenu);
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPCreateRecord.setVisible(false);
        UserQuery.setVisible(true);
        UserConfiguration.setVisible(false);
        JPLogin.setVisible(false);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonQueryActionPerformed

    private void ButtonConfigurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonConfigurationActionPerformed
        Animacion.Animacion.mover_derecha(290, 1100, 1, 1, JPUserMenu);
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPCreateRecord.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(true);
        JPLogin.setVisible(false);
        JPLogged.setVisible(true);
        UpdateUsernameField.setText(Username.getText());
        //Agregar la información personal del usuario en UpdatePersonalInfo
    }//GEN-LAST:event_ButtonConfigurationActionPerformed

    private void ButtonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLogOutActionPerformed
        JPWelcome.setVisible(true);
        JPLogin.setVisible(true);
        JPUserMenu.setVisible(false);
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPSignUp.setVisible(false);
        JPLogged.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        UsernameField.setText(null);
        PasswordField.setText(null);
    }//GEN-LAST:event_ButtonLogOutActionPerformed

    private void ButtonStatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonStatisticsActionPerformed
        Animacion.Animacion.mover_derecha(290, 1100, 1, 1, JPAdminMenu);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(true);
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPCreateRecord.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        JPLogin.setVisible(false);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonStatisticsActionPerformed

    private void ButtonLogOutAdminUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLogOutAdminUserActionPerformed
        JPWelcome.setVisible(true);
        JPUserMenu.setVisible(false);
        JPAdminMenu.setVisible(false);
        JPSignUp.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPCreateRecord.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        JPLogged.setVisible(false);
        JPLogin.setVisible(true);
    }//GEN-LAST:event_ButtonLogOutAdminUserActionPerformed

    private void ButtonAdminQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAdminQueryActionPerformed
        Animacion.Animacion.mover_derecha(290, 1100, 1, 1, JPAdminMenu);
        JPUserMenu.setVisible(false);
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(true);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPCreateRecord.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        JPSignUp.setVisible(false);
        JPLogged.setVisible(true);
        JPLogin.setVisible(false);
        String exampleUsers[] = {"3D", "a5"};
        String exampleReports[] = {"3D", "a5"};
        NewReportList.setListData(exampleReports);
    }//GEN-LAST:event_ButtonAdminQueryActionPerformed

    private void ButtonAdminConfigurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAdminConfigurationActionPerformed
        Animacion.Animacion.mover_derecha(290, 1100, 1, 1, JPAdminMenu);
        JPUserMenu.setVisible(false);
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPCreateRecord.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(true);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(true);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPLogged.setVisible(true);
        JPLogin.setVisible(false);
        UpdateUsernameField.setText(Username.getText());
        //Agregar la información personal del usuario en UpdateAdminPersonalInfo
        //Rellenar las comboBox de AdminCatalogues
        //Rellenar la lista con la funcion de expedientes en ApproveReports
    }//GEN-LAST:event_ButtonAdminConfigurationActionPerformed

    private void ButtonSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSignUpActionPerformed
        Animacion.Animacion.mover_derecha(290, 1100, 1, 1, JPWelcome);
        Animacion.Animacion.mover_izquierda(0, -1100, 1, 1, JPLogin);
        JPUserMenu.setVisible(false);
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPCreateRecord.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        AdminQuery.setVisible(false);
        JPSignUp.setVisible(true);
        JPLogged.setVisible(false);
        try {
            fillInComboBox_signIn();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonSignUpActionPerformed

    private void ButtonEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEnterActionPerformed
        String user_field = UsernameField.getText();
        String user_password = new String(PasswordField.getPassword());
        if(user_field.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fill the user field.");
        } else if(user_password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fill the password field.");
        } else try {
            if(ConnectDB.checkLogin(user_field, user_password) != -1){
                Username.setText(user_field);
                Animacion.Animacion.mover_derecha(290, 1100, 1, 1, JPWelcome);
                Animacion.Animacion.mover_izquierda(0, -1100, 1, 1, JPLogin);
                JPLogged.setVisible(true);
                JPUserMenu.setVisible(true);
                JPSignUp.setVisible(false);
                JPAdminMenu.setVisible(false);
                AdminQuery.setVisible(false);
                AdminConfiguration.setVisible(false);
                UserCatalogues.setVisible(false);
                PersonCatalogues.setVisible(false);
                RecordCatalogues.setVisible(false);
                AdminStatistics.setVisible(false);
                JPCreateOffender.setVisible(false);
                JPCreateRecord.setVisible(false);
                UserQuery.setVisible(false);
                UserConfiguration.setVisible(false);
                currentUser uc = currentUser.getInstance();
                uc.setUsername(user_field);
                uc.setId_userType(ConnectDB.getInt("ADM", "adminUser.getUserType", user_field));
            } else{
                JOptionPane.showMessageDialog(this, "User or password incorrect","Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonEnterActionPerformed

    private void ButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCloseActionPerformed
        dispose();
    }//GEN-LAST:event_ButtonCloseActionPerformed

    private void ButtonMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonMinimizeActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_ButtonMinimizeActionPerformed

    private void ButtonAdminQueryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonAdminQueryMouseEntered
        ButtonAdminQuery.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
        JPWelcome.setVisible(false);
    }//GEN-LAST:event_ButtonAdminQueryMouseEntered

    private void ButtonAdminQueryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonAdminQueryMouseExited
        ButtonAdminQuery.setBorder(null);
    }//GEN-LAST:event_ButtonAdminQueryMouseExited

    private void ButtonAdminConfigurationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonAdminConfigurationMouseEntered
        ButtonAdminConfiguration.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
        JPWelcome.setVisible(false);
    }//GEN-LAST:event_ButtonAdminConfigurationMouseEntered

    private void ButtonAdminConfigurationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonAdminConfigurationMouseExited
        ButtonAdminConfiguration.setBorder(null);
    }//GEN-LAST:event_ButtonAdminConfigurationMouseExited

    private void ButtonStatisticsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonStatisticsMouseEntered
        ButtonStatistics.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
        JPWelcome.setVisible(false);
    }//GEN-LAST:event_ButtonStatisticsMouseEntered

    private void ButtonStatisticsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonStatisticsMouseExited
        ButtonStatistics.setBorder(null);
    }//GEN-LAST:event_ButtonStatisticsMouseExited

    private void ButtonLogOutAdminUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLogOutAdminUserMouseEntered
        ButtonLogOutAdminUser.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
        JPWelcome.setVisible(false);
    }//GEN-LAST:event_ButtonLogOutAdminUserMouseEntered

    private void ButtonLogOutAdminUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLogOutAdminUserMouseExited
        ButtonLogOutAdminUser.setBorder(null);
    }//GEN-LAST:event_ButtonLogOutAdminUserMouseExited

    private void ButtonQueryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonQueryMouseEntered
        ButtonQuery.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
        JPWelcome.setVisible(false);
    }//GEN-LAST:event_ButtonQueryMouseEntered

    private void ButtonQueryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonQueryMouseExited
        ButtonQuery.setBorder(null);
    }//GEN-LAST:event_ButtonQueryMouseExited

    private void ButtonConfigurationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonConfigurationMouseEntered
        ButtonConfiguration.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
        JPWelcome.setVisible(false);
    }//GEN-LAST:event_ButtonConfigurationMouseEntered

    private void ButtonConfigurationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonConfigurationMouseExited
        ButtonConfiguration.setBorder(null);
    }//GEN-LAST:event_ButtonConfigurationMouseExited

    private void ButtonLogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLogOutMouseEntered
        ButtonLogOut.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
        JPWelcome.setVisible(false);
    }//GEN-LAST:event_ButtonLogOutMouseEntered

    private void ButtonLogOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLogOutMouseExited
        ButtonLogOut.setBorder(null);
    }//GEN-LAST:event_ButtonLogOutMouseExited

    private void ButtonCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCloseMouseEntered
        ButtonClose.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonCloseMouseEntered

    private void ButtonCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCloseMouseExited
        ButtonClose.setBorder(null);
    }//GEN-LAST:event_ButtonCloseMouseExited

    private void ButtonMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonMinimizeMouseEntered
        ButtonMinimize.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonMinimizeMouseEntered

    private void ButtonMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonMinimizeMouseExited
        ButtonMinimize.setBorder(null);
    }//GEN-LAST:event_ButtonMinimizeMouseExited

    private void ButtonSignUpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonSignUpMouseEntered
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        ButtonSignUp.setCursor(cursor);
    }//GEN-LAST:event_ButtonSignUpMouseEntered

    private void ButtonSignUpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonSignUpMouseExited
        Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
        ButtonSignUp.setCursor(cursor);
    }//GEN-LAST:event_ButtonSignUpMouseExited

    private void JPWelcomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPWelcomeMouseEntered
        JPWelcome.setVisible(true);
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPUserMenu.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPCreateRecord.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        AdminQuery.setVisible(false);
    }//GEN-LAST:event_JPWelcomeMouseEntered

    private void ButtonCancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelMouseEntered
        ButtonCancel.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
        JPWelcome.setVisible(false);
        JPLogin.setVisible(false);
        JPLogged.setVisible(false);
    }//GEN-LAST:event_ButtonCancelMouseEntered

    private void ButtonCancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelMouseExited
        ButtonCancel.setBorder(null);
    }//GEN-LAST:event_ButtonCancelMouseExited

    private void ButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelActionPerformed
        NewUsernameField.setText(null);
        NewUserPasswordField.setText(null);
        JPWelcome.setVisible(true);
        JPLogin.setVisible(true);
        JPLogged.setVisible(false);
        JPUserMenu.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPCreateRecord.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPSignUp.setVisible(false);
    }//GEN-LAST:event_ButtonCancelActionPerformed

    private void ButtonJoinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonJoinMouseEntered
        ButtonJoin.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
        JPWelcome.setVisible(false);
        JPLogin.setVisible(false);
        JPLogged.setVisible(false);
    }//GEN-LAST:event_ButtonJoinMouseEntered

    private void ButtonJoinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonJoinMouseExited
        ButtonJoin.setBorder(null);
    }//GEN-LAST:event_ButtonJoinMouseExited

    private void ButtonJoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonJoinActionPerformed
        String new_user = NewUsernameField.getText();
        String new_user_password = NewUserPasswordField.getText();
        String new_user_id = IdNewUserField.getText();
        String new_user_name = NameNewUserField.getText();
        String new_user_middle_name = MiddleNameNewUserField.getText();
        String new_user_last_name = LastNameNewUserField.getText();
        String new_user_birthday = NewUserBirthday.getText();
        if(new_user.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fill the username field.");
        } else if(new_user_password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fill the password field.");
        } else if(new_user_id.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill the id field.");
        } else if(new_user_name.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill the name field.");
        } else if(new_user_middle_name.isEmpty()){
            new_user_middle_name = null;
        } else if(new_user_last_name.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill the last name field.");
        } else if(BoxGenderNewUser.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Choose a valid option.");
        } else if(BoxNewUserDistrict.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Choose a valid option.");
        } else if(BoxInstitutionNewUser.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Choose a valid option.");
        } else {
            
            try{
                Person person = new Person(Integer.parseInt(new_user_id), new_user_name, new_user_middle_name, 
                    new_user_last_name, new SimpleDateFormat("dd/MM/yyyy").parse(new_user_birthday),
                    BoxGenderNewUser.getSelectedIndex(), BoxInstitutionNewUser.getSelectedIndex(), 
                    BoxNewUserDistrict.getSelectedIndex());
                User user = new User(new_user, new_user_password, person);
                ConnectDB.insertUser(user);
                JOptionPane.showMessageDialog(this, "The user was created successfully.");
            JPWelcome.setVisible(true);
            JPUserMenu.setVisible(false);
            JPAdminMenu.setVisible(false);
            AdminQuery.setVisible(false);
            AdminConfiguration.setVisible(false);
            UserCatalogues.setVisible(false);
            PersonCatalogues.setVisible(false);
            RecordCatalogues.setVisible(false);
            AdminStatistics.setVisible(false);
            JPSignUp.setVisible(false);
            NewUsernameField.setText(null);
            NewUserPasswordField.setText(null);
            UserQuery.setVisible(false);
            UserConfiguration.setVisible(false);
            JPLogin.setVisible(true);
            JPLogged.setVisible(false);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, "The user was NOT created successfully. Try again.");
            }
        }
    }//GEN-LAST:event_ButtonJoinActionPerformed

    private void JPSignUpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPSignUpMouseEntered
        JPSignUp.setVisible(true);
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPUserMenu.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPCreateRecord.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
    }//GEN-LAST:event_JPSignUpMouseEntered

    private void JPAdminMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPAdminMenuMouseEntered
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        JPLogged.setVisible(true);
        JPLogin.setVisible(false);
        JPAdminMenu.setVisible(true);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPUserMenu.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPCreateRecord.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
    }//GEN-LAST:event_JPAdminMenuMouseEntered

    private void JPUserMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPUserMenuMouseEntered
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        JPLogged.setVisible(true);
        JPLogin.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPCreateRecord.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPUserMenu.setVisible(true);
    }//GEN-LAST:event_JPUserMenuMouseEntered

    private void JPLoggedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPLoggedMouseEntered
        JPLogin.setVisible(false);
        JPLogged.setVisible(true);
        JPWelcome.setVisible(false);
    }//GEN-LAST:event_JPLoggedMouseEntered

    private void JPLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPLoginMouseEntered
        JPLogin.setVisible(true);
        JPLogged.setVisible(false);
    }//GEN-LAST:event_JPLoginMouseEntered

    private void UserQueryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserQueryMouseEntered
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPUserMenu.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPLogin.setVisible(false);
        JPLogged.setVisible(true);
        UserQuery.setVisible(true);
        UserConfiguration.setVisible(false);
    }//GEN-LAST:event_UserQueryMouseEntered

    @SuppressWarnings("empty-statement")
    private void ButtonShowPlacesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonShowPlacesActionPerformed
        String number_top = NumberTopField.getText();
        if(number_top.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fill the field for show the top.");
        }
        else
        {
            DefaultTableModel modelo = (DefaultTableModel)Table.getModel();
            modelo.setRowCount(0);
            modelo.setColumnCount(0);
            modelo.addColumn("District");
            modelo.addColumn("Quantity");
            try {
            ResultSet dangerous_places = ConnectDB.query("APP","user_queries.dangerous_places", Integer.parseInt(number_top));
            int i = 0;
            while(dangerous_places.next())
            {
                modelo.addRow(new Object[]{dangerous_places.getObject("name_district"), 
                    dangerous_places.getObject("quant_record")});
            }
            Table.setModel(modelo);
            } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ButtonShowPlacesActionPerformed

    private void ButtonShowRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonShowRecordsActionPerformed
        int index_category = BoxFilter.getSelectedIndex();
        int index_zone = BoxFilterSpecify.getSelectedIndex();
        String index_start = DateStartField.getText();
        String index_finish = DateEndField.getText();
        String filters [] = {BoxFilter.getItemAt(index_category), BoxFilterSpecify.getItemAt(index_zone), index_start, index_finish};
        String newFilters [] = {};
        for(int i = 0; i <= filters.length; i++) {
            if(filters[i] == "Default" || filters[i] == "Start Date" || filters[i] == "Finish Date") {
                newFilters[i] = "";
            }
        }
        filters = newFilters;
        //Aquí es donde se llama la función de la base de datos con los filtros y se agrega en la lista los valores
        String example[] = {"3D", "a5"};
        RecordsList.setListData(example);
    }//GEN-LAST:event_ButtonShowRecordsActionPerformed

    private void RecordsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RecordsListMouseClicked
        String record_number = RecordsList.getSelectedValue();
        RecordDescriptionText.setText(record_number);
    }//GEN-LAST:event_RecordsListMouseClicked

    private void ButtonCreateRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCreateRecordMouseEntered
        ButtonCreateRecord.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonCreateRecordMouseEntered

    private void ButtonCreateRecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCreateRecordMouseExited
        ButtonCreateRecord.setBorder(null);
    }//GEN-LAST:event_ButtonCreateRecordMouseExited

    private void ButtonCreateRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCreateRecordActionPerformed
        Animacion.Animacion.mover_derecha(290, 1100, 1, 1, JPUserMenu);
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        JPLogin.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPCreateOffender.setVisible(true);
        JPLogged.setVisible(true);
        try {
            fillInComboBox_Offender();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonCreateRecordActionPerformed

    private void JPCreateRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPCreateRecordMouseEntered
        JPUserMenu.setVisible(false);
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        JPCreateRecord.setVisible(true);
        JPLogin.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPLogged.setVisible(true);
        CheckBoxApproved.setEnabled(false);
    }//GEN-LAST:event_JPCreateRecordMouseEntered

    private void JPCreateOffenderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPCreateOffenderMouseEntered
        JPUserMenu.setVisible(false);
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPLogin.setVisible(false);
        JPCreateOffender.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_JPCreateOffenderMouseEntered

    private void ButtonRollbackCreateRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackCreateRecordMouseEntered
        ButtonRollbackCreateRecord.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonRollbackCreateRecordMouseEntered

    private void ButtonRollbackCreateRecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackCreateRecordMouseExited
        ButtonRollbackCreateRecord.setBorder(null);
    }//GEN-LAST:event_ButtonRollbackCreateRecordMouseExited

    private void ButtonRollbackCreateRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRollbackCreateRecordActionPerformed
        JPCreateOffender.setVisible(true);
        JPCreateRecord.setVisible(false);
    }//GEN-LAST:event_ButtonRollbackCreateRecordActionPerformed

    private void ButtonCancelOffenderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelOffenderMouseEntered
        ButtonCancelOffender.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonCancelOffenderMouseEntered

    private void ButtonCancelOffenderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelOffenderMouseExited
        ButtonCancelOffender.setBorder(null);
    }//GEN-LAST:event_ButtonCancelOffenderMouseExited

    private void ButtonCancelOffenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelOffenderActionPerformed
        JPWelcome.setVisible(false);
        JPUserMenu.setVisible(true);
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPSignUp.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        IdOffenderField.setText(null);
        NameOffenderField.setText(null);
        MiddleNameOffenderField.setText(null);
        LastNameOffenderField.setText(null);
        BirthdayOffenderField.setText(null);
        BoxGenderOffender.setSelectedIndex(0);
        BoxDistrictOffender.setSelectedIndex(0);
        BoxInstitutionOffender.setSelectedIndex(0);
    }//GEN-LAST:event_ButtonCancelOffenderActionPerformed

    private void ButtonConfirmOffenderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonConfirmOffenderMouseEntered
        ButtonConfirmOffender.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonConfirmOffenderMouseEntered

    private void ButtonConfirmOffenderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonConfirmOffenderMouseExited
        ButtonConfirmOffender.setBorder(null);
    }//GEN-LAST:event_ButtonConfirmOffenderMouseExited

    private void ButtonConfirmOffenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonConfirmOffenderActionPerformed
        String offender_id = IdOffenderField.getText();
        String offender_name = NameOffenderField.getText();
        String offender_middle_name = MiddleNameOffenderField.getText();
        String offender_last_name = LastNameOffenderField.getText();
        String offender_birthday = BirthdayOffenderField.getText();
        if(offender_id.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill the id field.");
        } else if(offender_name.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill the name field.");
        } else if(offender_middle_name.isEmpty()){
            offender_middle_name = null;
        } else if(offender_last_name.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill the last name field.");
        } else if(offender_birthday.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill the birthday field.");
        } else if(BoxGenderOffender.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Choose a valid option.");
        } else if(BoxDistrictOffender.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Choose a valid option.");
        } else if(BoxInstitutionOffender.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Choose a valid option.");
        } else {
             try{
                Person person = new Person(Integer.parseInt(offender_id), offender_name, offender_middle_name, offender_last_name, new SimpleDateFormat("dd/MM/yyyy").parse(offender_birthday), BoxGenderNewUser.getSelectedIndex(), BoxInstitutionNewUser.getSelectedIndex(), BoxNewUserDistrict.getSelectedIndex());
                ConnectDB.insert_person(person);
                JOptionPane.showMessageDialog(this, "The person was created successfully in the system.");
                Animacion.Animacion.mover_derecha(290, 1100, 1, 1, JPCreateOffender);
                JPAdminMenu.setVisible(false);
                AdminQuery.setVisible(false);
                AdminConfiguration.setVisible(false);
                UserCatalogues.setVisible(false);
                PersonCatalogues.setVisible(false);
                RecordCatalogues.setVisible(false);
                AdminStatistics.setVisible(false);
                JPUserMenu.setVisible(false);
                JPWelcome.setVisible(false);
                JPSignUp.setVisible(false);
                UserQuery.setVisible(false);
                UserConfiguration.setVisible(false);
                AdminQuery.setVisible(false);
                JPCreateRecord.setVisible(true);
                JPLogin.setVisible(false);
                JPLogged.setVisible(true);
            }
            catch(Exception e){}
            
        }
    }//GEN-LAST:event_ButtonConfirmOffenderActionPerformed

    private void ButtonRollbackQueryPlacesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackQueryPlacesMouseEntered
        ButtonRollbackQueryPlaces.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonRollbackQueryPlacesMouseEntered

    private void ButtonRollbackQueryPlacesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackQueryPlacesMouseExited
        ButtonRollbackQueryPlaces.setBorder(null);
    }//GEN-LAST:event_ButtonRollbackQueryPlacesMouseExited

    private void ButtonRollbackQueryPlacesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRollbackQueryPlacesActionPerformed
        JPWelcome.setVisible(false);
        JPUserMenu.setVisible(true);
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPSignUp.setVisible(false);
        JPLogged.setVisible(true);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        NumberTopField.setText(null);
        Table.removeAll();
    }//GEN-LAST:event_ButtonRollbackQueryPlacesActionPerformed

    private void ButtonRollbackQueryRecordsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackQueryRecordsMouseEntered
        ButtonRollbackQueryRecords.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonRollbackQueryRecordsMouseEntered

    private void ButtonRollbackQueryRecordsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackQueryRecordsMouseExited
        ButtonRollbackQueryRecords.setBorder(null);
    }//GEN-LAST:event_ButtonRollbackQueryRecordsMouseExited

    private void ButtonRollbackQueryRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRollbackQueryRecordsActionPerformed
        JPWelcome.setVisible(false);
        JPUserMenu.setVisible(true);
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPSignUp.setVisible(false);
        JPLogged.setVisible(true);
        UserConfiguration.setVisible(false);
        AdminQuery.setVisible(false);
        RecordsList.removeAll();
        RecordDescriptionText.setText(null);
        BoxFilter.setSelectedIndex(0);
        BoxFilterSpecify.setSelectedIndex(0);
        DateStartField.setText(null);
        DateEndField.setText(null);
    }//GEN-LAST:event_ButtonRollbackQueryRecordsActionPerformed

    private void ButtonRollbackQueryUsersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackQueryUsersMouseEntered
        ButtonRollbackQueryUsers.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonRollbackQueryUsersMouseEntered

    private void ButtonRollbackQueryUsersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackQueryUsersMouseExited
        ButtonRollbackQueryUsers.setBorder(null);
    }//GEN-LAST:event_ButtonRollbackQueryUsersMouseExited

    private void ButtonRollbackQueryUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRollbackQueryUsersActionPerformed
        JPWelcome.setVisible(false);
        JPUserMenu.setVisible(true);
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPSignUp.setVisible(false);
        JPLogin.setVisible(false);
        JPLogged.setVisible(true);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
    }//GEN-LAST:event_ButtonRollbackQueryUsersActionPerformed

    private void ButtonRollbackQueryBannedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackQueryBannedMouseEntered
        ButtonRollbackQueryBanned.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonRollbackQueryBannedMouseEntered

    private void ButtonRollbackQueryBannedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackQueryBannedMouseExited
        ButtonRollbackQueryBanned.setBorder(null);
    }//GEN-LAST:event_ButtonRollbackQueryBannedMouseExited

    private void ButtonRollbackQueryBannedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRollbackQueryBannedActionPerformed
        JPWelcome.setVisible(false);
        JPUserMenu.setVisible(true);
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPSignUp.setVisible(false);
        JPLogged.setVisible(true);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
    }//GEN-LAST:event_ButtonRollbackQueryBannedActionPerformed

    private void ButtonRollbackQueryExpireMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackQueryExpireMouseEntered
        ButtonRollbackQueryExpire.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonRollbackQueryExpireMouseEntered

    private void ButtonRollbackQueryExpireMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackQueryExpireMouseExited
        ButtonRollbackQueryExpire.setBorder(null);
    }//GEN-LAST:event_ButtonRollbackQueryExpireMouseExited

    private void ButtonRollbackQueryExpireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRollbackQueryExpireActionPerformed
        JPWelcome.setVisible(false);
        JPUserMenu.setVisible(true);
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPSignUp.setVisible(false);
        JPLogged.setVisible(true);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        RecordsExpireList.removeAll();
        RecordDescriptionTextExpire.setText(null);
        BoxStartDate1.setSelectedIndex(0);
        BoxFinishDate1.setSelectedIndex(0);
    }//GEN-LAST:event_ButtonRollbackQueryExpireActionPerformed

    private void PlacesMoreRecordsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlacesMoreRecordsMouseEntered
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPUserMenu.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPLogin.setVisible(false);
        JPLogged.setVisible(true);
        UserQuery.setVisible(true);
        UserConfiguration.setVisible(false);
        PlacesMoreRecords.setVisible(true);
        Records.setVisible(false);
        UsersList.setVisible(false);
        BannedUsers.setVisible(false);
        RecordsConvictionsToExpireOrExpired.setVisible(false);
    }//GEN-LAST:event_PlacesMoreRecordsMouseEntered

    private void RecordsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RecordsMouseEntered
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPUserMenu.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPLogin.setVisible(false);
        JPLogged.setVisible(true);
        UserQuery.setVisible(true);
        UserConfiguration.setVisible(false);
        PlacesMoreRecords.setVisible(false);
        Records.setVisible(true);
        UsersList.setVisible(false);
        BannedUsers.setVisible(false);
        RecordsConvictionsToExpireOrExpired.setVisible(false);
    }//GEN-LAST:event_RecordsMouseEntered

    private void UsersListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UsersListMouseEntered
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPUserMenu.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPLogin.setVisible(false);
        JPLogged.setVisible(true);
        UserQuery.setVisible(true);
        UserConfiguration.setVisible(false);
        PlacesMoreRecords.setVisible(false);
        Records.setVisible(false);
        UsersList.setVisible(true);
        BannedUsers.setVisible(false);
        RecordsConvictionsToExpireOrExpired.setVisible(false);
    }//GEN-LAST:event_UsersListMouseEntered

    private void BannedUsersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BannedUsersMouseEntered
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        JPAdminMenu.setVisible(false);AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPUserMenu.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPLogin.setVisible(false);
        JPLogged.setVisible(true);
        UserQuery.setVisible(true);
        UserConfiguration.setVisible(false);
        PlacesMoreRecords.setVisible(false);
        Records.setVisible(false);
        UsersList.setVisible(false);
        BannedUsers.setVisible(true);
        RecordsConvictionsToExpireOrExpired.setVisible(false);
    }//GEN-LAST:event_BannedUsersMouseEntered

    private void RecordsConvictionsToExpireOrExpiredMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RecordsConvictionsToExpireOrExpiredMouseEntered
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPUserMenu.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPLogin.setVisible(false);
        JPLogged.setVisible(true);
        UserQuery.setVisible(true);
        UserConfiguration.setVisible(false);
        AdminQuery.setVisible(false);
        PlacesMoreRecords.setVisible(false);
        Records.setVisible(false);
        UsersList.setVisible(false);
        BannedUsers.setVisible(false);
        RecordsConvictionsToExpireOrExpired.setVisible(true);
    }//GEN-LAST:event_RecordsConvictionsToExpireOrExpiredMouseEntered

    private void ButtonCancelNewRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelNewRecordMouseEntered
        ButtonCancelNewRecord.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonCancelNewRecordMouseEntered

    private void ButtonCancelNewRecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelNewRecordMouseExited
        ButtonCancelNewRecord.setBorder(null);
    }//GEN-LAST:event_ButtonCancelNewRecordMouseExited

    private void ButtonCancelNewRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelNewRecordActionPerformed
        JPWelcome.setVisible(false);
        JPUserMenu.setVisible(true);
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPSignUp.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        JPLogged.setVisible(true);
        JPLogin.setVisible(false);
        IdOffenderField.setText(null);
        NameOffenderField.setText(null);
        MiddleNameOffenderField.setText(null);
        LastNameOffenderField.setText(null);
        DateCrimeField.setText(null);
        ExpireDateField.setText(null);
        BoxGenderOffender.setSelectedIndex(0);
        BoxDistrictOffender.setSelectedIndex(0);
        BoxInstitutionOffender.setSelectedIndex(0);
    }//GEN-LAST:event_ButtonCancelNewRecordActionPerformed

    private void ButtonConfirmNewRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonConfirmNewRecordMouseEntered
        ButtonConfirmNewRecord.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonConfirmNewRecordMouseEntered

    private void ButtonConfirmNewRecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonConfirmNewRecordMouseExited
        ButtonConfirmNewRecord.setBorder(null);
    }//GEN-LAST:event_ButtonConfirmNewRecordMouseExited

    private void ButtonConfirmNewRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonConfirmNewRecordActionPerformed
        String number_record = RecordNumberField.getText();
        String crime_description = CrimeDescriptionField.getText();
        String date_crime = DateCrimeField.getText();
        String expire_date = ExpireDateField.getText();
        String resolution = ResolutionField.getText();
        String approved = "N";
        String[] pictures = null; //Moficar para que aquí reciba los paths de las fotos
        ArrayList<Pictures> pics = null;
        if(number_record.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill the number of the record field.");
        } else if(crime_description.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill the crime description field.");
        } else if(date_crime.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill the date of the crime field.");
        } else if(expire_date.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill the expire date field.");
        } else if(resolution.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill the resolution field.");
        }else if(BoxOffender.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Choose a valid option.");
        } else if(BoxCrimeType.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Choose a valid option.");
        } else if(BoxVeredict.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Choose a valid option.");
        } else if(BoxDistrictRecord.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Choose a valid option.");
        } else {
            try{
                if(CheckBoxApproved.isSelected())
                {
                    approved = "Y";
                }
                var record = new BL.Record(number_record, crime_description, new SimpleDateFormat("dd/MM/yyyy").parse(date_crime),
                        resolution, new SimpleDateFormat("dd/MM/yyyy").parse(expire_date), approved, BoxCrimeType.getSelectedIndex(), 
                        BoxOffender.getSelectedIndex(), BoxVeredict.getSelectedIndex(), BoxDistrictRecord.getSelectedIndex());
                
                ConnectDB.insert_record(record);
                for(String picture : pictures)
                {
                    Pictures pic = new BL.Pictures(picture,number_record);
                    pics.add(pic);
                    ConnectDB.insert_picture(pic);
                }
                JOptionPane.showMessageDialog(this, "The record was created successfully in the system.");
                JPAdminMenu.setVisible(true);
                AdminQuery.setVisible(false);
                AdminConfiguration.setVisible(false);
                UserCatalogues.setVisible(false);
                PersonCatalogues.setVisible(false);
                RecordCatalogues.setVisible(false);
                AdminStatistics.setVisible(false);
                JPUserMenu.setVisible(false);
                JPWelcome.setVisible(false);
                JPSignUp.setVisible(false);
                UserQuery.setVisible(false);
                UserConfiguration.setVisible(false);
                JPCreateRecord.setVisible(false);
                JPCreateOffender.setVisible(false);
                JPLogin.setVisible(false);
                JPLogged.setVisible(true);
            }
            catch(Exception e){}
        }
    }//GEN-LAST:event_ButtonConfirmNewRecordActionPerformed

    private void RightNewRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RightNewRecordMouseEntered
        RightNewRecord.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_RightNewRecordMouseEntered

    private void RightNewRecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RightNewRecordMouseExited
        RightNewRecord.setBorder(null);
    }//GEN-LAST:event_RightNewRecordMouseExited

    private void RightNewRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RightNewRecordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RightNewRecordActionPerformed

    private void LeftNewRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeftNewRecordMouseEntered
        LeftNewRecord.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_LeftNewRecordMouseEntered

    private void LeftNewRecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeftNewRecordMouseExited
        LeftNewRecord.setBorder(null);
    }//GEN-LAST:event_LeftNewRecordMouseExited

    private void LeftNewRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeftNewRecordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LeftNewRecordActionPerformed

    private void RemoveNewRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveNewRecordMouseEntered
        RemoveNewRecord.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_RemoveNewRecordMouseEntered

    private void RemoveNewRecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveNewRecordMouseExited
        RemoveNewRecord.setBorder(null);
    }//GEN-LAST:event_RemoveNewRecordMouseExited

    private void RemoveNewRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveNewRecordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RemoveNewRecordActionPerformed

    private void AddNewRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddNewRecordMouseEntered
        AddNewRecord.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_AddNewRecordMouseEntered

    private void AddNewRecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddNewRecordMouseExited
        AddNewRecord.setBorder(null);
    }//GEN-LAST:event_AddNewRecordMouseExited

    private void AddNewRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNewRecordActionPerformed

        
    }//GEN-LAST:event_AddNewRecordActionPerformed

    private void PictureNewRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PictureNewRecordActionPerformed
        
    }//GEN-LAST:event_PictureNewRecordActionPerformed

    private void PictureShowRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PictureShowRecordsActionPerformed
        
    }//GEN-LAST:event_PictureShowRecordsActionPerformed

    private void RightPicShowRecordsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RightPicShowRecordsMouseEntered
        RightPicShowRecords.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_RightPicShowRecordsMouseEntered

    private void RightPicShowRecordsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RightPicShowRecordsMouseExited
        RightPicShowRecords.setBorder(null);
    }//GEN-LAST:event_RightPicShowRecordsMouseExited

    private void RightPicShowRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RightPicShowRecordsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RightPicShowRecordsActionPerformed

    private void LeftPicShowRecordsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeftPicShowRecordsMouseEntered
        LeftPicShowRecords.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_LeftPicShowRecordsMouseEntered

    private void LeftPicShowRecordsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeftPicShowRecordsMouseExited
        LeftPicShowRecords.setBorder(null);
    }//GEN-LAST:event_LeftPicShowRecordsMouseExited

    private void LeftPicShowRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeftPicShowRecordsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LeftPicShowRecordsActionPerformed

    private void PictureRecordToExpireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PictureRecordToExpireActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PictureRecordToExpireActionPerformed

    private void RightPicRecordToExpireMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RightPicRecordToExpireMouseEntered
        RightPicRecordToExpire.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_RightPicRecordToExpireMouseEntered

    private void RightPicRecordToExpireMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RightPicRecordToExpireMouseExited
        RightPicRecordToExpire.setBorder(null);
    }//GEN-LAST:event_RightPicRecordToExpireMouseExited

    private void RightPicRecordToExpireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RightPicRecordToExpireActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RightPicRecordToExpireActionPerformed

    private void LeftPicRecordToExpireMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeftPicRecordToExpireMouseEntered
        LeftPicRecordToExpire.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_LeftPicRecordToExpireMouseEntered

    private void LeftPicRecordToExpireMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeftPicRecordToExpireMouseExited
        LeftPicRecordToExpire.setBorder(null);
    }//GEN-LAST:event_LeftPicRecordToExpireMouseExited

    private void LeftPicRecordToExpireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeftPicRecordToExpireActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LeftPicRecordToExpireActionPerformed

    private void ButtonCancelUpdatesUserLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelUpdatesUserLoginMouseEntered
        ButtonCancelUpdatesUserLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonCancelUpdatesUserLoginMouseEntered

    private void ButtonCancelUpdatesUserLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelUpdatesUserLoginMouseExited
        ButtonCancelUpdatesUserLogin.setBorder(null);
    }//GEN-LAST:event_ButtonCancelUpdatesUserLoginMouseExited

    private void ButtonCancelUpdatesUserLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelUpdatesUserLoginActionPerformed
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPUserMenu.setVisible(true);
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPCreateOffender.setVisible(false);
        UpdatePersonalInfo.setVisible(false);
        UpdateLoginInfo.setVisible(false);
        JPLogin.setVisible(false);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonCancelUpdatesUserLoginActionPerformed

    private void ButtonConfirmChangesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonConfirmChangesMouseEntered
        ButtonConfirmChanges.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonConfirmChangesMouseEntered

    private void ButtonConfirmChangesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonConfirmChangesMouseExited
        ButtonConfirmChanges.setBorder(null);
    }//GEN-LAST:event_ButtonConfirmChangesMouseExited

    private void ButtonConfirmChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonConfirmChangesActionPerformed
        String new_username = UpdateUsernameField.getText();
        String actual_password = (String) JOptionPane.showInputDialog(null,"Current password: ",JOptionPane.QUESTION_MESSAGE);
        //Que revise si es la contraseña igual
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPUserMenu.setVisible(true);
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPLogin.setVisible(false);
        JPLogged.setVisible(true);
        Username.setText(new_username);
    }//GEN-LAST:event_ButtonConfirmChangesActionPerformed

    private void UpdateLoginInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateLoginInfoMouseEntered
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPUserMenu.setVisible(false);
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(true);
        JPCreateRecord.setVisible(false);
        JPCreateOffender.setVisible(false);
        UpdatePersonalInfo.setVisible(false);
        UpdateLoginInfo.setVisible(true);
        JPLogin.setVisible(false);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_UpdateLoginInfoMouseEntered

    private void ButtonCancelUpdatesUserInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelUpdatesUserInfoMouseEntered
        ButtonCancelUpdatesUserInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonCancelUpdatesUserInfoMouseEntered

    private void ButtonCancelUpdatesUserInfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelUpdatesUserInfoMouseExited
        ButtonCancelUpdatesUserInfo.setBorder(null);
    }//GEN-LAST:event_ButtonCancelUpdatesUserInfoMouseExited

    private void ButtonCancelUpdatesUserInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelUpdatesUserInfoActionPerformed
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPUserMenu.setVisible(true);
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPCreateOffender.setVisible(false);
        UpdatePersonalInfo.setVisible(false);
        UpdateLoginInfo.setVisible(false);
        JPLogin.setVisible(false);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonCancelUpdatesUserInfoActionPerformed

    private void ButtonConfirmChangesUpdatePersonalInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonConfirmChangesUpdatePersonalInfoMouseEntered
        ButtonConfirmChangesUpdatePersonalInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonConfirmChangesUpdatePersonalInfoMouseEntered

    private void ButtonConfirmChangesUpdatePersonalInfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonConfirmChangesUpdatePersonalInfoMouseExited
        ButtonConfirmChangesUpdatePersonalInfo.setBorder(null);
    }//GEN-LAST:event_ButtonConfirmChangesUpdatePersonalInfoMouseExited

    private void ButtonConfirmChangesUpdatePersonalInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonConfirmChangesUpdatePersonalInfoActionPerformed
        String id = IdUpdateField.getText();
        String name = NameUpdateField.getText();
        String middle_name = MiddleNameUpdateField.getText();
        String last_name = LastNameUpdateField.getText();
        String birthday = BirthdayUpdateField.getText();
        if(id.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill the id of the person field.");
        } else if(name.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill the name of the person field.");
        } else if(middle_name.isEmpty()){
            middle_name = null;
        } else if(last_name.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill the expire date field.");
        }else if(BoxGenderUpdate.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Choose a valid option.");
        } else if(BoxCommunityUpdate.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Choose a valid option.");
        } else if(BoxInstitutionUpdate.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Choose a valid option.");
        } else {
            try{
                Person person = new Person(Integer.parseInt(id), name, middle_name, 
                        last_name, new SimpleDateFormat("dd/MM/yyyy").parse(birthday), 
                        BoxGenderUpdate.getSelectedIndex(), BoxInstitutionUpdate.getSelectedIndex(), 
                        BoxCommunityUpdate.getSelectedIndex());
                ConnectDB.insert_person(person);
                JOptionPane.showMessageDialog(this, "The person was updated successfully in the system.");
                JPAdminMenu.setVisible(false);
                AdminQuery.setVisible(false);
                AdminConfiguration.setVisible(false);
                UserCatalogues.setVisible(false);
                PersonCatalogues.setVisible(false);
                RecordCatalogues.setVisible(false);
                AdminStatistics.setVisible(false);
                JPUserMenu.setVisible(true);
                JPWelcome.setVisible(false);
                JPSignUp.setVisible(false);
                UserQuery.setVisible(false);
                UserConfiguration.setVisible(false);
                JPCreateRecord.setVisible(false);
                JPCreateOffender.setVisible(false);
                JPLogin.setVisible(false);
                JPLogged.setVisible(true);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, "The person was NOT updated successfully in the system. Try again");
            }
        }
    }//GEN-LAST:event_ButtonConfirmChangesUpdatePersonalInfoActionPerformed

    private void ButtonShowFilteredUserListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonShowFilteredUserListActionPerformed
        TableUsersPassword.removeAll();
        try {
            ResultSet all = ConnectDB.query("APP", "admin_queries.password_not_changed");
            DefaultTableModel modelo = (DefaultTableModel)TableUsersPassword.getModel();
            modelo.addColumn("Username");
            modelo.addColumn("Days");
            modelo.addColumn("Name");
            modelo.addColumn("Last Name");
            modelo.addColumn("Id");
            while(all.next())
            {
                modelo.addRow(new Object[]{all.getString("name_district")});
                BoxFilterIdPerson.addItem(all.getString("id"));
                BoxFilterNamePerson.addItem(all.getString("name"));
                BoxFilterLastNamePerson.addItem(all.getString("last_name"));
                BoxFilterUsernamePerson.addItem(all.getString("username"));   
            }
            TableUsersPassword.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonShowFilteredUserListActionPerformed

    private void PictureNewReportListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PictureNewReportListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PictureNewReportListActionPerformed

    private void RightPicNewReportListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RightPicNewReportListMouseEntered
        RightPicNewReportList.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_RightPicNewReportListMouseEntered

    private void RightPicNewReportListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RightPicNewReportListMouseExited
        RightPicNewReportList.setBorder(null);
    }//GEN-LAST:event_RightPicNewReportListMouseExited

    private void RightPicNewReportListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RightPicNewReportListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RightPicNewReportListActionPerformed

    private void LeftPicNewReportListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeftPicNewReportListMouseEntered
        LeftPicNewReportList.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_LeftPicNewReportListMouseEntered

    private void LeftPicNewReportListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeftPicNewReportListMouseExited
        LeftPicNewReportList.setBorder(null);
    }//GEN-LAST:event_LeftPicNewReportListMouseExited

    private void LeftPicNewReportListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeftPicNewReportListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LeftPicNewReportListActionPerformed

    private void ButtonRollbackReportListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackReportListMouseEntered
        ButtonRollbackReportList.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonRollbackReportListMouseEntered

    private void ButtonRollbackReportListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackReportListMouseExited
        ButtonRollbackReportList.setBorder(null);
    }//GEN-LAST:event_ButtonRollbackReportListMouseExited

    private void ButtonRollbackReportListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRollbackReportListActionPerformed
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPUserMenu.setVisible(true);
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPLogin.setVisible(false);
        JPLogged.setVisible(true);
        NewReportList.removeAll();
        ReportInformation.removeAll();
    }//GEN-LAST:event_ButtonRollbackReportListActionPerformed

    private void ButtonRollbackUserListNotChangePasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackUserListNotChangePasswordMouseEntered
        ButtonRollbackUserListNotChangePassword.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonRollbackUserListNotChangePasswordMouseEntered

    private void ButtonRollbackUserListNotChangePasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackUserListNotChangePasswordMouseExited
        ButtonRollbackUserListNotChangePassword.setBorder(null);
    }//GEN-LAST:event_ButtonRollbackUserListNotChangePasswordMouseExited

    private void ButtonRollbackUserListNotChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRollbackUserListNotChangePasswordActionPerformed
        JPAdminMenu.setVisible(true);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPUserMenu.setVisible(false);
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPLogin.setVisible(false);
        JPLogged.setVisible(true);
        TableUsersPassword.removeAll();
    }//GEN-LAST:event_ButtonRollbackUserListNotChangePasswordActionPerformed

    private void AdminQueryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminQueryMouseEntered
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(true);
        JPUserMenu.setVisible(false);
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPLogin.setVisible(false);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_AdminQueryMouseEntered

    private void ButtonLogUserListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLogUserListActionPerformed
        String dateStart = DateStartField.getText();
        String dateFinish = DateEndField.getText();
        String filters [] = {dateStart, dateFinish};
        String newFilters [] = {};
        for(int i = 0; i <= filters.length; i++) {
            if(filters[i] == "Start Date" || filters[i] == "FinishDate") {
                newFilters[i] = null;
            }
        }
        filters = newFilters;
        //Aquí es donde se llama la función de la base de datos con los filtros y se agrega en la lista los valores
        String example[] = {"3D", "a5"};
        //Sino hubieran datos que tire los usuarios de forma ascendente o como sea haha
        RecordsList.setListData(example);
    }//GEN-LAST:event_ButtonLogUserListActionPerformed

    private void ButtonRollbackLogMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackLogMouseEntered
        ButtonRollbackLog.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonRollbackLogMouseEntered

    private void ButtonRollbackLogMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackLogMouseExited
        ButtonRollbackLog.setBorder(null);
    }//GEN-LAST:event_ButtonRollbackLogMouseExited

    private void ButtonRollbackLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRollbackLogActionPerformed
        JPAdminMenu.setVisible(true);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPUserMenu.setVisible(false);
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPLogin.setVisible(false);
        JPLogged.setVisible(true);
        LogUserList.removeAll();
        BoxLogStartDate.setSelectedIndex(0);
        BoxLogFinishDate.setSelectedIndex(0);
    }//GEN-LAST:event_ButtonRollbackLogActionPerformed

    private void ButtonShowRecordsDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonShowRecordsDateActionPerformed
        int index_start = BoxStartDate1.getSelectedIndex();
        int index_finish = BoxFinishDate1.getSelectedIndex();
        String filters [] = {BoxStartDate1.getItemAt(index_start), BoxFinishDate1.getItemAt(index_finish)};
        String newFilters [] = {};
        for(int i = 0; i <= filters.length; i++) {
            if(filters[i] == "Start Date" || filters[i] == "FinishDate") {
                newFilters[i] = null;
            }
        }
        filters = newFilters;
        //Aquí es donde se llama la función de la base de datos con los filtros y se agrega en la lista los valores
        String example[] = {"3D", "a5"};
        RecordsList.setListData(example);
    }//GEN-LAST:event_ButtonShowRecordsDateActionPerformed

    private void ButtonCancelUpdatesUserLoginAdminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelUpdatesUserLoginAdminMouseEntered
        ButtonCancelUpdatesUserLoginAdmin.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonCancelUpdatesUserLoginAdminMouseEntered

    private void ButtonCancelUpdatesUserLoginAdminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelUpdatesUserLoginAdminMouseExited
        ButtonCancelUpdatesUserLoginAdmin.setBorder(null);
    }//GEN-LAST:event_ButtonCancelUpdatesUserLoginAdminMouseExited

    private void ButtonCancelUpdatesUserLoginAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelUpdatesUserLoginAdminActionPerformed
        JPAdminMenu.setVisible(true);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPUserMenu.setVisible(false);
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPLogin.setVisible(false);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonCancelUpdatesUserLoginAdminActionPerformed

    private void ButtonConfirmChangesAdminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonConfirmChangesAdminMouseEntered
        ButtonConfirmChangesAdmin.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonConfirmChangesAdminMouseEntered

    private void ButtonConfirmChangesAdminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonConfirmChangesAdminMouseExited
        ButtonConfirmChangesAdmin.setBorder(null);
    }//GEN-LAST:event_ButtonConfirmChangesAdminMouseExited

    private void ButtonConfirmChangesAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonConfirmChangesAdminActionPerformed
        String actual_username = ActualUsername.getText();
        String new_username = AdminUpdateUsernameField.getText();
        String password = (String) JOptionPane.showInputDialog(null,"Current password: ",JOptionPane.QUESTION_MESSAGE);
        String newPassword = AdminUpdatePasswordField.getText();
        int newType = BoxAdminUserTypeUpdate.getSelectedIndex();
        if(actual_username.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill the actual username field.");
        } else if(new_username.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill the new username field.");
        } else if(password.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill the password field.");
        } else if(newPassword.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill the new pasword field.");
        } else if(newType == 0){
            JOptionPane.showMessageDialog(this, "Fill the new type field.");    
        } else {
             try{
                if(ConnectDB.checkLogin(actual_username, password) == -1)
                {
                    JOptionPane.showMessageDialog(this, "Incorrect Username or password.");
                }
                else
                {
                    ConnectDB.editUserPassword(actual_username, password, newPassword);
                    ConnectDB.editUserType(actual_username,newType);
                    ConnectDB.editUsername(actual_username, new_username);
                    JOptionPane.showMessageDialog(this, "The user was updated successfully in the system.");
                    Animacion.Animacion.mover_derecha(290, 1100, 1, 1, JPCreateOffender);
                    JPAdminMenu.setVisible(true);
                    AdminQuery.setVisible(false);
                    AdminConfiguration.setVisible(false);
                    UserCatalogues.setVisible(false);
                    PersonCatalogues.setVisible(false);
                    RecordCatalogues.setVisible(false);
                    AdminStatistics.setVisible(false);
                    JPUserMenu.setVisible(false);
                    JPWelcome.setVisible(false);
                    JPSignUp.setVisible(false);
                    UserQuery.setVisible(false);
                    UserConfiguration.setVisible(false);
                    JPCreateRecord.setVisible(false);
                    JPCreateOffender.setVisible(false);
                    JPLogin.setVisible(false);
                    JPLogged.setVisible(true);
                    Username.setText(new_username);
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, "The user was NOT updated successfully. Try again.");
            }
        }
    }//GEN-LAST:event_ButtonConfirmChangesAdminActionPerformed

    private void ButtonCancelUpdatesAdminInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelUpdatesAdminInfoMouseEntered
        ButtonCancelUpdatesAdminInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonCancelUpdatesAdminInfoMouseEntered

    private void ButtonCancelUpdatesAdminInfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelUpdatesAdminInfoMouseExited
        ButtonCancelUpdatesAdminInfo.setBorder(null);
    }//GEN-LAST:event_ButtonCancelUpdatesAdminInfoMouseExited

    private void ButtonCancelUpdatesAdminInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelUpdatesAdminInfoActionPerformed
        JPAdminMenu.setVisible(true);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPUserMenu.setVisible(false);
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPLogin.setVisible(false);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonCancelUpdatesAdminInfoActionPerformed

    private void ButtonConfirmChangesUpdateAdminPersonalInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonConfirmChangesUpdateAdminPersonalInfoMouseEntered
        ButtonConfirmChangesUpdateAdminPersonalInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonConfirmChangesUpdateAdminPersonalInfoMouseEntered

    private void ButtonConfirmChangesUpdateAdminPersonalInfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonConfirmChangesUpdateAdminPersonalInfoMouseExited
        ButtonConfirmChangesUpdateAdminPersonalInfo.setBorder(null);
    }//GEN-LAST:event_ButtonConfirmChangesUpdateAdminPersonalInfoMouseExited

    private void ButtonConfirmChangesUpdateAdminPersonalInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonConfirmChangesUpdateAdminPersonalInfoActionPerformed
        String id = UpdateAdminIdField.getText();
        String new_name = UpdateAdminNameField.getText();
        String new_middle_name = UpdateAdminMiddleNameField.getText();
        String new_last_name = UpdateAdminLastNameField.getText();
        String new_birthday = UpdateAdminBirthdayField.getText();
        if(id.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill the id field.");
        } else if(new_name.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill the name field.");
        } else if(new_middle_name.isEmpty()){
            new_middle_name = null;
        } else if(new_last_name.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill the last name field.");
        } else if(new_birthday.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill the birthday field.");
        } else if(BoxGenderAdminUpdate.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Choose a valid option.");
        } else if(BoxDistrictAdminUpdate.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Choose a valid option.");
        } else if(BoxInstitutionAdminUpdate.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Choose a valid option.");
        } else {
             try{
                Person person = new Person(Integer.parseInt(id), new_name, new_middle_name, 
                        new_last_name, new SimpleDateFormat("dd/MM/yyyy").parse(new_birthday), 
                        BoxGenderAdminUpdate.getSelectedIndex(), BoxInstitutionAdminUpdate.getSelectedIndex(), 
                        BoxDistrictAdminUpdate.getSelectedIndex());
                ConnectDB.update_person(person);
                JOptionPane.showMessageDialog(this, "The person was updated successfully in the system.");
                Animacion.Animacion.mover_derecha(290, 1100, 1, 1, JPCreateOffender);
                JPAdminMenu.setVisible(true);
                AdminQuery.setVisible(false);
                AdminConfiguration.setVisible(false);
                UserCatalogues.setVisible(false);
                PersonCatalogues.setVisible(false);
                RecordCatalogues.setVisible(false);
                AdminStatistics.setVisible(false);
                JPUserMenu.setVisible(false);
                JPWelcome.setVisible(false);
                JPSignUp.setVisible(false);
                UserQuery.setVisible(false);
                UserConfiguration.setVisible(false);
                JPCreateRecord.setVisible(false);
                JPCreateOffender.setVisible(false);
                JPLogin.setVisible(false);
                JPLogged.setVisible(true);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, "The person was NOT updated successfully. Try again.");
            }
        }
    }//GEN-LAST:event_ButtonConfirmChangesUpdateAdminPersonalInfoActionPerformed

    private void ButtonRollbackCataloguesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackCataloguesMouseEntered
        ButtonRollbackCatalogues.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonRollbackCataloguesMouseEntered

    private void ButtonRollbackCataloguesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackCataloguesMouseExited
        ButtonRollbackCatalogues.setBorder(null);
    }//GEN-LAST:event_ButtonRollbackCataloguesMouseExited

    private void ButtonRollbackCataloguesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRollbackCataloguesActionPerformed
        JPAdminMenu.setVisible(true);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPUserMenu.setVisible(false);
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPLogin.setVisible(false);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonRollbackCataloguesActionPerformed

    private void ButtonCancelUnapprovedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelUnapprovedMouseEntered
        ButtonCancelUnapproved.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonCancelUnapprovedMouseEntered

    private void ButtonCancelUnapprovedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelUnapprovedMouseExited
        ButtonCancelUnapproved.setBorder(null);
    }//GEN-LAST:event_ButtonCancelUnapprovedMouseExited

    private void ButtonCancelUnapprovedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelUnapprovedActionPerformed
        JPAdminMenu.setVisible(true);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPUserMenu.setVisible(false);
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPLogin.setVisible(false);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonCancelUnapprovedActionPerformed

    private void ButtonBanUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonBanUserMouseEntered
        ButtonBanUser.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonBanUserMouseEntered

    private void ButtonBanUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonBanUserMouseExited
        ButtonBanUser.setBorder(null);
    }//GEN-LAST:event_ButtonBanUserMouseExited

    private void ButtonBanUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBanUserActionPerformed
        
    }//GEN-LAST:event_ButtonBanUserActionPerformed

    private void PictureUnapprovedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PictureUnapprovedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PictureUnapprovedActionPerformed

    private void RightUnapprovedPicMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RightUnapprovedPicMouseEntered
        RightUnapprovedPic.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_RightUnapprovedPicMouseEntered

    private void RightUnapprovedPicMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RightUnapprovedPicMouseExited
        RightUnapprovedPic.setBorder(null);
    }//GEN-LAST:event_RightUnapprovedPicMouseExited

    private void RightUnapprovedPicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RightUnapprovedPicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RightUnapprovedPicActionPerformed

    private void LeftUnapprovedPicMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeftUnapprovedPicMouseEntered
        LeftUnapprovedPic.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_LeftUnapprovedPicMouseEntered

    private void LeftUnapprovedPicMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeftUnapprovedPicMouseExited
        LeftUnapprovedPic.setBorder(null);
    }//GEN-LAST:event_LeftUnapprovedPicMouseExited

    private void LeftUnapprovedPicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeftUnapprovedPicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LeftUnapprovedPicActionPerformed

    private void AddUnapprovedPicMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddUnapprovedPicMouseEntered
        AddUnapprovedPic.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_AddUnapprovedPicMouseEntered

    private void AddUnapprovedPicMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddUnapprovedPicMouseExited
        AddUnapprovedPic.setBorder(null);
    }//GEN-LAST:event_AddUnapprovedPicMouseExited

    private void AddUnapprovedPicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddUnapprovedPicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddUnapprovedPicActionPerformed

    private void RemoveUnapprovedPicMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveUnapprovedPicMouseEntered
        RemoveUnapprovedPic.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_RemoveUnapprovedPicMouseEntered

    private void RemoveUnapprovedPicMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveUnapprovedPicMouseExited
        RemoveUnapprovedPic.setBorder(null);
    }//GEN-LAST:event_RemoveUnapprovedPicMouseExited

    private void RemoveUnapprovedPicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveUnapprovedPicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RemoveUnapprovedPicActionPerformed

    private void ButtonConfirmUnapprovedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonConfirmUnapprovedMouseEntered
        ButtonConfirmUnapproved.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonConfirmUnapprovedMouseEntered

    private void ButtonConfirmUnapprovedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonConfirmUnapprovedMouseExited
        ButtonConfirmUnapproved.setBorder(null);
    }//GEN-LAST:event_ButtonConfirmUnapprovedMouseExited

    private void ButtonConfirmUnapprovedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonConfirmUnapprovedActionPerformed
        if(CheckBoxApprovedOrNot.isSelected())
        {
            try {
                ConnectDB.approve_record(ListUnapprovedRecords.getSelectedValue());
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        JPAdminMenu.setVisible(true);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPUserMenu.setVisible(false);
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPLogin.setVisible(false);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonConfirmUnapprovedActionPerformed

    private void ButtonConfirmUserCatalogueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonConfirmUserCatalogueActionPerformed
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(true);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        JPLogin.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonConfirmUserCatalogueActionPerformed

    private void AddUserTypeCatalogueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddUserTypeCatalogueMouseEntered
        AddUserTypeCatalogue.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_AddUserTypeCatalogueMouseEntered

    private void AddUserTypeCatalogueMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddUserTypeCatalogueMouseExited
        AddUserTypeCatalogue.setBorder(null);
    }//GEN-LAST:event_AddUserTypeCatalogueMouseExited

    private void AddBannedReasonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBannedReasonMouseEntered
        AddBannedReason.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_AddBannedReasonMouseEntered

    private void AddBannedReasonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBannedReasonMouseExited
        AddBannedReason.setBorder(null);
    }//GEN-LAST:event_AddBannedReasonMouseExited

    private void RemoveBannedReasonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveBannedReasonMouseEntered
        RemoveBannedReason.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_RemoveBannedReasonMouseEntered

    private void RemoveBannedReasonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveBannedReasonMouseExited
        RemoveBannedReason.setBorder(null);
    }//GEN-LAST:event_RemoveBannedReasonMouseExited

    private void ButtonConfirmUserCatalogueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonConfirmUserCatalogueMouseEntered
        ButtonConfirmUserCatalogue.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonConfirmUserCatalogueMouseEntered

    private void ButtonConfirmUserCatalogueMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonConfirmUserCatalogueMouseExited
        ButtonConfirmUserCatalogue.setBorder(null);
    }//GEN-LAST:event_ButtonConfirmUserCatalogueMouseExited

    private void AddUserTypeCatalogueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddUserTypeCatalogueActionPerformed
        String new_user_type = (String) JOptionPane.showInputDialog(null,"New user type: ",JOptionPane.QUESTION_MESSAGE);
        UserType usertype = new UserType(new_user_type);
        try {
            ConnectDB.insertUserType(usertype);
            JOptionPane.showMessageDialog(this, "The user type was created successfully.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "The user type was NOT created successfully. Try again.");
        }
    }//GEN-LAST:event_AddUserTypeCatalogueActionPerformed

    private void RemoveUserTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveUserTypeActionPerformed
        int index_usertype = BoxModifyUserType.getSelectedIndex();
        try {
            ConnectDB.delete("ADM", "adminUser.removeUserType", index_usertype);
            JOptionPane.showMessageDialog(this, "The user type was deleted successfully.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "The user type was NOT deleted successfully. Try again.");
        }
    }//GEN-LAST:event_RemoveUserTypeActionPerformed

    private void AddBannedReasonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBannedReasonActionPerformed
        String new_banned_reason = (String) JOptionPane.showInputDialog(null,"New banned reason: ",JOptionPane.QUESTION_MESSAGE);
        BannedReason banned_reason = new BannedReason(new_banned_reason);
        try {
            ConnectDB.insertBannedReason(banned_reason);
            JOptionPane.showMessageDialog(this, "The banned reason was created successfully.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "The banned reason was NOT created successfully. Try again.");
        }
    }//GEN-LAST:event_AddBannedReasonActionPerformed

    private void RemoveBannedReasonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveBannedReasonActionPerformed
        int index_bannedReason = BoxModifyBannedReason.getSelectedIndex();
       try {
            ConnectDB.delete("ADM", "adminUser.removeBannedReason", index_bannedReason);
            JOptionPane.showMessageDialog(this, "The banned reason was deleted successfully.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "The banned reason was NOT deleted successfully. Try again.");
        }
    }//GEN-LAST:event_RemoveBannedReasonActionPerformed

    private void ButtonConfirmPersonCatalogueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonConfirmPersonCatalogueActionPerformed
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(true);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        JPLogin.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonConfirmPersonCatalogueActionPerformed

    private void AddGenderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddGenderMouseEntered
        AddGender.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_AddGenderMouseEntered

    private void AddGenderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddGenderMouseExited
        AddGender.setBorder(null);
    }//GEN-LAST:event_AddGenderMouseExited

    private void RemoveGenderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveGenderMouseEntered
        RemoveGender.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_RemoveGenderMouseEntered

    private void RemoveGenderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveGenderMouseExited
        RemoveGender.setBorder(null);
    }//GEN-LAST:event_RemoveGenderMouseExited

    private void AddInstitutionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddInstitutionMouseEntered
        AddInstitution.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_AddInstitutionMouseEntered

    private void AddInstitutionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddInstitutionMouseExited
        AddInstitution.setBorder(null);
    }//GEN-LAST:event_AddInstitutionMouseExited

    private void RemoveInstitutionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveInstitutionMouseEntered
        RemoveInstitution.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_RemoveInstitutionMouseEntered

    private void RemoveInstitutionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveInstitutionMouseExited
        RemoveInstitution.setBorder(null);
    }//GEN-LAST:event_RemoveInstitutionMouseExited

    private void AddCountryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddCountryMouseEntered
        AddCountry.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_AddCountryMouseEntered

    private void AddCountryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddCountryMouseExited
        AddCountry.setBorder(null);
    }//GEN-LAST:event_AddCountryMouseExited

    private void RemoveCountryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveCountryMouseEntered
        AddCountry.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_RemoveCountryMouseEntered

    private void RemoveCountryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveCountryMouseExited
        RemoveCountry.setBorder(null);
    }//GEN-LAST:event_RemoveCountryMouseExited

    private void AddStateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddStateMouseEntered
        AddState.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_AddStateMouseEntered

    private void AddStateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddStateMouseExited
        AddState.setBorder(null);
    }//GEN-LAST:event_AddStateMouseExited

    private void RemoveStateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveStateMouseEntered
        RemoveState.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_RemoveStateMouseEntered

    private void RemoveStateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveStateMouseExited
        RemoveState.setBorder(null);
    }//GEN-LAST:event_RemoveStateMouseExited

    private void AddCityMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddCityMouseEntered
        AddCity.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_AddCityMouseEntered

    private void AddCityMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddCityMouseExited
        AddCity.setBorder(null);
    }//GEN-LAST:event_AddCityMouseExited

    private void RemoveCityMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveCityMouseEntered
        RemoveCity.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_RemoveCityMouseEntered

    private void ButtonConfirmPersonCatalogueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonConfirmPersonCatalogueMouseEntered
        ButtonConfirmPersonCatalogue.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonConfirmPersonCatalogueMouseEntered

    private void ButtonConfirmPersonCatalogueMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonConfirmPersonCatalogueMouseExited
        ButtonConfirmPersonCatalogue.setBorder(null);
    }//GEN-LAST:event_ButtonConfirmPersonCatalogueMouseExited

    private void AddGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddGenderActionPerformed
        String new_gender = (String) JOptionPane.showInputDialog(null,"New gender: ",JOptionPane.QUESTION_MESSAGE);
        Gender gender = new Gender(new_gender);
        try {
            ConnectDB.insert_gender(gender);
            JOptionPane.showMessageDialog(this, "The gender was created successfully.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "The gender was NOT created successfully. Try again.");
        }
    }//GEN-LAST:event_AddGenderActionPerformed

    private void RemoveGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveGenderActionPerformed
        int index_gender = BoxModifyGender.getSelectedIndex();
        try {
            ConnectDB.delete("APP", "admin_gender.remove_gender", index_gender);
            JOptionPane.showMessageDialog(this, "The gender was deleted successfully.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "The gender was NOT deleted successfully. Try again.");
        }
    }//GEN-LAST:event_RemoveGenderActionPerformed

    private void AddInstitutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddInstitutionActionPerformed
        String new_institution= (String) JOptionPane.showInputDialog(null,"New institution: ",JOptionPane.QUESTION_MESSAGE);
        Institution institution = new Institution(new_institution);
        try {
            ConnectDB.insert_institution(institution);
            JOptionPane.showMessageDialog(this, "The institution was created successfully.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "The institution was NOT created successfully. Try again.");
        }
    }//GEN-LAST:event_AddInstitutionActionPerformed

    private void RemoveInstitutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveInstitutionActionPerformed
        int index_institution = BoxModifyInstitution.getSelectedIndex();
        try {
            ConnectDB.delete("APP", "admin_institution.remove_institution", index_institution);
            JOptionPane.showMessageDialog(this, "The institutions was deleted successfully.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "The institutions was NOT deleted successfully. Try again.");
        }
    }//GEN-LAST:event_RemoveInstitutionActionPerformed

    private void AddCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCountryActionPerformed
        String new_country = (String) JOptionPane.showInputDialog(null,"New country: ",JOptionPane.QUESTION_MESSAGE);
        Country country = new Country(new_country);
        try {
            ConnectDB.insert_country(country);
            JOptionPane.showMessageDialog(this, "The country was created successfully. Try again.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "The country was NOT created successfully. Try again.");
        }
    }//GEN-LAST:event_AddCountryActionPerformed

    private void RemoveCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveCountryActionPerformed
        int index_country = BoxModifyCountry.getSelectedIndex();
        try {
            ConnectDB.delete("APP", "admin_country.remove_country", index_country);
            JOptionPane.showMessageDialog(this, "The country was deleted successfully. Try again.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "The country was NOT deleted successfully. Try again.");
        }
    }//GEN-LAST:event_RemoveCountryActionPerformed

    private void AddStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddStateActionPerformed
        String new_state = (String) JOptionPane.showInputDialog(null,"New state: ",JOptionPane.QUESTION_MESSAGE);
        if(JOptionPane.showConfirmDialog(null,"The state will be added with the country selected",
                "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            int country_index = BoxModifyCountry.getSelectedIndex();
            if(country_index != 0)
            {
                State state = new State(new_state, country_index);
                try {
                    ConnectDB.insert_state(state);
                    JOptionPane.showMessageDialog(this, "The state was created successfully. Try again.");
                } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "The state was NOT created successfully. Try again.");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Please select a Country. And try again.");
            }
        }
    }//GEN-LAST:event_AddStateActionPerformed

    private void RemoveStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveStateActionPerformed
        int index_state = BoxModifyState.getSelectedIndex();
        try {
            ConnectDB.delete("APP", "admin_state.remove_state", index_state);
            JOptionPane.showMessageDialog(this, "The state was deleted successfully. Try again.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "The state was NOT deleted successfully. Try again.");
        }
    }//GEN-LAST:event_RemoveStateActionPerformed

    private void AddCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCityActionPerformed
        String new_city = (String) JOptionPane.showInputDialog(null,"New city: ",JOptionPane.QUESTION_MESSAGE);
        if(JOptionPane.showConfirmDialog(null,"The city will be added with the State selected",
                "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            int state_index = BoxModifyState.getSelectedIndex();
            if(state_index != 0)
            {
                City city = new City(new_city, state_index);
                try {
                    ConnectDB.insert_city(city);
                    JOptionPane.showMessageDialog(this, "The city was created successfully. Try again.");
                } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "The city was NOT created successfully. Try again.");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Please select a State. And try again.");
            }
        }
    }//GEN-LAST:event_AddCityActionPerformed

    private void RemoveCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveCityActionPerformed
        int index_city = BoxModifyCity.getSelectedIndex();
        try {
            ConnectDB.delete("APP", "admin_city.remove_city", index_city);
            JOptionPane.showMessageDialog(this, "The city was deleted successfully. Try again.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "The city was NOT deleted successfully. Try again.");
        }
    }//GEN-LAST:event_RemoveCityActionPerformed

    private void RemoveCityMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveCityMouseExited
        RemoveCity.setBorder(null);
    }//GEN-LAST:event_RemoveCityMouseExited

    private void ButtonCancelRecordCatalogueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelRecordCatalogueActionPerformed
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(true);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        JPLogin.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonCancelRecordCatalogueActionPerformed

    private void AddTypeCrimeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddTypeCrimeMouseEntered
        AddTypeCrime.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_AddTypeCrimeMouseEntered

    private void AddTypeCrimeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddTypeCrimeMouseExited
        AddTypeCrime.setBorder(null);
    }//GEN-LAST:event_AddTypeCrimeMouseExited

    private void RemoveTypeCrimeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveTypeCrimeMouseEntered
        RemoveTypeCrime.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_RemoveTypeCrimeMouseEntered

    private void RemoveTypeCrimeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveTypeCrimeMouseExited
        RemoveTypeCrime.setBorder(null);
    }//GEN-LAST:event_RemoveTypeCrimeMouseExited

    private void AddTypeSentenceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddTypeSentenceMouseEntered
        AddTypeSentence.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_AddTypeSentenceMouseEntered

    private void AddTypeSentenceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddTypeSentenceMouseExited
        AddTypeSentence.setBorder(null);
    }//GEN-LAST:event_AddTypeSentenceMouseExited

    private void RemoveTypeSentenceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveTypeSentenceMouseEntered
        RemoveTypeSentence.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_RemoveTypeSentenceMouseEntered

    private void RemoveTypeSentenceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveTypeSentenceMouseExited
        RemoveTypeSentence.setBorder(null);
    }//GEN-LAST:event_RemoveTypeSentenceMouseExited

    private void ButtonCancelRecordCatalogueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelRecordCatalogueMouseEntered
        ButtonCancelRecordCatalogue.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonCancelRecordCatalogueMouseEntered

    private void ButtonCancelRecordCatalogueMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelRecordCatalogueMouseExited
        ButtonCancelRecordCatalogue.setBorder(null);
    }//GEN-LAST:event_ButtonCancelRecordCatalogueMouseExited

    private void AddTypeCrimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTypeCrimeActionPerformed
        String new_type = (String) JOptionPane.showInputDialog(null,"New type crime: ",JOptionPane.QUESTION_MESSAGE);
        var type = new Types(" ");
        try {
            ConnectDB.insert_type(type);
            JOptionPane.showMessageDialog(this, "The type was created successfully.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "The type was NOT created successfully. Try again.");
        }
    }//GEN-LAST:event_AddTypeCrimeActionPerformed

    private void RemoveTypeCrimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveTypeCrimeActionPerformed
        int index_type_crime = BoxModifyTypeCrime.getSelectedIndex();
        String type_crime = BoxModifyTypeCrime.getItemAt(index_type_crime);
        //Borrar de la base
    }//GEN-LAST:event_RemoveTypeCrimeActionPerformed

    private void AddTypeSentenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTypeSentenceActionPerformed
       String new_type_sentence = (String) JOptionPane.showInputDialog(null,"New type sentence: ",JOptionPane.QUESTION_MESSAGE);
        //Agregarlo a la base
    }//GEN-LAST:event_AddTypeSentenceActionPerformed

    private void RemoveTypeSentenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveTypeSentenceActionPerformed
        int index_type_sentence = BoxModifyTypeSentence.getSelectedIndex();
        String type_sentence = BoxModifyTypeSentence.getItemAt(index_type_sentence);
        //Borrar de la base
    }//GEN-LAST:event_RemoveTypeSentenceActionPerformed

    private void ButtonEnterReportsZoneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonEnterReportsZoneMouseEntered
        ButtonEnterReportsZone.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonEnterReportsZoneMouseEntered

    private void ButtonEnterReportsZoneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonEnterReportsZoneMouseExited
        ButtonEnterReportsZone.setBorder(null);
    }//GEN-LAST:event_ButtonEnterReportsZoneMouseExited

    private void ButtonEnterReportsZoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEnterReportsZoneActionPerformed
        int index_country = BoxCountry.getSelectedIndex();
        int index_state = BoxState.getSelectedIndex();
        int index_city = BoxCity.getSelectedIndex();
        int index_district = BoxDistrict.getSelectedIndex();
        String filters [] = {BoxCountry.getItemAt(index_country), BoxState.getItemAt(index_state), BoxCity.getItemAt(index_city), BoxDistrict.getItemAt(index_district)};
        String newFilters [] = {};
        for(int i = 0; i <= filters.length; i++) {
            if(filters[i] == "Default") {
                newFilters[i] = null;
            }
        }
        filters = newFilters;
        try {
            ResultSet records = ConnectDB.query("ADM","statics.records_clasification");
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            float per = 0;
            while(records.next())
            {
                per = records.getFloat("percentage");
                dataset.addValue(new Double(per),records.getString("name"), "Quantity");
            }
            var chart = ChartFactory.createBarChart("Records by zone", "Zones", "Quantity",dataset, PlotOrientation.VERTICAL, 
                    true,true, false);
            ChartPanel panel = new ChartPanel(chart);
            jPanel1.add(panel);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        String example[] = {"3D", "a5"};
        RecordsList.setListData(example);
    }//GEN-LAST:event_ButtonEnterReportsZoneActionPerformed

    private void ButtonEnterPersonRecordsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonEnterPersonRecordsMouseEntered
        ButtonEnterPersonRecords.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonEnterPersonRecordsMouseEntered

    private void ButtonEnterPersonRecordsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonEnterPersonRecordsMouseExited
        ButtonEnterPersonRecords.setBorder(null);
    }//GEN-LAST:event_ButtonEnterPersonRecordsMouseExited

    private void ButtonEnterPersonRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEnterPersonRecordsActionPerformed
        int index_country = BoxCountryPersonRecords.getSelectedIndex();
        int index_state = BoxStatePersonRecords.getSelectedIndex();
        int index_city = BoxCityPersonRecords.getSelectedIndex();
        int index_district = BoxDistrictPersonRecords.getSelectedIndex();
        String filters [] = {BoxCountryPersonRecords.getItemAt(index_country), BoxStatePersonRecords.getItemAt(index_state), BoxCityPersonRecords.getItemAt(index_city), BoxDistrictPersonRecords.getItemAt(index_district)};
        String newFilters [] = {};
        for(int i = 0; i <= filters.length; i++) {
            if(filters[i] == "Default") {
                newFilters[i] = null;
            }
        }
        filters = newFilters;
        //Aquí es donde se llama la función de la base de datos con los filtros y se agrega en la lista los valores
        String example[] = {"3D", "a5"};
        RecordsList.setListData(example);
    }//GEN-LAST:event_ButtonEnterPersonRecordsActionPerformed

    private void ButtonUserCataloguesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonUserCataloguesMouseEntered
        ButtonUserCatalogues.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonUserCataloguesMouseEntered

    private void ButtonUserCataloguesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonUserCataloguesMouseExited
        ButtonUserCatalogues.setBorder(null);
    }//GEN-LAST:event_ButtonUserCataloguesMouseExited

    private void ButtonPersonCataloguesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonPersonCataloguesMouseEntered
        ButtonPersonCatalogues.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonPersonCataloguesMouseEntered

    private void ButtonPersonCataloguesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonPersonCataloguesMouseExited
        ButtonPersonCatalogues.setBorder(null);
    }//GEN-LAST:event_ButtonPersonCataloguesMouseExited

    private void ButtonRecordCataloguesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRecordCataloguesMouseEntered
        ButtonRecordCatalogues.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonRecordCataloguesMouseEntered

    private void ButtonRecordCataloguesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRecordCataloguesMouseExited
        ButtonRecordCatalogues.setBorder(null);
    }//GEN-LAST:event_ButtonRecordCataloguesMouseExited

    private void ButtonUserCataloguesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonUserCataloguesActionPerformed
        Animacion.Animacion.mover_derecha(290, 1100, 1, 1, AdminConfiguration);
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        UserCatalogues.setVisible(true);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        JPLogin.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonUserCataloguesActionPerformed

    private void ButtonPersonCataloguesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPersonCataloguesActionPerformed
        Animacion.Animacion.mover_derecha(290, 1100, 1, 1, AdminConfiguration);
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(true);
        RecordCatalogues.setVisible(false);
        AdminStatistics.setVisible(false);
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        JPLogin.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPLogged.setVisible(true);
        try {
            fillInPersonCatalogues();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonPersonCataloguesActionPerformed

    private void ButtonRecordCataloguesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRecordCataloguesActionPerformed
        Animacion.Animacion.mover_derecha(290, 1100, 1, 1, AdminConfiguration);
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(true);
        AdminStatistics.setVisible(false);
        JPWelcome.setVisible(false);
        JPSignUp.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
        JPLogin.setVisible(false);
        JPCreateRecord.setVisible(false);
        JPCreateOffender.setVisible(false);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonRecordCataloguesActionPerformed

    private void AddDistrictMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddDistrictMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_AddDistrictMouseEntered

    private void AddDistrictMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddDistrictMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_AddDistrictMouseExited

    private void AddDistrictActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddDistrictActionPerformed
        String new_district = (String) JOptionPane.showInputDialog(null,"New district: ",JOptionPane.QUESTION_MESSAGE);
        if(JOptionPane.showConfirmDialog(null,"The district will be added with the City selected",
                "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            int city_index = BoxModifyCity.getSelectedIndex();
            if(city_index != 0)
            {
                District district = new District(new_district, city_index);
                try {
                    ConnectDB.insert_district(district);
                    JOptionPane.showMessageDialog(this, "The district was created successfully. Try again.");
                } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "The district was NOT created successfully. Try again.");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Please select a City. And try again.");
            }
        }
    }//GEN-LAST:event_AddDistrictActionPerformed

    private void RemoveDistrictMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveDistrictMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_RemoveDistrictMouseEntered

    private void RemoveDistrictMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveDistrictMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_RemoveDistrictMouseExited

    private void RemoveDistrictActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveDistrictActionPerformed
        int index_district = BoxModifyDistrict.getSelectedIndex();
        try {
            ConnectDB.delete("APP", "admin_district.remove_district", index_district);
            JOptionPane.showMessageDialog(this, "The district was deleted successfully. Try again.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "The district was NOT deleted successfully. Try again.");
        }
    }//GEN-LAST:event_RemoveDistrictActionPerformed

    private void ButtonRefreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRefreshMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonRefreshMouseEntered

    private void ButtonRefreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRefreshMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonRefreshMouseExited

    private void ButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRefreshActionPerformed
        try {
            ResultSet unapproved = ConnectDB.query("APP","admin_queries.not_approved");
            DefaultListModel listModel = new DefaultListModel<>();
            add(new JScrollPane(ListUnapprovedRecords));
            ListUnapprovedRecords.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            while(unapproved.next())
            {
                listModel.addElement(unapproved.getObject("numberr"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonRefreshActionPerformed

    private void ListUnapprovedRecordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListUnapprovedRecordsMouseClicked
        try {
            String numberr = ListUnapprovedRecords.getSelectedValue();
            ResultSet record = ConnectDB.query("APP","admin_record.getRecord", numberr);
            UnapprovedCrimeDescriptionField.setText((String)record.getObject("description_crime"));
            UnapprovedDateCrimeField.setText((String) record.getObject("date_crime"));
            UnapprovedResolutionField.setText((String) record.getObject("resolution"));
            UnapprovedExpireDateField.setText((String) record.getObject("crime_expition_date"));
            UnapprovedIdOffender.setText((String) record.getObject("id_person"));
            UnapprovedTypeField.setText((String) record.getObject("id_type"));
            UnapprovedVeredictField.setText((String) record.getObject("id_veredict"));
            ResultSet pictures = ConnectDB.query("APP","admin_picture.getAll", numberr);
            ArrayList<String> paths = null;
            while(pictures.next())
            {
                paths.add((String) pictures.getObject("pic_str"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ListUnapprovedRecordsMouseClicked

    private void ButtonShowUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonShowUsersActionPerformed
        DefaultTableModel modelo = (DefaultTableModel)TableUsers.getModel();
        modelo.setRowCount(0);
        modelo.addColumn("Username");
        modelo.addColumn("Type");
        try {
            ResultSet userList = ConnectDB.query("APP","user_queries.user_list");
            int i = 0;
            while(userList.next())
            {
                modelo.addRow(new Object[]{userList.getObject("username"), userList.getObject("user_type")});
            }
            TableUsers.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonShowUsersActionPerformed

    private void ButtonShowBannedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonShowBannedActionPerformed
        DefaultTableModel modelo = (DefaultTableModel)TableBanned.getModel();
        modelo.setRowCount(0);
        modelo.addColumn("Username");
        modelo.addColumn("Is Permanent");
        modelo.addColumn("Description");
        try {
            ResultSet bannedList = ConnectDB.query("APP","user_queries.user_banned");
            int i = 0;
            while(bannedList.next())
            {
                modelo.addRow(new Object[]{bannedList.getObject("username"), bannedList.getObject("ispermanent"), 
                    bannedList.getObject("description")});
            }
            TableBanned.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonShowBannedActionPerformed

    private void ButtonShowCataloguesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonShowCataloguesActionPerformed
        try {
            fillIn_Records();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonShowCataloguesActionPerformed

    private void ButtonShowListOfReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonShowListOfReportsActionPerformed
        try {
            ResultSet new_records = ConnectDB.query("APP", "admin_queries.get_new_records");
            DefaultListModel listModel = new DefaultListModel();
            add(new JScrollPane(NewReportList));
            NewReportList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            while(new_records.next())
            {
                listModel.addElement(new_records.getString("numberr"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_ButtonShowListOfReportsActionPerformed

    private void NewReportListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewReportListMouseClicked
        try {
            ResultSet record = ConnectDB.query("ADM", "admin_record.getRecord");
            ReportInformation.setText("Number: " + record.getString("numberr") + 
                                      "Crime Description" + record.getString("description_crime") +
                                      "Resolution" + record.getString("resolution") +
                                      "Crime Expiration Date" + record.getString("crime_expiration_date") + 
                                      "Id Type" + record.getString("id_type")+
                                      "Id Veredict" + record.getString("description_crime") +
                                      "Id Person" + record.getString("id_person")+
                                      "Approved" + record.getString("approved") + 
                                      "Username Creator" + record.getString("username_creator") + 
                                      "Id District" + record.getString("id_district"));
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_NewReportListMouseClicked

    private void ButtonEnterReportsZone1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonEnterReportsZone1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonEnterReportsZone1MouseEntered

    private void ButtonEnterReportsZone1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonEnterReportsZone1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonEnterReportsZone1MouseExited

    private void ButtonEnterReportsZone1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEnterReportsZone1ActionPerformed
        try {
            ResultSet records = ConnectDB.query("ADM","statics.records_clasification");
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            float per = 0;
            while(records.next())
            {
                per = records.getFloat("percentage");
                dataset.addValue(new Double(per), records.getString("name"), records.getString("name"));
            }
            var chart = ChartFactory.createBarChart("Records by zone", "Type", "Quantity",dataset, PlotOrientation.VERTICAL, 
                    true,true, false);
            ChartPanel panel = new ChartPanel(chart);
            jPanel1.add(panel);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonEnterReportsZone1ActionPerformed

    private void ButtonRefreshTotalRecordsByZoneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRefreshTotalRecordsByZoneMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonRefreshTotalRecordsByZoneMouseEntered

    private void ButtonRefreshTotalRecordsByZoneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRefreshTotalRecordsByZoneMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonRefreshTotalRecordsByZoneMouseExited

    private void ButtonRefreshTotalRecordsByZoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRefreshTotalRecordsByZoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonRefreshTotalRecordsByZoneActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ActualUsername;
    private javax.swing.JButton AddBannedReason;
    private javax.swing.JButton AddCity;
    private javax.swing.JButton AddCountry;
    private javax.swing.JButton AddDistrict;
    private javax.swing.JButton AddGender;
    private javax.swing.JButton AddInstitution;
    private javax.swing.JButton AddNewRecord;
    private javax.swing.JButton AddState;
    private javax.swing.JButton AddTypeCrime;
    private javax.swing.JButton AddTypeSentence;
    private javax.swing.JButton AddUnapprovedPic;
    private javax.swing.JButton AddUserTypeCatalogue;
    private javax.swing.JPanel AdminCatalogues;
    private javax.swing.JTabbedPane AdminConfiguration;
    private javax.swing.JTabbedPane AdminQuery;
    private javax.swing.JTabbedPane AdminStatistics;
    private javax.swing.JTextField AdminUpdatePasswordField;
    private javax.swing.JTextField AdminUpdateUsernameField;
    private javax.swing.JPanel ApproveRecords;
    private javax.swing.JPanel BannedUsers;
    private javax.swing.JFormattedTextField BirthdayOffenderField;
    private javax.swing.JFormattedTextField BirthdayUpdateField;
    private javax.swing.JComboBox<String> BoxAdminUserTypeUpdate;
    private javax.swing.JComboBox<String> BoxCity;
    private javax.swing.JComboBox<String> BoxCityPersonRecords;
    private javax.swing.JComboBox<String> BoxCommunityUpdate;
    private javax.swing.JComboBox<String> BoxCountry;
    private javax.swing.JComboBox<String> BoxCountryPersonRecords;
    private javax.swing.JComboBox<String> BoxCrimeType;
    private javax.swing.JComboBox<String> BoxDistrict;
    private javax.swing.JComboBox<String> BoxDistrictAdminUpdate;
    private javax.swing.JComboBox<String> BoxDistrictOffender;
    private javax.swing.JComboBox<String> BoxDistrictPersonRecords;
    private javax.swing.JComboBox<String> BoxDistrictRecord;
    private javax.swing.JComboBox<String> BoxFilter;
    private javax.swing.JComboBox<String> BoxFilterIdPerson;
    private javax.swing.JComboBox<String> BoxFilterLastNamePerson;
    private javax.swing.JComboBox<String> BoxFilterNamePerson;
    private javax.swing.JComboBox<String> BoxFilterSpecify;
    private javax.swing.JComboBox<String> BoxFilterUsernamePerson;
    private javax.swing.JComboBox<String> BoxFinishDate1;
    private javax.swing.JComboBox<String> BoxGenderAdminUpdate;
    private javax.swing.JComboBox<String> BoxGenderNewUser;
    private javax.swing.JComboBox<String> BoxGenderOffender;
    private javax.swing.JComboBox<String> BoxGenderUpdate;
    private javax.swing.JComboBox<String> BoxInstitutionAdminUpdate;
    private javax.swing.JComboBox<String> BoxInstitutionNewUser;
    private javax.swing.JComboBox<String> BoxInstitutionOffender;
    private javax.swing.JComboBox<String> BoxInstitutionUpdate;
    private javax.swing.JComboBox<String> BoxLogFinishDate;
    private javax.swing.JComboBox<String> BoxLogStartDate;
    private javax.swing.JComboBox<String> BoxModifyBannedReason;
    private javax.swing.JComboBox<String> BoxModifyCity;
    private javax.swing.JComboBox<String> BoxModifyCountry;
    private javax.swing.JComboBox<String> BoxModifyDistrict;
    private javax.swing.JComboBox<String> BoxModifyGender;
    private javax.swing.JComboBox<String> BoxModifyInstitution;
    private javax.swing.JComboBox<String> BoxModifyState;
    private javax.swing.JComboBox<String> BoxModifyTypeCrime;
    private javax.swing.JComboBox<String> BoxModifyTypeSentence;
    private javax.swing.JComboBox<String> BoxModifyUserType;
    private javax.swing.JComboBox<String> BoxNewUserDistrict;
    private javax.swing.JComboBox<String> BoxOffender;
    private javax.swing.JComboBox<String> BoxStartDate1;
    private javax.swing.JComboBox<String> BoxState;
    private javax.swing.JComboBox<String> BoxStatePersonRecords;
    private javax.swing.JComboBox<String> BoxUserTypeNewUser;
    private javax.swing.JComboBox<String> BoxUserTypeUpdateUser;
    private javax.swing.JComboBox<String> BoxVeredict;
    private javax.swing.JButton ButtonAdminConfiguration;
    private javax.swing.JButton ButtonAdminQuery;
    private javax.swing.JButton ButtonBanUser;
    private javax.swing.JButton ButtonCancel;
    private javax.swing.JButton ButtonCancelNewRecord;
    private javax.swing.JButton ButtonCancelOffender;
    private javax.swing.JButton ButtonCancelRecordCatalogue;
    private javax.swing.JButton ButtonCancelUnapproved;
    private javax.swing.JButton ButtonCancelUpdatesAdminInfo;
    private javax.swing.JButton ButtonCancelUpdatesUserInfo;
    private javax.swing.JButton ButtonCancelUpdatesUserLogin;
    private javax.swing.JButton ButtonCancelUpdatesUserLoginAdmin;
    private javax.swing.JButton ButtonClose;
    private javax.swing.JButton ButtonConfiguration;
    private javax.swing.JButton ButtonConfirmChanges;
    private javax.swing.JButton ButtonConfirmChangesAdmin;
    private javax.swing.JButton ButtonConfirmChangesUpdateAdminPersonalInfo;
    private javax.swing.JButton ButtonConfirmChangesUpdatePersonalInfo;
    private javax.swing.JButton ButtonConfirmNewRecord;
    private javax.swing.JButton ButtonConfirmOffender;
    private javax.swing.JButton ButtonConfirmPersonCatalogue;
    private javax.swing.JButton ButtonConfirmUnapproved;
    private javax.swing.JButton ButtonConfirmUserCatalogue;
    private javax.swing.JButton ButtonCreateRecord;
    private javax.swing.JButton ButtonEnter;
    private javax.swing.JButton ButtonEnterPersonRecords;
    private javax.swing.JButton ButtonEnterReportsZone;
    private javax.swing.JButton ButtonEnterReportsZone1;
    private javax.swing.JButton ButtonJoin;
    private javax.swing.JButton ButtonLogOut;
    private javax.swing.JButton ButtonLogOutAdminUser;
    private javax.swing.JButton ButtonLogUserList;
    private javax.swing.JButton ButtonMinimize;
    private javax.swing.JButton ButtonPersonCatalogues;
    private javax.swing.JButton ButtonQuery;
    private javax.swing.JButton ButtonRecordCatalogues;
    private javax.swing.JButton ButtonRefresh;
    private javax.swing.JButton ButtonRefreshTotalRecordsByZone;
    private javax.swing.JButton ButtonRollbackCatalogues;
    private javax.swing.JButton ButtonRollbackCreateRecord;
    private javax.swing.JButton ButtonRollbackLog;
    private javax.swing.JButton ButtonRollbackQueryBanned;
    private javax.swing.JButton ButtonRollbackQueryExpire;
    private javax.swing.JButton ButtonRollbackQueryPlaces;
    private javax.swing.JButton ButtonRollbackQueryRecords;
    private javax.swing.JButton ButtonRollbackQueryUsers;
    private javax.swing.JButton ButtonRollbackReportList;
    private javax.swing.JButton ButtonRollbackUserListNotChangePassword;
    private javax.swing.JButton ButtonShowBanned;
    private javax.swing.JButton ButtonShowCatalogues;
    private javax.swing.JButton ButtonShowFilteredUserList;
    private javax.swing.JButton ButtonShowListOfReports;
    private javax.swing.JButton ButtonShowPlaces;
    private javax.swing.JButton ButtonShowRecords;
    private javax.swing.JButton ButtonShowRecordsDate;
    private javax.swing.JButton ButtonShowUsers;
    private javax.swing.JButton ButtonSignUp;
    private javax.swing.JButton ButtonStatistics;
    private javax.swing.JButton ButtonUserCatalogues;
    private javax.swing.JCheckBox CheckBoxApproved;
    private javax.swing.JCheckBox CheckBoxApprovedOrNot;
    private javax.swing.JTextArea CrimeDescriptionField;
    private javax.swing.JFormattedTextField DateCrimeField;
    private javax.swing.JFormattedTextField DateEndField;
    private javax.swing.JFormattedTextField DateStartField;
    private javax.swing.JFormattedTextField ExpireDateField;
    private javax.swing.JLabel IconCreateReacord;
    private javax.swing.JLabel IconLogged;
    private javax.swing.JLabel IconOffender;
    private javax.swing.JLabel IconPassword;
    private javax.swing.JLabel IconUpdatePassword;
    private javax.swing.JLabel IconUpdatePasswordAdmin;
    private javax.swing.JLabel IconUpdateUsername;
    private javax.swing.JLabel IconUpdateUsername1;
    private javax.swing.JLabel IconUpdateUsername10;
    private javax.swing.JLabel IconUpdateUsername2;
    private javax.swing.JLabel IconUpdateUsername3;
    private javax.swing.JLabel IconUpdateUsername4;
    private javax.swing.JLabel IconUpdateUsername5;
    private javax.swing.JLabel IconUpdateUsername6;
    private javax.swing.JLabel IconUpdateUsername7;
    private javax.swing.JLabel IconUpdateUsername8;
    private javax.swing.JLabel IconUpdateUsername9;
    private javax.swing.JLabel IconUpdateUsernameAdmin;
    private javax.swing.JLabel IconUser;
    private javax.swing.JLabel IconUsername;
    private javax.swing.JTextField IdNewUserField;
    private javax.swing.JTextField IdOffenderField;
    private javax.swing.JTextField IdUpdateField;
    private javax.swing.JPanel JPAdminMenu;
    private javax.swing.JPanel JPCreateOffender;
    private javax.swing.JPanel JPCreateRecord;
    private javax.swing.JPanel JPLogged;
    private javax.swing.JPanel JPLogin;
    private javax.swing.JPanel JPSignUp;
    private javax.swing.JPanel JPUserMenu;
    private javax.swing.JPanel JPWelcome;
    private javax.swing.JPanel JPWindow;
    private javax.swing.JLabel LabelAdminPasswordUpdateLogin;
    private javax.swing.JLabel LabelAdminUpdateLoginFields;
    private javax.swing.JLabel LabelAdminUsernameUpdateLogin;
    private javax.swing.JLabel LabelAdminUsernameUpdateLogin1;
    private javax.swing.JLabel LabelApproveRecords;
    private javax.swing.JLabel LabelBannedReason;
    private javax.swing.JLabel LabelChooseFilterRecords;
    private javax.swing.JLabel LabelChooseFilterRecords1;
    private javax.swing.JLabel LabelChooseFilterRecords2;
    private javax.swing.JLabel LabelChooseFilterUserListNotChangePassword;
    private javax.swing.JLabel LabelChooseFilterUserListNotChangePassword1;
    private javax.swing.JLabel LabelChooseFilterUserListNotChangePassword2;
    private javax.swing.JLabel LabelChooseFilterUserListNotChangePassword3;
    private javax.swing.JLabel LabelCity;
    private javax.swing.JLabel LabelCommunityNewUser;
    private javax.swing.JLabel LabelCommunityOffender;
    private javax.swing.JLabel LabelCommunityUpdate;
    private javax.swing.JLabel LabelCountry;
    private javax.swing.JLabel LabelCrimeDescription;
    private javax.swing.JLabel LabelCrimeDescriptionUnapproved;
    private javax.swing.JLabel LabelCrimeType;
    private javax.swing.JLabel LabelCrimeType1;
    private javax.swing.JLabel LabelCrimeTypeUnapproved;
    private javax.swing.JLabel LabelDateCrime;
    private javax.swing.JLabel LabelDateCrimeUnapproved;
    private javax.swing.JLabel LabelDistrict;
    private javax.swing.JLabel LabelExpireDate;
    private javax.swing.JLabel LabelExpireDateUnapproved;
    private javax.swing.JLabel LabelFilterIdPerson;
    private javax.swing.JLabel LabelFilterLastNamePerson;
    private javax.swing.JLabel LabelFilterNamePerson;
    private javax.swing.JLabel LabelFilterUsername;
    private javax.swing.JLabel LabelGender;
    private javax.swing.JLabel LabelGender1;
    private javax.swing.JLabel LabelIdNewUser;
    private javax.swing.JLabel LabelIdOffender;
    private javax.swing.JLabel LabelInstitution;
    private javax.swing.JLabel LabelInstitutionNewUser;
    private javax.swing.JLabel LabelInstitutionOffender;
    private javax.swing.JLabel LabelInstitutionUpdate;
    private javax.swing.JLabel LabelLastNameNewUser;
    private javax.swing.JLabel LabelLastNameOffender;
    private javax.swing.JLabel LabelLastNameUpdate;
    private javax.swing.JLabel LabelMiddleNameNewUser;
    private javax.swing.JLabel LabelMiddleNameOffender;
    private javax.swing.JLabel LabelMiddleNameUpdate;
    private javax.swing.JLabel LabelNameNewUser;
    private javax.swing.JLabel LabelNameOffender;
    private javax.swing.JLabel LabelNewUserBirthday;
    private javax.swing.JLabel LabelNewUserGender;
    private javax.swing.JLabel LabelNewUserPassword;
    private javax.swing.JLabel LabelNewUserUserType;
    private javax.swing.JLabel LabelNewUsername;
    private javax.swing.JLabel LabelNewUsername1;
    private javax.swing.JLabel LabelNewUsername2;
    private javax.swing.JLabel LabelNewUsername3;
    private javax.swing.JLabel LabelNewUsername4;
    private javax.swing.JLabel LabelNewUsername5;
    private javax.swing.JLabel LabelNewUsername6;
    private javax.swing.JLabel LabelNewUsername7;
    private javax.swing.JLabel LabelNewUsername8;
    private javax.swing.JLabel LabelOffender;
    private javax.swing.JLabel LabelOffenderBirthday;
    private javax.swing.JLabel LabelOffenderGender;
    private javax.swing.JLabel LabelOffenderUnapproved;
    private javax.swing.JLabel LabelPassword;
    private javax.swing.JLabel LabelRecordNumber;
    private javax.swing.JLabel LabelResolution;
    private javax.swing.JLabel LabelResolutionUnapproved;
    private javax.swing.JLabel LabelSignUp;
    private javax.swing.JLabel LabelState;
    private javax.swing.JLabel LabelState1;
    private javax.swing.JLabel LabelTop;
    private javax.swing.JLabel LabelUpdateAdminBirthday;
    private javax.swing.JLabel LabelUpdateAdminCommunity;
    private javax.swing.JLabel LabelUpdateAdminGender;
    private javax.swing.JLabel LabelUpdateAdminId;
    private javax.swing.JLabel LabelUpdateAdminInstitution;
    private javax.swing.JLabel LabelUpdateAdminLastName;
    private javax.swing.JLabel LabelUpdateAdminMiddleName;
    private javax.swing.JLabel LabelUpdateAdminNameUpdate;
    private javax.swing.JLabel LabelUpdateAdminUserType;
    private javax.swing.JLabel LabelUpdateBirthday;
    private javax.swing.JLabel LabelUpdateGender;
    private javax.swing.JLabel LabelUpdateId;
    private javax.swing.JLabel LabelUpdateNameUpdate;
    private javax.swing.JLabel LabelUpdateUserType;
    private javax.swing.JLabel LabelUserPasswordUpdateLogin;
    private javax.swing.JLabel LabelUserType;
    private javax.swing.JLabel LabelUserType1;
    private javax.swing.JLabel LabelUserType2;
    private javax.swing.JLabel LabelUserType3;
    private javax.swing.JLabel LabelUserUpdateLogin;
    private javax.swing.JLabel LabelUserUpdateLogin2;
    private javax.swing.JLabel LabelUserUpdateLogin3;
    private javax.swing.JLabel LabelUserUpdateLoginFields;
    private javax.swing.JLabel LabelUsername;
    private javax.swing.JLabel LabelVeredict;
    private javax.swing.JLabel LabelVeredictUnapproved;
    private javax.swing.JLabel LabelWelcome;
    private javax.swing.JTextField LastNameNewUserField;
    private javax.swing.JTextField LastNameOffenderField;
    private javax.swing.JTextField LastNameUpdateField;
    private javax.swing.JButton LeftNewRecord;
    private javax.swing.JButton LeftPicNewReportList;
    private javax.swing.JButton LeftPicRecordToExpire;
    private javax.swing.JButton LeftPicShowRecords;
    private javax.swing.JButton LeftUnapprovedPic;
    private javax.swing.JSeparator LineAdminBirthday;
    private javax.swing.JSeparator LineDateCrime;
    private javax.swing.JSeparator LineDateCrime1;
    private javax.swing.JSeparator LineDateCrime2;
    private javax.swing.JSeparator LineDateCrime3;
    private javax.swing.JSeparator LineExpireDate;
    private javax.swing.JSeparator LineExpireDate2;
    private javax.swing.JSeparator LineNewUserId;
    private javax.swing.JSeparator LineNewUserLastName;
    private javax.swing.JSeparator LineNewUserMiddleName;
    private javax.swing.JSeparator LineNewUserName;
    private javax.swing.JSeparator LineNewUserPassword;
    private javax.swing.JSeparator LineNewUsername;
    private javax.swing.JSeparator LineNumberRecord;
    private javax.swing.JSeparator LineOffenderBirthday;
    private javax.swing.JSeparator LineOffenderBirthday1;
    private javax.swing.JSeparator LineOffenderBirthday2;
    private javax.swing.JSeparator LineOffenderId;
    private javax.swing.JSeparator LineOffenderLastName;
    private javax.swing.JSeparator LineOffenderMiddleName;
    private javax.swing.JSeparator LineOffenderName;
    private javax.swing.JSeparator LineOffenderName1;
    private javax.swing.JSeparator LinePassword;
    private javax.swing.JSeparator LineResolution;
    private javax.swing.JSeparator LineResolution2;
    private javax.swing.JSeparator LineResolution3;
    private javax.swing.JSeparator LineResolution4;
    private javax.swing.JSeparator LineResolution5;
    private javax.swing.JSeparator LineUpdateAdminId;
    private javax.swing.JSeparator LineUpdateAdminLastName;
    private javax.swing.JSeparator LineUpdateAdminMiddleName;
    private javax.swing.JSeparator LineUpdateAdminName;
    private javax.swing.JSeparator LineUpdateAdminPassword;
    private javax.swing.JSeparator LineUpdateAdminUsername;
    private javax.swing.JSeparator LineUpdateAdminUsername1;
    private javax.swing.JSeparator LineUpdateId;
    private javax.swing.JSeparator LineUpdateLastName;
    private javax.swing.JSeparator LineUpdateMiddleName;
    private javax.swing.JSeparator LineUpdatePassword;
    private javax.swing.JSeparator LineUpdateUsername;
    private javax.swing.JSeparator LineUsername;
    private javax.swing.JList<String> ListUnapprovedRecords;
    private javax.swing.JPanel Log;
    private javax.swing.JList<String> LogUserList;
    private javax.swing.JTextField MiddleNameNewUserField;
    private javax.swing.JTextField MiddleNameOffenderField;
    private javax.swing.JTextField MiddleNameUpdateField;
    private javax.swing.JTextField NameNewUserField;
    private javax.swing.JTextField NameOffenderField;
    private javax.swing.JTextField NameUpdateField;
    private javax.swing.JList<String> NewReportList;
    private javax.swing.JFormattedTextField NewUserBirthday;
    private javax.swing.JTextField NewUserPasswordField;
    private javax.swing.JTextField NewUsernameField;
    private javax.swing.JTextField NumberTopField;
    private javax.swing.JSeparator NumberTopLine;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JPanel PersonCatalogues;
    private javax.swing.JButton PictureNewRecord;
    private javax.swing.JButton PictureNewReportList;
    private javax.swing.JButton PictureRecordToExpire;
    private javax.swing.JButton PictureShowRecords;
    private javax.swing.JButton PictureUnapproved;
    private javax.swing.JPanel PlacesMoreRecords;
    private javax.swing.JPanel RecordCatalogues;
    private javax.swing.JTextArea RecordDescriptionText;
    private javax.swing.JTextArea RecordDescriptionTextExpire;
    private javax.swing.JTextField RecordNumberField;
    private javax.swing.JPanel Records;
    private javax.swing.JPanel RecordsConvictionsToExpireOrExpired;
    private javax.swing.JList<String> RecordsExpireList;
    private javax.swing.JList<String> RecordsList;
    private javax.swing.JButton RemoveBannedReason;
    private javax.swing.JButton RemoveCity;
    private javax.swing.JButton RemoveCountry;
    private javax.swing.JButton RemoveDistrict;
    private javax.swing.JButton RemoveGender;
    private javax.swing.JButton RemoveInstitution;
    private javax.swing.JButton RemoveNewRecord;
    private javax.swing.JButton RemoveState;
    private javax.swing.JButton RemoveTypeCrime;
    private javax.swing.JButton RemoveTypeSentence;
    private javax.swing.JButton RemoveUnapprovedPic;
    private javax.swing.JButton RemoveUserType;
    private javax.swing.JTextArea ReportInformation;
    private javax.swing.JPanel ReportList;
    private javax.swing.JTextField ResolutionField;
    private javax.swing.JButton RightNewRecord;
    private javax.swing.JButton RightPicNewReportList;
    private javax.swing.JButton RightPicRecordToExpire;
    private javax.swing.JButton RightPicShowRecords;
    private javax.swing.JButton RightUnapprovedPic;
    private javax.swing.JTable Table;
    private javax.swing.JTable TableBanned;
    private javax.swing.JTable TableUsers;
    private javax.swing.JTable TableUsersPassword;
    private javax.swing.JTextArea UnapprovedCrimeDescriptionField;
    private javax.swing.JFormattedTextField UnapprovedDateCrimeField;
    private javax.swing.JFormattedTextField UnapprovedExpireDateField;
    private javax.swing.JTextField UnapprovedIdOffender;
    private javax.swing.JTextField UnapprovedResolutionField;
    private javax.swing.JTextField UnapprovedTypeField;
    private javax.swing.JTextField UnapprovedVeredictField;
    private javax.swing.JFormattedTextField UpdateAdminBirthdayField;
    private javax.swing.JTextField UpdateAdminIdField;
    private javax.swing.JTextField UpdateAdminLastNameField;
    private javax.swing.JPanel UpdateAdminLoginInfo;
    private javax.swing.JTextField UpdateAdminMiddleNameField;
    private javax.swing.JTextField UpdateAdminNameField;
    private javax.swing.JPanel UpdateAdminPersonalInfo;
    private javax.swing.JPanel UpdateLoginInfo;
    private javax.swing.JTextField UpdatePasswordField;
    private javax.swing.JPanel UpdatePersonalInfo;
    private javax.swing.JTextField UpdateUsernameField;
    private javax.swing.JPanel UserCatalogues;
    private javax.swing.JTabbedPane UserConfiguration;
    private javax.swing.JPanel UserListNotChangingPassword;
    private javax.swing.JTabbedPane UserQuery;
    private javax.swing.JLabel Username;
    private javax.swing.JTextField UsernameField;
    private javax.swing.JPanel UsersList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
