import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(name="userName")
    WebElement userName;

    @FindBy(name="password")
    WebElement Password;

    @FindBy(name="login")
    WebElement signIn;

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
