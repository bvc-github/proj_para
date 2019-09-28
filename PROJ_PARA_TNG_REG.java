package TNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PROJ_PARA_TNG_REG {
	WebDriver driver;
	@BeforeMethod
	public void beforemethod() {
		System.setProperty("webdriver.chrome.driver","C:\\software\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("http://demowebshop.tricentis.com/register");
		}
	/*	
	}
  @Test
  @Parameters({"username","password"})
  public void ParamTest(String username,String password) throws Exception
  {
  	WebElement user=driver.findElement(By.name("username"));
  	user.sendKeys(username);
  	
  	driver.findElement(By.id("pwd")).sendKeys(password);
  	
  	//driver.findElement(By.xpath("//*[@id=\"loginform\"]/input[3]\n")).click();
  }
}
*/
	@Test(dataProvider="register")
		public void dataProviderTest(String FirstName,String LastName,String Email,String Password,String Confirm_Password) throws InterruptedException
		{
		driver.findElement(By.xpath("//*[@id=\"gender-male\"]")).click();
		System.out.println("1");
	    Thread.sleep(1000);
	    
	 	WebElement FN=driver.findElement(By.name("FirstName"));
	 	FN.sendKeys(FirstName);
	 	System.out.println("2");
	    Thread.sleep(1000);
	    
	 	WebElement LN=driver.findElement(By.name("LastName"));
	 	LN.sendKeys(LastName);
	 	System.out.println("3");
	    Thread.sleep(1000);
	    
	 	
	 	WebElement email=driver.findElement(By.name("Email"));
	 	email.sendKeys(Email);
	 	System.out.println("4");
	    Thread.sleep(1000);
	    

	  	
	 	WebElement pwd=driver.findElement(By.id("Password"));
	  	pwd.sendKeys(Password);
	 	System.out.println("5");
	    Thread.sleep(1000);
	  	
	    
	  	
	 	WebElement cfmpwd=driver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]"));
	  	cfmpwd.sendKeys(Confirm_Password);
	 	System.out.println("6");
	    Thread.sleep(1000);
	  	
	  	

	  	driver.findElement(By.xpath("//*[@id=\"register-button\"]")).click();
	  	
	  	Thread.sleep(1000);
	  	System.out.println("7");
	  	
	  	driver.close();
		}
	@DataProvider(name="register")
	public Object[][] dataFromXml()
	{
		return new Object[][] {
		new Object[] {"AKASH","MEHTA","AMEHTA24@GMAIL.COM","password1","password1"},
		new Object[] {"AKASH1","MEHTA","AMEHTA241@GMAIL.COM","password2","password"},
		new Object[] {"AKASH2","MEHTA","AMEHTA242@GMAIL.COM","password3","password3"},
		new Object[] {"AKASH3","MEHTA","AMEHTA243@","password4","password4"},
	};
	}
}
	