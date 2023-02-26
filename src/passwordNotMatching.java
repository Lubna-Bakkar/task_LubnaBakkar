import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class passwordNotMatching extends parameters{

	
	@Test()
	public void password_Not_Matching() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		
		driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/i")).click();
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div[4]/div[2]/a/button/span[1]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div/div[1]/div/form/div[1]/div[1]/input")).sendKeys(("test1"));
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div/div[1]/div/form/div[2]/div[1]/input")).sendKeys(("test"));
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div/div[1]/div/form/div[3]/div[1]/input")).sendKeys(("mm123.test@gmail.com"));
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div/div[1]/div/form/div[4]/div[1]/input")).sendKeys(("Ttest123*"));
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div/div[1]/div/form/div[5]/div[1]/input")).sendKeys(("Aaaaa"+"123*"));
	
		driver.findElement(By.xpath("//*[@id=\"SharedPhoneControlRef--0---0-0-phone_number\"]")).sendKeys(("776590328"));
		Thread.sleep(1000);
		
	WebElement	ele=driver.findElement(By.xpath("//span[@class='text-muted']"));
		
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].click();", ele);
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[normalize-space()='Sign up']")).click();
	
	////////////////////////////////////////////
	
	String expectedmsg="Passwords must match";
	String actualmsg=driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div/div[1]/div/form/div[5]/div[2]")).getText();
	mySoftAssert.assertEquals(actualmsg, expectedmsg);
	mySoftAssert.assertAll();
	
	
}}
