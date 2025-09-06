package Testing_package;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Wait {
	WebDriver driver;
	
	
  @BeforeTest
  public void implicitwait() {
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  
	  }
  @Test
  public void openpage() {
	  driver.manage().window().maximize();
	  driver.get("https://www.flipkart.com/"); 
	  String expectedtitle="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
	  String actualtitle=driver.getTitle();
	  Assert.assertEquals(actualtitle, expectedtitle,"Title validation fail");
	  
	  WebElement search=driver.findElement(By.name("q"));
	  search.sendKeys("watch");
	  search.sendKeys(Keys.ENTER);
	  System.out.println("Search button avil on webpage");
	  
	  WebElement add=driver.findElement(By.name("gf"));
	  add.click();
	  
  }
 

  @AfterTest
  public void afterTest() {
  }

}
