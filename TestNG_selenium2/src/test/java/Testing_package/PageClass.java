package Testing_package;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageClass {
    WebDriver driver;
    By name=By.id("userid");
    By pass=By.id("pass");
    By cont=By.id("signin-continue-btn");
    By submit=By.id("sgnBt");
    
    By changename1=By.xpath("(\"//*[@id=\\\"gh\\\"]/nav/div[1]/span[1]/div/button");
    By cn2=By.xpath("(\"//*[@id=\\\"s0-1-4-9-3[0]-0-9-dialog\\\"]/div/div/ul/li[1]/div[2]/span[2]/a[1]");
    By cn3=By.xpath("(\"/html/body/div[6]/div/div[3]/div[2]/div/div[2]/button/span[2]");
    By cn4=By.xpath("(\"/html/body/div[6]/div/div[3]/div[1]/button");
    By cnsubmit=By.id("username_submit_edit_btn");
    By uname=By.id("user_name");
    By search=By.id("gh-ac");
    By atc=	By.xpath("//*[@id=\"item5c5056c6ec\"]/div/div[1]/div/a/div/img");
    
    By addToCart=By.id("atcBtn_btn_1");
    
    By cart=By.xpath("//*[@id=\"gh\"]/nav/div[2]/div[5]/div/a/span");
    
    By del=By.xpath("//*[@id=\"mainContent\"]/div/div[2]/div[1]/div[1]/div/ul/li/div/div/div/div[2]/span[2]/button");
    
    By desc=By.xpath("//*[@id=\"mainContent\"]/div[1]/div[1]/h1/span");
    By btn= By.cssSelector("button[class=\"gf-flag__button\"]");
    By flang=By.partialLinkText("France");
    By catDrop =By.id("gh-cat");
    By sbcb=By.xpath("//*[@id=\"gh\"]/section/div/div/div/button");
    By fclink=By.cssSelector("a[_sp=\"m570.l3409\"]");
    By sbclink=By.xpath("/html/body/div[2]/div[2]/section[2]/section/div/ul/li[5]/span/a");
    By cd=By.id("gh-cat");
   
    By ravada=By.xpath("//*[@id=\"gh\"]/nav/div[1]/span[1]/div/button");
    By acntset=By.xpath("//*[@id=\"s0-1-4-9-3[0]-0-9-dialog\"]/div/div/ul/li[2]/a");
    By personI=By.id("account-settings-link-PI");
    By editbtn=By.xpath("//*[@id=\"individual_personal_info_address_edit_button\"]");
    By lname=By.id("lastName");
    By city=By.id("city");
    By cntry=By.id("country");
    By optioncntry=By.cssSelector("select>option[value=\"IN\"]");
    By sub=By.id("address_edit_submit_button");
    
    
    public PageClass(WebDriver driver) {
        this.driver = driver;
    }
    public void login(String email, String password) {
        driver.findElement(name).sendKeys(email);
        driver.findElement(cont).click();
        driver.findElement(pass).sendKeys(password);
        driver.findElement(submit).click();
    }
    public void search(String query) {
        WebElement searcha= driver.findElement(search);
        searcha.clear();
        searcha.sendKeys(query);
        searcha.sendKeys(Keys.ENTER);
    }
    
    public void changename(String v) throws InterruptedException
    {
    	 Actions a = new Actions(driver);
         WebElement change = driver.findElement(changename1);
         a.moveToElement(change).perform();
         Thread.sleep(3000);
         driver.findElement(cn2).click();
         driver.findElement(cn3).click();
         driver.findElement(cn4).click();
         driver.findElement(uname).sendKeys(v);
         driver.findElement(submit).click();
         Thread.sleep(2000); 	
         
         
    }
    public void addAndDeleteFromCart() throws InterruptedException {
      
    	driver.findElement(atc).click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.findElement(addToCart).click();
        Thread.sleep(3000);
        driver.switchTo().window(tabs.get(0));
        driver.findElement(cart).click();
        Thread.sleep(3000); 
        driver.findElement(del).click();
    }

    public void address1(String lastn, String city1) throws InterruptedException {
        Actions a=new Actions(driver);
    		WebElement change=driver.findElement(ravada);
    				
    		a.moveToElement(change).perform();

    	
    	driver.findElement(acntset).click();
    	driver.findElement(personI).click();
    	driver.findElement(editbtn).click();
    	driver.findElement(lname).sendKeys(lastn);
    	driver.findElement(city).sendKeys(city1);
    	driver.findElement(cntry).click();
    	driver.findElement(optioncntry).click();
    	driver.findElement(sub).click();
    	
    	    	
    }
    public void shopByCat() throws InterruptedException {
        driver.findElement(sbcb).click();
        Thread.sleep(1000);
        driver.findElement(fclink).click(); 
        Thread.sleep(2000);
        driver.findElement(sbclink).click();
    }

    public void allCat(String v, String v1) {
        WebElement catDrop = driver.findElement(cd);
        Select s = new Select(catDrop);
        s.selectByValue(v); 
        WebElement searchs = driver.findElement(search);
        searchs.clear();
        searchs.sendKeys(v1);
        searchs.sendKeys(Keys.ENTER);
    }

    public String getDesc() {
        return driver.findElement(desc).getText();
        
    }
    public void lang() {
        ArrayList<String> tabs1 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs1.get(0)); // switch to main window
        driver.navigate().to("https://www.ebay.com/"); // navigate to main page
        WebElement cbtn = driver.findElement(By.cssSelector("button[class=\"gf-flag__button\"]"));
        cbtn.sendKeys(Keys.ENTER);
        driver.findElement(flang).click();
    }

}
