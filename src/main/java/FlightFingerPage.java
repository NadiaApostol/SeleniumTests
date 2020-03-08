import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
}
