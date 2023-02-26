import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class register_with_invalid_email extends parameters{
	
	/////
	//register_with_invalid_email
		@Test()
		public void RegisterInvalidEmail() throws InterruptedException{
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
			
			driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/i")).click();
			driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div[4]/div[2]/a/button/span[1]")).click();
			
			driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div/div[1]/div/form/div[1]/div[1]/input")).sendKeys(("aaa"));
			driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div/div[1]/div/form/div[2]/div[1]/input")).sendKeys(("test"));
			driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div/div[1]/div/form/div[3]/div[1]/input")).sendKeys(("a1"+".gmail.com"));
			driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div/div[1]/div/form/div[4]/div[1]/input")).sendKeys(("Aaaaa"+"123*"));
			driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div/div[1]/div/form/div[5]/div[1]/input")).sendKeys(("Aaaaa"+"123*"));
			parameters obj=new parameters();
		String number=obj.randomInt(7);
			driver.findElement(By.xpath("//*[@id=\"SharedPhoneControlRef--0---0-0-phone_number\"]")).sendKeys(("79"+number));
			Thread.sleep(1000);
			
		WebElement	ele=driver.findElement(By.xpath("//span[@class='text-muted']"));
			
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Sign up']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Sign up']")).click();
		///////////////////////
		
	Thread.sleep(2000);

	String	actualError=driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div/div[1]/div/form/div[3]/div[2]")).getText();
	String		expectError="Please enter a valid personal email address";
	mySoftAssert.assertEquals(actualError, expectError);
mySoftAssert.assertAll();
		}
		}

