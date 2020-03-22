import org.testng.Assert;
import org.testng.annotations.Test;

public class SideMenuTests extends BaseTest{

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

}
