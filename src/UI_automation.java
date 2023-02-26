import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UI_automation extends parameters{
	
	
	
	@Test()
	public void Check_The_Title() {
		
	String myActualTitle=driver.getTitle();
	System.out.println(myActualTitle);
	mySoftAssert.assertEquals(myActualTitle, ExpectedTitle);
	mySoftAssert.assertAll();
	}
	
	@Test()
	//Register_with_valid_fields
	public void Register_Candidate() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		
		parameters obj=new parameters();
	String firstName=obj.generate_Random_name();
		
		String lastName=obj.generate_Random_name();
		
		driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/i")).click();
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div[4]/div[2]/a/button/span[1]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div/div[1]/div/form/div[1]/div[1]/input")).sendKeys((firstName));
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div/div[1]/div/form/div[2]/div[1]/input")).sendKeys((lastName));
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div/div[1]/div/form/div[3]/div[1]/input")).sendKeys((firstName+"@gmail.com"));
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div/div[1]/div/form/div[4]/div[1]/input")).sendKeys((lastName+"123*"));
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div/div[1]/div/form/div[5]/div[1]/input")).sendKeys((lastName+"123*"));
		
	String number=obj.randomInt(7);
		driver.findElement(By.xpath("//*[@id=\"SharedPhoneControlRef--0---0-0-phone_number\"]")).sendKeys(("79"+number));
		Thread.sleep(1000);
		
	WebElement	ele=driver.findElement(By.xpath("//span[@class='text-muted']"));
		
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].click();", ele);
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[normalize-space()='Sign up']")).click();
		
	Thread.sleep(1000);
	
	String	actualMsg=driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div/div[1]/div/div[1]")).getText();
	String	expectmsg="Registered successfully";
	mySoftAssert.assertEquals(actualMsg, expectmsg);

	mySoftAssert.assertAll();

	}
	
	/////////////////////////////////////////////////////
	
	
}
