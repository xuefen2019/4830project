package TestProject;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class TestAdminOrderList {
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
  public void testAdminOrderList() throws Exception {
    driver.get("http://ec2-18-217-7-101.us-east-2.compute.amazonaws.com:8080/project/home.html");
    driver.findElement(By.linkText("Log in Link")).click();
    Thread.sleep(1000);
    driver.findElement(By.name("inputEmail")).click();
    Thread.sleep(1000);
    driver.findElement(By.name("inputEmail")).clear();
    Thread.sleep(1000);
    driver.findElement(By.name("inputEmail")).sendKeys("admin@unomaha.edu");
    Thread.sleep(1000);
    driver.findElement(By.name("inputPassword")).clear();
    Thread.sleep(1000);
    driver.findElement(By.name("inputPassword")).sendKeys("admin");
    Thread.sleep(1000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password'])[1]/following::button[1]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@value=\"Greetings! check your customers' order here »\"]")).click();
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
