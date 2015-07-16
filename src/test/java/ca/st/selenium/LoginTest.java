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

import ca.st.selenium.model.User;

public class LoginTest extends ca.st.selenium.pages.TestBase {
 private boolean acceptNextAlert = true;
 private StringBuffer verificationErrors = new StringBuffer();

 @Test
 public void testUntitled() throws Exception {
   
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
//  @BeforeMethod
//  public void mayBeLogout() {
//    if (app.getUserHelper().isLoggedIn()) {
//      app.getUserHelper().logout();
//    }
//  }
// 
//  @Test
//  public void testLoginOK() throws Exception {
//    User user = new User().setLogin("admin").setPassword("admin");
//    app.getUserHelper().loginAs(user);
//    assertTrue(app.getUserHelper().isLoggedInAs(user));
//  }
//
//  @Test
//  public void testLoginFailed() throws Exception {
//    User user = new User().setLogin("admin").setPassword("wrong");
//    app.getUserHelper().loginAs(user);
//    // assertFalse(app.getUserHelper().isLoggedIn());
//    assertTrue(app.getUserHelper().isNotLoggedIn());
//  }
//
//}


