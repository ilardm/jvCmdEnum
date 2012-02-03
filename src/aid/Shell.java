package aid;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import aid.cmd.Commands;
import aid.login.Login;

public class Shell {
	
	private final String HELP = "Help - gives list of commands and description";
	
	private final String START = "Start - starts a new session";
	
	private final String DATE = "Date - gives a current date";
	
	private final String STOP = "Stop - closes a current session";
	
	private final List<String> listOfCommands;
	
	private String userCMD;

	private BufferedReader reader;

	private BufferedWriter writer;
	
	private String name;
	
	private String password;

	public Shell() {
		listOfCommands = Arrays.asList(HELP, START, DATE, STOP);
		reader = new BufferedReader(new InputStreamReader(System.in));
		writer = new BufferedWriter(new OutputStreamWriter(System.out));
	}
	
	public void run(){
		try {
			writer.write("Welcome !");
			writer.flush();
			//
			writer.write("Please enter your name\n");
			writer.flush();
			try {
				name = reader.readLine();
				writer.write("Please enter your password\n");
				writer.flush();
				password = reader.readLine();
				if(!authorize(name, password)){
					System.exit(0);
				}
			} catch(Exception e) {
				
			}
			//
			writer.write("Call a \"Help\" command");
			writer.flush();
			
			userCMD = reader.readLine();
			
			if(userCMD.equals(Commands.HELP.getValue())){
				for(String str : listOfCommands){
					writeToConsole(str);
				}
				reader.close();
				writer.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void writeToConsole(String text){
		try {
			writer.write(text);
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private boolean authorize(String name, String password){
		Login login = new Login(name, name);
		return login.validator();
	}

}
