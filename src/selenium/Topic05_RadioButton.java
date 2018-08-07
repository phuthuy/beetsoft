package selenium;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic05_RadioButton {
	WebDriver driver;
  
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("http://live.guru99.com/");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }
  @Test
  public void TC_01() {
	  //aaa
	 String currURL =  driver.getCurrentUrl();
	  Assert.assertEquals(currURL, "http://live.guru99.com/");
  }
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
