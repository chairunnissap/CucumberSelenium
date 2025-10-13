package automation.Scenario;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webautomation.Page_Factory.Object_Repository.LoginObjectRepository;
import com.webautomation.Page_Factory.Page.LoginPage;

public class LoginScenario {
    WebDriver driver;
    WebDriverWait wait;
    LoginObjectRepository loginPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginObjectRepository(driver);
    }

    @Test
    public void LoginScen() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.DoLogin("standard_user", "secret_sauce");
        Thread.sleep(4000);
        loginPage.ButtonLogin();
    }
}
