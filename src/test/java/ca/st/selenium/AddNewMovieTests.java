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

	 //@Test
	    public void AddNewMoviePositive() throws Exception {
	    	    
	    int num_movies_original = driver.findElements(By.xpath(".//*[@id='results']/a")).size();
	    
	    driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
	    driver.findElement(By.name("name")).clear();
	    driver.findElement(By.name("name")).sendKeys("The matrix");
	    driver.findElement(By.name("year")).clear();
	    driver.findElement(By.name("year")).sendKeys("1999");
	    driver.findElement(By.id("submit")).click();
	    driver.get(baseUrl + "/php4dvd/#!/sort/name%20asc/");
	    int num_movies_new = driver.findElements(By.xpath(".//*[@id='results']/a")).size();
	    Assert.assertFalse(num_movies_original >= num_movies_new);
	  }

	  
	//@Test
	  public void AddNewMovieDoNotFillFieldNegative() throws Exception {
	    driver.get(baseUrl + "/php4dvd/#!/sort/name%20asc/");
	    driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
	    driver.findElement(By.name("name")).clear();
	    driver.findElement(By.name("name")).sendKeys("Fight club");
	    Assert.assertFalse(!driver.findElement(By.xpath(".//*[@id='updateform']/table/tbody/tr[4]/td[2]/label")).isDisplayed());
	
	  }
	
	  
	@Test
	  public void AddNewMovieCheckSaveButtonNegative() throws Exception {
	    driver.get(baseUrl + "/php4dvd/#!/sort/name%20asc/");
	    driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
	    driver.findElement(By.name("name")).clear();
	    driver.findElement(By.name("name")).sendKeys("Fight club");
	    driver.findElement(By.name("year")).sendKeys(" ");
	    driver.findElement(By.id("submit")).click();
	    Assert.assertFalse(!driver.findElement(By.id("submit")).isEnabled());
	    
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



