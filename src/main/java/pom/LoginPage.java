package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {
    WebDriver driver;

    @FindBy(name="userName")
    private WebElement userName;

    @FindBy(name="password")
    private WebElement Password;

    @FindBy(name="login")
    private WebElement signIn;

    @FindBy(xpath = "//table[@align='center']//table//a")
    public List<WebElement> sideMenuItems;

    public void login(String login, String password){
        userName.sendKeys(login);
        Password.sendKeys(password);
        signIn.click();
    }
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
}
