package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookAflightPage {
    WebDriver driver;

    public BookAflightPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@src='/images/masts/mast_book.gif']")
    WebElement imgBookAflight;

    @FindBy(xpath = "(//*[contains(text(),'$')])[1]")
    WebElement taxes;

    @FindBy(xpath = "(//*[contains(text(),'$')])[2]")
    WebElement totalPrice;

    @FindBy(name = "cc_frst_name")
    WebElement firstName;

    @FindBy(name = "cc_last_name")
    WebElement lastName;

    @FindBy(name = "billAddress1")
    WebElement address;

    @FindBy(name = "billCity")
    WebElement city;

    @FindBy(name = "billState")
    WebElement stateProvince;

    @FindBy(name = "billZip")
    WebElement postalCode;

    @FindBy(name = "buyFlights")
    WebElement buyFlight;

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

        int indexTaxes = textTaxes.indexOf("$");
        String textAmountTaxes = textTaxes.substring(indexTaxes + 1);
        int taxesNumber = Integer.parseInt(textAmountTaxes);

        System.out.println(taxesNumber);
        String textTotalPrice = totalPrice.getText();
        System.out.println(textTotalPrice);

        int indexTotalPrice = textTotalPrice.indexOf("$");
        System.out.println(indexTotalPrice);

        String textAmountTotalPrice = textTotalPrice.substring(indexTotalPrice + 1);
        int totalPriceNumber = Integer.parseInt(textAmountTotalPrice);
        System.out.println(totalPriceNumber);

        return totalPriceNumber - taxesNumber;
    }
}
