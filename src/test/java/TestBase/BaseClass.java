package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger; // LOg4j
	public Properties p;

	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({ "os", "browser" })
	public void setUp(String os, String br) throws IOException {

		logger = LogManager.getLogger(this.getClass());

		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid browser name");
			return;
		}

		// Loading config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appUrl"));
		driver.manage().window().maximize();

	}

	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearDown() {
		driver.quit();

	}

	public String aplabetbets() {

		String generatingAlphabetics = RandomStringUtils.randomAlphabetic(5);
		return generatingAlphabetics;
	}

	public String numeric() {

		String generatingNumeric = RandomStringUtils.randomNumeric(10);
		return generatingNumeric;
	}

	public String alphaNumeric() {
		String generatingAlphabetics = RandomStringUtils.randomAlphabetic(5);
		String generatingNumeric = RandomStringUtils.randomNumeric(10);
		return generatingAlphabetics + "@" + generatingNumeric;
	}
	
public String captureScreenShort(String tname) {
		
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot takeScreenShort=(TakesScreenshot)driver;
		
		File sourceFile=takeScreenShort.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\ScreenShorts" + tname + "_" + timeStamp + ".png";
		
		File targerFile=new File(targetFilePath);
		
		sourceFile.renameTo(targerFile);
		
		return targetFilePath;
		
	}

}
