package com.webautomation.Page_Factory.Object_Repository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginObjectRepository {

    @FindBy(id = "user-name")
    public WebElement UserName;

    @FindBy(id = "password")
    public WebElement Password;

    @FindBy(css = ".submit-button.btn_action")
    public WebElement LoginButton;

    public LoginObjectRepository(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
