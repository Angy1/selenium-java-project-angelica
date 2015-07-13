	package ca.st.selenium;

	import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.*;
import org.testng.annotations.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

	public class AddNewMovieTests extends ca.st.selenium.pages.TestBase {
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Test
	  public void AddNewMoviePositive() throws Exception {
	    driver.get(baseUrl + "/php4dvd/#!/sort/name%20asc/");
	    driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
	    driver.findElement(By.name("name")).clear();
	    driver.findElement(By.name("name")).sendKeys("The matrix");
	    driver.findElement(By.name("year")).clear();
	    driver.findElement(By.name("year")).sendKeys("1999");
	    driver.findElement(By.id("submit")).click();
	  }

	 //@Test
	  public void AddNewMovieNegative() throws Exception {
	    driver.get(baseUrl + "/php4dvd/#!/sort/name%20asc/");
	    driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
	    driver.findElement(By.name("name")).clear();
	    driver.findElement(By.name("name")).sendKeys("Fight club");
	    driver.findElement(By.cssSelector("img[alt=\"Save\"]")).click();
	    driver.findElement(By.id("submit")).click();
	  }
	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	}



