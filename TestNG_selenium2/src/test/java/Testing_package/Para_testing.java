package Testing_package;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
 
public class Para_testing {
	WebDriver driver;
	@BeforeClass
	  public void beforeClass() throws InterruptedException {
//		driver = new ChromeDriver();
		Thread.sleep(3000);
//        driver.manage().window().maximize();
         }
  @Test(priority=4)
  public void eBay() {
	  driver = new ChromeDriver();
	  driver.get("https://www.ebay.com/?gad_source=1&gad_campaignid=22873541418&gbraid=0AAAABA_ya85eTcZP0DpU80Luz-bor-SYc&gclid=CjwKCAjw7_DEBhAeEiwAWKiCC7iaiOU10UTjMpQZ7OH5ISETEyzGQHy8mnho1hj1JsNRUHREsKtnzxoCvioQAvD_BwE");
	  System.out.println("ebay - Thread ID: " +Thread.currentThread().getId());
	  driver.quit();
  
  }
  @Test(priority=3)
  public void amazon() throws InterruptedException
  {
	  driver = new ChromeDriver();
	  driver.get("https://www.amazon.in/"); 
	  String expectedurl="https://www.amazon.in/";
	  String actualurl=driver.getCurrentUrl();
	  Assert.assertEquals(actualurl, expectedurl,"Url validation fail");
	  Thread.sleep(3000);
	  System.out.println("amazon - Thread ID: " +Thread.currentThread().getId());
  }
  @Test(priority=1)
  public void flipkart() throws InterruptedException
  {
	  driver = new ChromeDriver();
	  driver.get("https://www.flipkart.com/"); 
	  String expectedtitle="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
	  String actualtitle=driver.getTitle();
	  Assert.assertEquals(actualtitle, expectedtitle,"Title validation fail");
	  Thread.sleep(3000);
	  System.out.println("flipKart - Thread ID: " +Thread.currentThread().getId());
  }
  @Test(priority=2)
  public void zerobank() throws InterruptedException
  {
	  driver = new ChromeDriver();
	  driver.get("http://zero.webappsecurity.com/");
	  WebElement search=driver.findElement(By.id("searchTerm"));
	  search.sendKeys("Online banking");
	  search.sendKeys(Keys.ENTER);
	  Assert.assertTrue(true,"search button is not clickable ");
	  Thread.sleep(3000);
	  System.out.println("ZeroBank - Thread ID: " +Thread.currentThread().getId());
  }

 
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
 
}