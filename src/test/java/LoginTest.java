import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {
    @Test
    public void login(){
        System.setProperty("webdriver.chrome.driver", "C:\\xyz\\TestyUI\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://newtours.demoaut.com/");

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.login("tutorial", "tutorial");

        FlightFingerPage objFlightFingerPage = new FlightFingerPage(driver);
        assert objFlightFingerPage.displayedImgFlightFinger();
        driver.close();

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

    @Test(dataProvider = "LoginNegative")
    public void negativeLogin(String login, String password){
        System.setProperty("webdriver.chrome.driver", "C:\\xyz\\TestyUI\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://newtours.demoaut.com/");

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.login(login, password);

        WebElement signOn = driver.findElement(By.xpath("//img[@src='/images/masts/mast_signon.gif']"));
        assert signOn.isDisplayed();
        driver.close();

    }
}
