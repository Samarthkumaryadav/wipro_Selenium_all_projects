package StepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Pageclass {
	WebDriver driver;
	By user=By.id("user_login");
	By pass=By.id("user_password");
	By signin=By.name("submit");
	By search=By.id("searchTerm");
	
	public Pageclass(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void login(String username1,String password1)
	{
		driver.findElement(user).click();
		driver.findElement(user).sendKeys(username1);;
		driver.findElement(pass).click();
		driver.findElement(pass).sendKeys(password1);;
		driver.findElement(signin).click();
		
	}
	public void search(String item)
	{
		driver.findElement(search).click();
		driver.findElement(search).sendKeys(item);;
		driver.findElement(search).sendKeys(Keys.ENTER);
				
	}
	
	
	
	
			

}
