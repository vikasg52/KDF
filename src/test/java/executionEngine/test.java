package executionEngine;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import config.Constants;

public class test {
	static WebDriver driver;

	@Test
	public void testfunction() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "./src/test/resources/lib/geckodriver.exe");

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get(Constants.URL);

		driver.findElement(By.xpath("//a[@href='https://www.qtpselenium.com/login']")).click(); 

		Thread.sleep(3000);	
		

		driver.findElement(By.xpath("//input[@placeholder='Email address']")).sendKeys(Constants.UserName); 

		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(Constants.Password);

		driver.findElement(By.xpath("//button[@class='btn btn-default button-new text-right']")).click();
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//p[contains(text(),'Welcome Vikas Garg')]")).click();

		driver.findElement(By.xpath("//a[@href='https://www.whizdomtraining.com/user/home/logout']")).click();
		
		Thread.sleep(3000);
		
		String s= driver.findElement(By.xpath("//h4[@class='color-orange text-center']")).getText();
		if(s.equalsIgnoreCase("PLEASE LOGIN")==true) {
			System.out.println("TEST PASSED: Logout success");
		}else {System.out.println("TEST FAILED:Logut Failed!!");}
	}
	
}
