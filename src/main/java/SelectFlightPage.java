import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectFlightPage {
    WebDriver driver;

    public SelectFlightPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//img[@src='/images/masts/mast_selectflight.gif']")
    WebElement imgSelectFlight;

    @FindBy(xpath = "//td[@class='title']//font[@face='ARIAL'][1]")
    WebElement fromCityToCity;

    public String getTextCityToCity(){
        return fromCityToCity.getText();
    }
}
