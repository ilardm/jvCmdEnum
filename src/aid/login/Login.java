package aid.login;

public class Login {

	private String n = "testUser";

	private String p = "abc123";

	private String userName;

	private String userPassword;
	
	/**
	 * This class provides a simple registration.
	 * @param userName
	 * @param userPassword
	 */

	public Login(String userName, String userPassword) {
		this.userName = userName;
		this.userPassword = userPassword;
	}

	/**
	 * Simple validator.
	 * @return true if user name and user password are correct
	 */
	public boolean validator() {
		if (userName.equals(n) && userPassword.equals(p)) {
			return true;
		} else {
			return false;
		}
	}

}
