package ca.st.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.*;
import org.testng.annotations.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DeleteMovieTest extends ca.st.selenium.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void DeleteMovie() throws Exception {
	driver.get(baseUrl + "/php4dvd/#!/sort/name%20asc/");
    
    int num_movies_original = driver.findElements(By.xpath(".//*[@id='results']/a")).size();
	
    driver.findElement(By.cssSelector("#movie_84 > div.title")).click();
    driver.findElement(By.cssSelector("img[alt=\"Remove\"]")).click();
 
    //assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to remove this[\\s\\S]$"));
  
    driver.switchTo().alert().accept();
    
    driver.get(baseUrl + "/php4dvd/#!/sort/name%20asc/");
    int num_movies_new = driver.findElements(By.xpath(".//*[@id='results']/a")).size();
    
    Assert.assertFalse(num_movies_original <= num_movies_new);
  
  
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
