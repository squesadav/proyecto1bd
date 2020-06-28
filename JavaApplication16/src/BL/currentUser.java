package BL;

/**
 *
 * @author Sebas
 */
public class currentUser 
{
    private String username;
    private int id_userType;
    private static currentUser instance = null;
    protected currentUser(){}

    public static currentUser getInstance()
    {
	if (instance == null)
	{
            instance = new currentUser();
	}
       return instance;
    }

    public String getUsername() 
    {
        return username;
    }

    public void setUsername(String username) 
    {
        this.username = username;
    }

    public int getId_userType() {
        return id_userType;
    }

    public void setId_userType(int id_userType) {
        this.id_userType = id_userType;
    }
    
    
}
