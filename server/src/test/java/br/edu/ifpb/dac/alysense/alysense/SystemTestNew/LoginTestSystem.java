package br.edu.ifpb.dac.alysense.alysense.SystemTestNew;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import br.edu.ifpb.dac.alysense.alysense.SystemTestNew.PageObjects.CreateEventMapping;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

public class LoginTestSystem {

  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;

  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void cadastre() {
    driver.get("http://localhost:3000/");
    driver.findElement(By.id("name")).click();
    driver.findElement(By.id("name")).sendKeys("Guilherme");
    timeSleep();
    driver.findElement(By.id("date")).click();
    driver.findElement(By.id("date")).sendKeys("04092022");
    timeSleep();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("guilherme@gmail.com");
    timeSleep();
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("12345678");
    timeSleep();
    driver.findElement(By.cssSelector(".btn")).click();
    timeSleep();
    String urlLogin = driver.getCurrentUrl();
    assertEquals(urlLogin, "http://localhost:3000/login");
  }

  @Test
  public void cadastreInvalid() {
    driver.get("http://localhost:3000/");
    driver.manage().window().setSize(new Dimension(1936, 1066));
    driver.findElement(By.cssSelector(".btn")).click();
    timeSleep();
    WebElement cardInvalid = driver.findElement(By.className("toast-title"));
    assertEquals(cardInvalid.getText(), "Erro");
    timeSleep();
    timeSleep();
    driver.findElement(By.id("name")).click();
    driver.findElement(By.id("name")).sendKeys("Guilherme");
    timeSleep();
    timeSleep();
    timeSleep();
    driver.findElement(By.cssSelector(".btn")).click();
    timeSleep();
    WebElement cardInvalidName = driver.findElement(By.className("toast-title"));
    assertEquals(cardInvalidName.getText(), "Erro");
    timeSleep();
    timeSleep();
    driver.findElement(By.id("date")).click();
    driver.findElement(By.id("date")).sendKeys("04092002");
    timeSleep();
    timeSleep();
    timeSleep();
    driver.findElement(By.cssSelector(".btn")).click();
    WebElement cardInvalidDate = driver.findElement(By.className("toast-title"));
    assertEquals(cardInvalidDate.getText(), "Erro");
    timeSleep();
    timeSleep();
    timeSleep();
  
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("guilherme@gmail.com");
    timeSleep();
    timeSleep();
    timeSleep();
    driver.findElement(By.cssSelector(".btn")).click();
    WebElement cardInvalidEmail = driver.findElement(By.className("toast-title"));
    assertEquals(cardInvalidEmail.getText(), "Erro");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("12345678");
    timeSleep();
    timeSleep();
    timeSleep();
    driver.findElement(By.cssSelector(".btn")).click();
    timeSleep();
    WebElement cardValid = driver.findElement(By.className("toast-title"));
    assertEquals(cardValid.getText(), "Sucesso");
    timeSleep();
    timeSleep();

  }

  @Test
  public void loginSuccess() {
    driver.get("http://localhost:3000/login");
    timeSleep();
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).sendKeys("guilherme@gmail.com");
    timeSleep();
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("12345678");
    timeSleep();
    driver.findElement(By.cssSelector(".btn")).click();
    timeSleep();
    WebElement cardValid = driver.findElement(By.className("toast-title"));
    assertEquals(cardValid.getText(), "Sucesso");
    timeSleep();
    String urlEventFind = driver.getCurrentUrl();
    assertEquals(urlEventFind, "http://localhost:3000/EventFeed");
    timeSleep();

  }

  @Test
  public void loginInvalid() {
    driver.get("http://localhost:3000/login");
    timeSleep();
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).sendKeys("Nicolas@gmail.com");
    timeSleep();
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("12345678");
    timeSleep();
    driver.findElement(By.cssSelector(".btn")).click();
    timeSleep();
    WebElement cardInvalid = driver.findElement(By.className("toast-title"));
    assertEquals(cardInvalid.getText(), "Erro");
    timeSleep();
    String urlLogin = driver.getCurrentUrl();
    assertEquals(urlLogin, "http://localhost:3000/login");

  }

  @Test
  public void loginSuccessBackNavigate() {
    driver.get("http://localhost:3000/login");
    timeSleep();
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).sendKeys("guilherme@gmail.com");
    timeSleep();
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("12345678");
    timeSleep();
    driver.findElement(By.cssSelector(".btn")).click();
    timeSleep();
    WebElement cardValid = driver.findElement(By.className("toast-title"));
    assertEquals(cardValid.getText(), "Sucesso");
    timeSleep();
    String urlEventFind = driver.getCurrentUrl();
    assertEquals(urlEventFind, "http://localhost:3000/EventFeed");
    timeSleep();
    driver.navigate().back();
    timeSleep();
    String urlLogin = driver.getCurrentUrl();
    assertEquals(urlLogin, "http://localhost:3000/login");
    timeSleep();
  }

  public void timeSleep(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
