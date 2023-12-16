package page;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BasePage {
	
	public int generateRandomNum(int boundryNum) {
		Random rnd = new Random();
		int generatedNum = rnd.nextInt(boundryNum);
		return generatedNum;
	}
	
	public void selectFromDropdown(WebElement element, String visibleText) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
	public void verifyElemnt(WebElement element, String expectedText, String errorMsg) {
		Assert.assertEquals(element.getText(), expectedText, errorMsg);
	}


}
