package pages;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestBase {
	
	public static WebDriver driver;

	public static void initDriver() {
	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
public void takeScreenshot(WebDriver driver) {
		
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yy_HHmmss");
		Date date = new Date();
		
		String label = formatter.format(date);
		
		try {
			
			FileUtils.copyFile(sourceFile, new File(System.getProperty("user.dir") + "/screenshot/" + label + ".png"));
						
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		

public int generateRandomNum(int boundryNum) {
	Random rnd = new Random();
	int generatedNum = rnd.nextInt(boundryNum);
	return generatedNum;
}

public void selectFromDropdown(WebElement element, String visibleText) {
	Select sel = new Select(element);
	sel.selectByVisibleText(visibleText);
}



	

}
