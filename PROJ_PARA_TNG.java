package TNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PROJ_PARA_TNG {
	WebDriver driver;
	@BeforeMethod
	public void beforemethod() {
		System.setProperty("webdriver.chrome.driver","C:\\software\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("http://demowebshop.tricentis.com/login");
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
	@Test(dataProvider="login")
		public void dataProviderTest(String Email,String password) throws InterruptedException
		{
	 	WebElement email=driver.findElement(By.name("Email"));
	 	email.sendKeys(Email);
	 	System.out.println("1");
	  	Thread.sleep(1000);
	  	System.out.println("1");
	 	WebElement pwd=driver.findElement(By.id("Password"));
	 	System.out.println("2");
	  	pwd.sendKeys(password);
	  	System.out.println("2");
	  	Thread.sleep(1000);
	  	driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")).click();
	  	Thread.sleep(1000);
	  	System.out.println("3");
	  	driver.close();
		}
	@DataProvider(name="login")
	public Object[][] dataFromXml()
	{
		return new Object[][] {
		new Object[] {"ABC1@dksbf.com","ABC14352"},
		new Object[] {"ABC2@","ABC232432"},
		new Object[] {"ABC3","ABC3wefweewfscdv"},
		new Object[] {"sidwagh11@gmail.com","sidwagh"},
	};
	}
}
	
