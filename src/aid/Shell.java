package aid;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import aid.cmd.Commands;
import aid.login.Login;

public class Shell {

	private final String HELP = "Help - gives list of commands and description";

	private final String START = "Start - starts a new session";

	private final String DATE = "Date - gives a current date";

	private final String STOP = "Stop - closes a current session";

	private String userCMD;

	private BufferedReader reader;

	private BufferedWriter writer;

	private String name;

	private String password;

	/**
	 * Initialize reader and writer. Initialize list of available commands with
	 * their description
	 */

	public Shell() {
		reader = new BufferedReader(new InputStreamReader(System.in));
		writer = new BufferedWriter(new OutputStreamWriter(System.out));
	}

	public void run() {
		try {
			writer.write("Welcome !");
			writer.flush();
			writer.write("Please enter your name\n");
			writer.flush();
			try {
				name = reader.readLine();
				writeToConsole("Please enter your password");
				password = reader.readLine();
				if (!authorize(name, password)) {
					System.exit(0);
				}
			} catch (Exception e) {
				closeAll();
			}
			while (true) {
				userCMD = reader.readLine();

				if (userCMD.equals(Commands.HELP.getValue())) {
					writeToConsole(HELP, START, DATE, STOP);
					continue;
				}
				if (userCMD.equals(Commands.DATE.getValue())) {
					Date date = new Date();
					writeToConsole(date.toString());
					continue;
				}
				if (userCMD.equals(Commands.START.getValue())) {
					System.out.println("Start a process");
					continue;
				}
				if (userCMD.equals(Commands.STOP.getValue())) {
					closeAll();
					break;
				} else {
					writeToConsole("Unknow command " + userCMD);
					continue;
				}
			}
		} catch (IOException e) {
			closeAll();
			e.printStackTrace();
		}
	}

	private void writeToConsole(String text) {
		try {
			writer.append(text);
			writer.append("\n");
			writer.flush();
		} catch (IOException e) {
			closeAll();
			e.printStackTrace();
		}
	}

	private void writeToConsole(String... strings) throws IOException {
		for (String str : strings) {
			writer.append(str);
			writer.append('\n');
		}
		writer.flush();
	}

	/**
	 * 
	 * @param name
	 * @param password
	 * @return true if name and password are correct
	 */
	private boolean authorize(String name, String password) {
		Login login = new Login(name, password);
		return login.validator();
	}

	private void closeAll() {
		try {
			reader.close();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
