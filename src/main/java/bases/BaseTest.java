package bases;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Random;
import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class BaseTest {
    public WebDriver driver;
    private String urlPage="http://automationpractice.com/index.php";
    private String urlChrome="drivers/chromedriver.exe";

    public String getUrlPage() {
        return urlPage;
    }

    public void setUrlPage(String urlPage) {
        this.urlPage = urlPage;
    }

    public String getUrlChrome() {
        return urlChrome;
    }

    public void setUrlChrome(String urlChrome) {
        this.urlChrome = urlChrome;
    }

    public String getUrlEdge() {
        return urlEdge;
    }

    public void setUrlEdge(String urlEdge) {
        this.urlEdge = urlEdge;
    }

    private String urlEdge="drivers/msedgedriver.exe";



    public WebDriver chromeDriverConnection(){
        System.setProperty("webdriver.chrome.driver", urlChrome);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
    public WebDriver edgeDriverConnection(){
        System.setProperty("webdriver.edge.driver",urlEdge);
        driver =  new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }
    @BeforeTest
    public void setUp(){
        LOGGER.log(Level.INFO, "Init setUP");
        chromeDriverConnection();
        //edgeDriverConnection();
        driver.navigate().to(urlPage);
    }
    @AfterTest
    public void tearDown(){
        LOGGER.log(Level.INFO, "Init close");
        driver.close();
        LOGGER.log(Level.INFO, "Init quit");
        driver.quit();
    }
    public void waitForNSeconds(int secs){
        try {
            Thread.sleep(secs*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public boolean isEmail(WebElement email){
        boolean isEmail;
        isEmail=email.getAttribute("value").matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        return isEmail;
    }
    public String generateRandomNumber(){
        int min = 1;
        int max = 1458650;
        Random random = new Random();
        int value = random.nextInt(max + min) + min;
        return String.valueOf(value);
    }
    public boolean isValidPassword(String password){
        return password.length()>=5;
    }

    public String generateEmailAccount(){
        String email ="pruebaQA"+generateRandomNumber()+"@hotmail.com";
        return email;
    }
}
