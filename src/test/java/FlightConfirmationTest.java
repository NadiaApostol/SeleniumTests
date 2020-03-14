import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pom.*;

public class FlightConfirmationTest {
    WebDriver driver;
    LoginPage objLoginPage;

    @BeforeClass
    public void signIn() {
        System.setProperty("webdriver.chrome.driver", "C:\\xyz\\TestyUI\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://newtours.demoaut.com/");

        objLoginPage = new LoginPage(driver);
        objLoginPage.login("tutorial", "tutorial");
    }

    @Test
    public void verifyPaymentDetails() {

        SelectFlightPage objSelectFlightPage = new SelectFlightPage(driver);
        FlightFingerPage objFlightFingerPage = new FlightFingerPage(driver);
        BookAflightPage objBookAflightPage = new BookAflightPage(driver);
        FlightConfirmationPage objFlightConfirmationPage = new FlightConfirmationPage(driver);

        objFlightFingerPage.findFlights.click();
        objSelectFlightPage.buttonContinue.click();

        String textDataForm = objBookAflightPage.fillInForm("Nadia", "Apostol");
        assert objFlightConfirmationPage.pageFlightConfirmationDisplayed();
        Assert.assertEquals(textDataForm, objFlightConfirmationPage.getTextInformationBilledTo());

    }

    @AfterClass
    public void close() {
        driver.close();
    }

}
