package pages;

import bases.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class MyAccountPage extends BasePage {
    By titleMyAccountPage = By.xpath("//h1[contains(text(),'My account')]");
    public MyAccountPage(WebDriver driver){
        super(driver);
    }

    public Boolean isMyAccountPage(){
        LOGGER.log(Level.INFO, "isSignPage");
        WebElement isSignInPage= driver.findElement(this.titleMyAccountPage);
        return isSignInPage.isDisplayed();
    }
}
