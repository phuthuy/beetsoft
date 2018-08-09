package selenium;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.util.List;
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
	public void TC_01_Case1() {
		driver.get("http://daominhdam.890m.com/");
		WebElement hoverText = driver.findElement(By.xpath("//a[contains(text(),'Hover over me')]"));
		action.moveToElement(hoverText).perform();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='tooltip-inner']")).isDisplayed());
	}

	@Test
	public void TC_01_Case2() {
		driver.get("http://www.myntra.com/");
		WebElement account = driver.findElement(By.xpath("//span[@class='myntraweb-sprite desktop-iconUser sprites-user']"));
		action.moveToElement(account).perform();
		driver.findElement(By.xpath("//a[contains(text(),'login')]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='login-box']")).isDisplayed());
	}
	@Test
	public void TC_02() {
		driver.get("http://jqueryui.com/resources/demos/selectable/display-grid.html");
		List<WebElement> items = driver.findElements(By.xpath("//li[@class='ui-state-default ui-selectee']"));
		action.clickAndHold(items.get(0)).moveToElement(items.get(3)).release().perform();
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
