import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Veiw_QA_Automation_Job extends parameters{
	@Test()
	public void Search_QA_Automation_job() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("document.querySelector('html').style.zoom = 'unset';");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		
		
		driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/i")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'Jobs')]")).click();
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div[1]/div/input")).sendKeys("QA Automation");
		///////////////////////////
		
		
		String careerLevel[]= {"mid","senior","fresh"};
		
		Random rlevel=new Random();
		int n1=rlevel.nextInt(3);
		
		
	driver.findElement(By.xpath("//*[@id=\"careerLevel\"]")).sendKeys(careerLevel[n1]);
	Thread.sleep(2000);
	
	
	/////////////////////////////////////////////////////////////
	
	
	String location[]= {"Irbid","Zarqa","Amman"};
	
	Random rlocation=new Random();
	int num=rlocation.nextInt(3);	
			
driver.findElement(By.xpath("//input[@id='location_uuid']")).sendKeys(location[num]);
Thread.sleep(4000);
WebElement ele=driver.findElement(By.xpath("//button[@class='btn-main text-white ml-1 mt-2 btn btn-outline-secondary']"));
executor.executeScript("arguments[0].click();", ele);

String actResult=driver.findElement(By.xpath("//p[@class='JobCard__CardTitle-sc-18ta2z4-3 bvUebE']")).getText();
String expResult="Automation QA";
mySoftAssert.assertEquals(actResult, expResult);

Thread.sleep(2000);
driver.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div/div/div/div/div/div/div[3]/button/span")).click();

driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[1]/a/div")).isDisplayed();

String Actual_url=driver.getCurrentUrl();
String expect_url="https://automations.elevatus.io/jobs/automation-qa-1677005491";
mySoftAssert.assertEquals(Actual_url, expect_url);

mySoftAssert.assertAll();
}}
