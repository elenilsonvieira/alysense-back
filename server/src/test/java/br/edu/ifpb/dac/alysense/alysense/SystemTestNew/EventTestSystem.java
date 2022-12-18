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

public class EventTestSystem {

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
    public void createEventBackNavigate() {
        driver.get("http://localhost:3000/login");
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
        String urlEventFeed = driver.getCurrentUrl();
        assertEquals(urlEventFeed, "http://localhost:3000/EventFeed");
        timeSleep();
        CreateEventMapping createEventMapping = new CreateEventMapping(driver);

        createEventMapping.clickNavBarCreateEvent();

        timeSleep();

        String urlNewEvent = driver.getCurrentUrl();
        assertEquals(urlNewEvent, "http://localhost:3000/newEvent");

        timeSleep();

        driver.navigate().back();
  
        timeSleep();

        String urlEventFeedAfterBack = driver.getCurrentUrl();
        assertEquals(urlEventFeedAfterBack, "http://localhost:3000/EventFeed");

    }

    @Test
    public void createEvent() {
        driver.get("http://localhost:3000/login");
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
        String urlEventFeed = driver.getCurrentUrl();
       
        assertEquals(urlEventFeed, "http://localhost:3000/EventFeed");
        timeSleep();
        CreateEventMapping createEventMapping = new CreateEventMapping(driver);

        createEventMapping.clickNavBarCreateEvent();

        timeSleep();

        String urlNewEvent = driver.getCurrentUrl();
        assertEquals(urlNewEvent, "http://localhost:3000/newEvent");
        js.executeScript("scrollBy(0,1000)","" );
        timeSleep();
        driver.findElement(By.id("inputTitulo")).click();
        driver.findElement(By.id("inputTitulo")).sendKeys("Japanese Food");

        timeSleep();
        driver.findElement(By.id("inputLocal")).click();
        driver.findElement(By.id("inputLocal")).sendKeys("Japão");

        driver.findElement(By.id("inputDate")).click();

        timeSleep();
        driver.findElement(By.id("inputDate")).sendKeys("04092023");
        driver.findElement(By.id("inputParticipants")).click();

        timeSleep();
        driver.findElement(By.id("inputParticipants")).sendKeys("50");
        driver.findElement(By.id("inputSamples")).click();

        timeSleep();
        driver.findElement(By.id("inputSamples")).sendKeys("50");
        driver.findElement(By.id("minimunAge")).click();

        timeSleep();
        driver.findElement(By.id("minimunAge")).sendKeys("8");
        driver.findElement(By.id("HEDONIC_FACIAL")).click();
        
        timeSleep();
        driver.findElement(By.cssSelector(".btn-primary:nth-child(1)")).click();
        timeSleep();
        
        
        WebElement cardValidEvent = driver.findElement(By.className("toast-title"));
        assertEquals(cardValidEvent.getText(), "Sucesso");
        timeSleep();
        String urlEventFeedAfterCreate = driver.getCurrentUrl();
        assertEquals(urlEventFeedAfterCreate, "http://localhost:3000/EventFeed");
        timeSleep();
    }

    @Test
    public void createEventInvalid () {
        driver.get("http://localhost:3000/login");
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
        String urlEventFeed = driver.getCurrentUrl();
       
        assertEquals(urlEventFeed, "http://localhost:3000/EventFeed");
        timeSleep();
        CreateEventMapping createEventMapping = new CreateEventMapping(driver);

        createEventMapping.clickNavBarCreateEvent();

        timeSleep();

        String urlNewEvent = driver.getCurrentUrl();
        assertEquals(urlNewEvent, "http://localhost:3000/newEvent");
        js.executeScript("scrollBy(0,1000)","" );
        timeSleep();
        timeSleep();
        driver.findElement(By.cssSelector(".btn-primary:nth-child(1)")).click();
        WebElement cardInvalid = driver.findElement(By.className("toast-title"));
        assertEquals(cardInvalid.getText(), "Erro");
        timeSleep();
        timeSleep();
        driver.findElement(By.id("inputTitulo")).click();
        driver.findElement(By.id("inputTitulo")).sendKeys("Japanese Food");
        timeSleep();
        driver.findElement(By.cssSelector(".btn-primary:nth-child(1)")).click();
        WebElement cardInvalid2 = driver.findElement(By.className("toast-title"));
        assertEquals(cardInvalid2.getText(), "Erro");
        timeSleep();
        timeSleep();
        driver.findElement(By.id("inputLocal")).click();
        driver.findElement(By.id("inputLocal")).sendKeys("Japão");
        timeSleep();
        driver.findElement(By.cssSelector(".btn-primary:nth-child(1)")).click();
        WebElement cardInvalid3 = driver.findElement(By.className("toast-title"));
        assertEquals(cardInvalid3.getText(), "Erro");
        timeSleep();
        driver.findElement(By.id("inputDate")).click();
        timeSleep();
        timeSleep();
        driver.findElement(By.id("inputDate")).sendKeys("04092023");
        driver.findElement(By.id("inputParticipants")).click();
        timeSleep();
        driver.findElement(By.cssSelector(".btn-primary:nth-child(1)")).click();
        timeSleep();
        timeSleep();
        WebElement cardValidEvent = driver.findElement(By.className("toast-title"));
        assertEquals(cardValidEvent.getText(), "Sucesso");
        timeSleep();
        String urlEventFeedAfterCreate = driver.getCurrentUrl();
        assertEquals(urlEventFeedAfterCreate, "http://localhost:3000/EventFeed");
        timeSleep();
    }
    public void timeSleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
