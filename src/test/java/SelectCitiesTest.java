import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SelectCitiesTest {
    WebDriver driver;

    @BeforeClass
    public void signIn(){
        System.setProperty("webdriver.chrome.driver","C:\\xyz\\TestyUI\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://newtours.demoaut.com/");

        LoginPage objLoginPage=new LoginPage(driver);
        objLoginPage.login("tutorial","tutorial");
    };

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

    @AfterClass
    public void close(){
        driver.close();
    }
    }
