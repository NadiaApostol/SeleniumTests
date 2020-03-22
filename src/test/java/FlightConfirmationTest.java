import org.testng.Assert;
import org.testng.annotations.Test;
import pom.*;

public class FlightConfirmationTest extends BaseTest{

    @Test
    public void verifyPaymentDetails() {

        SelectFlightPage objSelectFlightPage = new SelectFlightPage(driver);
        FlightFingerPage objFlightFingerPage = new FlightFingerPage(driver);
        BookAflightPage objBookAflightPage = new BookAflightPage(driver);
        FlightConfirmationPage objFlightConfirmationPage = new FlightConfirmationPage(driver);

        objFlightFingerPage.findFlights.click();
        assert objSelectFlightPage.selectPageDisplayed();

        objSelectFlightPage.buttonContinue.click();
        assert objBookAflightPage.pageDisplayed();

        String textDataForm = objBookAflightPage.fillInForm("Nadia", "Apostol");
        assert objFlightConfirmationPage.pageFlightConfirmationDisplayed();

        Assert.assertEquals(textDataForm, objFlightConfirmationPage.getTextInformationBilledTo());

    }

}
