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

public class TestRegisterPage {
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
  public void testRegisterPage() throws Exception {
    driver.get("http://ec2-18-217-7-101.us-east-2.compute.amazonaws.com:8080/project/home.html");
    driver.findElement(By.linkText("Register Link")).click();
    Thread.sleep(1000);
    driver.findElement(By.name("name")).click();
    Thread.sleep(1000);
    driver.findElement(By.name("name")).clear();
    Thread.sleep(1000);
    driver.findElement(By.name("name")).sendKeys("xingyuchen");
    Thread.sleep(1000);
    driver.findElement(By.name("email")).clear();
    Thread.sleep(1000);
    driver.findElement(By.name("email")).sendKeys("xingyuchen@unomaha.edu");
    Thread.sleep(1000);
    driver.findElement(By.name("psw1")).clear();
    Thread.sleep(1000);
    driver.findElement(By.name("psw1")).sendKeys("123");
    Thread.sleep(1000);
    driver.findElement(By.name("psw2")).clear();
    Thread.sleep(1000);
    driver.findElement(By.name("psw2")).sendKeys("321");
    Thread.sleep(1000);
    driver.findElement(By.name("phone")).clear();
    Thread.sleep(1000);
    driver.findElement(By.name("phone")).sendKeys("123456");
    Thread.sleep(1000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Register Page'])[1]/following::button[1]")).click();
    Thread.sleep(1000);
    driver.findElement(By.linkText("Register")).click();
    Thread.sleep(1000);
    driver.findElement(By.name("name")).click();
    Thread.sleep(1000);
    driver.findElement(By.name("name")).clear();
    Thread.sleep(1000);
    driver.findElement(By.name("name")).sendKeys("xingyuchen");
    Thread.sleep(1000);
    driver.findElement(By.name("email")).clear();
    Thread.sleep(1000);
    driver.findElement(By.name("email")).sendKeys("xingyuchen@unomaha.edu");
    Thread.sleep(1000);
    driver.findElement(By.name("psw1")).clear();
    Thread.sleep(1000);
    driver.findElement(By.name("psw1")).sendKeys("123456");
    Thread.sleep(1000);
    driver.findElement(By.name("psw2")).clear();
    Thread.sleep(1000);
    driver.findElement(By.name("psw2")).sendKeys("123456");
    Thread.sleep(1000);
    driver.findElement(By.name("phone")).clear();
    Thread.sleep(1000);
    driver.findElement(By.name("phone")).sendKeys("123456");
    Thread.sleep(1000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Register Page'])[1]/following::button[1]")).click();
    Thread.sleep(1000);
    driver.findElement(By.linkText("Sign in")).click();
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
