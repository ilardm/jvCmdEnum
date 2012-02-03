package aid;

public class Main {
	
	private boolean isAuthorized = false;

	public static void main(String[] args) {
		System.out.println("+++ startup");
		Shell shell = new Shell();
		shell.run();
	}

}
