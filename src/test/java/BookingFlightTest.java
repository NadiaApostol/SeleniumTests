import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pom.BookAflightPage;
import pom.FlightFingerPage;
import pom.SelectFlightPage;

public class BookingFlightTest extends BaseTest {

    @DataProvider(name = "selectCities")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"New York", "Acapulco"},
                {"Acapulco", "London"},
                {"Frankfurt", "Paris"},
                {"Paris", "Zurich"}
        };
    }

    @Test(dataProvider = "selectCities")
    public void selectCities(String cityFrom, String cityTo ){
        driver.get("http://newtours.demoaut.com/mercuryreservation.php");

        FlightFingerPage objFlightFingerPage = new FlightFingerPage(driver);
        objFlightFingerPage.selectCities(cityFrom, cityTo);

         SelectFlightPage objSelectFlightPage = new SelectFlightPage(driver);
        Assert.assertEquals(objSelectFlightPage.getTextCityToCity(),cityFrom +" to "+ cityTo);

    }

    @Test
    public void verifyTotalPrice(){
        driver.get("http://newtours.demoaut.com/mercuryreservation.php");

        SelectFlightPage objSelectFlightPage = new SelectFlightPage(driver);
        FlightFingerPage objFlightFingerPage = new FlightFingerPage(driver);

        objFlightFingerPage.findFlights.click();

        int totalPrice = objSelectFlightPage.getFlightOption(1) + objSelectFlightPage.getFlightOption(5);
        BookAflightPage objBookAflightPage = objSelectFlightPage.continueTo();
        Assert.assertEquals(objBookAflightPage.getNetPrice(), totalPrice);

    }

    }
