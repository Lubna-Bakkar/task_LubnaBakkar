import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;



public class parameters {
	
	
	public  String randomInt(int digits) {
	    int minimum = (int) Math.pow(10, digits - 1); // minimum value with 2 digits is 10 (10^1)
	    int maximum = (int) Math.pow(10, digits) - 1; // maximum value with 2 digits is 99 (10^2 - 1)
	    Random random = new Random();
	    
	    return Integer.toString( minimum + random.nextInt((maximum - minimum) + 1));
	}

	public String generate_Random_name() {
	    int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();

	    String generatedName = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
		return generatedName;

	}
	
	
	public WebDriver driver;
	
	
	String MyUrl="https://automations.elevatus.io";
	
	SoftAssert mySoftAssert=new SoftAssert();
	String ExpectedTitle="Career portal";

@BeforeTest

public void pre_My_Test() {
	
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(MyUrl);
	driver.navigate().refresh();	
}






}
