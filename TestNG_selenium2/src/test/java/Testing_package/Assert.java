package Testing_package;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

public class Assert {
	 WebDriver driver;
	 public static boolean stopExecution = false;
	 @BeforeClass
	  public void beforeClass() {
		 	driver=new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	        driver.get("https://www.selenium.dev/");
	  }
	 
	 @Test(priority = 1)
	    public void title() {
	        if (stopExecution) {
	            System.out.println("Stopped");
	            return;
	        }
	        String extitle="Selenium dev";
	        String actitle=driver.getTitle();
	        if (!actitle.equals(extitle)) {
	            stopExecution=true;
	            throw new RuntimeException("Title validation fails");
	        }
	        System.out.println("expected title"+extitle);
	        System.out.println("actual title"+actitle);
	    }

	 @Test(priority = 2)
	 public void url() {
	     if (stopExecution) {
	         throw new SkipException("Skipping test due to previous failure");
	     }
	    
	        String exurl="https://www.selenium.dev/";
	        String acturl=driver.getCurrentUrl();
	        Assert.assertEquals(acturl,exurl,"URL validation fails");
	        System.out.println("Expected url"+exurl);
	        System.out.println("actual url"+acturl);
	    }
	 /* @Test(priority=1)
	  public void title() {
		  String extitle="Selenium";
		  String actitle=driver.getTitle();
		  Assert.assertEquals(actitle,extitle,"Title validation fails");
		  System.out.println("Expected title"+extitle);
		  System.out.println("Actual title"+actitle);
		  
	  
	  }
	  @Test(priority=2)
	  public void url() {
		  String exurl="https://www.selenium.dev/";
		  String acturl=driver.getCurrentUrl();
		  Assert.assertEquals(acturl,exurl,"url validation fails");
		  System.out.println("Expected title"+exurl);
		  System.out.println("Actual title"+acturl);         */
	
	  @AfterClass
	  public void afterClass() {
		  driver.close();
	  }

}
