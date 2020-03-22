package pom;

import helpers.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SelectFlightPage {
    WebDriver driver;

    @FindBy(xpath = "//img[@src='/images/masts/mast_selectflight.gif']")
    private WebElement imgSelectFlight;

    @FindBy(xpath = "//td[@class='title']//font[@face='ARIAL'][1]")
    private WebElement fromCityToCity;

    @FindBy(xpath = "//input[@type='radio']")
    private List<WebElement> selectFlightRadioButtons;

    @FindBy(xpath = "//td[@class='data_verb_xcols']//font//b")
    private List<WebElement> selectFlightPrices;

    @FindBy(name="reserveFlights")
    public WebElement buttonContinue;

    public SelectFlightPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
     public boolean selectPageDisplayed(){
        return imgSelectFlight.isDisplayed();
     }

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
        return  Helper.getAmoundFromText(price);
    }
}
