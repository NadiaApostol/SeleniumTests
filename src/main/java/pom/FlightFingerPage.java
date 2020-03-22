package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightFingerPage {
    WebDriver driver;

    @FindBy(xpath = "//img[@src='/images/masts/mast_flightfinder.gif']")
    private WebElement imgFlightFinger;

    @FindBy(name = "fromPort")
    private WebElement fromPort;

    @FindBy(name = "toPort")
    private WebElement toPort;

    @FindBy(name = "findFlights")
    public WebElement findFlights;

    public FlightFingerPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean displayedImgFlightFinger() {

        return imgFlightFinger.isDisplayed();
    }

    public void selectCities(String cityFrom, String cityTo){
        Select fromPort = new Select(this.fromPort);
        fromPort.selectByVisibleText(cityFrom);
        Select toPort = new Select(this.toPort);
        toPort.selectByVisibleText(cityTo);
        findFlights.click();
    }


}
