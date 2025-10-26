package com.webautomation.Page_Factory.Object_Repository;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginObjectRepository {
    private WebDriver driver;

    @FindBy(id = "user-name")
    public WebElement UserName;

    @FindBy(id = "password")
    public WebElement Password;

    @FindBy(css = ".submit-button.btn_action")
    public WebElement LoginButton;

    public By InvalidLogin = By.cssSelector("h3[data-test='error']");
    public By UserName2 = By.id("user-name");
    public By Password2 = By.id("password");

    public LoginObjectRepository(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String InvalidLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(InvalidLogin));
        return error.getText();
        // return driver.findElement(loginObjectRepository.InvalidLogin).getText();
    }
}
