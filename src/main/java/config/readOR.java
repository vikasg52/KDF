package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readOR {
	public static Properties OR;
	public static String Path_OR = Constants.Path_OR;
	
	public static void loadOR() throws IOException {
		
		//Creating file system object for Object Repository text/property file
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(Path_OR);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Creating an Object of properties
		OR= new Properties(System.getProperties());
		//Loading all the properties from Object Repository property file in to OR object
		OR.load(fs);
	}
	
	public static void main(String[] args) throws IOException {
		loadOR();
		System.out.println(OR.getProperty("btn_SignIn"));
	}
}
