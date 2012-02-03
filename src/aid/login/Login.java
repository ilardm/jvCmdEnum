package aid.login;

public class Login {

	private String n = "testUser";

	private String p = "abc123";

	private String userName;

	private String userPassword;

	public Login(String userName, String userPassword) {
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public boolean validator() {
		if (userName.equals(n) && userPassword.equals(p)) {
			return true;
		} else {
			return false;
		}
	}

}
