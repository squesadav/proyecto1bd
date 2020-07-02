package javaapplication16.Frame;
import BL.*;
import Connect.ConnectDB;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import org.jfree.chart.JFreeChart;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class Login extends javax.swing.JFrame {
    int indexPictures;
    ArrayList<String> paths;
    boolean firstRunning = true;

    void blockAll()
    {
        JPWelcome.setVisible(false);
        JPLogin.setVisible(false);
        JPSignUp.setVisible(false);
        JPLogged.setVisible(false);
        JPAdminMenu.setVisible(false);
        AdminQuery.setVisible(false);
        AdminConfiguration.setVisible(false);
        UserCatalogues.setVisible(false);
        PersonCatalogues.setVisible(false);
        RecordCatalogues.setVisible(false);
        CreatePersonAdmin.setVisible(false);
        CreateRecordAdmin.setVisible(false);
        CreateBanUser.setVisible(false);
        DeleteUser.setVisible(false);
        DeletePerson.setVisible(false);
        DeleteRecord.setVisible(false);
        DeleteBan.setVisible(false);
        AdminStatistics.setVisible(false);
        JPUserMenu.setVisible(false);
        CreatePerson.setVisible(false);
        CreateRecord.setVisible(false);
        UserQuery.setVisible(false);
        UserConfiguration.setVisible(false);
    }

        void fillInComboBoxStatistics1() throws SQLException
    {
        BoxTypeOfZone.removeAllItems();
        BoxCity.removeAllItems();
        BoxState.removeAllItems();
        BoxCountry.removeAllItems();
        BoxTypeOfZone.addItem("Null");
        BoxTypeOfZone.addItem("District");
        BoxTypeOfZone.addItem("City");
        BoxTypeOfZone.addItem("State");
        BoxTypeOfZone.addItem("Country");        
        BoxCity.addItem("Null");
        BoxState.addItem("Null");
        BoxCountry.addItem("Null");       
        ResultSet city = null;
        ResultSet state= null;
        ResultSet country = null;
        try
        {
            city = ConnectDB.query("APP", "admin_city.getAll");
            state = ConnectDB.query("APP","admin_state.getAll");
            country = ConnectDB.query("APP","admin_country.getAll");
        }
        catch(Exception e){}
        while(city.next())
        {
            BoxCity.addItem(city.getString("name"));
        }
        while(state.next())
        {
            BoxState.addItem(state.getString("name"));
        }
        while(country.next())
        {
            BoxCountry.addItem(country.getString("name"));
        }
    }
        
        void fillInComboBoxStatistics2() throws SQLException
    {
        BoxTypeOfZone1.removeAllItems();
        BoxCityPersonRecords.removeAllItems();
        BoxStatePersonRecords.removeAllItems();
        BoxCountryPersonRecords.removeAllItems();
        BoxTypeOfZone1.addItem("Null");
        BoxTypeOfZone1.addItem("District");
        BoxTypeOfZone1.addItem("City");
        BoxTypeOfZone1.addItem("State");
        BoxTypeOfZone1.addItem("Country");        
        BoxCityPersonRecords.addItem("Null");
        BoxStatePersonRecords.addItem("Null");
        BoxCountryPersonRecords.addItem("Null");       
        ResultSet city = null;
        ResultSet state= null;
        ResultSet country = null;
        try
        {
            city = ConnectDB.query("APP", "admin_city.getAll");
            state = ConnectDB.query("APP","admin_state.getAll");
            country = ConnectDB.query("APP","admin_country.getAll");
        }
        catch(Exception e){}
        while(city.next())
        {
            BoxCityPersonRecords.addItem(city.getString("name"));
        }
        while(state.next())
        {
            BoxStatePersonRecords.addItem(state.getString("name"));
        }
        while(country.next())
        {
            BoxCountryPersonRecords.addItem(country.getString("name"));
        }
    }
    
    
    void fillInComboBox_signIn() throws SQLException
    {
        BoxGenderNewUser.removeAllItems();
        BoxNewUserDistrict.removeAllItems();
        BoxInstitutionNewUser.removeAllItems();
        BoxGenderNewUser.addItem("Default");
        BoxNewUserDistrict.addItem("Default");
        BoxInstitutionNewUser.addItem("Default");
        ResultSet genders = null;
        ResultSet districts = null;
        ResultSet institutions = null;
        try
        {
            genders = ConnectDB.query("APP", "admin_gender.getAll");
            districts = ConnectDB.query("APP","admin_district.getAll");
            institutions = ConnectDB.query("APP","admin_institution.getAll");
        }
        catch(Exception e){}
        while(genders.next())
        {
            BoxGenderNewUser.addItem(genders.getString("name"));
        }
        while(districts.next())
        {
            BoxNewUserDistrict.addItem(districts.getString("name"));
        }
        while(institutions.next())
        {
            BoxInstitutionNewUser.addItem(institutions.getString("name"));
        }
    }
    
    void fillInComboBox_Offender() throws SQLException
    {
        BoxGenderPerson.removeAllItems();
        BoxDistrictPerson.removeAllItems();
        BoxInstitutionPerson.removeAllItems();
        BoxGenderPerson.addItem("Default");
        BoxDistrictPerson.addItem("Default");
        BoxInstitutionPerson.addItem("Default");
        ResultSet genders = null;
        ResultSet districts = null;
        ResultSet institutions = null;
        try
        {
            genders = ConnectDB.query("APP", "admin_gender.getAll");
            districts = ConnectDB.query("APP","admin_district.getAll");
            institutions = ConnectDB.query("APP","admin_institution.getAll");
        }
        catch(Exception e){}
        while(genders.next())
        {
            BoxGenderPerson.addItem(genders.getString("name"));
        }
        while(districts.next())
        {
            BoxDistrictPerson.addItem(districts.getString("name"));
        }
        while(institutions.next())
        {
            BoxInstitutionPerson.addItem(institutions.getString("name"));
        }
    }
    
    void fillInComboBox_UserCatalogues() throws SQLException
    {
        BoxModifyUserType.removeAllItems();
        BoxModifyBannedReason.removeAllItems();
        BoxModifyUserType.addItem("Default");
        BoxModifyBannedReason.addItem("Default");
        ResultSet userType = null;
        ResultSet BannedReason = null;
        try
        {
            userType = ConnectDB.query("ADM", "adminUser.getAllUserType");
            BannedReason = ConnectDB.query("ADM","adminUser.getAllBannedReason");
        }
        catch(Exception e){}
        while(userType.next())
        {
            BoxModifyUserType.addItem(userType.getString("name"));
        }
        while(BannedReason.next())
        {
            BoxModifyBannedReason.addItem(BannedReason.getString("name"));
        }
    }
    
    void fillInPersonCatalogues() throws SQLException
    {
        BoxModifyGender.removeAllItems();
        BoxModifyGender.addItem("Default");
       
        BoxModifyInstitution.removeAllItems();
        BoxModifyInstitution.addItem("Default");
        
        BoxModifyCountry.removeAllItems();
        BoxModifyCountry.addItem("Default");
        
        BoxModifyState.removeAllItems();
        BoxModifyState.addItem("Default");
        
        BoxModifyCity.removeAllItems();
        BoxModifyCity.addItem("Default");
        
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
    
    void fillIn_Records() throws SQLException
    {
        BoxFilter.removeAllItems();
        BoxFilter.addItem("Default");
        
        
        BoxFilterSpecify.removeAllItems();
        BoxFilterSpecify.addItem("Default");
        
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
    
    void loadPictures(javax.swing.JButton button, javax.swing.JButton buttonLeft, javax.swing.JButton buttonRight){
        try {
            if(!paths.isEmpty()){
                ImageIcon pic = new ImageIcon(paths.get(indexPictures));
                Image picFit = pic.getImage();
                picFit = picFit.getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH);
                button.setIcon(new ImageIcon(picFit));
            }else{
                button.setIcon(new javax.swing.ImageIcon(""));
                buttonLeft.setEnabled(false);
                buttonRight.setEnabled(false);
            }
        } catch (Exception ex) {
        }

        if(indexPictures <= 0) {
            buttonLeft.setEnabled(false);
        } else {
            buttonLeft.setEnabled(true);
        }
        if(indexPictures == paths.size() || indexPictures == paths.size()-1) {
            buttonLeft.setEnabled(false);
        } else {
            buttonRight.setEnabled(true);
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
        LineDateCrime2 = new javax.swing.JSeparator();
        UnapprovedDateCrimeField = new javax.swing.JFormattedTextField();
        ButtonCancelUnapproved = new javax.swing.JButton();
        jScrollPane16 = new javax.swing.JScrollPane();
        UnapprovedCrimeDescriptionField = new javax.swing.JTextArea();
        CheckBoxApprovedOrNot = new javax.swing.JCheckBox();
        UnapprovedExpireDateField = new javax.swing.JFormattedTextField();
        LineExpireDate2 = new javax.swing.JSeparator();
        LabelExpireDateUnapproved = new javax.swing.JLabel();
        PictureUnapproved = new javax.swing.JButton();
        RightUnapprovedPic = new javax.swing.JButton();
        LeftUnapprovedPic = new javax.swing.JButton();
        AddUnapprovedPic = new javax.swing.JButton();
        RemoveUnapprovedPic = new javax.swing.JButton();
        jScrollPane17 = new javax.swing.JScrollPane();
        ListUnapprovedRecords = new javax.swing.JList<>();
        LabelCrimeDescriptionUnapproved = new javax.swing.JLabel();
        ButtonConfirmUnapproved = new javax.swing.JButton();
        ButtonRefresh = new javax.swing.JButton();
        YearsSentenceUnapproved = new javax.swing.JTextField();
        LineResolution3 = new javax.swing.JSeparator();
        LineResolution4 = new javax.swing.JSeparator();
        UnapprovedIdOffender = new javax.swing.JTextField();
        BoxResolutionUnapproved = new javax.swing.JComboBox<>();
        LabelVeredictUnapproved1 = new javax.swing.JLabel();
        BoxTypeCrimeApproveRecords = new javax.swing.JComboBox<>();
        LineDateCrime4 = new javax.swing.JSeparator();
        StartDateSentenceUnapproved = new javax.swing.JFormattedTextField();
        LabelExpireDateUnapproved1 = new javax.swing.JLabel();
        LabelExpireDateUnapproved2 = new javax.swing.JLabel();
        LineDateCrime5 = new javax.swing.JSeparator();
        FinishDateSentenceUnapproved = new javax.swing.JFormattedTextField();
        LabelResolutionUnapproved1 = new javax.swing.JLabel();
        BoxTypeSentenceUnapproved = new javax.swing.JComboBox<>();
        CreateSystem = new javax.swing.JPanel();
        ButtonBanUser = new javax.swing.JButton();
        ButtonPerson = new javax.swing.JButton();
        ButtonRecord = new javax.swing.JButton();
        ButtonRollbackCreateSystem = new javax.swing.JButton();
        DeleteSystem = new javax.swing.JPanel();
        ButtonDeleteBan = new javax.swing.JButton();
        ButtonDeletePerson = new javax.swing.JButton();
        ButtonDeleteRecord = new javax.swing.JButton();
        ButtonRollbackDeleteSystem = new javax.swing.JButton();
        ButtonDeleteUser = new javax.swing.JButton();
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
        CreatePersonAdmin = new javax.swing.JPanel();
        LabelIdOffender1 = new javax.swing.JLabel();
        LabelNameOffender1 = new javax.swing.JLabel();
        LabelMiddleNameOffender1 = new javax.swing.JLabel();
        LabelLastNameOffender1 = new javax.swing.JLabel();
        LabelCommunityOffender1 = new javax.swing.JLabel();
        LabelInstitutionOffender1 = new javax.swing.JLabel();
        LabelOffenderGender1 = new javax.swing.JLabel();
        LabelOffenderBirthday1 = new javax.swing.JLabel();
        LineOffenderId1 = new javax.swing.JSeparator();
        IdPersonField1 = new javax.swing.JTextField();
        LineOffenderName2 = new javax.swing.JSeparator();
        NamePersonField1 = new javax.swing.JTextField();
        LineOffenderMiddleName1 = new javax.swing.JSeparator();
        MiddleNamePersonField1 = new javax.swing.JTextField();
        LineOffenderLastName1 = new javax.swing.JSeparator();
        LastNamePersonField1 = new javax.swing.JTextField();
        LineOffenderBirthday3 = new javax.swing.JSeparator();
        BirthdayPersonField1 = new javax.swing.JFormattedTextField();
        BoxDistrictPerson1 = new javax.swing.JComboBox<>();
        BoxInstitutionPerson1 = new javax.swing.JComboBox<>();
        BoxGenderPerson1 = new javax.swing.JComboBox<>();
        ButtonCancelPerson1 = new javax.swing.JButton();
        ButtonConfirmPerson1 = new javax.swing.JButton();
        IconOffender1 = new javax.swing.JLabel();
        CreateRecordAdmin = new javax.swing.JPanel();
        ButtonRollbackCreateRecord1 = new javax.swing.JButton();
        LabelRecordNumber1 = new javax.swing.JLabel();
        LabelCrimeDescription1 = new javax.swing.JLabel();
        LabelOffender1 = new javax.swing.JLabel();
        LabelDateCrime1 = new javax.swing.JLabel();
        LineNumberRecord1 = new javax.swing.JSeparator();
        RecordNumberField1 = new javax.swing.JTextField();
        LineDateCrime8 = new javax.swing.JSeparator();
        DateCrimeCreateRecord1 = new javax.swing.JFormattedTextField();
        BoxOffender1 = new javax.swing.JComboBox<>();
        IconCreateReacord1 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        CrimeDescriptionCreateRecord1 = new javax.swing.JTextArea();
        PictureNewRecord1 = new javax.swing.JButton();
        RightPicRecordAdmin = new javax.swing.JButton();
        LeftPicRecordAdmin = new javax.swing.JButton();
        ButtonCreateOffender1 = new javax.swing.JButton();
        RemovePicRecordAdmin = new javax.swing.JButton();
        LabelResolutionUnapproved4 = new javax.swing.JLabel();
        LabelVeredictUnapproved4 = new javax.swing.JLabel();
        ButtonCancelRecordAdmin = new javax.swing.JButton();
        CheckBoxApprovedOrNotCreateRecord1 = new javax.swing.JCheckBox();
        ExpireDateCreateRecord1 = new javax.swing.JFormattedTextField();
        LineExpireDate4 = new javax.swing.JSeparator();
        LabelExpireDateUnapproved6 = new javax.swing.JLabel();
        YearsSentenceCreateRecord1 = new javax.swing.JTextField();
        LineResolution6 = new javax.swing.JSeparator();
        BoxResolutionCreateRecord1 = new javax.swing.JComboBox<>();
        LabelVeredictUnapproved5 = new javax.swing.JLabel();
        LineDateCrime9 = new javax.swing.JSeparator();
        StartDateSentenceCreateRecord1 = new javax.swing.JFormattedTextField();
        LabelExpireDateUnapproved7 = new javax.swing.JLabel();
        LabelExpireDateUnapproved8 = new javax.swing.JLabel();
        LineDateCrime10 = new javax.swing.JSeparator();
        FinishDateSentenceCreateRecord1 = new javax.swing.JFormattedTextField();
        LabelResolutionUnapproved5 = new javax.swing.JLabel();
        BoxTypeSentenceCreateRecord1 = new javax.swing.JComboBox<>();
        LabelCrimeTypeUnapproved2 = new javax.swing.JLabel();
        ButtonConfirmRecordAdmin = new javax.swing.JButton();
        BoxTypeCrimeCreateRecord1 = new javax.swing.JComboBox<>();
        AddPicRecordAdmin = new javax.swing.JButton();
        CreateBanUser = new javax.swing.JPanel();
        ButtonRollbackBanUser = new javax.swing.JButton();
        IconCreateReacord2 = new javax.swing.JLabel();
        LabelResolutionUnapproved7 = new javax.swing.JLabel();
        BoxReasonBanned = new javax.swing.JComboBox<>();
        ButtonConfirmBanned = new javax.swing.JButton();
        jScrollPane15 = new javax.swing.JScrollPane();
        ListUsersForBan = new javax.swing.JList<>();
        CheckBoxPermanency = new javax.swing.JCheckBox();
        LabelResolutionUnapproved8 = new javax.swing.JLabel();
        LabelChooseFilterRecords9 = new javax.swing.JLabel();
        DateStartField2 = new javax.swing.JFormattedTextField();
        LineDateCrime13 = new javax.swing.JSeparator();
        DateEndField2 = new javax.swing.JFormattedTextField();
        LineDateCrime14 = new javax.swing.JSeparator();
        LabelChooseFilterRecords10 = new javax.swing.JLabel();
        DeleteUser = new javax.swing.JPanel();
        ButtonRollbackDeleteUser = new javax.swing.JButton();
        IconCreateReacord3 = new javax.swing.JLabel();
        LabelResolutionUnapproved9 = new javax.swing.JLabel();
        ButtonDelete = new javax.swing.JButton();
        jScrollPane18 = new javax.swing.JScrollPane();
        ListUsersDelete = new javax.swing.JList<>();
        ButtonRefreshForDeleteUser = new javax.swing.JButton();
        DeletePerson = new javax.swing.JPanel();
        ButtonRollbackPersonDelete = new javax.swing.JButton();
        IconCreateReacord4 = new javax.swing.JLabel();
        LabelResolutionUnapproved11 = new javax.swing.JLabel();
        ButtonPersonDelete = new javax.swing.JButton();
        jScrollPane19 = new javax.swing.JScrollPane();
        ListPersonDelete = new javax.swing.JList<>();
        ButtonPersonRefreshForDelete = new javax.swing.JButton();
        DeleteRecord = new javax.swing.JPanel();
        ButtonRollbackRecordDelete = new javax.swing.JButton();
        IconCreateReacord5 = new javax.swing.JLabel();
        LabelResolutionUnapproved13 = new javax.swing.JLabel();
        ButtonRecordDelete = new javax.swing.JButton();
        jScrollPane20 = new javax.swing.JScrollPane();
        ListRecordsDelete = new javax.swing.JList<>();
        ButtonPersonRefreshForDelete1 = new javax.swing.JButton();
        DeleteBan = new javax.swing.JPanel();
        ButtonRollbackDeleteBan = new javax.swing.JButton();
        IconCreateReacord6 = new javax.swing.JLabel();
        LabelResolutionUnapproved15 = new javax.swing.JLabel();
        ButtonBanDelete = new javax.swing.JButton();
        jScrollPane21 = new javax.swing.JScrollPane();
        BannedListDelete = new javax.swing.JList<>();
        ButtonPersonRefreshForDelete2 = new javax.swing.JButton();
        AdminStatistics = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        ButtonEnterReportsZone1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        BoxCountry = new javax.swing.JComboBox<>();
        ButtonEnterReportsZone = new javax.swing.JButton();
        BoxState = new javax.swing.JComboBox<>();
        BoxCity = new javax.swing.JComboBox<>();
        BoxTypeOfZone = new javax.swing.JComboBox<>();
        LabelNewUsername1 = new javax.swing.JLabel();
        LabelNewUsername2 = new javax.swing.JLabel();
        LabelNewUsername3 = new javax.swing.JLabel();
        LabelNewUsername4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        ButtonEnterReportsZone2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        ButtonEnterReportsZone4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        BoxCountryPersonRecords = new javax.swing.JComboBox<>();
        ButtonEnterPersonRecords = new javax.swing.JButton();
        BoxStatePersonRecords = new javax.swing.JComboBox<>();
        BoxCityPersonRecords = new javax.swing.JComboBox<>();
        BoxTypeOfZone1 = new javax.swing.JComboBox<>();
        LabelNewUsername5 = new javax.swing.JLabel();
        LabelNewUsername6 = new javax.swing.JLabel();
        LabelNewUsername7 = new javax.swing.JLabel();
        LabelNewUsername8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        ButtonEnterReportsZone3 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        ButtonEnterReportsZone5 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        ButtonEnterReportsZone6 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        ButtonEnterReportsZone7 = new javax.swing.JButton();
        JPUserMenu = new javax.swing.JPanel();
        ButtonQuery = new javax.swing.JButton();
        ButtonConfiguration = new javax.swing.JButton();
        ButtonLogOut = new javax.swing.JButton();
        ButtonCreateRecord = new javax.swing.JButton();
        CreatePerson = new javax.swing.JPanel();
        LabelIdOffender = new javax.swing.JLabel();
        LabelNameOffender = new javax.swing.JLabel();
        LabelMiddleNameOffender = new javax.swing.JLabel();
        LabelLastNameOffender = new javax.swing.JLabel();
        LabelCommunityOffender = new javax.swing.JLabel();
        LabelInstitutionOffender = new javax.swing.JLabel();
        LabelOffenderGender = new javax.swing.JLabel();
        LabelOffenderBirthday = new javax.swing.JLabel();
        LineOffenderId = new javax.swing.JSeparator();
        IdPersonField = new javax.swing.JTextField();
        LineOffenderName = new javax.swing.JSeparator();
        NamePersonField = new javax.swing.JTextField();
        LineOffenderMiddleName = new javax.swing.JSeparator();
        MiddleNamePersonField = new javax.swing.JTextField();
        LineOffenderLastName = new javax.swing.JSeparator();
        LastNamePersonField = new javax.swing.JTextField();
        LineOffenderBirthday = new javax.swing.JSeparator();
        BirthdayPersonField = new javax.swing.JFormattedTextField();
        BoxDistrictPerson = new javax.swing.JComboBox<>();
        BoxInstitutionPerson = new javax.swing.JComboBox<>();
        BoxGenderPerson = new javax.swing.JComboBox<>();
        ButtonCancelPerson = new javax.swing.JButton();
        ButtonConfirmPerson = new javax.swing.JButton();
        IconOffender = new javax.swing.JLabel();
        CreateRecord = new javax.swing.JPanel();
        ButtonRollbackCreateRecord = new javax.swing.JButton();
        LabelRecordNumber = new javax.swing.JLabel();
        LabelCrimeDescription = new javax.swing.JLabel();
        LabelOffender = new javax.swing.JLabel();
        LabelDateCrime = new javax.swing.JLabel();
        LineNumberRecord = new javax.swing.JSeparator();
        RecordNumberField = new javax.swing.JTextField();
        LineDateCrime = new javax.swing.JSeparator();
        DateCrimeCreateRecord = new javax.swing.JFormattedTextField();
        BoxOffender = new javax.swing.JComboBox<>();
        IconCreateReacord = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        CrimeDescriptionCreateRecord = new javax.swing.JTextArea();
        PictureNewRecord = new javax.swing.JButton();
        RightRecordUser = new javax.swing.JButton();
        LeftRecordUser = new javax.swing.JButton();
        ButtonCreateOffender = new javax.swing.JButton();
        RemoveRecordUser = new javax.swing.JButton();
        LabelResolutionUnapproved2 = new javax.swing.JLabel();
        LabelVeredictUnapproved2 = new javax.swing.JLabel();
        ButtonCancelRecordUser = new javax.swing.JButton();
        CheckBoxApprovedOrNotCreateRecord = new javax.swing.JCheckBox();
        ExpireDateCreateRecord = new javax.swing.JFormattedTextField();
        LineExpireDate3 = new javax.swing.JSeparator();
        LabelExpireDateUnapproved3 = new javax.swing.JLabel();
        YearsSentenceCreateRecord = new javax.swing.JTextField();
        LineResolution5 = new javax.swing.JSeparator();
        BoxResolutionCreateRecord = new javax.swing.JComboBox<>();
        LabelVeredictUnapproved3 = new javax.swing.JLabel();
        LineDateCrime6 = new javax.swing.JSeparator();
        StartDateSentenceCreateRecord = new javax.swing.JFormattedTextField();
        LabelExpireDateUnapproved4 = new javax.swing.JLabel();
        LabelExpireDateUnapproved5 = new javax.swing.JLabel();
        LineDateCrime7 = new javax.swing.JSeparator();
        FinishDateSentenceCreateRecord = new javax.swing.JFormattedTextField();
        LabelResolutionUnapproved3 = new javax.swing.JLabel();
        BoxTypeSentenceCreateRecord = new javax.swing.JComboBox<>();
        LabelCrimeTypeUnapproved1 = new javax.swing.JLabel();
        ButtonConfirmRecordUser = new javax.swing.JButton();
        BoxTypeCrimeCreateRecord = new javax.swing.JComboBox<>();
        AddRecordUser = new javax.swing.JButton();
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
        LabelChooseFilterRecords3 = new javax.swing.JLabel();
        LabelChooseFilterRecords4 = new javax.swing.JLabel();
        LabelChooseFilterRecords7 = new javax.swing.JLabel();
        LabelChooseFilterRecords8 = new javax.swing.JLabel();
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
        LabelChooseFilterRecords5 = new javax.swing.JLabel();
        DateStartField1 = new javax.swing.JFormattedTextField();
        LineDateCrime11 = new javax.swing.JSeparator();
        DateEndField1 = new javax.swing.JFormattedTextField();
        LineDateCrime12 = new javax.swing.JSeparator();
        LabelChooseFilterRecords6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        LineOffenderBirthday2.setForeground(new java.awt.Color(29, 41, 81));
        JPSignUp.add(LineOffenderBirthday2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 130, 20));

        NewUserBirthday.setBorder(null);
        NewUserBirthday.setForeground(new java.awt.Color(29, 41, 81));
        NewUserBirthday.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        JPSignUp.add(NewUserBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 130, 30));

        getContentPane().add(JPSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 760, 530));

        JPWindow.setBackground(new java.awt.Color(255, 255, 255));
        JPWindow.setForeground(new java.awt.Color(255, 255, 255));
        JPWindow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPWindowMouseEntered(evt);
            }
        });
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
        ButtonShowListOfReports.setBorder(null);
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

        getContentPane().add(AdminQuery, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 760, 530));

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
        UpdateAdminBirthdayField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
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

        AdminConfiguration.addTab("Administrate catalogues", AdminCatalogues);

        ApproveRecords.setBackground(new java.awt.Color(255, 255, 255));
        ApproveRecords.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelApproveRecords.setBackground(new java.awt.Color(255, 255, 255));
        LabelApproveRecords.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelApproveRecords.setForeground(new java.awt.Color(29, 41, 81));
        LabelApproveRecords.setText("List of unapproved records");
        ApproveRecords.add(LabelApproveRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 240, 30));

        LabelResolutionUnapproved.setBackground(new java.awt.Color(255, 255, 255));
        LabelResolutionUnapproved.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelResolutionUnapproved.setForeground(new java.awt.Color(29, 41, 81));
        LabelResolutionUnapproved.setText("Resolution:");
        ApproveRecords.add(LabelResolutionUnapproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 90, 30));

        LabelVeredictUnapproved.setBackground(new java.awt.Color(255, 255, 255));
        LabelVeredictUnapproved.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelVeredictUnapproved.setForeground(new java.awt.Color(29, 41, 81));
        LabelVeredictUnapproved.setText("Veredict:");
        ApproveRecords.add(LabelVeredictUnapproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 100, 30));

        LabelOffenderUnapproved.setBackground(new java.awt.Color(255, 255, 255));
        LabelOffenderUnapproved.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelOffenderUnapproved.setForeground(new java.awt.Color(29, 41, 81));
        LabelOffenderUnapproved.setText("Offender:");
        ApproveRecords.add(LabelOffenderUnapproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 90, 30));

        LabelCrimeTypeUnapproved.setBackground(new java.awt.Color(255, 255, 255));
        LabelCrimeTypeUnapproved.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelCrimeTypeUnapproved.setForeground(new java.awt.Color(29, 41, 81));
        LabelCrimeTypeUnapproved.setText("Type of crime:");
        ApproveRecords.add(LabelCrimeTypeUnapproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 120, 30));

        LabelDateCrimeUnapproved.setBackground(new java.awt.Color(255, 255, 255));
        LabelDateCrimeUnapproved.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelDateCrimeUnapproved.setForeground(new java.awt.Color(29, 41, 81));
        LabelDateCrimeUnapproved.setText("Date crime:");
        ApproveRecords.add(LabelDateCrimeUnapproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 100, 30));

        LineDateCrime2.setForeground(new java.awt.Color(29, 41, 81));
        ApproveRecords.add(LineDateCrime2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 110, 20));

        UnapprovedDateCrimeField.setBorder(null);
        UnapprovedDateCrimeField.setForeground(new java.awt.Color(29, 41, 81));
        UnapprovedDateCrimeField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        ApproveRecords.add(UnapprovedDateCrimeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 110, 30));

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
        ApproveRecords.add(ButtonCancelUnapproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, 100, 40));

        UnapprovedCrimeDescriptionField.setColumns(20);
        UnapprovedCrimeDescriptionField.setRows(5);
        jScrollPane16.setViewportView(UnapprovedCrimeDescriptionField);

        ApproveRecords.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 220, 40));

        CheckBoxApprovedOrNot.setBackground(new java.awt.Color(255, 255, 255));
        CheckBoxApprovedOrNot.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        CheckBoxApprovedOrNot.setForeground(new java.awt.Color(29, 41, 81));
        CheckBoxApprovedOrNot.setText("Approved");
        ApproveRecords.add(CheckBoxApprovedOrNot, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 400, 110, -1));

        UnapprovedExpireDateField.setBorder(null);
        UnapprovedExpireDateField.setForeground(new java.awt.Color(29, 41, 81));
        UnapprovedExpireDateField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        UnapprovedExpireDateField.setCaretColor(new java.awt.Color(204, 204, 204));
        ApproveRecords.add(UnapprovedExpireDateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 400, 70, 30));

        LineExpireDate2.setForeground(new java.awt.Color(29, 41, 81));
        ApproveRecords.add(LineExpireDate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 430, 70, 20));

        LabelExpireDateUnapproved.setBackground(new java.awt.Color(255, 255, 255));
        LabelExpireDateUnapproved.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelExpireDateUnapproved.setForeground(new java.awt.Color(29, 41, 81));
        LabelExpireDateUnapproved.setText("Expire date:");
        ApproveRecords.add(LabelExpireDateUnapproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 400, 100, 30));

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
        ApproveRecords.add(PictureUnapproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 110, 110));

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
        ApproveRecords.add(RightUnapprovedPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, 40, 40));

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
        ApproveRecords.add(LeftUnapprovedPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 40, 40));

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
        ApproveRecords.add(AddUnapprovedPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, 40, 40));

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
        ApproveRecords.add(RemoveUnapprovedPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 40, 40));

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

        ApproveRecords.add(jScrollPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 270, 120));

        LabelCrimeDescriptionUnapproved.setBackground(new java.awt.Color(255, 255, 255));
        LabelCrimeDescriptionUnapproved.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelCrimeDescriptionUnapproved.setForeground(new java.awt.Color(29, 41, 81));
        LabelCrimeDescriptionUnapproved.setText("Crime Description:");
        ApproveRecords.add(LabelCrimeDescriptionUnapproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 160, 30));

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
        ApproveRecords.add(ButtonConfirmUnapproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 100, 40));

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
        ApproveRecords.add(ButtonRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 100, 40));

        YearsSentenceUnapproved.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        YearsSentenceUnapproved.setForeground(new java.awt.Color(29, 41, 81));
        YearsSentenceUnapproved.setBorder(null);
        ApproveRecords.add(YearsSentenceUnapproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 220, 80, 30));

        LineResolution3.setForeground(new java.awt.Color(29, 41, 81));
        ApproveRecords.add(LineResolution3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, 80, 20));

        LineResolution4.setForeground(new java.awt.Color(29, 41, 81));
        ApproveRecords.add(LineResolution4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 210, 20));

        UnapprovedIdOffender.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        UnapprovedIdOffender.setForeground(new java.awt.Color(29, 41, 81));
        UnapprovedIdOffender.setBorder(null);
        ApproveRecords.add(UnapprovedIdOffender, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 210, 30));

        BoxResolutionUnapproved.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BoxResolutionUnapproved.setForeground(new java.awt.Color(29, 41, 81));
        BoxResolutionUnapproved.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Guilty", "Innocent" }));
        BoxResolutionUnapproved.setSelectedIndex(1);
        BoxResolutionUnapproved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxResolutionUnapprovedActionPerformed(evt);
            }
        });
        ApproveRecords.add(BoxResolutionUnapproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, 140, 30));

        LabelVeredictUnapproved1.setBackground(new java.awt.Color(255, 255, 255));
        LabelVeredictUnapproved1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelVeredictUnapproved1.setForeground(new java.awt.Color(29, 41, 81));
        LabelVeredictUnapproved1.setText("Years of sentence:");
        ApproveRecords.add(LabelVeredictUnapproved1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 160, 30));

        BoxTypeCrimeApproveRecords.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BoxTypeCrimeApproveRecords.setForeground(new java.awt.Color(29, 41, 81));
        BoxTypeCrimeApproveRecords.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        ApproveRecords.add(BoxTypeCrimeApproveRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 150, 30));

        LineDateCrime4.setForeground(new java.awt.Color(29, 41, 81));
        ApproveRecords.add(LineDateCrime4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, 110, 20));

        StartDateSentenceUnapproved.setBorder(null);
        StartDateSentenceUnapproved.setForeground(new java.awt.Color(29, 41, 81));
        StartDateSentenceUnapproved.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        ApproveRecords.add(StartDateSentenceUnapproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, 110, 30));

        LabelExpireDateUnapproved1.setBackground(new java.awt.Color(255, 255, 255));
        LabelExpireDateUnapproved1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelExpireDateUnapproved1.setForeground(new java.awt.Color(29, 41, 81));
        LabelExpireDateUnapproved1.setText("Start date:");
        ApproveRecords.add(LabelExpireDateUnapproved1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 100, 30));

        LabelExpireDateUnapproved2.setBackground(new java.awt.Color(255, 255, 255));
        LabelExpireDateUnapproved2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelExpireDateUnapproved2.setForeground(new java.awt.Color(29, 41, 81));
        LabelExpireDateUnapproved2.setText("Finish date:");
        ApproveRecords.add(LabelExpireDateUnapproved2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 100, 30));

        LineDateCrime5.setForeground(new java.awt.Color(29, 41, 81));
        LineDateCrime5.setOpaque(true);
        ApproveRecords.add(LineDateCrime5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 340, 110, 20));

        FinishDateSentenceUnapproved.setBorder(null);
        FinishDateSentenceUnapproved.setForeground(new java.awt.Color(29, 41, 81));
        FinishDateSentenceUnapproved.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        ApproveRecords.add(FinishDateSentenceUnapproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, 110, 30));

        LabelResolutionUnapproved1.setBackground(new java.awt.Color(255, 255, 255));
        LabelResolutionUnapproved1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelResolutionUnapproved1.setForeground(new java.awt.Color(29, 41, 81));
        LabelResolutionUnapproved1.setText("Type of sentence:");
        ApproveRecords.add(LabelResolutionUnapproved1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, 160, 30));

        BoxTypeSentenceUnapproved.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BoxTypeSentenceUnapproved.setForeground(new java.awt.Color(29, 41, 81));
        BoxTypeSentenceUnapproved.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        ApproveRecords.add(BoxTypeSentenceUnapproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 120, 30));

        AdminConfiguration.addTab("Approve records", ApproveRecords);

        CreateSystem.setBackground(new java.awt.Color(255, 255, 255));
        CreateSystem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonBanUser.setBackground(new java.awt.Color(255, 255, 255));
        ButtonBanUser.setForeground(new java.awt.Color(29, 41, 81));
        ButtonBanUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/BannedUser.png"))); // NOI18N
        ButtonBanUser.setText("Ban User");
        ButtonBanUser.setBorder(null);
        ButtonBanUser.setContentAreaFilled(false);
        ButtonBanUser.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
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
        CreateSystem.add(ButtonBanUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 230, 180));

        ButtonPerson.setBackground(new java.awt.Color(255, 255, 255));
        ButtonPerson.setForeground(new java.awt.Color(29, 41, 81));
        ButtonPerson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Person.png"))); // NOI18N
        ButtonPerson.setText("Person");
        ButtonPerson.setBorder(null);
        ButtonPerson.setContentAreaFilled(false);
        ButtonPerson.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ButtonPerson.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonPersonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonPersonMouseExited(evt);
            }
        });
        ButtonPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPersonActionPerformed(evt);
            }
        });
        CreateSystem.add(ButtonPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 240, 180));

        ButtonRecord.setBackground(new java.awt.Color(255, 255, 255));
        ButtonRecord.setForeground(new java.awt.Color(29, 41, 81));
        ButtonRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Record.png"))); // NOI18N
        ButtonRecord.setText("Record");
        ButtonRecord.setBorder(null);
        ButtonRecord.setContentAreaFilled(false);
        ButtonRecord.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ButtonRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonRecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonRecordMouseExited(evt);
            }
        });
        ButtonRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRecordActionPerformed(evt);
            }
        });
        CreateSystem.add(ButtonRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 240, 180));

        ButtonRollbackCreateSystem.setBackground(new java.awt.Color(255, 255, 255));
        ButtonRollbackCreateSystem.setForeground(new java.awt.Color(255, 255, 255));
        ButtonRollbackCreateSystem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Rollback.png"))); // NOI18N
        ButtonRollbackCreateSystem.setBorder(null);
        ButtonRollbackCreateSystem.setContentAreaFilled(false);
        ButtonRollbackCreateSystem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonRollbackCreateSystemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonRollbackCreateSystemMouseExited(evt);
            }
        });
        ButtonRollbackCreateSystem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRollbackCreateSystemActionPerformed(evt);
            }
        });
        CreateSystem.add(ButtonRollbackCreateSystem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 50));

        AdminConfiguration.addTab("Create in system", CreateSystem);

        DeleteSystem.setBackground(new java.awt.Color(255, 255, 255));
        DeleteSystem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonDeleteBan.setBackground(new java.awt.Color(255, 255, 255));
        ButtonDeleteBan.setForeground(new java.awt.Color(29, 41, 81));
        ButtonDeleteBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/BannedUser.png"))); // NOI18N
        ButtonDeleteBan.setText("Ban User");
        ButtonDeleteBan.setBorder(null);
        ButtonDeleteBan.setContentAreaFilled(false);
        ButtonDeleteBan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ButtonDeleteBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonDeleteBanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonDeleteBanMouseExited(evt);
            }
        });
        ButtonDeleteBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeleteBanActionPerformed(evt);
            }
        });
        DeleteSystem.add(ButtonDeleteBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 230, 180));

        ButtonDeletePerson.setBackground(new java.awt.Color(255, 255, 255));
        ButtonDeletePerson.setForeground(new java.awt.Color(29, 41, 81));
        ButtonDeletePerson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Person.png"))); // NOI18N
        ButtonDeletePerson.setText("Person");
        ButtonDeletePerson.setBorder(null);
        ButtonDeletePerson.setContentAreaFilled(false);
        ButtonDeletePerson.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ButtonDeletePerson.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonDeletePersonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonDeletePersonMouseExited(evt);
            }
        });
        ButtonDeletePerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeletePersonActionPerformed(evt);
            }
        });
        DeleteSystem.add(ButtonDeletePerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 240, 180));

        ButtonDeleteRecord.setBackground(new java.awt.Color(255, 255, 255));
        ButtonDeleteRecord.setForeground(new java.awt.Color(29, 41, 81));
        ButtonDeleteRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Record.png"))); // NOI18N
        ButtonDeleteRecord.setText("Record");
        ButtonDeleteRecord.setBorder(null);
        ButtonDeleteRecord.setContentAreaFilled(false);
        ButtonDeleteRecord.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ButtonDeleteRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonDeleteRecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonDeleteRecordMouseExited(evt);
            }
        });
        ButtonDeleteRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeleteRecordActionPerformed(evt);
            }
        });
        DeleteSystem.add(ButtonDeleteRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 240, 180));

        ButtonRollbackDeleteSystem.setBackground(new java.awt.Color(255, 255, 255));
        ButtonRollbackDeleteSystem.setForeground(new java.awt.Color(255, 255, 255));
        ButtonRollbackDeleteSystem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Rollback.png"))); // NOI18N
        ButtonRollbackDeleteSystem.setBorder(null);
        ButtonRollbackDeleteSystem.setContentAreaFilled(false);
        ButtonRollbackDeleteSystem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonRollbackDeleteSystemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonRollbackDeleteSystemMouseExited(evt);
            }
        });
        ButtonRollbackDeleteSystem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRollbackDeleteSystemActionPerformed(evt);
            }
        });
        DeleteSystem.add(ButtonRollbackDeleteSystem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 50));

        ButtonDeleteUser.setBackground(new java.awt.Color(255, 255, 255));
        ButtonDeleteUser.setForeground(new java.awt.Color(29, 41, 81));
        ButtonDeleteUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/UserCatalogue.png"))); // NOI18N
        ButtonDeleteUser.setText("User");
        ButtonDeleteUser.setBorder(null);
        ButtonDeleteUser.setContentAreaFilled(false);
        ButtonDeleteUser.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ButtonDeleteUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonDeleteUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonDeleteUserMouseExited(evt);
            }
        });
        ButtonDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeleteUserActionPerformed(evt);
            }
        });
        DeleteSystem.add(ButtonDeleteUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 230, 180));

        AdminConfiguration.addTab("Delete in system", DeleteSystem);

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
        LabelUserType1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Catalogues.png"))); // NOI18N
        LabelUserType1.setText("User Catalogues");
        UserCatalogues.add(LabelUserType1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));

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
        LabelUserType2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Catalogues.png"))); // NOI18N
        LabelUserType2.setText("Person Catalogues");
        PersonCatalogues.add(LabelUserType2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

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
        LabelUserType3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Catalogues.png"))); // NOI18N
        LabelUserType3.setText("Record Catalogues");
        RecordCatalogues.add(LabelUserType3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, -1, -1));

        getContentPane().add(RecordCatalogues, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 760, 530));

        CreatePersonAdmin.setBackground(new java.awt.Color(255, 255, 255));
        CreatePersonAdmin.setForeground(new java.awt.Color(255, 255, 255));
        CreatePersonAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CreatePersonAdminMouseEntered(evt);
            }
        });
        CreatePersonAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelIdOffender1.setBackground(new java.awt.Color(255, 255, 255));
        LabelIdOffender1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelIdOffender1.setForeground(new java.awt.Color(29, 41, 81));
        LabelIdOffender1.setText("Id:");
        CreatePersonAdmin.add(LabelIdOffender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 100, 30));

        LabelNameOffender1.setBackground(new java.awt.Color(255, 255, 255));
        LabelNameOffender1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelNameOffender1.setForeground(new java.awt.Color(29, 41, 81));
        LabelNameOffender1.setText("Name:");
        CreatePersonAdmin.add(LabelNameOffender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 100, 30));

        LabelMiddleNameOffender1.setBackground(new java.awt.Color(255, 255, 255));
        LabelMiddleNameOffender1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelMiddleNameOffender1.setForeground(new java.awt.Color(29, 41, 81));
        LabelMiddleNameOffender1.setText("Middle name:");
        CreatePersonAdmin.add(LabelMiddleNameOffender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 120, 30));

        LabelLastNameOffender1.setBackground(new java.awt.Color(255, 255, 255));
        LabelLastNameOffender1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelLastNameOffender1.setForeground(new java.awt.Color(29, 41, 81));
        LabelLastNameOffender1.setText("Last name:");
        CreatePersonAdmin.add(LabelLastNameOffender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 90, 30));

        LabelCommunityOffender1.setBackground(new java.awt.Color(255, 255, 255));
        LabelCommunityOffender1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelCommunityOffender1.setForeground(new java.awt.Color(29, 41, 81));
        LabelCommunityOffender1.setText("District:");
        CreatePersonAdmin.add(LabelCommunityOffender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, 100, 30));

        LabelInstitutionOffender1.setBackground(new java.awt.Color(255, 255, 255));
        LabelInstitutionOffender1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelInstitutionOffender1.setForeground(new java.awt.Color(29, 41, 81));
        LabelInstitutionOffender1.setText("Institution:");
        CreatePersonAdmin.add(LabelInstitutionOffender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 90, 30));

        LabelOffenderGender1.setBackground(new java.awt.Color(255, 255, 255));
        LabelOffenderGender1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelOffenderGender1.setForeground(new java.awt.Color(29, 41, 81));
        LabelOffenderGender1.setText("Gender:");
        CreatePersonAdmin.add(LabelOffenderGender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 100, 30));

        LabelOffenderBirthday1.setBackground(new java.awt.Color(255, 255, 255));
        LabelOffenderBirthday1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelOffenderBirthday1.setForeground(new java.awt.Color(29, 41, 81));
        LabelOffenderBirthday1.setText("Birthday:");
        CreatePersonAdmin.add(LabelOffenderBirthday1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, 100, 30));

        LineOffenderId1.setForeground(new java.awt.Color(29, 41, 81));
        CreatePersonAdmin.add(LineOffenderId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 220, 20));

        IdPersonField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        IdPersonField1.setForeground(new java.awt.Color(29, 41, 81));
        IdPersonField1.setBorder(null);
        CreatePersonAdmin.add(IdPersonField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 220, 30));

        LineOffenderName2.setForeground(new java.awt.Color(29, 41, 81));
        CreatePersonAdmin.add(LineOffenderName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 220, 20));

        NamePersonField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NamePersonField1.setForeground(new java.awt.Color(29, 41, 81));
        NamePersonField1.setBorder(null);
        CreatePersonAdmin.add(NamePersonField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 220, 30));

        LineOffenderMiddleName1.setForeground(new java.awt.Color(29, 41, 81));
        CreatePersonAdmin.add(LineOffenderMiddleName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 220, 20));

        MiddleNamePersonField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        MiddleNamePersonField1.setForeground(new java.awt.Color(29, 41, 81));
        MiddleNamePersonField1.setBorder(null);
        CreatePersonAdmin.add(MiddleNamePersonField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 220, 30));

        LineOffenderLastName1.setForeground(new java.awt.Color(29, 41, 81));
        CreatePersonAdmin.add(LineOffenderLastName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 220, 20));

        LastNamePersonField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LastNamePersonField1.setForeground(new java.awt.Color(29, 41, 81));
        LastNamePersonField1.setBorder(null);
        CreatePersonAdmin.add(LastNamePersonField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 220, 30));

        LineOffenderBirthday3.setForeground(new java.awt.Color(29, 41, 81));
        CreatePersonAdmin.add(LineOffenderBirthday3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 130, 20));

        BirthdayPersonField1.setBorder(null);
        BirthdayPersonField1.setForeground(new java.awt.Color(29, 41, 81));
        BirthdayPersonField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        CreatePersonAdmin.add(BirthdayPersonField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 130, 30));

        BoxDistrictPerson1.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        BoxDistrictPerson1.setForeground(new java.awt.Color(29, 41, 81));
        BoxDistrictPerson1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        CreatePersonAdmin.add(BoxDistrictPerson1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, 170, 30));

        BoxInstitutionPerson1.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        BoxInstitutionPerson1.setForeground(new java.awt.Color(29, 41, 81));
        BoxInstitutionPerson1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        CreatePersonAdmin.add(BoxInstitutionPerson1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, 170, 30));

        BoxGenderPerson1.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        BoxGenderPerson1.setForeground(new java.awt.Color(29, 41, 81));
        BoxGenderPerson1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        CreatePersonAdmin.add(BoxGenderPerson1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 120, 30));

        ButtonCancelPerson1.setBackground(new java.awt.Color(255, 255, 255));
        ButtonCancelPerson1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonCancelPerson1.setForeground(new java.awt.Color(29, 41, 81));
        ButtonCancelPerson1.setText("Cancel");
        ButtonCancelPerson1.setBorder(null);
        ButtonCancelPerson1.setContentAreaFilled(false);
        ButtonCancelPerson1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonCancelPerson1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonCancelPerson1MouseExited(evt);
            }
        });
        ButtonCancelPerson1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelPerson1ActionPerformed(evt);
            }
        });
        CreatePersonAdmin.add(ButtonCancelPerson1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 460, 100, 40));

        ButtonConfirmPerson1.setBackground(new java.awt.Color(255, 255, 255));
        ButtonConfirmPerson1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonConfirmPerson1.setForeground(new java.awt.Color(29, 41, 81));
        ButtonConfirmPerson1.setText("Confirm");
        ButtonConfirmPerson1.setBorder(null);
        ButtonConfirmPerson1.setContentAreaFilled(false);
        ButtonConfirmPerson1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonConfirmPerson1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonConfirmPerson1MouseExited(evt);
            }
        });
        ButtonConfirmPerson1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonConfirmPerson1ActionPerformed(evt);
            }
        });
        CreatePersonAdmin.add(ButtonConfirmPerson1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, 100, 40));

        IconOffender1.setBackground(new java.awt.Color(255, 255, 255));
        IconOffender1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        IconOffender1.setForeground(new java.awt.Color(29, 41, 81));
        IconOffender1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/AddUser.png"))); // NOI18N
        IconOffender1.setText("Person Information");
        IconOffender1.setMaximumSize(new java.awt.Dimension(240, 128));
        IconOffender1.setMinimumSize(new java.awt.Dimension(240, 128));
        CreatePersonAdmin.add(IconOffender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 380, 130));

        getContentPane().add(CreatePersonAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 760, 530));

        CreateRecordAdmin.setBackground(new java.awt.Color(255, 255, 255));
        CreateRecordAdmin.setForeground(new java.awt.Color(255, 255, 255));
        CreateRecordAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CreateRecordAdminMouseEntered(evt);
            }
        });
        CreateRecordAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonRollbackCreateRecord1.setBackground(new java.awt.Color(255, 255, 255));
        ButtonRollbackCreateRecord1.setForeground(new java.awt.Color(255, 255, 255));
        ButtonRollbackCreateRecord1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Rollback.png"))); // NOI18N
        ButtonRollbackCreateRecord1.setBorder(null);
        ButtonRollbackCreateRecord1.setContentAreaFilled(false);
        ButtonRollbackCreateRecord1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonRollbackCreateRecord1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonRollbackCreateRecord1MouseExited(evt);
            }
        });
        ButtonRollbackCreateRecord1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRollbackCreateRecord1ActionPerformed(evt);
            }
        });
        CreateRecordAdmin.add(ButtonRollbackCreateRecord1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        LabelRecordNumber1.setBackground(new java.awt.Color(255, 255, 255));
        LabelRecordNumber1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelRecordNumber1.setForeground(new java.awt.Color(29, 41, 81));
        LabelRecordNumber1.setText("Record number:");
        CreateRecordAdmin.add(LabelRecordNumber1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 190, 30));

        LabelCrimeDescription1.setBackground(new java.awt.Color(255, 255, 255));
        LabelCrimeDescription1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelCrimeDescription1.setForeground(new java.awt.Color(29, 41, 81));
        LabelCrimeDescription1.setText("Crime Description:");
        CreateRecordAdmin.add(LabelCrimeDescription1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 160, 30));

        LabelOffender1.setBackground(new java.awt.Color(255, 255, 255));
        LabelOffender1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelOffender1.setForeground(new java.awt.Color(29, 41, 81));
        LabelOffender1.setText("Offender:");
        CreateRecordAdmin.add(LabelOffender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 90, 30));

        LabelDateCrime1.setBackground(new java.awt.Color(255, 255, 255));
        LabelDateCrime1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelDateCrime1.setForeground(new java.awt.Color(29, 41, 81));
        LabelDateCrime1.setText("Date crime:");
        CreateRecordAdmin.add(LabelDateCrime1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 110, 30));

        LineNumberRecord1.setForeground(new java.awt.Color(29, 41, 81));
        CreateRecordAdmin.add(LineNumberRecord1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 220, 20));

        RecordNumberField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        RecordNumberField1.setForeground(new java.awt.Color(29, 41, 81));
        RecordNumberField1.setBorder(null);
        CreateRecordAdmin.add(RecordNumberField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 220, 30));

        LineDateCrime8.setForeground(new java.awt.Color(29, 41, 81));
        CreateRecordAdmin.add(LineDateCrime8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 110, 20));

        DateCrimeCreateRecord1.setBorder(null);
        DateCrimeCreateRecord1.setForeground(new java.awt.Color(29, 41, 81));
        DateCrimeCreateRecord1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        CreateRecordAdmin.add(DateCrimeCreateRecord1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 110, 30));

        BoxOffender1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BoxOffender1.setForeground(new java.awt.Color(29, 41, 81));
        BoxOffender1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        CreateRecordAdmin.add(BoxOffender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 160, 30));

        IconCreateReacord1.setBackground(new java.awt.Color(255, 255, 255));
        IconCreateReacord1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        IconCreateReacord1.setForeground(new java.awt.Color(29, 41, 81));
        IconCreateReacord1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/AddFile.png"))); // NOI18N
        IconCreateReacord1.setText("Create Record");
        IconCreateReacord1.setMaximumSize(new java.awt.Dimension(240, 128));
        IconCreateReacord1.setMinimumSize(new java.awt.Dimension(240, 128));
        CreateRecordAdmin.add(IconCreateReacord1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 300, 90));

        CrimeDescriptionCreateRecord1.setColumns(20);
        CrimeDescriptionCreateRecord1.setRows(5);
        jScrollPane9.setViewportView(CrimeDescriptionCreateRecord1);

        CreateRecordAdmin.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 220, 40));

        PictureNewRecord1.setBackground(new java.awt.Color(255, 255, 255));
        PictureNewRecord1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        PictureNewRecord1.setForeground(new java.awt.Color(29, 41, 81));
        PictureNewRecord1.setText("Picture");
        PictureNewRecord1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        PictureNewRecord1.setContentAreaFilled(false);
        PictureNewRecord1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PictureNewRecord1ActionPerformed(evt);
            }
        });
        CreateRecordAdmin.add(PictureNewRecord1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 110, 120));

        RightPicRecordAdmin.setBackground(new java.awt.Color(255, 255, 255));
        RightPicRecordAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/RightPic.png"))); // NOI18N
        RightPicRecordAdmin.setBorder(null);
        RightPicRecordAdmin.setContentAreaFilled(false);
        RightPicRecordAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RightPicRecordAdminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RightPicRecordAdminMouseExited(evt);
            }
        });
        RightPicRecordAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RightPicRecordAdminActionPerformed(evt);
            }
        });
        CreateRecordAdmin.add(RightPicRecordAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, 40, 40));

        LeftPicRecordAdmin.setBackground(new java.awt.Color(255, 255, 255));
        LeftPicRecordAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/LeftPic.png"))); // NOI18N
        LeftPicRecordAdmin.setBorder(null);
        LeftPicRecordAdmin.setContentAreaFilled(false);
        LeftPicRecordAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LeftPicRecordAdminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LeftPicRecordAdminMouseExited(evt);
            }
        });
        LeftPicRecordAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeftPicRecordAdminActionPerformed(evt);
            }
        });
        CreateRecordAdmin.add(LeftPicRecordAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 40, 40));

        ButtonCreateOffender1.setBackground(new java.awt.Color(255, 255, 255));
        ButtonCreateOffender1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/AddPic.png"))); // NOI18N
        ButtonCreateOffender1.setBorder(null);
        ButtonCreateOffender1.setContentAreaFilled(false);
        ButtonCreateOffender1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonCreateOffender1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonCreateOffender1MouseExited(evt);
            }
        });
        ButtonCreateOffender1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCreateOffender1ActionPerformed(evt);
            }
        });
        CreateRecordAdmin.add(ButtonCreateOffender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, 40, 40));

        RemovePicRecordAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/RemovePic.png"))); // NOI18N
        RemovePicRecordAdmin.setContentAreaFilled(false);
        RemovePicRecordAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RemovePicRecordAdminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RemovePicRecordAdminMouseExited(evt);
            }
        });
        RemovePicRecordAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemovePicRecordAdminActionPerformed(evt);
            }
        });
        CreateRecordAdmin.add(RemovePicRecordAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 40, 40));

        LabelResolutionUnapproved4.setBackground(new java.awt.Color(255, 255, 255));
        LabelResolutionUnapproved4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelResolutionUnapproved4.setForeground(new java.awt.Color(29, 41, 81));
        LabelResolutionUnapproved4.setText("Resolution:");
        CreateRecordAdmin.add(LabelResolutionUnapproved4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 110, 30));

        LabelVeredictUnapproved4.setBackground(new java.awt.Color(255, 255, 255));
        LabelVeredictUnapproved4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelVeredictUnapproved4.setForeground(new java.awt.Color(29, 41, 81));
        LabelVeredictUnapproved4.setText("Veredict:");
        CreateRecordAdmin.add(LabelVeredictUnapproved4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 100, 30));

        ButtonCancelRecordAdmin.setBackground(new java.awt.Color(255, 255, 255));
        ButtonCancelRecordAdmin.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonCancelRecordAdmin.setForeground(new java.awt.Color(29, 41, 81));
        ButtonCancelRecordAdmin.setText("Cancel");
        ButtonCancelRecordAdmin.setBorder(null);
        ButtonCancelRecordAdmin.setContentAreaFilled(false);
        ButtonCancelRecordAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonCancelRecordAdminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonCancelRecordAdminMouseExited(evt);
            }
        });
        ButtonCancelRecordAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelRecordAdminActionPerformed(evt);
            }
        });
        CreateRecordAdmin.add(ButtonCancelRecordAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, 100, 40));

        CheckBoxApprovedOrNotCreateRecord1.setBackground(new java.awt.Color(255, 255, 255));
        CheckBoxApprovedOrNotCreateRecord1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        CheckBoxApprovedOrNotCreateRecord1.setForeground(new java.awt.Color(29, 41, 81));
        CheckBoxApprovedOrNotCreateRecord1.setText("Approved");
        CreateRecordAdmin.add(CheckBoxApprovedOrNotCreateRecord1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, 110, -1));

        ExpireDateCreateRecord1.setBorder(null);
        ExpireDateCreateRecord1.setForeground(new java.awt.Color(29, 41, 81));
        ExpireDateCreateRecord1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        ExpireDateCreateRecord1.setCaretColor(new java.awt.Color(204, 204, 204));
        CreateRecordAdmin.add(ExpireDateCreateRecord1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 420, 70, 30));

        LineExpireDate4.setForeground(new java.awt.Color(29, 41, 81));
        CreateRecordAdmin.add(LineExpireDate4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 450, 70, 20));

        LabelExpireDateUnapproved6.setBackground(new java.awt.Color(255, 255, 255));
        LabelExpireDateUnapproved6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelExpireDateUnapproved6.setForeground(new java.awt.Color(29, 41, 81));
        LabelExpireDateUnapproved6.setText("Expire date:");
        CreateRecordAdmin.add(LabelExpireDateUnapproved6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 420, 100, 30));

        YearsSentenceCreateRecord1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        YearsSentenceCreateRecord1.setForeground(new java.awt.Color(29, 41, 81));
        YearsSentenceCreateRecord1.setBorder(null);
        CreateRecordAdmin.add(YearsSentenceCreateRecord1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 240, 80, 30));

        LineResolution6.setForeground(new java.awt.Color(29, 41, 81));
        CreateRecordAdmin.add(LineResolution6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 270, 80, 20));

        BoxResolutionCreateRecord1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BoxResolutionCreateRecord1.setForeground(new java.awt.Color(29, 41, 81));
        BoxResolutionCreateRecord1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Guilty", "Innocent" }));
        BoxResolutionCreateRecord1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxResolutionCreateRecord1ActionPerformed(evt);
            }
        });
        CreateRecordAdmin.add(BoxResolutionCreateRecord1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 140, 30));

        LabelVeredictUnapproved5.setBackground(new java.awt.Color(255, 255, 255));
        LabelVeredictUnapproved5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelVeredictUnapproved5.setForeground(new java.awt.Color(29, 41, 81));
        LabelVeredictUnapproved5.setText("Years of sentence:");
        CreateRecordAdmin.add(LabelVeredictUnapproved5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 160, 30));

        LineDateCrime9.setForeground(new java.awt.Color(29, 41, 81));
        CreateRecordAdmin.add(LineDateCrime9, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 310, 110, 20));

        StartDateSentenceCreateRecord1.setBorder(null);
        StartDateSentenceCreateRecord1.setForeground(new java.awt.Color(29, 41, 81));
        StartDateSentenceCreateRecord1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        CreateRecordAdmin.add(StartDateSentenceCreateRecord1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 280, 110, 30));

        LabelExpireDateUnapproved7.setBackground(new java.awt.Color(255, 255, 255));
        LabelExpireDateUnapproved7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelExpireDateUnapproved7.setForeground(new java.awt.Color(29, 41, 81));
        LabelExpireDateUnapproved7.setText("Start date:");
        CreateRecordAdmin.add(LabelExpireDateUnapproved7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, 100, 30));

        LabelExpireDateUnapproved8.setBackground(new java.awt.Color(255, 255, 255));
        LabelExpireDateUnapproved8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelExpireDateUnapproved8.setForeground(new java.awt.Color(29, 41, 81));
        LabelExpireDateUnapproved8.setText("Finish date:");
        CreateRecordAdmin.add(LabelExpireDateUnapproved8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 110, 30));

        LineDateCrime10.setForeground(new java.awt.Color(29, 41, 81));
        LineDateCrime10.setOpaque(true);
        CreateRecordAdmin.add(LineDateCrime10, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 360, 110, 20));

        FinishDateSentenceCreateRecord1.setBorder(null);
        FinishDateSentenceCreateRecord1.setForeground(new java.awt.Color(29, 41, 81));
        FinishDateSentenceCreateRecord1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        CreateRecordAdmin.add(FinishDateSentenceCreateRecord1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 110, 30));

        LabelResolutionUnapproved5.setBackground(new java.awt.Color(255, 255, 255));
        LabelResolutionUnapproved5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelResolutionUnapproved5.setForeground(new java.awt.Color(29, 41, 81));
        LabelResolutionUnapproved5.setText("District:");
        CreateRecordAdmin.add(LabelResolutionUnapproved5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 80, 30));

        BoxTypeSentenceCreateRecord1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BoxTypeSentenceCreateRecord1.setForeground(new java.awt.Color(29, 41, 81));
        BoxTypeSentenceCreateRecord1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        CreateRecordAdmin.add(BoxTypeSentenceCreateRecord1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 380, 120, 30));

        LabelCrimeTypeUnapproved2.setBackground(new java.awt.Color(255, 255, 255));
        LabelCrimeTypeUnapproved2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelCrimeTypeUnapproved2.setForeground(new java.awt.Color(29, 41, 81));
        LabelCrimeTypeUnapproved2.setText("Type of crime:");
        CreateRecordAdmin.add(LabelCrimeTypeUnapproved2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, -1, 30));

        ButtonConfirmRecordAdmin.setBackground(new java.awt.Color(255, 255, 255));
        ButtonConfirmRecordAdmin.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonConfirmRecordAdmin.setForeground(new java.awt.Color(29, 41, 81));
        ButtonConfirmRecordAdmin.setText("Confirm");
        ButtonConfirmRecordAdmin.setBorder(null);
        ButtonConfirmRecordAdmin.setContentAreaFilled(false);
        ButtonConfirmRecordAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonConfirmRecordAdminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonConfirmRecordAdminMouseExited(evt);
            }
        });
        ButtonConfirmRecordAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonConfirmRecordAdminActionPerformed(evt);
            }
        });
        CreateRecordAdmin.add(ButtonConfirmRecordAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 470, 100, 40));

        BoxTypeCrimeCreateRecord1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BoxTypeCrimeCreateRecord1.setForeground(new java.awt.Color(29, 41, 81));
        BoxTypeCrimeCreateRecord1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        CreateRecordAdmin.add(BoxTypeCrimeCreateRecord1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, 150, 30));

        AddPicRecordAdmin.setBackground(new java.awt.Color(255, 255, 255));
        AddPicRecordAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/AddPic.png"))); // NOI18N
        AddPicRecordAdmin.setBorder(null);
        AddPicRecordAdmin.setContentAreaFilled(false);
        AddPicRecordAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddPicRecordAdminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddPicRecordAdminMouseExited(evt);
            }
        });
        AddPicRecordAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPicRecordAdminActionPerformed(evt);
            }
        });
        CreateRecordAdmin.add(AddPicRecordAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, 40, 40));

        getContentPane().add(CreateRecordAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 760, 530));

        CreateBanUser.setBackground(new java.awt.Color(255, 255, 255));
        CreateBanUser.setForeground(new java.awt.Color(255, 255, 255));
        CreateBanUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CreateBanUserMouseEntered(evt);
            }
        });
        CreateBanUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonRollbackBanUser.setBackground(new java.awt.Color(255, 255, 255));
        ButtonRollbackBanUser.setForeground(new java.awt.Color(255, 255, 255));
        ButtonRollbackBanUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Rollback.png"))); // NOI18N
        ButtonRollbackBanUser.setBorder(null);
        ButtonRollbackBanUser.setContentAreaFilled(false);
        ButtonRollbackBanUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonRollbackBanUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonRollbackBanUserMouseExited(evt);
            }
        });
        ButtonRollbackBanUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRollbackBanUserActionPerformed(evt);
            }
        });
        CreateBanUser.add(ButtonRollbackBanUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        IconCreateReacord2.setBackground(new java.awt.Color(255, 255, 255));
        IconCreateReacord2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        IconCreateReacord2.setForeground(new java.awt.Color(29, 41, 81));
        IconCreateReacord2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Ban.png"))); // NOI18N
        IconCreateReacord2.setText("Create Ban User");
        IconCreateReacord2.setMaximumSize(new java.awt.Dimension(240, 128));
        IconCreateReacord2.setMinimumSize(new java.awt.Dimension(240, 128));
        CreateBanUser.add(IconCreateReacord2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 300, 90));

        LabelResolutionUnapproved7.setBackground(new java.awt.Color(255, 255, 255));
        LabelResolutionUnapproved7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelResolutionUnapproved7.setForeground(new java.awt.Color(29, 41, 81));
        LabelResolutionUnapproved7.setText("List of users");
        CreateBanUser.add(LabelResolutionUnapproved7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 100, 30));

        BoxReasonBanned.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BoxReasonBanned.setForeground(new java.awt.Color(29, 41, 81));
        BoxReasonBanned.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        CreateBanUser.add(BoxReasonBanned, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 410, 120, 30));

        ButtonConfirmBanned.setBackground(new java.awt.Color(255, 255, 255));
        ButtonConfirmBanned.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonConfirmBanned.setForeground(new java.awt.Color(29, 41, 81));
        ButtonConfirmBanned.setText("Confirm");
        ButtonConfirmBanned.setBorder(null);
        ButtonConfirmBanned.setContentAreaFilled(false);
        ButtonConfirmBanned.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonConfirmBannedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonConfirmBannedMouseExited(evt);
            }
        });
        ButtonConfirmBanned.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonConfirmBannedActionPerformed(evt);
            }
        });
        CreateBanUser.add(ButtonConfirmBanned, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 470, 100, 40));

        jScrollPane15.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        jScrollPane15.setForeground(new java.awt.Color(29, 41, 81));

        ListUsersForBan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        ListUsersForBan.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        ListUsersForBan.setForeground(new java.awt.Color(29, 41, 81));
        ListUsersForBan.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ListUsersForBan.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jScrollPane15.setViewportView(ListUsersForBan);

        CreateBanUser.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 280, -1));

        CheckBoxPermanency.setBackground(new java.awt.Color(255, 255, 255));
        CheckBoxPermanency.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        CheckBoxPermanency.setForeground(new java.awt.Color(29, 41, 81));
        CheckBoxPermanency.setLabel("Permanent");
        CreateBanUser.add(CheckBoxPermanency, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, -1, -1));

        LabelResolutionUnapproved8.setBackground(new java.awt.Color(255, 255, 255));
        LabelResolutionUnapproved8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelResolutionUnapproved8.setForeground(new java.awt.Color(29, 41, 81));
        LabelResolutionUnapproved8.setText("Reason of banned:");
        CreateBanUser.add(LabelResolutionUnapproved8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, 160, 30));

        LabelChooseFilterRecords9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LabelChooseFilterRecords9.setForeground(new java.awt.Color(29, 41, 81));
        LabelChooseFilterRecords9.setText("End Date:");
        CreateBanUser.add(LabelChooseFilterRecords9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, -1, 30));

        DateStartField2.setBorder(null);
        DateStartField2.setForeground(new java.awt.Color(29, 41, 81));
        DateStartField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        CreateBanUser.add(DateStartField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 110, 30));

        LineDateCrime13.setForeground(new java.awt.Color(29, 41, 81));
        CreateBanUser.add(LineDateCrime13, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 110, 20));

        DateEndField2.setBorder(null);
        DateEndField2.setForeground(new java.awt.Color(29, 41, 81));
        DateEndField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        CreateBanUser.add(DateEndField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 350, 110, 30));

        LineDateCrime14.setForeground(new java.awt.Color(29, 41, 81));
        CreateBanUser.add(LineDateCrime14, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, 110, 20));

        LabelChooseFilterRecords10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LabelChooseFilterRecords10.setForeground(new java.awt.Color(29, 41, 81));
        LabelChooseFilterRecords10.setText("Start Date:");
        CreateBanUser.add(LabelChooseFilterRecords10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, -1, 30));

        getContentPane().add(CreateBanUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 760, 530));

        DeleteUser.setBackground(new java.awt.Color(255, 255, 255));
        DeleteUser.setForeground(new java.awt.Color(255, 255, 255));
        DeleteUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DeleteUserMouseEntered(evt);
            }
        });
        DeleteUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonRollbackDeleteUser.setBackground(new java.awt.Color(255, 255, 255));
        ButtonRollbackDeleteUser.setForeground(new java.awt.Color(255, 255, 255));
        ButtonRollbackDeleteUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Rollback.png"))); // NOI18N
        ButtonRollbackDeleteUser.setBorder(null);
        ButtonRollbackDeleteUser.setContentAreaFilled(false);
        ButtonRollbackDeleteUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonRollbackDeleteUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonRollbackDeleteUserMouseExited(evt);
            }
        });
        ButtonRollbackDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRollbackDeleteUserActionPerformed(evt);
            }
        });
        DeleteUser.add(ButtonRollbackDeleteUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        IconCreateReacord3.setBackground(new java.awt.Color(255, 255, 255));
        IconCreateReacord3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        IconCreateReacord3.setForeground(new java.awt.Color(29, 41, 81));
        IconCreateReacord3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/RemovePic.png"))); // NOI18N
        IconCreateReacord3.setText("Delete User");
        IconCreateReacord3.setMaximumSize(new java.awt.Dimension(240, 128));
        IconCreateReacord3.setMinimumSize(new java.awt.Dimension(240, 128));
        DeleteUser.add(IconCreateReacord3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 300, 90));

        LabelResolutionUnapproved9.setBackground(new java.awt.Color(255, 255, 255));
        LabelResolutionUnapproved9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelResolutionUnapproved9.setForeground(new java.awt.Color(29, 41, 81));
        LabelResolutionUnapproved9.setText("List of users");
        DeleteUser.add(LabelResolutionUnapproved9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 100, 30));

        ButtonDelete.setBackground(new java.awt.Color(255, 255, 255));
        ButtonDelete.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonDelete.setForeground(new java.awt.Color(29, 41, 81));
        ButtonDelete.setText("Delete");
        ButtonDelete.setBorder(null);
        ButtonDelete.setContentAreaFilled(false);
        ButtonDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonDeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonDeleteMouseExited(evt);
            }
        });
        ButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeleteActionPerformed(evt);
            }
        });
        DeleteUser.add(ButtonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 450, 100, 40));

        jScrollPane18.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        jScrollPane18.setForeground(new java.awt.Color(29, 41, 81));

        ListUsersDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        ListUsersDelete.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        ListUsersDelete.setForeground(new java.awt.Color(29, 41, 81));
        ListUsersDelete.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ListUsersDelete.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jScrollPane18.setViewportView(ListUsersDelete);

        DeleteUser.add(jScrollPane18, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 280, 250));

        ButtonRefreshForDeleteUser.setBackground(new java.awt.Color(255, 255, 255));
        ButtonRefreshForDeleteUser.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonRefreshForDeleteUser.setForeground(new java.awt.Color(29, 41, 81));
        ButtonRefreshForDeleteUser.setText("Refresh");
        ButtonRefreshForDeleteUser.setBorder(null);
        ButtonRefreshForDeleteUser.setContentAreaFilled(false);
        ButtonRefreshForDeleteUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonRefreshForDeleteUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonRefreshForDeleteUserMouseExited(evt);
            }
        });
        ButtonRefreshForDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRefreshForDeleteUserActionPerformed(evt);
            }
        });
        DeleteUser.add(ButtonRefreshForDeleteUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 450, 100, 40));

        getContentPane().add(DeleteUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 760, 530));

        DeletePerson.setBackground(new java.awt.Color(255, 255, 255));
        DeletePerson.setForeground(new java.awt.Color(255, 255, 255));
        DeletePerson.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DeletePersonMouseEntered(evt);
            }
        });
        DeletePerson.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonRollbackPersonDelete.setBackground(new java.awt.Color(255, 255, 255));
        ButtonRollbackPersonDelete.setForeground(new java.awt.Color(255, 255, 255));
        ButtonRollbackPersonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Rollback.png"))); // NOI18N
        ButtonRollbackPersonDelete.setBorder(null);
        ButtonRollbackPersonDelete.setContentAreaFilled(false);
        ButtonRollbackPersonDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonRollbackPersonDeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonRollbackPersonDeleteMouseExited(evt);
            }
        });
        ButtonRollbackPersonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRollbackPersonDeleteActionPerformed(evt);
            }
        });
        DeletePerson.add(ButtonRollbackPersonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        IconCreateReacord4.setBackground(new java.awt.Color(255, 255, 255));
        IconCreateReacord4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        IconCreateReacord4.setForeground(new java.awt.Color(29, 41, 81));
        IconCreateReacord4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/RemovePic.png"))); // NOI18N
        IconCreateReacord4.setText("Delete Person");
        IconCreateReacord4.setMaximumSize(new java.awt.Dimension(240, 128));
        IconCreateReacord4.setMinimumSize(new java.awt.Dimension(240, 128));
        DeletePerson.add(IconCreateReacord4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 300, 90));

        LabelResolutionUnapproved11.setBackground(new java.awt.Color(255, 255, 255));
        LabelResolutionUnapproved11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelResolutionUnapproved11.setForeground(new java.awt.Color(29, 41, 81));
        LabelResolutionUnapproved11.setText("Id list");
        DeletePerson.add(LabelResolutionUnapproved11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 100, 30));

        ButtonPersonDelete.setBackground(new java.awt.Color(255, 255, 255));
        ButtonPersonDelete.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonPersonDelete.setForeground(new java.awt.Color(29, 41, 81));
        ButtonPersonDelete.setText("Delete");
        ButtonPersonDelete.setBorder(null);
        ButtonPersonDelete.setContentAreaFilled(false);
        ButtonPersonDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonPersonDeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonPersonDeleteMouseExited(evt);
            }
        });
        ButtonPersonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPersonDeleteActionPerformed(evt);
            }
        });
        DeletePerson.add(ButtonPersonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 450, 100, 40));

        jScrollPane19.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        jScrollPane19.setForeground(new java.awt.Color(29, 41, 81));

        ListPersonDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        ListPersonDelete.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        ListPersonDelete.setForeground(new java.awt.Color(29, 41, 81));
        ListPersonDelete.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ListPersonDelete.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jScrollPane19.setViewportView(ListPersonDelete);

        DeletePerson.add(jScrollPane19, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 280, 240));

        ButtonPersonRefreshForDelete.setBackground(new java.awt.Color(255, 255, 255));
        ButtonPersonRefreshForDelete.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonPersonRefreshForDelete.setForeground(new java.awt.Color(29, 41, 81));
        ButtonPersonRefreshForDelete.setText("Refresh");
        ButtonPersonRefreshForDelete.setBorder(null);
        ButtonPersonRefreshForDelete.setContentAreaFilled(false);
        ButtonPersonRefreshForDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonPersonRefreshForDeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonPersonRefreshForDeleteMouseExited(evt);
            }
        });
        ButtonPersonRefreshForDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPersonRefreshForDeleteActionPerformed(evt);
            }
        });
        DeletePerson.add(ButtonPersonRefreshForDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 100, 40));

        getContentPane().add(DeletePerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 760, 530));

        DeleteRecord.setBackground(new java.awt.Color(255, 255, 255));
        DeleteRecord.setForeground(new java.awt.Color(255, 255, 255));
        DeleteRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DeleteRecordMouseEntered(evt);
            }
        });
        DeleteRecord.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonRollbackRecordDelete.setBackground(new java.awt.Color(255, 255, 255));
        ButtonRollbackRecordDelete.setForeground(new java.awt.Color(255, 255, 255));
        ButtonRollbackRecordDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Rollback.png"))); // NOI18N
        ButtonRollbackRecordDelete.setBorder(null);
        ButtonRollbackRecordDelete.setContentAreaFilled(false);
        ButtonRollbackRecordDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonRollbackRecordDeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonRollbackRecordDeleteMouseExited(evt);
            }
        });
        ButtonRollbackRecordDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRollbackRecordDeleteActionPerformed(evt);
            }
        });
        DeleteRecord.add(ButtonRollbackRecordDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        IconCreateReacord5.setBackground(new java.awt.Color(255, 255, 255));
        IconCreateReacord5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        IconCreateReacord5.setForeground(new java.awt.Color(29, 41, 81));
        IconCreateReacord5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/RemovePic.png"))); // NOI18N
        IconCreateReacord5.setText("Delete Record");
        IconCreateReacord5.setMaximumSize(new java.awt.Dimension(240, 128));
        IconCreateReacord5.setMinimumSize(new java.awt.Dimension(240, 128));
        DeleteRecord.add(IconCreateReacord5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 300, 90));

        LabelResolutionUnapproved13.setBackground(new java.awt.Color(255, 255, 255));
        LabelResolutionUnapproved13.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelResolutionUnapproved13.setForeground(new java.awt.Color(29, 41, 81));
        LabelResolutionUnapproved13.setText("Record list");
        DeleteRecord.add(LabelResolutionUnapproved13, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 90, 30));

        ButtonRecordDelete.setBackground(new java.awt.Color(255, 255, 255));
        ButtonRecordDelete.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonRecordDelete.setForeground(new java.awt.Color(29, 41, 81));
        ButtonRecordDelete.setText("Delete");
        ButtonRecordDelete.setBorder(null);
        ButtonRecordDelete.setContentAreaFilled(false);
        ButtonRecordDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonRecordDeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonRecordDeleteMouseExited(evt);
            }
        });
        ButtonRecordDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRecordDeleteActionPerformed(evt);
            }
        });
        DeleteRecord.add(ButtonRecordDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 450, 100, 40));

        jScrollPane20.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        jScrollPane20.setForeground(new java.awt.Color(29, 41, 81));

        ListRecordsDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        ListRecordsDelete.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        ListRecordsDelete.setForeground(new java.awt.Color(29, 41, 81));
        ListRecordsDelete.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ListRecordsDelete.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jScrollPane20.setViewportView(ListRecordsDelete);

        DeleteRecord.add(jScrollPane20, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 280, 250));

        ButtonPersonRefreshForDelete1.setBackground(new java.awt.Color(255, 255, 255));
        ButtonPersonRefreshForDelete1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonPersonRefreshForDelete1.setForeground(new java.awt.Color(29, 41, 81));
        ButtonPersonRefreshForDelete1.setText("Refresh");
        ButtonPersonRefreshForDelete1.setBorder(null);
        ButtonPersonRefreshForDelete1.setContentAreaFilled(false);
        ButtonPersonRefreshForDelete1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonPersonRefreshForDelete1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonPersonRefreshForDelete1MouseExited(evt);
            }
        });
        ButtonPersonRefreshForDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPersonRefreshForDelete1ActionPerformed(evt);
            }
        });
        DeleteRecord.add(ButtonPersonRefreshForDelete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 100, 40));

        getContentPane().add(DeleteRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 760, 530));

        DeleteBan.setBackground(new java.awt.Color(255, 255, 255));
        DeleteBan.setForeground(new java.awt.Color(255, 255, 255));
        DeleteBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DeleteBanMouseEntered(evt);
            }
        });
        DeleteBan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonRollbackDeleteBan.setBackground(new java.awt.Color(255, 255, 255));
        ButtonRollbackDeleteBan.setForeground(new java.awt.Color(255, 255, 255));
        ButtonRollbackDeleteBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/Rollback.png"))); // NOI18N
        ButtonRollbackDeleteBan.setBorder(null);
        ButtonRollbackDeleteBan.setContentAreaFilled(false);
        ButtonRollbackDeleteBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonRollbackDeleteBanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonRollbackDeleteBanMouseExited(evt);
            }
        });
        ButtonRollbackDeleteBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRollbackDeleteBanActionPerformed(evt);
            }
        });
        DeleteBan.add(ButtonRollbackDeleteBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        IconCreateReacord6.setBackground(new java.awt.Color(255, 255, 255));
        IconCreateReacord6.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        IconCreateReacord6.setForeground(new java.awt.Color(29, 41, 81));
        IconCreateReacord6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/RemovePic.png"))); // NOI18N
        IconCreateReacord6.setText("Delete Ban");
        IconCreateReacord6.setMaximumSize(new java.awt.Dimension(240, 128));
        IconCreateReacord6.setMinimumSize(new java.awt.Dimension(240, 128));
        DeleteBan.add(IconCreateReacord6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 300, 90));

        LabelResolutionUnapproved15.setBackground(new java.awt.Color(255, 255, 255));
        LabelResolutionUnapproved15.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelResolutionUnapproved15.setForeground(new java.awt.Color(29, 41, 81));
        LabelResolutionUnapproved15.setText("Banned user list");
        DeleteBan.add(LabelResolutionUnapproved15, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 150, 30));

        ButtonBanDelete.setBackground(new java.awt.Color(255, 255, 255));
        ButtonBanDelete.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonBanDelete.setForeground(new java.awt.Color(29, 41, 81));
        ButtonBanDelete.setText("Delete");
        ButtonBanDelete.setBorder(null);
        ButtonBanDelete.setContentAreaFilled(false);
        ButtonBanDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonBanDeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonBanDeleteMouseExited(evt);
            }
        });
        ButtonBanDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBanDeleteActionPerformed(evt);
            }
        });
        DeleteBan.add(ButtonBanDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 450, 100, 40));

        jScrollPane21.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        jScrollPane21.setForeground(new java.awt.Color(29, 41, 81));

        BannedListDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        BannedListDelete.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BannedListDelete.setForeground(new java.awt.Color(29, 41, 81));
        BannedListDelete.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        BannedListDelete.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jScrollPane21.setViewportView(BannedListDelete);

        DeleteBan.add(jScrollPane21, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 280, 250));

        ButtonPersonRefreshForDelete2.setBackground(new java.awt.Color(255, 255, 255));
        ButtonPersonRefreshForDelete2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonPersonRefreshForDelete2.setForeground(new java.awt.Color(29, 41, 81));
        ButtonPersonRefreshForDelete2.setText("Refresh");
        ButtonPersonRefreshForDelete2.setBorder(null);
        ButtonPersonRefreshForDelete2.setContentAreaFilled(false);
        ButtonPersonRefreshForDelete2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonPersonRefreshForDelete2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonPersonRefreshForDelete2MouseExited(evt);
            }
        });
        ButtonPersonRefreshForDelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPersonRefreshForDelete2ActionPerformed(evt);
            }
        });
        DeleteBan.add(ButtonPersonRefreshForDelete2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 100, 40));

        getContentPane().add(DeleteBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 760, 530));

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
        BoxCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxCountryActionPerformed(evt);
            }
        });
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
        jPanel2.add(ButtonEnterReportsZone, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 120, 30));

        BoxState.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BoxState.setForeground(new java.awt.Color(29, 41, 81));
        BoxState.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        jPanel2.add(BoxState, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 160, 30));

        BoxCity.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BoxCity.setForeground(new java.awt.Color(29, 41, 81));
        BoxCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        jPanel2.add(BoxCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 160, 30));

        BoxTypeOfZone.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BoxTypeOfZone.setForeground(new java.awt.Color(29, 41, 81));
        BoxTypeOfZone.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        BoxTypeOfZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxTypeOfZoneActionPerformed(evt);
            }
        });
        jPanel2.add(BoxTypeOfZone, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 160, 30));

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
        LabelNewUsername4.setText("Type of zone:");
        jPanel2.add(LabelNewUsername4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 100, 30));

        AdminStatistics.addTab("Total records by zone", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonEnterReportsZone2.setBackground(new java.awt.Color(255, 255, 255));
        ButtonEnterReportsZone2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ButtonEnterReportsZone2.setForeground(new java.awt.Color(29, 41, 81));
        ButtonEnterReportsZone2.setText("Enter");
        ButtonEnterReportsZone2.setBorder(null);
        ButtonEnterReportsZone2.setContentAreaFilled(false);
        ButtonEnterReportsZone2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonEnterReportsZone2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonEnterReportsZone2MouseExited(evt);
            }
        });
        ButtonEnterReportsZone2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEnterReportsZone2ActionPerformed(evt);
            }
        });
        jPanel3.add(ButtonEnterReportsZone2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 120, 30));

        AdminStatistics.addTab("Age range of users", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonEnterReportsZone4.setBackground(new java.awt.Color(255, 255, 255));
        ButtonEnterReportsZone4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ButtonEnterReportsZone4.setForeground(new java.awt.Color(29, 41, 81));
        ButtonEnterReportsZone4.setText("Enter");
        ButtonEnterReportsZone4.setBorder(null);
        ButtonEnterReportsZone4.setContentAreaFilled(false);
        ButtonEnterReportsZone4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonEnterReportsZone4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonEnterReportsZone4MouseExited(evt);
            }
        });
        ButtonEnterReportsZone4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEnterReportsZone4ActionPerformed(evt);
            }
        });
        jPanel4.add(ButtonEnterReportsZone4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 120, 30));

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

        BoxTypeOfZone1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BoxTypeOfZone1.setForeground(new java.awt.Color(29, 41, 81));
        BoxTypeOfZone1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        jPanel5.add(BoxTypeOfZone1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 160, 30));

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
        LabelNewUsername8.setText("Type of zone:");
        jPanel5.add(LabelNewUsername8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 100, 30));

        AdminStatistics.addTab("Total people with records by place of residence", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonEnterReportsZone3.setBackground(new java.awt.Color(255, 255, 255));
        ButtonEnterReportsZone3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ButtonEnterReportsZone3.setForeground(new java.awt.Color(29, 41, 81));
        ButtonEnterReportsZone3.setText("Enter");
        ButtonEnterReportsZone3.setBorder(null);
        ButtonEnterReportsZone3.setContentAreaFilled(false);
        ButtonEnterReportsZone3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonEnterReportsZone3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonEnterReportsZone3MouseExited(evt);
            }
        });
        ButtonEnterReportsZone3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEnterReportsZone3ActionPerformed(evt);
            }
        });
        jPanel6.add(ButtonEnterReportsZone3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 120, 30));

        AdminStatistics.addTab("Sentencing time for crime", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonEnterReportsZone5.setBackground(new java.awt.Color(255, 255, 255));
        ButtonEnterReportsZone5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ButtonEnterReportsZone5.setForeground(new java.awt.Color(29, 41, 81));
        ButtonEnterReportsZone5.setText("Enter");
        ButtonEnterReportsZone5.setBorder(null);
        ButtonEnterReportsZone5.setContentAreaFilled(false);
        ButtonEnterReportsZone5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonEnterReportsZone5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonEnterReportsZone5MouseExited(evt);
            }
        });
        ButtonEnterReportsZone5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEnterReportsZone5ActionPerformed(evt);
            }
        });
        jPanel7.add(ButtonEnterReportsZone5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 120, 30));

        AdminStatistics.addTab("Records with convictions expired or about to expire", jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonEnterReportsZone6.setBackground(new java.awt.Color(255, 255, 255));
        ButtonEnterReportsZone6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ButtonEnterReportsZone6.setForeground(new java.awt.Color(29, 41, 81));
        ButtonEnterReportsZone6.setText("Enter");
        ButtonEnterReportsZone6.setBorder(null);
        ButtonEnterReportsZone6.setContentAreaFilled(false);
        ButtonEnterReportsZone6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonEnterReportsZone6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonEnterReportsZone6MouseExited(evt);
            }
        });
        ButtonEnterReportsZone6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEnterReportsZone6ActionPerformed(evt);
            }
        });
        jPanel8.add(ButtonEnterReportsZone6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 120, 30));

        AdminStatistics.addTab("Number of years in jail by type of record", jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonEnterReportsZone7.setBackground(new java.awt.Color(255, 255, 255));
        ButtonEnterReportsZone7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ButtonEnterReportsZone7.setForeground(new java.awt.Color(29, 41, 81));
        ButtonEnterReportsZone7.setText("Enter");
        ButtonEnterReportsZone7.setBorder(null);
        ButtonEnterReportsZone7.setContentAreaFilled(false);
        ButtonEnterReportsZone7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonEnterReportsZone7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonEnterReportsZone7MouseExited(evt);
            }
        });
        ButtonEnterReportsZone7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEnterReportsZone7ActionPerformed(evt);
            }
        });
        jPanel9.add(ButtonEnterReportsZone7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 120, 30));

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

        CreatePerson.setBackground(new java.awt.Color(255, 255, 255));
        CreatePerson.setForeground(new java.awt.Color(255, 255, 255));
        CreatePerson.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CreatePersonMouseEntered(evt);
            }
        });
        CreatePerson.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelIdOffender.setBackground(new java.awt.Color(255, 255, 255));
        LabelIdOffender.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelIdOffender.setForeground(new java.awt.Color(29, 41, 81));
        LabelIdOffender.setText("Id:");
        CreatePerson.add(LabelIdOffender, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 100, 30));

        LabelNameOffender.setBackground(new java.awt.Color(255, 255, 255));
        LabelNameOffender.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelNameOffender.setForeground(new java.awt.Color(29, 41, 81));
        LabelNameOffender.setText("Name:");
        CreatePerson.add(LabelNameOffender, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 100, 30));

        LabelMiddleNameOffender.setBackground(new java.awt.Color(255, 255, 255));
        LabelMiddleNameOffender.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelMiddleNameOffender.setForeground(new java.awt.Color(29, 41, 81));
        LabelMiddleNameOffender.setText("Middle name:");
        CreatePerson.add(LabelMiddleNameOffender, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 120, 30));

        LabelLastNameOffender.setBackground(new java.awt.Color(255, 255, 255));
        LabelLastNameOffender.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelLastNameOffender.setForeground(new java.awt.Color(29, 41, 81));
        LabelLastNameOffender.setText("Last name:");
        CreatePerson.add(LabelLastNameOffender, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 90, 30));

        LabelCommunityOffender.setBackground(new java.awt.Color(255, 255, 255));
        LabelCommunityOffender.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelCommunityOffender.setForeground(new java.awt.Color(29, 41, 81));
        LabelCommunityOffender.setText("District:");
        CreatePerson.add(LabelCommunityOffender, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, 100, 30));

        LabelInstitutionOffender.setBackground(new java.awt.Color(255, 255, 255));
        LabelInstitutionOffender.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelInstitutionOffender.setForeground(new java.awt.Color(29, 41, 81));
        LabelInstitutionOffender.setText("Institution:");
        CreatePerson.add(LabelInstitutionOffender, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 90, 30));

        LabelOffenderGender.setBackground(new java.awt.Color(255, 255, 255));
        LabelOffenderGender.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelOffenderGender.setForeground(new java.awt.Color(29, 41, 81));
        LabelOffenderGender.setText("Gender:");
        CreatePerson.add(LabelOffenderGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 100, 30));

        LabelOffenderBirthday.setBackground(new java.awt.Color(255, 255, 255));
        LabelOffenderBirthday.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelOffenderBirthday.setForeground(new java.awt.Color(29, 41, 81));
        LabelOffenderBirthday.setText("Birthday:");
        CreatePerson.add(LabelOffenderBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, 100, 30));

        LineOffenderId.setForeground(new java.awt.Color(29, 41, 81));
        CreatePerson.add(LineOffenderId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 220, 20));

        IdPersonField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        IdPersonField.setForeground(new java.awt.Color(29, 41, 81));
        IdPersonField.setBorder(null);
        CreatePerson.add(IdPersonField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 220, 30));

        LineOffenderName.setForeground(new java.awt.Color(29, 41, 81));
        CreatePerson.add(LineOffenderName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 220, 20));

        NamePersonField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NamePersonField.setForeground(new java.awt.Color(29, 41, 81));
        NamePersonField.setBorder(null);
        CreatePerson.add(NamePersonField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 220, 30));

        LineOffenderMiddleName.setForeground(new java.awt.Color(29, 41, 81));
        CreatePerson.add(LineOffenderMiddleName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 220, 20));

        MiddleNamePersonField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        MiddleNamePersonField.setForeground(new java.awt.Color(29, 41, 81));
        MiddleNamePersonField.setBorder(null);
        CreatePerson.add(MiddleNamePersonField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 220, 30));

        LineOffenderLastName.setForeground(new java.awt.Color(29, 41, 81));
        CreatePerson.add(LineOffenderLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 220, 20));

        LastNamePersonField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LastNamePersonField.setForeground(new java.awt.Color(29, 41, 81));
        LastNamePersonField.setBorder(null);
        CreatePerson.add(LastNamePersonField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 220, 30));

        LineOffenderBirthday.setForeground(new java.awt.Color(29, 41, 81));
        CreatePerson.add(LineOffenderBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 130, 20));

        BirthdayPersonField.setBorder(null);
        BirthdayPersonField.setForeground(new java.awt.Color(29, 41, 81));
        BirthdayPersonField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        CreatePerson.add(BirthdayPersonField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 130, 30));

        BoxDistrictPerson.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        BoxDistrictPerson.setForeground(new java.awt.Color(29, 41, 81));
        BoxDistrictPerson.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        CreatePerson.add(BoxDistrictPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, 170, 30));

        BoxInstitutionPerson.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        BoxInstitutionPerson.setForeground(new java.awt.Color(29, 41, 81));
        BoxInstitutionPerson.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        CreatePerson.add(BoxInstitutionPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, 170, 30));

        BoxGenderPerson.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        BoxGenderPerson.setForeground(new java.awt.Color(29, 41, 81));
        BoxGenderPerson.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        CreatePerson.add(BoxGenderPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 120, 30));

        ButtonCancelPerson.setBackground(new java.awt.Color(255, 255, 255));
        ButtonCancelPerson.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonCancelPerson.setForeground(new java.awt.Color(29, 41, 81));
        ButtonCancelPerson.setText("Cancel");
        ButtonCancelPerson.setBorder(null);
        ButtonCancelPerson.setContentAreaFilled(false);
        ButtonCancelPerson.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonCancelPersonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonCancelPersonMouseExited(evt);
            }
        });
        ButtonCancelPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelPersonActionPerformed(evt);
            }
        });
        CreatePerson.add(ButtonCancelPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 460, 100, 40));

        ButtonConfirmPerson.setBackground(new java.awt.Color(255, 255, 255));
        ButtonConfirmPerson.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonConfirmPerson.setForeground(new java.awt.Color(29, 41, 81));
        ButtonConfirmPerson.setText("Confirm");
        ButtonConfirmPerson.setBorder(null);
        ButtonConfirmPerson.setContentAreaFilled(false);
        ButtonConfirmPerson.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonConfirmPersonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonConfirmPersonMouseExited(evt);
            }
        });
        ButtonConfirmPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonConfirmPersonActionPerformed(evt);
            }
        });
        CreatePerson.add(ButtonConfirmPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, 100, 40));

        IconOffender.setBackground(new java.awt.Color(255, 255, 255));
        IconOffender.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        IconOffender.setForeground(new java.awt.Color(29, 41, 81));
        IconOffender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/AddUser.png"))); // NOI18N
        IconOffender.setText("Person Information");
        IconOffender.setMaximumSize(new java.awt.Dimension(240, 128));
        IconOffender.setMinimumSize(new java.awt.Dimension(240, 128));
        CreatePerson.add(IconOffender, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 380, 130));

        getContentPane().add(CreatePerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 760, 530));

        CreateRecord.setBackground(new java.awt.Color(255, 255, 255));
        CreateRecord.setForeground(new java.awt.Color(255, 255, 255));
        CreateRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CreateRecordMouseEntered(evt);
            }
        });
        CreateRecord.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        CreateRecord.add(ButtonRollbackCreateRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        LabelRecordNumber.setBackground(new java.awt.Color(255, 255, 255));
        LabelRecordNumber.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelRecordNumber.setForeground(new java.awt.Color(29, 41, 81));
        LabelRecordNumber.setText("Record number:");
        CreateRecord.add(LabelRecordNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 140, 30));

        LabelCrimeDescription.setBackground(new java.awt.Color(255, 255, 255));
        LabelCrimeDescription.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelCrimeDescription.setForeground(new java.awt.Color(29, 41, 81));
        LabelCrimeDescription.setText("Crime Description:");
        CreateRecord.add(LabelCrimeDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 160, 30));

        LabelOffender.setBackground(new java.awt.Color(255, 255, 255));
        LabelOffender.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelOffender.setForeground(new java.awt.Color(29, 41, 81));
        LabelOffender.setText("Offender:");
        CreateRecord.add(LabelOffender, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 90, 30));

        LabelDateCrime.setBackground(new java.awt.Color(255, 255, 255));
        LabelDateCrime.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelDateCrime.setForeground(new java.awt.Color(29, 41, 81));
        LabelDateCrime.setText("Date crime:");
        CreateRecord.add(LabelDateCrime, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 100, 30));

        LineNumberRecord.setForeground(new java.awt.Color(29, 41, 81));
        CreateRecord.add(LineNumberRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 220, 20));

        RecordNumberField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        RecordNumberField.setForeground(new java.awt.Color(29, 41, 81));
        RecordNumberField.setBorder(null);
        CreateRecord.add(RecordNumberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 220, 30));

        LineDateCrime.setForeground(new java.awt.Color(29, 41, 81));
        CreateRecord.add(LineDateCrime, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 110, 20));

        DateCrimeCreateRecord.setBorder(null);
        DateCrimeCreateRecord.setForeground(new java.awt.Color(29, 41, 81));
        DateCrimeCreateRecord.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        CreateRecord.add(DateCrimeCreateRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 110, 30));

        BoxOffender.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BoxOffender.setForeground(new java.awt.Color(29, 41, 81));
        BoxOffender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        CreateRecord.add(BoxOffender, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 160, 30));

        IconCreateReacord.setBackground(new java.awt.Color(255, 255, 255));
        IconCreateReacord.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        IconCreateReacord.setForeground(new java.awt.Color(29, 41, 81));
        IconCreateReacord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/AddFile.png"))); // NOI18N
        IconCreateReacord.setText("Create Record");
        IconCreateReacord.setMaximumSize(new java.awt.Dimension(240, 128));
        IconCreateReacord.setMinimumSize(new java.awt.Dimension(240, 128));
        CreateRecord.add(IconCreateReacord, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 300, 90));

        CrimeDescriptionCreateRecord.setColumns(20);
        CrimeDescriptionCreateRecord.setRows(5);
        jScrollPane6.setViewportView(CrimeDescriptionCreateRecord);

        CreateRecord.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 220, 40));

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
        CreateRecord.add(PictureNewRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 110, 120));

        RightRecordUser.setBackground(new java.awt.Color(255, 255, 255));
        RightRecordUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/RightPic.png"))); // NOI18N
        RightRecordUser.setBorder(null);
        RightRecordUser.setContentAreaFilled(false);
        RightRecordUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RightRecordUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RightRecordUserMouseExited(evt);
            }
        });
        RightRecordUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RightRecordUserActionPerformed(evt);
            }
        });
        CreateRecord.add(RightRecordUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, 40, 40));

        LeftRecordUser.setBackground(new java.awt.Color(255, 255, 255));
        LeftRecordUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/LeftPic.png"))); // NOI18N
        LeftRecordUser.setBorder(null);
        LeftRecordUser.setContentAreaFilled(false);
        LeftRecordUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LeftRecordUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LeftRecordUserMouseExited(evt);
            }
        });
        LeftRecordUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeftRecordUserActionPerformed(evt);
            }
        });
        CreateRecord.add(LeftRecordUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 40, 40));

        ButtonCreateOffender.setBackground(new java.awt.Color(255, 255, 255));
        ButtonCreateOffender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/AddPic.png"))); // NOI18N
        ButtonCreateOffender.setBorder(null);
        ButtonCreateOffender.setContentAreaFilled(false);
        ButtonCreateOffender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonCreateOffenderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonCreateOffenderMouseExited(evt);
            }
        });
        ButtonCreateOffender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCreateOffenderActionPerformed(evt);
            }
        });
        CreateRecord.add(ButtonCreateOffender, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 363, 40, 40));

        RemoveRecordUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/RemovePic.png"))); // NOI18N
        RemoveRecordUser.setContentAreaFilled(false);
        RemoveRecordUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RemoveRecordUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RemoveRecordUserMouseExited(evt);
            }
        });
        RemoveRecordUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveRecordUserActionPerformed(evt);
            }
        });
        CreateRecord.add(RemoveRecordUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 40, 40));

        LabelResolutionUnapproved2.setBackground(new java.awt.Color(255, 255, 255));
        LabelResolutionUnapproved2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelResolutionUnapproved2.setForeground(new java.awt.Color(29, 41, 81));
        LabelResolutionUnapproved2.setText("Resolution:");
        CreateRecord.add(LabelResolutionUnapproved2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 90, 30));

        LabelVeredictUnapproved2.setBackground(new java.awt.Color(255, 255, 255));
        LabelVeredictUnapproved2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelVeredictUnapproved2.setForeground(new java.awt.Color(29, 41, 81));
        LabelVeredictUnapproved2.setText("Veredict:");
        CreateRecord.add(LabelVeredictUnapproved2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 100, 30));

        ButtonCancelRecordUser.setBackground(new java.awt.Color(255, 255, 255));
        ButtonCancelRecordUser.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonCancelRecordUser.setForeground(new java.awt.Color(29, 41, 81));
        ButtonCancelRecordUser.setText("Cancel");
        ButtonCancelRecordUser.setBorder(null);
        ButtonCancelRecordUser.setContentAreaFilled(false);
        ButtonCancelRecordUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonCancelRecordUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonCancelRecordUserMouseExited(evt);
            }
        });
        ButtonCancelRecordUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelRecordUserActionPerformed(evt);
            }
        });
        CreateRecord.add(ButtonCancelRecordUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, 100, 40));

        CheckBoxApprovedOrNotCreateRecord.setBackground(new java.awt.Color(255, 255, 255));
        CheckBoxApprovedOrNotCreateRecord.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        CheckBoxApprovedOrNotCreateRecord.setForeground(new java.awt.Color(29, 41, 81));
        CheckBoxApprovedOrNotCreateRecord.setText("Approved");
        CreateRecord.add(CheckBoxApprovedOrNotCreateRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, 110, -1));

        ExpireDateCreateRecord.setBorder(null);
        ExpireDateCreateRecord.setForeground(new java.awt.Color(29, 41, 81));
        ExpireDateCreateRecord.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        ExpireDateCreateRecord.setCaretColor(new java.awt.Color(204, 204, 204));
        CreateRecord.add(ExpireDateCreateRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 420, 70, 30));

        LineExpireDate3.setForeground(new java.awt.Color(29, 41, 81));
        CreateRecord.add(LineExpireDate3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 450, 70, 20));

        LabelExpireDateUnapproved3.setBackground(new java.awt.Color(255, 255, 255));
        LabelExpireDateUnapproved3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelExpireDateUnapproved3.setForeground(new java.awt.Color(29, 41, 81));
        LabelExpireDateUnapproved3.setText("Expire date:");
        CreateRecord.add(LabelExpireDateUnapproved3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 420, 100, 30));

        YearsSentenceCreateRecord.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        YearsSentenceCreateRecord.setForeground(new java.awt.Color(29, 41, 81));
        YearsSentenceCreateRecord.setBorder(null);
        CreateRecord.add(YearsSentenceCreateRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 240, 80, 30));

        LineResolution5.setForeground(new java.awt.Color(29, 41, 81));
        CreateRecord.add(LineResolution5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 270, 80, 20));

        BoxResolutionCreateRecord.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BoxResolutionCreateRecord.setForeground(new java.awt.Color(29, 41, 81));
        BoxResolutionCreateRecord.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Guilty", "Innocent" }));
        BoxResolutionCreateRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxResolutionCreateRecordActionPerformed(evt);
            }
        });
        CreateRecord.add(BoxResolutionCreateRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, 140, 30));

        LabelVeredictUnapproved3.setBackground(new java.awt.Color(255, 255, 255));
        LabelVeredictUnapproved3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelVeredictUnapproved3.setForeground(new java.awt.Color(29, 41, 81));
        LabelVeredictUnapproved3.setText("Years of sentence:");
        CreateRecord.add(LabelVeredictUnapproved3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 160, 30));

        LineDateCrime6.setForeground(new java.awt.Color(29, 41, 81));
        CreateRecord.add(LineDateCrime6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 310, 110, 20));

        StartDateSentenceCreateRecord.setBorder(null);
        StartDateSentenceCreateRecord.setForeground(new java.awt.Color(29, 41, 81));
        StartDateSentenceCreateRecord.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        CreateRecord.add(StartDateSentenceCreateRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 280, 110, 30));

        LabelExpireDateUnapproved4.setBackground(new java.awt.Color(255, 255, 255));
        LabelExpireDateUnapproved4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelExpireDateUnapproved4.setForeground(new java.awt.Color(29, 41, 81));
        LabelExpireDateUnapproved4.setText("Start date:");
        CreateRecord.add(LabelExpireDateUnapproved4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, 100, 30));

        LabelExpireDateUnapproved5.setBackground(new java.awt.Color(255, 255, 255));
        LabelExpireDateUnapproved5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelExpireDateUnapproved5.setForeground(new java.awt.Color(29, 41, 81));
        LabelExpireDateUnapproved5.setText("Finish date:");
        CreateRecord.add(LabelExpireDateUnapproved5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, 100, 30));

        LineDateCrime7.setForeground(new java.awt.Color(29, 41, 81));
        LineDateCrime7.setOpaque(true);
        CreateRecord.add(LineDateCrime7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 360, 110, 20));

        FinishDateSentenceCreateRecord.setBorder(null);
        FinishDateSentenceCreateRecord.setForeground(new java.awt.Color(29, 41, 81));
        FinishDateSentenceCreateRecord.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        CreateRecord.add(FinishDateSentenceCreateRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 110, 30));

        LabelResolutionUnapproved3.setBackground(new java.awt.Color(255, 255, 255));
        LabelResolutionUnapproved3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelResolutionUnapproved3.setForeground(new java.awt.Color(29, 41, 81));
        LabelResolutionUnapproved3.setText("Type of sentence:");
        CreateRecord.add(LabelResolutionUnapproved3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 160, 30));

        BoxTypeSentenceCreateRecord.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BoxTypeSentenceCreateRecord.setForeground(new java.awt.Color(29, 41, 81));
        BoxTypeSentenceCreateRecord.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        CreateRecord.add(BoxTypeSentenceCreateRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 380, 120, 30));

        LabelCrimeTypeUnapproved1.setBackground(new java.awt.Color(255, 255, 255));
        LabelCrimeTypeUnapproved1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        LabelCrimeTypeUnapproved1.setForeground(new java.awt.Color(29, 41, 81));
        LabelCrimeTypeUnapproved1.setText("Type of crime:");
        CreateRecord.add(LabelCrimeTypeUnapproved1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 120, 30));

        ButtonConfirmRecordUser.setBackground(new java.awt.Color(255, 255, 255));
        ButtonConfirmRecordUser.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ButtonConfirmRecordUser.setForeground(new java.awt.Color(29, 41, 81));
        ButtonConfirmRecordUser.setText("Confirm");
        ButtonConfirmRecordUser.setBorder(null);
        ButtonConfirmRecordUser.setContentAreaFilled(false);
        ButtonConfirmRecordUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonConfirmRecordUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonConfirmRecordUserMouseExited(evt);
            }
        });
        ButtonConfirmRecordUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonConfirmRecordUserActionPerformed(evt);
            }
        });
        CreateRecord.add(ButtonConfirmRecordUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 470, 100, 40));

        BoxTypeCrimeCreateRecord.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BoxTypeCrimeCreateRecord.setForeground(new java.awt.Color(29, 41, 81));
        BoxTypeCrimeCreateRecord.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        CreateRecord.add(BoxTypeCrimeCreateRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 150, 30));

        AddRecordUser.setBackground(new java.awt.Color(255, 255, 255));
        AddRecordUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication16/Image/AddPic.png"))); // NOI18N
        AddRecordUser.setBorder(null);
        AddRecordUser.setContentAreaFilled(false);
        AddRecordUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddRecordUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddRecordUserMouseExited(evt);
            }
        });
        AddRecordUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRecordUserActionPerformed(evt);
            }
        });
        CreateRecord.add(AddRecordUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, 40, 40));

        getContentPane().add(CreateRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 760, 530));

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
        Records.add(BoxFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 140, 30));

        BoxFilterSpecify.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BoxFilterSpecify.setForeground(new java.awt.Color(29, 41, 81));
        BoxFilterSpecify.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        Records.add(BoxFilterSpecify, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 140, 30));

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
        Records.add(ButtonShowRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 100, 30));

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

        Records.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 350, 130));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        jScrollPane3.setForeground(new java.awt.Color(29, 41, 81));

        RecordDescriptionText.setColumns(20);
        RecordDescriptionText.setRows(5);
        jScrollPane3.setViewportView(RecordDescriptionText);

        Records.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 350, 170));

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
        ButtonShowCatalogues.setBorder(null);
        ButtonShowCatalogues.setContentAreaFilled(false);
        ButtonShowCatalogues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonShowCataloguesActionPerformed(evt);
            }
        });
        Records.add(ButtonShowCatalogues, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, 100, 30));

        DateStartField.setBorder(null);
        DateStartField.setForeground(new java.awt.Color(29, 41, 81));
        DateStartField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        Records.add(DateStartField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 110, 30));

        LineDateCrime1.setForeground(new java.awt.Color(29, 41, 81));
        Records.add(LineDateCrime1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 110, 20));

        DateEndField.setBorder(null);
        DateEndField.setForeground(new java.awt.Color(29, 41, 81));
        DateEndField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        Records.add(DateEndField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 110, 30));

        LineDateCrime3.setForeground(new java.awt.Color(29, 41, 81));
        Records.add(LineDateCrime3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 110, 20));

        LabelChooseFilterRecords1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LabelChooseFilterRecords1.setForeground(new java.awt.Color(29, 41, 81));
        LabelChooseFilterRecords1.setText("Place of the crime:");
        Records.add(LabelChooseFilterRecords1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, 30));

        LabelChooseFilterRecords2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LabelChooseFilterRecords2.setForeground(new java.awt.Color(29, 41, 81));
        LabelChooseFilterRecords2.setText("Start Date:");
        Records.add(LabelChooseFilterRecords2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, 30));

        LabelChooseFilterRecords3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LabelChooseFilterRecords3.setForeground(new java.awt.Color(29, 41, 81));
        LabelChooseFilterRecords3.setText("Reports list:");
        Records.add(LabelChooseFilterRecords3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, 30));

        LabelChooseFilterRecords4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LabelChooseFilterRecords4.setForeground(new java.awt.Color(29, 41, 81));
        LabelChooseFilterRecords4.setText("Description of the selected report:");
        Records.add(LabelChooseFilterRecords4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, -1, 30));

        LabelChooseFilterRecords7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LabelChooseFilterRecords7.setForeground(new java.awt.Color(29, 41, 81));
        LabelChooseFilterRecords7.setText("Choose the filter:");
        Records.add(LabelChooseFilterRecords7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, 30));

        LabelChooseFilterRecords8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LabelChooseFilterRecords8.setForeground(new java.awt.Color(29, 41, 81));
        LabelChooseFilterRecords8.setText("Type of report:");
        Records.add(LabelChooseFilterRecords8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, 30));

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
        ButtonShowUsers.setBorder(null);
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
        ButtonShowBanned.setBorder(null);
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(29, 41, 81));
        jLabel1.setText("Date Range");
        RecordsConvictionsToExpireOrExpired.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 100, 30));

        jScrollPane7.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        jScrollPane7.setForeground(new java.awt.Color(29, 41, 81));

        RecordDescriptionTextExpire.setColumns(20);
        RecordDescriptionTextExpire.setRows(5);
        jScrollPane7.setViewportView(RecordDescriptionTextExpire);

        RecordsConvictionsToExpireOrExpired.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 370, 220));

        jScrollPane8.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        jScrollPane8.setForeground(new java.awt.Color(29, 41, 81));
        jScrollPane8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        RecordsExpireList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        RecordsExpireList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RecordsExpireList.setForeground(new java.awt.Color(29, 41, 81));
        RecordsExpireList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RecordsExpireListMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(RecordsExpireList);

        RecordsConvictionsToExpireOrExpired.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 280, 220));

        ButtonShowRecordsDate.setBackground(new java.awt.Color(255, 255, 255));
        ButtonShowRecordsDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ButtonShowRecordsDate.setForeground(new java.awt.Color(29, 41, 81));
        ButtonShowRecordsDate.setText("Enter");
        ButtonShowRecordsDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 41, 81)));
        ButtonShowRecordsDate.setContentAreaFilled(false);
        ButtonShowRecordsDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonShowRecordsDateActionPerformed(evt);
            }
        });
        RecordsConvictionsToExpireOrExpired.add(ButtonShowRecordsDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 100, 30));

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

        LabelChooseFilterRecords5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LabelChooseFilterRecords5.setForeground(new java.awt.Color(29, 41, 81));
        LabelChooseFilterRecords5.setText("End Date:");
        RecordsConvictionsToExpireOrExpired.add(LabelChooseFilterRecords5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, 30));

        DateStartField1.setBorder(null);
        DateStartField1.setForeground(new java.awt.Color(29, 41, 81));
        DateStartField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        RecordsConvictionsToExpireOrExpired.add(DateStartField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 110, 30));

        LineDateCrime11.setForeground(new java.awt.Color(29, 41, 81));
        RecordsConvictionsToExpireOrExpired.add(LineDateCrime11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 110, 20));

        DateEndField1.setBorder(null);
        DateEndField1.setForeground(new java.awt.Color(29, 41, 81));
        DateEndField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        RecordsConvictionsToExpireOrExpired.add(DateEndField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 110, 30));

        LineDateCrime12.setForeground(new java.awt.Color(29, 41, 81));
        RecordsConvictionsToExpireOrExpired.add(LineDateCrime12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 110, 20));

        LabelChooseFilterRecords6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LabelChooseFilterRecords6.setForeground(new java.awt.Color(29, 41, 81));
        LabelChooseFilterRecords6.setText("Start Date:");
        RecordsConvictionsToExpireOrExpired.add(LabelChooseFilterRecords6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, 30));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(29, 41, 81));
        jLabel2.setText("Description of the selected report");
        RecordsConvictionsToExpireOrExpired.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(29, 41, 81));
        jLabel3.setText("Report List");
        RecordsConvictionsToExpireOrExpired.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, -1));

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
        blockAll();
        UserQuery.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonQueryActionPerformed

    private void ButtonConfigurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonConfigurationActionPerformed
        Animacion.Animacion.mover_derecha(290, 1100, 1, 1, JPUserMenu);
        blockAll();
        UserConfiguration.setVisible(true);
        JPLogged.setVisible(true);
        UpdateUsernameField.setText(Username.getText());
        //Agregar la información personal del usuario en UpdatePersonalInfo
    }//GEN-LAST:event_ButtonConfigurationActionPerformed

    private void ButtonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLogOutActionPerformed
        blockAll();
        JPWelcome.setVisible(true);
        JPLogin.setVisible(true);
        UsernameField.setText(null);
        PasswordField.setText(null);
    }//GEN-LAST:event_ButtonLogOutActionPerformed

    private void ButtonStatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonStatisticsActionPerformed
        Animacion.Animacion.mover_derecha(290, 1100, 1, 1, JPAdminMenu);
        blockAll();
        AdminStatistics.setVisible(true);
        JPLogged.setVisible(true);
        try {
        fillInComboBoxStatistics1();
        fillInComboBoxStatistics2(); 
        }
        catch (Exception e) {}
    }//GEN-LAST:event_ButtonStatisticsActionPerformed

    private void ButtonLogOutAdminUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLogOutAdminUserActionPerformed
        blockAll();
        JPWelcome.setVisible(true);
        JPLogin.setVisible(true);
    }//GEN-LAST:event_ButtonLogOutAdminUserActionPerformed

    private void ButtonAdminQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAdminQueryActionPerformed
        Animacion.Animacion.mover_derecha(290, 1100, 1, 1, JPAdminMenu);
        blockAll();
        AdminQuery.setVisible(true);
        //Rellenar la info;
    }//GEN-LAST:event_ButtonAdminQueryActionPerformed

    private void ButtonAdminConfigurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAdminConfigurationActionPerformed
        Animacion.Animacion.mover_derecha(290, 1100, 1, 1, JPAdminMenu);
        blockAll();
        UserConfiguration.setVisible(true);
        AdminConfiguration.setVisible(true);
        JPLogged.setVisible(true);
        UpdateUsernameField.setText(Username.getText());
        //Agregar la información personal del usuario en UpdateAdminPersonalInfo
        //Rellenar las comboBox de AdminCatalogues
        //Rellenar la lista con la funcion de expedientes en ApproveReports
    }//GEN-LAST:event_ButtonAdminConfigurationActionPerformed

    private void ButtonSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSignUpActionPerformed
        firstRunning = false;
        Animacion.Animacion.mover_derecha(290, 1100, 1, 1, JPWelcome);
        Animacion.Animacion.mover_izquierda(0, -1100, 1, 1, JPLogin);
        blockAll();
        JPSignUp.setVisible(true);
        JPLogged.setVisible(false);
        try {
            fillInComboBox_signIn();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonSignUpActionPerformed

    private void ButtonEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEnterActionPerformed
        firstRunning = false;
        String user_field = UsernameField.getText();
        String user_password = new String(PasswordField.getPassword());
        if(user_field.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fill the user field.");
        } else if(user_password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fill the password field.");
        } else try {
            int type = ConnectDB.checkLogin(user_field, user_password);
            if (type == 1)
            {
                currentUser uc = currentUser.getInstance();
                uc.setUsername(user_field);
                uc.setId_userType(type);
                Username.setText(user_field);
                Animacion.Animacion.mover_derecha(290, 1100, 1, 1, JPWelcome);
                Animacion.Animacion.mover_izquierda(0, -1100, 1, 1, JPLogin);
                blockAll();
                JPLogged.setVisible(true);
                JPAdminMenu.setVisible(true);
            }
            else if(type > 1){
                Username.setText(user_field);
                Animacion.Animacion.mover_derecha(290, 1100, 1, 1, JPWelcome);
                Animacion.Animacion.mover_izquierda(0, -1100, 1, 1, JPLogin);
                blockAll();
                JPLogged.setVisible(true);
                JPUserMenu.setVisible(true);
            } else if (type == 0){
                JOptionPane.showMessageDialog(this, "User or password incorrect","Error", JOptionPane.ERROR_MESSAGE);
             } else if (type == -1){
                JOptionPane.showMessageDialog(this, "User is currently banned","Error", JOptionPane.ERROR_MESSAGE);
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
        blockAll();
        JPWelcome.setVisible(true);
        JPLogin.setVisible(true);
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
        blockAll();
        JPWelcome.setVisible(true);
        JPLogin.setVisible(true);
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
                user.setId_userType(2);
                ConnectDB.insert_person(person);
                ConnectDB.insertUser(user);
                JOptionPane.showMessageDialog(this, "The user was created successfully.");
            blockAll();
            JPWelcome.setVisible(true);
            NewUsernameField.setText(null);
            NewUserPasswordField.setText(null);
            JPLogin.setVisible(true);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, "The user was NOT created successfully. Try again.");
            }
        }
    }//GEN-LAST:event_ButtonJoinActionPerformed

    private void JPSignUpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPSignUpMouseEntered
        blockAll();
        JPSignUp.setVisible(true);
    }//GEN-LAST:event_JPSignUpMouseEntered

    private void JPAdminMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPAdminMenuMouseEntered
        blockAll();
        JPLogged.setVisible(true);
        JPAdminMenu.setVisible(true);
    }//GEN-LAST:event_JPAdminMenuMouseEntered

    private void JPUserMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPUserMenuMouseEntered
        blockAll();
        JPLogged.setVisible(true);
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
        blockAll();
        JPLogged.setVisible(true);
        UserQuery.setVisible(true);
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
        indexPictures = 0;
        ArrayList<String> paths = null;
        //Obtener las pictures del expediente seleccionado y guardar en la global paths;
        loadPictures(PictureShowRecords, LeftPicShowRecords, RightPicShowRecords);
    }//GEN-LAST:event_RecordsListMouseClicked

    private void ButtonCreateRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCreateRecordMouseEntered
        ButtonCreateRecord.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonCreateRecordMouseEntered

    private void ButtonCreateRecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCreateRecordMouseExited
        ButtonCreateRecord.setBorder(null);
    }//GEN-LAST:event_ButtonCreateRecordMouseExited

    private void ButtonCreateRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCreateRecordActionPerformed
        Animacion.Animacion.mover_derecha(290, 1100, 1, 1, JPUserMenu);
        blockAll();
        CreateRecord.setVisible(true);
        JPLogged.setVisible(true);
        CheckBoxApprovedOrNotCreateRecord.setEnabled(false);
        try {
            fillInComboBox_Offender();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonCreateRecordActionPerformed

    private void CreatePersonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreatePersonMouseEntered
        blockAll();
        CreatePerson.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_CreatePersonMouseEntered

    private void ButtonCancelPersonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelPersonMouseEntered
        ButtonCancelPerson.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonCancelPersonMouseEntered

    private void ButtonCancelPersonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelPersonMouseExited
        ButtonCancelPerson.setBorder(null);
    }//GEN-LAST:event_ButtonCancelPersonMouseExited

    private void ButtonCancelPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelPersonActionPerformed
        blockAll();
        CreateRecord.setVisible(true);
        IdPersonField.setText(null);
        NamePersonField.setText(null);
        MiddleNamePersonField.setText(null);
        LastNamePersonField.setText(null);
        BirthdayPersonField.setText(null);
        BoxGenderPerson.setSelectedIndex(0);
        BoxDistrictPerson.setSelectedIndex(0);
        BoxInstitutionPerson.setSelectedIndex(0);
    }//GEN-LAST:event_ButtonCancelPersonActionPerformed

    private void ButtonConfirmPersonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonConfirmPersonMouseEntered
        ButtonConfirmPerson.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonConfirmPersonMouseEntered

    private void ButtonConfirmPersonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonConfirmPersonMouseExited
        ButtonConfirmPerson.setBorder(null);
    }//GEN-LAST:event_ButtonConfirmPersonMouseExited

    private void ButtonConfirmPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonConfirmPersonActionPerformed
        String offender_id = IdPersonField.getText();
        String offender_name = NamePersonField.getText();
        String offender_middle_name = MiddleNamePersonField.getText();
        String offender_last_name = LastNamePersonField.getText();
        String offender_birthday = BirthdayPersonField.getText();
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
        } else if(BoxGenderPerson.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Choose a valid option.");
        } else if(BoxDistrictPerson.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Choose a valid option.");
        } else if(BoxInstitutionPerson.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Choose a valid option.");
        } else {
             try{
                Person person = new Person(Integer.parseInt(offender_id), offender_name, offender_middle_name, offender_last_name, new SimpleDateFormat("dd/MM/yyyy").parse(offender_birthday), BoxGenderNewUser.getSelectedIndex(), BoxInstitutionNewUser.getSelectedIndex(), BoxNewUserDistrict.getSelectedIndex());
                ConnectDB.insert_person(person);
                JOptionPane.showMessageDialog(this, "The person was created successfully in the system.");
                Animacion.Animacion.mover_derecha(290, 1100, 1, 1, CreatePerson);
                blockAll();
                CreateRecord.setVisible(true);
                JPLogged.setVisible(true);
            }
            catch(Exception e){}
            
        }
    }//GEN-LAST:event_ButtonConfirmPersonActionPerformed

    private void ButtonRollbackQueryPlacesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackQueryPlacesMouseEntered
        ButtonRollbackQueryPlaces.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonRollbackQueryPlacesMouseEntered

    private void ButtonRollbackQueryPlacesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackQueryPlacesMouseExited
        ButtonRollbackQueryPlaces.setBorder(null);
    }//GEN-LAST:event_ButtonRollbackQueryPlacesMouseExited

    private void ButtonRollbackQueryPlacesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRollbackQueryPlacesActionPerformed
        blockAll();
        JPUserMenu.setVisible(true);
        JPLogged.setVisible(true);
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
        blockAll();
        JPUserMenu.setVisible(true);
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
        blockAll();
        JPUserMenu.setVisible(true);
        JPLogged.setVisible(true);
        UserConfiguration.setVisible(false);
    }//GEN-LAST:event_ButtonRollbackQueryUsersActionPerformed

    private void ButtonRollbackQueryBannedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackQueryBannedMouseEntered
        ButtonRollbackQueryBanned.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonRollbackQueryBannedMouseEntered

    private void ButtonRollbackQueryBannedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackQueryBannedMouseExited
        ButtonRollbackQueryBanned.setBorder(null);
    }//GEN-LAST:event_ButtonRollbackQueryBannedMouseExited

    private void ButtonRollbackQueryBannedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRollbackQueryBannedActionPerformed
        blockAll();
        JPUserMenu.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonRollbackQueryBannedActionPerformed

    private void ButtonRollbackQueryExpireMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackQueryExpireMouseEntered
        ButtonRollbackQueryExpire.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonRollbackQueryExpireMouseEntered

    private void ButtonRollbackQueryExpireMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackQueryExpireMouseExited
        ButtonRollbackQueryExpire.setBorder(null);
    }//GEN-LAST:event_ButtonRollbackQueryExpireMouseExited

    private void ButtonRollbackQueryExpireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRollbackQueryExpireActionPerformed
        blockAll();
        JPUserMenu.setVisible(true);
        JPLogged.setVisible(true);
        RecordsExpireList.removeAll();
        RecordDescriptionTextExpire.setText(null);
    }//GEN-LAST:event_ButtonRollbackQueryExpireActionPerformed

    private void PlacesMoreRecordsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlacesMoreRecordsMouseEntered
        blockAll();
        JPLogged.setVisible(true);
        UserQuery.setVisible(true);
        PlacesMoreRecords.setVisible(true);
        RecordsConvictionsToExpireOrExpired.setVisible(false);
    }//GEN-LAST:event_PlacesMoreRecordsMouseEntered

    private void RecordsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RecordsMouseEntered
        blockAll();
        JPLogged.setVisible(true);
        UserQuery.setVisible(true);
        Records.setVisible(true);
        RecordsConvictionsToExpireOrExpired.setVisible(false);
    }//GEN-LAST:event_RecordsMouseEntered

    private void UsersListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UsersListMouseEntered
        blockAll();
        JPLogged.setVisible(true);
        UserQuery.setVisible(true);
        UsersList.setVisible(true);
        RecordsConvictionsToExpireOrExpired.setVisible(false);
    }//GEN-LAST:event_UsersListMouseEntered

    private void BannedUsersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BannedUsersMouseEntered
        blockAll();
        JPLogged.setVisible(true);
        UserQuery.setVisible(true);
        BannedUsers.setVisible(true);
        RecordsConvictionsToExpireOrExpired.setVisible(false);
    }//GEN-LAST:event_BannedUsersMouseEntered

    private void RecordsConvictionsToExpireOrExpiredMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RecordsConvictionsToExpireOrExpiredMouseEntered
        blockAll();
        JPLogged.setVisible(true);
        UserQuery.setVisible(true);
        RecordsConvictionsToExpireOrExpired.setVisible(true);
    }//GEN-LAST:event_RecordsConvictionsToExpireOrExpiredMouseEntered

    private void PictureShowRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PictureShowRecordsActionPerformed
        /*if(!paths.isEmpty()) {
            Pictures v = new Pictures(null, true, paths.get(indexPictures).toString());
            v.setVisible(true);
        }
        //Aquí necesito una clase picture :(;*/
    }//GEN-LAST:event_PictureShowRecordsActionPerformed

    private void RightPicShowRecordsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RightPicShowRecordsMouseEntered
        RightPicShowRecords.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_RightPicShowRecordsMouseEntered

    private void RightPicShowRecordsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RightPicShowRecordsMouseExited
        RightPicShowRecords.setBorder(null);
    }//GEN-LAST:event_RightPicShowRecordsMouseExited

    private void RightPicShowRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RightPicShowRecordsActionPerformed
        int size = paths.size();
        if(indexPictures < size) {
            indexPictures++;
        }
        loadPictures(PictureShowRecords, LeftPicShowRecords, RightPicShowRecords);
    }//GEN-LAST:event_RightPicShowRecordsActionPerformed

    private void LeftPicShowRecordsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeftPicShowRecordsMouseEntered
        LeftPicShowRecords.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_LeftPicShowRecordsMouseEntered

    private void LeftPicShowRecordsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeftPicShowRecordsMouseExited
        LeftPicShowRecords.setBorder(null);
    }//GEN-LAST:event_LeftPicShowRecordsMouseExited

    private void LeftPicShowRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeftPicShowRecordsActionPerformed
        if(indexPictures > -1) {
            indexPictures--;
        }
        loadPictures(PictureShowRecords, LeftPicShowRecords, RightPicShowRecords);
    }//GEN-LAST:event_LeftPicShowRecordsActionPerformed

    private void PictureRecordToExpireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PictureRecordToExpireActionPerformed
        /*if(!paths.isEmpty()) {
            Picture v = new Picture(null, true, paths.get(indexPictures).toString());
            v.setVisible(true);
        }
        /Necesito una clase Picture;*/
    }//GEN-LAST:event_PictureRecordToExpireActionPerformed

    private void RightPicRecordToExpireMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RightPicRecordToExpireMouseEntered
        RightPicRecordToExpire.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_RightPicRecordToExpireMouseEntered

    private void RightPicRecordToExpireMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RightPicRecordToExpireMouseExited
        RightPicRecordToExpire.setBorder(null);
    }//GEN-LAST:event_RightPicRecordToExpireMouseExited

    private void RightPicRecordToExpireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RightPicRecordToExpireActionPerformed
        int size = paths.size();
        if(indexPictures < size) {
            indexPictures++;
        }
        loadPictures(PictureRecordToExpire, LeftPicRecordToExpire, RightPicRecordToExpire);
    }//GEN-LAST:event_RightPicRecordToExpireActionPerformed

    private void LeftPicRecordToExpireMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeftPicRecordToExpireMouseEntered
        LeftPicRecordToExpire.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_LeftPicRecordToExpireMouseEntered

    private void LeftPicRecordToExpireMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeftPicRecordToExpireMouseExited
        LeftPicRecordToExpire.setBorder(null);
    }//GEN-LAST:event_LeftPicRecordToExpireMouseExited

    private void LeftPicRecordToExpireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeftPicRecordToExpireActionPerformed
        if(indexPictures > -1) {
            indexPictures--;
        }
        loadPictures(PictureRecordToExpire, LeftPicRecordToExpire, RightPicRecordToExpire);
    }//GEN-LAST:event_LeftPicRecordToExpireActionPerformed

    private void ButtonCancelUpdatesUserLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelUpdatesUserLoginMouseEntered
        ButtonCancelUpdatesUserLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonCancelUpdatesUserLoginMouseEntered

    private void ButtonCancelUpdatesUserLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelUpdatesUserLoginMouseExited
        ButtonCancelUpdatesUserLogin.setBorder(null);
    }//GEN-LAST:event_ButtonCancelUpdatesUserLoginMouseExited

    private void ButtonCancelUpdatesUserLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelUpdatesUserLoginActionPerformed
        blockAll();
        JPUserMenu.setVisible(true);
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
        //Que revise si es la contraseña igual;
        blockAll();
        JPUserMenu.setVisible(true);
        JPLogged.setVisible(true);
        Username.setText(new_username);
    }//GEN-LAST:event_ButtonConfirmChangesActionPerformed

    private void UpdateLoginInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateLoginInfoMouseEntered
        blockAll();
        UserConfiguration.setVisible(true);
        UpdateLoginInfo.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_UpdateLoginInfoMouseEntered

    private void ButtonCancelUpdatesUserInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelUpdatesUserInfoMouseEntered
        ButtonCancelUpdatesUserInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonCancelUpdatesUserInfoMouseEntered

    private void ButtonCancelUpdatesUserInfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelUpdatesUserInfoMouseExited
        ButtonCancelUpdatesUserInfo.setBorder(null);
    }//GEN-LAST:event_ButtonCancelUpdatesUserInfoMouseExited

    private void ButtonCancelUpdatesUserInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelUpdatesUserInfoActionPerformed
        blockAll();
        JPUserMenu.setVisible(true);
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
                blockAll();
                JPUserMenu.setVisible(true);
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
        /*if(!paths.isEmpty()) {
            Picture v = new Picture(null, true, paths.get(indexPictures).toString());
            v.setVisible(true);
        }
        //Necesito una clase Picture;*/
    }//GEN-LAST:event_PictureNewReportListActionPerformed

    private void RightPicNewReportListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RightPicNewReportListMouseEntered
        RightPicNewReportList.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_RightPicNewReportListMouseEntered

    private void RightPicNewReportListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RightPicNewReportListMouseExited
        RightPicNewReportList.setBorder(null);
    }//GEN-LAST:event_RightPicNewReportListMouseExited

    private void RightPicNewReportListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RightPicNewReportListActionPerformed
        int size = paths.size();
        if(indexPictures < size){
            indexPictures++;
        }
        loadPictures(PictureNewReportList, LeftPicNewReportList, RightPicNewReportList);
    }//GEN-LAST:event_RightPicNewReportListActionPerformed

    private void LeftPicNewReportListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeftPicNewReportListMouseEntered
        LeftPicNewReportList.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_LeftPicNewReportListMouseEntered

    private void LeftPicNewReportListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeftPicNewReportListMouseExited
        LeftPicNewReportList.setBorder(null);
    }//GEN-LAST:event_LeftPicNewReportListMouseExited

    private void LeftPicNewReportListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeftPicNewReportListActionPerformed
        if(indexPictures > -1) {
            indexPictures--;
        }
        loadPictures(PictureNewReportList, LeftPicNewReportList, RightPicNewReportList);
    }//GEN-LAST:event_LeftPicNewReportListActionPerformed

    private void ButtonRollbackReportListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackReportListMouseEntered
        ButtonRollbackReportList.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonRollbackReportListMouseEntered

    private void ButtonRollbackReportListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackReportListMouseExited
        ButtonRollbackReportList.setBorder(null);
    }//GEN-LAST:event_ButtonRollbackReportListMouseExited

    private void ButtonRollbackReportListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRollbackReportListActionPerformed
        blockAll();
        JPUserMenu.setVisible(true);
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
        blockAll();
        JPAdminMenu.setVisible(true);
        JPLogged.setVisible(true);
        TableUsersPassword.removeAll();
    }//GEN-LAST:event_ButtonRollbackUserListNotChangePasswordActionPerformed

    private void AdminQueryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminQueryMouseEntered
        blockAll();
        AdminQuery.setVisible(true);
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
        blockAll();
        JPAdminMenu.setVisible(true);
        JPLogged.setVisible(true);
        LogUserList.removeAll();
        BoxLogStartDate.setSelectedIndex(0);
        BoxLogFinishDate.setSelectedIndex(0);
    }//GEN-LAST:event_ButtonRollbackLogActionPerformed

    private void ButtonShowRecordsDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonShowRecordsDateActionPerformed
        //Filtro de rango de fechas para los expedientes
    }//GEN-LAST:event_ButtonShowRecordsDateActionPerformed

    private void ButtonCancelUpdatesUserLoginAdminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelUpdatesUserLoginAdminMouseEntered
        ButtonCancelUpdatesUserLoginAdmin.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonCancelUpdatesUserLoginAdminMouseEntered

    private void ButtonCancelUpdatesUserLoginAdminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelUpdatesUserLoginAdminMouseExited
        ButtonCancelUpdatesUserLoginAdmin.setBorder(null);
    }//GEN-LAST:event_ButtonCancelUpdatesUserLoginAdminMouseExited

    private void ButtonCancelUpdatesUserLoginAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelUpdatesUserLoginAdminActionPerformed
        blockAll();
        JPAdminMenu.setVisible(true);
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
                    Animacion.Animacion.mover_derecha(290, 1100, 1, 1, CreatePerson);
                    blockAll();
                    JPAdminMenu.setVisible(true);
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
        blockAll();
        JPAdminMenu.setVisible(true);
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
                Animacion.Animacion.mover_derecha(290, 1100, 1, 1, CreatePerson);
                blockAll();
                JPAdminMenu.setVisible(true);
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
        blockAll();
        JPAdminMenu.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonRollbackCataloguesActionPerformed

    private void ButtonCancelUnapprovedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelUnapprovedMouseEntered
        ButtonCancelUnapproved.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonCancelUnapprovedMouseEntered

    private void ButtonCancelUnapprovedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelUnapprovedMouseExited
        ButtonCancelUnapproved.setBorder(null);
    }//GEN-LAST:event_ButtonCancelUnapprovedMouseExited

    private void ButtonCancelUnapprovedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelUnapprovedActionPerformed
        blockAll();
        JPAdminMenu.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonCancelUnapprovedActionPerformed

    private void PictureUnapprovedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PictureUnapprovedActionPerformed
       /* if(!paths.isEmpty()) {
            Picture v = new Picture(null, true, paths.get(indexPictures).toString());
            v.setVisible(true);
        }
        /Necesito una clase Picture;*/
    }//GEN-LAST:event_PictureUnapprovedActionPerformed

    private void RightUnapprovedPicMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RightUnapprovedPicMouseEntered
        RightUnapprovedPic.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_RightUnapprovedPicMouseEntered

    private void RightUnapprovedPicMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RightUnapprovedPicMouseExited
        RightUnapprovedPic.setBorder(null);
    }//GEN-LAST:event_RightUnapprovedPicMouseExited

    private void RightUnapprovedPicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RightUnapprovedPicActionPerformed
        int size = paths.size();
        if(indexPictures < size){
            indexPictures++;
        }
        loadPictures(PictureUnapproved, LeftUnapprovedPic, RightUnapprovedPic);
    }//GEN-LAST:event_RightUnapprovedPicActionPerformed

    private void LeftUnapprovedPicMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeftUnapprovedPicMouseEntered
        LeftUnapprovedPic.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_LeftUnapprovedPicMouseEntered

    private void LeftUnapprovedPicMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeftUnapprovedPicMouseExited
        LeftUnapprovedPic.setBorder(null);
    }//GEN-LAST:event_LeftUnapprovedPicMouseExited

    private void LeftUnapprovedPicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeftUnapprovedPicActionPerformed
        if(indexPictures > -1){
            indexPictures--;
        }
        loadPictures(PictureUnapproved, LeftUnapprovedPic, RightUnapprovedPic);
    }//GEN-LAST:event_LeftUnapprovedPicActionPerformed

    private void AddUnapprovedPicMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddUnapprovedPicMouseEntered
        AddUnapprovedPic.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_AddUnapprovedPicMouseEntered

    private void AddUnapprovedPicMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddUnapprovedPicMouseExited
        AddUnapprovedPic.setBorder(null);
    }//GEN-LAST:event_AddUnapprovedPicMouseExited

    private void AddUnapprovedPicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddUnapprovedPicActionPerformed
        //Agregar imágenes al expediente;
    }//GEN-LAST:event_AddUnapprovedPicActionPerformed

    private void RemoveUnapprovedPicMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveUnapprovedPicMouseEntered
        RemoveUnapprovedPic.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_RemoveUnapprovedPicMouseEntered

    private void RemoveUnapprovedPicMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveUnapprovedPicMouseExited
        RemoveUnapprovedPic.setBorder(null);
    }//GEN-LAST:event_RemoveUnapprovedPicMouseExited

    private void RemoveUnapprovedPicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveUnapprovedPicActionPerformed
        //eliminar imagenes al expediente;
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
        blockAll();
        JPAdminMenu.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonConfirmUnapprovedActionPerformed

    private void ButtonConfirmUserCatalogueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonConfirmUserCatalogueActionPerformed
        blockAll();
        AdminConfiguration.setVisible(true);
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
        blockAll();
        AdminConfiguration.setVisible(true);
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
        blockAll();
        AdminConfiguration.setVisible(true);
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
        try{
            int type_number = ConnectDB.getInt("APP", "admin_type.getId",type_crime);
            ConnectDB.delete("APP", "admin_type.remove_type",type_number);
        }catch(Exception e){}
    }//GEN-LAST:event_RemoveTypeCrimeActionPerformed

    private void AddTypeSentenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTypeSentenceActionPerformed
       String new_type_sentence = (String) JOptionPane.showInputDialog(null,"New type sentence: ",JOptionPane.QUESTION_MESSAGE);
        //Agregarlo a la base
       try{
            ConnectDB.delete("APP", "admin_type.insert_type",new_type_sentence);
        }catch(Exception e){}
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
        String name_country = (String) BoxCountry.getSelectedItem();
        String name_state = (String) BoxState.getSelectedItem();
        String name_city = (String)BoxCity.getSelectedItem();
        String type_zone = (String) BoxTypeOfZone.getSelectedItem();
        if("Null".equals(type_zone)){
            JOptionPane.showMessageDialog(this, "Choose a valid option type of zone.");
        }
        try {
            ResultSet records = null;
            String graphName = "";
            String valueName = "";
            if(null != type_zone)
            switch (type_zone) {
                case "District":
                    records = ConnectDB.records_by_district(ConnectDB.getIdCity(name_city), ConnectDB.getIdState(name_state), ConnectDB.getIdCountry(name_country));
                    graphName = "Records by district";
                    valueName = "district";
                    break;
                case "City":
                    records = ConnectDB.records_by_city(ConnectDB.getIdState(name_state), ConnectDB.getIdCountry(name_country));
                    graphName = "Records by city";
                    valueName = "city";
                    break;
                case "State":
                    records = ConnectDB.query("ADM", "statistics.records_by_state", ConnectDB.getIdCountry(name_country));
                    graphName = "Records by state";
                    valueName = "state";
                    break;
                case "Country":
                    records = ConnectDB.query("ADM", "statistics.records_by_country");
                    graphName = "Records by country";
                    valueName = "country";
                    break;
                default:              
                    break;
            }
            
            DefaultPieDataset dataset = new DefaultPieDataset();
            float per = 0;
            while(records.next())
            {
                per = records.getFloat("percentage");
                dataset.setValue(records.getString(valueName) + " / " + records.getString("quantity") + " / " + String.valueOf(per) + "%", new Double(per));
            }
            JFreeChart chart = ChartFactory.createPieChart(graphName, dataset, 
                    false,true, false);
            ChartPanel panel = new ChartPanel(chart);
            JFrame ventana = new JFrame(graphName);
            ventana.setVisible(true);
            ventana.setSize(800, 600);
            ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ventana.add(panel);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE); 
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonEnterReportsZoneActionPerformed

    private void ButtonEnterPersonRecordsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonEnterPersonRecordsMouseEntered
        ButtonEnterPersonRecords.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonEnterPersonRecordsMouseEntered

    private void ButtonEnterPersonRecordsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonEnterPersonRecordsMouseExited
        ButtonEnterPersonRecords.setBorder(null);
    }//GEN-LAST:event_ButtonEnterPersonRecordsMouseExited

    private void ButtonEnterPersonRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEnterPersonRecordsActionPerformed
        String name_country = (String) BoxCountryPersonRecords.getSelectedItem();
        String name_state = (String) BoxStatePersonRecords.getSelectedItem();
        String name_city = (String)BoxCityPersonRecords.getSelectedItem();
        String type_zone = (String) BoxTypeOfZone1.getSelectedItem();
        if("Null".equals(type_zone)){
            JOptionPane.showMessageDialog(this, "Choose a valid option type of zone.");
        }
        try {
            ResultSet records = null;
            String graphName = "";
            String valueName = "";
            if(null != type_zone)
            switch (type_zone) {
                case "District":
                    records = ConnectDB.criminals_by_district(ConnectDB.getIdCity(name_city), ConnectDB.getIdState(name_state), ConnectDB.getIdCountry(name_country));
                    graphName = "Persons with records by district";
                    valueName = "district";
                    break;
                case "City":
                    records = ConnectDB.criminals_by_city(ConnectDB.getIdState(name_state), ConnectDB.getIdCountry(name_country));
                    graphName = "Persons with records by city";
                    valueName = "city";
                    break;
                case "State":
                    records = ConnectDB.query("ADM", "statistics.criminals_by_state", ConnectDB.getIdCountry(name_country));
                    graphName = "Persons with records by state";
                    valueName = "state";
                    break;
                case "Country":
                    records = ConnectDB.query("ADM", "statistics.criminals_by_country");
                    graphName = "Persons with records by country";
                    valueName = "country";
                    break;
                default:              
                    break;
            }
            
            DefaultPieDataset dataset = new DefaultPieDataset();
            float per = 0;
            while(records.next())
            {
                per = records.getFloat("percentage");
                dataset.setValue(records.getString(valueName) + " / " + records.getString("quantity") + " / " + String.valueOf(per) + "%", new Double(per));
            }
            JFreeChart chart = ChartFactory.createPieChart(graphName, dataset, 
                    false,true, false);
            ChartPanel panel = new ChartPanel(chart);
            JFrame ventana = new JFrame(graphName);
            ventana.setVisible(true);
            ventana.setSize(800, 600);
            ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ventana.add(panel);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE); 
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Aquí es donde se llama la función de la base de datos con los filtros y se agrega en la lista los valores
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
        blockAll();
        UserCatalogues.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonUserCataloguesActionPerformed

    private void ButtonPersonCataloguesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPersonCataloguesActionPerformed
        Animacion.Animacion.mover_derecha(290, 1100, 1, 1, AdminConfiguration);
        blockAll();
        PersonCatalogues.setVisible(true);
        JPLogged.setVisible(true);
        try {
            fillInPersonCatalogues();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonPersonCataloguesActionPerformed

    private void ButtonRecordCataloguesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRecordCataloguesActionPerformed
        Animacion.Animacion.mover_derecha(290, 1100, 1, 1, AdminConfiguration);
        blockAll();
        RecordCatalogues.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonRecordCataloguesActionPerformed

    private void AddDistrictMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddDistrictMouseEntered
        AddDistrict.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_AddDistrictMouseEntered

    private void AddDistrictMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddDistrictMouseExited
        AddDistrict.setBorder(null);
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
        RemoveDistrict.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_RemoveDistrictMouseEntered

    private void RemoveDistrictMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveDistrictMouseExited
        RemoveDistrict.setBorder(null);
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
        ButtonRefresh.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonRefreshMouseEntered

    private void ButtonRefreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRefreshMouseExited
        ButtonRefresh.setBorder(null);
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
            //UnapprovedResolutionField.setText((String) record.getObject("resolution"));
            UnapprovedExpireDateField.setText((String) record.getObject("crime_expition_date"));
            UnapprovedIdOffender.setText((String) record.getObject("id_person"));
            //UnapprovedTypeField.setText((String) record.getObject("id_type"));
            YearsSentenceUnapproved.setText((String) record.getObject("id_veredict"));
            ResultSet pictures = ConnectDB.query("APP","admin_picture.getAll", numberr);
            ArrayList<String> paths = null;
            while(pictures.next())
            {
                paths.add((String) pictures.getObject("pic_str"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Hay que cambiar lo de la resolución y el veredicto
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
        ButtonEnterReportsZone1.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonEnterReportsZone1MouseEntered

    private void ButtonEnterReportsZone1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonEnterReportsZone1MouseExited
        ButtonEnterReportsZone1.setBorder(null);
    }//GEN-LAST:event_ButtonEnterReportsZone1MouseExited

    private void ButtonEnterReportsZone1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEnterReportsZone1ActionPerformed
        try {
            ResultSet records = ConnectDB.query("ADM","statistics.records_classification");
            DefaultPieDataset dataset = new DefaultPieDataset();
            float per = 0;
            while(records.next())
            {
                per = records.getFloat("percentage");
                dataset.setValue(records.getString("name") + " / " + records.getString("quantity") + " / " + String.valueOf(per) + "%", new Double(per));
            }
            JFreeChart chart = ChartFactory.createPieChart("Records by classification", dataset, 
                    false,true, false);
            ChartPanel panel = new ChartPanel(chart);
            JFrame ventana = new JFrame("Records by classification");
            ventana.setVisible(true);
            ventana.setSize(800, 600);
            ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ventana.add(panel);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);           
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonEnterReportsZone1ActionPerformed

    private void BoxResolutionUnapprovedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxResolutionUnapprovedActionPerformed
        int resolution = BoxResolutionUnapproved.getSelectedIndex();
        if(resolution == 1){
            YearsSentenceUnapproved.setEnabled(false);
            StartDateSentenceUnapproved.setEnabled(false);
            FinishDateSentenceUnapproved.setEnabled(false);
            BoxTypeSentenceUnapproved.setEnabled(false);
        }
    }//GEN-LAST:event_BoxResolutionUnapprovedActionPerformed

    private void ButtonBanUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonBanUserMouseEntered
        ButtonBanUser.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonBanUserMouseEntered

    private void ButtonBanUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonBanUserMouseExited
        ButtonBanUser.setBorder(null);
    }//GEN-LAST:event_ButtonBanUserMouseExited

    private void ButtonBanUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBanUserActionPerformed
        Animacion.Animacion.mover_derecha(290, 1100, 1, 1, AdminConfiguration);
        blockAll();
        CreateBanUser.setVisible(true);
        JPLogged.setVisible(true);
        try {
            ResultSet lista = ConnectDB.query("ADM", "adminUser.getAllUsernames");
            DefaultListModel model = new DefaultListModel();
            while(lista.next())
            {
                model.addElement(lista.getString("username"));
            }
            ListUsersForBan.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonBanUserActionPerformed

    private void ButtonPersonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonPersonMouseEntered
        ButtonPerson.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonPersonMouseEntered

    private void ButtonPersonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonPersonMouseExited
        ButtonPerson.setBorder(null);
    }//GEN-LAST:event_ButtonPersonMouseExited

    private void ButtonPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPersonActionPerformed
        Animacion.Animacion.mover_derecha(290, 1100, 1, 1, AdminConfiguration);
        blockAll();
        CreatePersonAdmin.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonPersonActionPerformed

    private void ButtonRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRecordMouseEntered
        ButtonRecord.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonRecordMouseEntered

    private void ButtonRecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRecordMouseExited
        ButtonRecord.setBorder(null);
    }//GEN-LAST:event_ButtonRecordMouseExited

    private void ButtonRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRecordActionPerformed
        Animacion.Animacion.mover_derecha(290, 1100, 1, 1, AdminConfiguration);
        blockAll();
        CreateRecordAdmin.setVisible(true);
        JPLogged.setVisible(true);
        //Llenar las combo box
    }//GEN-LAST:event_ButtonRecordActionPerformed

    private void ButtonRollbackCreateSystemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackCreateSystemMouseEntered
        ButtonRollbackCreateSystem.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonRollbackCreateSystemMouseEntered

    private void ButtonRollbackCreateSystemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackCreateSystemMouseExited
        ButtonRollbackCreateSystem.setBorder(null);
    }//GEN-LAST:event_ButtonRollbackCreateSystemMouseExited

    private void ButtonRollbackCreateSystemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRollbackCreateSystemActionPerformed
        blockAll();
        JPAdminMenu.setVisible(true);
        CreateRecordAdmin.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonRollbackCreateSystemActionPerformed

    private void ButtonDeleteBanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonDeleteBanMouseEntered
        ButtonDeleteBan.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonDeleteBanMouseEntered

    private void ButtonDeleteBanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonDeleteBanMouseExited
        ButtonDeleteBan.setBorder(null);
    }//GEN-LAST:event_ButtonDeleteBanMouseExited

    private void ButtonDeleteBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDeleteBanActionPerformed
        Animacion.Animacion.mover_derecha(290, 1100, 1, 1, AdminConfiguration);
        blockAll();
        CreateBanUser.setVisible(true);
        DeleteBan.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonDeleteBanActionPerformed

    private void ButtonDeletePersonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonDeletePersonMouseEntered
        ButtonDeletePerson.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonDeletePersonMouseEntered

    private void ButtonDeletePersonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonDeletePersonMouseExited
        ButtonDeletePerson.setBorder(null);
    }//GEN-LAST:event_ButtonDeletePersonMouseExited

    private void ButtonDeletePersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDeletePersonActionPerformed
        Animacion.Animacion.mover_derecha(290, 1100, 1, 1, AdminConfiguration);
        blockAll();
        DeletePerson.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonDeletePersonActionPerformed

    private void ButtonDeleteRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonDeleteRecordMouseEntered
        ButtonDeleteRecord.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonDeleteRecordMouseEntered

    private void ButtonDeleteRecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonDeleteRecordMouseExited
        ButtonDeleteRecord.setBorder(null);
    }//GEN-LAST:event_ButtonDeleteRecordMouseExited

    private void ButtonDeleteRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDeleteRecordActionPerformed
        Animacion.Animacion.mover_derecha(290, 1100, 1, 1, AdminConfiguration);
        blockAll();
        DeleteRecord.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonDeleteRecordActionPerformed

    private void ButtonRollbackDeleteSystemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackDeleteSystemMouseEntered
        ButtonRollbackDeleteSystem.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonRollbackDeleteSystemMouseEntered

    private void ButtonRollbackDeleteSystemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackDeleteSystemMouseExited
        ButtonRollbackDeleteSystem.setBorder(null);
    }//GEN-LAST:event_ButtonRollbackDeleteSystemMouseExited

    private void ButtonRollbackDeleteSystemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRollbackDeleteSystemActionPerformed
        blockAll();
        JPAdminMenu.setVisible(true);
        CreateBanUser.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonRollbackDeleteSystemActionPerformed

    private void ButtonDeleteUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonDeleteUserMouseEntered
        ButtonDeleteUser.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonDeleteUserMouseEntered

    private void ButtonDeleteUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonDeleteUserMouseExited
        ButtonDeleteUser.setBorder(null);
    }//GEN-LAST:event_ButtonDeleteUserMouseExited

    private void ButtonDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDeleteUserActionPerformed
        Animacion.Animacion.mover_derecha(290, 1100, 1, 1, AdminConfiguration);
        blockAll();
        DeleteUser.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonDeleteUserActionPerformed

    private void ButtonCancelPerson1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelPerson1MouseEntered
        ButtonCancelPerson1.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonCancelPerson1MouseEntered

    private void ButtonCancelPerson1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelPerson1MouseExited
        ButtonCancelPerson1.setBorder(null);
    }//GEN-LAST:event_ButtonCancelPerson1MouseExited

    private void ButtonCancelPerson1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelPerson1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonCancelPerson1ActionPerformed

    private void ButtonConfirmPerson1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonConfirmPerson1MouseEntered
        ButtonConfirmPerson1.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonConfirmPerson1MouseEntered

    private void ButtonConfirmPerson1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonConfirmPerson1MouseExited
        ButtonConfirmPerson1.setBorder(null);
    }//GEN-LAST:event_ButtonConfirmPerson1MouseExited

    private void ButtonConfirmPerson1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonConfirmPerson1ActionPerformed
        String offender_id = IdPersonField1.getText();
        String offender_name = NamePersonField1.getText();
        String offender_middle_name = MiddleNamePersonField1.getText();
        String offender_last_name = LastNamePersonField1.getText();
        String offender_birthday = BirthdayPersonField1.getText();
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
        } else if(BoxGenderPerson1.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Choose a valid option.");
        } else if(BoxDistrictPerson1.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Choose a valid option.");
        } else if(BoxInstitutionPerson1.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Choose a valid option.");
        } else {
             try{
                Person person = new Person(Integer.parseInt(offender_id), offender_name, offender_middle_name, offender_last_name, new SimpleDateFormat("dd/MM/yyyy").parse(offender_birthday), BoxGenderNewUser.getSelectedIndex(), BoxInstitutionNewUser.getSelectedIndex(), BoxNewUserDistrict.getSelectedIndex());
                ConnectDB.insert_person(person);
                JOptionPane.showMessageDialog(this, "The person was created successfully in the system.");
                Animacion.Animacion.mover_derecha(290, 1100, 1, 1, CreatePerson);
                blockAll();
                CreateRecord.setVisible(true);
                JPLogged.setVisible(true);
            }
            catch(Exception e){}
        }
    }//GEN-LAST:event_ButtonConfirmPerson1ActionPerformed

    private void CreatePersonAdminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreatePersonAdminMouseEntered
        CreatePersonAdmin.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_CreatePersonAdminMouseEntered

    private void ButtonRollbackCreateRecord1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackCreateRecord1MouseEntered
        ButtonRollbackCreateRecord1.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonRollbackCreateRecord1MouseEntered

    private void ButtonRollbackCreateRecord1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackCreateRecord1MouseExited
        ButtonRollbackCreateRecord1.setBorder(null);
    }//GEN-LAST:event_ButtonRollbackCreateRecord1MouseExited

    private void ButtonRollbackCreateRecord1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRollbackCreateRecord1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonRollbackCreateRecord1ActionPerformed

    private void PictureNewRecord1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PictureNewRecord1ActionPerformed
        /*if(!paths.isEmpty()) {
            Picture v = new Picture(null, true, paths.get(indexPictures).toString());
            v.setVisible(true);
        }
        /Necesito una clase Picture;*/
    }//GEN-LAST:event_PictureNewRecord1ActionPerformed

    private void RightPicRecordAdminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RightPicRecordAdminMouseEntered
        RightPicRecordAdmin.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_RightPicRecordAdminMouseEntered

    private void RightPicRecordAdminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RightPicRecordAdminMouseExited
        RightPicRecordAdmin.setBorder(null);
    }//GEN-LAST:event_RightPicRecordAdminMouseExited

    private void RightPicRecordAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RightPicRecordAdminActionPerformed
        int size = paths.size();
        if(indexPictures < size){
            indexPictures++;
        }
        loadPictures(PictureNewRecord1, LeftPicRecordAdmin, RightPicRecordAdmin);
    }//GEN-LAST:event_RightPicRecordAdminActionPerformed

    private void LeftPicRecordAdminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeftPicRecordAdminMouseEntered
        LeftPicRecordAdmin.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_LeftPicRecordAdminMouseEntered

    private void LeftPicRecordAdminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeftPicRecordAdminMouseExited
        LeftPicRecordAdmin.setBorder(null);
    }//GEN-LAST:event_LeftPicRecordAdminMouseExited

    private void LeftPicRecordAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeftPicRecordAdminActionPerformed
        if(indexPictures > -1){
            indexPictures--;
        }
        loadPictures(PictureNewRecord1, LeftPicRecordAdmin, RightPicRecordAdmin);
    }//GEN-LAST:event_LeftPicRecordAdminActionPerformed

    private void ButtonCreateOffender1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCreateOffender1MouseEntered
        ButtonCreateOffender1.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonCreateOffender1MouseEntered

    private void ButtonCreateOffender1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCreateOffender1MouseExited
        ButtonCreateOffender1.setBorder(null);
    }//GEN-LAST:event_ButtonCreateOffender1MouseExited

    private void ButtonCreateOffender1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCreateOffender1ActionPerformed
        Animacion.Animacion.mover_derecha(290, 1100, 1, 1, CreateRecordAdmin);
        blockAll();
        CreatePersonAdmin.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonCreateOffender1ActionPerformed

    private void RemovePicRecordAdminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemovePicRecordAdminMouseEntered
        RemovePicRecordAdmin.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_RemovePicRecordAdminMouseEntered

    private void RemovePicRecordAdminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemovePicRecordAdminMouseExited
        RemovePicRecordAdmin.setBorder(null);
    }//GEN-LAST:event_RemovePicRecordAdminMouseExited

    private void RemovePicRecordAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemovePicRecordAdminActionPerformed
        //eliminar imagen del expediente;
    }//GEN-LAST:event_RemovePicRecordAdminActionPerformed

    private void ButtonCancelRecordAdminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelRecordAdminMouseEntered
        ButtonCancelRecordAdmin.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonCancelRecordAdminMouseEntered

    private void ButtonCancelRecordAdminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelRecordAdminMouseExited
        ButtonCancelRecordAdmin.setBorder(null);
    }//GEN-LAST:event_ButtonCancelRecordAdminMouseExited

    private void ButtonCancelRecordAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelRecordAdminActionPerformed
        blockAll();
        AdminConfiguration.setVisible(true);
        CreateRecord.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonCancelRecordAdminActionPerformed

    private void BoxResolutionCreateRecord1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxResolutionCreateRecord1ActionPerformed
        int resolution = BoxResolutionCreateRecord.getSelectedIndex();
        if(resolution == 1){
            YearsSentenceCreateRecord.setEnabled(false);
            StartDateSentenceCreateRecord.setEnabled(false);
            FinishDateSentenceCreateRecord.setEnabled(false);
        }
    }//GEN-LAST:event_BoxResolutionCreateRecord1ActionPerformed

    private void ButtonConfirmRecordAdminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonConfirmRecordAdminMouseEntered
        ButtonConfirmRecordAdmin.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonConfirmRecordAdminMouseEntered

    private void ButtonConfirmRecordAdminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonConfirmRecordAdminMouseExited
        ButtonConfirmRecordAdmin.setBorder(null);
    }//GEN-LAST:event_ButtonConfirmRecordAdminMouseExited

    private void ButtonConfirmRecordAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonConfirmRecordAdminActionPerformed
       /* String number_record = RecordNumberField.getText();
        String crime_description = CrimeDescriptionCreateRecord.getText();
        String date_crime = DateCrimeCreateRecord.getText();
        String expire_date = ExpireDateCreateRecord.getText();
        String resolution = BoxResolutionCreateRecord.getItemAt(BoxResolutionCreateRecord.getSelectedIndex());
        if(resolution == "Innocent"){
            YearsSentenceCreateRecord.setEnabled(false);
            StartDateSentenceCreateRecord.setEnabled(false);
            FinishDateSentenceCreateRecord.setEnabled(false);
            BoxTypeSentenceCreateRecord.setEnabled(false);
        }
        String approved = "N";
        //String[] pictures = null; /Moficar para que aquí reciba los paths de las fotos;
        ArrayList<Pictures> pics = null;
        if(number_record.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill the number of the record field.");
        } else if(crime_description.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill the crime description field.");
        } else if(date_crime.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill the date of the crime field.");
        } else if(expire_date.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill the expire date field.");
        } else {
            //Falta crear una tupla en la tabla veredicto y utilizar ese id en la creación del expediente
            try{
                if(CheckBoxApprovedOrNotCreateRecord.isSelected())
                {
                    approved = "Y";
                }
                var record = new BL.Record(number_record, crime_description, new SimpleDateFormat("dd/MM/yyyy").parse(date_crime),
                        resolution, new SimpleDateFormat("dd/MM/yyyy").parse(expire_date), approved, CheckBoxApprovedOrNotCreateRecord.getSelectedIndex(), 
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
                CreatePersonAdmin.setVisible(false);
                CreateRecordAdmin.setVisible(false);
                CreateBanUser.setVisible(false);
                AdminStatistics.setVisible(false);
                JPUserMenu.setVisible(false);
                JPWelcome.setVisible(false);
                JPSignUp.setVisible(false);
                UserQuery.setVisible(false);
                UserConfiguration.setVisible(false);
                CreateRecord.setVisible(false);
                CreatePerson.setVisible(false);
                JPLogin.setVisible(false);
                JPLogged.setVisible(true);
            }
            catch(Exception e){}
        }*/
    }//GEN-LAST:event_ButtonConfirmRecordAdminActionPerformed

    private void AddPicRecordAdminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddPicRecordAdminMouseEntered
        AddPicRecordAdmin.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_AddPicRecordAdminMouseEntered

    private void AddPicRecordAdminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddPicRecordAdminMouseExited
        AddPicRecordAdmin.setBorder(null);
    }//GEN-LAST:event_AddPicRecordAdminMouseExited

    private void AddPicRecordAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPicRecordAdminActionPerformed
        //agregar imagen al expediente;
    }//GEN-LAST:event_AddPicRecordAdminActionPerformed

    private void CreateRecordAdminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateRecordAdminMouseEntered
        CreateRecordAdmin.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_CreateRecordAdminMouseEntered

    private void CreateRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateRecordMouseEntered
        blockAll();
        CreateRecord.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_CreateRecordMouseEntered

    private void AddRecordUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddRecordUserActionPerformed
        //Agregar imagen al expediente;
    }//GEN-LAST:event_AddRecordUserActionPerformed

    private void AddRecordUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddRecordUserMouseExited
        AddRecordUser.setBorder(null);
    }//GEN-LAST:event_AddRecordUserMouseExited

    private void AddRecordUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddRecordUserMouseEntered
        AddRecordUser.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_AddRecordUserMouseEntered

    private void ButtonConfirmRecordUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonConfirmRecordUserActionPerformed
        String number_record = RecordNumberField.getText();
        String crime_description = CrimeDescriptionCreateRecord.getText();
        String stringDatecrime = DateCrimeCreateRecord.getText();
        String expire_date = ExpireDateCreateRecord.getText();
        String years = YearsSentenceCreateRecord.getText();
        String start_date = StartDateSentenceCreateRecord.getText();
        String end_date = FinishDateSentenceCreateRecord.getText();
        try {
            Date dateCrime = new SimpleDateFormat("dd/MM/yyyy").parse(stringDatecrime);
            Date expireDateCrime = new SimpleDateFormat("dd/MM/yyyy").parse(expire_date);
            Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(start_date);
            Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(end_date);
        } catch (ParseException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        String idOffender = BoxOffender.getItemAt(BoxOffender.getSelectedIndex());
        String typeOfCrime = BoxTypeCrimeCreateRecord.getItemAt(BoxTypeCrimeCreateRecord.getSelectedIndex());
        String resolution = BoxResolutionCreateRecord.getItemAt(BoxResolutionCreateRecord.getSelectedIndex());
        if(resolution == "Innocent"){
            YearsSentenceCreateRecord.setEnabled(false);
            StartDateSentenceCreateRecord.setEnabled(false);
            FinishDateSentenceCreateRecord.setEnabled(false);
        }
        String approved = "N";
        String[] pictures = null; //Moficar para que aquí reciba los paths de las fotos;
        ArrayList<Pictures> pics = null;
        if(number_record.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill the number of the record field.");
        } else if(crime_description.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill the crime description field.");
        } else if(stringDatecrime.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill the date of the crime field.");
        } else if(expire_date.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill the expire date field.");
        }else if (BoxOffender.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Fill the offender person field.");
        }else if (BoxTypeCrimeCreateRecord.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Fill the type of crime field.");
        }else if (BoxResolutionCreateRecord.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Fill the resolution of crime field.");
        } else {
            try{
                if(CheckBoxApprovedOrNotCreateRecord.isSelected())
                {
                    approved = "Y";
                }
                var veredict = new Veredict(Integer.parseInt(years));
                var record = new BL.Record(number_record, crime_description, new SimpleDateFormat("dd/MM/yyyy").parse(date_crime),
                    resolution, new SimpleDateFormat("dd/MM/yyyy").parse(expire_date), approved, CheckBoxApprovedOrNotCreateRecord.getSelectedIndex(),
                   BoxOffender.getSelectedIndex(), BoxVeredict.getSelectedIndex(), BoxDistrictRecord.getSelectedIndex());

                ConnectDB.insert_record(record);
                for(String picture : pictures)
                {
                    Pictures pic = new BL.Pictures(picture,number_record);
                    pics.add(pic);
                    ConnectDB.insert_picture(pic);
                }
                JOptionPane.showMessageDialog(this, "The record was created successfully in the system.");
                blockAll();
                JPAdminMenu.setVisible(true);
                JPLogged.setVisible(true);
            }
            catch(Exception e){}
        }
    }//GEN-LAST:event_ButtonConfirmRecordUserActionPerformed

    private void ButtonConfirmRecordUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonConfirmRecordUserMouseExited
        ButtonConfirmRecordUser.setBorder(null);
    }//GEN-LAST:event_ButtonConfirmRecordUserMouseExited

    private void ButtonConfirmRecordUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonConfirmRecordUserMouseEntered
        ButtonConfirmRecordUser.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonConfirmRecordUserMouseEntered

    private void BoxResolutionCreateRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxResolutionCreateRecordActionPerformed
        int index = BoxResolutionCreateRecord.getSelectedIndex();
        if(index == 1){
            YearsSentenceCreateRecord.setEnabled(false);
            StartDateSentenceCreateRecord.setEnabled(false);
            FinishDateSentenceCreateRecord.setEnabled(false);
        }
    }//GEN-LAST:event_BoxResolutionCreateRecordActionPerformed

    private void ButtonCancelRecordUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelRecordUserActionPerformed
        blockAll();
        JPUserMenu.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonCancelRecordUserActionPerformed

    private void ButtonCancelRecordUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelRecordUserMouseExited
        ButtonCancelRecordUser.setBorder(null);
    }//GEN-LAST:event_ButtonCancelRecordUserMouseExited

    private void ButtonCancelRecordUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCancelRecordUserMouseEntered
        ButtonCancelRecordUser.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonCancelRecordUserMouseEntered

    private void RemoveRecordUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveRecordUserActionPerformed
        //eliminar la imagen del expediente;
    }//GEN-LAST:event_RemoveRecordUserActionPerformed

    private void RemoveRecordUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveRecordUserMouseExited
        RemoveRecordUser.setBorder(null);
    }//GEN-LAST:event_RemoveRecordUserMouseExited

    private void RemoveRecordUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveRecordUserMouseEntered
        RemoveRecordUser.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_RemoveRecordUserMouseEntered

    private void ButtonCreateOffenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCreateOffenderActionPerformed
        Animacion.Animacion.mover_derecha(290, 1100, 1, 1, CreateRecord);
        blockAll();
        CreatePerson.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonCreateOffenderActionPerformed

    private void ButtonCreateOffenderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCreateOffenderMouseExited
        ButtonCreateOffender.setBorder(null);
    }//GEN-LAST:event_ButtonCreateOffenderMouseExited

    private void ButtonCreateOffenderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCreateOffenderMouseEntered
        ButtonCreateOffender.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonCreateOffenderMouseEntered

    private void LeftRecordUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeftRecordUserActionPerformed
        if(indexPictures > -1){
            indexPictures--;
        }
        loadPictures(PictureNewRecord, LeftRecordUser, RightRecordUser);
    }//GEN-LAST:event_LeftRecordUserActionPerformed

    private void LeftRecordUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeftRecordUserMouseExited
        LeftRecordUser.setBorder(null);
    }//GEN-LAST:event_LeftRecordUserMouseExited

    private void LeftRecordUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeftRecordUserMouseEntered
        LeftRecordUser.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_LeftRecordUserMouseEntered

    private void RightRecordUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RightRecordUserActionPerformed
        int size = paths.size();
        if(indexPictures < size) {
            indexPictures++;
        }
        loadPictures(PictureRecordToExpire, LeftPicRecordToExpire, RightPicRecordToExpire);
    }//GEN-LAST:event_RightRecordUserActionPerformed

    private void RightRecordUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RightRecordUserMouseExited
        RightRecordUser.setBorder(null);
    }//GEN-LAST:event_RightRecordUserMouseExited

    private void RightRecordUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RightRecordUserMouseEntered
        RightRecordUser.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_RightRecordUserMouseEntered

    private void PictureNewRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PictureNewRecordActionPerformed
        /*if(!paths.isEmpty()) {
            Picture v = new Picture(null, true, paths.get(indexPictures));
            v.setVisible(true);
        }
        /Falta clase Picture;*/
    }//GEN-LAST:event_PictureNewRecordActionPerformed

    private void ButtonRollbackCreateRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRollbackCreateRecordActionPerformed
        blockAll();
        JPUserMenu.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonRollbackCreateRecordActionPerformed

    private void ButtonRollbackCreateRecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackCreateRecordMouseExited
        ButtonRollbackCreateRecord.setBorder(null);
    }//GEN-LAST:event_ButtonRollbackCreateRecordMouseExited

    private void ButtonRollbackCreateRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackCreateRecordMouseEntered
        ButtonRollbackCreateRecord.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonRollbackCreateRecordMouseEntered

    private void ButtonRollbackBanUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackBanUserMouseEntered
        ButtonRollbackBanUser.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonRollbackBanUserMouseEntered

    private void ButtonRollbackBanUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackBanUserMouseExited
        ButtonRollbackBanUser.setBorder(null);
    }//GEN-LAST:event_ButtonRollbackBanUserMouseExited

    private void ButtonRollbackBanUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRollbackBanUserActionPerformed
        blockAll();
        AdminConfiguration.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonRollbackBanUserActionPerformed

    private void ButtonConfirmBannedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonConfirmBannedMouseEntered
        ButtonConfirmBanned.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonConfirmBannedMouseEntered

    private void ButtonConfirmBannedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonConfirmBannedMouseExited
        ButtonConfirmBanned.setBorder(null);
    }//GEN-LAST:event_ButtonConfirmBannedMouseExited

    private void ButtonConfirmBannedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonConfirmBannedActionPerformed
        String username = ListUsersForBan.getSelectedValue();
        boolean isPermanent = CheckBoxPermanency.isSelected();
        String ispermanent = "N";
        if(isPermanent)
            ispermanent = "Y";
        String DateStart = DateStartField2.getText();
        String DateEnd = DateEndField2.getText();
        int bannedReason = Integer.parseInt(BoxReasonBanned.getItemAt(BoxReasonBanned.getSelectedIndex()));
        if(username.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Fill the username field.");
        }
        else if(DateStart.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Fill the start date field.");
        }
        else if(DateEnd.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Fill the end date field.");
        }
        currentUser cu = currentUser.getInstance();
        if(cu.getUsername().equals(username))
        {
            JOptionPane.showMessageDialog(this, "You can´t banned yourself.");
        }
        try {
            Banned banned = new Banned(ispermanent, new SimpleDateFormat("dd/MM/yyyy").parse(DateStart),
                    new SimpleDateFormat("dd/MM/yyyy").parse(DateEnd), username,bannedReason);
            ConnectDB.insertBanned(banned);
            JOptionPane.showMessageDialog(this, "The user was banned of the system succefully.");
            blockAll();
            AdminConfiguration.setVisible(true);
            JPLogged.setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "The user was not banned of the system succefully.");
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "The user was not banned of the system succefully.");
        }
    }//GEN-LAST:event_ButtonConfirmBannedActionPerformed

    private void CreateBanUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateBanUserMouseEntered
        blockAll();
        CreateBanUser.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_CreateBanUserMouseEntered

    private void ButtonRollbackDeleteUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackDeleteUserMouseEntered
        ButtonRollbackDeleteUser.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonRollbackDeleteUserMouseEntered

    private void ButtonRollbackDeleteUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackDeleteUserMouseExited
        ButtonRollbackDeleteUser.setBorder(null);
    }//GEN-LAST:event_ButtonRollbackDeleteUserMouseExited

    private void ButtonRollbackDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRollbackDeleteUserActionPerformed
        blockAll();
        AdminConfiguration.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonRollbackDeleteUserActionPerformed

    private void ButtonDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonDeleteMouseEntered
        ButtonDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonDeleteMouseEntered

    private void ButtonDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonDeleteMouseExited
        ButtonDelete.setBorder(null);
    }//GEN-LAST:event_ButtonDeleteMouseExited

    private void ButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDeleteActionPerformed
        String username = ListUsersDelete.getSelectedValue();
        try {
            ConnectDB.delete("ADM", "adminUser.removeUser",username);
            JOptionPane.showMessageDialog(this, "The user was deleted successfully in the system.");
            blockAll();
            AdminConfiguration.setVisible(true);
            JPLogged.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "The user was NOT deleted successfully in the system. Try again.");
        }
    }//GEN-LAST:event_ButtonDeleteActionPerformed

    private void DeleteUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteUserMouseEntered
        DeleteUser.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_DeleteUserMouseEntered

    private void ButtonRollbackPersonDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackPersonDeleteMouseEntered
        ButtonRollbackPersonDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonRollbackPersonDeleteMouseEntered

    private void ButtonRollbackPersonDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackPersonDeleteMouseExited
        blockAll();
        AdminConfiguration.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonRollbackPersonDeleteMouseExited

    private void ButtonRollbackPersonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRollbackPersonDeleteActionPerformed
        blockAll();
        AdminConfiguration.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonRollbackPersonDeleteActionPerformed

    private void ButtonPersonDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonPersonDeleteMouseEntered
        ButtonPersonDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonPersonDeleteMouseEntered

    private void ButtonPersonDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonPersonDeleteMouseExited
        ButtonPersonDelete.setBorder(null);
    }//GEN-LAST:event_ButtonPersonDeleteMouseExited

    private void ButtonPersonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPersonDeleteActionPerformed
        String person = ListPersonDelete.getSelectedValue();
        try {
            ConnectDB.delete("APP", "admin_person.remove_person",person);
            JOptionPane.showMessageDialog(this, "The person was deleted successfully in the system.");
            blockAll();
            AdminConfiguration.setVisible(true);
            JPLogged.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "The person was NOT deleted successfully in the system. Try again.");
        }
    }//GEN-LAST:event_ButtonPersonDeleteActionPerformed

    private void ButtonRollbackRecordDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackRecordDeleteMouseEntered
        ButtonRollbackRecordDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonRollbackRecordDeleteMouseEntered

    private void ButtonRollbackRecordDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackRecordDeleteMouseExited
        ButtonRollbackRecordDelete.setBorder(null);
    }//GEN-LAST:event_ButtonRollbackRecordDeleteMouseExited

    private void ButtonRollbackRecordDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRollbackRecordDeleteActionPerformed
        blockAll();
        AdminConfiguration.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonRollbackRecordDeleteActionPerformed

    private void ButtonRecordDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRecordDeleteMouseEntered
        ButtonRecordDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonRecordDeleteMouseEntered

    private void ButtonRecordDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRecordDeleteMouseExited
        ButtonRecordDelete.setBorder(null);
    }//GEN-LAST:event_ButtonRecordDeleteMouseExited

    private void ButtonRecordDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRecordDeleteActionPerformed
        String record = ListRecordsDelete.getSelectedValue();
        try {
            ConnectDB.delete("APP", "admin_record.remove_record",record);
            JOptionPane.showMessageDialog(this, "The record was deleted successfully in the system.");
            blockAll();
            AdminConfiguration.setVisible(true);
            JPLogged.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "The record was NOT deleted successfully in the system. Try again.");
        }
    }//GEN-LAST:event_ButtonRecordDeleteActionPerformed

    private void DeleteRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteRecordMouseEntered
        blockAll();
        DeleteRecord.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_DeleteRecordMouseEntered

    private void DeletePersonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeletePersonMouseEntered
        blockAll();
        DeletePerson.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_DeletePersonMouseEntered

    private void ButtonRollbackDeleteBanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackDeleteBanMouseEntered
        ButtonRollbackDeleteBan.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonRollbackDeleteBanMouseEntered

    private void ButtonRollbackDeleteBanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRollbackDeleteBanMouseExited
        ButtonRollbackDeleteBan.setBorder(null);
    }//GEN-LAST:event_ButtonRollbackDeleteBanMouseExited

    private void ButtonRollbackDeleteBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRollbackDeleteBanActionPerformed
        blockAll();
        AdminConfiguration.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonRollbackDeleteBanActionPerformed

    private void ButtonBanDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonBanDeleteMouseEntered
        ButtonBanDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(29,41,81), 2));
    }//GEN-LAST:event_ButtonBanDeleteMouseEntered

    private void ButtonBanDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonBanDeleteMouseExited
        ButtonBanDelete.setBorder(null);
    }//GEN-LAST:event_ButtonBanDeleteMouseExited

    private void ButtonBanDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBanDeleteActionPerformed
        //Eliminar el baneo al usuario;
        blockAll();
        AdminConfiguration.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_ButtonBanDeleteActionPerformed

    private void DeleteBanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteBanMouseEntered
        blockAll();
        DeleteBan.setVisible(true);
        JPLogged.setVisible(true);
    }//GEN-LAST:event_DeleteBanMouseEntered

    private void RecordsExpireListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RecordsExpireListMouseClicked
        /*if(!paths.isEmpty()) {
            Picture v = new Picture(null, true, paths.get(indexPictures));
            v.setVisible(true);
        }
        /Falta la clase Picture;*/
    }//GEN-LAST:event_RecordsExpireListMouseClicked

    private void JPWindowMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPWindowMouseEntered
        if(firstRunning) {
            blockAll();
            JPLogin.setVisible(true);
            JPWelcome.setVisible(true);
        }
    }//GEN-LAST:event_JPWindowMouseEntered

    private void ButtonEnterReportsZone2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonEnterReportsZone2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonEnterReportsZone2MouseEntered

    private void ButtonEnterReportsZone2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonEnterReportsZone2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonEnterReportsZone2MouseExited

    private void ButtonEnterReportsZone2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEnterReportsZone2ActionPerformed
        try {
            ResultSet records = ConnectDB.query("ADM","statistics.users_age_range");
            DefaultPieDataset dataset = new DefaultPieDataset();
            float per = 0;
            while(records.next())
            {
                per = records.getFloat("percentage");
                dataset.setValue(records.getString("age_range_users") + " / " + records.getString("quantity") + " / " + String.valueOf(per) + "%", new Double(per));
            }
            JFreeChart chart = ChartFactory.createPieChart("Users by range", dataset, 
                    false,true, false);
            ChartPanel panel = new ChartPanel(chart);
            JFrame ventana = new JFrame("Users by range");
            ventana.setVisible(true);
            ventana.setSize(800, 600);
            ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ventana.add(panel);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);           
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonEnterReportsZone2ActionPerformed

    private void ButtonEnterReportsZone3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonEnterReportsZone3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonEnterReportsZone3MouseEntered

    private void ButtonEnterReportsZone3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonEnterReportsZone3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonEnterReportsZone3MouseExited

    private void ButtonEnterReportsZone3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEnterReportsZone3ActionPerformed
        try {
            ResultSet records = ConnectDB.query("ADM","statistics.average_record_type_years");
            DefaultPieDataset dataset = new DefaultPieDataset();
            float per = 0;
            while(records.next())
            {
                per = records.getFloat("percentage");
                dataset.setValue(records.getString("record_type") + " / " + records.getString("avg_years_of_sentence") + " / " + String.valueOf(per) + "%", new Double(per));
            }
            JFreeChart chart = ChartFactory.createPieChart("Average record type years of sentence", dataset, 
                    false,true, false);
            ChartPanel panel = new ChartPanel(chart);
            JFrame ventana = new JFrame("Average record type years of sentence");
            ventana.setVisible(true);
            ventana.setSize(800, 600);
            ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ventana.add(panel);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);           
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonEnterReportsZone3ActionPerformed

    private void ButtonEnterReportsZone4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonEnterReportsZone4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonEnterReportsZone4MouseEntered

    private void ButtonEnterReportsZone4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonEnterReportsZone4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonEnterReportsZone4MouseExited

    private void ButtonEnterReportsZone4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEnterReportsZone4ActionPerformed
        try {
            ResultSet records = ConnectDB.query("ADM","statistics.criminal_age_range");
            DefaultPieDataset dataset = new DefaultPieDataset();
            float per = 0;
            while(records.next())
            {
                per = records.getFloat("percentage");
                dataset.setValue(records.getString("age_range_criminals") + " / " + records.getString("quantity") + " / " + String.valueOf(per) + "%", new Double(per));
            }
            JFreeChart chart = ChartFactory.createPieChart("Person in record by age range", dataset, 
                    false,true, false);
            ChartPanel panel = new ChartPanel(chart);
            JFrame ventana = new JFrame("Person in record by age rangee");
            ventana.setVisible(true);
            ventana.setSize(800, 600);
            ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ventana.add(panel);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);           
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonEnterReportsZone4ActionPerformed

    private void ButtonEnterReportsZone5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonEnterReportsZone5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonEnterReportsZone5MouseEntered

    private void ButtonEnterReportsZone5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonEnterReportsZone5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonEnterReportsZone5MouseExited

    private void ButtonEnterReportsZone5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEnterReportsZone5ActionPerformed
        try {
            ResultSet records = ConnectDB.query("ADM","statistics.sentence_time_to_expiration");
            DefaultPieDataset dataset = new DefaultPieDataset();
            float per = 0;
            while(records.next())
            {
                per = records.getFloat("percentage");
                dataset.setValue(records.getString("range") + " / " + records.getString("quantity") + " / " + String.valueOf(per) + "%", new Double(per));
            }
            JFreeChart chart = ChartFactory.createPieChart("Sentence time to expiration", dataset, 
                    false,true, false);
            ChartPanel panel = new ChartPanel(chart);
            JFrame ventana = new JFrame("Sentence time to expiration");
            ventana.setVisible(true);
            ventana.setSize(800, 600);
            ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ventana.add(panel);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);           
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonEnterReportsZone5ActionPerformed

    private void ButtonEnterReportsZone6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonEnterReportsZone6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonEnterReportsZone6MouseEntered

    private void ButtonEnterReportsZone6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonEnterReportsZone6MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonEnterReportsZone6MouseExited

    private void ButtonEnterReportsZone6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEnterReportsZone6ActionPerformed
        try {
            ResultSet records = ConnectDB.query("ADM","statistics.average_record_type_years");
            DefaultPieDataset dataset = new DefaultPieDataset();
            float per = 0;
            while(records.next())
            {
                per = records.getFloat("percentage");
                dataset.setValue(records.getString("record_type") + " / " + records.getString("avg_years_of_sentence") + " / " + String.valueOf(per) + "%", new Double(per));
            }
            JFreeChart chart = ChartFactory.createPieChart("Average years in jail by type", dataset, 
                    false,true, false);
            ChartPanel panel = new ChartPanel(chart);
            JFrame ventana = new JFrame("Average years in jail by type");
            ventana.setVisible(true);
            ventana.setSize(800, 600);
            ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ventana.add(panel);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);           
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonEnterReportsZone6ActionPerformed

    private void ButtonEnterReportsZone7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonEnterReportsZone7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonEnterReportsZone7MouseEntered

    private void ButtonEnterReportsZone7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonEnterReportsZone7MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonEnterReportsZone7MouseExited

    private void ButtonEnterReportsZone7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEnterReportsZone7ActionPerformed
        try {
            ResultSet records = ConnectDB.query("ADM","statistics.records_with_house_arrest");
            DefaultPieDataset dataset = new DefaultPieDataset();
            float per = 0;
            while(records.next())
            {
                per = records.getFloat("percentage");
                dataset.setValue(records.getString("name") + " / " + records.getString("quantity") + " / " + String.valueOf(per) + "%", new Double(per));
            }
            JFreeChart chart = ChartFactory.createPieChart("Records with house arrest", dataset, 
                    false,true, false);
            ChartPanel panel = new ChartPanel(chart);
            JFrame ventana = new JFrame("Records with house arrest");
            ventana.setVisible(true);
            ventana.setSize(800, 600);
            ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ventana.add(panel);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);           
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonEnterReportsZone7ActionPerformed

    private void ButtonRefreshForDeleteUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRefreshForDeleteUserMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonRefreshForDeleteUserMouseEntered

    private void ButtonRefreshForDeleteUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRefreshForDeleteUserMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonRefreshForDeleteUserMouseExited

    private void ButtonRefreshForDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRefreshForDeleteUserActionPerformed
        try {
            ResultSet usernames = ConnectDB.query("ADM", "adminUser.getAllUsernames");
            DefaultListModel model = new DefaultListModel();
            model.removeAllElements();
            while(usernames.next())
            {
                model.addElement(usernames.getString("username"));
            }
            ListUsersDelete.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonRefreshForDeleteUserActionPerformed

    private void ButtonPersonRefreshForDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonPersonRefreshForDeleteMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonPersonRefreshForDeleteMouseEntered

    private void ButtonPersonRefreshForDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonPersonRefreshForDeleteMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonPersonRefreshForDeleteMouseExited

    private void ButtonPersonRefreshForDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPersonRefreshForDeleteActionPerformed
        try {
            ResultSet ids = ConnectDB.query("APP", "admin_person.getAll");
            DefaultListModel model = new DefaultListModel();
            model.removeAllElements();
            while(ids.next())
            {
                model.addElement(ids.getString("id"));
            }
            ListPersonDelete.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonPersonRefreshForDeleteActionPerformed

    private void ButtonPersonRefreshForDelete1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonPersonRefreshForDelete1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonPersonRefreshForDelete1MouseEntered

    private void ButtonPersonRefreshForDelete1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonPersonRefreshForDelete1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonPersonRefreshForDelete1MouseExited

    private void ButtonPersonRefreshForDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPersonRefreshForDelete1ActionPerformed
        try {
            ResultSet records = ConnectDB.query("APP", "admin_record.getAllNumberr");
            DefaultListModel model = new DefaultListModel();
            model.removeAllElements();
            while(records.next())
            {
                model.addElement(records.getString("numberr"));
            }
            ListRecordsDelete.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonPersonRefreshForDelete1ActionPerformed

    private void ButtonPersonRefreshForDelete2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonPersonRefreshForDelete2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonPersonRefreshForDelete2MouseEntered

    private void ButtonPersonRefreshForDelete2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonPersonRefreshForDelete2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonPersonRefreshForDelete2MouseExited

    private void ButtonPersonRefreshForDelete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPersonRefreshForDelete2ActionPerformed
        try {
            ResultSet bans = ConnectDB.query("ADM", "adminUser.getAllUsernamedBanned");
            DefaultListModel model = new DefaultListModel();
            model.removeAllElements();
            while(bans.next())
            {
                model.addElement(bans.getString("username"));
            }
            ListRecordsDelete.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonPersonRefreshForDelete2ActionPerformed

    private void BoxTypeOfZoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxTypeOfZoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BoxTypeOfZoneActionPerformed

    private void BoxCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxCountryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BoxCountryActionPerformed


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
    private javax.swing.JButton AddPicRecordAdmin;
    private javax.swing.JButton AddRecordUser;
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
    private javax.swing.JList<String> BannedListDelete;
    private javax.swing.JPanel BannedUsers;
    private javax.swing.JFormattedTextField BirthdayPersonField;
    private javax.swing.JFormattedTextField BirthdayPersonField1;
    private javax.swing.JFormattedTextField BirthdayUpdateField;
    private javax.swing.JComboBox<String> BoxAdminUserTypeUpdate;
    private javax.swing.JComboBox<String> BoxCity;
    private javax.swing.JComboBox<String> BoxCityPersonRecords;
    private javax.swing.JComboBox<String> BoxCommunityUpdate;
    private javax.swing.JComboBox<String> BoxCountry;
    private javax.swing.JComboBox<String> BoxCountryPersonRecords;
    private javax.swing.JComboBox<String> BoxDistrictAdminUpdate;
    private javax.swing.JComboBox<String> BoxDistrictPerson;
    private javax.swing.JComboBox<String> BoxDistrictPerson1;
    private javax.swing.JComboBox<String> BoxFilter;
    private javax.swing.JComboBox<String> BoxFilterIdPerson;
    private javax.swing.JComboBox<String> BoxFilterLastNamePerson;
    private javax.swing.JComboBox<String> BoxFilterNamePerson;
    private javax.swing.JComboBox<String> BoxFilterSpecify;
    private javax.swing.JComboBox<String> BoxFilterUsernamePerson;
    private javax.swing.JComboBox<String> BoxGenderAdminUpdate;
    private javax.swing.JComboBox<String> BoxGenderNewUser;
    private javax.swing.JComboBox<String> BoxGenderPerson;
    private javax.swing.JComboBox<String> BoxGenderPerson1;
    private javax.swing.JComboBox<String> BoxGenderUpdate;
    private javax.swing.JComboBox<String> BoxInstitutionAdminUpdate;
    private javax.swing.JComboBox<String> BoxInstitutionNewUser;
    private javax.swing.JComboBox<String> BoxInstitutionPerson;
    private javax.swing.JComboBox<String> BoxInstitutionPerson1;
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
    private javax.swing.JComboBox<String> BoxOffender1;
    private javax.swing.JComboBox<String> BoxReasonBanned;
    private javax.swing.JComboBox<String> BoxResolutionCreateRecord;
    private javax.swing.JComboBox<String> BoxResolutionCreateRecord1;
    private javax.swing.JComboBox<String> BoxResolutionUnapproved;
    private javax.swing.JComboBox<String> BoxState;
    private javax.swing.JComboBox<String> BoxStatePersonRecords;
    private javax.swing.JComboBox<String> BoxTypeCrimeApproveRecords;
    private javax.swing.JComboBox<String> BoxTypeCrimeCreateRecord;
    private javax.swing.JComboBox<String> BoxTypeCrimeCreateRecord1;
    private javax.swing.JComboBox<String> BoxTypeOfZone;
    private javax.swing.JComboBox<String> BoxTypeOfZone1;
    private javax.swing.JComboBox<String> BoxTypeSentenceCreateRecord;
    private javax.swing.JComboBox<String> BoxTypeSentenceCreateRecord1;
    private javax.swing.JComboBox<String> BoxTypeSentenceUnapproved;
    private javax.swing.JComboBox<String> BoxUserTypeUpdateUser;
    private javax.swing.JButton ButtonAdminConfiguration;
    private javax.swing.JButton ButtonAdminQuery;
    private javax.swing.JButton ButtonBanDelete;
    private javax.swing.JButton ButtonBanUser;
    private javax.swing.JButton ButtonCancel;
    private javax.swing.JButton ButtonCancelPerson;
    private javax.swing.JButton ButtonCancelPerson1;
    private javax.swing.JButton ButtonCancelRecordAdmin;
    private javax.swing.JButton ButtonCancelRecordCatalogue;
    private javax.swing.JButton ButtonCancelRecordUser;
    private javax.swing.JButton ButtonCancelUnapproved;
    private javax.swing.JButton ButtonCancelUpdatesAdminInfo;
    private javax.swing.JButton ButtonCancelUpdatesUserInfo;
    private javax.swing.JButton ButtonCancelUpdatesUserLogin;
    private javax.swing.JButton ButtonCancelUpdatesUserLoginAdmin;
    private javax.swing.JButton ButtonClose;
    private javax.swing.JButton ButtonConfiguration;
    private javax.swing.JButton ButtonConfirmBanned;
    private javax.swing.JButton ButtonConfirmChanges;
    private javax.swing.JButton ButtonConfirmChangesAdmin;
    private javax.swing.JButton ButtonConfirmChangesUpdateAdminPersonalInfo;
    private javax.swing.JButton ButtonConfirmChangesUpdatePersonalInfo;
    private javax.swing.JButton ButtonConfirmPerson;
    private javax.swing.JButton ButtonConfirmPerson1;
    private javax.swing.JButton ButtonConfirmPersonCatalogue;
    private javax.swing.JButton ButtonConfirmRecordAdmin;
    private javax.swing.JButton ButtonConfirmRecordUser;
    private javax.swing.JButton ButtonConfirmUnapproved;
    private javax.swing.JButton ButtonConfirmUserCatalogue;
    private javax.swing.JButton ButtonCreateOffender;
    private javax.swing.JButton ButtonCreateOffender1;
    private javax.swing.JButton ButtonCreateRecord;
    private javax.swing.JButton ButtonDelete;
    private javax.swing.JButton ButtonDeleteBan;
    private javax.swing.JButton ButtonDeletePerson;
    private javax.swing.JButton ButtonDeleteRecord;
    private javax.swing.JButton ButtonDeleteUser;
    private javax.swing.JButton ButtonEnter;
    private javax.swing.JButton ButtonEnterPersonRecords;
    private javax.swing.JButton ButtonEnterReportsZone;
    private javax.swing.JButton ButtonEnterReportsZone1;
    private javax.swing.JButton ButtonEnterReportsZone2;
    private javax.swing.JButton ButtonEnterReportsZone3;
    private javax.swing.JButton ButtonEnterReportsZone4;
    private javax.swing.JButton ButtonEnterReportsZone5;
    private javax.swing.JButton ButtonEnterReportsZone6;
    private javax.swing.JButton ButtonEnterReportsZone7;
    private javax.swing.JButton ButtonJoin;
    private javax.swing.JButton ButtonLogOut;
    private javax.swing.JButton ButtonLogOutAdminUser;
    private javax.swing.JButton ButtonLogUserList;
    private javax.swing.JButton ButtonMinimize;
    private javax.swing.JButton ButtonPerson;
    private javax.swing.JButton ButtonPersonCatalogues;
    private javax.swing.JButton ButtonPersonDelete;
    private javax.swing.JButton ButtonPersonRefreshForDelete;
    private javax.swing.JButton ButtonPersonRefreshForDelete1;
    private javax.swing.JButton ButtonPersonRefreshForDelete2;
    private javax.swing.JButton ButtonQuery;
    private javax.swing.JButton ButtonRecord;
    private javax.swing.JButton ButtonRecordCatalogues;
    private javax.swing.JButton ButtonRecordDelete;
    private javax.swing.JButton ButtonRefresh;
    private javax.swing.JButton ButtonRefreshForDeleteUser;
    private javax.swing.JButton ButtonRollbackBanUser;
    private javax.swing.JButton ButtonRollbackCatalogues;
    private javax.swing.JButton ButtonRollbackCreateRecord;
    private javax.swing.JButton ButtonRollbackCreateRecord1;
    private javax.swing.JButton ButtonRollbackCreateSystem;
    private javax.swing.JButton ButtonRollbackDeleteBan;
    private javax.swing.JButton ButtonRollbackDeleteSystem;
    private javax.swing.JButton ButtonRollbackDeleteUser;
    private javax.swing.JButton ButtonRollbackLog;
    private javax.swing.JButton ButtonRollbackPersonDelete;
    private javax.swing.JButton ButtonRollbackQueryBanned;
    private javax.swing.JButton ButtonRollbackQueryExpire;
    private javax.swing.JButton ButtonRollbackQueryPlaces;
    private javax.swing.JButton ButtonRollbackQueryRecords;
    private javax.swing.JButton ButtonRollbackQueryUsers;
    private javax.swing.JButton ButtonRollbackRecordDelete;
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
    private javax.swing.JCheckBox CheckBoxApprovedOrNot;
    private javax.swing.JCheckBox CheckBoxApprovedOrNotCreateRecord;
    private javax.swing.JCheckBox CheckBoxApprovedOrNotCreateRecord1;
    private javax.swing.JCheckBox CheckBoxPermanency;
    private javax.swing.JPanel CreateBanUser;
    private javax.swing.JPanel CreatePerson;
    private javax.swing.JPanel CreatePersonAdmin;
    private javax.swing.JPanel CreateRecord;
    private javax.swing.JPanel CreateRecordAdmin;
    private javax.swing.JPanel CreateSystem;
    private javax.swing.JTextArea CrimeDescriptionCreateRecord;
    private javax.swing.JTextArea CrimeDescriptionCreateRecord1;
    private javax.swing.JFormattedTextField DateCrimeCreateRecord;
    private javax.swing.JFormattedTextField DateCrimeCreateRecord1;
    private javax.swing.JFormattedTextField DateEndField;
    private javax.swing.JFormattedTextField DateEndField1;
    private javax.swing.JFormattedTextField DateEndField2;
    private javax.swing.JFormattedTextField DateStartField;
    private javax.swing.JFormattedTextField DateStartField1;
    private javax.swing.JFormattedTextField DateStartField2;
    private javax.swing.JPanel DeleteBan;
    private javax.swing.JPanel DeletePerson;
    private javax.swing.JPanel DeleteRecord;
    private javax.swing.JPanel DeleteSystem;
    private javax.swing.JPanel DeleteUser;
    private javax.swing.JFormattedTextField ExpireDateCreateRecord;
    private javax.swing.JFormattedTextField ExpireDateCreateRecord1;
    private javax.swing.JFormattedTextField FinishDateSentenceCreateRecord;
    private javax.swing.JFormattedTextField FinishDateSentenceCreateRecord1;
    private javax.swing.JFormattedTextField FinishDateSentenceUnapproved;
    private javax.swing.JLabel IconCreateReacord;
    private javax.swing.JLabel IconCreateReacord1;
    private javax.swing.JLabel IconCreateReacord2;
    private javax.swing.JLabel IconCreateReacord3;
    private javax.swing.JLabel IconCreateReacord4;
    private javax.swing.JLabel IconCreateReacord5;
    private javax.swing.JLabel IconCreateReacord6;
    private javax.swing.JLabel IconLogged;
    private javax.swing.JLabel IconOffender;
    private javax.swing.JLabel IconOffender1;
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
    private javax.swing.JTextField IdPersonField;
    private javax.swing.JTextField IdPersonField1;
    private javax.swing.JTextField IdUpdateField;
    private javax.swing.JPanel JPAdminMenu;
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
    private javax.swing.JLabel LabelChooseFilterRecords10;
    private javax.swing.JLabel LabelChooseFilterRecords2;
    private javax.swing.JLabel LabelChooseFilterRecords3;
    private javax.swing.JLabel LabelChooseFilterRecords4;
    private javax.swing.JLabel LabelChooseFilterRecords5;
    private javax.swing.JLabel LabelChooseFilterRecords6;
    private javax.swing.JLabel LabelChooseFilterRecords7;
    private javax.swing.JLabel LabelChooseFilterRecords8;
    private javax.swing.JLabel LabelChooseFilterRecords9;
    private javax.swing.JLabel LabelChooseFilterUserListNotChangePassword;
    private javax.swing.JLabel LabelChooseFilterUserListNotChangePassword1;
    private javax.swing.JLabel LabelChooseFilterUserListNotChangePassword2;
    private javax.swing.JLabel LabelChooseFilterUserListNotChangePassword3;
    private javax.swing.JLabel LabelCity;
    private javax.swing.JLabel LabelCommunityNewUser;
    private javax.swing.JLabel LabelCommunityOffender;
    private javax.swing.JLabel LabelCommunityOffender1;
    private javax.swing.JLabel LabelCommunityUpdate;
    private javax.swing.JLabel LabelCountry;
    private javax.swing.JLabel LabelCrimeDescription;
    private javax.swing.JLabel LabelCrimeDescription1;
    private javax.swing.JLabel LabelCrimeDescriptionUnapproved;
    private javax.swing.JLabel LabelCrimeTypeUnapproved;
    private javax.swing.JLabel LabelCrimeTypeUnapproved1;
    private javax.swing.JLabel LabelCrimeTypeUnapproved2;
    private javax.swing.JLabel LabelDateCrime;
    private javax.swing.JLabel LabelDateCrime1;
    private javax.swing.JLabel LabelDateCrimeUnapproved;
    private javax.swing.JLabel LabelDistrict;
    private javax.swing.JLabel LabelExpireDateUnapproved;
    private javax.swing.JLabel LabelExpireDateUnapproved1;
    private javax.swing.JLabel LabelExpireDateUnapproved2;
    private javax.swing.JLabel LabelExpireDateUnapproved3;
    private javax.swing.JLabel LabelExpireDateUnapproved4;
    private javax.swing.JLabel LabelExpireDateUnapproved5;
    private javax.swing.JLabel LabelExpireDateUnapproved6;
    private javax.swing.JLabel LabelExpireDateUnapproved7;
    private javax.swing.JLabel LabelExpireDateUnapproved8;
    private javax.swing.JLabel LabelFilterIdPerson;
    private javax.swing.JLabel LabelFilterLastNamePerson;
    private javax.swing.JLabel LabelFilterNamePerson;
    private javax.swing.JLabel LabelFilterUsername;
    private javax.swing.JLabel LabelGender;
    private javax.swing.JLabel LabelGender1;
    private javax.swing.JLabel LabelIdNewUser;
    private javax.swing.JLabel LabelIdOffender;
    private javax.swing.JLabel LabelIdOffender1;
    private javax.swing.JLabel LabelInstitution;
    private javax.swing.JLabel LabelInstitutionNewUser;
    private javax.swing.JLabel LabelInstitutionOffender;
    private javax.swing.JLabel LabelInstitutionOffender1;
    private javax.swing.JLabel LabelInstitutionUpdate;
    private javax.swing.JLabel LabelLastNameNewUser;
    private javax.swing.JLabel LabelLastNameOffender;
    private javax.swing.JLabel LabelLastNameOffender1;
    private javax.swing.JLabel LabelLastNameUpdate;
    private javax.swing.JLabel LabelMiddleNameNewUser;
    private javax.swing.JLabel LabelMiddleNameOffender;
    private javax.swing.JLabel LabelMiddleNameOffender1;
    private javax.swing.JLabel LabelMiddleNameUpdate;
    private javax.swing.JLabel LabelNameNewUser;
    private javax.swing.JLabel LabelNameOffender;
    private javax.swing.JLabel LabelNameOffender1;
    private javax.swing.JLabel LabelNewUserBirthday;
    private javax.swing.JLabel LabelNewUserGender;
    private javax.swing.JLabel LabelNewUserPassword;
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
    private javax.swing.JLabel LabelOffender1;
    private javax.swing.JLabel LabelOffenderBirthday;
    private javax.swing.JLabel LabelOffenderBirthday1;
    private javax.swing.JLabel LabelOffenderGender;
    private javax.swing.JLabel LabelOffenderGender1;
    private javax.swing.JLabel LabelOffenderUnapproved;
    private javax.swing.JLabel LabelPassword;
    private javax.swing.JLabel LabelRecordNumber;
    private javax.swing.JLabel LabelRecordNumber1;
    private javax.swing.JLabel LabelResolutionUnapproved;
    private javax.swing.JLabel LabelResolutionUnapproved1;
    private javax.swing.JLabel LabelResolutionUnapproved11;
    private javax.swing.JLabel LabelResolutionUnapproved13;
    private javax.swing.JLabel LabelResolutionUnapproved15;
    private javax.swing.JLabel LabelResolutionUnapproved2;
    private javax.swing.JLabel LabelResolutionUnapproved3;
    private javax.swing.JLabel LabelResolutionUnapproved4;
    private javax.swing.JLabel LabelResolutionUnapproved5;
    private javax.swing.JLabel LabelResolutionUnapproved7;
    private javax.swing.JLabel LabelResolutionUnapproved8;
    private javax.swing.JLabel LabelResolutionUnapproved9;
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
    private javax.swing.JLabel LabelVeredictUnapproved;
    private javax.swing.JLabel LabelVeredictUnapproved1;
    private javax.swing.JLabel LabelVeredictUnapproved2;
    private javax.swing.JLabel LabelVeredictUnapproved3;
    private javax.swing.JLabel LabelVeredictUnapproved4;
    private javax.swing.JLabel LabelVeredictUnapproved5;
    private javax.swing.JLabel LabelWelcome;
    private javax.swing.JTextField LastNameNewUserField;
    private javax.swing.JTextField LastNamePersonField;
    private javax.swing.JTextField LastNamePersonField1;
    private javax.swing.JTextField LastNameUpdateField;
    private javax.swing.JButton LeftPicNewReportList;
    private javax.swing.JButton LeftPicRecordAdmin;
    private javax.swing.JButton LeftPicRecordToExpire;
    private javax.swing.JButton LeftPicShowRecords;
    private javax.swing.JButton LeftRecordUser;
    private javax.swing.JButton LeftUnapprovedPic;
    private javax.swing.JSeparator LineAdminBirthday;
    private javax.swing.JSeparator LineDateCrime;
    private javax.swing.JSeparator LineDateCrime1;
    private javax.swing.JSeparator LineDateCrime10;
    private javax.swing.JSeparator LineDateCrime11;
    private javax.swing.JSeparator LineDateCrime12;
    private javax.swing.JSeparator LineDateCrime13;
    private javax.swing.JSeparator LineDateCrime14;
    private javax.swing.JSeparator LineDateCrime2;
    private javax.swing.JSeparator LineDateCrime3;
    private javax.swing.JSeparator LineDateCrime4;
    private javax.swing.JSeparator LineDateCrime5;
    private javax.swing.JSeparator LineDateCrime6;
    private javax.swing.JSeparator LineDateCrime7;
    private javax.swing.JSeparator LineDateCrime8;
    private javax.swing.JSeparator LineDateCrime9;
    private javax.swing.JSeparator LineExpireDate2;
    private javax.swing.JSeparator LineExpireDate3;
    private javax.swing.JSeparator LineExpireDate4;
    private javax.swing.JSeparator LineNewUserId;
    private javax.swing.JSeparator LineNewUserLastName;
    private javax.swing.JSeparator LineNewUserMiddleName;
    private javax.swing.JSeparator LineNewUserName;
    private javax.swing.JSeparator LineNewUserPassword;
    private javax.swing.JSeparator LineNewUsername;
    private javax.swing.JSeparator LineNumberRecord;
    private javax.swing.JSeparator LineNumberRecord1;
    private javax.swing.JSeparator LineOffenderBirthday;
    private javax.swing.JSeparator LineOffenderBirthday1;
    private javax.swing.JSeparator LineOffenderBirthday2;
    private javax.swing.JSeparator LineOffenderBirthday3;
    private javax.swing.JSeparator LineOffenderId;
    private javax.swing.JSeparator LineOffenderId1;
    private javax.swing.JSeparator LineOffenderLastName;
    private javax.swing.JSeparator LineOffenderLastName1;
    private javax.swing.JSeparator LineOffenderMiddleName;
    private javax.swing.JSeparator LineOffenderMiddleName1;
    private javax.swing.JSeparator LineOffenderName;
    private javax.swing.JSeparator LineOffenderName1;
    private javax.swing.JSeparator LineOffenderName2;
    private javax.swing.JSeparator LinePassword;
    private javax.swing.JSeparator LineResolution3;
    private javax.swing.JSeparator LineResolution4;
    private javax.swing.JSeparator LineResolution5;
    private javax.swing.JSeparator LineResolution6;
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
    private javax.swing.JList<String> ListPersonDelete;
    private javax.swing.JList<String> ListRecordsDelete;
    private javax.swing.JList<String> ListUnapprovedRecords;
    private javax.swing.JList<String> ListUsersDelete;
    private javax.swing.JList<String> ListUsersForBan;
    private javax.swing.JPanel Log;
    private javax.swing.JList<String> LogUserList;
    private javax.swing.JTextField MiddleNameNewUserField;
    private javax.swing.JTextField MiddleNamePersonField;
    private javax.swing.JTextField MiddleNamePersonField1;
    private javax.swing.JTextField MiddleNameUpdateField;
    private javax.swing.JTextField NameNewUserField;
    private javax.swing.JTextField NamePersonField;
    private javax.swing.JTextField NamePersonField1;
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
    private javax.swing.JButton PictureNewRecord1;
    private javax.swing.JButton PictureNewReportList;
    private javax.swing.JButton PictureRecordToExpire;
    private javax.swing.JButton PictureShowRecords;
    private javax.swing.JButton PictureUnapproved;
    private javax.swing.JPanel PlacesMoreRecords;
    private javax.swing.JPanel RecordCatalogues;
    private javax.swing.JTextArea RecordDescriptionText;
    private javax.swing.JTextArea RecordDescriptionTextExpire;
    private javax.swing.JTextField RecordNumberField;
    private javax.swing.JTextField RecordNumberField1;
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
    private javax.swing.JButton RemovePicRecordAdmin;
    private javax.swing.JButton RemoveRecordUser;
    private javax.swing.JButton RemoveState;
    private javax.swing.JButton RemoveTypeCrime;
    private javax.swing.JButton RemoveTypeSentence;
    private javax.swing.JButton RemoveUnapprovedPic;
    private javax.swing.JButton RemoveUserType;
    private javax.swing.JTextArea ReportInformation;
    private javax.swing.JPanel ReportList;
    private javax.swing.JButton RightPicNewReportList;
    private javax.swing.JButton RightPicRecordAdmin;
    private javax.swing.JButton RightPicRecordToExpire;
    private javax.swing.JButton RightPicShowRecords;
    private javax.swing.JButton RightRecordUser;
    private javax.swing.JButton RightUnapprovedPic;
    private javax.swing.JFormattedTextField StartDateSentenceCreateRecord;
    private javax.swing.JFormattedTextField StartDateSentenceCreateRecord1;
    private javax.swing.JFormattedTextField StartDateSentenceUnapproved;
    private javax.swing.JTable Table;
    private javax.swing.JTable TableBanned;
    private javax.swing.JTable TableUsers;
    private javax.swing.JTable TableUsersPassword;
    private javax.swing.JTextArea UnapprovedCrimeDescriptionField;
    private javax.swing.JFormattedTextField UnapprovedDateCrimeField;
    private javax.swing.JFormattedTextField UnapprovedExpireDateField;
    private javax.swing.JTextField UnapprovedIdOffender;
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
    private javax.swing.JTextField YearsSentenceCreateRecord;
    private javax.swing.JTextField YearsSentenceCreateRecord1;
    private javax.swing.JTextField YearsSentenceUnapproved;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
