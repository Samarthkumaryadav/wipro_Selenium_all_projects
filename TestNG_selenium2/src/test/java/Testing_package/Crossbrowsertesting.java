package Testing_package;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Crossbrowsertesting {
	WebDriver driver;
  @Test
  public void chrome() throws InterruptedException
  {
	  driver = new ChromeDriver();
	  driver.get("https://www.flipkart.com/"); 
	  String expectedtitle="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
	  String actualtitle=driver.getTitle();
	  Assert.assertEquals(actualtitle, expectedtitle,"Title validation fail");
	  System.out.println("flipKart - Thread ID: " +Thread.currentThread().getId());	  
	  Thread.sleep(3000);
  }
  @Test
  public void edge() throws InterruptedException
  {
	  System.setProperty("webdriver.edge.driver", "C:\\Users\\priya\\Downloads\\edgedriver_win64 (1)\\msedgedriver.exe");
	  driver = new EdgeDriver();
	  driver.get("https://www.flipkart.com/"); 
	  String expectedtitle="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
	  String actualtitle=driver.getTitle();
	  Assert.assertEquals(actualtitle, expectedtitle,"Title validation fail");
	  
	  System.out.println("flipKart - Thread ID: " +Thread.currentThread().getId());
	  Thread.sleep(3000);
  }
  @AfterTest
  public void afterTest() {
	  driver.close();
	  
		  }
  }
  
  
















