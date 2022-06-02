package pages;
import bases.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import org.openqa.selenium.interactions.*;
public class HomePage extends BasePage {
    By contactUsPage = By.xpath("//h1[contains(text(),'Customer service - Contact us')]");
    By signInPage = By.xpath("//h1[contains(text(),'Authentication')]");
    By signInButton = By.xpath(" //a[contains(text(),'Sign in')]");
    String popularProductsFirts="//div[@class='tab-content']/ul[@id='homefeatured']/child::li/div/div[2]/h5/a[contains(text(),'";
    String popularProductsSecond="')]//parent::h5//parent::div//div[2]//a[@title='Add to cart']";
    String popularProductsForAction="//parent::div//parent::div//parent::div//parent::li";
    By modalItemAdd=By.xpath("//div[@id='layer_cart']");
    By closeModal=By.xpath("//span[@class='continue btn btn-default button exclusive-medium']");
    By quantityItemsCart= By.xpath("//span[@class='ajax_cart_quantity unvisible']x  ");
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
    public Boolean addProductCart(String itemName){
        String itemXpath = popularProductsFirts+itemName+popularProductsSecond;

        WebElement  containerItem = driver.findElement(By.xpath(itemXpath+this.popularProductsForAction));
        Actions actions = new Actions(driver);

        actions.moveToElement(containerItem);
        By byProductsPopular = By.xpath(itemXpath);
        WebElement productBuyButton= driver.findElement(byProductsPopular);
        actions.moveToElement(productBuyButton);
        actions.click().build().perform();
        return productBuyButton.isEnabled();

    }
    public void closeLayerCart(){
        WebElement closeButton = driver.findElement(this.closeModal);
        closeButton.click();


    }
    public Boolean isLayerCartVisible(){
        WebElement modalProductAdded = driver.findElement(this.modalItemAdd);
        return modalProductAdded.isDisplayed();
    }
    public int quantityItemsCart(){
        WebElement quantityItems=driver.findElement(this.quantityItemsCart);
        return  Integer.parseInt(quantityItems.getText());
    }
}
