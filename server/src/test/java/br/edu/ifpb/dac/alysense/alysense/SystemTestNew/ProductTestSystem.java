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

public class ProductTestSystem {

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
    public void createProductBackNavigate() {
        driver.get("http://localhost:3000/");
        driver.findElement(By.linkText("clique aqui")).click();
        timeSleep();
        String urlLogin = driver.getCurrentUrl();
        assertEquals(urlLogin, "http://localhost:3000/login");
        timeSleep();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("guilherme@gmail.com");
        timeSleep();
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.cssSelector(".btn")).click();
        timeSleep();
        WebElement cardValid = driver.findElement(By.className("toast-title"));
        assertEquals(cardValid.getText(), "Sucesso");
        String urlEventFeed = driver.getCurrentUrl();
        timeSleep();
        assertEquals(urlEventFeed, "http://localhost:3000/EventFeed");

        CreateEventMapping createEventMapping = new CreateEventMapping(driver);

        createEventMapping.clickNavBarCreateEvent();

        timeSleep();

        String urlNewEvent = driver.getCurrentUrl();
        assertEquals(urlNewEvent, "http://localhost:3000/newEvent");

        timeSleep();

        driver.findElement(By.cssSelector(".btn:nth-child(2)")).click();

        String urlNewProduct = driver.getCurrentUrl();
        assertEquals(urlNewProduct, "http://localhost:3000/newProduct");

        timeSleep();

        driver.navigate().back();

        String urlNewEventAfterBack = driver.getCurrentUrl();
        assertEquals(urlNewEventAfterBack, "http://localhost:3000/newEvent");

        timeSleep();
    }

    @Test
    public void createProduct() {
        driver.get("http://localhost:3000/");
        driver.findElement(By.linkText("clique aqui")).click();
        timeSleep();
        String urlLogin = driver.getCurrentUrl();
        assertEquals(urlLogin, "http://localhost:3000/login");
        timeSleep();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("guilherme@gmail.com");
        timeSleep();
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.cssSelector(".btn")).click();
        timeSleep();
        WebElement cardValid = driver.findElement(By.className("toast-title"));
        assertEquals(cardValid.getText(), "Sucesso");
        String urlEventFeed = driver.getCurrentUrl();
        timeSleep();
        assertEquals(urlEventFeed, "http://localhost:3000/EventFeed");

        CreateEventMapping createEventMapping = new CreateEventMapping(driver);

        createEventMapping.clickNavBarCreateEvent();

        timeSleep();

        String urlNewEvent = driver.getCurrentUrl();
        assertEquals(urlNewEvent, "http://localhost:3000/newEvent");

        timeSleep();

        driver.findElement(By.cssSelector(".btn:nth-child(2)")).click();

        String urlNewProduct = driver.getCurrentUrl();
        assertEquals(urlNewProduct, "http://localhost:3000/newProduct");

        timeSleep();
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).sendKeys("Comida Japonesa ");
        timeSleep();
        driver.findElement(By.id("owner")).click();
        driver.findElement(By.id("owner")).sendKeys("Japinha");
        timeSleep();
        driver.findElement(By.id("date")).click();
        driver.findElement(By.id("date")).sendKeys("04092023");
        timeSleep();
        driver.findElement(By.id("ingredients")).click();
        driver.findElement(By.id("ingredients")).sendKeys("Peixe Cru");
        timeSleep();
        driver.findElement(By.cssSelector(".characterist .btn")).click();
        driver.findElement(By.id("charact")).click();
        driver.findElement(By.id("charact")).sendKeys("Caracteristica");
        timeSleep();
        driver.findElement(By.cssSelector(".btn:nth-child(3)")).click();
        driver.findElement(By.cssSelector(".slices .btn")).click();
    
        driver.findElement(By.id("obs")).click();
        driver.findElement(By.id("obs")).sendKeys("Amostra");
        timeSleep();
        driver.findElement(By.cssSelector(".btn:nth-child(4)")).click();
        driver.findElement(By.cssSelector(".btn-primary:nth-child(1)")).click();
        timeSleep();
        timeSleep();
        WebElement cardValidProduct = driver.findElement(By.className("toast-title"));
        assertEquals(cardValidProduct.getText(), "Sucesso");
        String urlNewEventAfterCreate = driver.getCurrentUrl();
        assertEquals(urlNewEventAfterCreate, "http://localhost:3000/newEvent");
        timeSleep();

    }
    
    @Test
    public void createProductInvalid() {
        driver.get("http://localhost:3000/");
        driver.findElement(By.linkText("clique aqui")).click();
        timeSleep();
        String urlLogin = driver.getCurrentUrl();
        assertEquals(urlLogin, "http://localhost:3000/login");
        timeSleep();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("guilherme@gmail.com");
        timeSleep();
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.cssSelector(".btn")).click();
        timeSleep();
        WebElement cardValid = driver.findElement(By.className("toast-title"));
        assertEquals(cardValid.getText(), "Sucesso");
        String urlEventFeed = driver.getCurrentUrl();
        timeSleep();
        assertEquals(urlEventFeed, "http://localhost:3000/EventFeed");

        CreateEventMapping createEventMapping = new CreateEventMapping(driver);

        createEventMapping.clickNavBarCreateEvent();

        timeSleep();

        String urlNewEvent = driver.getCurrentUrl();
        assertEquals(urlNewEvent, "http://localhost:3000/newEvent");

        timeSleep();

        driver.findElement(By.cssSelector(".btn:nth-child(2)")).click();

        String urlNewProduct = driver.getCurrentUrl();
        assertEquals(urlNewProduct, "http://localhost:3000/newProduct");
        timeSleep();

        driver.findElement(By.cssSelector(".btn-primary:nth-child(1)")).click();
        WebElement cardInvalid = driver.findElement(By.className("toast-title"));
        assertEquals(cardInvalid.getText(), "Erro");
        timeSleep();
        timeSleep();
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).sendKeys("Comida Japonesa ");
        timeSleep();
        timeSleep();
        driver.findElement(By.cssSelector(".btn-primary:nth-child(1)")).click();
        WebElement cardInvalid2 = driver.findElement(By.className("toast-title"));
        assertEquals(cardInvalid2.getText(), "Erro");
        timeSleep();
        timeSleep();
        driver.findElement(By.id("owner")).click();
        driver.findElement(By.id("owner")).sendKeys("Japinha");
        timeSleep();
        timeSleep();
        driver.findElement(By.cssSelector(".btn-primary:nth-child(1)")).click();
        WebElement cardInvalid3 = driver.findElement(By.className("toast-title"));
        assertEquals(cardInvalid3.getText(), "Erro");
        timeSleep();
        driver.findElement(By.id("date")).click();
        driver.findElement(By.id("date")).sendKeys("04092023");
        timeSleep();
        driver.findElement(By.cssSelector(".btn-primary:nth-child(1)")).click();
        timeSleep();
    
        timeSleep();
        WebElement cardValidProduct = driver.findElement(By.className("toast-title"));
        assertEquals(cardValidProduct.getText(), "Sucesso");
        String urlNewEventAfterCreate = driver.getCurrentUrl();
        assertEquals(urlNewEventAfterCreate, "http://localhost:3000/newEvent");
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
