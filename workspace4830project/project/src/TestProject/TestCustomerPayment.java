package TestProject;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCustomerPayment {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/xingyuchen/workspace4830project/project/chromedriver"); 
		driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCustomerPayment() throws Exception {
    driver.get("http://ec2-18-217-7-101.us-east-2.compute.amazonaws.com:8080/project/payment.html");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Credit/Debit Card'])[1]/following::label[1]")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cash'])[1]/following::label[1]")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("ship address")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("ship address")).clear();
    Thread.sleep(1000);
    driver.findElement(By.id("ship address")).sendKeys("6955 Cum St");
    Thread.sleep(1000);
    driver.findElement(By.id("address2")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("address2")).clear();
    Thread.sleep(1000);
    driver.findElement(By.id("address2")).sendKeys("1245");
    Thread.sleep(1000);
    driver.findElement(By.id("ship zip")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("ship zip")).clear();
    Thread.sleep(1000);
    driver.findElement(By.id("ship zip")).sendKeys("68106-2345");
    Thread.sleep(1000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Zip code required.'])[1]/following::button[1]")).click();
    Thread.sleep(3000);
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
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
