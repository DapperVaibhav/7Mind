package TestNGFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Login {
	WebDriver driver;
	
	
  @Test(priority=0)
  public void VerifyTitle() throws InterruptedException {
	  String expectedTitle= "7Mind | Live more consciously and relaxed with the 7Mind-App";
	  String actualTitle= driver.getTitle();
	  if(actualTitle.equalsIgnoreCase(expectedTitle)) {
		  System.out.println("Title Verified");
	  }
	  
	  else {
		  System.out.println("Wrong website opened");
	  }
	  
  }

  
  @Test(priority=1)  //Login Click
  public void LoginClick() throws InterruptedException {	  
	  
	  WebDriverWait cookies = new WebDriverWait (driver, 20);
	  cookies.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='button all-cookies primary']"))).click();
	 
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0,20000)");
      
	  WebDriverWait loginbtn = new WebDriverWait (driver, 20);
	  loginbtn.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='button tertiary with-icon teal-light-30']"))).click();
      
   
  }
      @Test(priority=2)  //Register a User Via Email
      public void RegisterUserviaEmail() throws InterruptedException {
    	  JavascriptExecutor js1 = (JavascriptExecutor) driver;
          js1.executeScript("window.scrollBy(0,20000)");
          
          Thread.sleep(2000);
          
          driver.findElements(By.cssSelector("a[class='_2OFNsr8gX_ZiFbxUKxVZI3']")).get(1).click();
          
          WebDriverWait name = new WebDriverWait (driver, 20);
    	  name.until(ExpectedConditions.visibilityOfElementLocated(By.name("name"))).sendKeys("Vaibhav");
    	  
    	  WebDriverWait email = new WebDriverWait (driver, 20);
    	  email.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys("test8@test.com");
    	  
    	  WebDriverWait password = new WebDriverWait (driver, 20);
    	  password.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("Vaibhav@16121994");
    	  
    	  WebDriverWait submit = new WebDriverWait (driver, 20);
    	  submit.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit"))).click();
    	  
    	  WebDriverWait loginclick = new WebDriverWait (driver, 20);
    	  loginclick.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[class='_3Yn0TBSu0TaLPQnZMr4ltW']"))).click();
    	    
 
          
      }
      
      @Test(priority=3)  //Login with Registered User(Email)
      public void LoginEmail() throws InterruptedException {
    	  
    	  WebDriverWait email = new WebDriverWait (driver, 20);
    	  email.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys("test8@test.com");
    	  
    	  WebDriverWait password = new WebDriverWait (driver, 20);
    	  password.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("Vaibhav@16121994");
    	  
    	  WebDriverWait submit = new WebDriverWait (driver, 20);
    	  submit.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit"))).click();
       
      }
  

  @BeforeTest
  public void beforeTest() throws InterruptedException {
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\abc\\Desktop\\7Mind\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
	    driver.get("https://www.7mind.de/en");
	    driver.manage().window().maximize();
	    Thread.sleep(2000);
  }

  @AfterTest
  
  public void afterTest() {
	  driver.close();
  }

}