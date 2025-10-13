package automation.Scenario;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webautomation.Page_Factory.Object_Repository.LoginObjectRepository;
import com.webautomation.Page_Factory.Page.CartPage;
import com.webautomation.Page_Factory.Page.DashboardPage;
import com.webautomation.Page_Factory.Page.LoginPage;

public class VerifyScenario {
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
    public void verifyScenario() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.DoLogin("standard_user", "secret_sauce");
        Thread.sleep(4000);
        loginPage.ButtonLogin();

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.AddToCart("Sauce Labs Backpack","$7.99");
        Thread.sleep(4000);

        CartPage cartPage = new CartPage(driver);
        cartPage.GoToCart();
        Assert.assertTrue(cartPage.VerifyName("Sauce Labs Backpack").isDisplayed());
        Assert.assertTrue(cartPage.VerifyPrice("$7.99").isDisplayed());
        Assert.assertTrue(cartPage.VerifyQty("1").isDisplayed());
        Assert.assertTrue(
            cartPage.VerifyName("Sauce Labs Backpack").getText().contains("Sauce Labs Backpack"),
            "Sauce Labs Backpack tidak ditemukan di cart!"
        );
        Assert.assertTrue(
            cartPage.VerifyName("Sauce Labs Onesie").getText().contains("Sauce Labs Onesie"),
            "Sauce Labs Onesie tidak ditemukan di cart!"
        );
        Thread.sleep(2000);
        cartPage.VerifyProductInCart("Sauce Labs Backpack", "$7.99", "1");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException{
        System.out.println("this is after method");
        Thread.sleep(4000);
        if(driver != null){
            driver.quit();
        }
    }
}
