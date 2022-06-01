package pages;
import bases.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class HomePage extends BasePage {
    By contactUsPage = By.xpath("//h1[contains(text(),'Customer service - Contact us')]");
    By signInPage = By.xpath("//h1[contains(text(),'Authentication')]");
    By signInButton = By.xpath(" //a[contains(text(),'Sign in')]");

    public HomePage(WebDriver driver){
        super(driver);
    }
    public boolean validateHomeLogoIsDisplayed(){
        WebElement home_sales_logo = driver.findElement(By.xpath("//div[@id='homepage-slider']"));
        return home_sales_logo.isDisplayed();
    }

    public void clickContactUs(){
        WebElement aContactUs= driver.findElement(By.xpath(" //a[contains(text(),'Contact us')]"));
        LOGGER.log(Level.INFO, "Click to ContactUs");
        aContactUs.click();
    }
    public boolean isContactUsPage(){
        LOGGER.log(Level.INFO, "Init isContactUsPage function");
        WebElement isContactUsPage= driver.findElement(this.contactUsPage);
        return isContactUsPage.isDisplayed();
    }

    public void clickSignIn(){
        WebElement signIn= driver.findElement(this.signInButton);
        LOGGER.log(Level.INFO, "Click to signIn");
        signIn.click();
    }

    public boolean isSignInPage(){
        LOGGER.log(Level.INFO, "Init isSignInPage function");
        WebElement isSignInPage= driver.findElement(this.signInPage);
        return isSignInPage.isDisplayed();
    }
}
