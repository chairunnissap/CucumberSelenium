package stepdefenitions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.webautomation.Page_Factory.Object_Repository.LoginObjectRepository;
import com.webautomation.Page_Factory.Page.CartPage;
import com.webautomation.Page_Factory.Page.DashboardPage;
import com.webautomation.Page_Factory.Page.FinishPage;
import com.webautomation.Page_Factory.Page.InformationPage;
import com.webautomation.Page_Factory.Page.LoginPage;
import com.webautomation.Page_Factory.Page.OverviewPage;
import hook.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepImpl {
    WebDriver driver;
    LoginObjectRepository loginPage;

    public StepImpl(Hooks hooks) {
        this.driver = Hooks.GetDriver();
    }

    // @Given("User is on the login page")
    // public void user_is_on_the_login_page(){
    //     this.driver = Hooks.GetDriver();
    // }

    @When("User enter valid {string} and {string}")
    public void User_enter_valid(String usernamevalid, String passwordvalid){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.DoLogin(usernamevalid, passwordvalid);
    }

    @When("User cannot login with {string} and {string}")
    public void User_cannot_login_with(String username,String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.DoLogin(username, password);
        loginPage.ButtonLogin();
    }

    @Then("User should see an error message")
    public void User_should_see_an_error_message() throws InterruptedException{
        // LoginPage loginPage = new LoginPage(driver);
        String invalidText = loginPage.InvalidLogin();
        System.out.println("Error muncul: " + invalidText);
        Assert.assertEquals(invalidText, "Epic sadface: Username and password do not match any user in this service");
        Thread.sleep(2000);
    }

    @Then("User click on the login button")
    public void User_click_on_the_login_button(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.ButtonLogin();
    }

    @When("User add product to the cart {string}")
    public void User_add_product_to_the_cart(String productNama) throws InterruptedException{
        Thread.sleep(4000);
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.AddToCart(productNama,"$7.99");
    }

    @When("User click on the cart icon")
    public void User_click_on_the_cart_icon(){
        CartPage cartPage = new CartPage(driver);
        cartPage.GoToCart();
    }

    @And("User verify the product is added to the cart")
    public void User_verify_the_product_is_added_to_the_cart(){
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
        cartPage.VerifyProductInCart("Sauce Labs Backpack", "$7.99", "1");
    }

    @Then("User click on the checkout button and User fills in the shipping details")
    public void User_click_on_the_checkout_button(){
        InformationPage informationPage = new InformationPage(driver);
        informationPage.DoContinue("Chairun", "Nissa","Puspitasari");
    }

    @When("User overview in the shipping details")
    public void User_fills_in_the_shipping_details() throws InterruptedException {
        OverviewPage overviewPage = new OverviewPage(driver);
        double totalCalculated = overviewPage.getTotalCalculated();
        System.out.println("Total harga dihitung: $" + totalCalculated);

        String pricetotalText = overviewPage.PricetotalText();
        // Contoh: "Item total: $37.98"
        double ItemTotal = Double.parseDouble(pricetotalText.replace("Item total: $", "").trim());
        System.out.println("PriceTotal dari item total: $" + ItemTotal);

        // Overview total harga benar
        Assert.assertEquals(ItemTotal, totalCalculated, "Total Harga tidak sesuai!");
        overviewPage.Finish();
    }

    @Then("User click on the finish button and User verify the order is placed successfully")
    public void User_click_on_the_place_order_button(){
        FinishPage finishPage = new FinishPage(driver);
        String actualMessage = finishPage.Finish();
        Assert.assertEquals(actualMessage, "Thank you for your order!");

        finishPage.BackToProduct();
        System.out.println("this is after method");
        if(driver != null){
            driver.quit();
        }
    }

}
