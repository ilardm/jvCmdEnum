package aid.cmd;

public enum Commands {
	START("Start"), DATE("Date"), STOP("Stop"), HELP("Help");

	private String cmd;

	private Commands(String cmd) {
		this.cmd = cmd;
	}

	public String getValue() {
		return cmd;
	}

}
