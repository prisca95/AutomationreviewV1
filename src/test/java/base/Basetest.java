package base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fr;
	public static FileReader fr1;
	
		@BeforeMethod
	public void setUp() throws IOException {
		
	if(driver==null) {
		 fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
		 fr1 = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties");

	prop.load(fr);
	loc.load(fr1);
	}
	
	
	 if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
		 ChromeOptions options = new ChromeOptions();  //for new chromedriver issue
		 options.addArguments("--remote-allow-origins=*");   //for new chromedriver issue

		 
		WebDriverManager.chromedriver().driverVersion("110.0.5481").setup();   //base
		  driver = new ChromeDriver(options);  // base
		// driver.get("https://www.zoho.com/");   //properties  
		 //or
		 driver.get(prop.getProperty("testurl"));  //properties
		 	driver.manage().window().maximize();    //maximize window
	}
	
	else if(prop.getProperty("browser").equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();  //base
		 driver = new EdgeDriver();  //base
		driver.get("https://www.zoho.com/"); //properties
		//or
		driver.get(prop.getProperty("testurl"));  //properties
		driver.manage().window().maximize();  //Maximize window
		
	}
	
	
	
	}

	@AfterMethod
	public void tearDown() {
		driver.manage().window().minimize();  //minimize window
		driver.close();
		System.out.println("Teardown successful");
		
	}
}
