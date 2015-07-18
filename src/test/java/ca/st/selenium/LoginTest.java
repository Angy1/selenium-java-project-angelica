package ca.st.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

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


