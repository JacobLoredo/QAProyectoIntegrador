package pages;

import bases.BasePage;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class CreateAccountPage extends BasePage {

    By titleCreateAccount = By.xpath("//h3[contains(text(),'Your personal information')]");
    By errorList= By.xpath("//div[@class='alert alert-danger']/ol/child::li");
    By genderInputs = By.xpath("//input[@name='id_gender']");
    By inputFirstNameCustomer = By.xpath("//input[@name='customer_firstname']");
    By inputLastNameCustomer = By.xpath("//input[@name='customer_lastname']");
    By inputPassword = By.xpath("//input[@type='password']");
    By inputDay = By.xpath("//select[@name='days']");
    By inputMonth = By.xpath("//select[@name='months']");
    By inputYear = By.xpath("//select[@name='years']");
    By inputFirstName = By.xpath("//input[@name='firstname']");
    By inputLastName = By.xpath("//input[@name='lastname']");
    By inputAddress = By.xpath("//input[@name='address1']");
    By inputCity = By.xpath("//input[@name='city']");
    By inputState = By.xpath("//select[@name='id_state']");
    By inputZip = By.xpath("//input[@name='postcode']");
    By inputCountry = By.xpath("//select[@name='id_country']");
    By inputMobilePhone = By.xpath("//input[@name='phone_mobile']");
    By inputAliasAddress = By.xpath("//input[@name='alias']");
    By buttonRegister = By.xpath("//button[@name='submitAccount']");
    By registerSuccess= By.xpath("//p[contains(text(),'Welcome to your account. Here you can manage all of your personal information and orders.')]");

    public CreateAccountPage(WebDriver driver){
        super(driver);
    }
    public boolean isCreateAccountPage(){
        LOGGER.log(Level.INFO, "init isCreateAccountPage");
        WebElement CreateAccountPage = driver.findElement(this.titleCreateAccount);
        return CreateAccountPage.isDisplayed();
    }
    public WebElement putTitleInfo(@NotNull String gender){
        LOGGER.log(Level.INFO, "init putTitleInfo");
        List<WebElement> genderOptions = driver.findElements(this.genderInputs);
        String value = (gender.equals("Mr."))?"1":(gender.equals("Mrs."))?"2":"0";
        int selected=0;
        for(int i=0;i<genderOptions.size();i++){
            if(genderOptions.get(i).getAttribute("value").equals(value)){
                selected=i;
                genderOptions.get(i).click();
                LOGGER.log(Level.INFO, "option selected: "+genderOptions.get(i));
                break;
            }
        }
        return genderOptions.get(selected);
    }

    public Boolean putFirstNameAccount(String Fname){
        LOGGER.log(Level.INFO, "init putFirstName");
        WebElement firstName = driver.findElement(this.inputFirstNameCustomer);
        firstName.sendKeys(Fname);

        return firstName.getAttribute("value").isEmpty();

    }
    public Boolean putLastNameAccount(String Lname){
        LOGGER.log(Level.INFO, "init inputLastName");
        WebElement LastName = driver.findElement(this.inputLastNameCustomer);
        LastName.sendKeys(Lname);

        return LastName.getAttribute("value").isEmpty();

    }

    public void putEmail(String Email){

    }
    public String putPassword(String password){
        LOGGER.log(Level.INFO, "init putPassword");
        WebElement inputPassword = driver.findElement(this.inputPassword);
        inputPassword.sendKeys(password);
        return inputPassword.getAttribute("value").toString();
    }
    public void putDateHBD(int day, String month, int year){
        Select dayDropdown = new Select(driver.findElement(this.inputDay));
        dayDropdown.selectByValue(String.valueOf(day));

        Select monthDropdown = new Select(driver.findElement(this.inputMonth));
        monthDropdown.selectByVisibleText(month);

        Select yearDropdown = new Select(driver.findElement(this.inputYear));
        yearDropdown.selectByValue(String.valueOf(year));

    }

    public Boolean putFirstName(String Fname){
        LOGGER.log(Level.INFO, "init putFirstName");
        WebElement firstName = driver.findElement(this.inputFirstName);
        firstName.sendKeys(Fname);
        return firstName.getAttribute("value").isEmpty();

    }

    public Boolean putLastName(String Lname){
        LOGGER.log(Level.INFO, "init putLastName");
        WebElement LastName = driver.findElement(this.inputLastName);
        LastName.sendKeys(Lname);

        return LastName.getAttribute("value").isEmpty();
    }

    public Boolean putAddress(String address){
        LOGGER.log(Level.INFO, "init putAddress");
        WebElement Address = driver.findElement(this.inputAddress);
        Address.sendKeys(address);

        return Address.getAttribute("value").isEmpty();
    }

    public Boolean putCity(String city){
        LOGGER.log(Level.INFO, "init putCity");
        WebElement City = driver.findElement(this.inputCity);
        City.sendKeys(city);

        return City.getAttribute("value").isEmpty();
    }
    public void putState(String state){
        Select stateDropdown = new Select(driver.findElement(this.inputState));
        stateDropdown.selectByVisibleText(state);

    }
    public Boolean putZipCode(String code){
        LOGGER.log(Level.INFO, "init putCity");
        WebElement ZipCode = driver.findElement(this.inputZip);
        ZipCode.sendKeys(code);

        return ZipCode.getAttribute("value").isEmpty();
    }
    public Boolean putMobilePhone(String phone){
        LOGGER.log(Level.INFO, "init putMobilePhone");
        WebElement MobilePhone = driver.findElement(this.inputMobilePhone);
        MobilePhone.sendKeys(phone);

        return MobilePhone.getAttribute("value").isEmpty();
    }
    public Boolean putAliasAddress(String alias){
        LOGGER.log(Level.INFO, "init putAliasAddress");
        WebElement AliasAddress = driver.findElement(this.inputAliasAddress);
        AliasAddress.sendKeys(alias);

        return AliasAddress.getAttribute("value").isEmpty();
    }
    public void clickButtonRegister(){
        LOGGER.log(Level.INFO, "init clickButtonRegister");
        WebElement buttonR = driver.findElement(this.buttonRegister);
        buttonR.click();
    }
    public boolean validateCreateAccount(){
        LOGGER.log(Level.INFO, "init validateCreateAccount");
        WebElement messageSuccess = driver.findElement(this.registerSuccess);
        return  messageSuccess.isDisplayed();
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
    public void putCountry(String Country){
        Select countryDropdown = new Select(driver.findElement(this.inputCountry));
        countryDropdown.selectByVisibleText(Country);

    }
}
