package pages;

import bases.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class SignInPage extends BasePage {
    By titleSignInPage = By.xpath("//h3[contains(text(),'Create an account')]");
    By inputEmailNew = By.xpath("//input[@name='email_create']");
    By inputEmailRegistered = By.xpath("//input[@name='email']");
    By inputPassword = By.xpath("//input[@name='passwd']");
    By createAccountButton = By.xpath("//button[@id='SubmitCreate']");
    By submitLoginButton = By.xpath("//button[@id='SubmitLogin']");
    By errorList= By.xpath("//div[@class='alert alert-danger']/ol/child::li");

    public SignInPage(WebDriver driver){
        super(driver);
    }
    public Boolean isSignInPage(){
        LOGGER.log(Level.INFO, "isSignPage");
        WebElement isSignInPage= driver.findElement(this.titleSignInPage);
        return isSignInPage.isDisplayed();
    }
    public WebElement setInputEmailNew(String Email){
        LOGGER.log(Level.INFO, "Put email value");
        WebElement inputEmailNew= driver.findElement(this.inputEmailNew);
        inputEmailNew.sendKeys(Email);
        return inputEmailNew;
    }
    public WebElement setInputEmailRegistered(String Email){
        LOGGER.log(Level.INFO, "Put EmailRegistered value");
        WebElement inputEmailRegistered= driver.findElement(this.inputEmailRegistered);
        inputEmailRegistered.sendKeys(Email);
        return inputEmailRegistered;
    }
    public void clickCreateAccountButton(){
        WebElement CreateAccountButton= driver.findElement(this.createAccountButton);
        CreateAccountButton.click();
    }
    public void clickInitSessionButton(){
        WebElement SessionButton= driver.findElement(this.submitLoginButton);
        SessionButton.click();
    }
    public boolean checkError(String Error){
        List<WebElement> errorsList = driver.findElements(this.errorList);
        boolean isError=false;
        LOGGER.log(Level.INFO, "check Error: "+Error);
        for(int i=0;i<errorsList.size();i++){

            if(errorsList.get(i).getText().contains(Error)){
                isError=true;
                LOGGER.log(Level.INFO, "option selected: "+errorsList.get(i).getText());
                break;
            }
        }
        return isError;
    }
    public String putPassword(String password){
        LOGGER.log(Level.INFO, "init putPassword");
        WebElement inputPassword = driver.findElement(this.inputPassword);
        inputPassword.sendKeys(password);
        return inputPassword.getAttribute("value").toString();
    }

}
