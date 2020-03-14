package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(xpath = "//input[@type='radio']")
    List<WebElement> selectFlightRadioButtons;

    @FindBy(xpath = "//td[@class='data_verb_xcols']//font//b")
    List<WebElement> selectFlightPrices;

    @FindBy(name="reserveFlights")
    public WebElement buttonContinue;

    public BookAflightPage continueTo(){
        buttonContinue.click();
        return new BookAflightPage(driver);
    }

    public String getTextCityToCity(){
        return fromCityToCity.getText();
    }

    public int getFlightOption(int i){
        selectFlightRadioButtons.get(i).click();
        String price = selectFlightPrices.get(i).getText();
        int index = price.indexOf("$");
        String amount = price.substring(index + 1);
        int amountNumber = Integer.parseInt(amount);
        return amountNumber;
    }
}
