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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Wait;

public class FindMovieTests extends ca.st.selenium.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
private WebElement webElement;

 @Test
  public void FindMovieThatIncluded() throws Exception {
	 
	 
    driver.get(baseUrl + "php4dvd/#!/sort/name%20asc/");
    String orig_url = driver.getCurrentUrl();
    driver.findElement(By.id("q")).clear();
    driver.findElement(By.id("q")).sendKeys("Pulp fiction" + Keys.RETURN);
    
    new WebDriverWait(driver,10).until(ExpectedConditions.urlContains("Pulp%20fiction"));
    String new_url = driver.getCurrentUrl();
    
    if(!new_url.equals(orig_url))
    {
    	new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='movie_103']/div[1]/div")));
    }
    else
    {
    	Assert.assertFalse(true);
    }
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

