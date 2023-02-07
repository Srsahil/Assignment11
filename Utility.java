package utilityhelp;


import java.time.Duration;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Reporter;

public class Utility {
	
	
	
	
	public static WebDriver startBrowser(String browserName,String applicationURL)
	{
		
		WebDriver driver=null;
		
		if(browserName.contains("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browserName.contains("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		else if(browserName.contains("Edge"))
		{
			driver=new EdgeDriver();
		}
		else {
			Reporter.log("Sorry "+browserName +" not supported Running test in default browser");
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
		
		driver.get(applicationURL);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}

	
		
	
}

