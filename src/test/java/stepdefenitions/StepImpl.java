package stepdefenitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.webautomation.Page_Factory.Object_Repository.LoginObjectRepository;
import com.webautomation.Page_Factory.Page.CartPage;
import com.webautomation.Page_Factory.Page.DashboardPage;
import com.webautomation.Page_Factory.Page.FinishPage;
import com.webautomation.Page_Factory.Page.InformationPage;
import com.webautomation.Page_Factory.Page.LoginPage;
import com.webautomation.Page_Factory.Page.OverviewPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepImpl {
    WebDriver driver;
    LoginObjectRepository loginPage;

    @Given("User is on the login page")
    public void user_is_on_the_login_page() throws InterruptedException{
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginObjectRepository(driver);
        Thread.sleep(2000);
    }

    @When("User enter valid username and password")
    public void User_enter_valid_username_and_password() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        Thread.sleep(2000);
        loginPage.DoLogin("standard_user", "secret_sauce");
        Thread.sleep(2000);
    }

    @When("User cannot login with {string} and {string}")
    public void User_cannot_login_with(String username,String password) throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        Thread.sleep(2000);
        loginPage.DoLogin(username, password);
        Thread.sleep(2000);
    }

    @Then("User click on the login button")
    public void User_click_on_the_login_button() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        Thread.sleep(2000);
        loginPage.ButtonLogin();
    }

    @When("User add product to the cart")
    public void User_add_product_to_the_cart() throws InterruptedException{
        Thread.sleep(2000);
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.AddToCart("Sauce Labs Backpack","$7.99");
        Thread.sleep(4000);
    }

    @When("User click on the cart icon")
    public void User_click_on_the_cart_icon() throws InterruptedException{
        CartPage cartPage = new CartPage(driver);
        cartPage.GoToCart();
    }

    @And("User verify the product is added to the cart")
    public void User_verify_the_product_is_added_to_the_cart() throws InterruptedException{
        CartPage cartPage = new CartPage(driver);
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
        Thread.sleep(2000);
    }

    @Then("User click on the checkout button and User fills in the shipping details")
    public void User_click_on_the_checkout_button() throws InterruptedException{
        InformationPage informationPage = new InformationPage(driver);
        informationPage.DoContinue("Chairun", "Nissa","Puspitasari");
        Thread.sleep(4000);
    }

    @When("User overview in the shipping details")
    public void User_fills_in_the_shipping_details() throws InterruptedException{
        OverviewPage overviewPage = new OverviewPage(driver);
        Thread.sleep(2000);
        double totalCalculated = overviewPage.getTotalCalculated();
        System.out.println("Total harga dihitung: $" + totalCalculated);

        String pricetotalText = overviewPage.PricetotalText();
        // Contoh: "Item total: $37.98"
        double ItemTotal = Double.parseDouble(pricetotalText.replace("Item total: $", "").trim());
        System.out.println("PriceTotal dari item total: $" + ItemTotal);

        // Overview total harga benar
        Assert.assertEquals(ItemTotal, totalCalculated, "Total Harga tidak sesuai!");
        Thread.sleep(2000);
        overviewPage.Finish();
        Thread.sleep(2000);
    }

    @Then("User click on the finish button and User verify the order is placed successfully")
    public void User_click_on_the_place_order_button() throws InterruptedException{
        FinishPage finishPage = new FinishPage(driver);
        Thread.sleep(2000);
        String actualMessage = finishPage.Finish();
        Assert.assertEquals(actualMessage, "Thank you for your order!");
        Thread.sleep(2000);

        finishPage.BackToProduct();
        System.out.println("this is after method");
        Thread.sleep(4000);
        if(driver != null){
            driver.quit();
        }
    }

}
