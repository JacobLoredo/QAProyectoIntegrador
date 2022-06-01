import org.testng.Assert;
import org.testng.annotations.*;
import pages.ContactUsPage;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.SignInPage;
import bases.BaseTest;

public class CaseTest extends BaseTest{

    /*
    * ID: Test case 1
    * Requirement reference: Req01
    * Description: Register a new user successfully
    */
    @Test(priority = 1)
    public void validateCreateNewAccount(){
        HomePage homePage = new HomePage(driver);
        homePage.clickSignIn();
        Assert.assertTrue(homePage.isSignInPage());

        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue(signInPage.isSignInPage());
        Assert.assertTrue(isEmail( signInPage.setInputEmailNew(generateEmailAccount())));
        signInPage.clickCreateAccountButton();
        waitForNSeconds(3);

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);

        Assert.assertTrue(createAccountPage.isCreateAccountPage());
        Assert.assertTrue(createAccountPage.putTitleInfo("Mr.").isSelected());

        Assert.assertFalse(createAccountPage.putFirstNameAccount("Jacob"));
        Assert.assertFalse(createAccountPage.putLastNameAccount("Loredo"));
        Assert.assertTrue(isValidPassword(createAccountPage.putPassword("12345")));
        createAccountPage.putDateHBD(27,"November ",1997);
        Assert.assertFalse(createAccountPage.putFirstName("Alejandro"));
        Assert.assertFalse(createAccountPage.putLastName("De La Rosa"));
        Assert.assertFalse(createAccountPage.putAddress("Pedernal 920"));
        Assert.assertFalse(createAccountPage.putCity("San Luis Potosi"));
        createAccountPage.putState("Mississippi");
        Assert.assertFalse(createAccountPage.putZipCode("78150"));
        Assert.assertFalse(createAccountPage.putMobilePhone("4442994241"));
        Assert.assertFalse(createAccountPage.putAliasAddress("Departamento"));
        createAccountPage.clickButtonRegister();
        waitForNSeconds(3);
        Assert.assertTrue(createAccountPage.validateCreateAccount());

    }

    /*
     * ID: Test case 2
     * Requirement reference: Req01
     * Description: Register a new user WithoutData
     */
    @Test(priority = 2)
    public void validateCreateNewAccountWithoutData(){
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.validateHomeLogoIsDisplayed());
        homePage.clickSignIn();
        waitForNSeconds(1);
        Assert.assertTrue(homePage.isSignInPage());

        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue(signInPage.isSignInPage());
        Assert.assertTrue(isEmail(signInPage.setInputEmailNew(generateEmailAccount())));
        signInPage.clickCreateAccountButton();
        waitForNSeconds(3);

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.putCountry("-");
        createAccountPage.clickButtonRegister();
        waitForNSeconds(3);
        //Check if one phone number error is present
        Assert.assertTrue(createAccountPage.checkError("You must register at least one phone number."));
        //Check if Last name error is present
        Assert.assertTrue(createAccountPage.checkError("Last name is required."));
        //Check if Firs name error is present
        Assert.assertTrue(createAccountPage.checkError("First name is required."));
        //Check if Password error is present
        Assert.assertTrue(createAccountPage.checkError("Password is required."));
        //Check if Country error is present
        Assert.assertTrue(createAccountPage.checkError("Country is required."));
        //Check if Address error is present
        Assert.assertTrue(createAccountPage.checkError("Address is required."));
        //Check if City error is present
        Assert.assertTrue(createAccountPage.checkError("City is required."));

    }

    /*
     * ID: Test case 3
     * Requirement reference: Req01
     * Description: Register a new user with email already registered
     */
    @Test(priority = 3)
    public void validateCreateNewAccountWithEmailUsed(){
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.validateHomeLogoIsDisplayed());
        homePage.clickSignIn();
        waitForNSeconds(1);
        Assert.assertTrue(homePage.isSignInPage());

        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue(signInPage.isSignInPage());
        Assert.assertTrue(isEmail(signInPage.setInputEmailNew("yeicob_loredo@hotmail.com")));
        signInPage.clickCreateAccountButton();
        waitForNSeconds(3);
        //Check if error email already registered
        Assert.assertTrue(signInPage.checkError("An account using this email address has already been registered. Please enter a valid password or request a new one."));

    }
}
