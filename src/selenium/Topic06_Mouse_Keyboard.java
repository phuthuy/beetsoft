package selenium;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic06_Mouse_Keyboard {
	WebDriver driver;
	Actions action;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01() {
		driver.get("http://daominhdam.890m.com/");
		WebElement hoverText = driver.findElement(By.xpath("//a[contains(text(),'Hover over me')]"));
		action.moveToElement(hoverText).perform();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='tooltip-inner']")).isDisplayed());
	}

	@Test
	public void TC_02() {
		driver.get("http://www.myntra.com/");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
