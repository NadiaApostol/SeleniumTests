import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import sun.security.util.Password;

public class FlightFingerPage {
    WebDriver driver;

    @FindBy(xpath = "//img[@src='/images/masts/mast_flightfinder.gif']")
    WebElement imgFlightFinger;

    public FlightFingerPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean displayedImgFlightFinger() {
        return imgFlightFinger.isDisplayed();
    }

    @FindBy(xpath = "(//input[@name='tripType'])[1]")
    WebElement raundTripType;

    @FindBy(xpath = "(//input[@name='tripType'])[2]")
    WebElement oneWayTripType;

    @FindBy(name = "fromPort")
    WebElement fromPort;

    @FindBy(name = "fromMonth")
    WebElement fromMonth;

    @FindBy(name = "fromDay")
    WebElement fromDay;

    @FindBy(name = "toPort")
    WebElement toPort;

    @FindBy(name = "toMonth")
    WebElement toMonth;

    @FindBy(name = "toDay")
    WebElement toDay;

    @FindBy(xpath = "(//input[@name='servClass'])[1]")
    WebElement economyServClass;

    @FindBy(xpath = "(//input[@name='servClass'])[2]")
    WebElement businessServClass;

    @FindBy(xpath = "(//input[@name='servClass'])[3]")
    WebElement firstServClass;

    @FindBy(name = "airline")
    WebElement airline;

    @FindBy(name = "findFlights")
    WebElement findFlights;

    public void selectCities(String cityFrom, String cityTo){
        Select fromPort = new Select(this.fromPort);
        fromPort.selectByVisibleText(cityFrom);
        Select toPort = new Select(this.toPort);
        toPort.selectByVisibleText(cityTo);
        findFlights.click();
    }


}
