package pom;

import helpers.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookAflightPage {
    WebDriver driver;

    @FindBy(xpath = "//img[@src='/images/masts/mast_book.gif']")
    private WebElement imgBookAflight;

    @FindBy(xpath = "(//*[contains(text(),'$')])[1]")
    private WebElement taxes;

    @FindBy(xpath = "(//*[contains(text(),'$')])[2]")
    private WebElement totalPrice;

    @FindBy(name = "cc_frst_name")
    private WebElement firstName;

    @FindBy(name = "cc_last_name")
    private WebElement lastName;

    @FindBy(name = "billAddress1")
    private WebElement address;

    @FindBy(name = "billCity")
    private WebElement city;

    @FindBy(name = "billState")
    private WebElement stateProvince;

    @FindBy(name = "billZip")
    private WebElement postalCode;

    @FindBy(name = "buyFlights")
    private WebElement buyFlight;

    public BookAflightPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean pageDisplayed(){

        return imgBookAflight.isDisplayed();
    }

    public String fillInForm(String parFirstName, String parLastName) {
        firstName.sendKeys(parFirstName);
        lastName.sendKeys(parLastName);
        String addressText = address.getAttribute("value");
        String cityText = city.getAttribute("value");
        String province = stateProvince.getAttribute("value");
        String code = postalCode.getAttribute("value");
        buyFlight.click();
        System.out.println(parFirstName + " " + parLastName + " " + addressText + " " + cityText + ", " + province + ", " + code);
        return (parFirstName + parLastName + addressText + cityText + "," + province + "," + code).replaceAll(" ", "");
    }

    public int getNetPrice() {
        String textTaxes = taxes.getText();
        int taxesNumber = Helper.getAmoundFromText(textTaxes);

        String textTotalPrice = totalPrice.getText();
        int totalPriceNumber = Helper.getAmoundFromText(textTotalPrice);

        return totalPriceNumber - taxesNumber;
    }
}
