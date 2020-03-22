import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;
import pom.FlightFingerPage;
import pom.LoginPage;

public class LoginTest {
    private WebDriver driver;
    private LoginPage objLoginPage;

    @BeforeMethod
    public void signIn() {
        System.setProperty("webdriver.chrome.driver", "C:\\xyz\\TestyUI\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://newtours.demoaut.com/");
        objLoginPage = new LoginPage(driver);
    }

    @Test(priority = 0, description="Pass Login Scenario with true username and password")
   // @Description("Test Description: Login test with true username and true password")
    public void login(){

        objLoginPage.login("tutorial", "tutorial");

        FlightFingerPage objFlightFingerPage = new FlightFingerPage(driver);
        assert objFlightFingerPage.displayedImgFlightFinger();
    }

    @DataProvider(name = "LoginNegative")
    public Object[][] dataProvider() {
        return new Object[][] {
                { "tutorial", "111" },
                { "123", "tutorial" },
                { "test", "test" },
                { "test3", "test3" }
        };

    }
    @Test(dataProvider = "LoginNegative", priority = 0, description="Invalid Login Scenario with wrong username and password")
    @Description("Login test with wrong username and wrong password")
    public void negativeLogin(String login, String password){

        objLoginPage.login(login, password);
// Element is called directly without pom because it is single element from this page.
        WebElement signOn = driver.findElement(By.xpath("//img[@src='/images/masts/mast_signon.gif']"));
        assert signOn.isDisplayed();
    }
    @AfterMethod
    public void close(){
        driver.quit();
    }
}
