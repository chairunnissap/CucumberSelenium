package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.webautomation.Page_Factory.Object_Repository.LoginObjectRepository;
import com.webautomation.Page_Factory.Page.LoginPage;

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
        loginPage.DoLogin("standard_user", "secret_sauce");
        Thread.sleep(2000);
    }

    @And("User click on the login button")
    public void User_click_on_the_login_button(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.ButtonLogin();
    }

    @Then("User is navigated to the product page")
    public void User_is_navigated_to_the_product_page(){
        throw new io.cucumber.java.PendingException();
    }

    @When("User add product to the cart")
    public void User_add_product_to_the_cart(){
        throw new io.cucumber.java.PendingException();
    }

    @And("User click on the cart icon")
    public void User_click_on_the_cart_icon(){
        throw new io.cucumber.java.PendingException();
    }

    @Then("User verify the product is added to the cart")
    public void User_verify_the_product_is_added_to_the_cart(){
        throw new io.cucumber.java.PendingException();
    }

    @When("User click on the checkout button")
    public void User_click_on_the_checkout_button(){
        throw new io.cucumber.java.PendingException();
    }

    @Then("User is navigated to the checkout page")
    public void User_is_navigated_to_the_checkout_page(){
        throw new io.cucumber.java.PendingException();
    }

    @When("User fills in the shipping details")
    public void User_fills_in_the_shipping_details(){
        throw new io.cucumber.java.PendingException();
    }

    @And("User click on the place order button")
    public void User_click_on_the_place_order_button(){
        throw new io.cucumber.java.PendingException();
    }

}
