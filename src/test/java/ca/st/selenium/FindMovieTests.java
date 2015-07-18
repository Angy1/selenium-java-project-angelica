package ca.st.selenium;

import java.util.List;
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

public class FindMovieTests extends ca.st.selenium.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

 @Test
  public void FindMovieThatIncluded() throws Exception {
	
    driver.get(baseUrl + "/php4dvd/#!/sort/name%20asc/");
    List<WebElement>elementsBefore = driver.findElements(By.xpath(".//*[@id='results']/a")); 
    driver.findElement(By.id("q")).clear();
    driver.findElement(By.id("q")).sendKeys("Pulp fiction" + Keys.RETURN);
    Thread.sleep(1000);
    List<WebElement>elementsAfter = driver.findElements(By.xpath(".//*[@id='results']/a"));
    Assert.assertNotEquals(elementsAfter.size(), elementsBefore.size());
    
    
    
  //  Assert.assertFalse(!driver.findElement(By.xpath(".//*[@id='movie_89']/div[1]/div")).isSelected());
  }

 //@Test
  public void FindMovieThatNotIncluded() throws Exception {
	Actions builder = new Actions(driver);   
    driver.get(baseUrl + "/php4dvd/#!/sort/name%20asc/");
    driver.findElement(By.id("q")).clear();
    driver.findElement(By.id("q")).sendKeys("Interstellar");
    builder.sendKeys(Keys.RETURN).perform();
    Thread.sleep(1000);
    Assert.assertFalse(!driver.findElements(By.xpath(".//*[@id='results']/a")).isEmpty());
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

