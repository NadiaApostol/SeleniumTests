package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightConfirmationPage {
    WebDriver driver;

    @FindBy(xpath = "//img[@src='/images/masts/mast_confirmation.gif']")
    WebElement imgFlightConfirmation;

    @FindBy(xpath = "(//font[@face='Arial, Helvetica, sans-serif, Verdana'])[8]")
    WebElement billedTo;

    public FlightConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean pageFlightConfirmationDisplayed(){

        return imgFlightConfirmation.isDisplayed();
    }

    public String getTextInformationBilledTo(){
        System.out.println(billedTo.getText());
        return billedTo.getText().replaceAll("[\\n\\t ]", "");
    }
}
