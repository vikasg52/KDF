package config;
 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utility.Logs;
import static config.readOR.OR;


public class ActionKeywords {
	static WebDriver driver;
	static String browser="ch";
 
	
	//open Browser
 public static void openBrowser(){ 
	 if(browser.equalsIgnoreCase("ff")) {
	 System.setProperty("webdriver.gecko.driver", "./src/test/resources/lib/geckodriver.exe");
	 
	 Logs.info("Opening Browser Firefox");
	 
     driver = new FirefoxDriver();
     
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     
     driver.manage().window().maximize();
     
     System.out.println("Browser Opened..");
 } 
	 else if(browser.equalsIgnoreCase("ch")) {
		 
     System.setProperty("webdriver.chrome.driver", "./src/test/resources/lib/chromedriver.exe");
	 
	 Logs.info("Opening Browser chrome");
	 
     driver = new ChromeDriver();
     
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     
     driver.manage().window().maximize(); 
     
     System.out.println("Browser Opened..");
 }
 }
 
 
 //get browser
 public static void navigate(){ 
	 Logs.info("Opening URL-"+Constants.URL);
	 driver.get(Constants.URL);
	 System.out.println("Opened:"+Constants.URL);
 }

 
 public static void click_SignInButton(String object){	 
 Logs.info("Clicking on WebElement"+object);
 driver.findElement(By.xpath(OR.getProperty(object))).click();
 System.out.println("Clicked on sign in button");
 }
 
 
 public static void input_UserName(String Object){	 
 driver.findElement(By.xpath(OR.getProperty(Object))).sendKeys(Constants.UserName);  
 System.out.println("Input user name");
 }
 
 
 public static void input_Password(String object){	 
 driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Constants.Password);
 System.out.println("Input password");
 }
 
 
 public static void click_LoginButton(String object){
 driver.findElement(By.xpath(OR.getProperty(object))).click();
 System.out.println("Click on Login button");
 }
 
 
 public static void waitFor() throws Exception{
 Thread.sleep(2000);
 System.out.println("Waiting for 3 seconds..");
 }
 
 
 public static void click_UserName(){
 driver.findElement(By.xpath("//p[contains(text(),'Welcome Vikas Garg')]")).click();
 System.out.println("Click user name");
 }
 
 
 public static void click_Logout(){
 driver.findElement(By.xpath("//a[@href='https://www.whizdomtraining.com/user/home/logout']")).click();
 System.out.println("Click Logout link");
	String s= driver.findElement(By.xpath("//h4[@class='color-orange text-center']")).getText();
	if(s.equalsIgnoreCase("PLEASE LOGIN")==true) {
		System.out.println("Logout success");
	}else {System.out.println("Logut Failed!!");}
 }
 
 
 public static void closeBrowser(){
 driver.quit();
 //driver.close();
 System.out.println("Browser Closed");
 }
 
 public static void verifyTextPresent() {
	String s= driver.findElement(By.xpath("//h4[@class='color-orange text-center']")).getText();
	if(s.equalsIgnoreCase("PLEASE LOGIN")==true) {
		System.out.println("Logout success");
	}else {System.out.println("Logut Failed!!");}
 }
}