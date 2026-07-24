package testBase;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;  //Log4j
import org.apache.logging.log4j.Logger;  //Log4j
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {

	protected WebDriver driver;
	public Properties p;
	public Logger logger;

	@Parameters ({"os","browser"})
	@BeforeMethod
	public void setUp(String os, String br) throws Exception {

		switch(br.toLowerCase()) {
		case "chrome" : driver= new ChromeDriver(); break;
		case "edge" : driver= new EdgeDriver();break;
		case "firefox" : driver= new FirefoxDriver(); break;
		default :System.out.println("Invalid browser"); return;
		}
		
		 

		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		
		logger= LogManager.getLogger(this.getClass());
		logger.info("Started");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
@AfterMethod
	public void tearDown() {

	//driver.close();
	//driver.quit();
	}
}
