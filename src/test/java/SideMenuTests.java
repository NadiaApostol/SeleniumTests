import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pom.LoginPage;


public class SideMenuTests {
    WebDriver driver;
    LoginPage objLoginPage;

    @BeforeClass
    public void signIn() {
        System.setProperty("webdriver.chrome.driver", "C:\\xyz\\TestyUI\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://newtours.demoaut.com/");

        objLoginPage = new LoginPage(driver);
        objLoginPage.login("tutorial", "tutorial");
    }

    @Test
    public void verifySideMenuItems() {
        String[] nameSideMenuItems = new String[]{
                "Home",
                "Flights",
                "Hotels",
                "Car Rentals",
                "Cruises",
                "Destinations",
                "Vacations"};

        for (int i = 0; i < (nameSideMenuItems.length); i++) {
            Assert.assertEquals(objLoginPage.sideMenuItems.get(i).getText(), nameSideMenuItems[i]);
        }
    }

    @Test
    public void navigationSideMenu() {
        String baseUrl = "http://newtours.demoaut.com/";
        String[] navigationSideMenuUrl = new String[]{
                "mercurywelcome.php",
                "mercuryreservation.php",
                "mercuryunderconst.php",
                "mercuryunderconst.php",
                "mercurycruise.php",
                "mercuryunderconst.php",
                "mercuryunderconst.php"};

        for (int i = 0; i < (navigationSideMenuUrl.length); i++) {
            driver.get("http://newtours.demoaut.com/");
            objLoginPage.sideMenuItems.get(i).click();

            Assert.assertEquals(driver.getCurrentUrl(), baseUrl + navigationSideMenuUrl[i]);
        }
    }

    @AfterClass
    public void close() {
        driver.close();
    }

}
