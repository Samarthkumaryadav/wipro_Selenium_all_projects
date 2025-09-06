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
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class classTest {
  @Test
  public void amazon() throws InterruptedException
  {
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://www.amazon.in/"); 
	  String expectedurl="https://www.amazon.in/";
	  String actualurl=driver.getCurrentUrl();
	  Assert.assertEquals(actualurl, expectedurl,"Url validation fail");
	  Thread.sleep(3000);
	  System.out.println("amazon - Thread ID: " +Thread.currentThread().getId());
	  driver.close();
  }

}
