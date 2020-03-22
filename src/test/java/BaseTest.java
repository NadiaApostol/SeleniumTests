import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pom.LoginPage;

public class BaseTest {
    WebDriver driver;
    LoginPage objLoginPage;

    @BeforeClass
    public void signIn(){
        System.setProperty("webdriver.chrome.driver","C:\\xyz\\TestyUI\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://newtours.demoaut.com/");

        objLoginPage = new LoginPage(driver);
        objLoginPage.login("tutorial","tutorial");
    }

    @AfterClass
    public void close(){
        driver.quit();
    }
}
