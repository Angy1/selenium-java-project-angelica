
package ca.st.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ca.st.selenium.webdriver.WebDriverFactory;

public class LoginTest extends ca.st.selenium.pages.TestBase {
 private boolean acceptNextAlert = true;
 private StringBuffer verificationErrors = new StringBuffer();

 
 @Test
 public void LoginTest() throws Exception {
	

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
