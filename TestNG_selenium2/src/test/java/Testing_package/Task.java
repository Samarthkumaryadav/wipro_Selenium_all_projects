package Testing_package;

import org.testng.annotations.Test;

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
import org.testng.annotations.AfterTest;

public class Task {
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
  
  String[] ele = {"Watch", "Phone", "Bag"};

  @Test(priority=1, invocationCount=2)
  public void search() throws InterruptedException {
      for (String d : ele) {
          WebElement search = driver.findElement(By.id("gh-ac"));
          search.clear();
          search.sendKeys(d);
          search.sendKeys(Keys.ENTER);
          Thread.sleep(3000);
      }
  }


  @AfterTest
  public void afterTest() {
  }

}
