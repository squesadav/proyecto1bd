package BL;

/**
 *
 * @author Sebas
 */
public class currentUser 
{
	private String username;
	private static currentUser instance = NULL;


	protected currentUser(){}

	public static currentUser getInstance()
	{
		if (instance == null)
		{
			instance = new currentUser();
		}
       return instance;
    }

	public int getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
