package br.edu.ifpb.dac.alysense.alysense.SystemTestNew.PageObjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CreateEventMapping {
    private WebDriver driver;

    @FindBy(how = How.CSS, using = "div.App div.nav-bar nav.navbar.navbar-expand-lg.navbar-dark.bg-primary div.container-fluid div.collapse.navbar-collapse ul.navbar-nav.me-auto li.nav-item:nth-child(2) > a.nav-link")
    private WebElement navBarCreateEvent;
    
    @FindBy(how = How.CSS, using = "div.App div.event-create header.EventCreate-header div.main-container div.big-form > h1.title:nth-child(1)")
    private WebElement textTitle;

    @FindBy(how = How.CSS, using = "#inputTitulo")
    private WebElement inputTitle;

    @FindBy(how = How.CSS, using = "#inputLocal")
    private WebElement inputLocal;

    @FindBy(how = How.CSS, using = "#inputDate")
    private WebElement inputDate;

    @FindBy(how = How.CSS, using = "#inputParticipants")
    private WebElement inputPaticipants;

    @FindBy(how = How.CSS, using = "#inputSamples")  
    private WebElement inputSamples;

    @FindBy(how = How.CSS, using = "#minimunAge")  
    private WebElement inputMinimunAge;

    @FindBy(how = How.XPATH, using = "(//*[@id='HEDONIC_FACIAL'])") 
    private WebElement inputTypeScale;

    @FindBy(how = How.CSS, using = ".btn-primary:nth-child(1)")
    private WebElement btnCreateEvent;

    public CreateEventMapping(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickNavBarCreateEvent(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", this.navBarCreateEvent);
    }

    public String textTitle(){
        return this.textTitle.getText();
    }

    public void inputTitle(String title){
        this.inputTitle.sendKeys(title);
    }

    public void inputLocal(String local){
        this.inputLocal.sendKeys(local);
    }

    public void inputDate(String date){
        this.inputDate.sendKeys(date);
    }

    public void inputPaticipants(String qtdParticipants){
        this.inputPaticipants.clear();
        this.inputPaticipants.sendKeys(qtdParticipants);
    }

    public void inputSamples(String qtdSamples){
        this.inputSamples.clear();
        this.inputSamples.sendKeys(qtdSamples);
    }

    public void inputAge(String minimunAge){
        this.inputMinimunAge.clear();
        this.inputMinimunAge.sendKeys(minimunAge);
    }

    public void inputTypeScale(){
        this.inputTypeScale.click();
    }

    public void clickCreateEvent(){
        this.btnCreateEvent.click();
    }
    
}
