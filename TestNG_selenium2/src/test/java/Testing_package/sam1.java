package Testing_package;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class sam1 {
	WebDriver driver;
	 @BeforeTest
	  public void beforeTest() {
		  driver = new ChromeDriver();
	      driver.get("https://signin.ebay.com/signin/?sgfl=lgp");
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	     
	      driver.manage().window().maximize();
	      
	      WebElement name=driver.findElement(By.id("userid"));
		    name.sendKeys("samyadav1461316@gmail.com");
		    driver.findElement(By.id("signin-continue-btn")).click();
		    
			WebElement pass=driver.findElement(By.id("pass"));
		    pass.sendKeys("Penny#219");
		    
		    driver.findElement(By.id("sgnBt")).click();
		    
	 }
	 @Test(priority=1, enabled=false)
	    public void name() throws InterruptedException {
	        Actions a=new Actions(driver);
	        WebElement change=driver.findElement(By.xpath("//*[@id=\"gh\"]/nav/div[1]/span[1]/div/button"));
	        a.moveToElement(change).perform();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//*[@id=\"s0-1-4-9-3[0]-0-9-dialog\"]/div/div/ul/li[1]/div[2]/span[2]/a[1]")).click();
	        driver.findElement(By.xpath("/html/body/div[6]/div/div[3]/div[2]/div/div[2]/button/span[2]")).click();
	        driver.findElement(By.xpath("/html/body/div[6]/div/div[3]/div[1]/button")).click();
	        WebElement n2 = driver.findElement(By.id("user_name"));
	        n2.sendKeys("yadav");
	        n2.clear();
	        driver.findElement(By.id("username_submit_edit_btn")).click();
	        Thread.sleep(2000);
	    }

	    @Test(priority = 2)
	    public void address() throws InterruptedException {
	        Actions a = new Actions(driver);
	        WebElement change = driver.findElement(By.xpath("//*[@id=\"gh\"]/nav/div[1]/span[1]/div/button"));
	        a.moveToElement(change).perform();
	        driver.findElement(By.xpath("//*[@id=\"s0-1-4-9-3[0]-0-9-dialog\"]/div/div/ul/li[2]/a")).click();
	        driver.findElement(By.id("account-settings-link-PI")).click();
	        driver.findElement(By.xpath("//*[@id=\"individual_personal_info_address_edit_button\"]")).click();
	        WebElement n2 = driver.findElement(By.id("lastName"));
	        n2.clear();
	        n2.sendKeys("Sam");
	        WebElement add = driver.findElement(By.id("addressLine1"));
	        add.clear();
	        add.sendKeys("new building, new colony");
	        WebElement city = driver.findElement(By.id("city"));
	        city.clear();
	        city.sendKeys("Khargone");
	        driver.findElement(By.id("country")).click();
	        driver.findElement(By.cssSelector("select>option[value=\"IN\"]")).click();
	        driver.findElement(By.id("stateOrProvince")).click();
	        driver.findElement(By.cssSelector("select>option[value=\"AP\"]")).click();
	        WebElement n3 = driver.findElement(By.id("postalCode"));
	        n3.clear();
	        n3.sendKeys("451001");
	        driver.findElement(By.id("address_edit_submit_button")).click();
	    }
 

  

  @AfterTest
  public void afterTest() {
  }

}
