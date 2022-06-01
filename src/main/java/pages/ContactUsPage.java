package pages;

import bases.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.logging.Level;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class ContactUsPage extends BasePage {
    private final String urlPage="http://automationpractice.com/index.php?controller=contact";
    By SubjectHeading = By.xpath("//*[@name='id_contact']//descendant::option[2]");
    By inputEmail2= By.xpath("//input[@id='email']");
    By InputOrder=By.xpath("//input[@name='id_order']");
    By inputText= By.xpath(" //textarea[@name='message']");
    By submitButton=By.xpath(" //span[contains(text(),'Send')]//ancestor::button[@name='submitMessage']");

    By messageSuccess = By.xpath(" //p[contains(text(),'Your message has been successfully sent to our team.')]");
    public ContactUsPage(WebDriver driver){
        super(driver);

    }
    public void goToContactUsPage(WebDriver driver){
        driver.navigate().to(urlPage);
    }
    public boolean isContactUsPage(){
        LOGGER.log(Level.INFO, "Init isContactUsPage function");
        WebElement isContactUsPage= driver.findElement(By.xpath("//h1[contains(text(),'Customer service - Contact us')]"));
        return isContactUsPage.isDisplayed();
    }
    public String choiceSubjectHeading(){

        WebElement SubjectHeading =driver.findElement(this.SubjectHeading);
        SubjectHeading.click();
        LOGGER.log(Level.INFO, SubjectHeading.getText());
        return SubjectHeading.getText();

    }
    public WebElement putAddressEmail(String Address){

        //*Firs option take all de inputs after Email address (take 8 inputs)*/
        //WebElement inputEmail= this.driver.findElement(By.xpath("//label[contains(text(),'Email address')]//following::input[1]"));
        //*Second option*/

        WebElement inputEmail2= driver.findElement(this.inputEmail2);
        LOGGER.log(Level.INFO, "Put email value");
        inputEmail2.sendKeys(Address);
        return inputEmail2;
        //Assert.assertTrue(isEmail(inputEmail2));

    }
    public Boolean putOrderReference(String RandomNumber){

        WebElement inputOrderReference=driver.findElement(this.InputOrder);
        LOGGER.log(Level.INFO, "Put Order Reference value");
        inputOrderReference.sendKeys(RandomNumber);
        LOGGER.log(Level.INFO, inputOrderReference.getAttribute("value"));
        //*Check if the inputOrderReference get value*/
        return inputOrderReference.getAttribute("value").isEmpty();
    }
    public boolean putMessage(String Message){
        LOGGER.log(Level.INFO, "Message test");
        WebElement inputMessage= driver.findElement(this.inputText);
        inputMessage.sendKeys(Message);
        //*Check if the inputOrderReference get value*/
        return inputMessage.getAttribute("value").isEmpty();
    }
    public void clickSubmit(){
        LOGGER.log(Level.INFO, "Click button submit");
        WebElement buttonSubmit= driver.findElement(this.submitButton);
        buttonSubmit.click();
    }
    public boolean validateSendEmail(){
        LOGGER.log(Level.INFO, "Validate success message");
        WebElement messageSuccess= driver.findElement(this.messageSuccess);
        return messageSuccess.isDisplayed();

    }

}
